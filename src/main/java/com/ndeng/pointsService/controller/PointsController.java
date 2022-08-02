package com.ndeng.pointsService.controller;

import com.ndeng.pointsService.dto.TransactionDto;
import com.ndeng.pointsService.exception.PointsException;
import com.ndeng.pointsService.request.CustomerRequest;
import com.ndeng.pointsService.request.SpendRequest;
import com.ndeng.pointsService.request.TransactionRequest;
import com.ndeng.pointsService.response.BalanceResponse;
import com.ndeng.pointsService.response.CustomerResponse;
import com.ndeng.pointsService.response.SpendResponse;
import com.ndeng.pointsService.service.BalanceService;
import com.ndeng.pointsService.service.CustomerService;
import com.ndeng.pointsService.service.SpendService;
import com.ndeng.pointsService.service.TransactionService;
import com.ndeng.pointsService.utility.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class PointsController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SpendService spendService;

    /**
     * Health check point
     * @return a welcome message
     */
    @GetMapping
    public String greeting() {
        return "Welcome to Points service!";
    }

    /**
     * Request to create a new customer
     * @param request the request containing customer's name
     * @return the new customer's name and the initial number of points
     */
    @PostMapping(path = "customers")
    public @ResponseBody CustomerResponse createCustomer(@RequestBody CustomerRequest request) {
        return customerService.createCustomer(request.getCustomer());
    }

    /**
     * Request to get a customer's balance
     * @param request the request containing the customer's name
     * @return the customer's balance details
     * @throws PointsException any possible exception
     */
    @GetMapping(path = "balance")
    public @ResponseBody BalanceResponse balance(@RequestBody CustomerRequest request)
            throws PointsException {
        return balanceService.getBalance(request.getCustomer());
    }

    /**
     * Request to post a transaction
     * @param request the request containing the transaction's details
     * @return the customer's balance details
     * @throws PointsException any possible exception
     */
    @PostMapping(path = "transactions")
    public @ResponseBody BalanceResponse postTransaction(@RequestBody TransactionRequest request)
            throws PointsException {
        TransactionDto transactionDto = new TransactionDto(request);
        customerService.updateCustomer(transactionDto);
        // payerService.updatePayer
        transactionService.saveTransaction(transactionDto);
        BalanceResponse response =  balanceService.updateBalance(transactionDto);
        return response;
    }

    /**
     * Request to spend points
     * @param request the request containing details of spending
     * @return the number of points spent and corresponding payers
     * @throws PointsException any possible exception
     */
    @PostMapping(path = "spend")
    public @ResponseBody SpendResponse spend(@RequestBody SpendRequest request)
            throws PointsException {
        Validator.validateSpendRequest(request);
        customerService.updateCustomer(request);
        // payerService.updatePayer
        spendService.saveSpend(request);
        SpendResponse response =  balanceService.updateBalance(request);
        return response;
    }
}
