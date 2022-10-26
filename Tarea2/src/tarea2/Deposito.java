package tarea2;

import java.util.ArrayList;

public abstract class Deposito {

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
