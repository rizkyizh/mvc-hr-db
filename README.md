- branch name : [_rizkyizh_](https://github.com/SIBKM-Batch4-Java/S1-MySQL_JDBC/tree/rizkyizh)
- author      : [Rizki Izzul Haq](https://github.com/rizkyizh)

---

### MVC (Model, View, Controller)

#### Task Framework MVC 1

- CRUD on Table Region:

  - getAll ✅
  - getById ✅
  - searchByName ✅
  - create ✅
  - update ✅
  - delete ✅

- implements:

  - Models ✅
  - IDAOS => DAOs ✅
  - IControllers => Controllers ✅
  - Views ✅

---
- How to run ?
  - import mysql db :  `db_hr.sql` [click here to download this file](https://gdurl.com/5H2G/download)
  - set mysql database `dbname, user and password` on `src/tools/DBConnection.java`

    ```java
    private String dbname = "database_name";
    private String user = "user_name";
    private String pass = "password";
    ```
    _mysql listening on port 3306_
    
  - compile and run on `src/App.java`
  
