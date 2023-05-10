package com.test;

abstract class IPO{
	protected PaymentTerm payterm;
	IPO(PaymentTerm payterm){
		this.payterm = payterm;
	}
	
	abstract void poPay();
}

class ManualPO extends IPO{
	
	public ManualPO(PaymentTerm payterm) {
		super(payterm);
	}
	public void poPay() {
		System.out.println("Manual Po Payment -");
		payterm.paymentMode();
	}
}

class CatalogPO extends IPO{
	
	public CatalogPO(PaymentTerm payterm) {
		super(payterm);
	}
	public void poPay() {
		System.out.println("Catalog Po Payment -");
		payterm.paymentMode();
	}
}

class AutoPO extends IPO{
	
	public AutoPO(PaymentTerm payterm) {
		super(payterm);
	}
	public void poPay() {
		System.out.println("AutoPO Po Payment -");
		payterm.paymentMode();
	}
}

interface PaymentTerm{
	public void paymentMode();
}

class RecurringPayment implements PaymentTerm{
	public void paymentMode() {
		System.out.println("Monthly recurring");
	}
}

class DirectPayment implements PaymentTerm{
	public void paymentMode() {
		System.out.println("Direct cash");
	}
}

class OnlinePayment implements PaymentTerm{
	public void paymentMode() {
		System.out.println("Direct Online");
	}
}


public class BridgePattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPO manualPO = new ManualPO(new DirectPayment());
		manualPO.poPay();
		
		IPO manualPO1 = new ManualPO(new RecurringPayment());
		manualPO1.poPay();
		
		IPO catalogPO = new CatalogPO(new DirectPayment());
		catalogPO.poPay();
		
		IPO catalogPO1 = new CatalogPO(new OnlinePayment());
		catalogPO1.poPay();
		
		IPO autoPO = new AutoPO(new DirectPayment());
		autoPO.poPay();
	}

}
