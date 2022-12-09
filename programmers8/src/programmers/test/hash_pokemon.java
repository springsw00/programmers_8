package programmers.test;

import java.util.*;
import java.util.stream.Collectors;

public class hash_pokemon {
	public static void main(String[] args) {
		solution(new int[] {3,1,2,3});	//2
		solution(new int[] {3,3,3,2,2,4});	//3
	}
	
	public static int solution(int[] nums) {
        int answer = 0;
        
        List<Integer> numList = Arrays.stream(nums).distinct().boxed().collect(Collectors.toList());
        
        System.out.println(numList.toString());
        
        if(nums.length/2 < numList.size()) answer = nums.length/2;
        else answer = numList.size();
        
        return answer;
	}
}
