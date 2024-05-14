package in.nk.tech.cbr4j.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.nk.tech.cbr4j.model.Activity;
import in.nk.tech.cbr4j.model.PokemonDetails;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class AppRestController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/external/bored")
	@CircuitBreaker(name = "boredApiFallBack", fallbackMethod = "boredFallBackMethod")
	public String invovkeBoredThirdPartyApi() {
		String url = "https://www.boredapi.com/api/activity/";
		ResponseEntity<Activity> forEntity = restTemplate.getForEntity(url, Activity.class);
		Activity body = forEntity.getBody();

		return body.getActivity();
	}

	public String boredFallBackMethod(Throwable t) {
		return "<h1>Bored Service Down. Please Try again later!!!</h1>";
	}

	@GetMapping("/external/pokemon")
	@CircuitBreaker(name = "pokemonApiFallBack", fallbackMethod = "pokemonFallBackMethod")
	public ResponseEntity<PokemonDetails> invovkePokemonThirdPartyApi() throws Exception {
		String url = "https://pokeapi.co/api/v2/pokemon/";
		ResponseEntity<PokemonDetails> forEntity = restTemplate.getForEntity(url, PokemonDetails.class);
		PokemonDetails body = forEntity.getBody();		

		return ResponseEntity.ok(body);

	}

	public ResponseEntity<?> pokemonFallBackMethod(Exception e) {		
		return new ResponseEntity<String>("<h1>Pokemon Service Unavailable. Please Try again later!!!</h1>", HttpStatus.SERVICE_UNAVAILABLE);
	}
}
