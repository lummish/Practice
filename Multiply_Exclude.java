public class Multiply_Exclude {
	public static Integer[] mult(Integer[] in) {
		
		int sz = in.length;

		Integer[] dynamo = new Integer[2 * sz - 2];
		int mid = dynamo.length / 2;
		dynamo[0] = in[0];
		dynamo[mid] = in[sz - 1];

		for (int i = 1; i < mid; i++) {
			dynamo[i] = dynamo[i - 1] * in[i];
			dynamo[mid + i] = dynamo[mid + i - 1] * in[sz - (i + 1)];
		}

		//Integer[] result = new Integer[sz];
		int start = 1;

		int sz_d = dynamo.length;

		in[0] = dynamo[sz_d - start];

		for (int i = 0; i < mid - 1; i++) {
			in[i + 1] = 
				dynamo[sz_d - (start + i + 1)] * 
				dynamo[i];
		}

		in[mid] = dynamo[mid - 1];

		for (int i = 0; i < in.length; i++) {
			System.out.print(in[i] + " ");
		}

		return in;
	}

	public static void main(String[] args) {
		
		Integer[] tst = new Integer[args.length];

		for (int i = 0; i < args.length; i++) {
			tst[i] = Integer.parseInt(args[i]);
		}

		mult(tst);
	}
}