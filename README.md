# Simple Contacts App

This is a simple contacts app developed using JSF, Maven and Hibernate with Java.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

```
Tomcat 9
MySQL 5
```

### Installing

Under `persistence/META-INF/persistence.xml` set up your MySQL settings.

```
<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/testDB" />
<property name="javax.persistence.jdbc.user" value="root" />
<property name="javax.persistence.jdbc.password" value="pass" />
```

For testing purposes eclipselink.ddl-generation is set to drop-and-create-tables, which means after you close the live session, all of the data will be erased. You can also change this in properties file.

```
<property name="eclipselink.ddl-generation" value="drop-and-create-tables" />
```

After you're done setting it up just run it through your IDE with Tomcat and navigate to http://localhost:8080/contact/home.xhtml or http://localhost:8080/contactsJSF/contact/home.xhtml (depending on your setup).

(If you are using Intellij IDEA, set persistence directory as resources root.)

## Built With

* [JSF](http://www.oracle.com/technetwork/java/javaee/javaserverfaces-139869.html) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Eclipselink](http://www.eclipse.org/eclipselink/) - Used to generate persistent data

As my IDE I have used Eclipse IDE as it provided most support for web projects. Maven made dependency management really easy.
