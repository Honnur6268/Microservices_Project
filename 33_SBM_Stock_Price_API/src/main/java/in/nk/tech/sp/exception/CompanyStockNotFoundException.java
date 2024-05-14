package in.nk.tech.sp.exception;

public class CompanyStockNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyStockNotFoundException(String message) {
		super(message);
	}
}
