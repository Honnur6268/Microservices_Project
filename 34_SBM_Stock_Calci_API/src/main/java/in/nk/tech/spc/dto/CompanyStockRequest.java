package in.nk.tech.spc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class CompanyStockRequest {

	private String companyName;

	private Integer quantity;

}
