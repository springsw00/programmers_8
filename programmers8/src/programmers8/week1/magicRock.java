package programmers8.week1;


public class magicRock {
	public static void main(String[] args) {
		/*System.out.println(solution(16));	//6
		System.out.println(solution(2554));	//16
		System.out.println(solution(2900));	//4
		System.out.println(solution(9900));	//2
*/		//System.out.println(solution(109900));	//3
		//System.out.println(solution(8));	//3
		System.out.println(solution(111000));	//3
	}
	
	public static int solution(int storey) {
        int answer = 0;
        
        // 자리수 구하기
        String str = String.valueOf(storey);
        int leng = str.length(); 
        //System.out.println(leng);
        
        boolean plusCheck = false;
        while(leng-1 >= 0) {
        	int nowNum = Integer.parseInt(str.substring(leng-1, leng));
        	if(plusCheck) nowNum += 1;
        	System.out.println("idx:"+leng+"/nowNum::"+nowNum);
        	
        	if(nowNum % 10 == 0 && leng-1 == 0){
        		//System.out.println("2::"+nowNum);
        		answer += 1;
        		plusCheck = false;
        	}else if(nowNum >=5) {
        		//System.out.println("1::"+(10 - nowNum));
        		answer = answer + 10 - nowNum;
        		plusCheck = true;
        	}else if(nowNum == 0){
        		plusCheck = false;
        	}else {
        		plusCheck = false;
        		//System.out.println("3::"+nowNum);
        		answer += nowNum;
        	}
        	leng--;
        }
        
        if(plusCheck) answer++;
        
        return answer;
    }
}
