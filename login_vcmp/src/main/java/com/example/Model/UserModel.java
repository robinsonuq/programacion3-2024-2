package com.example.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserModel {
    
    private static final String FILE_PATH = "D:\\Users\\PCSHOP-COL\\Desktop\\U_SEM4\\Programacion_III\\programacion3-2024-2\\login_vcmp\\src\\main\\java\\com\\example";

    public boolean isValidUser(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}