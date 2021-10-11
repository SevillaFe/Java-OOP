package edu.uoc.uocleaner.model;

public enum Symbol {
	CORRIDOR(' ', ""),
	DIRT('·',"dirt.png"),
	DUMPSTER ('D', "dumpster.png"),
	DUSTBALL ('@', "dustball.png"),
	VACUUM ('V', "huocver.png"),
	WALL('#',"");
	
	/** 
	 * ASCII character of the Symbol
	 */
	private char ascii;
	/**
	 * Image of the Symbol
	 */
	private String image;
	/**
	 * Parameterized constructor
	 * @param ascii - The ASCII character of the symbol.
	 * @param image - Name of the image of the symbol. 
	 */
	private Symbol(char ascii, String image) {
		this.ascii = ascii;
		this.image = image;
	}

	/**
	 * The ASCII character of the symbol (field "ascii").
	 * @return The ASCII character of the symbol.
	 */
	public char getAscii() {
		return ascii;
	}

	/**
	 * The image of the symbol (field "image").
	 * @return The image of the symbol.
	 */
	public String getImage() {
		return image;
	}
	/**
	 * Given an ASCII character, it returns the name of the symbol.
	 * @param ascii - ASCII character of the symbol.
	 * @return It returns the name of the symbol from an ASCII character.
	 */
	public static Symbol getName(char ascii) {
		if(ascii==' ') {
			return Symbol.CORRIDOR;
		}else if (ascii=='·') {
			return Symbol.DIRT;
		}else if (ascii=='D') {
			return Symbol.DUMPSTER;
		}else if (ascii=='@') {
			return Symbol.DUSTBALL;
		}else if (ascii=='V') {
			return Symbol.VACUUM;
		}else if (ascii=='#') {
			return Symbol.WALL;
		}else {
			return null;
		}	

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String s=Character.toString(ascii);
		return s;
	}


}
