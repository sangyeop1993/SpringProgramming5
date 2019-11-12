package com.mycompany.web.service;

import java.util.Date;
import java.util.Random;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
public class Ch11MqttPubTest {
	public static void main(String[] args) throws Exception {
		MqttClient client = new MqttClient("tcp://localhost:1882", MqttClient.generateClientId(), null);
		client.connect();
		Random random = new Random();
		for(int i=0;i<60;i+=1) {
			JSONArray jsonArray = new JSONArray();
			jsonArray.put(new Date().getTime());
			jsonArray.put((double)random.nextInt(300)/10);
			String json = jsonArray.toString();
			client.publish("/drone/chart/pub", json.getBytes(), 0, false);
			Thread.sleep(1000);
		}
	}
}
