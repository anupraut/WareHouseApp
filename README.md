# WarehouseApp

This is a warehouse management application built with Java and Spring Boot.

## Technologies Used

*   **Java:** 17
*   **Spring Boot:** 2.3.9.RELEASE
*   **Database:** MySQL
*   **Build Tool:** Maven
*   **Template Engine:** Thymeleaf
*   **API Documentation:** Swagger
*   **Other Dependencies:**
    *   Spring Data JPA
    *   Spring Web
    *   Spring Security
    *   Spring Batch
    *   Lombok
    *   JFreeChart (for charts)
    *   iText (for PDF generation)
    *   Apache POI (for Excel generation)

## Features

*   **User Management:** Manage different types of users (e.g., Admin, Customer).
*   **UOM (Unit of Measurement):** Manage units of measurement for products.
*   **Order Method:** Manage different methods of ordering (e.g., Sale, Purchase).
*   **Shipment Type:** Manage different types of shipments.
*   **Part Management:** Manage product parts.
*   **Purchase Orders:** Create and manage purchase orders.
*   **Sale Orders:** Create and manage sale orders.
*   **GRN (Goods Received Note):** Manage goods received notes.
*   **Shipping:** Manage shipping and delivery.
*   **Document Management:** Upload and manage documents.
*   **Data Visualization:** View charts for UOM, Shipment Type, and Sale Orders.
*   **Data Export:** Export data to PDF and Excel formats.

## Setup and Installation

1.  **Prerequisites:**
    *   Java 17
    *   Maven
    *   MySQL

2.  **Database Setup:**
    *   Create a MySQL database named `warehouseapp`.
    *   Update the `spring.datasource.username` and `spring.datasource.password` in `src/main/resources/application.properties` with your MySQL credentials.

3.  **Build the project:**
    ```bash
    mvn clean install
    ```

4.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```
    The application will be accessible at `http://localhost:9090`.

## API Documentation

Swagger UI is integrated for API documentation. Once the application is running, you can access the Swagger UI at:
`http://localhost:9090/swagger-ui.html`

## Configuration

*   The application configuration is in `src/main/resources/application.properties`.
*   The server port is set to `9090`.
*   Logging is configured to write to `F:/mylogs/whapp.log`.

## Project Structure

The project follows a standard Maven project structure.

*   `src/main/java`: Contains the Java source code.
    *   `in.nareshit.raghu.controller`: Contains the Spring MVC controllers.
    *   `in.nareshit.raghu.model`: Contains the JPA entity classes.
    *   `in.nareshit.raghu.repo`: Contains the Spring Data JPA repositories.
    *   `in.nareshit.raghu.service`: Contains the business logic.
    *   `in.nareshit.raghu.view`: Contains classes for PDF and Excel views.
*   `src/main/resources`: Contains the application resources.
    *   `static`: Contains static resources like CSS, JavaScript, and images.
    *   `templates`: Contains the Thymeleaf templates.
*   `pom.xml`: The Maven project configuration file.
