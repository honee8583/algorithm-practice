package 백준.그래프.벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_11657 {
    public static class Edge {
        int node;
        int next;
        int weight;

        public Edge(int node, int next, int weight) {
            this.node = node;
            this.next = next;
            this.weight = weight;
        }
    }

    public static int N, E;
    public static long[] distance;
    public static Edge[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int node = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[i] = new Edge(node, next, weight);
        }

        distance = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[1] = 0;
        boolean flag = true;
        for (int j = 1; j < N; j++) {   // 업데이트 반복 횟수는 N-1 번이다.
            for (int i = 0; i < E; i++) {
                Edge curEdge = edgeList[i];

                if (distance[curEdge.node] != Integer.MAX_VALUE && distance[curEdge.next] > distance[curEdge.node] + curEdge.weight) {
                    distance[curEdge.next] = distance[curEdge.node] + curEdge.weight;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            Edge curEdge = edgeList[i];

            if (distance[curEdge.node] != Integer.MAX_VALUE && distance[curEdge.next] > distance[curEdge.node] + curEdge.weight) {
                flag = false;
                break;
            }
        }

        if (!flag) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) System.out.println(-1);
                else System.out.println(distance[i]);
            }
        }
    }
}