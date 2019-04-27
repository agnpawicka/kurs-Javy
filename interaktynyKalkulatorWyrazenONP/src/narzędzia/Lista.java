package narzędzia;

import java.util.LinkedList;
/**Klasa implementuje listę
 **/
public class Lista {
   private LinkedList<String> lista;
    public Lista(){
       lista=new LinkedList<String>();
    }
    public void push(String a){
       lista.push(a);
    }
    public String get(int i){
       return lista.get(i);
    }
}
