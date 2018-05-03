package Singleton;
/**
 * ����ģʽ��ָȷ��ĳ����ֻ��һ��ʵ��
 * �������д������ʵ��
 * �����ܹ�������ϵͳ�ṩ���ʵ��
 * 
 * ����ģʽ��Ϊ����ģʽ�ͱ���ģʽ
 * @author zhuxiu
 *
 */

public class Singleton {
	//1.��������ģʽ
	//���ƣ�������ٶȿ죬����ʱ��ȡ������ٶȱȽ���
	/**
	 * �ؼ��㣺���캯������Ϊ˽�У�ֻ�������ȡ����
	 * 		��Ա��������Ϊ��̬����֤�������ȡ�������
	 * 		public��֤������synchronize��֤���߳�ʱ����ȷ��
	 */
	private static Singleton  single = null;
	private Singleton() {}
	
	public static synchronized Singleton getSingleton() {
		if(single == null) {
			single = new Singleton();
		}
		return single;
	}
	//˫�ؼ����������
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
	
	//2.��������ģʽ
	
	private static Singleton single2 = new  Singleton();
	public static Singleton getEagerSingleton() {
		return single2;
	}
}
