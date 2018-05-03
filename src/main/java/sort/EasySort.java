package sort;
/**
 * 快速选择排序：找到最小的
 * @author zhuxiu
 *
 */
public class EasySort {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("neibulei"+i);
				}
		}});
		int []c= {7,4,6,3,2};
		getSort(c);
		for(int i:c) {
			System.out.print(i);
		}
		System.out.println();
	}
	public static void getSort(int []c) {
		for(int i=0;i<c.length;i++) {
			int min=i;
			for(int j=i+1;j<c.length;j++) {
				if(c[min]>c[j]) {
					int tmp=0;
					tmp=c[min];
					c[min]=c[j];
					c[j]=tmp;
				}
			}
		}
	}
}
