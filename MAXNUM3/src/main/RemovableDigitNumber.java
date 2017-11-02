package main;

import java.io.PrintWriter;

public class RemovableDigitNumber {

	String originalNumber;
	
	public RemovableDigitNumber(String number) {
		this.originalNumber = number;
	}

	public void printSolution(PrintWriter out) {
		out.println(solve());
	}

	public String solve() {
		if(!isDivisibleByTwo(originalNumber)) {
			String originalNumberBy10 = originalNumber.substring(0, originalNumber.length()-1); 
			if (isDivisibleByTwo(originalNumberBy10)
					&& isDivisibleByThree(originalNumberBy10)) {
				return originalNumberBy10;
			} else {
				return "-1";
			}
		} else {
			char[] removable;
			switch (restByThree(originalNumber)) {
			case 0: 
				removable = new char[4];
				removable[0] = '9';
				removable[1] = '6';
				removable[2] = '3';
				removable[3] = '0';				
				break;
			case 1:
				removable = new char[3];
				removable[0] = '7';
				removable[1] = '4';
				removable[2] = '1';				
				break;
			case 2:
				removable = new char[3];
				removable[0] = '8';
				removable[1] = '5';
				removable[2] = '2';
				break;
			default:
				//Never reached! Used for compile reasons only
				removable = new char[1];				
				break;
			}	
			return remove(removable, originalNumber);
		}
	}
	
	private String remove(char[] removable, String number) {
		int removeAtIndex = -1;
		for(int i = 0; i < number.length(); i++) {
			if(isRemovable(number.charAt(i),removable)) {				
				if(i == number.length()-1
						&& Integer.parseInt(number.substring(i)) % 2 == 0
						&& Integer.parseInt(number.substring(i-1,i)) % 2 == 1) {
					//I can't remove the last one unless the previous one is pair
				} else {
					removeAtIndex = i;
					if(i+1 < number.length() && number.charAt(i) < number.charAt(i+1)) {
						break;
					}
				}
			}
		}
		return removeAt(number, removeAtIndex);
	}

	private boolean isRemovable(char charAt, char[] removable) {
		for (int i = 0; i < removable.length; i++) {
			if(charAt == removable[i]) {
				return true;
			}
		}
		return false;
	}
	
	private String removeAt(String s, int index) {
		return index == -1 ? "-1" : s.substring(0,index) + s.substring(index+1);
	}
	
	private boolean isDivisibleByTwo(String number) {
		int lastDigit = number.charAt(number.length()-1);
		return lastDigit % 2 == 0; 
	}

	 //A number is divisible by 3 if the sum of its digits is divisible by 3
	private boolean isDivisibleByThree(String number) {
		int digitsSum = 0;
		for (int i = 0; i < number.length(); i++) {
			digitsSum +=  number.charAt(i);
		}
		return digitsSum % 3 == 0;
	}
	
	private int restByThree(String number) {
		int digitsSum = 0;
		for (int i = 0; i < number.length(); i++) {
			digitsSum +=  number.charAt(i);
		}
		return digitsSum % 3;
	}
}
