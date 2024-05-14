package in.nk.tech.spc.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.nk.tech.spc.model.CompanyStock;

@FeignClient(name = "STOCK-PRICE-API")
public interface CompanyStockExternalService {

	@GetMapping("/api/stock/{companyName}")
	public ResponseEntity<CompanyStock> getStockDetailsByCompanyName(@PathVariable String companyName);
}
