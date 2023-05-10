package com.test;

interface Ipen{
	public void writeByPen();
}

class Pen implements Ipen{
	@Override
	public void writeByPen() {
		// TODO Auto-generated method stub
		System.out.println("writing with pen...");
	}
}
interface Ipencil{
	public void writeByPencil();
}

class WriteAdapter implements Ipen{
	
	private Ipencil pencil;
	
	public WriteAdapter(Ipencil pencil) {
		this.pencil = pencil;
	}
	@Override
	public void writeByPen() {
		// TODO Auto-generated method stub
		this.pencil.writeByPencil();
	}
	
}

class Pencil implements Ipencil{
	@Override
	public void writeByPencil() {
		// TODO Auto-generated method stub
		System.out.println("writing with pencil...");
	}
}

public class AdapterTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ipen pen = new Pen();
		pen.writeByPen();
		
		Ipen pen1 = new WriteAdapter(new Pencil());
		pen1.writeByPen();
		
	}

}
