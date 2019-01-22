
public class Choose {
	
	public void printChoose(String s, int k) {
		String chosen = "";
		printChoosehelper(s,k,chosen);
	}
	int c=0;
	public void printChoosehelper(String s, int k, String chosen) {
		if(chosen.length() == k) {
			System.out.println(chosen);
			return;
		}
		//if(s.length() ==0) {
		//	System.out.println(chosen);;
		//}
		if(s.length() == 0) {
			return;
		}
		else {
			char c = s.charAt(0);
			chosen = chosen+c;
			s = s.substring(1, s.length());
			printChoosehelper(s,k,chosen);
			chosen = chosen.substring(0, chosen.length()-1);
			printChoosehelper(s,k,chosen);
			s = c+s.substring(0, s.length());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Choose c = new Choose();
		String s = "wxyz";
		int k = 2;
		c.printChoose(s,k);
		System.out.println(c.c);
	}

}
