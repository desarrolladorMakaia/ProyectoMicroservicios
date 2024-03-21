package com.example.Taller2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarCSV {

    static List<List<String>> validarFecha = new ArrayList<>();
    static List<List<String>> InvalidarFecha = new ArrayList<>();

    public static String validators(String ruta) {

        String expresion = "^([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,6})?$";

        Pattern pattern = Pattern.compile(expresion);
        String linea;

        Set<String> validarTitulo = new HashSet<>();
        validarTitulo.add("Haematologist");
        validarTitulo.add("Phytotherapist");
        validarTitulo.add("Building surveyor");
        validarTitulo.add("Insurance account manager");
        validarTitulo.add("Educational psychologist");

        try (BufferedReader buffered = new BufferedReader(new FileReader(ruta))) {

            while ((linea = buffered.readLine()) != null) {

                String[] valores = linea.split(",");

                Matcher matcher = pattern.matcher(valores[5]);

                try {

                    Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(valores[7]);
                    Date fecha2 = new SimpleDateFormat("yyyy-MM-dd").parse("1980-01-01");

                    String jobTitle = valores[8];

                    if (matcher.find() && validarTitulo.contains(jobTitle) && fecha2.before(fecha)) {
                        validarFecha.add(List.of(valores));
                    } else {
                        InvalidarFecha.add(List.of(valores));
                    }

                } catch (ParseException e) {
                    System.err.println("Error al analizar la fecha en la línea: " + linea);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        return "Archivos válidos " + validarFecha.size() + "\nArchivos inválidos " + InvalidarFecha.size();
    }
}