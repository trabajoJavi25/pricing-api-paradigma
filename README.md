# Price Service API

This project implements a REST API to query product pricing information based on product ID, brand ID, and application
date.

---

## 📝 Design Decisions

✅ API First approach using OpenAPI Generator for interfaces and DTO  
✅ Generated code stored under `src/generated/java` to avoid regeneration at build time  
✅ `build-helper-maven-plugin` configured to add generated sources to Maven build path  
✅ MapStruct used for mapping between domain and DTO, with explicit `@Mapping(expression = "...")` for DTO
✅ **The project follows Hexagonal Architecture (Ports and Adapters):**

- `application.port` defines input/output ports
- `application.usecase` implements business logic
- `infrastructure.in` contains adapters/controllers (REST)
- `infrastructure.out` contains adapters/repositories (database access)  
  ✅ Dockerized using multi-stage build for optimized image size
  ✅ Static OpenAPI-generated code ensures reproducibility

---

## 🏁 Project Structure

```
src/main/java
├── com.jrosroig.priceservice
│   ├── application
│   │   ├── port
│   │   ├── usecase
│   │   └── service
│   ├── domain
│   ├── infrastructure
│   │   ├── in
│   │   └── out
│   └── generated (OpenAPI generated interfaces and DTOs)
```

---

## 🗄️ API Contract

The API was designed using an **API First** approach with OpenAPI 3.0.3.  
The OpenAPI contract file is located at:

`src/main/resources/openapi/openapi.yml`

API interfaces and DTOs were generated using **OpenAPI Generator CLI** and stored under:

`src/generated/java`

Maven is configured with `build-helper-maven-plugin` to include this folder as a source directory.

---

## 📐 Overview

The API receives:

- `applicationDate`: date and time of the query
- `productId`: product identifier
- `brandId`: brand identifier

It returns:

- `productId`
- `brandId`
- `priceList`
- `startDate`, `endDate`
- `price`
- `currency`

The system selects the applicable price for the given date, considering the highest priority when multiple prices
overlap.

---

## 🚀 Technologies

- Java 21
- Spring Boot 3.4.5
- MapStruct 1.5.5
- OpenAPI Generator 7.3.0
- H2 in-memory database
- JUnit 5 + Mockito
- Docker

---

## 🏗️ Build and Run

### 🖥️ Using Maven

Build the application:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

The API will be available at [http://localhost:8080](http://localhost:8080)

Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### 🐳 Using Docker

Build the Docker image:

```bash
docker build -t price-service .
```

Run the Docker container:

```bash
docker run -p 8080:8080 price-service
```

---

## 🧪 Testing

This project includes:

✅ Unit tests for `FindPriceService`, mocking `LoadPricePort`  
✅ Integration tests for `PriceController` using MockMvc and in-memory H2 database

Run all tests:

```bash
mvn test
```

---

## 📂 API Endpoint

**GET `/prices`**  
Query price by `productId`, `brandId`, and `applicationDate`.

Example request:

```http
GET /prices?productId=35455&brandId=1&applicationDate=2020-06-14T16:00:00%2B00:00
```

Example response:

```json
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 2,
  "startDate": "2020-06-14T15:00:00Z",
  "endDate": "2020-06-14T18:30:00Z",
  "price": 25.45,
  "currency": "EUR"
}
```

---

## 📨 Postman Collection

A Postman collection with the 5 test requests is included at:

`postman/PriceServiceAPI.postman_collection.json`

Import this collection into Postman to test the API endpoints.

---

## 🔑 H2 Console Access

The application uses an embedded H2 database with the following configuration:

- **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** *(empty)*

> ✅ **Remote connections to the H2 console are already enabled in `application.properties`.**  
> You can access the H2 console remotely (e.g., from your browser while the app runs in Docker) without further
> configuration.

---

## 🙌 Notes

- The project uses an H2 in-memory database → no external DB setup required.
- The API implements the 5 specified test cases with expected prices and priorities.
- OpenAPI-generated DTOs use builder-style setters, requiring explicit MapStruct mappings.

---

## 🧑‍💻 Author

Javier Ros Roig
