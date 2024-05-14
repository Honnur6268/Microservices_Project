package in.nk.tech.sp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nk.tech.sp.exception.CompanyStockNotFoundException;
import in.nk.tech.sp.model.CompanyStock;
import in.nk.tech.sp.repository.CompanyStockRepository;
import in.nk.tech.sp.service.CompanyStockService;

@Service
public class CompanyStockServiceImpl implements CompanyStockService {

	@Autowired
	private CompanyStockRepository stockRepository;

	@Override
	public List<CompanyStock> saveAllStocks(List<CompanyStock> stocks) {

		return stockRepository.saveAll(stocks);
	}

	@Override
	public CompanyStock findByCompanyName(String CompanyName) {
		CompanyStock stock = stockRepository.findByCompanyName(CompanyName);
		if (null != stock) {

			return stock;
		}
		throw new CompanyStockNotFoundException("Company Not Found: " + CompanyName);
	}

	@Override
	public List<CompanyStock> getAllStockDetails() {
		
		return stockRepository.findAll();
	}

}
