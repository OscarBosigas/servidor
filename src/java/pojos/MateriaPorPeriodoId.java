package pojos;
// Generated 17/02/2019, 2:18:41 p.m. by Hibernate Tools 4.3.1



/**
 * MateriaPorPeriodoId generated by hbm2java
 */
public class MateriaPorPeriodoId  implements java.io.Serializable {


     private int idMateria;
     private int idPeriodo;

    public MateriaPorPeriodoId() {
    }

    public MateriaPorPeriodoId(int idMateria, int idPeriodo) {
       this.idMateria = idMateria;
       this.idPeriodo = idPeriodo;
    }
   
    public int getIdMateria() {
        return this.idMateria;
    }
    
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
    public int getIdPeriodo() {
        return this.idPeriodo;
    }
    
    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MateriaPorPeriodoId) ) return false;
		 MateriaPorPeriodoId castOther = ( MateriaPorPeriodoId ) other; 
         
		 return (this.getIdMateria()==castOther.getIdMateria())
 && (this.getIdPeriodo()==castOther.getIdPeriodo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdMateria();
         result = 37 * result + this.getIdPeriodo();
         return result;
   }   


}


