package in.nk.tech.spc.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;
import in.nk.tech.spc.exception.CompanyStockNotFoundException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(FeignException.NotFound.class)
	public Map<String, String> handleFeignNotFoundException(FeignException.NotFound ex) {
		Map<String, String> companyNotFound = new HashMap<>();

		companyNotFound.put("errorMessage", ex.contentUTF8());

		return companyNotFound;
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(FeignException.class)
	public Map<String, String> handleFeignException(FeignException ex) {
		Map<String, String> notfound = new HashMap<>();
		notfound.put("errorMessage", ex.contentUTF8());

		return notfound;
	}

	@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
	@ExceptionHandler(CallNotPermittedException.class)
	public String handleCallNotPermittedException(CallNotPermittedException ex) {

		String msg = "Service Down!!!, Try again Later....";
		return msg;
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CompanyStockNotFoundException.class)
	public Map<String, String> handleCompanyNotFoundException(CompanyStockNotFoundException ex) {
		Map<String, String> notfound = new HashMap<>();
		notfound.put("errorMessage", ex.getMessage());

		return notfound;
	}

}
