/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domain.Dete;
import domain.Doktor;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
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
        try {

            while (!kraj) {
                Request req = (Request) receiver.receiveRequest();
                Response res = new Response();

                if (req.getOperation() == Operation.LOGIN) {
                    Doktor d = (Doktor) req.getPayload();
                    System.out.println("Login operacija sa doktorom: " + d.toString());
                    d = Controller.getInstance().login(d);
                    res.setPayload(d);
                } else if (req.getOperation() == Operation.UCITAJ_DECU) {
                    System.out.println("Ucitaj decu operacija");
                    List<Dete> deca = Controller.getInstance().ucitajDecu();
                    res.setPayload(deca);
                } else if (req.getOperation() == Operation.OBRISI_DETE) {
                    System.out.println("Obrisi dete operacija");

                    try {

                        Dete dete = (Dete) req.getPayload();
                        Controller.getInstance().obrisiDete(dete);
                        res.setPayload(null);

                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.DODAJ_DETE) {
                    System.out.println("Dodaj dete operacija");
                    try {
                        Dete dete = (Dete) req.getPayload();
                        Controller.getInstance().dodajDete(dete);
                        res.setPayload(null);

                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.IZMENI_DETE) {
                    System.out.println("Ixmeni dete operacija");
                    try {
                        Dete dete = (Dete) req.getPayload();
                        Controller.getInstance().izmeniDete(dete);
                        res.setPayload(null);

                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else {
                    System.out.println("greska ta operacije ne postoji");
                }

                if (res.getPayload() != null && res.getPayload().toString() != null) {
                    System.out.println("response sent :" + res.getPayload().toString());
                }
                sender.sendResponse(res);

            }
        } catch (Exception ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prekini() {
        //todo ovo promeni da je malo lepse kao sto si radio na ultu
        try {
            kraj = true;
            socket.close();
            interrupt();
//            
//            synchronized (Server.getInstance().getUsers()) {
//                Server.getInstance().getUsers().remove(this);
//            }
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
