import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

enum Color {
	R("Rouge"),
	B("Bleu"),
	V("Vert"),
	N("Noir"),
	J("Jaune"),
	G("Gris");
	
	public final String color;
	
	private Color(String color) {
		this.color = color;
	}
	
	private static final List<Color> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	private static Color randomColor() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

	public String toString() {
		return color;
	}
	
	public static ArrayList<Color> pickColors() {
		ArrayList<Color> colors = new ArrayList<Color>();
		for (int i=0; i < 4; i++) {
			colors.add(Color.randomColor());
		}
		return colors;
	}
}