package in.nk.tech.sp.service;

import java.util.List;

import in.nk.tech.sp.model.CompanyStock;

public interface CompanyStockService {

	List<CompanyStock> saveAllStocks(List<CompanyStock> stocks);

	CompanyStock findByCompanyName(String CompanyName);
	
	List<CompanyStock> getAllStockDetails();
}
