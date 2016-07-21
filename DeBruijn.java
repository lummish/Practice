import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class DeBruijn {
	private int k;
	private int n;
	private char [] alph;

	public DeBruijn(int k, int n) {
		this.k = k;
		this.n = n;
		this.alph = new char[k];

		for (int i = 0; i < k; i++) {
			alph[i] = Character.forDigit(i, 10);
		}
	}

	public DeBruijn(String alph, int n) {
		this.k = alph.length();
		this.n = n;
		this.alph = new char[k];

		for (int i = 0; i < k; i++) {
			this.alph[i] = (char) alph.charAt(i);
		}
	}

	private String next_lyndon(String prev_lyndon, int n) {
		String new_word =  "";

		for (int i = 0; i < n; i++) {
			new_word += prev_lyndon.charAt(i % prev_lyndon.length());
		}
		//System.out.println(new_word);

		int index_to_remove = -1;

		for (int i = n - 1; i >= 0; i--) {
			if ( new_word.charAt(i) == alph[k - 1]) {
				index_to_remove++;
			} else {
				break;
			}
		}

		if (index_to_remove >= 0) {
			new_word = new_word.substring(0, (n - 1) - index_to_remove)	;
		}

		if (new_word.length() == 0) {
			return null;
		}

		int last_char_index;
		char last_char = new_word.charAt(new_word.length() - 1);

		for (last_char_index = 0; last_char_index < alph.length; last_char_index++) {
			if (alph[last_char_index] == last_char) {
				break;
			}
		}

		new_word = new_word.substring(0, new_word.length() - 1) + alph[last_char_index + 1];

		//System.out.println(new_word);
		return new_word;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.useDelimiter(" ");

		while (in.hasNextLine()) {
			String[] inLine = in.nextLine().split(" ");
			String k_string = inLine[0];
			int n = Integer.parseInt(inLine[1]);
			DeBruijn d;

			try { //if k is an integer	
				int k = Integer.parseInt(k_string);
				if (k == 0 || n == 0) {
					continue;
				}
				d = new DeBruijn(k, n);

			} catch (Exception e) {//if k is an alphabetical string
				int k  = k_string.length();
				d = new DeBruijn(k_string, n);
			}

			ArrayList<String> db_sequence = new ArrayList<>();
			db_sequence.add("" + d.alph[0]);
			String next_word = d.next_lyndon(db_sequence.get(0), d.n);
			int get_index = 1;

			while (next_word != null) {
				db_sequence.add(next_word);
				next_word = d.next_lyndon(db_sequence.get(get_index++), d.n);
			}

			Iterator itr = db_sequence.iterator();
			String output = "";

			while (itr.hasNext()) {
				String next_out = (String) itr.next();
				if (n % next_out.length() == 0) {
					output += next_out;
				}
			}

			System.out.println(output);

		}
	}
}