/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemm2025.misingresos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/financiero?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root";
    private static final String PASS = "Zaq123edcxz1";
    
    public Connection getConexion(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.out.println("error de conexion");
            System.out.println(e.getMessage());
       
        }
        return con;
    }
    
}
