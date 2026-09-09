# Jakarta Persistence and Hibernate

This project demonstrates how to use `Jakarta Persistence (JPA)` with `Hibernate and MariaDB` in a Jakarta EE environment.

### 1. Database Setup
Ensure MariaDB is running and a database named `library` exists. You can use the provided script:
```bash
mariadb -u root -p < sql/mariadb-init.sql
```

### 2. Run as Standalone Application (Quick Test) 
run a standalone `Main` class to verify the JPA integration and database connection:

## Dependencies
- `hibernate-core`: ORM framework Hibernate.
- `mariadb-java-client`: JDBC driver for MariaDB.
