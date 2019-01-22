import java.util.Arrays;

public class QuickSort {
	
	public void qs(int[] a,int low, int high) {
		if(low<high) {
			int p = partition(a,low,high);
			qs(a,low,p-1);
			qs(a,p+1,high);
		}
	}
	
	public int partition(int[] a,int low,int high) {
		int pivot = a[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(a[j]<=pivot) {
				i+=1;
				int t = a[j];
				a[j] = a[i];
				a[i] = t;
			}
		}
		int t = a[high];
		a[high] = a[i+1];
		a[i+1] = t;
		return i+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,3,1,4};
		QuickSort q = new QuickSort(); 
		q.qs(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}

}
