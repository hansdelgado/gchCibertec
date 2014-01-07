package pe.edu.cibertec.gch.exception;

/**
 * Cuando los datos recibidos son invalidos
 */
public class DatosInvalidosException extends Exception {

    /**
     * Creates a new instance of
     * <code>DatosInvalidosException</code> without detail message.
     */
    public DatosInvalidosException() {
    }

    /**
     * Constructs an instance of
     * <code>DatosInvalidosException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public DatosInvalidosException(String msg) {
        super(msg);
    }
}
