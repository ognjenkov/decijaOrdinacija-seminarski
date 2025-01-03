/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.Operation;
import network.Receiver;
import network.Request;
import network.Response;
import network.Sender;

/**
 *
 * @author ognje
 */
public class ObradaKlijentskihZahteva extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;
    boolean kraj = false;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while (!kraj) {
            Request req = (Request) receiver.receiveRequest();
            Response res = new Response();

            if(req.getOperation() == Operation.LOGIN) {
                System.out.println("login");
            } else {
                System.out.println("greska ta operacije ne postoji");
            }
            
            sender.sendResponse(res);
            
        }
    }
    
    public void prekini() {
        //todo ovo promeni da je malo lepse kao sto si radio na ultu
        try {
            kraj = true;
            socket.close();
            interrupt();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
