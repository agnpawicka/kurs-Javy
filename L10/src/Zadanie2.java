import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadanie2 {
    private String plik;
    private LinkedList<Trojkat> lista;

    public Zadanie2(String plik) {
        this.plik = plik;
        lista = new LinkedList<Trojkat>();
        przeczytaj();

    }

    private void przeczytaj() {
        try (BufferedReader br = new BufferedReader(new FileReader(plik))) {
            for (String ln = br.readLine(); ln != null; ln = br.readLine()) {
                Matcher subMatcher = Pattern.compile("/").matcher(ln);
                if (subMatcher.find()) ln = ln.substring(0, subMatcher.start());
               // System.out.println(ln);
                ln += " ";//żeby zawsze znalazło trzecią liczbę po białym znaku
                Matcher startMatcher = Pattern.compile("[\\d|.]+").matcher(ln);
                Matcher endMatcher = Pattern.compile("\\s+").matcher(ln);
                List<String> list = new LinkedList<String>();
                while (startMatcher.find() && endMatcher.find()) {
                    String st = ln.substring(startMatcher.start(), endMatcher.start());
                    //System.out.println(st);
                    list.add(st);
                }

                if (list.size() == 3) {
                    try {
                        Trojkat t = new Trojkat(Double.parseDouble(list.get(0)), Double.parseDouble(list.get(1)), Double.parseDouble(list.get(2)));
                        lista.add(t);
                    } catch (Exception e) {
                        continue;
                        //e.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public LinkedList<Trojkat> getLista() {
        return lista;
    }
    public LinkedList<Trojkat> sortujPoObwodach(){
        LinkedList<Trojkat> lista2=new LinkedList<>();
        lista.stream().sorted((s1, s2)->{
            return s1.obwod().compareTo(s2.obwod());
        }).forEach((s->lista2.add(s)));

        return lista2;
    }
    public LinkedList<Trojkat> prostokatne(){
        LinkedList<Trojkat> lista2=new LinkedList<>();
        lista.stream().filter(s-> {
            return s.jestProstokatne();
        }).forEach((s->lista2.add(s)));

        return lista2;
    }
    public LinkedList<Trojkat> minMaxPole(){
        LinkedList<Trojkat> lista2=new LinkedList<>();
        lista.stream()
                .max((s1, s2)->{
                    return s2.pole().compareTo(s1.pole());
                })
                .ifPresent(lista2::add);
        lista.stream()
                .max((s1, s2)->{
                    return s1.pole().compareTo(s2.pole());
                })
                .ifPresent(lista2::add);

          return lista2;
    }
}
