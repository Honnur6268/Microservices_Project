package in.nk.tech.cc.restcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeclomeRestController {

	@Value("${msg}")
	private String msg;
	
	@GetMapping("/get")
	public String getMsg() {
		return msg;
	}
}
