package pe.edu.cibertec.gch.modelo;

/**
 * Indica la situacion en que se encuentra un laboratorio.
 */
public enum EstadoLaboratorio {

    /**
     * Que tiene todo lo necesario para que las clases se dicten con normalidad.
     */
    Implementado("1"),
    /**
     * Que tiene pendiente algunas mejoras para que las clases se puedan dictar
     * con normalidad.
     */
    PendienteImplementacion("2"),
    /**
     * Que tiene problemas que requieren una solucion importante para poder
     * dictar clases.
     */
    ConProblemas("3"),
    /**
     * El local ha declarado el salon no podra ser usado para clases.
     */
    Deshabilitado("4"),
    /**
     * El laboratorio tiene otros planes para el laboratorio.
     */
    NoDisponible("5");

   public static EstadoLaboratorio obtenerSegun(String estado) {
        switch (estado) {
            case "1":
                return Implementado;
            case "2":
                return PendienteImplementacion;
            case "3":
                return ConProblemas;
            case "4":
                return Deshabilitado;
            default:
                return NoDisponible;
        }
    }

    public static String obtenerSegun(EstadoLaboratorio estadoStr) {
        switch (estadoStr) {
            case Implementado:
                return "1";
            case PendienteImplementacion:
                return "2";
            case ConProblemas:
                return "3";
            case Deshabilitado:
                return "4";
            default:
                return "5";
        }
    }
    
    private String estado;
    
    EstadoLaboratorio(String estado) {
        this.estado = estado;
    }
    
    public String getEstadoCode() {
        return this.estado;
    }
}
