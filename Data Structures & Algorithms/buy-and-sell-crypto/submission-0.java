class Solution {
    public int maxProfit(int[] prices) {
        int l = 0,r= 1,maxP = 0;
        while(r<prices.length){
            if(prices[r]>prices[l]){
            int profit = prices[r] - prices[l];
            maxP = Math.max(maxP,profit);
            }else{
                l=r;
            } 
            r++;
        }
       return maxP;
    }
}
