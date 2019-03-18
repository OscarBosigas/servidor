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
        DAOS daos = new DAOS();
        return daos.login(usuario, contra);
            
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

    /**
     * Web service operation
     * @param parameter
     * @return 
     */
    @WebMethod(operationName = "valorNota")
    public double valorNota(@WebParam(name = "parameter") ArrayList<String> parameter) {
        //TODO write your implementation code here:
        DAOS daos = new DAOS();
        return daos.notaFinal(parameter);
    }

    /**
     * Web service operation
     * @param porcentaje
     * @param valo
     * @return 
     */
    @WebMethod(operationName = "agregarPonderado")
    public String agregarPonderado(@WebParam(name = "porcentaje") String porcentaje, @WebParam(name = "valo") String valo) {
        //TODO write your implementation code here:
        return porcentaje + "," + valo;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "calificar")
    public String calificar(@WebParam(name = "idAlumno") String idAlumno, @WebParam(name = "idGrado") int idGrado, @WebParam(name = "notas") ArrayList<String> notas) {
        //TODO write your implementation code here:
        DAOS daos = new DAOS();
        daos.ingresarNota(idAlumno, idGrado, notas);
        return "";
    }


    
}
