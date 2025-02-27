/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package network;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author ognje
 */
public class Receiver {
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }

    public Object receive() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            return ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}

/*
public class Receiver {
    private Socket socket;
    private ObjectInputStream ois;

    public Receiver(Socket socket) throws IOException {
        this.socket = socket;
        this.ois = new ObjectInputStream(socket.getInputStream());
    }

    public Object receive() {
        try {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void close() {
        try {
            if (ois != null) {
                ois.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
*/
