package tarea2;

public abstract class Bebida{
    private final int numSerie;
    public int getSerie(){
        return numSerie;
    }
    public abstract String beber();
    public Bebida(int numSerie){
        this.numSerie = numSerie;
    }
}

class CocaCola extends Bebida{
    @Override
    public String beber(){
        return "CocaCola";
    }
    public CocaCola(int numSerie){
        super(numSerie);
    }
}

class Sprite extends Bebida{
    @Override
    public String beber(){
        return "Sprite";
    }
    public Sprite(int numSerie){
        super(numSerie);
    }
}

class Fanta extends Bebida{
    @Override
    public String beber(){
        return "Fanta";
    }
    public Fanta(int numSerie){
        super(numSerie);
    }
}

class LimonSoda extends Bebida{
    @Override
    public String beber(){
        return "LimonSoda";
    }
    public LimonSoda(int numSerie){
        super(numSerie);
    }
}

