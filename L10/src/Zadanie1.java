import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Zadanie1 {
    private String plik;
    private ArrayList<Integer> lista;

    public Zadanie1(String plik) {
        this.plik = plik;
        lista=new ArrayList<Integer>();
        przeczytaj();

    }

    private void przeczytaj() {
        try (BufferedReader br = new BufferedReader(new FileReader(plik))) {
            for (String ln = br.readLine(); ln != null; ln = br.readLine()) {
                Matcher subMatcher = Pattern.compile("/").matcher(ln);
                if(subMatcher.find()) ln=ln.substring(0, subMatcher.start());
                //System.out.println(ln);
                if(!(ln.equals(""))){
                    ln=ln.replaceAll("\\s+","");
                    lista.add(Integer.parseInt(ln));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<Integer> getLista(){
        return lista;
    }
    public ArrayList<Integer> posortuj(){
        ArrayList<Integer> lista2=new ArrayList<Integer>();
         lista.stream().sorted((s1, s2)->{
             return s2.compareTo(s1);
         }).forEach((s->lista2.add(s)));

         return lista2;
    }
    public ArrayList<Integer> pierwsze(){
        ArrayList<Integer> lista2=new ArrayList<Integer>();
        lista.stream().filter(s->{
           return jestPierwsza(s);
        }).forEach((s->lista2.add(s)));

        return lista2;
    }
    private boolean jestPierwsza(int a){//wmieni.ć na coś ładnego
        if(a==2) return true;
        if(a%2==0) return false;
        for(int i=3; i*i<a; i+=2){
            if(a%i==0) return false;
        }
        return true;
    }
    private class Suma{
        private int s;
        private int getSuma(){
            return s;
        }
        Suma(){
            s=0;
        }
        private void dodaj(int co){
            s+=co;
        }
    }
    public int sumaMniejszych(){
        Suma suma=new Suma();
        lista.stream().filter(s->{
            return s<1000;
        }).forEach((s->suma.dodaj(s)));
        return suma.getSuma();
    }
}
