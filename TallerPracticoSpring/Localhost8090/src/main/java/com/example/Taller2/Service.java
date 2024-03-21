package com.example.Taller2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {

    public String identifyDocument(String ruta) throws FileNotFoundException {

        String files = "Datos no admitidos";

        if (ruta.contains(".csv") || ruta.contains(".xlsx")) {

            Ruta rutaNueva = new Ruta(ruta);
            String testRuta = rutaNueva.getRuta();

            ResponseEntity<String> response = new RestTemplate().postForEntity("http://localhost:8090/validate-data", testRuta, String.class);

            return response.getBody();

        } else {
            return files;
        }

    }

}