import java.util.concurrent.Semaphore;

public class Minuto implements  Runnable{

    Semaphore hora;
    Semaphore minuto;
    int numerador;

    public Minuto(Semaphore minuto, Semaphore hora, int numerador){
        this.hora = hora;
        this.minuto = minuto;
        this.numerador = numerador;
    }

    @Override
    public void run() {
        while (true){
            try {
                minuto.acquire();
                if (numerador != 59){
                    numerador++;
                    System.out.println(numerador + " minuto");
                    Thread.sleep(1000);
                }
                else{
                    numerador = 0;
                    System.out.println(numerador + " Hora");
                    hora.release();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
