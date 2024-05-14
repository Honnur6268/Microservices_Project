package in.nk.tech.spc.service;

import in.nk.tech.spc.model.CompanyStock;

public interface CompanyStockCalciService {

	public CompanyStock getStockDetailsByCompanyName(String companyName);
}
