import java.util.Arrays;

public class Test2 {
	
	public int[] get_ancestors(int[] A, int D) {
		int[] ans = new int[A.length];
		
		for(int i=0;i<A.length;i++) {
			int current_distance = 0;
			int current_ancestor = i;
			while(current_distance < D) {
				current_ancestor = A[current_ancestor];
				current_distance+=1;
				if(current_ancestor == -1) {
					break;
				}
			}
			ans[i] = current_ancestor;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ancestors = {-1,0,1,2,3};
		int D=2;
		Test2 t = new Test2(); 
		int[] ans = t.get_ancestors(ancestors,D);
		System.out.println(Arrays.toString(ans));
	}

}
