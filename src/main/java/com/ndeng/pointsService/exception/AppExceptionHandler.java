package com.ndeng.pointsService.exception;

import com.ndeng.pointsService.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Exception handler for generating error responses once exceptions happen
 */
@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {PointsException.class})
    public ResponseEntity<Object> handleBadRequestException(PointsException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                e.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath(),
                e.getStatus()
        );

        return new ResponseEntity<>(response, new HttpHeaders(), response.getStatus());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOwnershipException(Exception e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                e.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return new ResponseEntity<>(response, new HttpHeaders(), response.getStatus());
    }
}
