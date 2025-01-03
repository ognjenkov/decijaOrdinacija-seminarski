/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package network;

import java.io.Serializable;

/**
 *
 * @author ognje
 */
public class Request implements Serializable {
    private Operation operation;
    private Object payload;

    public Request() {
    }

    public Request(Operation operation, Object payload) {
        this.operation = operation;
        this.payload = payload;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
    
    
}
