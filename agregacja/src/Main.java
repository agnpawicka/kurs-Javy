import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args){

        Zadanie1 zadanie1=new Zadanie1("src/dane1.txt");
        System.out.println(zadanie1.getLista());
        System.out.println(zadanie1.posortuj());
        System.out.println(zadanie1.pierwsze());
        System.out.println(zadanie1.sumaMniejszych());
        //System.out.println(zadanie1.);

        Zadanie2 zadanie2=new Zadanie2("src/dane2.txt");
        System.out.println(zadanie2.getLista());
        System.out.println(zadanie2.sortujPoObwodach());
        System.out.println(zadanie2.prostokatne());
        System.out.println(zadanie2.minMaxPole());
    }
}
