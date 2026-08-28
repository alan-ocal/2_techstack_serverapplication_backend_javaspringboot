USE library;

CREATE TABLE IF NOT EXISTS user(
                                   user_id INT AUTO_INCREMENT PRIMARY KEY,
                                   user_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS grp(
                                  group_id INT AUTO_INCREMENT PRIMARY KEY,
                                  group_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS student(
                                   studentCode VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS teacher(
                                   teacherCode VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS member(
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255),
                                     member_type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS student2(
                                      studentCode VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS teacher2(
                                      teacherCode VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS member2(
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255),
                                     member_type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS genre(
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    code VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS  fiction(
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    code VARCHAR(255),
                                    setting VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS non_fiction(
                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                          code VARCHAR(255),
                                          topic VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS payment(
                                    id INT PRIMARY KEY,
                                    amount VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS cardpayment(
                                    id INT PRIMARY KEY,
                                    amount VARCHAR(255),
                                    cardNumber VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS cashpayment(
                                    id INT PRIMARY KEY,
                                    amount VARCHAR(255),
                                    code VARCHAR(255)
);