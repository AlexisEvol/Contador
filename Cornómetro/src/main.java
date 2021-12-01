import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Semaphore;

public class main {
    public static void main(String[] args) throws InterruptedException {

        String pathSegundos = "src/Segundo.java";



        Semaphore segundo = new Semaphore(1);// 1 es abierto y 0 es cerrado
        Semaphore minuto = new Semaphore(0);
        Semaphore hora = new Semaphore(0);

        Segundo segundos = new Segundo(segundo, minuto, 0);
        Minuto minutos = new Minuto(minuto, hora, 0);
        Hora horas = new Hora(hora, 0);

        Thread hiloSegundos = new Thread(segundos);
        Thread hiloMinutos = new Thread(minutos);
        Thread hiloHoras = new Thread(horas);

        hiloSegundos.start();
        hiloMinutos.start();
        hiloHoras.start();
    }
}
