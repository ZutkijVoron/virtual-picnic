package src.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PicnicService {

	private String getStringFile(FileReader fileReader) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(fileReader);
		while (br.ready()) {
			sb.append(br.readLine());
		}
		return sb.toString();
	}

	public int countWords() {
		int count = 0;
		try (FileReader fileReader = new FileReader("input.txt")) {
			String str = getStringFile(fileReader);
			List<String> words = new ArrayList<>(Arrays.asList(str.split(" ")));
			words.removeAll(Arrays.asList("", null));
			count = words.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public String findLongestWord() {
		String longestWord = "";
		try (FileReader fileReader = new FileReader("input.txt")) {
			String str = getStringFile(fileReader);
			List<String> words = new ArrayList<>(Arrays.asList(str.split(" ")));
			words.removeAll(Arrays.asList("", null));
			for (String word : words) {
				if (word.length() > longestWord.length()) {
					longestWord = word;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return longestWord;
	}

	public HashMap<String, Integer> countEachWord() {
		String str = "";
		HashMap<String, Integer> map = new HashMap<>();
		try (FileReader fileReader = new FileReader("input.txt")) {
			str = getStringFile(fileReader);
			List<String> words = new ArrayList<>(Arrays.asList(str.split(" ")));
			words.removeAll(Arrays.asList("", null));
			for (String word : words) {
				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sortedHashMap(map);
	}

	private HashMap<String, Integer> sortedHashMap(HashMap<String, Integer> map) {
		return map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
	}
}
