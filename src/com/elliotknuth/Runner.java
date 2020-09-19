package com.elliotknuth;

import java.util.ArrayList;

public class Runner {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		
		PieceForm formPiece = new PieceForm(store);
		PieceRecycle recyclePiece = new PieceRecycle(store);
		DesignAdd addDesign = new DesignAdd(store);
		DesignRemove removeDesign = new DesignRemove(store);
		CartAdd addToCart = new CartAdd(store);
		CartRemove removeFromCart = new CartRemove(store);
		
		Command[] orderPiece = {formPiece, addDesign, addToCart};
		Command[] revertPiece = {removeFromCart, removeDesign, recyclePiece};
		Macro orderPieceMacro = new Macro(orderPiece);
		Macro revertPieceMacro = new Macro(revertPiece);
		
		store.setCommand(0, orderPieceMacro, revertPieceMacro);
		System.out.println("Storefront ordering a piece\n-----");
		store.addButtonWasPushed(0);
		System.out.println("Storefront is removing the piece\n-----");
		store.removeButtonWasPushed(0);

	}

}
