import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Wetterdaten-Programm
 *
 * Für die Vorlesung "Verteilte Systeme"
 * an der DHBW Karlsruhe
 */

public class Main extends TimerTask{
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static DatagramSocket socket = null;
    private static InetAddress address = null;
    private static Wetterstation kappelrodeck = null;
    private byte[] buffer;

    public Main() {
        super();


    }

    public static void main(String[] Arguments){
        Runtime.getRuntime().addShutdownHook(new ShutDownHook());

        kappelrodeck = new Wetterstation("Kappelrodeck#1");

        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            logger.log(Level.SEVERE, "Konnte Socket nicht erstellen", e);
        }

        try {
            address = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            logger.log(Level.SEVERE, "Konnte Adresse nicht verwenden", e);
        }

        /* Erfasse und Sende Wetterdaten alle 5 Sekunden */
        Timer timer = new Timer();
        timer.schedule(new Main(), 0, 500);
    }

    public void run(){
        String message = null;
        for(int i = 0; i < 3; i++) {

            if(i == 0)
                 message = kappelrodeck.messeTemperatur();
            else if (i == 1)
                message = kappelrodeck.messeLuftdruck();
            else if (i == 2)
                message = kappelrodeck.messeLuftfeuchtigkeit();

            System.out.println(message);

            buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 7134);

            try {
                socket.send(packet);
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Konnte Packet nicht versenden!", e);
            }
        }


    }

    private static class ShutDownHook extends Thread {
        @Override
        public void run(){
            socket.close();
            logger.info("Socket closed");
        }
    }
}