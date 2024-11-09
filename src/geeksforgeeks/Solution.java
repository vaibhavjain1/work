package geeksforgeeks;

import java.util.ArrayList;

public class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    public static void main(String[] args) {
        ArrayList list = subarraySum(new int[]{1,2,3,4,5,6,7,8,9,10}, 10, 15);
        System.out.println(list.get(0)+" "+ list.get(1));
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {

        ArrayList<Integer> list = new ArrayList<>();

        if(n==1){
            if(s==arr[0]){
                list.add(1);
                list.add(1);
                return list;
            }
            else{
                list.add(-1);
                return list;
            }
        }

        int beginIndex = 0;
        int endIndex = beginIndex + 1;
        int sum = 0;
        while(beginIndex < n && endIndex < n){
            if(sum == s) {
                sum =-1;
                break;
            }
            if(sum > s) {
                sum = sum - arr[beginIndex];
                beginIndex ++;
            }
            else if(sum < s) {
                endIndex ++;
                if(endIndex == n){
                    sum = -1;
                    break;
                }

                sum = sum + arr[endIndex];
            }

        }


        if(sum == -1)
        {
            list.add(beginIndex);
            list.add(endIndex);
        }
        else {
            list.add(-1);
        }
        return list;
    }
}
