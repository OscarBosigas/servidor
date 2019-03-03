/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojos.Alumno;
import pojos.Grado;
import pojos.Materia;
import pojos.Profesor;
import pojos.Tutor;

/**
 *
 * @author oscar
 */
public class DAOS {

    public Profesor consultarProfesor(String id) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Profesor p = (Profesor) session.get(Profesor.class, id);
        if (p != null) {
            return p;
        }
        return null;
    }

    public Materia consultarMateria(int id) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Materia m = (Materia) session.get(Materia.class, id);
        if (m != null) {
            return m;
        }
        return null;
    }
    
    public Grado consultarGradoDeMateria(int id) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Materia m = this.consultarMateria(id);
        Grado g = (Grado) session.get(Grado.class, m.getIdGrado());
        if (g != null) {
            return g;
        }
        return null;
    }    
    public String consultarGrado(int id) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Grado g = (Grado) session.get(Grado.class, id);
        if (g != null) {
            return g.getNombre();
        }
        return "vacio";
    }

    public Alumno consultarAlumno(String identificacion) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Alumno a = (Alumno) session.get(Alumno.class, identificacion);
        if (a != null) {
            return a;
        }
        return null;
    }

    public Tutor consultarTutor(String identificacion) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Tutor t = (Tutor) session.get(Tutor.class, identificacion);
        if (t != null) {
            return t;
        }
        return null;
    }

    public List<Materia> consultarMateriasPorProfesor(String idProfesor) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("Select m from Materia m where Id_Profesor=:Id_Profesor");
        query.setParameter("Id_Profesor", idProfesor);
        List<Materia> list= new ArrayList();
        for (int i=0; i<query.list().size(); i++) {
            Materia materia = (Materia) query.list().get(i);
            list.add(materia);
        }
        return list;
    }
    
    public List<Alumno> consultarAlumnosPorGrado(int idGrado) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("Select a from Alumno a where Id_Grado=:Id_Grado");
        query.setParameter("Id_Grado", idGrado);
        List<Alumno> list= new ArrayList();
        for (int i=0; i<query.list().size(); i++) {
            Alumno alumno = (Alumno) query.list().get(i);
            list.add(alumno);
        }
        return list;
    }
}
