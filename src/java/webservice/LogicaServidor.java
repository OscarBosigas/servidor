/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Conexion;
import model.DAOS;
import pojos.Alumno;
import pojos.Grado;
import pojos.Materia;
import pojos.Profesor;


/**
 *
 * @author oscar
 */
@WebService(serviceName = "LogicaServidor1")
public class LogicaServidor {

     List<String> listProfesores = new ArrayList();
    List<String> listEstudiantes = new ArrayList();

    /**
     * Web service operation
     * @param usuario
     * @param contra
     * @return 
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "usuario") String usuario, @WebParam(name = "contra") String contra) {
        try {
            //TODO write your implementation code here:
            Conexion c = new Conexion();
            Connection conn = c.conectar();
            Statement s1 = (Statement) conn.createStatement();            
            Statement s2 = (Statement) conn.createStatement();

            ResultSet rs1 = s1.executeQuery("SELECT identificacion, contraseña FROM profesor");
            ResultSet rs2 = s2.executeQuery("SELECT apellidos, identificacion FROM alumno");

            
            while (rs1.next()) {
                listProfesores.add(rs1.getString(1) + "," + rs1.getString(2));
            }
            while (rs2.next()) {
                listEstudiantes.add(rs2.getString(1) + "," + rs2.getString(2));
            }

            for (int i = 0; i < listProfesores.size(); i++) {
                if (existInList(listProfesores.get(i), usuario, contra)) {
                    return "Profesor";
                }
            }
            for (int i = 0; i < listEstudiantes.size(); i++) {
                if (existInList(listEstudiantes.get(i), usuario, contra)) {
                    return "Estudiante";
                }
            }
        } catch (SQLException ex) { 
            Logger.getLogger(LogicaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

            return "nada";
    }

    /**
     * Web service operation
     * @param s1
     * @param s2
     * @param s3
     * @return 
     */
    @WebMethod(operationName = "existInList")
    public boolean existInList(@WebParam(name = "s1") String s1, @WebParam(name = "s2") String s2, @WebParam(name = "s3") String s3) {
         String x[] = s1.split(",");
        return x[0].equals(s2) && x[1].equals(s3);
    }

    /**
     * Web service operation
     * @param parameter
     * @return 
     */
    @WebMethod(operationName = "operation")
    public Profesor operation(@WebParam(name = "parameter") String parameter) {
        DAOS daos = new DAOS();
        return daos.consultarProfesor(parameter);
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "consultarMateria")
    public Materia consultarMateria(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        DAOS daos = new DAOS();
        return daos.consultarMateria(id);
    }

    /**
     * Web service operation
     * @param Identificacion
     * @return 
     */
    @WebMethod(operationName = "consultarEstudiante")
    public Alumno consultarEstudiante(@WebParam(name = "Identifiacion") String Identificacion) {
       DAOS daos = new DAOS();
        return daos.consultarAlumno(Identificacion);
    }

    /**
     * Web service operation
     * @param parameter
     * @return 
     */
    @WebMethod(operationName = "consultarGrado2")
    public Grado consultarGrado2(@WebParam(name = "parameter") int parameter) {
        DAOS daos = new DAOS();
        return daos.consultarGradoDeMateria(parameter);
    }

    /**
     * Web service operation
     * @param idProfesor
     * @return 
     */
    @WebMethod(operationName = "obtenerMaterias")
    public List<Materia> obtenerMaterias(@WebParam(name = "idProfesor") String idProfesor) {
        DAOS daos = new DAOS();
        return daos.consultarMateriasPorProfesor(idProfesor);
    }

    /**
     * Web service operation
     * @param idGrado
     * @return 
     */
    @WebMethod(operationName = "alumnoPorGrado")
    public List<Alumno> alumnoPorGrado(@WebParam(name = "idGrado") int idGrado) {
        DAOS daos = new DAOS();
        return daos.consultarAlumnosPorGrado(idGrado);
    }

    
}
