import java.util.*;  

class MaxAndMinValues {
    public String solution(String s) {
        final String[] splitedStrings = Utils.splitStringArray(s);
        final Set<Integer> numbers = Utils.stringArrayToSet(splitedStrings);
        
        final Integer minimumVal = Utils.getMinimumValue(numbers);
        final Integer maximumVal = Utils.getMaximumValue(numbers);
        
        return minimumVal + " " + maximumVal;
    }
}

class Utils {
    public static String[] splitStringArray(final String string) {
        return string.split(" ");
    }
    
    public static Set<Integer> initHashSetBy(final int length) {
        return new HashSet<>(length);
    }
    
    public static Set<Integer> stringArrayToSet(final String[] strings) {
        Set<Integer> numbers = initHashSetBy(strings.length);

        for (String stringNumber : strings) {
            numbers.add(Integer.parseInt(stringNumber));
        }
        
        return numbers;
    }
    
    public static Integer getMinimumValue(final Set<Integer> numbers) {
        return Collections.min(numbers);
    }
    
    public static Integer getMaximumValue(final Set<Integer> numbers) {
        return Collections.max(numbers);
    }
}
