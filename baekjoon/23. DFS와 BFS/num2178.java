package package23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num2178 {
	static int M,N;
	static int[][] map;
	static int[][] visited;
	static int count;
	// BFS는 dx, dy 사용해야 한다
	static int[] dx = { 1, -1, 0, 0};
	static int[] dy = { 0, 0, 1, -1};

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> que = new ArrayList<Integer>();
		// FIFO
		boolean checkIndex = true;
		
		String[] MNdata = br.readLine().split("");
		int M = Integer.parseInt(MNdata[0]);
		int N = Integer.parseInt(MNdata[1]);
		
		for(int i=0;i<M;i++) {
			String[] inputMapData = br.readLine().split("");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(inputMapData[j]);
			}
		}
	}

}
