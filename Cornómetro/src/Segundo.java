import java.util.concurrent.Semaphore;

public class Segundo implements Runnable {
    int numerador;
    //int minutoCont;
    Semaphore segundo;
    Semaphore minuto;


    public Segundo(Semaphore segundo, Semaphore mintuo, int numerador){
        this.segundo = segundo;
        this.minuto = mintuo;
        this.numerador = numerador;
    }

    public int getNumerador(){
        return numerador;
    }
    public void setNumerador(int numerador){
        this.numerador = numerador;
    }

    @Override
    public void run(){
        while (true){
            try {
                segundo.acquire();
                if (numerador != 59){
                    numerador++;
                    System.out.println(numerador + " Segundo");
                    Thread.sleep(100);
                    segundo.release();
                }
                else{
                    numerador = 0;
                    //minutoCont++;
                    //System.out.println(minutoCont + " Minuto");
                    segundo.release();
                    minuto.release();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
