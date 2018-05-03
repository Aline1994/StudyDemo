package Singleton;
/**
 * 单例模式是指确保某个类只有一个实例
 * 必须自行创建这个实例
 * 必须能够向整个系统提供这个实例
 * 
 * 单例模式分为懒汉模式和饱汉模式
 * @author zhuxiu
 *
 */

public class Singleton {
	//1.懒汉单例模式
	//优势：类加载速度快，运行时获取对象的速度比较慢
	/**
	 * 关键点：构造函数定义为私有，只能自身获取对象
	 * 		成员变量定义为静态，保证自身类获取自身对象
	 * 		public保证公开，synchronize保证多线程时的正确性
	 */
	private static Singleton  single = null;
	private Singleton() {}
	
	public static synchronized Singleton getSingleton() {
		if(single == null) {
			single = new Singleton();
		}
		return single;
	}
	//双重检查锁定方法
	public static Singleton getSynDoubleSingleton() {
		if(single == null) {
			synchronized(Singleton.class) {
				if(single == null) {
					single = new Singleton();
				}
			}
		}
		return single;
	}
	
	//2.饿汉单例模式
	
	private static Singleton single2 = new  Singleton();
	public static Singleton getEagerSingleton() {
		return single2;
	}
}
