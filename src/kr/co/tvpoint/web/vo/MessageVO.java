package kr.co.tvpoint.web.vo;

public class MessageVO {
	private String text;
	private String photo;
	private String url;
	private String width;
	private String height;
	private MessageButtonVO message_button;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public MessageButtonVO getMessage_button() {
		return message_button;
	}
	public void setMessage_button(MessageButtonVO message_button) {
		this.message_button = message_button;
	}
	

}
