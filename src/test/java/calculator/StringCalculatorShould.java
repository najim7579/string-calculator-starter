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

  
}
