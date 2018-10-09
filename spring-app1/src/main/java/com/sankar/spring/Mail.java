package com.sankar.spring;

public class Mail {
	
		private String toAddress;
		private String fromAddress;
		private Message message;
		
		//default constructor is not defined.. So it will be available automatically
		
		public String getToAddress() {
			return toAddress;
		}
		public void setToAddress(String toAddress) {
			this.toAddress = toAddress;
		}
		public String getFromAddress() {
			return fromAddress;
		}
		public void setFromAddress(String fromAddress) {
			this.fromAddress = fromAddress;
		}
		public Message getMessage() {
			return message;
		}
		public void setMessage(Message message) {
			this.message = message;
		}
		
		
		

}
