import java.util.*;
public class Solution {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        return isSolveable(leap, game, 0);
    }

    private static boolean isSolveable(int leap, int[] game, int i) {
        if (i >= game.length) {
            // We have reached or passed the end of the array, game is won
            return true;
        }
        if (i < 0 || game[i] == 1) {
            // We are out of bounds or standing on a 1, game is not solvable
            return false;
        }

        // Mark the current cell as visited
        game[i] = 1;

        // Recursive calls to explore all possible moves
        return isSolveable(leap, game, i + leap) || isSolveable(leap, game, i + 1) || isSolveable(leap, game, i - 1);
    } // private static boolean isSolveable(int leap, int[] game, int i) {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q-- > 0) {
            int n = scanner.nextInt();
            int leap = scanner.nextInt();
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scanner.nextInt();
            }
            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scanner.close();
    }
}
