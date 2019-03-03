/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class Conexion {
    
    
    com.mysql.jdbc.Connection connect = null;
    
    public com.mysql.jdbc.Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://axxb6a0z2kydkco3.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/r4ilw06qulc69m6b",
                    "hv6wyllr4ingopl9", "uolmd06bve48bgzj");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erro al conectar " + ex.getMessage());
        }
        return connect;
    }   
    
    
}
