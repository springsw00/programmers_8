package programmers.week4;

import java.util.*;


public class RegisterCourses {
	
	
	/*선후수 관계를 나타내는 배열 s1 과 s2: 
	 * 배열 s1 의 i 번째 원소가 "X" 이고 배열 s2 의 i 번째 원소가 "Y" 인 경우
	 * , 과목 "X" 가 과목 "Y" 의 선수과목임을 나타냅니다.*/
	//윤서가 수강하고자 하는 과목 코드 k
	public static String[] solution(String[] s1, String[] s2, String k) {
        String[] answer = {};
        
        Queue<String> queue = new <String>LinkedList();
        List<String> sortArray = new ArrayList<String>();
        List<String> resultArray = new ArrayList<String>();
        
        for(int i=0; i<s2.length; i++) {
        	if(s2[i].equals(k)) {
        		sortArray.add(s1[i]);
        	}
        }
        resultArray.add(k);
        Collections.sort(sortArray);
        resultArray.addAll(0,sortArray);
        
        for(String s:sortArray) {
        	queue.offer(s);
        }
        

        while(!queue.isEmpty()) {
        	String nowString = queue.poll();
//        	System.out.println("now::"+nowString);
        	
        	sortArray.clear();
        	for(int i=0; i<s2.length; i++) {
            	if(s2[i].equals(nowString)) {
            		if(resultArray.contains(s1[i])) continue;
            		sortArray.add(s1[i]);
            	}
            }
        	
        	if(sortArray.isEmpty()) continue;
        	
        	Collections.sort(sortArray);
        	for(String s:sortArray) {
            	queue.offer(s);
            }
        	
            resultArray.addAll(0,sortArray);
//            System.out.println("now:add:"+resultArray.toString());
        }
        
        
        answer= resultArray.toArray(new String[resultArray.size()]);
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"A", "E", "B", "D", "B", "H", "F", "H", "C"}
							, new String[] {"G", "C", "G", "F", "J", "E", "B", "F", "B"}
							, "B"));
	}
}
