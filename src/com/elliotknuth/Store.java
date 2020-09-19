package com.elliotknuth;

import java.util.ArrayList;

public class Store {
	Command[] addCommands;
	Command[] removeCommands;
	Command undoCommand;
	private final int totalNumOfcommands = 3;
	private Piece currentPiece; 
	private ArrayList<Piece> cart;
	
	public Store() {
		addCommands = new Command[totalNumOfcommands];
		removeCommands = new Command[totalNumOfcommands];
 
		Command noCommand = new NoCommand();
		for(int i=0 ; i < totalNumOfcommands ; i++) {
			addCommands[i] = noCommand;
			removeCommands[i] = noCommand;
		}
		undoCommand = noCommand;
		currentPiece = new Piece();
		cart = new ArrayList<Piece>();
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		addCommands[slot] = onCommand;
		removeCommands[slot] = offCommand;
	}
 
	public void addButtonWasPushed(int slot) {
		addCommands[slot].execute();
		undoCommand = addCommands[slot];
	}
 
	public void removeButtonWasPushed(int slot) {
		removeCommands[slot].execute();
		undoCommand = removeCommands[slot];
	}
	
	public void setUndoCommand(Command undoCommand) {
		this.undoCommand = undoCommand;
	}

	public void undoButtonWasPushed() {
		undoCommand.undo();
		undoCommand = new NoCommand();
	}

	public void setCurrentPiece(Piece piece) {
		if (piece != null) {
			currentPiece = piece;
		}
	}
 
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("Commands for the Store:\n");
		for (int i = 0; i < addCommands.length; i++) {
			stringBuff.append("Commands for item " + i + ": " + addCommands[i].getClass().getName()
				+ " & " + removeCommands[i].getClass().getName() + "\n");
		}
		stringBuff.append("Current undo command: " + undoCommand.getClass().getName() + "\n");
		return stringBuff.toString();
	}

	public Piece getCurrentPiece() {
		return currentPiece;
	}

	public ArrayList<Piece> getCart() {
		return cart;
	}
}
