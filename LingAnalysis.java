import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
 * Jamie Konigsberg
 * 
 * Note: Top 10 Words (Words > 3 letters)
 */

public class LingAnalysis {
	public static void main(String[] args) {
		Path source = Paths.get("corpora/tester.txt");
		Path output = Paths.get("generated.txt");

		Map<String, Integer> freq = frequencyDist(source);
		System.out.println("Frequency:");
		System.out.println(freq);
		Map<Integer, Integer> freqlengths = wordLengths(source);
		System.out.println("# Letters = # Words with that amount of letters:");
		System.out.println(freqlengths);
		Map<String, List<String>> bigramio = bigram(source);
		System.out.println("Bigrams:");
		System.out.println(bigramio);
		Map<String, Integer> ten = top10(freq);
		Map<String, Integer> mostcommon = top10(freq);
		System.out.println("Top 10 Most Common:");
		System.out.println(mostcommon);

	}
	/*
	 * this should make a string of length words.
	 * 
	 * pick a first word from the keyset of gram
	 * repeat length times:
	 *    get the list associated with the word
	 *    replace word with a random pick from that list
	 *    add that word to the file
	 */
	static void generate(Map<String, List<String>> gram, int length, Path out) {
		try {
			BufferedWriter file = Files.newBufferedWriter(out, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			file.write("hello ");
			file.close();
			//need a length function to stop.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * this map should be from word length, to the number of words with that length.
	 * 
	 * for example, the output for tester.txt should be:
	 * {3=2, 5=1, 7=2} 
	 * in other words, there are two words of size three, one word of size 5, and two words of size 7
	 * 
	 */

	static Map<Integer, Integer> wordLengths(Path p) {
		Map<Integer, Integer> freqlengths = new HashMap<Integer, Integer>();

		try {
			BufferedReader bf = Files.newBufferedReader(p, StandardCharsets.UTF_8);

			for(String s = bf.readLine(); s!=null; s = bf.readLine())
			{
				for(String word : s.split(" "))
				{
					word = word.toLowerCase();
					word = word.replaceAll("[,?.!()*-/\1234567890+_&# -:;]", "");
					word = word.replaceAll("'s?", "");
					word = word.trim();
					if(word.length()<=2) continue;
					if(freqlengths.containsKey(word.length())) freqlengths.put(word.length(), freqlengths.get(word.length())+1);
					else freqlengths.put(word.length(), 1);
				}

			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return freqlengths;
	}

	/*
	 * This map should be from every word in the text to a list of words that can follow it.
	 * There should be multiple copies of the following words if they repeat in the text
	 * 
	 * the correct output for tester should be:
	 * 
	 * {two=[three], one=[two], testing=[testing, one]}
	 * 
	 * for each word:
	 *   if the previous word is not in the map, add it to the map with an empty list
	 *   get the previous word's list from the map, add the current word.	 * 
	 */
	static Map<String, List<String>> bigram(Path p) {
		Map<String, List<String>> bigramio = new TreeMap<String, List<String>>();
		String SENTINAL = "aaaaaboom";


		try {
			BufferedReader bf = Files.newBufferedReader(p, StandardCharsets.UTF_8);

			String prevword = SENTINAL;


			for(String s = bf.readLine(); s!=null; s = bf.readLine())
			{
				for(String word : s.split(" ")) {
					word = word.toLowerCase();
					word = word.replaceAll("[,?.!()*-/\123 4567890+_&#-:;\"]", "");
					word = word.replaceAll("'s?", "");
					word = word.replaceAll(" ", "");
					word = word.trim();
					if(word.length()<=5) continue;
					if(bigramio.containsKey(prevword)) {
						bigramio.get(prevword).add(word);
					}
					else {
						List myList = new ArrayList();
						myList.add(word);
						bigramio.put(prevword, myList);
					}

					prevword = word; 
				}

			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		bigramio.remove(SENTINAL);
		return bigramio;
	}

	/*
	 * 
	 * 10 Most Common Words
	 * 
	 * 
	 */
	static Map<String, Integer> top10(Map freq) {

		Map<String, Integer> mostcommon = new HashMap<String, Integer>();


		//find the largest Key:
		for(int i = 0; i < 10; i++)
		{
			String largest = null;
			int largestFreq = 0;
			Iterator iterator = freq.keySet().iterator();
			while(iterator.hasNext())
			{
				String checker = (String) iterator.next(); 
				if((int)freq.get(checker) > largestFreq)	
				{
					largestFreq = (int) freq.get(checker);
					largest = checker; 
				}
			}
			mostcommon.put(largest, largestFreq);
			freq.remove(largest);
		}
	return mostcommon;
	}


/*
 * this map should be from every word to the frequency in the text
 * 
 * for each word:
 *   if the word is in the map, increment the value by one
 *   if the word is not in the map, add the word with a value of one.
 */
static Map<String, Integer> frequencyDist(Path p) {
	Map<String, Integer> freq = new HashMap<String, Integer>();

	try {
		BufferedReader bf = Files.newBufferedReader(p, StandardCharsets.UTF_8);

		for(String s = bf.readLine(); s!=null; s = bf.readLine())
		{
			for(String word : s.split(" "))
			{
				word = word.toLowerCase();
				word = word.replaceAll("[,?.!()*-/\1234567890+_&# -:;]", "");
				word = word.replaceAll("'s?", "");
				word = word.trim();
				if(freq.containsKey(word)) freq.put(word, freq.get(word)+1);
				else if(word.length()<=2) continue; 
				else freq.put(word, 1);
			}
		}
		bf.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return freq;
}
}























