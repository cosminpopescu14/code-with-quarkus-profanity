# code-with-quarkus-profanity project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

This is a simple microservice that checks if a comment contains any bad words or swearing.
It does not use any fancy algorithm or nlp technique, for the moment, basic comparison between a list of bad words
and the comment.

There are two endpoints.
* `/api/profanity/isProfanity/{word}` - for checking if a single word is a bad word and accepts a GET request
* `/api/profanity/analyseComment` - for analysing a comment written by used and accepts POST reques

Output Examples:
* `/api/profanity/isProfanity/{word}`
```JSON
{
    "profanity": false,
    "wordSupplied": "cosmin"
}
```
```JSON
{
    "profanity": true,
    "wordSupplied": "fuck"
}
```


A nice comment :)
```JSON
{
    "comment": "@FroMage did you start working on it? I'm the one that contribute the json representation of resteasy NotFoundExceptionMapper error page so I'm curious what is the issue.",
    "containBadWords": false,
    "numberOfWords": 27,
    "percentage": 0.0
}
```

A bad comment
```JSON
{
   "comment":"fuck this idiotic class",
   "containBadWords":true,
   "numberOfBadWords":2,
   "numberOfWords":4,
   "percentage":50.0
}
```

Requirements:
* Java >=11

Not required, but for a smooth development experience, Intellij IDEA.

If you like this project you can star it. Contributions are welcomed.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `code-with-quarkus-profanity-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/code-with-quarkus-profanity-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-profanity-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

# RESTEasy JAX-RS

Guide: https://quarkus.io/guides/rest-json


