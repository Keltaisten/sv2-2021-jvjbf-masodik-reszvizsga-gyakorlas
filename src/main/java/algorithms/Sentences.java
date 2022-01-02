package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {
    List<String> sentences = new ArrayList<>();

    public void addSentence(String sentence){
        if(checkFisrtLetter(sentence) && checkLastSymbol(sentence)){
            sentences.add(sentence);
        }
        else {

        }
    }

    private boolean checkLastSymbol(String sentence) {
        String lastSymbol = String.valueOf(sentence.charAt(sentence.length()-1));
        boolean lastSymbolDot = lastSymbol.equals(".");
        boolean lastSymbolQuestionMark = lastSymbol.equals("?");
        boolean lastSymbolExclamationMark  = lastSymbol.equals("!");
        if( ! (lastSymbolDot || lastSymbolQuestionMark || lastSymbolExclamationMark)){
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
        return lastSymbolDot || lastSymbolQuestionMark || lastSymbolExclamationMark;
    }

    private boolean checkFisrtLetter(String sentence) {
        String firstLetter = String.valueOf(sentence.charAt(0));
        if( ! firstLetter.equals(firstLetter.toUpperCase())){
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        return firstLetter.equals(firstLetter.toUpperCase());
    }

    public List<String> getSentences() {
        return sentences;
    }

    public String findLongestSentence(){
        String longestSentence = "";
        int length = 0;
        for(String sentence: sentences){
            if(sentence.length() > length){
                longestSentence = sentence;
                length = longestSentence.length();
            }
        }
        if(longestSentence.equals("")){
            throw new IllegalStateException();
        }
        return longestSentence;
    }
}
