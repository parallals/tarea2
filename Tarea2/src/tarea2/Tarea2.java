package tarea2;
import java.util.ArrayList;

public class Tarea2 {
    public static void main(String[] args) {
        // Monedas      
        Moneda1000 m1 = new Moneda1000();
        System.out.println(m1.getValor() + "  Y  " + m1.getSerie());
        Moneda500 m2 = new Moneda500();
        System.out.println(m2.getValor() + "  Y  " + m1.getSerie());
        Moneda100 m3 = new Moneda100();
        System.out.println(m3.getValor() + "  Y  " + m1.getSerie());
        // Expendor
        Expendedor e1 = new Expendedor(0, 500);
        // Comprador
        Comprador c1 = new Comprador(m2, 2, e1);
        System.out.println(c1.queBebiste() + "  Y  " + c1.cuantoVuelto());
    }   
}
//___________________________________EXCEPCIONES________________________________//

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
//___________________________________COMPRADOR___________________________________//
class Comprador{
    private int vuelto;
    private String sabor;
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return sabor;
    }
    public void ComprarOtra(Moneda moneda, int BebidaElegida, Expendedor expendedor){
        this.vuelto = 0;
        for(int i=0 ; i<10 ; i++){
            Moneda Aux = expendedor.getVuelto();
            if(Aux != null){
                this.vuelto = this.vuelto + Aux.getValor();
            }
        this.sabor =  expendedor.ComprarBebida(BebidaElegida, moneda).beber();
        }
    }
    public Comprador(Moneda moneda, int BebidaElegida, Expendedor expendedor){
        Bebida bebida = expendedor.ComprarBebida(BebidaElegida, moneda);
        this.vuelto = 0;
        for(int i=0 ; i<10 ; i++){
            Moneda Aux = expendedor.getVuelto();
            if(Aux != null){
                this.vuelto = this.vuelto + Aux.getValor();
            }
        }
        this.sabor =  bebida.beber();
    }
}
//___________________________________EXPENDEDOR___________________________________//
class Expendedor extends Deposito{
    private final int precioBebidas;
    public Bebida ComprarBebida(int BebidaElegida, Moneda moneda) throws PagoIncorrectoException,PagoInsuficienteException{
        if(moneda == null){
            throw new PagoIncorrectoException("Inserte moneda valida");
        }else if(moneda.getValor() < precioBebidas){
            DepositoVuelto.add(moneda);
            throw new PagoInsuficienteException("Le faltan monedas");
        }
        int Aux = (moneda.getValor()-precioBebidas)/100;
        switch(BebidaElegida){
            case 1 -> {
                if(DepositoCoca.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan CocaColas");
                }else{
                    for(int i=0 ;  i<Aux ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoCoca.remove(0);
                }
            }case 2 -> {
                if(DepositoSprite.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Sprites");
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoCoca.remove(0);
                }
            }case 3 -> {
                if(DepositoFanta.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Fantas");
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoCoca.remove(0);
                }
            }case 4 -> {
                if(DepositoLimonSoda.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No hay Limon Soda");
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoCoca.remove(0);
                }
            }default -> {
                // Añadir EleccionIncorrectaException
                DepositoVuelto.add(moneda);
                return null;
            }
        }
    }
    public Moneda getVuelto(){
        if(DepositoVuelto.isEmpty()){
            return null;
         }else{
            return DepositoVuelto.remove(0);
         }
    }
    public Expendedor(int numBebidas, int precioBebidas){
        super(numBebidas);
        this.precioBebidas = precioBebidas;

    }
}

//___________________________________DEPOSITO___________________________________//
abstract class Deposito{
    protected ArrayList<CocaCola> DepositoCoca;
    protected ArrayList<Sprite> DepositoSprite;
    protected ArrayList<Fanta> DepositoFanta;
    protected ArrayList<LimonSoda> DepositoLimonSoda;
    protected ArrayList<Moneda> DepositoVuelto;
    protected Deposito(int cantidad){
        DepositoCoca = new ArrayList<>();
        DepositoSprite = new ArrayList<>();
        DepositoFanta = new ArrayList<>();
        DepositoLimonSoda = new ArrayList<>();
        DepositoVuelto = new ArrayList<>();
        for(int i=0 ; i<cantidad ; i++){
            DepositoCoca.add(new CocaCola(i));
            DepositoSprite.add(new Sprite(i+cantidad));
            DepositoFanta.add(new Fanta(i+(2*cantidad)));
            DepositoLimonSoda.add(new LimonSoda(i+(3*cantidad)));
        }
    }
}

//___________________________________BEBIDAS___________________________________//
abstract class Bebida{
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