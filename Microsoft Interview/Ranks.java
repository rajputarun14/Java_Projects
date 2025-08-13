
/******************************************************************************

Problem:

In a gaming competition, players earn scores between 0 and 100 (inclusive). Players are ranked in descending order of scores. Players with the same score share the same rank, and the next rank is incremented by the number of players who share the previous score.

Only players whose rank ≤ k and score > 0 can advance to the next level.

Given an array scores representing the scores of all players and an integer k, write a function to determine how many players can level up.

Example 1:

vbnet
Copy
Edit
Input: scores = [100, 90, 90, 80, 75, 75, 60], k = 4
Output: 5

Explanation:
Scores sorted: 100 (rank 1), 90 (rank 2), 90 (rank 2), 80 (rank 4), 75 (rank 5), 75 (rank 5), 60 (rank 7)  
Ranks ≤ 4 → Players with scores [100, 90, 90, 80] → Total 4 players.  
Wait! But rank 4 contains just the player with score 80, so total = 4 players.

*******************************************************************************/
public class Ranks
{
    public static int numberOfPeoples(int[] arr, int k)
    {
        int n = arr.length;
        int count[] = new int[101];
        for(int i=0;i<n;i++)
        {
            count[arr[i]]++;
        }
        int total = 0;
        int rank = 1;
        for(int i=100;i>=0;i--)
        {
            if(count[i]>0)
            {
                if(rank <= k)
                {
                    total += count[i];
                    rank += count[i];
                }
            }
        }
        return total;
    }
	public static void main(String[] args) {
	        int[] arr = new int[]{100, 90, 90, 80, 80, 75, 60};
            int k = 4;
            System.out.println(numberOfPeoples(arr,k));
	}
}
