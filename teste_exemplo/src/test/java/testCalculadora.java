import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import static org.junit.Assert.*;

import java.lang.IllegalArgumentException;
import com.example.Calculadora;

/**
 * testCalculadora
 */
public class testCalculadora {

    Calculadora calc = new Calculadora();

    // criar test
    @Test
    public void testSoma() {
        double result = calc.soma(3, 9);
        assertEquals(12, result, 0);
    }
    @Test
    public void testSub() {
        double result = calc.subtrair(10, 9);
        assertEquals(1, result, 0);
    }
    @Test
    public void testMult() {
        double result = calc.multiplica(3, 9);
        assertEquals(27, result, 0);
    }
    @Test
    public void testDiv() {
        double result = calc.divide(18, 9);
        assertEquals(2, result, 0);
    }
    
    @Test
    public void testDivisao0() {
    assertThrows(IllegalArgumentException.class,()-> calc.divide(10,0));

}
}