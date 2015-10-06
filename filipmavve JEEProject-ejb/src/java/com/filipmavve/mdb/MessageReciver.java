/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Filip
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MessageReciver implements MessageListener {
    
    public MessageReciver() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage text = (TextMessage) message;
        try {
            System.out.println("Got message: " + text.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
}
