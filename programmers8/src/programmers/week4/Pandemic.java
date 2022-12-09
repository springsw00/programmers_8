package programmers.week4;

import java.util.*;

public class Pandemic {
	
	static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
    
    public static int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];
        int[][] countByQuery = new int[rows][columns];
        for(int i = 0; i < answer.length; i++)
			Arrays.fill(answer[i], 0);
        
        Queue<Position> queue = new <Position>LinkedList();
        
        for(int[] i:queries){
        	for(int x = 0; x < countByQuery.length; x++)
    			Arrays.fill(countByQuery[x], 0);
        	
        	// 배열 좌표로 변환
            int x = i[0]-1;
            int y = i[1]-1;
            
        	queue.offer(new Position(x, y));
        	
        	while(!queue.isEmpty()) {
        		
        		Position nowPosition = queue.poll();
        		
        		// 현재위치가 맵에서 벗어났는지 확인
        		if(nowPosition.x < 0 || nowPosition.x >= rows || nowPosition.y < 0 || nowPosition.y >= columns)
        			continue;
        		
        		// 이번 쿼리에서 이미 방문한곳인지 확인
        		if(countByQuery[nowPosition.x][nowPosition.y] > 0) continue;
        		
        		countByQuery[nowPosition.x][nowPosition.y]++;	// 방문체크
        		
        		if(answer[nowPosition.x][nowPosition.y] < 2){
                	answer[nowPosition.x][nowPosition.y]++;
                	continue;
                }
        		
        		queue.offer(new Position(nowPosition.x, nowPosition.y + 1));
                queue.offer(new Position(nowPosition.x, nowPosition.y - 1));
                queue.offer(new Position(nowPosition.x + 1, nowPosition.y));
                queue.offer(new Position(nowPosition.x - 1, nowPosition.y));
        	}
        }
        for(int i = 0; i < answer.length; i++)
    		System.out.println(Arrays.toString(answer[i]));
        
        
        
       /*int[][] countByQuery = new int[rows][columns];
        for(int i = 0; i < answer.length; i++)
			Arrays.fill(answer[i], 0);
        
        for(int[] i:queries){
            //System.out.println(Arrays.toString(i));
        	for(int x = 0; x < countByQuery.length; x++)
    			Arrays.fill(countByQuery[x], 0);
        	
        	// 배열 좌표로 변환
            int x = i[0]-1;
            int y = i[1]-1;
            
            if(x == 2 && y ==0) 
            	System.out.println("test");
            
            if(answer[x][y] < 2){
            	answer[x][y]++;
            	countByQuery[x][y]++;
            }else if(answer[x][y] >= max_virus){
                propagation(x,y, answer, max_virus, countByQuery);
            }
            System.out.println("####"+Arrays.toString(i));
            for(int t = 0; t < answer.length; t++)
			    System.out.println(Arrays.toString(answer[t]));
        }*/
        
        //for(int i = 0; i < answer.length; i++)
		//	System.out.println(Arrays.toString(answer[i]));
        
        return answer;
    }
    
    /*public void propagation(int x,int y,int[][] answer, int max_virus,int[][] countByQuery){
        countByQuery[x][y]++;
		
        if(x-1 >= 0) 	//상
            propagationCheck(x-1, y, answer, max_virus, countByQuery);
        if(y-1 >= 0)    //좌
            propagationCheck(x, y-1, answer, max_virus, countByQuery);
        if(y+1 < answer[0].length)  //하  
            propagationCheck(x, y+1, answer, max_virus, countByQuery);
        if(x+1 < answer.length)//우    
            propagationCheck(x+1, y, answer, max_virus, countByQuery);
    }
    
    public void propagationCheck(int x,int y,int[][] answer, int max_virus, int[][] countByQuery){
        if(countByQuery[x][y]>0) return;
    	if(answer[x][y] >= max_virus){
            propagation(x,y, answer, max_virus, countByQuery);
        }else {
        	answer[x][y]++;
        	countByQuery[x][y]++;
        }
    }
    
    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];
        int[][] countByQuery = new int[rows][columns];
        for(int i = 0; i < answer.length; i++)
			Arrays.fill(answer[i], 0);
        
        for(int[] i:queries){
        	for(int x = 0; x < countByQuery.length; x++)
    			Arrays.fill(countByQuery[x], 0);
        	
        	// 배열 좌표로 변환
            int x = i[0]-1;
            int y = i[1]-1;
            
            if(answer[x][y] < max_virus){
            	answer[x][y]++;
            	countByQuery[x][y]++;
            }else if(answer[x][y] >= max_virus){
                propagation(x,y, answer, max_virus, countByQuery);
            }
            //System.out.println("####"+Arrays.toString(i));
            //for(int t = 0; t < answer.length; t++)
			//    System.out.println(Arrays.toString(answer[t]));
        }
        
        return answer;
    }*/
	
	public static void main(String[] args) {
		int[] array = {4,11};
		System.out.println(solution(3,4,2,new int[][]{{3,2},{3,2},{2,2},{3,2},{1,4},{3,2},{2,3},{3,1}}));
		
		//int[] array2 = {9};
		//System.out.println(solution(16,array2,2));
	}
}
