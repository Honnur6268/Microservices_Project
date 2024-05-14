package in.nk.tech.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nk.tech.sp.model.CompanyStock;

public interface CompanyStockRepository extends JpaRepository<CompanyStock, Integer> {
	CompanyStock findByCompanyName(String companyName);
}
