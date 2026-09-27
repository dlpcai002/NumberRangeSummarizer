package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InputTests {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplementation();

    @Test
    void testSampleInput() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }

    @Test 
    void testEmptyInput() {
        String input = "";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("", result);
    }

    @Test
    void testSingleNumberInput() {
        String input = "5";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("5", result);
    }

    @Test
    void testUnorderedInput() {
        String input = "5, 1, 3, 2, 4";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("1-5", result);
    }

    @Test
    void testInputWithDuplicates() {
        String input = "1, 2, 2, 3, 4, 4, 5";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("1-5", result);
    }

    @Test
    void testInputWithNegativeNumbers() {
        String input = "-3, -2, -1, 0, 1, 2";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("-3-2", result);
    }

    @Test
    void testMixedDisjointInput() {
        String input = "1, 2, 4, 6, 7, 8, 10";
        Collection<Integer> collected = summarizer.collect(input);
        String result = summarizer.summarizeCollection(collected);
        assertEquals("1-2, 4, 6-8, 10", result);
    }

    @Test
    void testCustomListInput() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 5, 6, 8, 9, 10);
        String result = summarizer.summarizeCollection(input);
        assertEquals("1-3, 5-6, 8-10", result);
    }
}