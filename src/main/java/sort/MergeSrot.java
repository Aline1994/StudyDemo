package sort;

public class MergeSrot {
	public static void main(String[] args) {
		int[] a = {3,5,7,4,3,2,1,9};
		merge(a);
		for(int s:a) {
			System.out.print(s);
		}
	}
	
	public static void merge(int a[]) {
		int[] temp = new int[a.length];
		sort(a,0,a.length-1,temp);
	}
	public static  void sort(int a[],int l,int r,int[]temp) {
		
		if(l<r) {
			int mid = (r+l)/2;
			sort(a,l,mid,temp);//��߅�w������ʹ������������
			sort(a,mid+1,r,temp);//��߅���x��ʹ������������
			merge(a,l,mid,r,temp);
		}
		
	}
	public static void merge(int[]a,int l,int mid,int r,int[]temp) {
				int i = l;
				int j = mid+1;
				int k = 0;
		
				while(i<=mid&&j<=r) {
					if(a[i]<a[j]) {
						temp[k++]=a[i++];
					}else {
						temp[k++]=a[j++];
					}
				}
				while(i<=mid) {
					temp[k++]=a[i++];
				}
				while(j<=r) {
					temp[k++]=a[j++];
				}
				//���ź���Ĕ��M��ؐ�oԭ���M
				
				k = 0;
				while(l<=r) {
					a[l++]=temp[k++];
				}
			}
	public static void swap(int a, int b) {
		a ^= b;
		b ^= a;
		a ^= b;
	}
}
