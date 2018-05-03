package javaDemo.extendss;

class Animal{
	private String desc;
	
	public Animal() {
		this.desc = getDesc();
	}
	public String getDesc() {
		return  "Animal";
	}
	public String toString() {
		return getDesc();
	}
}
public class Wolf extends Animal{
	private String name;
	private double weight;
	
	public Wolf(String name,double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getDesc() {
		return name+weight;
	}
	public static void main(String[] args) {
		Wolf wolf = new Wolf("kaka",67);
		System.out.println(wolf);
		
	}
}
