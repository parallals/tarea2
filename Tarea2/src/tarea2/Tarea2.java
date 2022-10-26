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
