package pojos;
// Generated 17/02/2019, 2:18:41 p.m. by Hibernate Tools 4.3.1



/**
 * Nota generated by hbm2java
 */
public class Nota  implements java.io.Serializable {


     private NotaId id;
     private int valor;

    public Nota() {
    }

    public Nota(NotaId id, int valor) {
       this.id = id;
       this.valor = valor;
    }
   
    public NotaId getId() {
        return this.id;
    }
    
    public void setId(NotaId id) {
        this.id = id;
    }
    public int getValor() {
        return this.valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }




}


