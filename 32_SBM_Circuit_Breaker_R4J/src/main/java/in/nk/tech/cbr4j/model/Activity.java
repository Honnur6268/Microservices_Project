package in.nk.tech.cbr4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

	private String activity;
	private String type;
	private Integer participants;
	private Double price;
	private String link;
	private String key;
	private Double accessibility;
}
