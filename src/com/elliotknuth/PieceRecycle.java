package com.elliotknuth;

public class PieceRecycle implements Command {
	Piece piece;
	Store store;
	
	private PieceRecycle() {}
	
	public PieceRecycle(Store store) {
		this.store = store;
		this.piece = store.getCurrentPiece();
	}

	@Override
	public void execute() {
		System.out.println("The " + piece.getPieceType() + " is being recycled.");
		piece.recycle();
		store.setUndoCommand(this);
		System.out.println("The piece is now a ball of clay.\n");
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		System.out.println("Remaking the piece");
		piece.create();
		System.out.println("The " + piece.getPieceType() + " is remade.\n");
	}
}
