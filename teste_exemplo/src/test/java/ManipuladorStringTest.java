import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import com.example.ManipuladorString;


public class ManipuladorStringTest {

    private final ManipuladorString manipulador = new ManipuladorString();

    @Test
    public void testInvertString() {
        assertEquals("dlroW olleH", manipulador.invertString("Hello World"));
        assertEquals("321", manipulador.invertString("123"));
        assertEquals("", manipulador.invertString(""));
        assertThrows(IllegalArgumentException.class, () -> manipulador.invertString(null));
    }

    @Test
    public void testContarVogais() {
        assertEquals(3, manipulador.contarVogais("Hello World"));
        assertEquals(0, manipulador.contarVogais("bcdfgh"));
        assertEquals(0, manipulador.contarVogais(""));
        assertThrows(IllegalArgumentException.class, () -> manipulador.contarVogais(null));
    }

    @Test
    public void testContarPalavras() {
        assertEquals(2, manipulador.contarPalavras("Hello World"));
        assertEquals(1, manipulador.contarPalavras("SingleWord"));
        assertEquals(0, manipulador.contarPalavras(""));
        assertThrows(IllegalArgumentException.class, () -> manipulador.contarPalavras(null));
        assertEquals(0, manipulador.contarPalavras("   ")); // Espaços em branco
    }
}
