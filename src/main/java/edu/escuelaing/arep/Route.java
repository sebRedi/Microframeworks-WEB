package edu.escuelaing.arep;

@FunctionalInterface
public interface Route {
    String handle(Request req, Response res);
}