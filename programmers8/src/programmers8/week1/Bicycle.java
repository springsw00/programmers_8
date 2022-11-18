package programmers8.week1;

public class Bicycle {
	
	public static void main(String[] args) {
		System.out.println("test1::"+solution(new int[][] {{0, 10}, {50, 20}, {100, 30}, {200, 40}},new int[][] {{3, 50}, {7, 200}, {8, 200}}));
		System.out.println("test2::"+solution(new int[][] {{0, 10}, {50, 20}},new int[][] {{3, 100}, {4, 200}}));
	}
	
	public static int solution(int[][] cost, int[][] order) {
        int answer = 0;
        int made = 0;
        int maxMonth = 0;
        int totalNeedOrder = 0;
    	for(int n=0; n<order.length;n++) {
    		int month = order[n][0];
    		totalNeedOrder += order[n][1];
    		if(month > maxMonth) maxMonth = month;
    	}
    	
    	int[] monthlyOrder = new int[maxMonth];
    	for (int[] o : order) {
            monthlyOrder[o[0] - 1] += o[1]; // 월을 index로 사용하기 위해 -1을 해줍니다
        }
    	
    	System.out.println(monthlyOrder.length);
    	
    	for(int i=0; i<cost.length-1; i++) {
    		if(totalNeedOrder == 0 || made >= totalNeedOrder) break;
    		int nowCost = cost[i][1];
    		int limit = cost[i + 1][0] - cost[i][0];
    		int leftOrder = 0;
    		for (int j = 0; j < maxMonth; j++) {
    			if (totalNeedOrder == 0 || made >= totalNeedOrder) break;
    			
    			int nowMaking = 0;
    			if(limit <= totalNeedOrder) {
    				nowMaking = limit;
    			}else {
    				nowMaking = totalNeedOrder - made;
    			}
    			
    			System.out.println(j+1+"nowCost:"+nowCost+"/nowMaking:"+nowMaking+"/"+made+"/"+totalNeedOrder);
    			//System.out.println(j+1+"/"+nowMaking);
    			
    			answer = answer + nowMaking*nowCost;
    			made += nowMaking;
    			totalNeedOrder -=monthlyOrder[j];
    			
    			if(monthlyOrder[j] == 0) continue;
    			
    			int deleverly = 0;
    			if(made <= monthlyOrder[j]) {
    				deleverly = made;
    			}else {
    				deleverly = monthlyOrder[j];
    			}
    			
    			made -= deleverly;
    			monthlyOrder[j] -= deleverly;
    			leftOrder += monthlyOrder[j];	// 납품 후 남은것 다음구간에서 만든다
    		}
    		totalNeedOrder = leftOrder;
    		made = 0;
    	}
    	
    	System.out.println("totalNeedOrder::"+totalNeedOrder);
    	
    	answer += totalNeedOrder*cost[cost.length-1][1];
    	
        return answer;
    }
	
}
