import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		List<RemovableDigitNumber> testingNumbers = readInput();
		for (Iterator<RemovableDigitNumber> iterator = testingNumbers.iterator(); iterator.hasNext();) {
			RemovableDigitNumber number = iterator.next();
			number.printSolution(out);
		}
		out.flush();
	}	
	private static List<RemovableDigitNumber> readInput() {
		List<RemovableDigitNumber> result = new ArrayList<>();
		BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));            
            int T = Integer.parseInt(br.readLine());
            for(int i = 0; i < T; i++) {
            	int number = Integer.parseInt(br.readLine());
            	result.add(new RemovableDigitNumber(number));
            }
        } catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return result;
	}
}
