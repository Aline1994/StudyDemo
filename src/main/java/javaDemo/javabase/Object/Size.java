package javaDemo.javabase.Object;

public enum Size {
	SMALL("S"),MEDIUM("M"),EXTRA_LARGE("XL");
	
	private String aaa;
	private Size(String aaa) {
		this.aaa = aaa;
	}
	
	public String getAaa() {
		return aaa;
	}
}
