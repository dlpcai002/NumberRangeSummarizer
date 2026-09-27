package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.trim().isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        //if collection passed directly rather than string input
        List<Integer> sortedNumbers = input.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        List<String> ranges = new ArrayList<>();
        int start = sortedNumbers.get(0);
        int prev = start;

        for (int i = 1; i < sortedNumbers.size(); i++) {
            int current = sortedNumbers.get(i);

            if (current == prev + 1) {
                prev = current;
            } else {
                ranges.add(formatRange(start, prev));
                start = current;
                prev = current;
            }
        }
        
        ranges.add(formatRange(start, prev));
        return String.join(", ", ranges);
    }

    private String formatRange(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "-" + end;
        }
    }

  
}
