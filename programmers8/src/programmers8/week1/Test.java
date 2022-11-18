package programmers8.week1;

public class Test {
	public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIndex = 0;
        int current =1;
        //answer= stations.length;
       /* while(current <= n) {
        	if((current >= stations[stationIndex] - w) && stationIndex < stations.length) {
        		current = stations[stationIndex] + w + 1;
        		stationIndex++;
        	}else {
        		answer++;
        		current += (w*2+1);
        	}
        }*/
        /*for(int current =1; current <= n; current++){
        	//System.out.println(current);
        	if((current >= stations[stationIndex] - w) && current <= stations[stationIndex]+w) {
        		current = stations[stationIndex] + w;
        		stationIndex++;
        	}else {
        		answer++;
        		
        		current += (w*2);
        	}
        }*/
        
		while (current <= n) {
			if (stationIndex < stations.length && current >= stations[stationIndex] - w) {
				current = stations[stationIndex] + w + 1;
				stationIndex++;
			} else {
				current += 2 * w + 1;
				answer++;
			}
		}

        return answer;
    }
	
	public static void main(String[] args) {
		int[] array = {4,11};
		System.out.println(solution(11,array,1));
		
		int[] array2 = {9};
		System.out.println(solution(16,array2,2));
	}
}
