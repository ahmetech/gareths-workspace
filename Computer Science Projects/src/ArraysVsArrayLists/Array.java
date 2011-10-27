package ArraysVsArrayLists;

public class  Array {
	public static void main(String[] args) {
		int maxnumber = 178844371;
		boolean[] prime;
		prime = new boolean[maxnumber + 1];
		for (int position = 0; position <= maxnumber; position++) {
			prime[position] = false;
		}
		for (int position = 2; position <= Math.sqrt(maxnumber); position++) {
			if (!prime[position]) {
				int notaprime = position * 2;
				while (notaprime <= maxnumber) {
					prime[notaprime] = true;
					notaprime += position;
				}                
			}
		}
		for (int position = maxnumber; position <= maxnumber; position++) { 
			if (!prime[position]) { 
				System.out.print(position); 
			} 
		}
	}
}
