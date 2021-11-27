package planeta;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Planeta {
    public static void main(String[] args) {
        int op = 0;
        while (op == 0){
            String aux;
            //Scanner rd = new Scanner (System.in);
            //System.out.println("dato:");
            //caso = rd.nextInt();
            aux = JOptionPane.showInputDialog("Escriba el numero de especies");
            int caso =Integer.parseInt(aux);
            Planeta p1 = new Planeta (caso);
            p1.getpermutaciones();
            especies = p1.getCombinaciones(especies);
            p1.crearAutomatas();
            p1.t();
            p1.generarDatosDibujo(p1.automatas);
            p1.dibujar(p1.automatas);
            especies.clear();
            op = JOptionPane.showConfirmDialog(null, "¿Volver a intentar?");
        }
    }
	static ArrayList <String[]> especies = new ArrayList <String[]>(); 
	ArrayList<String[]> aaa = new ArrayList<String[]>();
	ArrayList <Nodo> nodos = new ArrayList <Nodo>();
	ArrayList <Automata> automatas = new ArrayList <Automata> ();
	int n = 0;
	String[] cadena = new String [3];
	
	public Planeta(int n){
		this.n = n;
	}

    public void getpermutaciones(){
        int a = 0;
        for (int i = 0; i<n; i++){
           for (int j = 0; j<n; j++){
                for (int z = 0; z<n; z++){
                    if ((i+j+z) == n){
                        especies.add(new String[3]);
                        (especies.get(a))[0] = Integer.toString(i);
                        (especies.get(a))[1] = Integer.toString(j);
                        (especies.get(a))[2] = Integer.toString(z);
                        a++;
                    }
                }
            }
        }
    }

    public ArrayList <String[]> getCombinaciones(ArrayList <String[]> especi){	
    	for (int i = 0; i<especi.size(); i++ ) {
            for (int j = 0; j<especi.size(); j++){
   		if (i != j) {
                    if (comparador (especi.get(i), especi.get(j)) == true){
   			especi.remove(j);
			j = 0;
			i = 0;
    			break;
                    }
		}
            }
    	}
    	return especi;
    }

    public boolean comparador(String[] a , String[] b){    
        ArrayList<String> aa = new ArrayList<String>();
        ArrayList<String> bb = new ArrayList<String>();
          
       for (int x = 0; x <3; x++) {
            aa.add(a[x]);
        }
        for (int y = 0; y <3; y++) {
            bb.add(b[y]);
        }
        for (int i = 0; i < aa.size(); i++) {
            for (int j = 0; j < bb.size(); j++) {    	   
               if (aa.get(i).equals(bb.get(j)) == true) {
                    bb.remove(j);
                }
            }
        }
        if (bb.isEmpty()) {
            return true;
        }   	
        return false;
    }

    public String[] apareo (String[] estado){
        ArrayList <String> cc = new ArrayList<String>();
        ArrayList <String> dd = new ArrayList<String>();
        
        for (int j=0; j<3; j++){
            cc.add(estado[j]);
        }
        for (int i = 0;i<cc.size();i++) {
            if(cc.size() != 1){
             	if (!cc.get(i).equals("0")){
                    dd.add(Integer.toString((Integer.parseInt(cc.get(i)))-1));
                    cc.remove(i);
                    i=-1;
		}	
            }else{
    		dd.add(Integer.toString((Integer.parseInt(cc.get(i)))+2));
		cc.remove(i);
                i=-1;
            }
        }    	
    	String nuevo[] = new String[3];
    	nuevo [0] = dd.get(0); 
    	nuevo [1] = dd.get(1);
    	nuevo [2] = dd.get(2);
    	return nuevo;
    }

    public boolean buscarTope(String[] ca){
    	for (int i = 0; i<3; i++ ) {
            if (ca[i].equals(Integer.toString(n))) {	
    		return true;
            }
        }
    	return false;
    }

    public ArrayList<String[]> dameTodosApareos (String[] valorNodo){
        ArrayList<String[]> permutaciones = new ArrayList<String[]> (permutar (stringArrayList(valorNodo)));
	ArrayList<String[]> apareos = new ArrayList<String[]> ();
        for (int i = 0; i<permutaciones.size() ; i++) {
            apareos.add(apareo(permutaciones.get(i)));
	}
	getCombinaciones(apareos);
        return apareos;
    }


   public ArrayList<String[]> permutar( ArrayList<String[]> conjunto) {
   	ArrayList<String[]> permutas =new  ArrayList<String[]>();  
       	int per=0;
       	for (int i= 0;i<3 ;i++ ) {
            for (int j = 0;j<3 ;j++ ) {
        	for (int z=0;z<3 ;z++ ) {
                    if(i!=j && j!=z && i!=z){
                    	permutas.add(new String[3]);
                    	permutas.get(per)[0] = conjunto.get(0)[i];
        		permutas.get(per)[1] = conjunto.get(0)[j];
                        permutas.get(per)[2] = conjunto.get(0)[z];
        		per++;
                    }
        	}
            }
        }
        return permutas;
    }
   
    public ArrayList<String[]> stringArrayList(String[] cadena){    		
    	ArrayList <String []> a = new ArrayList <String[]>();
    	a.add(cadena);
    	return a;
    }
    
    public void falla (String[] raiz){
        Nodo ra = new Nodo(raiz);
        ArrayList <String[]> apareos = new ArrayList <String[]>();
        apareos = dameTodosApareos(ra.valorNodo);
        nodos.add(new Nodo(raiz));   
        for (int i = 0; i<apareos.size(); i++){
            int inter = 0;
            if(buscarTope(apareos.get(i)) == true){
            //System.out.println("Automata falla");				
            
            nodos.add(new Nodo(apareos.get(i)));
	}
        for(int j = 0; j<nodos.size(); j++){
            if (comparador (nodos.get(j).valorNodo, apareos.get(i)) == true){
                inter = 1;
            }
        }
        if (inter == 0 && buscarTope(apareos.get(i)) == false){
            falla(apareos.get(i));
        }			
    }
}
    
    public void crearAutomatas (){
        int inter=0;
	for (int i = 0; i<especies.size(); i++){
            if (i==0){
              System.out.println("Automata " + i + " raiz " + especies.get(i)[0]+ especies.get(i)[1]+ especies.get(i)[2] );
		falla(especies.get(i));				
		ArrayList <Nodo> n = new ArrayList <Nodo>(nodos);
		automatas.add(new Automata (i, n));
                automatas.get(i).verAutomata();
                nodos.clear();
            }else{
                for (int a=0; a<automatas.size(); a++){
                    for (int b= 0;b<automatas.get(a).nodos.size(); b++) {
			if (comparador (automatas.get(a).nodos.get(b).valorNodo, especies.get(i)) ==true) {
                            inter = 1;
			}
                    }
		}
		if(inter == 0){
                  System.out.println("Automata " + i + " raiz " + especies.get(i)[0]+ especies.get(i)[1]+ especies.get(i)[2] );
                    falla(especies.get(i));
                    ArrayList <Nodo> n2 = new ArrayList <Nodo>(nodos);
                    automatas.add(new Automata (i, n2));
                    automatas.get(i).verAutomata();
                    nodos.clear();
    		}
            }
	}
    }
        
    public void generarDatosDibujo(ArrayList<Automata> automatas){
       int radio = 300;
       int x =2*radio;
       int y = radio;
       for (int i = 0; i < automatas.size(); i++) {
           if(automatas.get(i).nodos.size() != 0){
               double separacion = Math.toRadians(360/automatas.get(i).nodos.size());
               double au = separacion;
               for (int j = 0; j < automatas.get(i).nodos.size(); j++) {
                   automatas.get(i).nodos.get(j).radio = 50;
                   automatas.get(i).nodos.get(j).x = x;
                   automatas.get(i).nodos.get(j).y = y;
                    if (j != 0 ){
                        separacion +=au;
                    }
                    x = (int)((radio*Math.cos(separacion)) + radio);
                    y = (int)((radio*Math.sin(separacion)) + radio);         
                }
            }
        }
       
       for (int i = 0; i<automatas.size(); i++){
           for (int j = 0; j < automatas.get(i).nodos.size(); j++) {
               for (int z = 0; z < automatas.get(i).nodos.get(j).transiciones.size(); z++){
                   
                   for (int a = 0; a < automatas.get(i).nodos.size(); a++) {
                       
                       if (comparador (automatas.get(i).nodos.get(a).valorNodo, automatas.get(i).nodos.get(j).transiciones.get(z))){
                           automatas.get(i).nodos.get(j).dibujoTransicion.add(new Transicion(
                                   automatas.get(i).nodos.get(j).x,automatas.get(i).nodos.get(j).y,
                                   automatas.get(i).nodos.get(a).x,automatas.get(i).nodos.get(a).y
                           ));
                       }
                   }
               }
           } 
       }
    }
    
    public void dibujar(ArrayList<Automata> a){
        ArrayList<JFrame> ventanas = new ArrayList<JFrame>();
        ArrayList<Dibujo> dibujos = new ArrayList<Dibujo>();
        
        int v = 0;
        int v2= 0;
        int aasd=0;
        for (int i = 0; i< automatas.size();i++){
        //Dibujo dibujo = new Dibujo (automatas,i);
        //JFrame frame = new JFrame();
        
        dibujos.add(new Dibujo(automatas,i));
        ventanas.add(new JFrame());
        ventanas.get(v).setTitle("Automata " + i);
        ventanas.get(v).setSize(800, 800);
        ventanas.get(v).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanas.get(v).getContentPane().add(dibujos.get(v2));
        ventanas.get(v).setVisible(true);
        dibujos.get(v2).repaint();
        v++;
        v2++;
        }
    }
    public void t (){
        for (int i = 0; i < automatas.size(); i++){
            for (int j = 0; j <automatas.get(i).nodos.size(); j++) {
                if (!buscarTope(automatas.get(i).nodos.get(j).valorNodo)){
                    automatas.get(i).nodos.get(j).datosT(dameTodosApareos(automatas.get(i).nodos.get(j).valorNodo)); 
                }else{
                    automatas.get(i).nodos.get(j).tipo=1;
                    automatas.get(i).tipo = 1;
                }   
            }
       }
    }
}

