/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domain.Dete;
import domain.Doktor;
import domain.Lek;
import domain.PredskolskoDete;
import domain.Recept;
import domain.SkolskoDete;
import domain.StavkaRecepta;
import java.io.EOFException;
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

    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private boolean kraj = false;
    private Doktor user;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        try {

            while (!kraj) {
                Request req = (Request) receiver.receive();
                if (req == null) {
                    break;
                }
                Response res = new Response();

                if (req.getOperation() == Operation.LOGIN) {
                    Doktor d = (Doktor) req.getPayload();
                    System.out.println("Login operacija sa doktorom: " + d.toString());
                    d = Controller.getInstance().login(d);
                    user = d;
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
                } else if (req.getOperation() == Operation.UCITAJ_RECEPTE) {
                    System.out.println("Ucitaj recepte operacija");
                    List<Recept> recepti = Controller.getInstance().ucitajRecepte();
                    res.setPayload(recepti);
                } else if (req.getOperation() == Operation.UCITAJ_STAVKE) {
                    System.out.println("Ucitaj stavke operacija");
                    List<StavkaRecepta> stavke = Controller.getInstance().ucitajStavke((int) req.getPayload());
                    res.setPayload(stavke);
                } else if (req.getOperation() == Operation.DODAJ_PREDSKOLSKODETE) {
                    System.out.println("DODAJ_PREDSKOLSKODETE operacija");
                    try {
                        PredskolskoDete dete = (PredskolskoDete) req.getPayload();
                        Controller.getInstance().dodajPredskolskoDete(dete);
                        res.setPayload(null);

                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.IZMENI_PREDSKOLSKODETE) {
                    System.out.println("IZMENI_PREDSKOLSKODETE operacija");
                    try {
                        PredskolskoDete dete = (PredskolskoDete) req.getPayload();
                        Controller.getInstance().izmeniPredskolskoDete(dete);
                        res.setPayload(null);

                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.DODAJ_SKOLSKODETE) {
                    System.out.println("Dodaj DODAJ_SKOLSKODETE operacija");
                    try {
                        SkolskoDete dete = (SkolskoDete) req.getPayload();
                        Controller.getInstance().dodajSkolskoDete(dete);
                        res.setPayload(null);

                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.IZMENI_SKOLSKODETE) {
                    System.out.println("Ixmeni IZMENI_SKOLSKODETE operacija");
                    try {
                        SkolskoDete dete = (SkolskoDete) req.getPayload();
                        Controller.getInstance().izmeniSkolskoDete(dete);
                        res.setPayload(null);

                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.UCITAJ_SKOLSKUDECU) {
                    System.out.println("Ucitaj UCITAJ_SKOLSKUDECU operacija");
                    List<SkolskoDete> skolskaDeca = Controller.getInstance().ucitajSkolskuDecu();
                    res.setPayload(skolskaDeca);
                } else if (req.getOperation() == Operation.UCITAJ_PREDSKOLSKUDECU) {
                    System.out.println("Ucitaj UCITAJ_PREDSKOLSKUDECU operacija");
                    List<PredskolskoDete> predskolskaDeca = Controller.getInstance().ucitajPredskolskuDecu();
                    res.setPayload(predskolskaDeca);
                } else if (req.getOperation() == Operation.OBRISI_PREDSKOLSKODETE) {
                    System.out.println("Obrisi OBRISI_PREDSKOLSKODETE operacija");

                    try {
                        PredskolskoDete predskolskoDete = (PredskolskoDete) req.getPayload();
                        Controller.getInstance().obrisiPredskolskoDete(predskolskoDete);
                        res.setPayload(null);
                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.OBRISI_SKOLSKODETE) {
                    System.out.println("Obrisi OBRISI_SKOLSKODETE operacija");

                    try {
                        SkolskoDete skolskoDete = (SkolskoDete) req.getPayload();
                        Controller.getInstance().obrisiSkolskoDete(skolskoDete);
                        res.setPayload(null);
                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.UCITAJ_LEKOVE) {
                    System.out.println("Ucitaj UCITAJ_LEKOVE operacija");
                    List<Lek> lekovi = Controller.getInstance().ucitajLekove();
                    res.setPayload(lekovi);

                } else if (req.getOperation() == Operation.DODAJ_RECEPT) {
                    System.out.println("Dodaj DODAJ_RECEPT operacija");
                    try {
                        StavkaRecepta sr = (StavkaRecepta) req.getPayload();
                        Controller.getInstance().dodajRecept(sr);
                        res.setPayload(null);

                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.OBRISI_RECEPT) {
                    System.out.println("Obrisi OBRISI_RECEPT operacija");

                    try {
                        Recept recept = (Recept) req.getPayload();
                        Controller.getInstance().obrisiRecept(recept);
                        res.setPayload(null);
                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.DODAJ_STAVKURECEPTA) {
                    System.out.println("Dodaj DODAJ_STAVKURECEPTA operacija");
                    try {
                        StavkaRecepta sr = (StavkaRecepta) req.getPayload();
                        Controller.getInstance().dodajStavkuRecepta(sr);
                        res.setPayload(null);

                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.OBRISI_STAVKURECEPTA) {
                    System.out.println("Obrisi OBRISI_STAVKURECEPTA operacija");

                    try {
                        StavkaRecepta stavkaRecepta = (StavkaRecepta) req.getPayload();
                        Controller.getInstance().obrisiStavkuRecepta(stavkaRecepta);
                        res.setPayload(null);
                    } catch (Exception e) {
                        res.setPayload(e);
                    }
                } else if (req.getOperation() == Operation.LOGOUT) {
                    disconnect();
                } else {
                    System.out.println("greska ta operacije ne postoji");
                }

                if (res.getPayload() != null && res.getPayload().toString() != null) {
                    System.out.println("response sent :" + res.getPayload().toString());
                }
                System.out.println("RESPONSE SENT!");
                sender.send(res);

            }
        } catch (EOFException e) {
            System.out.println("Client disconnected.");
        } catch (Exception ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            sender.send(new Response((boolean) true));

            this.kraj = true;

            socket.close();

            synchronized (Controller.getInstance().getUsers()) {
                Controller.getInstance().getUsers().remove(this);
            }

            interrupt();

        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public void prekini() {
//        //todo ovo promeni da je malo lepse kao sto si radio na ultu
//        try {
//            kraj = true;
//            socket.close();
//            interrupt();
////            
////            synchronized (Server.getInstance().getUsers()) {
////                Server.getInstance().getUsers().remove(this);
////            }
//        } catch (IOException ex) {
//            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public Doktor getUser() {
        return user;
    }

    public void setUser(Doktor user) {
        this.user = user;
    }

}
