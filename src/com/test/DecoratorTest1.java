package com.test;

interface IBeverages{
	public double cost();
}

class Coffee implements IBeverages{
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		System.out.println(" Coffee cost -");
		return 5.0;
	}
}

class Tea implements IBeverages{
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		System.out.println(" Tea cost -");
		return 3.0;
	}
}


class BeverageDecorator implements IBeverages{
	protected IBeverages brevarages;
	
	public BeverageDecorator(IBeverages brevarages) {
		this.brevarages= brevarages;
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.brevarages.cost();
	}
	
}

class MilkDecorator extends BeverageDecorator{
	
	public MilkDecorator(IBeverages brevarages) {
		super(brevarages);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.brevarages.cost() + 1.0;
	}
	
}

class SugarDecorator extends BeverageDecorator{
	
	public SugarDecorator(IBeverages brevarages) {
		super(brevarages);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.brevarages.cost() + 1.5;
	}
	
}

public class DecoratorTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBeverages Beverages = new MilkDecorator(new BeverageDecorator(new Tea()));
		System.out.println(Beverages.cost());
		
		IBeverages Beverages2 = new SugarDecorator(new BeverageDecorator(new Coffee()));
		System.out.println(Beverages2.cost());
		
		IBeverages Beverages3 = new MilkDecorator(new SugarDecorator(new BeverageDecorator(new Coffee())));
		System.out.println(Beverages3.cost());
		
		
	}

}
