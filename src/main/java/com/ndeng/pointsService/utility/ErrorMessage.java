package com.ndeng.pointsService.utility;

/**
 * Pre-defined error messages.
 */
public enum ErrorMessage {
    POINTS_INEFFICIENCY("The customer's points balance is inefficient."),
    CUSTOMER_NOT_EXIST("The customer does not exist."),
    NEGATIVE_SPEND("The number of points to be spent should not be negative.");

    private String message;
    ErrorMessage(String s) {
        this.message = s;
    }

    public String getMessage(){
        return this.message;
    }
}
