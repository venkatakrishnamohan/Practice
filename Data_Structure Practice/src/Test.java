
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc.sd.g@2.3@b.c.d@gmail.com";
		int ind = s.lastIndexOf("@");
		System.out.println(ind);
		String prefix = s.substring(0,ind);
		String suffix = s.substring(ind,s.length());
		prefix = prefix.replace(".", "");
		System.out.println(prefix+suffix);
		int[] r = new int[5];
		r[0] = 5;
		System.out.println(r[0]);
		int x = 2 > 5 ? 2: 5;
		System.out.println(x);
	}

}
