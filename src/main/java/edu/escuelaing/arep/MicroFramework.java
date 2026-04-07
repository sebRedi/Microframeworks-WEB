package edu.escuelaing.arep;

import java.util.HashMap;
import java.util.Map;

public class MicroFramework {

    private static Map<String, Route> getRoutes = new HashMap<>();
    private static String staticFolder = "/webroot";

    public static void get(String path, Route route) {
        getRoutes.put(path, route);
    }

    public static Map<String, Route> getRoutes() {
        return getRoutes;
    }

    public static void staticfiles(String folder) {
        staticFolder = folder;
    }

    public static String getStaticFolder() {
        return staticFolder;
    }

}