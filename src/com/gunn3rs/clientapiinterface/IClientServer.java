package com.gunn3rs.clientapiinterface;

public interface IClientServer{
	
	public static final String DEFAULT_IP = "0.0.0.0";
	public static final int DEFAULT_PORT = 10001;
	
	public boolean connectToServer();
	public boolean sendRequestToServer();
	public void forwardResponse();

}
