import java.util.ArrayList;

public class DiceRoll {
	
	public void printcombs(int n, int sum) {
		ArrayList<Integer> chosen = new ArrayList<>();
		int sumsofar = 0;
		printcombsHelper(n, chosen, sum, sumsofar);
	}
	
	public void printcombsHelper(int n, ArrayList<Integer> chosen, int sum, int sumsofar) {
		if(sumsofar == sum) {
			System.out.println(chosen.toString());
		}
		else if(n==0) {
			return;
		}
		else {
			for(int i=1;i<6;i++) {
				if(sumsofar+i+(n-1)*6>=sum && sumsofar+i+1*(n-1)<=sum) {
				chosen.add(i);
				printcombsHelper(n-1,chosen,sum, sumsofar+i);
				//sumsofar = sumsofar - chosen.get(chosen.size()-1);
				chosen.remove(chosen.size()-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiceRoll d = new DiceRoll();
		d.printcombs(3,5);
	}

}
