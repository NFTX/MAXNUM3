import java.io.PrintWriter;
import java.util.Arrays;

public class RemovableDigitNumber {

	int originalNumber;
	String maxDivisibleBySixWithLeadingZeros;
	
	public RemovableDigitNumber(int number) {
		this.originalNumber = number;
	}

	public void printSolution(PrintWriter out) {
		solve();
		out.println(maxDivisibleBySixWithLeadingZeros);
	}

	private void solve() {
		if(originalNumber % 2 == 1) {
			if (originalNumber/10 % 3 == 0 && originalNumber/10 % 2 == 0) {
				maxDivisibleBySixWithLeadingZeros = String.valueOf(originalNumber/10);
			} else {
				maxDivisibleBySixWithLeadingZeros = "-1";
			}
		} else {
			char[] removable;
			switch (originalNumber % 3) { //A number is divisible by 3 if the sum of its digits is divisible by 3
			case 0: 
				removable = new char[4];
				removable[0] = '9';
				removable[1] = '6';
				removable[2] = '3';
				removable[3] = '0';
				remove(removable, String.valueOf(originalNumber));
				break;
			case 1:
				removable = new char[3];
				removable[0] = '7';
				removable[1] = '4';
				removable[2] = '1';
				remove(removable, String.valueOf(originalNumber));
				break;
			case 2:
				removable = new char[3];
				removable[0] = '8';
				removable[1] = '5';
				removable[2] = '2';
				remove(removable, String.valueOf(originalNumber));
				break;
			default:
				//Never reached!
				break;
			}	
		}
	}
	
	private void remove(char[] removable, String number) {
		int[] occurrence = new int[removable.length*2];
		int aux;
		int removeAtIndex = -1;
		for(int i = 0; i < removable.length; i++) {
			aux = number.indexOf(removable[i]);
			occurrence[2*i] = aux;
			occurrence[2*i+1] = number.substring(aux+1).indexOf(removable[i]);			
		}
		Arrays.sort(occurrence);
		
		int first = indexOfMin(occurrence,1);
		if(first != -1) {
			if(first == number.length()-1) {
				removeAtIndex = number.length()-1;
			} else if(number.charAt(first) <= number.charAt(first+1)) {
				removeAtIndex = first;
			} else {
				int second = indexOfMin(occurrence,2);
				if(second == -1) {
					removeAtIndex = first;
				} else if(number.charAt(first+1) > number.charAt(second)) {
					removeAtIndex = first;
				} else {
					removeAtIndex = second;
				}
			}
		}
		maxDivisibleBySixWithLeadingZeros = removeAt(number, removeAtIndex);
	}

	private int indexOfMin(int[] list, int ordinal) {
		int i = 0;
		while(i < list.length) {
			if(list[i] == -1) {
				i++; 
			} else {
				break;
			}
		}
		return list.length <= i+ordinal-1 ? -1 : list[i+ordinal-1];
	}
	
	private String removeAt(String s, int index) {
		return index == -1 ? "-1" : s.substring(0,index) + s.substring(index+1);
	}
}
