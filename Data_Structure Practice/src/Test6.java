
public class Test6 {
	    public int removeDuplicates(int[] nums) {
	        int i=0;
	        int j=0;
	        while(i<nums.length){
	            if(nums[i] == nums[j]){
	                i+=1;
	            }
	            else{
	                j+=1;
	                int temp = nums[i];
	                nums[i] = nums[j];
	                nums[j] = temp;
	                i+=1;
	            }
	        }
	        for(int k=0;k<nums.length;k++) {
	        	System.out.println(nums[k]);
	        }
	        return j+1;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test6 t = new Test6();
		int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
		System.out.println("------------");
		System.out.println(t.removeDuplicates(nums));
		
	}

}
