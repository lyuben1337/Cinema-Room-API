# Cinema Room API

This is a learning project developed as part of the [Hyperskill platform](https://hyperskill.org/projects/133), aimed at building a simple API for managing a cinema room. The project focuses on practicing Java programming and utilizing the Spring Boot framework.

# API Endpoints
### Get Available Seats

- **Endpoint:** GET /seats
- **Description:** Retrieves information about the available seats in the cinema room.
- **Response:** Returns a JSON object containing the total number of rows and columns in the cinema room, as well as a list of available seats with their corresponding prices.

### Purchase Ticket

- **Endpoint:** POST /purchase
- **Description:** Purchases a ticket for a specific seat.
- **Request Body:** Requires a JSON object containing the seat details (row and column).
- **Response:** Returns a JSON object representing the purchased ticket, including a unique token and the seat information.

### Return Ticket

- **Endpoint:** POST /return
- **Description:** Returns a previously purchased ticket.
- **Request Body:** Requires a JSON object containing the ticket token.
- **Response:** Returns a JSON object representing the returned ticket.

### Get Movie Theatre Statistics

- **Endpoint:** POST /stats
- **Description:** Retrieves statistics about the movie theatre, including total income, available seats count, and purchased tickets count.
- **Query Parameter:** Allows an optional password to be provided for authentication.
- **Response:** Returns a JSON object containing the movie theatre statistics.

