
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public final class Strings {

    private static final Set<Character> allVowels
            = new HashSet(Arrays.asList('a', 'i', 'u', 'e', 'o'));

    private Strings(){
        throw new AssertionError("Cannot be instantiated");
    }

    public static Pair<Integer, Integer> countVowelsAndConsonantsV1(String str){

        if(str == null || str.isBlank()){
            return Pair.of(-1, -1);
        }
        str = str.toLowerCase();

        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (allVowels.contains(ch)){
                vowels++;
            }else if((ch >= 'a' && ch <= 'z')){
                consonants++;
            }
        }
        return Pair.of(vowels, consonants);
    }

    public static Pair<Long, Long> countVowelsAndConsonantsV2(String str){

        if(str == null || str.isBlank()){
            return Pair.of(-1L, -1L);
        }
        str = str.toLowerCase();
        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> (ch >= 'a' && ch <='z'))
                .collect(partitioningBy(c -> allVowels.contains(c),counting()));

        return Pair.of(result.get(true), result.get(false));
    }
}
