# esirgeyen ve bağışlayan❤️ Allah'ın (c.c) adıyla - 2a0_linkedin_samarakkody
- [GitHub Environment](https://friendly-xylophone-9wp9557559r2xw4g.github.dev/)
# Jakarta Persistence and Hibernate

This project demonstrates how to use `Jakarta Persistence (JPA)` with `Hibernate and MariaDB` in a Jakarta EE environment.

### 1. Database Setup
Ensure MariaDB is running and a database named `library` exists. You can use the provided script:
```bash
mariadb -u root -p < sql/mariadb-init.sql
```

### 2. Run as Standalone Application (Quick Test) 
run a standalone `Main` class to verify the JPA integration and database connection:

This will:
- A union happens by combining all child tables and data persist to child tables only `card` and `cash`.
- AUTO_INCREMENT is not supported across all child tables when using the `table per class` strategy.
- 
## Dependencies
- `hibernate-core`: ORM framework Hibernate.
- `mariadb-java-client`: JDBC driver for MariaDB.
