package com.vaidhyamegha;

import java.util.*;
import java.util.stream.IntStream;

public class Utilities {

    // fill in your PatternCount() function here.

    /**
     *      Count(Text, Pattern), our plan is to “slide a window” down Text, checking whether each k-mer substring of Text
     *      matches Pattern. We will therefore refer to the k-mer starting at position i of Text as Text(i, k).
     *      Throughout this book, we will often use 0-based indexing, meaning that we count starting at 0 instead of 1.
     *      In this case, Text begins at position 0 and ends at position |Text| − 1 (|Text| denotes the number of symbols
     *      in Text). For example, if Text = GACCATACTG, then Text(4, 3) = ATA. Note that the last k-mer of Text begins at
     *      position |Text| − k, e.g., the last 3-mer of GACCATACTG starts at position 10 − 3 = 7.
     */
    public static int PatternCount(String text, String pattern) {
        int count = 0;

        for (int i = 0; i <= (text.length() - pattern.length()); i++){
            if(text.substring(i, i + pattern.length()).equals(pattern)){
                count = count + 1;
            }
        }

        return count;
    }

    // Place your FrequentWords() function here along with any subroutines that you need.

    /**
     *     Frequent Words Problem: Find the most frequent k-mers in a string.
     *
     *     Input: A string Text and an integer k.
     *     Output: All most frequent k-mers in Text.
     *
     *     Refer notes/FrequentWords.png
     */
    public static ArrayList<String> FrequentWords(String text, int k) {
        Set<String> freqPatterns = new HashSet<>();
        int[] count = new int[text.length() - k];
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < text.length() - k; i++){
            String pattern = text.substring(i, i+k);
            count[i] = PatternCount(text, pattern);
        }

        int max = -1;

        for (int i1 : count) max = max > i1 ? max : i1;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max){
                String pattern = text.substring(i, i+k);

                if(freqPatterns.add(pattern)) list.add(pattern);
            }
        }

        return list;
    }

    public static long PatternToNumber(String pattern) {
        int k = pattern.length();
        int[] patternNumbers = new int[k];

        for (int i = 0; i < k ; i++) {
            char c = pattern.charAt(i);
            int cnum = -1;

            switch (c){
                case 'A' :
                    cnum = 0;
                    break;
                case 'C' :
                    cnum = 1;
                    break;
                case 'G' :
                    cnum = 2;
                    break;
                case 'T' :
                    cnum = 3;
                    break;
            }

            patternNumbers[i] = cnum;
        }

        long index = 0;

        for (int i = 0; i < k ; i++) {
            index = index + (patternNumbers[k - i - 1] + 1) * (long) (Math.pow(4, i));
        }

        return index - ((long)Math.pow(4, k)- 1)/3;
    }

    public static String NumberToPattern(int index, int k){
        char[] pattern = new char[k];

        for (int i = 0; i < k; i++) {
            int num = index % 4;
            char c = '-';

            switch (num){
                case 0:
                    c = 'A';
                    break;
                case 1:
                    c = 'C';
                    break;
                case 2:
                    c = 'G';
                    break;
                case 3:
                    c = 'T';
                    break;
            }

            index = index/4;

            pattern[k - i - 1] = c;
        }

        return new String(pattern);
    }

    public static int[] FrequencyArray(String text, int k){
        int[] freq = new int[(int)(Math.pow(4,k))];
        int len = text.length();

        for (int i = 0; i <= (len - k) ; i++) {
            String pattern = text.substring(i, i + k);
            freq[(int)PatternToNumber(pattern)]++;
        }

        return freq;
    }

    public static ArrayList<String> FasterFrequentWords(String text, int k){
        int[] freq = FrequencyArray(text, k);
        ArrayList<String> list = new ArrayList<>();

        OptionalInt maxInt = Arrays.stream(freq).max();

        if (maxInt.isPresent()){
            int max = Arrays.stream(freq).max().getAsInt();

            for (int i = 0; i < freq.length; i++) if (freq[i] == max) list.add(NumberToPattern(i, k));
        }

        return  list;
    }

    public static ArrayList<String> FasterFrequentWordsBySorting(String text, int k) {
        int len = text.length();
        int[] patternIndexes;
        ArrayList<String> freqPatterns = new ArrayList<>();

        patternIndexes = IntStream.rangeClosed(0, len - k).map(i -> (int)PatternToNumber(text.substring(i, i + k))).toArray();

        Arrays.sort(patternIndexes);

        Map<Integer, Integer> patternCount = new HashMap<>();

        for (int patternIndex : patternIndexes) {
            if (patternCount.containsKey(patternIndex)) {
                patternCount.put(patternIndex, patternCount.get(patternIndex) + 1);
            } else {
                patternCount.put(patternIndex, 1);
            }
        }

        Collection<Integer> counts = patternCount.values();
        int max = Collections.max(counts);

        Set<Integer> distinctPatternIndexes = patternCount.keySet();

        for (int patternIndex: distinctPatternIndexes) {
            if(patternCount.get(patternIndex) == max)
                freqPatterns.add(NumberToPattern(patternIndex, k));
        }

        return freqPatterns;
    }

    //Fill in your ReverseComplement() function here, along with any necessary subroutines.
    public static String ReverseComplement(String pattern) {
        int len = pattern.length();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < len ; i++) {
            char c = pattern.charAt(i);
            char cc = '-';

            switch (c){
                case 'A' :
                    cc = 'T';
                    break;
                case 'C' :
                    cc = 'G';
                    break;
                case 'G' :
                    cc = 'C';
                    break;
                case 'T' :
                    cc = 'A';
                    break;
            }

            str.append(cc);
        }

        return str.reverse().toString();
    }

    // Fill in your PatternMatching() function here along with any subroutines you need.
    public static ArrayList<Integer> PatternMatching(String pattern, String genome) {
        ArrayList<Integer> positions = new ArrayList<>();
        int len = genome.length();
        int k = pattern.length();
        long patternIndex = PatternToNumber(pattern);

        for (int i = 0; i <= (len - k ); i++) {
            String kmer = genome.substring(i, i + k);
            long kmerIndex = PatternToNumber(kmer);

            if(patternIndex == kmerIndex) positions.add(i);
        }

        return positions;
    }
}
