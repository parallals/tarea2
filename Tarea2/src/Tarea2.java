package tarea2;
import java.util.ArrayList;

public class Tarea2 {
    public static void main(String[] args) {
            
    }   
}

//___________________________________COMPRADOR___________________________________//
class Comprador{
    private int vuelto;
    private String sabor;
    public Comprador(Moneda moneda, int BebidaElegida, Expendedor expendedor){
        
    }

}
//___________________________________EXPENDEDOR___________________________________//
class Expendedor{
    private ArrayList<Bebida> DepositoBebidas;
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

//___________________________________BEBIDAS___________________________________//
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

//___________________________________MONEDAS___________________________________//
abstract class Moneda{
    private int valor;
    public int getValor(){
        return valor;
    }
    public Moneda(int valor){
        this.valor = valor;
    }
}

class Moneda1000 extends Moneda{
    public Moneda1000(){
        super(1000);
    }
}

class Moneda500 extends Moneda{
    public Moneda500(){
        super(500);
    }
}

class Moneda100 extends Moneda{
    public Moneda100(){
        super(100);
    }
}