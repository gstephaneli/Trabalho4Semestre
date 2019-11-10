package views;

import controllers.PublisherController;

public class teste {
	public static void main(String args[]) throws Throwable {
		PublisherController action = new PublisherController();
		
		if(action.addPublisher("Abril", "www.url.net")) {
			System.out.println("sucesso");
		} else {
			System.out.println("falha");
		}
	}
}
