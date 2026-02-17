import java.util.*;
import java.io.*;

class Solution {
    
    private class Music {
        int idx;
        int play;
        
        Music(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        
        @Override
        public String toString() {
            return idx + ": " + play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 플레이 횟수(내림차순) 우선순위 큐
        Map<String, PriorityQueue<Music>> playList = new HashMap<>();
        for (int i = 0;i < plays.length;i++) {
            String genre = genres[i];
            if (!playList.containsKey(genre)) {
                playList.put(genre, new PriorityQueue<>((x, y) -> {
                    if (x.play == y.play) {
                        return x.idx - y.idx;
                    } else {
                        return y.play - x.play;
                    }
                }));
            }
            playList.get(genre).add(new Music(i, plays[i]));
        }
        
        // 출력
        // for (Map.Entry<String, PriorityQueue<Music>> entry : playList.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }
        
        // 장르별 전체 노래 플레이 횟수
        Map<String, Integer> genrePlays = new HashMap<>();
        for (int i = 0;i < plays.length;i++) {
            genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // System.out.println(genrePlays);
        
        // 전체 노래 플레이 횟수(내림차순) 장르
        PriorityQueue<String> pq = new PriorityQueue((x, y) -> genrePlays.get(y) - genrePlays.get(x));
        for (String key : genrePlays.keySet()) {
            pq.add(key);
        }
        
        // System.out.println(pq);
        
        Queue<Music> queue = new LinkedList<>();
        while (!pq.isEmpty()) {
            PriorityQueue<Music> musics = playList.get(pq.poll());
            queue.add(musics.poll());           // 1곡은 무조건 추가
            if (!musics.isEmpty()) {            // 2곡째가 있으면 추가
                queue.add(musics.poll());
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            answer.add(queue.poll().idx);
        }
        
//         for (int i = 0;i < plays.length;i++) {
//             answer.add(queue.poll().idx);
//         }
        
//         if (plays.length / 2 != 0) {
//             answer.remove(plays.length - 1);
//         }

        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}