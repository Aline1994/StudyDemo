package sort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = {3,5,7,4,3,2,1,9};
		bubbleSortStren(a);
		for(int s:a) {
			System.out.print(s);
		}
	}
	//��ͨ��ð������
	public static void bubbleSort(int [] notSort) {
		int i,j;
		for(i=0;i<notSort.length-1;i++) {
			for(j=0;j<notSort.length-1-i;j++) {
				if(notSort[j]>notSort[j+1]) {
					notSort[j]^=notSort[j+1];
					notSort[j+1]^=notSort[j];
					notSort[j]^=notSort[j+1];
				}
			}
		}
	}
	
	/*
	 * ð�ݵĸĽ���
	 */
	public static void bubbleSortStren(int [] notSort) {
		int i,j;
		boolean flag = true;//�ж��Ƿ�����˽���
		for(i=0;i<notSort.length-1&&flag;i++) {
			flag = false;
			for(j=0;j<notSort.length-1-i;j++) {
				if(notSort[j]>notSort[j+1]) {
					notSort[j]^=notSort[j+1];
					notSort[j+1]^=notSort[j];
					notSort[j]^=notSort[j+1];
					flag = true;
				}
			}
		}
	}
}
