import org.example.CalcService;
import org.example.exceptions.DivisionByZeroException;
import org.example.exceptions.IncorrectArgException;
import org.example.exceptions.IncorrectOperationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;


public class CalcServiceTest {
    private CalcService calcService;


    @Before
    public void setUp() {
        calcService = new CalcService();
    }


    @Test
    public void testSum() throws IncorrectArgException, DivisionByZeroException, IncorrectOperationException {
        System.setIn(new ByteArrayInputStream("+\n3\n4\n".getBytes()));
        double result = calcService.calculate();
        Assert.assertEquals(7.0, result, 0.0001);
    }


    @Test
    public void testDiff() throws IncorrectArgException, DivisionByZeroException, IncorrectOperationException {
        System.setIn(new ByteArrayInputStream("-\n143262\n3464.43453\n".getBytes()));
        double result = calcService.calculate();
        Assert.assertEquals(139797.56547, result, 0.0001);
    }


    @Test
    public void testMultiplication() throws IncorrectArgException, DivisionByZeroException, IncorrectOperationException {
        System.setIn(new ByteArrayInputStream("*\n70.27\n-2.12\n".getBytes()));
        double result = calcService.calculate();
        Assert.assertEquals(-148.9724, result, 0.0001);
    }


    @Test
    public void testDivision() throws IncorrectArgException, DivisionByZeroException, IncorrectOperationException {
        System.setIn(new ByteArrayInputStream("/\n24\n8\n".getBytes()));
        double result = calcService.calculate();
        Assert.assertEquals(3.0, result, 0.0001);
    }


    @Test
    public void testIncorrectArgException() {
        System.setIn(new ByteArrayInputStream("/\nff\nf\n".getBytes()));
        Assert.assertThrows(IncorrectArgException.class, () -> calcService.calculate());
    }


    @Test
    public void testDivisionByZero() {
        System.setIn(new ByteArrayInputStream("/\n10\n0\n".getBytes()));
        Assert.assertThrows(DivisionByZeroException.class, () -> calcService.calculate());
    }


    @Test(expected = IncorrectOperationException.class)
    public void testIncorrectOperationException() throws IncorrectArgException, DivisionByZeroException, IncorrectOperationException {
        System.setIn(new ByteArrayInputStream("whth\n3\n4\n".getBytes()));
        calcService.calculate();
    }
}
