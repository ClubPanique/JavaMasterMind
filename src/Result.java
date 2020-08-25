import java.util.ArrayList;
import java.util.List;

public class Result {
	int wellplaced;
	int misplaced;

	public Result compareColors(List<String> letters, ArrayList<Color> colors) {
		int i = 0;
		Result result = new Result();
		for (String letter : letters) {
			if (colors.get(i).name().contentEquals(letter)) {
				wellplaced++;
			}
			else if (colors.contains(Color.valueOf(letter))) {
				misplaced++;
			}
			i++;
		}
		return result;
	}
	
	public boolean displayResult() {
		String pluralW = "";
		String pluralM = "";
		
		if (wellplaced > 1) pluralW = "s";
		if (misplaced > 1) pluralM = "s";
		
		System.out.println("Couleur" + pluralW + " bien placée" + pluralW + " : " + wellplaced);
		System.out.println("Couleur" + pluralM + " mal placée" + pluralM + " : " + misplaced);
		if (wellplaced == 4) {
			return true;
		} 
		else {
			return false;
		}
	}
}

