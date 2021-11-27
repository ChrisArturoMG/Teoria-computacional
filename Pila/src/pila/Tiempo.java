package pila;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Tiempo {
    Timer timer = new Timer();    
    public int segundos;
    public boolean alto;
    
    TimerTask tarea = new TimerTask(){
        public void run (){
            System.out.println ("Prueba" + new Date());
        }
    };   
}
