package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.RemovableDigitNumber;

class RemovableDigitNumberTest {

	@Test
	void testSolve() {
		assertTrue(randomNumbersInt32SizeTest(300000));
	}

	private boolean randomNumbersInt32SizeTest(int quantity) {
		boolean passed = true;
		for (int i = 0; i < quantity; i++) {
			int number = (int)(10 + Math.random() * 2147483637);
			String numberString= String.valueOf(number);
			int max = -1;
			RemovableDigitNumber test = new RemovableDigitNumber(numberString);
			String result = test.solve();
			if(result.isEmpty()) {
				System.out.println(numberString + " -> empty string!");
				passed = false;
			}
			if(!"-1".equals(result) &&  Integer.parseInt(result) % 6 !=0) {
				System.out.println(numberString + " -> "+ result +" - Not divisible by 6!");
				passed = false;
			}
			for (int j = 0; j < numberString.length(); j++) {
				int changedNumber;
				if(j != 0 && j < numberString.length()-1) {
					changedNumber = Integer.parseInt(numberString.substring(0, j) + numberString.substring(j+1));
				} else if (j == 0) {
					changedNumber = Integer.parseInt(numberString.substring(1));
				} else {
					changedNumber = Integer.parseInt(numberString.substring(0,j));
				}
				if(changedNumber % 6 == 0 && changedNumber > max) {
					max = changedNumber;
				}	
			}
			if(Integer.parseInt(result) != max) {
				System.out.println(numberString + "became into " + result + " but should be " + max);
				passed = false;
			}
		}
		return passed;
	}
}
