
package tarea2;

public class Comprador{
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
