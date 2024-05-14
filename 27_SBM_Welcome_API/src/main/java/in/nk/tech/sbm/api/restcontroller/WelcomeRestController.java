package in.nk.tech.sbm.api.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@Autowired
	private Environment env;

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String port = env.getProperty("server.port");
		String msg = "Hi, Welcome ... Server Port ==> " + port;
		return msg;
	}
}
