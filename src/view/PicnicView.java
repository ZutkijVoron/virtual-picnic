package src.view;

import java.util.HashMap;
import java.util.Scanner;

public class PicnicView {
	private Scanner scanner = new Scanner(System.in);

	public void start() {
		System.out.println("Работа приложения началась");
	}

	public int menu() {
		System.out.println("Меню:");
		System.out.println("1. Подсчёт слов в файле \"input.txt\"");
		System.out.println("2. Вывести самое длинное слово в файле \"input.txt\"");
		System.out.println("3. Вывести сколько раз каждое слово встречается в файле \"input.txt\"");
		System.out.println("4. Выход");
		int result = scanner.nextInt();
		return result;
	}

	public void end() {
		scanner.close();
		System.out.println("Работа приложения закончена");
	}

	public void countWords(int message) {
		System.out.println("Слов в файле \"input.txt\": " + message);
	}

	public void findLongestWord(String message) {
		System.out.println("Самое длинное слово в файле \"input.txt\": " + message);
	}

	public void countEachWord(HashMap<String, Integer> map) {
		System.out.println("Сколько раз каждое слово встречается в файле \"input.txt\": " + map);
	}
}
