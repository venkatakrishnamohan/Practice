import java.util.Arrays;

public class CountSort {
	
	public int[] cs(int[] a) {
		int[] c = new int[10];
		Arrays.fill(c, 0);
		for(int i=0;i<a.length;i++) {
			c[a[i]]+=1;
		}
		for(int i=1;i<c.length;i++) {
			c[i] = c[i-1]+c[i];
		}
		int[] ans = new int[a.length];
		Arrays.fill(ans, -1);
		for(int i=0;i<a.length;i++) {
			ans[c[a[i]]-1] = a[i];
			c[a[i]]-=1;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountSort cs = new CountSort();
		int[] arr = {1,4,6,8,1,3,7};
		int[] ans = cs.cs(arr);
		System.out.println(Arrays.toString(ans));
	}

}
