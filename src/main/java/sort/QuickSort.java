package sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = { 3, 5, 7, 4, 3, 2, 1, 9 };
		quickSort(a, 0, a.length - 1);
		for (int s : a) {
			System.out.print(s);
		}
	}

	public static void quickSort(int a[], int left, int right) {
		if (left < right) {
			int i = left;
			int j = right;
			int x = a[left];
			while (i < j) {
				while (i < j && a[j] >= x)
					j--;

				a[i] = a[j];

				while (i < j && a[i] < x)
					i++;

				a[j] = a[i];
			}
			a[i] = x;
			quickSort(a, left, i - 1);
			quickSort(a, i + 1, right);
		}

	}


}
