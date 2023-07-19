# Thoughtspot Assessment

This repository contains a Spring Boot application that provides REST services to manage views. It allows users to create, list, fetch, update, and delete views.

  

## Endpoints:

  

### a. Create View: POST /view

  

Create a new view with the provided data.

  

- Request body:

```json

{

"name": "...",

"chartType": "column",

"country": "IN",

"indicator": "1.0.HCount.1.90usd",

"startDate": "...",

"endDate": "..."

}

```

  

- Response:

- HTTP 201 (Created) when successful.

- HTTP 4XX (Bad Request) if the request data is invalid.

- HTTP 5XX (Server Error) if there is an internal server error.

  

### b. List all Views: GET /view

  

Get a list of all views available in the system.

  

- Response:

- HTTP 200 (OK) when successful.

- HTTP 5XX (Server Error) if there is an internal server error.

  

### c. Fetch a View by ID: GET /view/<viewId>

  

Fetch a specific view by its ID.

  

- Response:

- HTTP 200 (OK) when successful.

- HTTP 4XX (Bad Request) if the view ID is invalid.

- HTTP 5XX (Server Error) if there is an internal server error.

  

### d. Delete a View: DELETE /view/<viewId>

  

Delete a view with the specified ID.

  

- Response:

- HTTP 200 (OK) when successful.

- HTTP 4XX (Bad Request) if the view ID is invalid.

- HTTP 5XX (Server Error) if there is an internal server error.

  

### e. Update a View: PUT /view/<viewId>

  

Update an existing view with the provided data.

  

- Request body:

```json

{

"viewId": "v111",

"name": "...",

"chartType": "column",

"country": "IN",

"indicator": "1.0.HCount.1.90usd",

"startDate": "...",

"endDate": "..."

}

```

  

- Response:

- HTTP 200 (OK) when successful.

- HTTP 4XX (Bad Request) if the view ID or request data is invalid.

- HTTP 5XX (Server Error) if there is an internal server error.

  

## Running the Application:

  

1. Clone this repository to your local machine.

2. Ensure you have Java (JDK 8 or higher) and Maven installed.

3. Open a terminal and navigate to the project directory.

4. Run `mvn spring-boot:run` to start the application.

5. The application will be accessible at `http://localhost:7000
