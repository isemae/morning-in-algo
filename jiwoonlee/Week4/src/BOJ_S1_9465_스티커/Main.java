package BOJ_S1_9465_스티커;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[2][n + 1];
			int[][] dp = new int[2][n + 1];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];

			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + arr[1][i];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));

		}
	}
}
