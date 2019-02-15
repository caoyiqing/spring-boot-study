package com.cyq.handle.impl;

import org.springframework.stereotype.Service;

import com.cyq.handle.NormalMessageHandler;

@Service("textMessageHandler")
public class TextMessageHandler implements NormalMessageHandler {

	@Override
	public void handleMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println(this + " handle message " + message);
	}

}
