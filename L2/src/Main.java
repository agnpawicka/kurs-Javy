import geometria.*;


public class Main {
    public static void main(String[] args) {
        Punkt a = new Punkt(1.1, 1.1);
        Punkt b = new Punkt(0.0, 0.0);
        Punkt c = new Punkt(2.2, 2.2);
        Punkt d = new Punkt(5.0, 7.8);
        try{
            Trojkat t1=new Trojkat(a, b, d);
            Odcinek o1=new Odcinek(c, d);
            Prosta p1=new Prosta(1.0, -1.0, 4.3 );
            Prosta p2=new Prosta(0.0, 2.0, 3.2);
            Wektor w1=new Wektor(2.0, 4.0);
            Wektor w2=new Wektor(-2.0, -4.0);


            //przesunięcie o wektor
            System.out.println("Odcinek1 "+ o1);
            System.out.println("wektor1 "+w1);
            o1.przesun(w1);
            System.out.println("Odcinek1 przesunięty o wektor1 "+o1);
            o1.przesun(w2);
            System.out.println("Odcinek1 przesunięty o - wektor1 "+o1);





            System.out.println("prosta1 "+ p1);
            System.out.println("wektor1 "+w1);
            System.out.println("prosta1 przesunięta o wektor1 "+Prosta.przesun(w1, p1));
            System.out.println("prosta1 przesunięta o - wektor1 "+Prosta.przesun(w2, p1));




            System.out.println("trojkat1 "+ t1);
            System.out.println("wektor1 "+w1);
            t1.przesun(w1);
            System.out.println("trojkat1 przesunięty o wektor1 "+t1);
            t1.przesun(w2);
            System.out.println("trojkat1 przesunięty o - wektor1 "+t1);


            Wektor w3=Wektor.zlozWektory(w1, w2);
            t1.przesun(w3);

            System.out.println("trojkat1 przesunięty o złożenie wektorów przeciwnych "+t1);
            //odbicie względem prostej

            System.out.println("Odcinek1 "+ o1);
            System.out.println("prosta1 "+p1);
            o1.odbij(p1);
            System.out.println("Odcinek1 odbity względem prostej1 "+o1);
            o1.odbij(p1);
            System.out.println("Odcinek1 odbity ponownie "+o1);

            System.out.println("trojkat1 "+ t1);
            System.out.println("prosta2 "+w1);
            t1.odbij(p2);
            System.out.println("trojkat1 odbity względem p2 "+t1);
            t1.odbij(p2);
            System.out.println("trojkat1 odbity ponownie "+t1);

            //obrót o kąt
            double pi=Math.PI;
            System.out.println(pi+"<-Math.Pi\n");
            System.out.println("trojkat1 "+ t1);
            System.out.println("punkt "+c);
            t1.obroc(c, pi/6);
            System.out.println("trojkat1 obrócony względem punktu o 30 stopni "+t1);
            t1.obroc(c, 11*pi/6);
            System.out.println("trojkat1 odwrócony ponownie"+t1);


            //punkt przecięcia

            System.out.println(Prosta.punktPrzeciecia(p1, p2));

            Prosta p3=new Prosta(3.2, 0.0, 4.8);
            Prosta p4= new Prosta(1.0, -1.0, 8.9);
            System.out.println("Poniżej powinno znajdować się : false, true, true, false\n");
            System.out.print(Prosta.czyRownolegle(p1, p2));
            System.out.print(" ");
            System.out.print( Prosta.czyRownolegle(p1, p4));
            System.out.print(" ");

            System.out.print(  Prosta.czyProstopadle(p2, p3));
            System.out.print(" ");
            System.out.print( Prosta.czyProstopadle(p1, p4));

            System.out.print("\npunkt przecięcia równoległych:\n");
            System.out.println(Prosta.punktPrzeciecia(p1, p4));

            Trojkat t2=new Trojkat(a, b, c);
         }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Trojkat t2=new Trojkat(a, b, c);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Odcinek o2=new Odcinek(c, c);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Prosta p3=new Prosta(0.0, 0.0, 4.2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
