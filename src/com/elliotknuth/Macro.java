package com.elliotknuth;

public class Macro implements Command {
	private Command[] commands;
	
	private Macro() {}
	
	public Macro(Command[] commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		for (Command c : commands) {
			c.execute();
		}
	}

	@Override
	public void undo() {
		for (Command c : commands) {
			c.undo();
		}
	}

}
