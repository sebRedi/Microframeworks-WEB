# Project Title

Microframework Web -- REST Services and Static File Handling

This project implements a lightweight Java web framework capable of
serving static files and defining REST services using lambda
expressions. The framework demonstrates core concepts of HTTP servers,
routing, query parameter parsing, and distributed web architecture.

The framework allows developers to:

-   Define REST endpoints using lambda functions
-   Extract query parameters from HTTP requests
-   Serve static files such as HTML, CSS, JS, and images
-   Build simple web applications using a minimal framework architecture

------------------------------------------------------------------------

## Getting Started

These instructions will help you run the microframework locally.

Example endpoints:

http://localhost:8080/App/hello?name=Pedro http://localhost:8080/App/pi
http://localhost:8080/index.html

------------------------------------------------------------------------

## Project Architecture

Client Browser → HTTP Request → HttpServer → Route Matching → Lambda
Execution → HTTP Response

Components:

HttpServer -- Handles socket connections and HTTP parsing\
MicroFramework -- Stores routes and static folder configuration\
Route -- Functional interface for lambda expressions\
Request -- Extracts query parameters\
Response -- HTTP response metadata\
Static Files -- Served from resources/webroot

------------------------------------------------------------------------

## Prerequisites

Java 17+\
Maven\
Git

Verify:

java -version\
mvn -version

------------------------------------------------------------------------

## Installing

Clone repository:

git clone `https://github.com/sebRedi/Microframeworks-WEB`{=html}

Enter project:

cd Microframeworks-WEB

Compile:

mvn clean package

Run server:

mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.App"

Server runs at:

http://localhost:8080

------------------------------------------------------------------------

## Example Application

staticfiles("/webroot");

get("/App/hello", (req, res) -\> "Hello" + req.getValues("name") );

get("/App/pi", (req, res) -\> String.valueOf(Math.PI) );

------------------------------------------------------------------------

## Running the tests

Static file test:

http://localhost:8080/index.html

REST service test:

http://localhost:8080/App/hello?name=Pedro

Expected:

Hello Pedro

PI test:

http://localhost:8080/App/pi

Expected:

3.141592653589793

------------------------------------------------------------------------

## Built With

Java\
Maven\
HTTP Protocol\
Sockets API

------------------------------------------------------------------------

## Authors

Sebastian Galvis Briceño

------------------------------------------------------------------------

## License

Educational use only.
