package com.example.demo11.constants;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

	private Object data;
	private Integer statusCode;
	private String message;
	private ResponseStatus status;

	public Response(Object data, Integer statusCode, String string, ResponseStatus failed) {
		super();
		this.data = data;
		this.statusCode = statusCode;
		this.message = string;
		this.status = failed;
	}

	public Response() {
		super();
	}

}
