import java.util.Random;

public class DaneDlaLabiryntu {

    private static void potasujCiąg(int[] ciąg) {
        int indeks;
        Random random = new Random();
        for (int i = ciąg.length - 1; i > 0; i--) {
            indeks = random.nextInt(i + 1);
            if (indeks != i) {
                ciąg[indeks] ^= ciąg[i];
                ciąg[i] ^= ciąg[indeks];
                ciąg[indeks] ^= ciąg[i];
            }
        }
    }

    private int rozmiar = 0;
    private int[][] przejścia;
    private int[][] grupy;

    private int znajdźGrupę(int a, int b) {
        int x = grupy[a][b];

        if (x != a * rozmiar + b) {
            grupy[a][b] = znajdźGrupę(x / rozmiar, x % rozmiar);
        }
        return grupy[a][b];
    }
    private void zmieńGrupę(int a, int b,  int nowa){
        int x = grupy[a][b];
        if (x != a * rozmiar + b) zmieńGrupę(x / rozmiar, x % rozmiar, nowa);
        grupy[a][b]=nowa;

    }

    public DaneDlaLabiryntu(int rozmiar) {
        this.rozmiar = rozmiar;
        //przejścia będą trzymane maskami bitowymi: 0001 - można iść w górę
        //                                          0010 - można w prawo
        //                                          0100 - w dół
        //                                          1000 - w lewo
        //Jeśli jest więcej niż jedno przejście, to liczba będzie sumą przejść powyżej
        przejścia = new int[rozmiar][rozmiar];
         grupy = new int[rozmiar][rozmiar];
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                grupy[i][j] = rozmiar * i + j;
            }
        }
        int liczbaGrup = rozmiar * rozmiar;
        int liczbaKrawędzi = (rozmiar - 1) * (rozmiar) * 2;
        //
        int[] potencjalneKrawędzie = new int[liczbaKrawędzi];
        //Krawędzie będące poziomymi kreskami są ujemne...
        for (int i = 0; i < liczbaKrawędzi; i++) {
            potencjalneKrawędzie[i] = (i / 2);
            if (i % 2 == 1) potencjalneKrawędzie[i] *= -1;
        }
        //
        potasujCiąg(potencjalneKrawędzie);
        int iterator = 0;
        while (liczbaGrup > 1) {
            int wiersz1, wiersz2, kolumna1, kolumna2;
            if (potencjalneKrawędzie[iterator] < 0) {
                wiersz1 = (-potencjalneKrawędzie[iterator]) % (rozmiar - 1);
                wiersz2 = wiersz1 + 1;
                kolumna1 = (-potencjalneKrawędzie[iterator]) / (rozmiar - 1);
                kolumna2 = kolumna1;
            } else {
                wiersz1 = potencjalneKrawędzie[iterator] / (rozmiar - 1);
                wiersz2 = wiersz1;
                kolumna1 = potencjalneKrawędzie[iterator] % (rozmiar - 1);
                kolumna2 = kolumna1+1;
            }

            int gr1 = znajdźGrupę(wiersz1, kolumna1);
            int gr2 = znajdźGrupę(wiersz2, kolumna2);

            if (gr1 != gr2) {
                if(wiersz1==wiersz2){
                    if(kolumna1<kolumna2){
                        przejścia[wiersz1][kolumna1]+=2;
                        przejścia[wiersz2][kolumna2]+=8;
                    }
                    else {
                        przejścia[wiersz1][kolumna1]+=8;
                        przejścia[wiersz2][kolumna2]+=2;
                    }
                }
                else {
                    if(wiersz1<wiersz2){
                        przejścia[wiersz1][kolumna1]+=4;
                        przejścia[wiersz2][kolumna2]+=1;
                    }
                    else {
                        przejścia[wiersz1][kolumna1]+=1;
                        przejścia[wiersz2][kolumna2]+=4;
                    }
                }
                if (gr1 > gr2) zmieńGrupę(wiersz1, kolumna1,  gr2);
                else zmieńGrupę(wiersz2, kolumna2,  gr1);
                liczbaGrup--;

            }
            iterator++;
        }

    }

    public boolean czyIstniejePrzejście(int wiersz1, int kolumna1, int wiersz2, int kolumna2 ){
        if(wiersz1==wiersz2) {
            if (kolumna1 < kolumna2) return ((przejścia[wiersz1][kolumna1] & 2) > 0);
            else return ((przejścia[wiersz1][kolumna1] & 8) > 0);
        }
        else if(wiersz1<wiersz2) return ((przejścia[wiersz1][kolumna1]&4)>0);
            else return ((przejścia[wiersz1][kolumna1]&1)>0);
    }
    public String toString(){
        String mapa="";
        for(int j=0; j<rozmiar; j++)mapa+=" _";
        for (int i=0; i<rozmiar-1; i++){
            mapa+=" \n|";
            for (int j=0; j<rozmiar; j++){
                if((przejścia[i][j]&2)>0) mapa+=" |";
                else mapa+="  ";
            }
            mapa+=" |\n ";
            for (int j=0; j<rozmiar; j++){
                if ((przejścia[i][j]&8)>0)mapa+=" _";
                else mapa+="  ";
            }
        }
        mapa+=" \n|";
        for (int j=0; j<rozmiar; j++){
            if((przejścia[rozmiar-1][j]&2)>0) mapa+=" |";
            else mapa+="  ";
        }
        mapa+=" |\n";
        for(int j=0; j<rozmiar; j++)mapa+=" _";

        return  mapa;
    }
}
