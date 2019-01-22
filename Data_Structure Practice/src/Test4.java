import java.util.Arrays;
import java.util.HashMap;

public class Test4 {

	
	public int get_frequent(String[] L) {
		HashMap<String, Integer> map= new HashMap<String, Integer>();
		int max=0;
		if(L==null || L.length == 0) {
			return 0;
		}
		for(int i=0;i<L.length;i++) {
			int ind = L[i].lastIndexOf('@');
			String local = L[i].substring(0, ind);
			String domain = L[i].substring(ind, L[i].length());
			String[] locals = local.split("\\+");
			if(locals.length == 0) {
				local = "";
			}
			if(locals.length !=0) {
				local = locals[0].replace(".","");
			}
			String formatted = local+domain;
			System.out.println(formatted);
			if(!map.containsKey(formatted)) {
				map.put(formatted, 1);
				if(max<1) {
					max=1;
				}
			}
			else {
				map.computeIfPresent(formatted, (k,v) -> v+1);
				if(map.get(formatted) > max) {
					max = map.get(formatted);
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test4 t = new Test4();
		String[] L = {"+@gmail.com", "+drgdh@gmail.com", "+fd.dfv.d@gmail.com", "...+@gmail.com"};
		int ans = t.get_frequent(L);
		System.out.println(ans);
		String[] a = "+@gmail.com".split("\\+");
		System.out.println(a[0]);
		System.out.println("test");
		}

}
