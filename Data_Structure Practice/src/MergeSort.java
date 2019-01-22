import java.util.Arrays;

public class MergeSort {
	
	public void ms(int[] a,int low,int high) {
		if(low < high){
			int h = (low+high)/2;
			ms(a,low,h);
			ms(a,h+1,high);
			merge(a,low,h,high);
		}
	}

	public void merge(int[] a,int low, int mid, int high) {
		int i=0;
		int j=0;
		int[] b = new int[mid-low+1];
		int[] c = new int[high-mid];
		for(int x=0;x<b.length;x++) {
			b[x] = a[low+x];
		}
		for(int x=0;x<b.length;x++) {
			c[x] = a[mid+1+x];
		}
		int k=low;
		while(i<mid-low+1 && j<high-mid) {
			if(b[i]<=c[j]) {
				a[k] = b[i];
				i+=1;
				k+=1;
			}
			else {
				a[k] = c[j];
				j+=1;
				k+=1;
			}
		}
		while(i<mid-low+1) {
			a[k] = b[i];
			i+=1;
			k+=1;
		}
		while(j<high-mid) {
			a[k] = c[j];
			j+=1;
			k+=1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,1,4,3};
		MergeSort m = new MergeSort();
		m.ms(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
