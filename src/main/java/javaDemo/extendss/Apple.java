package javaDemo.extendss;

class Fruit{
	String color = "δȷ����ɫ";
	
	public Fruit getThis() {
		return this;
	}
	public void info() {
		System.out.println("Fruit����");
	}
}
public class Apple extends Fruit{
	String color = "��ɫ";
	public void info() {
		System.out.println("Apple����");
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
