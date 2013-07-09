package com.gunn3rs.clientcli;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.gunn3rs.clientapiinterface.IClientServer;

public class ClientServer implements IClientServer, Runnable {

	private String ip = IClientServer.DEFAULT_IP;
	private int port = IClientServer.DEFAULT_PORT;
	private boolean connected = false;
	private Socket connectionSocket;
	@SuppressWarnings("unused")
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ClientServer(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public void run() {
		connectToServer();
		// TODO part with listening
		ois = null;
		oos = null;
		
		//open outputstream
		try {
			oos = new ObjectOutputStream(connectionSocket.getOutputStream());
			oos.flush();	
		} catch (IOException e) {
			System.err.println("Some error in socket,cannot send any data");
			e.printStackTrace();
		}
		//TODO send some data on the outputstream
		
		//open inputstream
		try {
			ois = new ObjectInputStream(connectionSocket.getInputStream());
		} catch (IOException e) {
			System.err.println("Some error in socket,cannot receive any data");
			e.printStackTrace();
		}
		
	}

	@Override
	/**
	 * Connection to server with the given ip and port from constructor
	 */
	public boolean connectToServer() {
		if (connected) {
			System.err.println("You are already connected to requested server");
			return true;
		}
		try {
			connectionSocket = new Socket(ip, port);
		} catch (IOException e) {
			System.err.println("Connection unsuccesfull");
			e.printStackTrace();
			return false;
		}
		System.err.println("Connection to server was succesfull");
		this.connected = true;
		return true;
	}

	@Override
	public boolean sendRequestToServer() {
		return false;
	}

	@Override
	public void forwardResponse() {
		// TODO Auto-generated method stub

	}

}
