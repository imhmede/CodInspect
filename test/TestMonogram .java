
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MonogramTest {

    @InjectMocks
    private Monogram monogram = new Monogram();

    @Mock
    private Scanner scanner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    // Test getMonogram method with valid input
    @Test
    public void testGetMonogram_ValidInput_ReturnsCorrectMonogram() {
        String fullName = "John Smith";
        String expectedMonogram = "JS";

        String actualMonogram = monogram.getMonogram(fullName);

        assertEquals(expectedMonogram, actualMonogram);
    }

    // Test getMonogram method with empty input
    @Test
    public void testGetMonogram_EmptyInput_ReturnsEmptyString() {
        String fullName = "";
        String expectedMonogram = "";

        String actualMonogram = monogram.getMonogram(fullName);

        assertEquals(expectedMonagram, actualMonogram);
    }

    // Test getMonogram method with null input
    @Test
    public void testGetMonogram_NullInput_ReturnsEmptyString() {
        String fullName = null;
        String expectedMonogram = "";

        String actualMonogram = monogram.getMonogram(fullName);

        assertEquals(expectedMonagram, actualMonogram);
    }

    // Test getMonogram method with whitespace input
    @Test
    public void testGetMonogram_WhitespaceInput_ReturnsCorrectMonogram() {
        String fullName = "  John Smith   ";
        String expectedMonogram = "JS";

        String actualMonogram = monogram.getMonogram(fullName);

        assertEquals(expectedMonogram, actualMonogram);
    }

    // Test main method with valid input
    @Test
    public void testMain_ValidInput_PrintsCorrectMonogram() {
        // Mock the Scanner to return a valid input
        when(scanner.nextLine()).thenReturn("John Smith");

        monogram.main(new String[0]);

        verify(System.out).printf("The Monogram of John Smith is JS");
    }

    // Test main method with null input
    @Test
    public void testMain_NullInput_PrintsEmptyString() {
        // Mock the Scanner to return null
        when(scanner.nextLine()).thenReturn(null);

        monogram.main(new String[0]);

        verify(System.out).printf("The Monogram of is ");
    }
}
