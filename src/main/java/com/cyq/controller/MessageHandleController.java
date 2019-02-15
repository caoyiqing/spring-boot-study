package com.cyq.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyq.handle.MessageHandler;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/messageHandle")
public class MessageHandleController {
	
	@Autowired
	@Qualifier("textMessageHandler")
	private MessageHandler textMessageHandler;
	
	@Autowired
	@Qualifier("imageMessageHandler")
	private MessageHandler imageMessageHandler;
	
	@ApiOperation(value="处理文本消息", notes="处理文本消息")
	@ApiImplicitParam(name = "message", value = "消息内容", dataType = "String")
	@ResponseBody
	@PostMapping("/handleText")
	public Object handleText(@NotNull(message = "消息内容不能为空") @RequestParam String message) {
		textMessageHandler.handleMessage(message);
		return message;
	}
	
	@ApiOperation(value="处理图片消息", notes="处理图片消息")
	@ApiImplicitParam(name = "message", value = "消息内容", dataType = "String")
	@ResponseBody
	@PostMapping("/handleImage")
	public Object handleImage(@NotNull(message = "消息内容不能为空") @RequestParam String message) {
		imageMessageHandler.handleMessage(message);
		return message;
	}

}
