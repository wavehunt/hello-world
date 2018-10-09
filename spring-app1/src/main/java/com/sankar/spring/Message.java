package com.sankar.spring;

public class Message {
	
		private String header;
		private String body;
		
		public Message(String header, String body) {
			this.header = header;
			this.body = body;
		}
		
		//as one constructor is already defined, default will NOT be created automatically
		
		public String getHeader() {
			return header;
		}

		public void setHeader(String header) {
			this.header = header;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}
				
		
}
