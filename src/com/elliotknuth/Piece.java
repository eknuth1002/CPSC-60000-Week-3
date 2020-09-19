package com.elliotknuth;

public class Piece {
	private String type = "Raw Clay";
	private String design = "None";
	
	public void paint() {
		design = "Butterflies";
	}
	
	public void clean() {
		design = "None";
	}
	
	public void create() {
		type = "Cup";
	}
	public void recycle() {
		type = "Raw Clay";
	}
	
	public String getPieceType() {
		return type;
	}

	public String getDesign() {
		return design;
	}
	
	public void setDesign(String design) {
		if (!design.isEmpty()) {
			this.design = design;
		}
	}
	
}
