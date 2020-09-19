package com.elliotknuth;

import java.util.ArrayList;

public class CartAdd implements Command {
	private ArrayList<Piece> cart;
	private Store store;
	private Piece piece;
	
	private CartAdd() {}
	
	public CartAdd(Store store) {
		this.store = store;
		this.cart = store.getCart();
		this.piece = store.getCurrentPiece();
	}
	
	@Override
	public void execute() {
		System.out.println("Adding the " + piece.getPieceType() + " to the cart.");
		cart.add(piece);
		store.setUndoCommand(this);
		System.out.println("The piece is added.\n");
	}

	@Override
	public void undo() {
		if (cart.contains(piece)) {
			System.out.println("Removing the " + piece.getPieceType() + " to the cart.");
			cart.remove(piece);
			piece = null;
			System.out.println("The piece is removed.\n");
		} else {
			System.out.println("That piece isn't in the cart.\n");
		}
		
	}

}
