import java.util.concurrent.Semaphore;

public class Hora implements  Runnable{

    Semaphore hora;
    int numerador;

    public Hora(Semaphore hora, int numerador){
        this.hora = hora;
        this.numerador = numerador;
    }

    @Override
    public void run() {
        while (true){
            try {
                hora.acquire();
                if (numerador != 23){
                    numerador++;
                    System.out.println(numerador + " hora");
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }    }
}
