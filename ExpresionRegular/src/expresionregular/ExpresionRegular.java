package expresionregular;
import java.util.Random;

public class ExpresionRegular {
   public static void main(String[] args) {
       
       ExpresionRegular er = new ExpresionRegular();
       String cadena;
       
       if (er.lanzarRandom(1)==0){
           int vciclo = er.lanzarRandom(0);
           
           cadena = "0";
           for (int i = 0; i<vciclo; i++){
               cadena = cadena + "11";
           }
           
           vciclo = er.lanzarRandom(0);
           
           for (int i = 0; i<vciclo; i++){
               if (er.lanzarRandom(1) == 0){
                   
                   int v2ciclo = er.lanzarRandom(0);
                   
                   for (int j = 0; j< v2ciclo; j++){
                       if (er.lanzarRandom(1)==0){
                           cadena = cadena + "00";
                       }else {
                           cadena = cadena + "01";
                       }
                   }
               }else {
                   int v3ciclo = er.lanzarRandom(0);
                   
                   for (int j = 0; j< v3ciclo; j++){
                       if (er.lanzarRandom(1)==0){
                           cadena = cadena + "00";
                       }else {
                           cadena = cadena + "01";
                       }
                   }
               }
           }
       
       }else {
           cadena = "00";
       }
       
       System.out.println(cadena);
           
       
    }
   public int lanzarRandom(int op){
       
       Random ra = new Random();
       
       if (op == 1 ){
            return (int)(Math.random()*2);
       }
       else {
            return (int)(Math.random()*10);
       }
   }
}
