package tarea2;
import java.util.ArrayList;

public class Tarea2 {
    public static void main(String[] args) {
        //                  Prueba de algunas Clases
        System.out.println("Monedas:");
        Moneda1000 m1 = new Moneda1000();
        System.out.println("m1:  Valor = "+m1.getValor() + "  Y  Serie = " + m1.getSerie());
        Moneda500 m2 = new Moneda500();
        System.out.println("m2:  Valor = "+m2.getValor() + "  Y  Serie = " + m2.getSerie());
        Moneda100 m3 = new Moneda100();
        System.out.println("m3:  Valor = "+m3.getValor() + "  Y  Serie = " + m3.getSerie());
        Moneda1000 m4 = new Moneda1000();
        System.out.println("m4:  Valor = "+m4.getValor() + "  Y  Serie = " + m4.getSerie()+"\n");
        Moneda1000 m5 = new Moneda1000();
        System.out.println("m5:  Valor = "+m5.getValor() + "  Y  Serie = " + m5.getSerie()+"\n");
        Moneda1000 m6 = new Moneda1000();
        System.out.println("m6:  Valor = "+m6.getValor() + "  Y  Serie = " + m6.getSerie()+"\n");
       
        //                   Caso 1:
        System.out.println("Caso 1: Compra Exitosa!");
        System.out.println("Expendedor con 1 bebida con un valor de 700 pesos y comprador paga con 1000 pesos una Sprite");
        Expendedor e1 = new Expendedor(1, 700);
        Comprador c1 = new Comprador(m1, 2, e1);
        System.out.println("Bebi "+c1.queBebiste() + " y me devolvieron " + c1.cuantoVuelto() + " pesos \n");
        
        //                   Caso 2:
        System.out.println("Caso 2: PagoInsuficienteException");
        System.out.println("Expendedor con 1 bebida con un valor de 700 pesos y comprador paga con 100 pesos una CocaCola");
        Comprador c2 = new Comprador(m3, 1, e1);
        System.out.println("Bebi "+c2.queBebiste() + " y me devolvieron " + c2.cuantoVuelto()+" pesos\n");
        
        //                   Caso 3:
        System.out.println("Caso 3: PagoIncorrectoException");
        System.out.println("Expendedor con 1 bebida con un valor de 700 pesos y comprador paga con moneda falsa (null) una Fanta");
        Comprador c3 = new Comprador(null, 3, e1);
        System.out.println("Bebi "+c3.queBebiste() + " y me devolvieron " + c3.cuantoVuelto()+" pesos\n");
        
        //                   Caso 4:
        System.out.println("Caso 4: NoHayBebidaException");
        System.out.println("Expendedor sin bebidas con un valor de 400 pesos y comprador paga con moneda de 500 pesos una LimonSoda");
        Expendedor e2 = new Expendedor(0, 400);
        Comprador c4 = new Comprador(m2, 4, e2);
        System.out.println("Bebi "+c4.queBebiste() + " y me devolvieron " + c4.cuantoVuelto()+" pesos\n");
        
        //                   Caso 5:
        System.out.println("Caso 5: EleccionInexistenteException");
        System.out.println("Expendedor con 3 bebidas con un valor de 900 pesos y comprador paga con moneda de 1000 pesos y marca una seleccion inexistente");
        Expendedor e3 = new Expendedor(3, 900);
        Comprador c5 = new Comprador(m4, 777, e3);
        System.out.println("Bebi "+c5.queBebiste() + " y me devolvieron " + c5.cuantoVuelto()+" pesos\n");
        
        
        //                   Prueba ComprarOtra:
        System.out.println("Prueba metodo adicional para comprar otra bebida con el mismo comprador:");
        c1.ComprarOtra(m5, 4, e1);
        System.out.println("Bebi "+c1.queBebiste() + " y me devolvieron " + c1.cuantoVuelto()+" pesos");
        c1.ComprarOtra(m6, 4, e1);
        System.out.println("Bebi "+c1.queBebiste() + " y me devolvieron " + c1.cuantoVuelto()+" pesos\n");
    }   
}

//__________________________________EXCEPCIONES________________________________//
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
        Bebida bebida;
        try{
            bebida = expendedor.ComprarBebida(BebidaElegida, moneda);
            this.sabor =  bebida.beber();
        } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException | EleccionInexistenteException e){
            System.out.println(e.getMessage());
            bebida = null;
            this.sabor = null;
        }
        this.vuelto = 0;
        for(int i=0 ; i<10 ; i++){
            Moneda Aux = expendedor.getVuelto();
            if(Aux != null){
                this.vuelto = this.vuelto + Aux.getValor();
            }else{
                i=10;
            }
        }
    }
    public Comprador(Moneda moneda, int BebidaElegida, Expendedor expendedor){
        Bebida bebida;
        try{
            bebida = expendedor.ComprarBebida(BebidaElegida, moneda);
            this.sabor =  bebida.beber();
        } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException | EleccionInexistenteException e){
            System.out.println(e.getMessage());
            bebida = null;
            this.sabor = null;
        }
        this.vuelto = 0;
        for(int i=0 ; i<10 ; i++){
            Moneda Aux = expendedor.getVuelto();
            if(Aux != null){
                this.vuelto = this.vuelto + Aux.getValor();
            }else{
                i=10;
            }
        }
    }
}

//___________________________________EXPENDEDOR___________________________________//
class Expendedor extends Deposito{
    private final int precioBebidas;
    public Bebida ComprarBebida(int BebidaElegida, Moneda moneda) throws NoHayBebidaException, PagoInsuficienteException, PagoIncorrectoException, EleccionInexistenteException{
        if(moneda == null){
            throw new PagoIncorrectoException("Inserte moneda valida");
        }else if(moneda.getValor() < precioBebidas){
            DepositoVuelto.add(moneda);
            throw new PagoInsuficienteException("Le faltan monedas");
        }
        int Aux = (moneda.getValor()-precioBebidas)/100;
        switch(BebidaElegida){
            case 1:
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
            case 2:
                if(DepositoSprite.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Sprites");
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoSprite.remove(0);
                }
            case 3:
                if(DepositoFanta.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Fantas");
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoFanta.remove(0);
                }
            case 4:
                if(DepositoLimonSoda.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan LimonSoda");
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoLimonSoda.remove(0);
                }
            default:
                DepositoVuelto.add(moneda);
                throw new EleccionInexistenteException("Error de seleccion");
            
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