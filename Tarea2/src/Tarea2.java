package tarea2;
import java.util.ArrayList;
public class Tarea2 {

    public static void main(String[] args) {
            System.out.println("aaaa");
    }
    
}

class Comprador{
    private int bebidaElegida;
    public int cuantoVuelto(){
    }
    public String queBebiste(){
    }
    public Comprador(Moneda m, int bebidaElegida, Expendedor expendedor){
        this.bebidaElegida = bebidaElegida;
    }

}

class Expendedor{
    private ArrayList<Bebida> DepositoCoca;
    private ArrayList<Bebida> DepositoSprite;
    private ArrayList<Bebida> DepositoFanta;
    public Bebida comprarBebida(Moneda m, int cual){
    
    }
    //Insertar excepciones
    public Moneda getVuelto(){
    }
    public Expendedor(int numBebidas, int precio){
        this.DepositoCoca = new ArrayList<Bebida>(cantidad);
        this.DepositoSprite = new ArrayList<Bebida>(cantidad);
        this.DepositoFanta = new ArrayList<Bebida>(cantidad);
    }
}

abstract class Bebida{
    private int numSerie;
    public int getSerie(){
        return numSerie;
    }
    public abstract String beber();
    public Bebida(int numSerie){
        this.numSerie = numSerie;
    }
}

class CocaCola extends Bebida{
    private int numSerie;
    public CocaCola(int numSerie){
        super(numSerie);
    }
}

class Sprite extends Bebida{
    private int numSerie;
    public Sprite(int numSerie){
        super(numSerie);
    }
}

class Fanta extends Bebida{
    private int numSerie;
    public Fanta(int numSerie){
        super(numSerie);
    }
}

abstract class Moneda{
    public getSerie(){
    }
    public Moneda(){
    }
}

class Moneda1000 extends Moneda{
    public Moneda()1000{
    }
    public int getValor(){
        return 1000;
    }
}
class Moneda500 extends Moneda{
    public Moneda()500{
    }
    public int getValor(){
        return 500;
    }
}
class Moneda100 extends Moneda{
    public Moneda()100{
    }
    public int getValor(){
        return 100;
    }
}