![](https://github.com/Lylio/image-repo/blob/master/logos/spring-boot.png?raw=true)
![](https://github.com/Lylio/image-repo/blob/master/logos/camel.png?raw=true)

# Camel App

### Description

Introduction to the Camel framework.

### Tech Stack
- Spring Boot (JDK 11)
- Camel
- Maven

### Setup & Launch

#### Maven Launch : Message Route

Demonstration of triggering Camel routes via REST API endpoints. A GET and POST example is available:

1. In the app's root directory (where pom.xml is) run `mvn spring-boot:run`
2. Use curl commands or Postman to trigger Camel routes via REST API calls:

```
curl -XGET -H "Content-type: application/json" 'http://localhost:8080/messages'
```

```
curl -XPOST -H "Content-type: application/json" -d '{
"yellow":"banana",
"green":"apple",
"red":"strawberry",
"black": "grape"
}' 'http://localhost:8080/message'
```

The JSON values POSTed in the body can be made-up as anything - the Camel route merely returns the body content.

#### Maven Launch : File Move Route

Demonstration of transferring a file from one directory to another using a Camel route. Note the folder src/data/
containing the document file.txt. The following Camel route polls this directory for 5-seconds and copies the contents
of to a new directory in target/messages:

1. Use Postman or the following curl command to trigger the file transfer:
````
   curl -XGET -H "Content-type: application/json" 'http://localhost:8080/filemove'
````

Notice now there is a folder target/messages and the copied document file.txt.

<br />

#### Acknowledgements
Based on the articles at [Masterspringboot (Camel)](http://www.masterspringboot.com/category/camel/).
