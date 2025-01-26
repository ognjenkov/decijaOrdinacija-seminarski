/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.Dete;
import domain.Doktor;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
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
public class Communication {

    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    private static Communication instance;

    private Communication() {

    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public void connection() {
        try {
            socket = new Socket("localhost", 9000);
            sender = new Sender(socket);
            receiver = new Receiver(socket);
        } catch (IOException ex) {
            System.out.println("server nije povezan");
        }
    }

    public Doktor login(int id, String email) {
        Doktor d = new Doktor(id, email);
        Request req = new Request(Operation.LOGIN, d);

        sender.sendResponse(req);
        Response res = (Response) receiver.receiveRequest();

        d = (Doktor) res.getPayload();

        return d;
    }

    public List<Dete> ucitajDecu() {
        List<Dete> lista = new ArrayList<>();
        Request req = new Request(Operation.UCITAJ_DECU, null);

        sender.sendResponse(req);
        Response res = (Response) receiver.receiveRequest();

        lista = (List<Dete>) res.getPayload();
        
        return lista;
    }

    public void obrisiDete(Dete dete) throws Exception {
        Request req = new Request(Operation.OBRISI_DETE, dete);
        sender.sendResponse(req);
        Response res = (Response) receiver.receiveRequest();
        if(res.getPayload() == null) {
            System.out.println("USPEH");
        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri brisanju deteta");
        }
    }

    public void dodajDete(Dete dete) throws Exception {
        Request req = new Request(Operation.DODAJ_DETE, dete);
        sender.sendResponse(req);
        Response res = (Response) receiver.receiveRequest();
        if(res.getPayload() == null) {
            System.out.println("USPEH");
        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri brisanju deteta");
        }
    }
    
    public void izmeniDete(Dete dete) throws Exception {
        Request req = new Request(Operation.IZMENI_DETE, dete);
        sender.sendResponse(req);
        Response res = (Response) receiver.receiveRequest();
        if(res.getPayload() == null) {
            System.out.println("USPEH");
            cordinator.Cordinator.getInstance().osveziFormuPrikazDece();
        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri azuriranju deteta");
        }
    }
}
