package my.bank.process.client.tasks;

import java.util.Map;
import java.util.logging.Level;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import my.bank.process.client.ClientProcess;

@Log
@Component
@ExternalTaskSubscription(ClientProcess.WRITE_LOG_INFO_TASK)
public class WriteLogInfoTask implements ExternalTaskHandler {

	@Override
	public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

		try {

			Map<String, Object> vars = externalTask.getAllVariables();
			
			this.readVars(vars);

			externalTaskService.complete(externalTask);

		} catch (Exception ex) {
			log.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}
	
	private void readVars(Map<String, Object> vars) {
		
		String clientName1 = (String) vars.get(ClientProcess.VAR_CLIENT_NAME_1);
		Long clientAge1 = (Long) vars.get(ClientProcess.VAR_CLIENT_AGE_1);
		String clientEmail1 = (String) vars.get(ClientProcess.VAR_CLIENT_EMAIL_1);

		log.info("CLIENT_NAME_1: " + clientName1);
		log.info("CLIENT_EMAIL_1: " + clientEmail1);
		log.info("CLIENT_AGE_1: " + clientAge1);
		
		
		String clientName2 = (String) vars.get(ClientProcess.VAR_CLIENT_NAME_2);
		Long clientAge2 = (Long) vars.get(ClientProcess.VAR_CLIENT_AGE_2);
		String clientEmail2 = (String) vars.get(ClientProcess.VAR_CLIENT_EMAIL_2);

		log.info("CLIENT_NAME_2: " + clientName2);
		log.info("CLIENT_EMAIL_2: " + clientEmail2);
		log.info("CLIENT_AGE_2: " + clientAge2);
	}

}
