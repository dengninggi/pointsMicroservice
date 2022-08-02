package com.ndeng.pointsService.exception;

import com.ndeng.pointsService.utility.ErrorMessage;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Exception with http status and pre-defined error messages as enums.
 */
@Data
public class PointsException extends Exception{
    private HttpStatus status;
    private ErrorMessage errorMessage;
    public PointsException(HttpStatus status, ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
