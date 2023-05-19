package my.bank.process.bank.tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.MessageApi;
import org.openapitools.client.model.CorrelationMessageDto;
import org.openapitools.client.model.MessageCorrelationResultWithVariableDto;
import org.openapitools.client.model.VariableValueDto;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import my.bank.process.bank.BankProcess;


@Log
@Component
@ExternalTaskSubscription(BankProcess.SEND_INFO_TASK)
public class BankSendInfoTask implements ExternalTaskHandler {
	
	private static String camundaBaseUri = "http://localhost:8080/engine-rest";

	@Override
	public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

		try {

			Map<String, Object> vars = externalTask.getAllVariables();
			
			
			String clientProcessInstanceId = (String) vars.get("client_process_instance_id");
			String risk = (String) vars.get("risk");

			log.info("SEND INFO TO PROCESS CLIENT: " + clientProcessInstanceId);
			
			

			Map<String, VariableValueDto> variables = new HashMap();

			
			
			String bankProcessInstanceId = externalTask.getProcessDefinitionId();
			VariableValueDto vProcessBankId = new VariableValueDto();
			vProcessBankId.setType("String");
			vProcessBankId.setValue(bankProcessInstanceId);
			variables.put("bank_process_instance_id", vProcessBankId);
			
			VariableValueDto vRisk = new VariableValueDto();
			vRisk.setType("String");
			vRisk.setValue(risk);
			variables.put("risk", vRisk);

			this.sendMessageToClient(clientProcessInstanceId, variables);
			
			externalTaskService.complete(externalTask);

		} catch (Exception ex) {
			log.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}
	
	private void sendMessageToClient(String clientProcessInstanceId, Map<String, VariableValueDto> variables) {
		
		CorrelationMessageDto msgDto = new CorrelationMessageDto();
		msgDto.setVariablesInResultEnabled(true);
		msgDto.resultEnabled(true);
		msgDto.setProcessInstanceId(clientProcessInstanceId);
		msgDto.setProcessVariables(variables);
		msgDto.setMessageName("CLIENT_CREATE_ACCOUNT");

		ApiClient ac = new ApiClient().setBasePath(camundaBaseUri);
		MessageApi apiMessage = new MessageApi(ac);
		
		try {
			List<MessageCorrelationResultWithVariableDto> result = apiMessage.deliverMessage(msgDto);
			log.info(result.toString());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
	}

}
