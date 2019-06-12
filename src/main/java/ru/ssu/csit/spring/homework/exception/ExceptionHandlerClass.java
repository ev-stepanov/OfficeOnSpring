package ru.ssu.csit.spring.homework.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ssu.csit.spring.homework.view.ErrorResponseView;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(value = ValidationException.class)
    public ErrorResponseView dataValidationException(Exception e) {
        return new ErrorResponseView("Invalid input.");
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ErrorResponseView dataSearchException (Exception e) {
        return new ErrorResponseView(e.getMessage());
    }

    @ExceptionHandler(NotCompletedException.class)
    public ErrorResponseView commandNotExecutedException (Exception e) {
        return new ErrorResponseView("Command not executed. " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponseView exceptionHandler(Exception e){
        return new ErrorResponseView("Error. Something went wrong.");
    }
}
