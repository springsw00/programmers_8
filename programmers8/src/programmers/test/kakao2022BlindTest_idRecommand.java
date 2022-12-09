package programmers.test;


public class kakao2022BlindTest_idRecommand {
	public static void main(String[] args) {
		//solution("...!@BaT#*..y.abcdefghijklm");
		//solution("=.=");
		//solution("123_.def");
		solution("abcdefghijklmn.p");
		solution("ba");
	}
	
	public static String solution(String new_id) {
		String answer = "";
        
		answer = new_id.toLowerCase();
		answer = answer.replaceAll("[^a-z\\d-_.]", "");
		answer = answer.replaceAll("\\.{2,}", ".");
		if(answer.startsWith(".")) answer = answer.substring(1);
		if(answer.endsWith(".")) answer = answer.substring(0, answer.length()-1);
		if(answer.isEmpty()) answer = "a";
		
		if(answer.length() > 15) answer = answer.substring(0, 14);
		if(answer.endsWith(".")) answer = answer.substring(0, answer.length()-1);
		
		if(answer.length() < 3) {
			char lastChar = answer.charAt(answer.length()-1);
			for(int i=0; i<=3-answer.length(); i++) {
				answer = answer.concat(String.valueOf(lastChar));
			}
		}
        
		System.out.println(answer);
        return answer;
	}
}
