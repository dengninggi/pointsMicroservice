package com.ndeng.pointsService.utility;

import com.ndeng.pointsService.exception.PointsException;
import com.ndeng.pointsService.request.SpendRequest;
import com.ndeng.pointsService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class Validator {
    @Autowired
    private CustomerService customerService;
    public static void validateSpendRequest(SpendRequest request) throws PointsException {
        if (request.getPoints() < 0) {
            throw new PointsException(HttpStatus.BAD_REQUEST, ErrorMessage.NEGATIVE_SPEND);
        }
    }
}
