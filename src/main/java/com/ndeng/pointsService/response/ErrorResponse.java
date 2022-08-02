package com.ndeng.pointsService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

/**
 * Response when exception happens.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private final Instant instant = Instant.now();
    private int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    private String error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    private String message;
    private String path;

    public ErrorResponse(String message, String path) {
        this.message = message;
        this.path = path;
    }

    public ErrorResponse(String message, String path, HttpStatus httpStatus) {
        this.message = message;
        this.path = path;
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
    }
}
