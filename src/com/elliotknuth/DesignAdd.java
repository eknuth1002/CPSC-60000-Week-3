package com.elliotknuth;

public class DesignAdd implements Command {
	Piece piece;
	Store store;
	
	private DesignAdd() {}
	
	public DesignAdd(Store store) {
		this.store = store;
		this.piece = store.getCurrentPiece();
	}

	@Override
	public void execute() {
		if (piece.getPieceType() != "Raw Clay") {
			if (piece.getDesign() == "None") {
				System.out.println("Painting the design of Butterflies on the " + piece.getPieceType());
				piece.setDesign("Butterflies");
				store.setUndoCommand(this);
				System.out.println("The piece now has Butterflies painted on it.\n");
			} else {
				System.out.println("Sorry, there is already a design on the piece.\n");
			}	
		}
	}

	@Override
	public void undo() {
		if (piece.getPieceType() != "Raw Clay") {
			if (piece.getDesign() != "None") {
				System.out.println("Now cleaning the piece off");
				piece.setDesign("None");
				System.out.println("The piece is now clean.\n");
			} else {
				System.out.println("The piece is already clean.\n");
			}		
		}
	}
}
