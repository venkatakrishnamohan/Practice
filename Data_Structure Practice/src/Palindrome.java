import java.util.Arrays;

public class Palindrome {
	
	public boolean pal(String s) {
		if(s.length() == 1 || s.length() == 0) {
			return true;
		}
		else {
			if(s.charAt(0) == s.charAt(s.length()-1)) {
				return pal(s.substring(1, s.length()-1));
			}
			else {
				return false;
			}
		}
	}
	
	public void map(int[] a) {
		if(a.length == 1) {
			System.out.println(a[0]+1);
		}
		else {
			map(Arrays.copyOfRange(a, 0, a.length-1));
			System.out.println(a[a.length-1]+1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome p = new Palindrome();
		System.out.println(p.pal("ab"));
		int[] a = {1,2,3,4,5,6};
		p.map(a);
	}

}
