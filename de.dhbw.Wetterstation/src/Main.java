import java.util.Timer;
import java.util.TimerTask;

/**
 * Wetterdaten-Programm
 *
 * Für die Vorlesung "Verteilte Systeme"
 * an der DHBW Karlsruhe
 */

public class Main extends TimerTask{
    private static Wetterstation kappelrodeck;

    public static void main(String[] Arguments){
        kappelrodeck = new Wetterstation();

        /* Erfasse und Sende Wetterdaten alle 5 Sekunden */
        Timer timer = new Timer();
        timer.schedule(new Main(), 0, 5000);
    }

    public void run(){
        System.out.println(kappelrodeck.getMesswerte());
    }

}
