import java.util.*;

class TheBiggestNumber {
    
    private static String ZERO = "0";
    
    public String solution(int[] numbers) {
        TheBiggestNumberHelper theBiggestNumberHelper = new TheBiggestNumberHelper();
        
        String[] strings = theBiggestNumberHelper.toStringArray(numbers);
        
        theBiggestNumberHelper.getSortedList(strings);
        
        if (ZERO.equals(strings[0])) return ZERO; 
        
        return String.join("", strings);
    }

}

class TheBiggestNumberHelper {

    public void getSortedList(final String[] strings) {
        Arrays.sort(strings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
    }

    public String[] toStringArray(final int[] numbers) {
        String[] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        return strings;
    }
}
