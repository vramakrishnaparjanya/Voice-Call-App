package com.voicecallapp.springbootcallenabledapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;

@SpringBootApplication
public class SpringBootCallEnabledAppApplication implements ApplicationRunner {

	// Twilio Account SID
	private final static String ACCOUNT_SID = "ACCOUNT_SID";

	// Twilio Auth ID for Calling
	private final static String AUTH_ID = "AUTH_ID";

	//Enter from number with Country Code like +91 or +1
	private final static String FROM_NUMBER="FROM_NUMBER";

	//Enter to number with Country Code like +91 or +1
	private final static String TO_NUMBER ="TO_NUMBER";

	static {
		// Initialising Twilio account
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCallEnabledAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(
				new PhoneNumber(TO_NUMBER),
				new PhoneNumber(FROM_NUMBER),
				new URI("https://demo.twilio.com/welcome/voice/")
		).create();
	}

}
