/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package network;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author ognje
 */
public class Sender {
    public Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public void send(Object obj) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(obj);
            oos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                
    }
    
}



/*
public class Sender {
    private Socket socket;
    private ObjectOutputStream oos;

    public Sender(Socket socket) throws IOException {
        this.socket = socket;
        this.oos = new ObjectOutputStream(socket.getOutputStream());
    }

    public void send(Object obj) {
        try {
            oos.writeObject(obj);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        try {
            if (oos != null) {
                oos.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
*/
