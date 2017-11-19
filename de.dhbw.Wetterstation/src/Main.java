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

    private Wetterstation kappelrodeck = null;
    private static DatagramSocket socket = null;
    private InetAddress address = null;

    private byte[] buffer;

    public Main() {
        super();
        kappelrodeck = new Wetterstation();

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

    }

    public static void main(String[] Arguments){
        Runtime.getRuntime().addShutdownHook(new ShutDownHook());

        /* Erfasse und Sende Wetterdaten alle 5 Sekunden */
        Timer timer = new Timer();
        timer.schedule(new Main(), 0, 500);
    }

    public void run(){
        String message = kappelrodeck.getMesswerte();
        System.out.println(message);

        buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 7134);

        try {
            socket.send(packet);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Konnte Packet nicht versenden!", e);
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