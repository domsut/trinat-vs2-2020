package ch.trinat.edu.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TippDesTagesServer {
    String[] tips = {"Geben Sie Vollgas", "Leben Sie jeden Tag als waere dieser Ihrer letzter", "Unmoeglich! Gibt es nicht", "Seien Sie ehrlich, nur heute mal. Sagen Sie Ihrem Boss, was Sie *wirklich* denken.", "Geben Sie jeden Tag Ihr Bestes"};

    public void los() {

        try (ServerSocket serverSock = new ServerSocket(4242)) {

            while(true) {
                Socket sock = serverSock.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String tipp = getTipp();
                writer.println(tipp);
                writer.close();
                System.out.println(tipp);
            }

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    } // los() schliessen

    private String getTipp() {
        int random = (int) (Math.random() * tips.length);
        return tips[random];
    }

    public static void main(String[] args) {
        TippDesTagesServer server = new TippDesTagesServer();
        server.los();
    }
}
