# Pour d'Or

A premium coffee shop web application built using Java Servlets, JSP, JDBC, MySQL, and the DAO design pattern.

Pour d'Or provides a complete customer shopping workflow, including authentication, product browsing, cart management, address selection, checkout, and order placement. The application follows a layered MVC-oriented architecture designed to keep presentation, business logic, and data access responsibilities separated.

---

## Overview

Pour d'Or is a Java-based e-commerce application developed to demonstrate practical implementation of a traditional Java web application architecture.

The project focuses on:

- Clean separation of concerns
- DAO-based database access
- Servlet-driven request handling
- JSP-based presentation
- Session-based authentication
- Relational database design
- Reusable frontend components
- Maintainable project structure
- Git-based development workflow

The project is being developed with a strong emphasis on transforming a functional Java web application into a production-style portfolio project.

---

## Features

### Authentication

- User registration
- User login
- Session-based authentication
- Role-based login handling
- Authentication filter for protected customer routes
- Logout functionality

### Product Catalog

- Product listing
- Product categories
- Product information
- Product images
- Category-based product retrieval

### Shopping Cart

- Create and retrieve user carts
- Add products to cart
- Prevent unnecessary duplicate cart entries
- Update product quantities
- Remove individual cart items
- Calculate item totals
- Calculate cart subtotal
- Calculate shipping
- Calculate final order total
- Display dynamic cart item count

### Checkout

- Display saved delivery addresses
- Select delivery address
- Select payment method
- Review order summary
- Place order

### Order Management

- Create customer orders
- Create order items
- Store order totals
- Store payment method
- Store order status
- Retrieve orders by user
- Retrieve individual orders
- Retrieve all orders
- Update order information
- Delete orders
- Clear cart after successful checkout

### Address Management

- Create addresses
- Retrieve individual addresses
- Retrieve addresses belonging to a user
- Update addresses
- Delete addresses
- Retrieve all addresses

---

## Technology Stack

### Backend

- Java
- Jakarta Servlets
- JDBC
- JSP
- Apache Tomcat

### Database

- MySQL
- JDBC MySQL Driver

### Architecture and Design Patterns

- MVC-oriented architecture
- DAO Design Pattern
- Layered architecture
- Servlet-based request handling
- Session-based authentication

### Frontend

- HTML5
- CSS3
- JSP
- Custom SVG icons
- Responsive design

### Development Tools

- Eclipse IDE
- Apache Tomcat
- MySQL
- Git
- GitHub

---

## Architecture

The application follows a layered MVC-oriented structure.

```text
Client
   |
   v
JSP / HTML / CSS
   |
   v
Servlet Layer
   |
   v
DAO Layer
   |
   v
JDBC
   |
   v
MySQL Database


##Database Design

user
 |
 +---- address
 |
 +---- cart
        |
        +---- cart_item
                |
                +---- product
                        |
                        +---- category

user
 |
 +---- orders
          |
          +---- order_item
                    |
                    +---- product

user
 |
 +---- review
