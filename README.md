# Statistic API

This API provides statistics related to players.

## Endpoints

### Get Country with Highest Winning Ratio

- URL: `/statistic/ratio`
- Method: `GET`
- Description: Retrieves the country with the highest winning ratio among players.
- Success Response:
  - Status Code: 200 (OK)
  - Body: Country with the highest winning ratio (String)
- Error Response:
  - Status Code: 500 (Internal Server Error)
  - Body: "Failed to retrieve winning ratio statistics" (String)

### Get Average IMC

- URL: `/statistic/imc`
- Method: `GET`
- Description: Retrieves the average IMC (Body Mass Index) of players.
- Success Response:
  - Status Code: 200 (OK)
  - Body: Average IMC (Double)
- Error Response:
  - Status Code: 500 (Internal Server Error)
  - Body: `null`

### Get Median Height

- URL: `/statistic/median`
- Method: `GET`
- Description: Retrieves the median height of players.
- Success Response:
  - Status Code: 200 (OK)
  - Body: Median height (Integer)
- Error Response:
  - Status Code: 500 (Internal Server Error)
  - Body: `null`

## Setup and Configuration

Make sure you have the following requirements installed and configured:

- Java Development Kit (JDK) version 1.8
- Maven 3.X.
- Database: H2

## Build and Run

1. Clone the repository:

```bash
git clone  https://github.com/ChrislainGba/PlayersStatistics.git
