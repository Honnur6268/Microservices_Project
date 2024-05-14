package in.nk.tech.spc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CompanyTotalStockResponse {

	private String companyName;

	private Double currentStockPrice;

	private Integer quantity;

	private Double totalStockPrice;

}
