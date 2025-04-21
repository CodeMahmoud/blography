# Blogography - A Modern Blogging Platform

Blogography is a full-stack blogging platform built with Spring Boot and React, featuring a clean and modern user interface. It allows users to create, read, update, and delete blog posts with support for categories and tags.

## Features

- **User Authentication**: Secure login and registration system with JWT
- **Blog Post Management**: Create, read, update, and delete blog posts
- **Categories & Tags**: Organize posts with categories and tags
- **Rich Text Content**: Support for formatted blog content
- **Reading Time**: Automatic calculation of post reading time
- **Responsive Design**: Mobile-friendly interface
- **Modern UI**: Built with NextUI components

## Tech Stack

### Backend
- **Java 17**
- **Spring Boot 3.x**
- **Spring Security** with JWT authentication
- **Spring Data JPA**
- **PostgreSQL** database
- **Maven** for dependency management

### Frontend
- **React 18**
- **TypeScript**
- **NextUI** for UI components
- **Axios** for API calls
- **React Router** for navigation
- **DOMPurify** for content sanitization

## Prerequisites

- Java 17 or higher
- Node.js 16 or higher
- PostgreSQL 14 or higher
- Maven 3.8 or higher

## Getting Started

### Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/blogography.git
   cd blogography
   ```

2. Configure the database:
   - Create a PostgreSQL database
   - Update the database configuration in `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

3. Build and run the backend:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm run dev
   ```

The application will be available at:
- Backend: http://localhost:8080
- Frontend: http://localhost:5173

## API Endpoints

### Authentication
- `POST /api/v1/auth/register` - Register a new user
- `POST /api/v1/auth/login` - Login and get JWT token

### Posts
- `GET /api/v1/posts` - Get all published posts
- `GET /api/v1/posts/{id}` - Get a specific post
- `POST /api/v1/posts` - Create a new post
- `PUT /api/v1/posts/{id}` - Update a post
- `DELETE /api/v1/posts/{id}` - Delete a post
- `GET /api/v1/posts/drafts` - Get draft posts (authenticated)

### Categories
- `GET /api/v1/categories` - Get all categories
- `POST /api/v1/categories` - Create a new category
- `PUT /api/v1/categories/{id}` - Update a category
- `DELETE /api/v1/categories/{id}` - Delete a category

### Tags
- `GET /api/v1/tags` - Get all tags
- `POST /api/v1/tags` - Create new tags
- `DELETE /api/v1/tags/{id}` - Delete a tag

## Project Structure

```
blogography/
├── frontend/              # React frontend application
│   ├── src/
│   │   ├── components/    # Reusable UI components
│   │   │   ├── components/    # Reusable UI components
│   │   │   ├── pages/        # Page components
│   │   │   ├── services/     # API service
│   │   │   └── types/        # TypeScript types
│   │   └── package.json
│   └── src/                   # Spring Boot backend
│       ├── main/
│       │   ├── java/
│       │   │   ├── controllers/    # REST controllers
│       │   │   ├── domain/        # Domain models and DTOs
│       │   │   ├── repositories/  # JPA repositories
│       │   │   ├── services/      # Business logic
│       │   │   └── security/      # Security configuration
│       │   └── resources/         # Configuration files
│       └── test/                  # Test files
└── pom.xml                   # Maven configuration
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [React](https://reactjs.org/)
- [NextUI](https://nextui.org/)
- [PostgreSQL](https://www.postgresql.org/)
