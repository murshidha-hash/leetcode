class even {
    public int findNumbers(int[] nums) {
    int count=0;
    for(int i=0;i<nums.length;i++){
    int sum= String.valueOf(Math.abs(nums[i])).length();
    if(sum%2==0){
        count++;
     }
    } 
     return count;

    }
}