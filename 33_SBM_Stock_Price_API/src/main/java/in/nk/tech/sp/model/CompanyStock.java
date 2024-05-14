package in.nk.tech.sp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Company_Stock")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CompanyStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String companyName;

	private Double stockPrice;

	public CompanyStock(String companyName, Double stockPrice) {
		super();
		this.companyName = companyName;
		this.stockPrice = stockPrice;
	}

}
