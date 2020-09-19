package com.elliotknuth;

public class DesignRemove implements Command {
	Piece piece;
	Store store;
	
	private DesignRemove() {}
	
	public DesignRemove(Store store) {
		this.store = store;
		this.piece = store.getCurrentPiece();
	}
	@Override
	public void execute() {
		if (piece.getPieceType() != "Raw Clay") {
			if (piece.getDesign() != "None") {
				System.out.println("Now cleaning the piece off");
				piece.setDesign("None");
				store.setUndoCommand(this);
				System.out.println("The piece is now clean\n");
			} else {
				System.out.println("There is no design on the piece.\n");
			}		
		}
	}

	@Override
	public void undo() {
		if (piece.getPieceType() != "Raw Clay") {
			if (piece.getDesign() == "None") {
				System.out.println("Repainting the design of Butterflies back on the " + piece.getPieceType());
				piece.setDesign("Butterflies");
				System.out.println("The Butterflies are back on the piece.\n");
			} else {
				System.out.println("Sorry, there is already a design on the piece.\n");
			}
		}
	}

}
