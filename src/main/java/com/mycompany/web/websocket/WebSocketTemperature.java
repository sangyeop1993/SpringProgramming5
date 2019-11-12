package com.mycompany.web.websocket;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketTemperature extends TextWebSocketHandler {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketTemperature.class);
	
	private List<WebSocketSession> list = new ArrayList<>();
	/*
	public WebSocketTemperature() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				for(int i=0;i<30;i+=1) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("msgid", "temperature");
					jsonObject.put("value", ""+i);
					String json = jsonObject.toString();
					List<WebSocketSession> cloned = new ArrayList<>(list);
					for(WebSocketSession wss: cloned) {
						TextMessage message = new TextMessage(json);
						try {
							wss.sendMessage(message);
							Thread.sleep(1000);
						} catch (Exception e) {}
					}
				}
			}
		};
		thread.start();
	}
	*/
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.debug(session.getId()+"가 접속되었습니다.");
		list.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.debug(session.getId()+"가 접속이 끊어졌습니다.");
		list.remove(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String json = message.getPayload();
		logger.debug(json);
	}
	//-----------------------------------------------------------------------------------------
	
	public WebSocketTemperature() {
		mqttConnect();
	}
	
	private MqttClient client;
	
	private void mqttConnect() {
		try {
			client = new MqttClient("tcp://localhost:1882", MqttClient.generateClientId(), null);
	        client.connect();
	        receiveMessage();
	        logger.info("MQTT Brokcer Connect Success");
		} catch(Exception e) {}
	}
	   
	private void mqttDisConnect() {
		try {
			client.disconnectForcibly(1);
	        client.close(true);
	        logger.info("MQTT Brokcer DisConnect");
	    } catch(Exception e) {}
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
		        List<WebSocketSession> cloned = new ArrayList<>(list);
		        for(WebSocketSession wss: cloned) {
		        	TextMessage msg = new TextMessage(json);
		        	try {
						wss.sendMessage(msg);
						Thread.sleep(1000);
					} catch (Exception e) {}
				}
		        logger.info(json);
		    }

		    @Override
		    public void deliveryComplete(IMqttDeliveryToken token) {
		    }
		         
		});
		client.subscribe("/drone/websocket/sub");
	}
	public void sendMessage(String topic, String message) {
		try {
			client.publish(topic, message.getBytes(), 0, false);
		} catch (Exception e) {}
	}  
}
