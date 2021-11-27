package pila;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DibujoPila extends Canvas{
 String cadena;
 String estado = "p";
 ArrayList <String> pila = new ArrayList <String>();
 String pila2 = "zo";   
    public void paint (Graphics g){
        int random1 =(int)(Math.random()*254)+1;
        int random2 =(int)(Math.random()*254)+1;
        int random3 =(int)(Math.random()*254)+1;
        
        g.setColor(new Color (random1,random2,random3));
        g.drawLine(225, 160, 225, 200);
        g.drawLine(225, 250, 225,295);
        g.drawString(cadena, 225, 148);
        g.drawRect(200, 200, 50, 50);
        g.drawString(estado, 222, 227);
        g.drawOval(220, 150, 10, 10);
        g.drawOval(220, 295, 10, 10);
        
        pila2="zo";
        for(int i =0; i<pila.size(); i++){
            pila2 =  pila.get(i)+ pila2;
        }

        g.drawString(pila2, 222, 327);

    }
}
