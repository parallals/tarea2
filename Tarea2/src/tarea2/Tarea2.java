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
        Expendedor e1 = new Expendedor(3, 500);
        // Comprador
        Comprador c1 = new Comprador(m1, 2, e1);
        System.out.println(c1.queBebiste() + "  Y  " + c1.cuantoVuelto());
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
            this.vuelto = this.vuelto + Aux.getValor();
        }
        this.sabor =  expendedor.ComprarBebida(BebidaElegida, moneda).beber();
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
    public Bebida ComprarBebida(int BebidaElegida, Moneda moneda){
        if(moneda == null){
            // Añadir PagoIncorrectoException
            return null;
        }else if(moneda.getValor() < precioBebidas){
            // Añadir PagoInsuficienteException
            DepositoVuelto.add(moneda);
            return null;
        }
        int Aux = (moneda.getValor()-precioBebidas)/100;
        switch(BebidaElegida){
            case 1 -> {
                if(DepositoCoca.isEmpty()){
                    // Añadir NoHayBebidaException
                    DepositoVuelto.add(moneda);
                    return null;
                }else{
                    for(int i=0 ;  i<Aux ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoCoca.remove(0);
                }
            }case 2 -> {
                if(DepositoSprite.isEmpty()){
                    // Añadir NoHayBebidaException
                    DepositoVuelto.add(moneda);
                    return null;
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoCoca.remove(0);
                }
            }case 3 -> {
                if(DepositoFanta.isEmpty()){
                    // Añadir NoHayBebidaException
                    DepositoVuelto.add(moneda);
                    return null;
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoCoca.remove(0);
                }
            }case 4 -> {
                if(DepositoLimonSoda.isEmpty()){
                    // Añadir NoHayBebidaException
                    DepositoVuelto.add(moneda);
                    return null;
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