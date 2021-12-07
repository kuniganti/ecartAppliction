package com.ecart.order.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Image {
	private String imagePath;
	private short length;
	private short breadth;
	public Image(String fileName, short length, short breadth) {
		this.imagePath = fileName;
		this.length = length;
		this.breadth = breadth;
	}
	public Image() {
	}
	@Override
	public String toString() {
		return "Image [fileName=" + imagePath + ", length=" + length + ", breadth=" + breadth + "]";
	}
	
	
}
