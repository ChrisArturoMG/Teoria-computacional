package planeta;

import java.util.ArrayList;

public class Automata{
    int idAutomata;
    int conodo = -1;
    ArrayList <Nodo> nodos = new ArrayList <Nodo>();
    int tipo = 0;
	
    public Automata (int idAutomata, ArrayList <Nodo> nodos){
	this.idAutomata = idAutomata;
	this.nodos = nodos;
    }

    public void insertarNodo(Nodo nodo){
	nodos.add(nodo);
	conodo++;
    }

    public void verAutomata(){      
	for (int i= 0; i<nodos.size(); i++){
            System.out.println (nodos.get(i).valorNodo[0] + nodos.get(i).valorNodo[1] +nodos.get(i).valorNodo[2]);
            //System.out.println ("transicion tamanio " + nodos.get(i).transiciones.size());
            /*for (int j = 0; j<nodos.get(i).transiciones.size(); j++){
                System.out.println ("transicion " + j + " " + nodos.get(i).transiciones.get(j)[0] +
                        nodos.get(i).transiciones.get(j)[1] +
                        nodos.get(i).transiciones.get(j)[2]);
            }*/
        }
    }
}