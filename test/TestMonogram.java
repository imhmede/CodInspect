import org.junit.*;

public class TestMonogram {

    Monogram monogram;

    // @BeforeAll
    @Before
    public void setup() {
        monogram = new Monogram(); 
    }

    @Test
    public void testGetMonogram_EmptyName() {
        String name = "";
        String expected = "";
        String actual = monogram.getMonogram(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonogram_NullName() {
        String name = null;
        String expected = "";
        String actual = monogram.getMonogram(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonogram_SingleWordName() {
        String name = "John";
        String expected = "J";
        String actual = monogram.getMonogram(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonogram_MultipleWordsName() {
        String name = "John Doe";
        String expected = "JD";
        String actual = monogram.getMonogram(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonogram_NameWithSpaces() {
        String name = "John  Doe";
        String expected = "J D";
        String actual = monogram.getMonogram(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonogram_NameWithSpecialCharacters() {
        String name = "John!Doe";
        String expected = "JD";
        String actual = monogram.getMonogram(name);
        Assert.assertEquals(expected, actual);
    }
}