package javaDemo.extendss;

class Price{
	
	public static final Price instance = new Price(2.8);
	public static final double initPrice = 20;
	 double curentPrice ;
	
	public Price(double discount) {
		curentPrice = initPrice - discount;
	}
	
}
public class PriceTest {
	public static void main(String[] args) {
		System.out.println(Price.instance.curentPrice);
	}

}
