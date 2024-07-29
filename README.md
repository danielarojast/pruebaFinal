https://pruebafinal-fjtd.onrender.com
https://github.com/danielarojast/pruebaFinal
https://trello.com/b/bEOrwWlN/prueba-final


Coupon Management and Redemption System


Members, responsibility of each member and their roles:

* Samuel Rodriguez: Team Leader
* Daniela Rojas: Developer
* Miguel Espinal: Developer
* Bayron Otalvaro: Developer


This project is an API for the management and redemption of discount coupons in an ecommerce system.

Description

This system allows users to manage and redeem discount coupons, following specific business rules and using modern architecture principles.
Table of Contents

    Installation
    Usage
    Main Features
    System Requirements
    Architecture and Principles
    Business Rules
    Contribution
    License
    Documentation

Installation

To install and run the project locally:

bash

git clone https://github.com/danielarojast/pruebaFinal.git


cd coupons


./mvnw spring-boot:run

Using
User Management

    User registration: POST /api/v1/user
    User update: PUT /api/v1/user/{id}
    User delete: DELETE /api/v1/user/{id}



Coupon Management

    Coupon creation: POST /api/voucher
    voucher listing: GET /api/voucher
    Coupon modification: PUT /api/voucher/{id}
    Deleting voucher: DELETE /api/voucher/{id}

Coupon Redemption

    Redeem coupons: POST /api/redeemed

Main Features

    User management: New user registration.
    Coupon management: Coupon creation, modification, deletion and verification.
    Coupon redemption: Redeem coupons on purchases and consult redemption history.

System Requirements

    Java 11+
    Spring Boot 2.5+
    Relational database (PostgreSQL, MySQL, etc.)
    Swagger for API documentation

Architecture and Principles

    Architectural pattern: Use of dependency injection.
    SOLID Principles: To ensure code quality.
    Exception handling: Efficient error handling.
    ORM: Data management using Object-Relational Mapping.

Business Rules

    A registered user can only redeem a coupon once.
    A coupon must have a unique code, expiration date and discount percentage.
    When redeeming a coupon, the user ID and product must be validated.

License

This project is licensed under the MIT License.
Documentation

Full API documentation is available from Swagger.



Proposed Solution

The proposed solution for the coupon management and redemption system focuses on providing flexibility and efficiency, covering three key aspects:

1.  One user can redeem many coupons:

        Flexibility of use: Each user can redeem multiple coupons, allowing them to take advantage of various offers.

        Validation and control: Mechanisms are implemented to ensure that coupons are redeemed according to their specific terms, avoiding duplicate redemptions by the same user.

2.   A coupon can be redeemed many times:

        Coupon reuse: 
        The same coupon can be used by different users or by the same user in different transactions.

        Redemption tracking: The system records each redemption, keeping an accurate and up-to-date record.


 3.  Many products can be associated with one coupon:

        Multi-product discounts: One coupon can be applied to multiple products, increasing the relevance of offers.

        Flexible configuration: Administrators can define specific criteria for coupon application, such as product categories or price ranges.


        
## UML Diagram

![Texto Alternativo](https://i.imgur.com/VD3z7iY.png)

## Hexagonal Structure

![Texto Alternativo](https://i.imgur.com/XkacKOi.png)
