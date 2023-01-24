package game.play.eGround.globalExceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import game.play.eGround.errorResponse.ErrorResponse;
import game.play.eGround.exceptions.AlreadyExistsException;
import game.play.eGround.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalException {

	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex){
		
		ex.printStackTrace();
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());
		ErrorResponse error = new ErrorResponse("User does not exists", details);
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
public ResponseEntity<Object> handleAlreadyExistsException(AlreadyExistsException ex){
		
		ex.printStackTrace();
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());
		ErrorResponse error = new ErrorResponse("User already exists", details);
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
	
}
