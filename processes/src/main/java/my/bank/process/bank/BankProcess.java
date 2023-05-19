package my.bank.process.bank;

public class BankProcess {

	public static final String PROCESS_NAME ="PROCESS_CREATE_ACCOUNT_BANK";
	public static final String PROCESS_KEY = "PROCESS_CREATE_ACCOUNT_BANK_ID";
	
	public static final String START_EVENT = "START_EVENT_BANK_ID";
	
	public static final String LOG_DATA_BANK_TASK = "LOG_DATA_BANK_TOPIC";
	public static final String CREATE_ACCOUNT_TASK = "CREATE_ACCOUNT_TOPIC";
	public static final String SEND_INFO_TASK = "BANK_SEND_INFO_TOPIC";
	public static final String CANCEL_CREATION_TASK = "CANCEL_CREATION_TOPIC";

	public static final String BANK_START_MESSAGE = "BANK_START_MESSAGE";
	
	public static final String BANK_START_VAR_CLIENT_1 = "client1";
	public static final String BANK_START_VAR_CLIENT_2 = "client2";


	BankProcess() {
	}

	

}
