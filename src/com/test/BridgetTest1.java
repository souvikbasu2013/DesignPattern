package com.test;

interface IColor{
	public void writeInColor();
}

class RedColor implements IColor{
	@Override
	public void writeInColor() {
		// TODO Auto-generated method stub
		System.out.println(" Color is Red..");
	}
}

class BlueColor implements IColor{
	@Override
	public void writeInColor() {
		// TODO Auto-generated method stub
		System.out.println(" Color is Blue..");
	}
}

abstract class IPens{
	protected IColor color;
	public IPens(IColor color) {
		this.color = color;
	}
	abstract void writeByPen();
}

class BallPen extends IPens{
	
	public BallPen(IColor color) {
		super(color);
	}
	@Override
	public void writeByPen() {
		// TODO Auto-generated method stub
		System.out.println("writing with ball pen...");
		color.writeInColor();
	}
}

class SketchPen extends IPens{
	
	public SketchPen(IColor color) {
		super(color);
	}
	@Override
	public void writeByPen() {
		// TODO Auto-generated method stub
		System.out.println("writing with sketh pen...");
		color.writeInColor();
	}
}

class InkPen extends IPens{
	
	public InkPen(IColor color) {
		super(color);
	}
	@Override
	public void writeByPen() {
		// TODO Auto-generated method stub
		System.out.println("writing with ink pen...");
		color.writeInColor();
	}
}

public class BridgetTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPens ballPen = new BallPen(new RedColor());
		ballPen.writeByPen();
		
		IPens inkPen = new InkPen(new BlueColor());
		inkPen.writeByPen();
		
		IPens sketchPen = new SketchPen(new RedColor());
		sketchPen.writeByPen();
	}

}
