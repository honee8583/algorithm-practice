import java.io.*;
import java.util.*;


class Main {
    static class Meeting implements Comparable<Meeting> {
        int start, end;
    
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    
        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start; // If end times are equal, sort by start time
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            pq.offer(new Meeting(start, end));
        }

        int cnt = 1;
        Meeting cur = pq.poll();
        while (!pq.isEmpty()) {
            Meeting next = pq.poll();

            if (next.start >= cur.end) {
                cnt++;
                cur = next;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}