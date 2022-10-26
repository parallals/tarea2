package tarea2;

class PagoIncorrectoException extends RuntimeException{
    public PagoIncorrectoException(){}
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}

class PagoInsuficienteException extends RuntimeException{
    public PagoInsuficienteException(){}
    public PagoInsuficienteException(String mensaje){
        super(mensaje);
    }
}

class NoHayBebidaException extends RuntimeException{
    public NoHayBebidaException(){}
    public NoHayBebidaException(String mensaje){
        super(mensaje);
    }
}

class EleccionInexistenteException extends RuntimeException{
    public EleccionInexistenteException(){}
    public EleccionInexistenteException(String mensaje){
        super(mensaje);
    }
}