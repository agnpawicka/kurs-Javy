package main;

import narzędzia.Zbiór;
import obliczenia.Zmienna;

import java.util.Scanner;

    /**
     * Główna klasa interaktywnego kalkulatora
     */
    public class Main {
        private static String linia;
        private static int index;

        /**
         * @return Kolejny podciąg rozpoczęty i zakończony znakiem : ' '
         */
        private static String next() {
            if (index >= linia.length()) return null;
            int end = linia.indexOf(' ', index + 1);
            if (end == -1) end = linia.length();
            if (end - index == 1) return next();
            String wyn = linia.substring(index + 1, end);
            index = end;
            return wyn;
        }

        /**
         * Główna pętla programu
         *
         * @param args
         */
        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            while (true) {
                try {
                    linia = in.nextLine();
                    linia = " " + linia;
                    index = 0;
                    assert (linia.contains("exit") || linia.contains("calc") || linia.contains("clear"));
                    if (linia.contains("exit")) {
                        break;
                    }
                    if (linia.contains("calc")) {
                        next();

                        Wyrażenie w = new Wyrażenie(linia.substring(index));
                        System.out.println(w.oblicz());
                        continue;
                    }
                    if (linia.contains("clear")) {
                        String s = next();
                        if (s == null) Zmienna.czysc();
                        while (s != null) {
                            Zmienna.usuń(s);
                            s = next();
                        }
                    }
                }catch (Exception e){

                }
            }
        }
    }
