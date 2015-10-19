public class ChangeMaker {
	
	private Integer[][] counter;
	private int[] coins;

	public ChangeMaker(int n, int[] coins) {
		counter = new Integer[n][coins.length];
		this.coins = coins;
	}
	public static int count(int n, int coin) {

		if (n == 0) return 1; //base case
		if (n < coins[coin] || coin >= coins.length) return 0; //edge case

		if(counter[n][coin] == null) {
			counter[n][coin] = count(n - coins[coin], coin) + count(n, coin + 1);
		}

		else {
			return (int) counter[n][coin];
		}
	}
	public static void main(String[] args) {
		
	}


}