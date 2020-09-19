package com.elliotknuth;

import java.util.ArrayList;

public class CartRemove implements Command {
	private ArrayList<Piece> cart;
	private Piece piece;
	private Store store;
	
	private CartRemove() {}
	
	public CartRemove(Store store) {
		this.store = store;
		this.cart = store.getCart();
		this.piece = store.getCurrentPiece();
	}

	@Override
	public void execute() {
		piece = store.getCurrentPiece(); 
		if (cart.size() > 0) {
			System.out.println("Removing the " + piece.getPieceType() + " to the cart.");
			cart.remove(piece);
			store.setUndoCommand(this);
			System.out.println("The piece is removed.\n");
		} else {
			if (cart.size() == 0){
				System.out.println("The cart is empty.\n");
			} else {
				System.out.println("There are none of that piece to remove.\n");
			}
		}
	}

	@Override
	public void undo() {
		System.out.println("Readding the piece to the cart");
		cart.add(piece);
		System.out.println("The piece is now back in the cart.\n");
	}

}
