package my.bank.process.bank.tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import my.bank.process.bank.BankProcess;
import my.bank.process.bank.data.ComplexData;


@Log
@Component
@ExternalTaskSubscription(BankProcess.CANCEL_CREATION_TASK)
public class CancelCreationTask implements ExternalTaskHandler {

	@Override
	public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

		try {

			Map<String, Object> vars = externalTask.getAllVariables();
			
			String risk = (String) vars.get("risk");

			log.info("TOO MUCH RISK. CANCELING CREATION. The risk is "+risk);
			
			externalTaskService.complete(externalTask);

		} catch (Exception ex) {
			log.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}

}
