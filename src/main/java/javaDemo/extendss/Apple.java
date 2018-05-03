package javaDemo.extendss;

class Fruit{
	String color = "未确定颜色";
	
	public Fruit getThis() {
		return this;
	}
	public void info() {
		System.out.println("Fruit方法");
	}
}
public class Apple extends Fruit{
	String color = "红色";
	public void info() {
		System.out.println("Apple方法");
	}
	public Fruit getSuper() {
		return super.getThis();
	}
	public void getAccessSuperInfo() {
		super.info();
	}
	public static void main(String[] args) {
		Apple a = new Apple();
		Fruit f = a.getSuper();
		
		System.out.println(a==f);
		System.out.println(a.color);
		System.out.println(f.color);
		
		a.info();
		f.info();
		
		a.getAccessSuperInfo();
	}
}
