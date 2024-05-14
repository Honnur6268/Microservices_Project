package in.nk.tech.spc.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feign.FeignException.ServiceUnavailable;
import in.nk.tech.spc.dto.CompanyStockRequest;
import in.nk.tech.spc.dto.CompanyTotalStockResponse;
import in.nk.tech.spc.model.CompanyStock;
import in.nk.tech.spc.service.CompanyStockCalciService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/stock")
public class StockCalciRestController {

	@Autowired
	private CompanyStockCalciService stockCalciService;

	@PostMapping("/calci")
	@CircuitBreaker(name = "calculateStockPriceCB", fallbackMethod = "calculateStockPriceFallback")
	public ResponseEntity<CompanyTotalStockResponse> calculateStockPrice(@RequestBody CompanyStockRequest request) {

		CompanyStock stockByCompany = stockCalciService.getStockDetailsByCompanyName(request.getCompanyName());

		Double currentStockPrice = stockByCompany.getStockPrice();

		Double totalStockPrice = (currentStockPrice * (double) request.getQuantity());
		CompanyTotalStockResponse response = CompanyTotalStockResponse.build(request.getCompanyName(),
				currentStockPrice, request.getQuantity(), totalStockPrice);

		return ResponseEntity.ok(response);

	}

	// Fallback method for calculateStockPrice, in-case of STOCK-PRICE-API service
	// down
	public ResponseEntity<?> calculateStockPriceFallback(CompanyStockRequest request, ServiceUnavailable t) {
		return new ResponseEntity<String>("Service Unavailable. Please Try again later!!!",
				HttpStatus.SERVICE_UNAVAILABLE);
	}

	@GetMapping("/other")
	public ResponseEntity<String> otherServices() {
		return ResponseEntity.ok("Other Services Are Running!!!!!");
	}
}
