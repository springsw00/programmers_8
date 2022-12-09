package programmers.test;

import java.util.*;

public class kakao2022BlindTest {
	public static void main(String[] args) {
		//[2,1,1,0]
		solution(new String[] {"muzi", "frodo", "apeach", "neo"}, new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
        List<String> idArrayList = new ArrayList<>(Arrays.asList(id_list));
        Map<String, ArrayList<String>> reportMap = new HashMap<>();
        for(String id:id_list) {
        	reportMap.put(id, new ArrayList<>());
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            answer[i]=0;
        }
        
        for(String rep:report) {
        	String reporter = rep.split(" ")[0];
        	String badPerson = rep.split(" ")[1];
        	
        	ArrayList<String> idReport = reportMap.get(badPerson);
        	if(!idReport.contains(reporter)) idReport.add(reporter);
        }
        
        reportMap.entrySet().stream().filter(item -> item.getValue().size() >= k)
        	.forEach(item -> item.getValue()
        		.forEach(i -> answer[idArrayList.indexOf(i)]++));
        System.out.println(reportMap.toString());
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
