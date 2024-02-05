

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		//System.out.println(existInDictionary("worth", dictionary));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++){
			dictionary[i] = in.readString();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		for (int i = 0; i < dictionary.length; i++){
			if (word.length() == dictionary[i].length()){
				if (stringEquals(word, dictionary[i])){
					//System.out.println(i);
					return true;
				}
	
			}
		}
		return false;
	}

	public static boolean stringEquals(String word1,String word2){
		for(int i = 0; i < word1.length(); i++){
			if (word1.charAt(i) != word2.charAt(i)){
				return false;
			}
		}
		return true;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
		
        if (hashtag.isEmpty()) {
            return;
        }
		hashtag = hashtag.toLowerCase();
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) {
		String prefix = hashtag.substring(0, i);
			if (existInDictionary(prefix, dictionary)){
				System.out.println(prefix);
				breakHashTag(hashtag.substring(i), dictionary);
				return;
			}
		
        }
    }

}
