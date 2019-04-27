import struktury.*;
public class Main {
    public static void main(String[] args){
        ZbiorNaTablicy zb=new ZbiorNaTablicy(3);
        Para a=new Para("a", 3.14);
        Para b=new Para("b", 2.14);
        Para c=new Para("c", 2.71);
        Para d=new Para("d", 42.24);
        Para e=new Para("e", 9.81);

        ZbiorNaTablicyDynamicznej zb2=new ZbiorNaTablicyDynamicznej();
        try{
            zb.wstaw(a);
            zb.wstaw(b);
            zb.wstaw(c);
            zb.wstaw(d);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
           System.out.println("Znalezione a: "+ zb.szukaj("a").toString());
           System.out.println("Wartość b: "+ zb.czytaj("b"));
            b.setWartosc(b.getWartosc()-2.0);
           zb.ustaw(b);
            System.out.println("Wartość b po zmianie wartości: "+ zb.czytaj("b"));
            zb.czysc();
            System.out.println("Przechowywanych po wyczyszczeniu: "+zb.ile());

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        try{
            zb2.wstaw(a);
            zb2.wstaw(b);

            zb2.wstaw(c);
            zb2.wstaw(d);
            zb2.wstaw(e);

            System.out.println("Znalezione a: "+ zb2.szukaj("a").toString());

            System.out.println("Wartość b: "+ zb2.czytaj("b"));
            b.setWartosc(b.getWartosc()-2.0);
            zb2.ustaw(b);
            System.out.println("Wartość b po zmianie wartości: "+ zb2.czytaj("b"));
            zb2.czysc();
            System.out.println("Przechowywanych po wyczyszczeniu: "+zb2.ile());



        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
