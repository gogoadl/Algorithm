package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589 {
	static int[] dx = new int[] {-1,1,0,0};
	static int[] dy = new int[] {0,0,-1,1};
	static int height;
	static int width;
	static int length = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());

		char[][] map = new char[height][width];
		boolean[][] visited = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (map[i][j] == 'L') {
					bfs(map, visited, i, j);
					visited = new boolean[height][width];
				}
			}
		}

		System.out.println(length);
	}

	public static void bfs(char[][] graph, boolean[][] visited, int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		int result = 0;
		queue.add(new int[] {i,j,0});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] value = queue.poll();
			result = Math.max(result, value[2]);
			for (int k = 0; k < 4; k++) {
				int ny = value[0] + dy[k];
				int nx = value[1] + dx[k];

				if (ny >= height || nx >= width || nx < 0 || ny < 0) continue;
				if (graph[ny][nx] != graph[i][j]) continue;
				if (visited[ny][nx]) continue;

				visited[ny][nx] = true;
				queue.add(new int[] {ny,nx, value[2]+1});
			}
		}
		length = Math.max(length, result);
	}

}
