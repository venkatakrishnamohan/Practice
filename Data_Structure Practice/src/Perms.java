
public class Perms {

	public void strperm(String s) {
		String chosen = "";
		strpermhelper(s, chosen);
	}
	int c = 0;
	public void strpermhelper(String s, String chosen){
		if(s.length() == 0) {
			System.out.println(chosen);
			c++;
		}
		else {
			for(int i=0;i<s.length();i++) {
				chosen = chosen + s.charAt(i);
				s = s.substring(0, i)+s.substring(i+1, s.length());
				strpermhelper(s,chosen);
				char c = chosen.charAt(chosen.length()-1);
				chosen = chosen.substring(0, chosen.length()-1);
				s = s.substring(0, i)+c+s.substring(i, s.length());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Krishna";
		Perms p = new Perms();
		p.strperm(s);
		System.out.println(p.c);
	}

}
