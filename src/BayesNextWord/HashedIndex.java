package BayesNextWord;

import java.util.HashMap;

public class HashedIndex {

	HashMap<String, HashMap<String, Integer>> index = new HashMap<String, HashMap<String, Integer>>();
	HashMap<String, Integer> stationaryProbabilities = new HashMap<String, Integer>();

	String previousWord;
	boolean isFirst = true;

	public HashedIndex() {
	}

	public void insert(String token) {
		if (isFirst) {
			previousWord = token;
			isFirst = false;
		} else {
			String currentWord = token;

			if (index.containsKey(previousWord)) {

				HashMap<String, Integer> tmpMap = index.get(previousWord);
				if (tmpMap.containsKey(currentWord)) {
					int oldValue = tmpMap.get(currentWord);
					tmpMap.put(currentWord, (oldValue + 1));
				} else {
					tmpMap.put(currentWord, 1);
				}
			} else {
				HashMap<String, Integer> tmpMap = new HashMap<String, Integer>();
				tmpMap.put(currentWord, 1);
				index.put(previousWord, tmpMap);
				stationaryProbabilities.put(previousWord, 1);
			}
			int oldValue = 0;
			if (stationaryProbabilities.containsKey(currentWord)) {
				oldValue += stationaryProbabilities.get(currentWord);
			}
			stationaryProbabilities.put(currentWord, oldValue + 1);
			previousWord = currentWord;
		}

	}

	public String getNextWord(String word) {
		if (index.containsKey(word)) {
			return getMaxProbWord(index.get(word));

		} else {
			return getMaxProbWord(stationaryProbabilities);
		}
	}

	private String getMaxProbWord(HashMap<String, Integer> parameterMap) {
		Object[] allKeys = parameterMap.keySet().toArray();

		int i;
		int max = 0;
		String maxString = "";
		for (Object o : allKeys) {
			if ((i = parameterMap.get(o.toString())) > max) {
				max = i;
				maxString = o.toString();
			}
		}

		return maxString;
	}
}
