package in.nk.tech.sp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.nk.tech.sp.exception.CompanyStockNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CompanyStockNotFoundException.class)
	public String handleUserNotFoundException(CompanyStockNotFoundException ex) {
		return ex.getMessage();
	}
}
