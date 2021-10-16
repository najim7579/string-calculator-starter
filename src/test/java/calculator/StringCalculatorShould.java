package calculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;


public class StringCalculatorShould {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
   public void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals( stringCalculator.add("") , 0);
    }

    @Test
    public void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("1"),1 );
        assertEquals(stringCalculator.add("5"), 5);
    }
    
    @Test
    public void numbersCommaDelimitedShouldBeSummed() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("1,2"), 3);
        assertEquals(25, stringCalculator.add("10,15"));
    }
    
    @Test
    public void numbersNewlineDelimitedShouldBeSummed() {
    	 StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("1\n2"), 3);
        assertEquals(stringCalculator.add("11\n13"), 24);
    }

    @Test
    public void threeNumbersDelimitedAnywayShouldBeSummed() {
    	 StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("1,2,3"), 6);
        assertEquals(stringCalculator.add("5\n2\n3"), 10);
    }
    
    @Test
    public void negativeInputReturnsException() {
    	 StringCalculator stringCalculator = new StringCalculator();
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negative input!");
        stringCalculator.add("-1");
        stringCalculator.add("-5,10\n-15");
    }
    @Test
    public void numbersGreaterThan1000AreIgnored() {
    	 StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("5,12,1001"), 17);
        assertEquals(stringCalculator.add("14124,22\n4,1214"), 26);
    }
	

  
}
