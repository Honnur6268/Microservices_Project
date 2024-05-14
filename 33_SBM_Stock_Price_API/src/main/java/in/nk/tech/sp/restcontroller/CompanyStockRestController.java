package in.nk.tech.sp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nk.tech.sp.model.CompanyStock;
import in.nk.tech.sp.service.CompanyStockService;

@RestController
@RequestMapping("/api/stock")
public class CompanyStockRestController {

	@Autowired
	private CompanyStockService stockService;

	@PostMapping
	public ResponseEntity<List<CompanyStock>> saveAllCompanyStocks(@RequestBody List<CompanyStock> stocks) {

		List<CompanyStock> savedstocks = stockService.saveAllStocks(stocks);
		if (!savedstocks.isEmpty()) {
			return ResponseEntity.ok(savedstocks);
		}
		return new ResponseEntity<List<CompanyStock>>(savedstocks, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{companyName}")
	public ResponseEntity<CompanyStock> getStockDetailsByCompanyName(@PathVariable String companyName) {
		CompanyStock stock = stockService.findByCompanyName(companyName);

		return ResponseEntity.ok(stock);
	}
	
	@GetMapping("/fetch-all")
	public ResponseEntity<List<CompanyStock>> getAllStockDetails(){
		List<CompanyStock> allStockDetails = stockService.getAllStockDetails();
		return ResponseEntity.ok(allStockDetails);
	}
}
