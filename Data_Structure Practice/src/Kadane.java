
public class Kadane {
	
	public int maxsubarray(int[] a) {
		if(a.length>=1) {
		int maxsofar = Integer.MIN_VALUE;
		int minprefix = 1;
		int b = 1;
		for(int i=0;i<a.length;i++) {
			b = b*a[i];
			if(b < minprefix) {
				minprefix = b;
			}
			if(b-minprefix > maxsofar ) {
				maxsofar = b/minprefix;
			}
		}
		return maxsofar;
		}
		else {
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kadane k = new Kadane();
		int[] a = {-2,0,-1,2,5};
		int m = k.maxsubarray(a);
		System.out.println(m);
	}

}
