package BayesNextWord;

public class BayesNextWord {
	public static void main(String[] arg) {
		tokenizer s = new tokenizer("/afs/nada.kth.se/home/3/u1qvl923/bajslav");
		s.tokenize();
		System.out.println(s.myHashedIndex.getNextWord(""));
	}
}
