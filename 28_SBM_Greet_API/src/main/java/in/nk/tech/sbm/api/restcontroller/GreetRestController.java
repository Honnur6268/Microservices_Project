package in.nk.tech.sbm.api.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nk.tech.sbm.api.cleint.WelcomeApiClient;

@RestController
public class GreetRestController {

	@Autowired
	private WelcomeApiClient apiClient;
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		String msg = "Good Morning...";
		String welcomeResponse = apiClient.invokeWelcomeAPi();
		
		return welcomeResponse +" , "+msg;
	}
}
