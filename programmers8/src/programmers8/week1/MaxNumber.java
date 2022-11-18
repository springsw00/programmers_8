package programmers8.week1;

import java.util.*;

public class MaxNumber {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[]{6,10,2}));
		System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
	}
	
	public static String solution(int[] numbers) {
        String answer = "";
        
        // int -> string 형변환
        List<String> strArray = new ArrayList<String>();
        for(int a:numbers) {
        	strArray.add(String.valueOf(a));
        }
        
        // 내림차순정렬
        strArray.sort((str1, str2)->{return (str2+str1).compareTo(str1+str2);});
       
        //System.out.println(String.join("", strArray));
        
        answer = String.join("", strArray);
        
        if(answer.startsWith("0")) answer = "0";
        
        return answer;
    }

}
