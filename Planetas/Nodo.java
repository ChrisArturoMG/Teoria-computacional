package planeta;

import java.util.ArrayList;

public class Nodo{
    String valorNodo[] = new String [3];
    ArrayList<String[]> transiciones = new ArrayList<String[]> ();
    ArrayList<Transicion> dibujoTransicion = new ArrayList<Transicion> (); 
    int tipo=0;
    
    int x,y,radio;
    
    public Nodo (String[] nodo){
        for (int i = 0;i<3 ;i++ ) {
            valorNodo[i] = nodo[i]; 	
	}
    }
    
    public String getValorNodo(){
        String cadena="";
        for (int i=0; i<3; i++){
            if (i!=2){
            cadena = cadena + valorNodo[i] + " ";
            }else{
             cadena = cadena + valorNodo[i];   
            }
        }
        return cadena;
    }
    public void datosT(ArrayList<String[]> transiciones){
        this.transiciones = transiciones;
    }
}