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

    public void sendResponse(Object obj) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(obj);
            oos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                
    }
    
}
