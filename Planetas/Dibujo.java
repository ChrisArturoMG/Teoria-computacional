package planeta;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Dibujo extends Canvas{
    ArrayList<Automata> automatas = new ArrayList <Automata>();
    int i;
    
    public Dibujo (ArrayList <Automata> automatas, int i){
        this.automatas = automatas;
        this.i = i;
    }
    
    public void paint (Graphics g){   
        //System.out.println ("Automata " + i + " a dibujar");
        automatas.get(i).verAutomata();
                        
        for (int j = 0; j < automatas.get(i).nodos.size(); j++){
            int x = automatas.get(i).nodos.get(j).x;
            int y = automatas.get(i).nodos.get(j).y;
            int r = automatas.get(i).nodos.get(j).radio;
            //System.out.println ("x " + x + " y " + y);
            if (j == 0){g.setColor(Color.black);}
            if (j == 1){g.setColor(Color.red);}
            if (j == 2){g.setColor(Color.blue);}
            if (j == 3){g.setColor(Color.GREEN);}
            if (j == 4){g.setColor(Color.MAGENTA);}
            if (j == 6){g.setColor(Color.ORANGE);}
            if (j == 7){g.setColor(Color.pink);}
            if (j == 8){g.setColor(Color.cyan);}
            if (j == 9){g.setColor(Color.gray);}
            
            g.drawOval(x,y,r,r);
            g.drawString(automatas.get(i).nodos.get(j).getValorNodo(), (x)+r/4, y+30);
            
            if ((automatas.get(i).tipo == 1)){
            g.drawString("Automata fallo",10, 10);
            if (automatas.get(i).nodos.get(j).tipo==1){
                g.drawOval(x+5,y+5,r-10,r-10);
            }
            }else{
            g.drawString("Automata no fallo ", 10, 10);    
            }
            
            for (int k = 0; k < automatas.get(i).nodos.get(j).dibujoTransicion.size(); k++) {
                g.drawLine (automatas.get(i).nodos.get(j).dibujoTransicion.get(k).i1, 
                automatas.get(i).nodos.get(j).dibujoTransicion.get(k).f1,
                automatas.get(i).nodos.get(j).dibujoTransicion.get(k).i2,
                automatas.get(i).nodos.get(j).dibujoTransicion.get(k).f2);
                            
                g.drawOval(automatas.get(i).nodos.get(j).dibujoTransicion.get(k).i2,
                automatas.get(i).nodos.get(j).dibujoTransicion.get(k).f2, 
                10, 10);
                }  
            } 
        }
}