import org.junit.Assert;
import org.junit.Test;
import src.Match;

public class TestMatch {

    @Test
    public void testFind_withUppercaseLetter() {
        Assert.assertEquals(3, Match.find("Bananas", 'A'));
    }

    @Test
    public void testFind_withLowercaseLetter() {
        Assert.assertEquals(3, Match.find("Bananas", 'a'));
    }

    @Test
    public void testFind_noOccurrences() {
        Assert.assertEquals(0, Match.find("Bananas", 'x'));
    }

    @Test
    public void testFind_emptyString() {
        Assert.assertEquals(0, Match.find("", 'a'));
    }

    @Test
    public void testFind_caseInsensitiveCheck() {
        Assert.assertEquals(2, Match.find("Hello World", 'o'));
    }
}
