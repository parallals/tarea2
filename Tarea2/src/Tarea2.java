package tarea2;
import java.util.ArrayList;

public class Tarea2 {
    public static void main(String[] args) {
        Moneda100 m = new Moneda100();
        System.out.println(m.toString());
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

//___________________________________DEPOSITO___________________________________//
class Deposito{
    private int precio;
    private ArrayList<CocaCola> DepositoCoca;
    private ArrayList<Sprite> DepositoSprite;
    private ArrayList<Fanta> DepositoFanta;
    private ArrayList<LimonSoda> DepositoLimonSoda;
    public Deposito(int cantidad, int precio){
        this.precio = precio;
        DepositoCoca = new ArrayList<CocaCola>();
        DepositoSprite = new ArrayList<Sprite>();
        DepositoFanta = new ArrayList<Fanta>();
        DepositoLimonSoda = new ArrayList<LimonSoda>();
        for(int i=0 ; i<cantidad ; i++){
            DepositoCoca.add(new CocaCola(i));
            DepositoSprite.add(new Sprite(i+cantidad));
            DepositoFanta.add(new Fanta(i+(cantidad*2)));
            DepositoLimonSoda.add(new LimonSoda(i+(cantidad*3)));
        }
    }
    public Bebida getBebida(int BebidaElegida){
        switch(BebidaElegida){
            case 1:
                if(DepositoCoca.isEmpty()){
                    return null;
                }else{
                    return DepositoCoca.remove(0);     
                }
            case 2:
                if(DepositoSprite.isEmpty()){
                    return null;
                }else{
                    return DepositoSprite.remove(0);     
                }
            case 3:
                if(DepositoFanta.isEmpty()){
                    return null;
                }else{
                    return DepositoFanta.remove(0);     
                }
            case 4:
                if(DepositoLimonSoda.isEmpty()){
                    return null;
                }else{
                    return DepositoLimonSoda.remove(0);     
                }
        }
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
    abstract public int getValor();
    public String getSerie(){
        return toString();
    }
    public Moneda(){
    }

    
}

class Moneda1000 extends Moneda{
    public Moneda1000(){
    }
    @Override
    public int getValor(){
        return 1000;
    }
}

class Moneda500 extends Moneda{
    public Moneda500(){
    }
    @Override
    public int getValor(){
        return 500;
    }
}

class Moneda100 extends Moneda{
    public Moneda100(){
    }
    @Override
    public int getValor(){
        return 100;
    }
}