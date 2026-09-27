package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CollectTests {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplementation();

    @Test
    void testCollectWithValidInput() {
        String input = "1, 2, 3, 4, 5";
        Collection<Integer> collected = summarizer.collect(input);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, collected);
    }

    @Test
    void testWhitespaceHandling() {
        String input = " 1 , 2 , 3 , 4 , 5 ";
        Collection<Integer> collected = summarizer.collect(input);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, collected);
    }

    @Test
    void testCollectWithEmptyInput() {
        String input = "";
        Collection<Integer> collected = summarizer.collect(input);
        assertTrue(collected.isEmpty());
    }

    @Test
    void testCollectWithNullInput() {
        String input = null;
        Collection<Integer> collected = summarizer.collect(input);
        assertTrue(collected.isEmpty());
    }

    @Test
    void testCollectWithInvalidInput() {
        String input = "1, 2, a, 4, 5";
        assertThrows(NumberFormatException.class, () -> {
            summarizer.collect(input);
        });
    }
}