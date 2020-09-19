package com.elliotknuth;

public interface Command {
	public void execute();
	public void undo(); 
}
