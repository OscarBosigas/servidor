/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Alumno;
import pojos.Grado;
import pojos.Materia;
import pojos.Nota;
import pojos.NotaId;
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
        session.close();
        return null;
    }

    public Materia consultarMateria(int id) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Materia m = (Materia) session.get(Materia.class, id);
        if (m != null) {
            return m;
        }
        session.close();
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
        session.close();
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
        session.close();
        return null;
    }

    public List<Materia> consultarMateriasPorProfesor(String idProfesor) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("Select m from Materia m where Id_Profesor=:Id_Profesor");
        query.setParameter("Id_Profesor", idProfesor);
        List<Materia> list = new ArrayList();
        for (int i = 0; i < query.list().size(); i++) {
            Materia materia = (Materia) query.list().get(i);
            list.add(materia);
        }
        session.close();
        return list;
    }

    public List<Alumno> consultarAlumnosPorGrado(int idGrado) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("Select a from Alumno a where Id_Grado=:Id_Grado");
        query.setParameter("Id_Grado", idGrado);
        List<Alumno> list = new ArrayList();
        for (int i = 0; i < query.list().size(); i++) {
            Alumno alumno = (Alumno) query.list().get(i);
            list.add(alumno);
        }
        session.close();
        return list;
    }

    public double promedio() {
        List<String> notas = new ArrayList<>();
        double result = 0;
        for (int i = 0; i < notas.size(); i++) {
            String x[] = notas.get(i).split(",");
            result += Double.parseDouble(x[1]);
        }
        return result;
    }

    public String login(String usuario, String pass) {
        Alumno alumno = this.consultarAlumno(pass);
        Profesor profesor = this.consultarProfesor(usuario);

        if (alumno != null) {
            if (alumno.getApellidos().equals(usuario)) {
                return "Estudiante";
            }
        }
        if (profesor != null) {
            if (profesor.getContraseña().equals(pass)) {
                return "Profesor";
            }
        }

        return "nada";
    }

    public double notaFinal(List<String> listNotas) {
        double resultado = 0;
        double porcentaje = 0;
        double valor = 0;
        for (int i = 0; i < listNotas.size(); i++) {
            String x[] = listNotas.get(i).split(",");
            porcentaje = Double.parseDouble(x[0]) / 100;
            valor = Double.parseDouble(x[1]);
            resultado += porcentaje * valor;
        }
        return resultado;
    }
    
    public String observaciones(List<String> list){
        String aux = "";
        for (int i = 0; i < list.size(); i++) {
            String x[] = list.get(i).split(",");
            aux += "\n" + x[2];
        }
        return aux;
    }

    public void ingresarNota(String idAlumno, int idMateria, ArrayList<String> listNotas) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(new Nota(new NotaId(idAlumno, idMateria), this.notaFinal(listNotas), this.observaciones(listNotas)));
            tx.commit();
            session.close();
        }catch(Exception e){
            tx.rollback();
            System.err.println(e.getMessage());
        }
    }
}
