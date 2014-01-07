package pe.edu.cibertec.gch.modelo;

/**
 * Representa al genero de una persona
 */
public enum Genero {
    Masculino("m"), Femenino("f"), Indeterminado("i");

    public static Genero obtenerSegun(String sexo) {
        switch(sexo) {
            case "m":
                return Masculino;
            case "f":
                return Femenino;
            default:
                return Indeterminado;
        }
    }
    
    private String generoCode;
    
    Genero(String genero) {
        this.generoCode = genero;
    }
    
    public String getGeneroCode() {
        return this.generoCode;
    }
    
    
}
