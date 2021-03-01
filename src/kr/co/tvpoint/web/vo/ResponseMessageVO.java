package kr.co.tvpoint.web.vo;

public class ResponseMessageVO {
	private MessageVO message;
	private KeyboardVO keyboard;

	public MessageVO getMessage() {
		return message;
	}

	public void setMessage(MessageVO jobjText) {
		this.message = jobjText;
	}
	
	public KeyboardVO getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(KeyboardVO keyboard) {
		this.keyboard = keyboard;
	}
	

}
