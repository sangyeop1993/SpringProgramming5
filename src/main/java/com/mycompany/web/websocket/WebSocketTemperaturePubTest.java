package com.mycompany.web.websocket;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WebSocketTemperaturePubTest {
	public static void main(String[] args) throws Exception {
		MqttClient client = new MqttClient("tcp://localhost:1882", MqttClient.generateClientId(), null);
		client.connect();
		for(int i=0;i<30;i+=1) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("msgid", "temperature");
			jsonObject.put("value", ""+i);
			String json = jsonObject.toString();
			client.publish("/drone/websocket/sub", json.getBytes(), 0, false);
			Thread.sleep(1000);
		}
	}
}
