

public class KonwerterLiczbNaSlowa {

    private static final String[][] liczebniki = {{"zero", "jeden ", "dwa ", "trzy ", "cztery ", "pięć ", "sześć ", "siedem ", "osiem ", "dziewięć "},
            {"dziesięć ", "jedenaście ", "dwanaście ", "trzynaście ", "czternaście ", "piętnaście ", "szesnaście ", "siedemnaście ", "osiemnaście ", "dziewiętnaście "},
            {"", "", "dwadzieścia ", "trzydzieści ", "czterdzieści ", "pięćdziesiąt ", "sześćdziesiąt ", "siedemdziesiąt ", "osiemdziesiąt ", "dziewięćdziesiąt "},
            {"", "sto ", "dwieście ", "trzysta ", "czterysta ", "pięćset ", "sześćset ", "siedemset ", "osiemset ", "dziewięćset "},
            {"jeden", "", ""},
            {"tysiąc ", "tysiące ", "tysięcy "},
            {"milion ", "miliony ", "milionów "},
            {"", "miliard ", "miliardy "}};

    private static String wypisywanie(int liczba) {
        String slowne = "";
        int dziesiatki = 1000000000;
        if (liczba == 0) return "zero";//System.out.println(liczebniki[0][0]);
        else {

            if (liczba == Integer.MIN_VALUE) {
                slowne += "minus dwa miliardy ";
                liczba = liczba % dziesiatki;
                liczba = -liczba;
            } else if (liczba < 0) {
                slowne += "minus ";
                liczba = -liczba;
            }
            int a = liczba / dziesiatki;
            if (a > 0) {
                if (a > 1) slowne += liczebniki[0][a];
                slowne += liczebniki[7][a];
            }
            boolean czyJeden=false;
            for (int i = 6; i >= 4; i--) {
                czyJeden=false;
                liczba = liczba % dziesiatki;//10^3x
                dziesiatki /= 10;//10^3x-1
                // System.out.println(liczba +"wartosc liczby w ifie 1-synkowym");
                //System.out.println(liczba/(dziesiatki/10)+"  "+liczba/(dziesiatki/100));
                if (liczba / (dziesiatki / 10) == 0 && liczba / (dziesiatki / 100) == 1) {
                    //  System.out.println(liczba +"wartosc liczby w ifie 1-synkowym");
                    slowne += liczebniki[i][0];//1 milion
                    czyJeden=true;
                }
                a = liczba / dziesiatki;
                if (a > 0) {//setki milionów
                    slowne += liczebniki[3][a];
                }
                liczba = liczba % dziesiatki;
                dziesiatki /= 10;//10^3x-2
                a = liczba / dziesiatki;
                liczba = liczba % dziesiatki;
                dziesiatki /= 10;//10^3x-3
                int b = liczba / dziesiatki;
                if (a == 1) {//nastki milionów
                    slowne += liczebniki[1][b] + liczebniki[i][2];
                } else if (a > 0) {//dziesiatki milionów
                    slowne += liczebniki[2][a];
                    if (b != 0) slowne += liczebniki[0][b];
                    if (b >= 2 && b <= 4) slowne += liczebniki[i][1];
                    else slowne += liczebniki[i][2];
                } else if (b > 1 || (b==1 && !czyJeden )) {
                    slowne += liczebniki[0][b];
                    if (b >= 2 && b <= 4) slowne += liczebniki[i][1];
                    else slowne += liczebniki[i][2];
                }

            }
            return slowne;
            //System.out.println(slowne);
        }

    }

    public static void main(String[] args) throws NumberFormatException {

        for (String arg : args) {
            try {
                Integer liczba = new Integer(arg);
                String slowne =wypisywanie(liczba);
                System.out.println(slowne);
            } catch (Exception e) {
                System.err.println("Błąd konwersji argumentu do liczby z zakresu int");
            }
        }
    }
}
