/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
    List<ObradaKlijentskihZahteva> klijenti;

    //TODO ove klijente ces da premestis u kontroler
    public Server() {
        klijenti = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9000);
            while (!kraj) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent je povezan");
                
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(socket);
                okz.start();
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
            for (ObradaKlijentskihZahteva k : klijenti) {
                k.prekini();
            }
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
