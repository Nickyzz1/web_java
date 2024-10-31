package com.desktopapp;

public class MyPasswordValidator {
    public static boolean Validate(String pass) 
    {

        pass = pass.toLowerCase();

        if(pass.length() < 8) {

            System.out.println("\n\n\n\n\n não pasou small pass " + pass);
            return false;
        }

        // ver se uma string contem números
        if(!pass.matches(".*\\d.*")) {
            System.out.println("\n\n\n\n\n não pasou sem numero " + pass +"\n\n\n");
            return false;
        }

         // ver se uma string contem letras
        if(!pass.matches(".*[a-zA-Z].*")) {
            System.out.println("\n\n\n\n\n não pasou sem letras " + pass +"\n\n\n");
            return false;
        }

        if(!pass.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            System.out.println("\n\n\n\n\n não pasou sem caracteres especiais " + pass +"\n\n\n");
            return false;
        }

        return true;
    }
}