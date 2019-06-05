package numbertowords;

public class NumberToWordsFactory {
    public static String convert(int number, Language lang) {
        switch(lang) {
            case AR :
                return ArabicNumberToWords.convert(number);
            case EN :
                return EnglishNumberToWords.convert(number);
            case FR :
                return FrenchNumberToWords.convert(number);
        }
        return "";
    }
}
