package com.elliotknuth;

public class PieceForm implements Command {
	Piece piece;
	Store store;
	
	private PieceForm() {}
	
	public PieceForm(Store store) {
		this.store = store;
		this.piece = store.getCurrentPiece();
		
	}

	@Override
	public void execute() {
		System.out.println("Making the piece");
		piece.create();
		store.setUndoCommand(this);
		System.out.println("The " + piece.getPieceType() + " is made.\n");
	}

	@Override
	public void undo() {
		System.out.println("Undoing the creation of the " + piece.getPieceType());
		piece.recycle();
		System.out.println("The piece has been reduced to a ball of clay.\n");
	}

}
