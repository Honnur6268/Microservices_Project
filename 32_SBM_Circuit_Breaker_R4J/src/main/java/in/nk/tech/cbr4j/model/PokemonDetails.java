package in.nk.tech.cbr4j.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDetails {
	private Integer count;
	private String next;
	private String previous;
	private Set<Pokemon> results;
//	private String status;

}
