import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class MasterMind {
	private static Scanner reader;
	private static ArrayList<Color> colors;
	private static List<String> userInput;
	private static boolean won;
	private static boolean lost;
	private static int attemps;
	private static boolean retry = true;
	
	public static void main(String[] args) {
		while (retry) {
			playgame();
			retry = askForRetry();
		}
		
		System.out.println("A bientôt ! :)");
	}
	
	private static void playgame() {
		init();
		
		while (!won && !quit() && !lost) {
			askUserInput();
			checkUserInput();
				
			if (help()) {
				displayHelp();
			} 
			else if (!quit()) {
				Result result = new Result(); 
				result.compareColors(userInput, colors);
				won = result.displayResult();
				attemps++;
			}
			
			if (attemps > 10) lost = true;
		}
		
		if (!quit()) displayEndMessage();
	}
	
	private static void init() {
		won = false;
		lost = false;
		attemps = 0;
		reader = new Scanner(System.in);
		
		System.out.println("Bienvenue dans le MasterMind !");
		System.out.println("4 couleurs ont été tirées, vous devez les trouver. A vous de jouer !");
		
		colors = Color.pickColors();
		userInput = new ArrayList<String>();
		userInput.add("Start");
	}
	
	private static boolean quit() {
		if (userInput.get(0).contentEquals("Q")) return true;
		else return false;
	}
	
	private static boolean help() {
		if (userInput.get(0).contentEquals("H")) return true;
		else return false;
	}
	
	private static void displayHelp() {
		for (Color color : Color.values()) {
			System.out.println("\tTapez " + color.name() + " pour " + color.color);
		}
	}
	
	private static void askUserInput() {
		System.out.println("Veuillez entrer 4 couleurs. Tapez H pour voir l'aide, Q pour quitter.");
		String letters = reader.next().toUpperCase();
		userInput = Arrays.asList(letters.split(""));
	}
	
	private static void checkUserInput() {
		boolean wrongInput = false;
		
		if (userInput.contains("Q") || userInput.contains("H")) {
			return;
		}
		else if (userInput.size() != 4) {
			System.out.println("Veuillez saisir 4 lettres");
			wrongInput = true;
		}
		for (String letter : userInput) {
			try {
				Color.valueOf(letter);
			}
			catch (IllegalArgumentException ex) {  
		         System.out.println("Une des lettres entrées est incorrecte. Tapez H pour afficher l'aide.");
		         wrongInput = true;
		         break;
			}
		}
		
		if (wrongInput) askUserInput();
	}
	
	private static void displayEndMessage() {
		String message = "";
		if (won) message = "Félicitations ";
		else message = "Dommage ";
		message += "!!! Tapez R pour recommencer, autre chose pour quitter.";
		System.out.println(message);
	}
	
	private static boolean askForRetry() {
		String answer = reader.next().toUpperCase();
		if (answer.contentEquals("R")) return true;
		else return false;
	}
}
