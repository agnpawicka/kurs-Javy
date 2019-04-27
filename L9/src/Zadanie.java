import java.util.TimerTask;

public class Zadanie extends TimerTask {
    private Plansza plansza;
    public Zadanie(Plansza plansza){
        this.plansza=plansza;
    }
    @Override
    public void run(){
        plansza.odswiez();
        //System.out.println("sialalala");
    }
}
