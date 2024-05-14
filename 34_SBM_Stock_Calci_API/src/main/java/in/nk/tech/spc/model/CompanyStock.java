package in.nk.tech.spc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CompanyStock {

	private Integer id;

	private String companyName;

	private Double stockPrice;

}