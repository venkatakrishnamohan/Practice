import java.util.HashMap;

public class Test5 {
	
	public int find_min(int[] coupons) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		while(end<coupons.length) {
			//System.out.println(coupons[end]);
			if(!map.containsKey(coupons[end])) {
				map.put(coupons[end], 1);
				end = end+1;
			}
			else {
				map.put(coupons[end], map.get(coupons[end])+1);
				while(map.get(coupons[end]) > 1) {
					if(map.get(coupons[start]) == 1) {
						map.remove(coupons[start]);
					}
					else {
						map.put(coupons[start], map.get(coupons[start])-1);
					}
				start = start+1;
				}
				//System.out.println("Start");
				//System.out.println(start);
				end = end+1;
				min = (end-start+1) < min ? end-start+1 : min;
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = {5,3,4,2,3,4,5,7};
		Test5 t = new Test5();
		int x = t.find_min(c);
		System.out.println(x);
	}

}
