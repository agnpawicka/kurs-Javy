import java.io.Serializable;

public class Mikolaj implements Serializable {
    private int N;
    private int M;
    private int MikolajX, MikolajY;
    public Mikolaj(int n, int m){
        N=n;
        M=m;
        MikolajX=(m-1)/2;//do m-1 od 0
        MikolajY=n/2;//do n od 1
    }
    public int getX(){
        return MikolajX;
    }
    public int getY(){
        return MikolajY;
    }
    public void ruchPionowy(int str){
        MikolajY+=str;
        MikolajY=(MikolajY+N)%(N);//????
        if(MikolajY==0) MikolajY=N;
    }
    public void ruchPoziomy(int str){
        MikolajX+=str;
        MikolajX=(MikolajX+M)%M;
    }
}
