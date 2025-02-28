/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.Dete;
import domain.Doktor;
import domain.PredskolskoDete;
import domain.Recept;
import domain.SkolskoDete;
import domain.StavkaRecepta;
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
    
    public void disconnect() {
        try {
            if (sender != null) {
//                sender.close(); 
                sender = null;
            }
            if (receiver != null) {
//                receiver.close();
                receiver = null;
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException ex) {
            System.out.println("Error closing socket: " + ex.getMessage());
        } finally {
            socket = null;
            sender = null;
            receiver = null;
            instance = null; // Allow reconnection with a new instance
        }
    }

    public Doktor login(int id, String email) {
        Doktor d = new Doktor(id, email);
        Request req = new Request(Operation.LOGIN, d);
        System.out.println("LOGIN komunikacija request SENT");
        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("LOGIN komunikacija response RECEIVED");

        d = (Doktor) res.getPayload();

        return d;
    }
    
    public boolean logout() {
//        Request req = new Request(Operation.LOGOUT, null);
    return true;
    }

    public List<Dete> ucitajDecu() {
        List<Dete> lista = new ArrayList<>();
        Request req = new Request(Operation.UCITAJ_DECU, null);
        System.out.println("UCITAJ DECU komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("UCITAJ DECU komunikacija response RECEIVED");

        lista = (List<Dete>) res.getPayload();

        return lista;
    }

    public void obrisiDete(Dete dete) throws Exception {
        Request req = new Request(Operation.OBRISI_DETE, dete);
        System.out.println("OBRISI DETE komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("OBRISI DETE komunikacija response RECEIVED");

        if (res.getPayload() == null) {
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
        System.out.println("DODAJ DETE komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("DODAJ DETE komunikacija response RECEIVED");

        if (res.getPayload() == null) {
            System.out.println("USPEH");
//            cordinator.Cordinator.getInstance().osveziFormuPrikazDece();
        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri brisanju deteta");
        }
    }

    public void izmeniDete(Dete dete) throws Exception {
        Request req = new Request(Operation.IZMENI_DETE, dete);
        System.out.println("IZMENI DETE komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("IZMENI DETE komunikacija response RECEIVED");

        if (res.getPayload() == null) {
            System.out.println("USPEH");
//            cordinator.Cordinator.getInstance().osveziFormuPrikazObrazovanja();
        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri azuriranju deteta");
        }
    }

    public List<Recept> ucitajRecepte() {
        List<Recept> lista = new ArrayList<>();
        Request req = new Request(Operation.UCITAJ_RECEPTE, null);
        System.out.println("UCITAJ RECEPTE komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("UCITAJ RECEPTE komunikacija response RECEIVED");

        lista = (List<Recept>) res.getPayload();

        return lista;
    }

    public List<StavkaRecepta> ucitajStavke(int idRecept) {
        List<StavkaRecepta> lista = new ArrayList<>();
        Request req = new Request(Operation.UCITAJ_STAVKE, idRecept);
        System.out.println("UCITAJ STAVKE komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("UCITAJ STAVKE komunikacija response RECEIVED");

        lista = (List<StavkaRecepta>) res.getPayload();

        return lista;
    }

    public void izmeniPredskolskoDete(PredskolskoDete predskolskoDete) throws Exception {
        Request req = new Request(Operation.IZMENI_PREDSKOLSKODETE, predskolskoDete);
        System.out.println("IZMENI PREDSKOLSKODETE komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("IZMENI PREDSKOLSKODETE komunikacija response RECEIVED");

        if (res.getPayload() == null) {
            System.out.println("USPEH");
            cordinator.Cordinator.getInstance().osveziFormuPrikazObrazovanja();
        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri azuriranju predskolskog deteta");
        }

    }

    public void dodajPredskolskoDete(PredskolskoDete predskolskoDete) throws Exception {
        Request req = new Request(Operation.DODAJ_PREDSKOLSKODETE, predskolskoDete);
        System.out.println("DODAJ predskolskoDete komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("DODAJ predskolskoDete komunikacija response RECEIVED");

        if (res.getPayload() == null) {
            System.out.println("USPEH");
            cordinator.Cordinator.getInstance().osveziFormuPrikazObrazovanja();

        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri dodavanjju preskolskog deteta");
        }
    }

    public void izmeniSkolskoDete(SkolskoDete skolskoDete) throws Exception {
        Request req = new Request(Operation.IZMENI_SKOLSKODETE, skolskoDete);
        System.out.println("IZMENI skolskoDete komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("IZMENI skolskoDete komunikacija response RECEIVED");

        if (res.getPayload() == null) {
            System.out.println("USPEH");
            cordinator.Cordinator.getInstance().osveziFormuPrikazObrazovanja();
        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri azuriranju skolskoDete");
        }
    }

    public void dodajSkolskoDete(SkolskoDete skolskoDete) throws Exception {
        Request req = new Request(Operation.DODAJ_SKOLSKODETE, skolskoDete);
        System.out.println("DODAJ skolskoDete komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("DODAJ skolskoDete komunikacija response RECEIVED");

        if (res.getPayload() == null) {
            System.out.println("USPEH");
            cordinator.Cordinator.getInstance().osveziFormuPrikazObrazovanja();

        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri dodavanjju skolskoDete deteta");
        }
    }

    public List<PredskolskoDete> ucitajPredskolskuDecu() {
        List<PredskolskoDete> lista = new ArrayList<>();
        Request req = new Request(Operation.UCITAJ_PREDSKOLSKUDECU, null);
        System.out.println("UCITAJ UCITAJ_PREDSKOLSKUDECU komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("UCITAJ UCITAJ_PREDSKOLSKUDECU komunikacija response RECEIVED");

        lista = (List<PredskolskoDete>) res.getPayload();

        return lista;
    }

    public List<SkolskoDete> ucitajSkolskuDecu() {
        List<SkolskoDete> lista = new ArrayList<>();
        Request req = new Request(Operation.UCITAJ_SKOLSKUDECU, null);
        System.out.println("UCITAJ ucitajSkolskuDecu komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("UCITAJ ucitajSkolskuDecu komunikacija response RECEIVED");

        lista = (List<SkolskoDete>) res.getPayload();

        return lista;
    }

    public void obrisiSkolskoDete(SkolskoDete skolskoDete) throws Exception {
        Request req = new Request(Operation.OBRISI_SKOLSKODETE, skolskoDete);
        System.out.println("OBRISI_SKOLSKODETE komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("OBRISI_SKOLSKODETE komunikacija response RECEIVED");

        if (res.getPayload() == null) {
            System.out.println("USPEH");
        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri brisanju skolskog deteta");
        }
    }

    public void obrisiPredskolskoDete(PredskolskoDete predskolskoDete) throws Exception {
        Request req = new Request(Operation.OBRISI_PREDSKOLSKODETE, predskolskoDete);
        System.out.println("OBRISI_PREDSKOLSKODETE komunikacija request SENT");

        sender.send(req);
        Response res = (Response) receiver.receive();
        System.out.println("OBRISI_PREDSKOLSKODETE komunikacija response RECEIVED");

        if (res.getPayload() == null) {
            System.out.println("USPEH");
        } else {
//            TODO mozes da implementiras kod deleta moze da dodje greska da ima constraint u bazi i to da ispises u poruci
            System.out.println("GRESKA");
            ((Exception) res.getPayload()).printStackTrace();
            throw new Exception("greska pri brisanju predskolskog deteta");
        }
    }

    public void obrisiRecept(Recept recept) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void obrisiStavkuRecepta(StavkaRecepta stavkaRecepta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
