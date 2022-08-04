# Points Microservice
## Services Overview
* Customer: customer profiles with Name (as ID) and total points. Contact information and preferences can be added potentially. 
* Transaction: records for every transaction with customer, payer, points and timestamp.
* Balance: records for points for each pair of customer and payer. 
* Spend: records for customers spending points.
* Payer (the implementation is not completed).
## Deployments
The service is deployed on Heroku. The host address is https://points-microservice.herokuapp.com
## Running on local machine

## Routes
### Health Check Point

Check whether the service is available. 

Route: GET /

Example: 
```
curl --location --request GET 'https://points-microservice.herokuapp.com/'
```
### Customer
Create a customer

Route: POST /customers

Example: 
```
curl --location --request POST 'https://points-microservice.herokuapp.com/customers' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customer": "Ning"
}'
```
### Balance
Get balance details of a customer

Route: GET /balance

Example:
```
curl --location --request GET 'https://points-microservice.herokuapp.com/balance' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customer": "Ning"
}'
```
### Transaction
Create a transaction

Route: POST /transactions

Example:
```
curl --location --request POST 'https://points-microservice.herokuapp.com/transactions' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customer": "Ning",
    "payer": "DANNON",
    "points": 1000,
    "timestamp": "2020-11-02T14:00:00Z"
}'
```
### Spend
Create a spend (or redemption of points) for a customer

Route: POST /spend

Example:
```
curl --location --request POST 'https://points-microservice.herokuapp.com/spend' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customer": "Ning",
    "points": 5000
}'
```
