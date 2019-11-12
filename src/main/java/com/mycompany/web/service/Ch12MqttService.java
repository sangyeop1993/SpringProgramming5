package com.mycompany.web.service;

import javax.annotation.PreDestroy;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Ch12MqttService {
   private static final Logger logger = LoggerFactory.getLogger(Ch12MqttService.class);
   private MqttClient client; 
   
   public Ch12MqttService() {
      mqttConnect();
   }
   
   private void mqttConnect() {
      try {
         client = new MqttClient("tcp://localhost:1882", MqttClient.generateClientId(), null);
         client.connect();
         receiveMessage();
         logger.info("MQTT Brokcer Connect Success");
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   private void mqttDisConnect() {
      try {
         client.disconnectForcibly(1);
         client.close(true);
         logger.info("MQTT Brokcer DisConnect");
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   @PreDestroy
   public void destroy() {
      mqttDisConnect();
      logger.info("MQTT die");
   }
   
   private void receiveMessage() throws MqttException {
      client.setCallback(new MqttCallback() {

         @Override
         public void connectionLost(Throwable cause) {
            
         }

         @Override
         public void messageArrived(String topic, MqttMessage message) throws Exception {
            byte[] arr = message.getPayload();
            String json = new String(arr);
            logger.info(json);
         }

         @Override
         public void deliveryComplete(IMqttDeliveryToken token) {
            
         }
         
      });
      client.subscribe("/drone/mqttservice/sub");
      
   }
   
   public void sendMessage(String topic, String message) {
      try {
         client.publish(topic, message.getBytes(), 0, false);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}