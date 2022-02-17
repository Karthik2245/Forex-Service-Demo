# Forex-Service-Demo

## Description

Prototype of a REST based microservice with the following functions.
* Get daily exchange rate between a pair of currencies in question.
* Exchange rates for a given time range.

Uses data from <http://exchangeratesapi.io> with a scheduled task. Scheduling is configured at `application.properties`
It supports H2 as the in-memory database.
Keywords: Spring Boot, Feign Client, Maven 

## Usage

Run microservice

```
mvn spring-boot:run
```


## API 

### Get Current Exchange Rate

```http
GET /api/currExchangeRates/latest
```

```json
{
  "date": "2021-01-18",
  "from": "USD",
  "to": "EUR",
  "rate": 0.8795
}
```
### List Exchange Rates in Date Interval

```http
GET /api/currExchangeRateSeries?startDate={START_DATE}&endDate={END_DATE}
```

```json
{
  "created": "2021-01-14",
  "from": "USD",
  "to": "EUR",
  "fromDate": "2021-01-14",
  "toDate": "2021-01-17",
  "rates": [
    { "date": "2021-01-14", "rate": 0.8738},
    { "date": "2021-01-15", "rate": 0.8759},
    { "date": "2021-01-16", "rate": 0.8759},
    { "date": "2021-01-17", "rate": 0.8763},
  ]
} 
```
