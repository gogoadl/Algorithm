package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> rq = new PriorityQueue<>();
		Queue<Integer> zeroq = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int value = Integer.parseInt(st.nextToken());
			if (value > 0) {
				q.add(value);
			} else if (value == 0) {
				zeroq.add(value);
			} else {
				rq.add(value);
			}

		}
		int answer = 0;
		while (!q.isEmpty()) {
			int first = q.poll();
			if (q.isEmpty()) {
				answer += first;
				break;
			}
			int second = q.poll();
			if (first == 1 || second == 1)
				answer += first + second;
			else
				answer += first * second;
		}

		while (!rq.isEmpty()) {
			int first = rq.poll();
			if (rq.isEmpty()) {
				if (!zeroq.isEmpty()) {
					zeroq.poll();
				} else {
					answer += first;
				}
				break;
			}
			int second = rq.poll();

			answer += first * second;
		}
		System.out.println(answer);
	}
}
