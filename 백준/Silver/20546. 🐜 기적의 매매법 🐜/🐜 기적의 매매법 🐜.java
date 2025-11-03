import java.io.*;
import java.util.*;

import javax.imageio.plugins.tiff.TIFFDirectory;

class Main {
    static int curMoney;
    static int[] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        price = new int[15];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1;i < 15;i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        curMoney = money;
        int bnp = BNP();

        curMoney = money;
        int timing = TIMING();

        // System.out.println(bnp);
        // System.out.println(timing);

        if (bnp > timing) {
            System.out.println("BNP");
        } else if (bnp < timing) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    private static int BNP() {
        int cnt = 0;
        for (int i = 1;i < 15;i++) {
            if (price[i] <= curMoney) {
                cnt += curMoney / price[i];
                curMoney %= price[i];
            }
        }

        return getResult(cnt);
    }

    private static int TIMING() {
        int cnt = 0;
        int up = 0;
        int down = 0;
        for (int i = 2;i < 15;i++) {
            if (price[i] < price[i - 1]) {  // 상승
                down++;
                up = 0;
            } else if (price[i] > price[i - 1]) {  // 하락
                up++;
                down = 0;
            } else {
                up = 0;
                down = 0;
            }

            if (up >= 3) {  // 3일 연속 상승한 경우 풀매도
                // System.out.println(i + "일 풀매도");
                curMoney += price[i] * cnt;
                cnt = 0;
            } else if (down >= 3) {  // 3일 연속 하락한 경우 풀매수
                // System.out.println(i + "일 풀매수");
                cnt += curMoney / price[i];
                curMoney %= price[i];
            }
        }

        return getResult(cnt);
    }

    private static int getResult(int cnt) {
        return price[14] * cnt + curMoney;
    }
}