package edu.escuelaing.arep;

public class App {

    public static void main(String[] args) throws Exception {

        MicroFramework.staticfiles("/webroot");

        MicroFramework.get("/App/hello", (req, res) ->
                "Hello " + req.getValues("name")
        );

        MicroFramework.get("/App/pi", (req, res) ->
                String.valueOf(Math.PI)
        );

        HttpServer.start(8080);
    }

}