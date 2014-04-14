package BayesNextWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class tokenizer {

	HashedIndex myHashedIndex = new HashedIndex();
	String fileName;

	public tokenizer(String fileName) {
		this.fileName = fileName;
	}

	public void tokenize() {
		File file = new File(fileName);
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			ArrayList<String> linesAsStrings = new ArrayList<String>();
			String s;

			while ((s = bufferedReader.readLine()) != null) {
				linesAsStrings.add(s);
			}

			for (String str : linesAsStrings) {
				StringTokenizer tokens = new StringTokenizer(str);
				while (tokens.hasMoreTokens()) {
					String token = tokens.nextToken();
					System.out.println(token);
					myHashedIndex.insert(token.toLowerCase());
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
