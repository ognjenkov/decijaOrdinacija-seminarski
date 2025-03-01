/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author ognje
 */
public class Server extends Thread {

    boolean kraj = false;
    ServerSocket serverSocket;

    //TODO ove klijente ces da premestis u kontroler
    public Server() {
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9000);
            while (!kraj) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Klijent je povezan");

                    ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(socket);
                    controller.Controller.getInstance().getUsers().add(okz);
                    okz.start();
                } catch (SocketException e) {
                    // ovaj exception se desi kada ugasim server a .accept() je ukjucen, u prevodu ceka a ja ga gasim tokom cekanja to baci exception
                    if (kraj) {
                        System.out.println("Server is shutting down...");
                        break; // Exit the loop cleanly
                    }
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zaustaviServer() {
        kraj = true;
        //TODO ovde ces da prekines vezu sa svim klijentima iz liste u kontroleru
        //TODO tako sto ces da pozoves metodu iz obzz.zaustavi
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close(); // This will break the `accept()` call
            }

            List<ObradaKlijentskihZahteva> usersCopy = new ArrayList<>(controller.Controller.getInstance().getUsers());
            for (ObradaKlijentskihZahteva k : usersCopy) {
                System.out.println("diskonektovanje usera prilikom zaustaviserver");
                k.disconnect();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
