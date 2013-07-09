package com.gunn3rs.user;

import java.io.Serializable;
import java.util.HashMap;
import com.gunn3rs.fileinfo.FileInfo;
import com.gunn3rs.client.*;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2713120203604976112L;
	private int id;
	private boolean isMe;
	private String userName;
	private boolean active;
	private HashMap<String, FileInfo> sharedFiles;
	private String ip;
	private int listeningPort;

	public User() {
		this.isMe = true;
	}

	public User(Client client) {
		this.isMe = false;
		this.active = true;
		this.ip = client.getIpConnected();
		this.listeningPort = client.getPortConnected();
		this.sharedFiles = new HashMap<String, FileInfo>();
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the listeningPort
	 */
	public int getListeningPort() {
		return listeningPort;
	}

	/**
	 * @param listeningPort
	 *            the listeningPort to set
	 */
	public void setListeningPort(int listeningPort) {
		this.listeningPort = listeningPort;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the isMe
	 */
	public boolean isMe() {
		return isMe;
	}

	/**
	 * @param isMe
	 *            the isMe to set
	 */
	public void setMe(boolean isMe) {
		this.isMe = isMe;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the sharedFiles
	 */
	public HashMap<String, FileInfo> getSharedFiles() {
		return sharedFiles;
	}

	/**
	 * @param sharedFiles
	 *            the sharedFiles to set
	 */
	public void setSharedFiles(HashMap<String, FileInfo> sharedFiles) {
		this.sharedFiles = sharedFiles;
	}

	public Client userToClient() {
		return new Client(userName);
	}
}
