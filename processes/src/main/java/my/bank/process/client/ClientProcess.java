package my.bank.process.client;

import lombok.Getter;
import lombok.Setter;
import my.bank.process.bank.data.ComplexData;

public class ClientProcess {

	public static final String PROCESS_NAME ="PROCESS_CREATE_ACCOUNT_CLIENT";
	public static final String PROCESS_KEY = "PROCESS_CREATE_ACCOUNT_CLIENT_ID";
	
	public static final String START_EVENT = "START_EVENT_ID";

	public static final String WRITE_LOG_INFO_TASK = "WRITE_LOG_INFO_TASK_TOPIC";
	public static final String SEND_INFO_TASK = "SEND_INFO_TOPIC";
	public static final String CLOSE_BY_INACTIVITY_TASK = "CLOSE_BY_INACTIVITY_TOPIC";

	public static final String VAR_CLIENT_NAME_1 = "VAR_CLIENT_NAME_1";
	public static final String VAR_CLIENT_AGE_1 = "VAR_CLIENT_AGE_1";
	public static final String VAR_CLIENT_EMAIL_1 = "VAR_CLIENT_EMAIL_1";
	
	public static final String VAR_CLIENT_NAME_2 = "VAR_CLIENT_NAME_2";
	public static final String VAR_CLIENT_AGE_2 = "VAR_CLIENT_AGE_2";
	public static final String VAR_CLIENT_EMAIL_2 = "VAR_CLIENT_EMAIL_2";
	
	public static final String BANK_START_MESSAGE_CLIENT_1 = "BANK_START_MESSAGE_CLIENT1";
	public static final String BANK_START_MESSAGE_CLIENT_2 = "BANK_START_MESSAGE_CLIENT2";


	ClientProcess() {
	}

	@Getter
	@Setter
	public class ProcessWierdVariables {

		private String var1;
		private String var2;
		private boolean exists;
		private ComplexData datum;

	}

}
