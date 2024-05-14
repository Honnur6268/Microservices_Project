package in.nk.tech.spc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.nk.tech.spc.model.CompanyStock;
import in.nk.tech.spc.service.CompanyStockCalciService;
import in.nk.tech.spc.service.external.CompanyStockExternalService;

@Service
public class CompanyStockCalciServiceImpl implements CompanyStockCalciService {

	@Autowired
	private CompanyStockExternalService stockExternalService;

	@Override
	public CompanyStock getStockDetailsByCompanyName(String companyName) {
		ResponseEntity<CompanyStock> stockDetails = stockExternalService.getStockDetailsByCompanyName(companyName);

		return stockDetails.getBody();
	}
}
