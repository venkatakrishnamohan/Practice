
public class Test3 {
	
	public String formatString(String s, int k) {
		StringBuilder ans = new StringBuilder("");
		s = s.replace("-","");
		int end = s.length();
		while(end-k>0) {
			StringBuilder stb = new StringBuilder(s.substring(end-k, end));
			ans = ans.append(stb.reverse()).append("-");
			end = end-k;
		}
		StringBuilder s2 = new StringBuilder(s.substring(0,end));
		ans = ans.append(s2.reverse());
		return ans.reverse().toString().toUpperCase();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "BADD12-4A0r7-4k";
		Test3 t = new Test3();
		String ans = t.formatString(s, 3);
		System.out.println(ans);
	}

}
