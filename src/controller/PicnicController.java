package src.controller;

import src.service.PicnicService;
import src.view.PicnicView;

public class PicnicController {
	private PicnicView picnicView = new PicnicView();
	private PicnicService picnicService = new PicnicService();

	public void start() {
		picnicView.start();
		while (true) {
			int menu = picnicView.menu();
			switch (menu) {
				case 1: {
					picnicView.countWords(picnicService.countWords());
					break;
				}
				case 2: {
					picnicView.findLongestWord(picnicService.findLongestWord());
					break;
				}
				case 3: {
					picnicView.countEachWord(picnicService.countEachWord());
					break;
				}
				case 4: {
					picnicView.end();
					return;
				}
			}
		}
	}
}
