package pila;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Pila {

    static ArrayList<String> pila = new ArrayList <String>(); 
    DibujoPila dibujo = new DibujoPila();
    
    public boolean meter (String v){
            pila.add(v);
            return true;
    }
    
    public boolean sacar (){
        if (!pila.isEmpty()){
            pila.remove(pila.size()-1);
            return true;
        }
        return false;
    }
    public String mostrar (){
        return pila.get(pila.size()-1);
    }
    public static void esperar (int segundos){
        try{
            Thread.sleep(segundos*1000);
        }catch(InterruptedException e){
            
        }
    }
    public void dibujar(String cadena2){
        dibujo.cadena = cadena2; 
        JFrame venta = new JFrame ();
        venta.setSize(500, 500);
        venta.add(dibujo);
        venta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        venta.setVisible(true);
    }
    public void repintar(){
        dibujo.repaint();
    }
    
    public static void main(String[] args) {
        int op=0;
        while (op==0){
            Pila p = new Pila();
            String cadena =  JOptionPane.showInputDialog("ingrese cadena");
            String cadena2 = cadena;
            int i =0;


            p.dibujar(cadena);

            Pila.esperar(7);


            for (int j = 0; j<cadena.length();j++){
                p.dibujo.estado = "p";
                if (cadena.charAt(j) =='0'){
                    cadena2 = cadena2.substring(1,cadena2.length());
                    p.dibujo.cadena =cadena2;
                    p.repintar();
                    p.meter("x");
                    p.dibujo.pila =p.pila;
                    Pila.esperar(10);
                }else{
                    i=j;
                    break;
                }
            }    
            for (int a = i; a<cadena.length(); a++ ){
                p.dibujo.estado = "q";
                if (cadena.charAt(a)=='1' && !pila.isEmpty()){
                    cadena2 = cadena2.substring(1,cadena2.length());
                    p.dibujo.cadena = cadena2;
                    p.repintar();
                    p.sacar();
                    p.dibujo.pila = p.pila;
                    Pila.esperar(10);
                }else{              
                    i=a;
                    break;
                }
                i=a;
            }

            if (p.pila.isEmpty() && cadena2.length() == 0){
                JOptionPane.showMessageDialog(null, "cadena valida");
            }else{
                JOptionPane.showMessageDialog(null, "cadena no valida");
            }
            Pila.esperar(7);
            op = JOptionPane.showConfirmDialog(null, "¿Volver a intentar?");
        }
        
    }
    
}
