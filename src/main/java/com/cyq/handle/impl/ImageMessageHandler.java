package com.cyq.handle.impl;

import org.springframework.stereotype.Service;

import com.cyq.handle.FileMessageHandler;

@Service("imageMessageHandler")
public class ImageMessageHandler implements FileMessageHandler {

	@Override
	public void handleMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println(this + " handle message " + message);
	}

}
