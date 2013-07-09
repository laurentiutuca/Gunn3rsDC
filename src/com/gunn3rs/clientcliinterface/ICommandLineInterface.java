package com.gunn3rs.clientcliinterface;

import java.util.Scanner;

public interface ICommandLineInterface {
	//TODO parameters
	public String readCommand(Scanner sc);
	public boolean solveCommand(String comm);
	

}
