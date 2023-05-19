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


@Log
@Component
@ExternalTaskSubscription(BankProcess.LOG_DATA_BANK_TASK)
public class LogDataBankTask implements ExternalTaskHandler {

	@Override
	public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

		try {

			Map<String, Object> vars = externalTask.getAllVariables();
			
			LinkedHashMap client1 = (LinkedHashMap) vars.get(BankProcess.BANK_START_VAR_CLIENT_1);
			LinkedHashMap client2 = (LinkedHashMap) vars.get(BankProcess.BANK_START_VAR_CLIENT_2);

			log.info("CLIENT_1: " + client1.toString());
			log.info("CLIENT_2: " + client2.toString());
			
			externalTaskService.complete(externalTask);

		} catch (Exception ex) {
			log.log(Level.SEVERE, ex.getMessage(), ex);
		}

	}

}
