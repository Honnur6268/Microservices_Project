package in.nk.tech.spc.exception;

public class CompanyStockNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyStockNotFoundException(String msg) {
		super(msg);
	}
}
