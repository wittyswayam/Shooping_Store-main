# 🛒 E-Commerce Shopping Store

A full-featured RESTful API for an e-commerce platform built with Spring Boot, providing comprehensive product catalog management, shopping cart functionality, and order processing capabilities.

## ✨ Features

### Category Management
- ✅ Create, update, and delete product categories
- ✅ Upload category images
- ✅ Active/inactive category status
- ✅ Featured categories support
- ✅ Soft delete functionality

### Product Management
- 📦 Product CRUD operations
- 💰 Original and discounted pricing
- 📊 Stock management
- 🖼️ Multiple product images support
- 🏷️ Product categorization
- ⭐ Featured products

### Shopping Cart
- 🛍️ Add/remove items to cart
- 📝 Cart item management
- 💳 Total amount calculation
- 📊 Quantity tracking

### Order & Booking System
- 📋 Order placement
- 🚚 Multiple delivery types (Office, Home, Other)
- 💳 Multiple payment methods (COD, Credit/Debit Card, UPI, Net Banking)
- 📍 Address management
- 📦 Order status tracking (In Progress, Received, Packed, Shipped)

### User Management
- 👤 User registration and profile
- 📧 Email and mobile verification
- 🏠 Multiple address support
- 🖼️ Profile image upload

## 🏗️ Technology Stack

- **Backend Framework**: Spring Boot 3.2.5
- **Java Version**: 17
- **Database**: MySQL 8.x
- **ORM**: Spring Data JPA / Hibernate
- **Build Tool**: Maven 3.2.0
- **Object Mapping**: ModelMapper 3.0.0
- **Development Tools**: Lombok, Spring DevTools

## 📋 Prerequisites

- Java Development Kit (JDK) 17 or higher
- MySQL 8.x or higher
- Maven 3.6+ (or use included Maven wrapper)
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## 📁 Project Structure

```
shopping-store/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/ecom/
│   │   │       ├── config/          # Configuration classes
│   │   │       ├── controller/      # REST API controllers
│   │   │       ├── dto/             # Data Transfer Objects
│   │   │       ├── endpoint/        # API endpoint interfaces
│   │   │       ├── enums/           # Enumeration types
│   │   │       ├── exception/       # Custom exceptions
│   │   │       ├── handler/         # Response handlers
│   │   │       ├── model/           # Entity classes
│   │   │       ├── repository/      # JPA repositories
│   │   │       ├── service/         # Business logic layer
│   │   │       │   └── impl/        # Service implementations
│   │   │       └── utils/           # Utility classes
│   │   └── resources/
│   │       ├── application.properties
│   │       └── category_img/        # Category images storage
│   └── test/                        # Unit and integration tests
├── pom.xml
└── README.md
```

## 🔌 API Endpoints

### Category Management

#### Create Category
```http
POST /category/
Content-Type: application/json

{
  "name": "Electronics",
  "description": "Electronic devices and accessories",
  "isActive": true,
  "isFeatures": false
}
```

#### Create Category with Image
```http
POST /category/saveCategory
Content-Type: multipart/form-data

file: [category_image.jpg]
category: {
  "name": "Electronics",
  "description": "Electronic devices",
  "isActive": true
}
```

#### Get All Categories
```http
GET /category/
```

#### Delete Category
```http
DELETE /category/{id}
```

### Response Format
All API responses follow a standard format:
```json
{
  "status": 200,
  "message": "success",
  "data": {
    // Response data
  }
}
```

## 🗄️ Database Schema

### Main Entities

**Category**
- id (Primary Key)
- name
- description
- isActive
- isDeleted
- isFeatures
- images
- products (One-to-Many)

**Product**
- id (Primary Key)
- title
- description
- discount
- originalPrice
- discountPrice
- stock
- isActive
- isFeature
- category (Many-to-One)
- images (One-to-Many)

**User (UserDtls)**
- id (Primary Key)
- fullName
- email
- mobno
- password
- address (One-to-Many)
- profileImage

**Cart**
- id (Primary Key)
- totalAmount
- totalQuantity
- cartItem (One-to-One)
- user (Many-to-One)

**Booking (Order)**
- id (Primary Key)
- bookingDate
- orderNumber
- cart
- customer
- address
- delivery (Enum)
- payment (Enum)
- status (Enum)

## 🎨 Key Features Implementation

### Image Upload
The application supports file uploads for category and product images, stored in the local filesystem:
- Category images: `category_img/`
- Configurable upload paths in `application.properties`

### Exception Handling
Global exception handling with custom exceptions:
- `ResourceNotFoundException` - When requested resource doesn't exist
- `ExistResourceException` - When trying to create duplicate resources
- `NoResourceFoundException` - For invalid API endpoints

### ModelMapper Integration
Automatic conversion between entities and DTOs for clean separation of concerns.

### Soft Delete
Categories support soft deletion with `isDeleted` flag, preserving data integrity.

## 🛠️ Development

### Running Tests
```bash
./mvnw test
```

### Building JAR
```bash
./mvnw clean package
```

The JAR file will be created in `target/` directory.

### Hot Reload
Spring DevTools is included for automatic application restart during development.

## 🔐 Security Considerations

**⚠️ Important**: This is a demonstration project. For production use, implement:
- Spring Security for authentication/authorization
- Password encryption (BCrypt)
- JWT token-based authentication
- Role-based access control (Admin, User)
- Input validation and sanitization
- HTTPS/SSL configuration
- API rate limiting

## 📝 Configuration

### Application Properties
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/ecom
spring.datasource.username=****
spring.datasource.password=****

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# File Upload Path
category.imges=category_img/
```

### Environment Variables
You can override database configuration using environment variables:
```bash
MYSQL_HOST=localhost
MYSQL_PORT=3306
```

## 🚀 Future Enhancements

- [ ] Implement Spring Security
- [ ] Add user authentication & JWT
- [ ] Product review and rating system
- [ ] Search and filter functionality
- [ ] Email notifications
- [ ] Order tracking system
- [ ] Wishlist functionality
- [ ] Product recommendations
- [ ] Admin dashboard


## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 🙏 Acknowledgments

- Spring Boot framework
- Spring Data JPA
- ModelMapper library
- MySQL database
- Lombok for reducing boilerplate code
