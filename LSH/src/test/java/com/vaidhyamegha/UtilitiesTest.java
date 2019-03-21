package com.vaidhyamegha;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void patternCount() {
        //should be 2
        int count = Utilities.PatternCount("GCGCG", "GCG");
        System.out.println(count);
        assertEquals(count, 2);

        //should be 21
        count = Utilities.PatternCount("ACGGCGCCTGGAACACTGGAACTACTGGAACTGACGCTGGAACCCTGGAACCTAGCTGGAACGGCGTGTCCTGGAACTCTCTGGAACATCCTGGAACCTGGAACACTGGAACGACTGGAACCTGGAACCCCTGAATTCAGCACCCTGGAACGGCAACTGGAACAAGTCTGGAACGTAGGTCATGCCTGGAACACCGAATGCTGGAACTGTCTCTGGAACCCTACTGGAACGCTCCTGGAACACTGGAACGACTGGAACTCTGGAACTCTGGAACCTGGAACCCTGGAACCCCTGGAACCTGGAACTTCTGGAACACTGGAACCATACTGGAACCCTGGAACCTGGAACCTCTGGAACGCTGGAACCTCTGGAACCTGGAACGCCTGGAACTACTGGAACGGGTCTGGAACTACTGGAACTCCCTGGAACTACCTGGAACCTGGAACATCTGGAACCACTGGAACTCAATAGGCTGGAACCTGGAACCCTGGAACCTGGAACGCTGCTGGAACCTGGAACGCTGGAACCCTGGAACTACGACTGGAACGCTGGAACCTGCTGGAACTGCTGGAACCCTGGAACACTGGAACCAAGAATCATGGCTGGAACATGCCGTTGGCGCTGGAACGCTGGAACAACTGGAACCCGCTGGAACTTCGGTGCATCTGGAACACTGGAACATCTACTGGAACGGGACTGGAACGGTTCATGGATACTGGAACATGACTGGAACCCCGCTGGAACCCTGGAACTGCTGGAACCAAAGCTGGAACCTGGAACCTGGAACACCTGGAACCTGGAACATTAGACTGGAACAGGAACTGGAACCTGGAACACAGCTGGAACTGGGCCTGGAACAGCTGGAACCTGGAACATCTGGAACTCTGGAACCTGGAACGTATCTATCAGTCCACTCTTCCCTGGAACGACTGGAACCTAGGCTGGAACGCTGGAAC", "CTGGAACCT");
        System.out.println(count);
        assertEquals(count, 21);
    }

    @Test
    public void frequentWords() {
        //should be 2 sized Arraylist
        List<String> frequentWords = Utilities.FrequentWords("ACGTTGCATGTCGCATGATGCATGAGAGCT", 4);
        System.out.println(frequentWords);
        assertTrue(frequentWords.contains("CATG"));
        assertTrue(frequentWords.contains("GCAT"));
        assertEquals(2, frequentWords.size());

        //should be 6 sized Arraylist
        frequentWords = Utilities.FrequentWords("GGAATTGGTAGCCGCTCGGCAAACGACGGCAAACGACGGCAAACGACAGCCGCTCGGCAAACGACAACAGGTCATAGCCGCTCGGCAAACGACGTCACGCGGGTCACGCGGGGCAAACGACGTCACGCGGGGAATTGGTGGCAAACGACGTCACGCGGGTCACGCGGAGCCGCTCGTCACGCGGAACAGGTCATGTCACGCGGGGCAAACGACGGAATTGGTGGCAAACGACGTCACGCGGGGCAAACGACAACAGGTCATAGCCGCTCAGCCGCTCGTCACGCGGGGCAAACGACAACAGGTCATGGCAAACGACGGCAAACGACGGAATTGGTGGAATTGGTGTCACGCGGGGAATTGGTGGAATTGGTGGCAAACGACGTCACGCGGGTCACGCGGAGCCGCTCGTCACGCGGAGCCGCTCAACAGGTCATAACAGGTCATGTCACGCGGAGCCGCTCAACAGGTCATAGCCGCTCGGAATTGGTGGCAAACGACGGCAAACGACAGCCGCTCGGCAAACGACGGAATTGGTAACAGGTCATAACAGGTCATGTCACGCGGGGAATTGGTGGAATTGGTGGAATTGGTGGCAAACGACGTCACGCGGGGAATTGGTGTCACGCGGGTCACGCGGAGCCGCTCAGCCGCTCAGCCGCTCAGCCGCTCAGCCGCTCGTCACGCGGAACAGGTCATAACAGGTCATGGAATTGGTGGAATTGGTGTCACGCGGAGCCGCTCGTCACGCGGAGCCGCTCAGCCGCTCAGCCGCTCGGCAAACGACGGAATTGGTAGCCGCTCGGCAAACGACGTCACGCGGGTCACGCGGAGCCGCTCAGCCGCTCAGCCGCTCGGCAAACGACGGAATTGGTAACAGGTCATGGCAAACGACGTCACGCGGAACAGGTCATGGAATTGGT", 12);
        System.out.println(frequentWords);
        //[GGCAAACGACGG, AGCCGCTCAGCC, GCCGCTCAGCCG, CCGCTCAGCCGC, CGCTCAGCCGCT, GCTCAGCCGCTC]
        assertTrue(frequentWords.contains("GGCAAACGACGG"));
        assertTrue(frequentWords.contains("AGCCGCTCAGCC"));
        assertTrue(frequentWords.contains("GCCGCTCAGCCG"));
        assertTrue(frequentWords.contains("CCGCTCAGCCGC"));
        assertTrue(frequentWords.contains("CGCTCAGCCGCT"));
        assertTrue(frequentWords.contains("GCTCAGCCGCTC"));
        assertEquals(6, frequentWords.size());

    }

    @Test
    public void patternToNumber() {
        assertEquals(0, Utilities.PatternToNumber("A"));
        assertEquals(1, Utilities.PatternToNumber("C"));
        assertEquals(2, Utilities.PatternToNumber("G"));
        assertEquals(3, Utilities.PatternToNumber("T"));
        assertEquals(0, Utilities.PatternToNumber("AA"));
        assertEquals(0, Utilities.PatternToNumber("AAA"));
        assertEquals(12, Utilities.PatternToNumber("ATA"));
        assertEquals(912, Utilities.PatternToNumber("ATGCAA"));

    }

    @Test
    public void numberToPattern() {
        assertEquals("A", Utilities.NumberToPattern(0, 1));
        assertEquals("C", Utilities.NumberToPattern(1, 1));
        assertEquals("G", Utilities.NumberToPattern(2, 1));
        assertEquals("T", Utilities.NumberToPattern(3, 1));
        assertEquals("AA", Utilities.NumberToPattern(0, 2));
        assertEquals("AAA", Utilities.NumberToPattern(0, 3));
        assertEquals("ATA", Utilities.NumberToPattern(12, 3));
        assertEquals("CCCATTC", Utilities.NumberToPattern(5437, 7));
        assertEquals("ACCCATTC", Utilities.NumberToPattern(5437, 8));

    }

    @Test
    public void frequencyArray() {
        assertEquals("[2, 1, 0, 0, 0, 0, 2, 2, 1, 2, 1, 0, 0, 1, 1, 0]", Arrays.toString(Utilities.FrequencyArray("ACGCGGCTCTGAAA", 2)));
        assertEquals("[0, 1, 1, 0, 1, 0, 0, 2, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 3, 0, 0, 2, 1, 0, 3, 0, 2, 0, 0, 1, 0, 0, 1, 2, 0, 1, 1, 0, 1, 1, 3, 0, 1, 0, 1, 2, 0, 0, 1, 0, 2, 1, 0, 0, 0, 0, 0, 0, 2, 2, 0, 1, 0, 0, 0, 3, 0, 3, 0, 0, 0, 1, 0, 0, 0, 1, 2, 0, 0, 1, 0, 0, 0, 1, 1, 1, 3, 1, 0, 0, 1, 2, 1, 0, 0, 1, 1, 0, 1, 0, 3, 3, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0, 1, 0, 3, 2, 0, 0, 3, 1, 0, 1, 2, 0, 0, 1, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 3, 0, 0, 1, 0, 1, 1, 1, 2, 0, 0, 0, 2, 0, 0, 2, 1, 1, 2, 2, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 2, 0, 1, 0, 1, 0, 0, 1, 1, 0, 2, 2, 0, 2, 1, 0, 1, 0, 2, 1, 0, 0, 0, 0, 3, 0, 0, 1, 1, 0, 3, 1, 1, 2, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 2, 1, 0, 0, 2, 1, 0, 0, 0, 1, 1, 1, 2, 0, 0, 0, 2, 0, 1, 2, 0, 0, 0, 0, 3, 1, 0, 1, 1, 2, 1, 2, 3, 0, 1, 0, 0, 1, 1, 2, 0, 1, 0, 2, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 3, 2, 1, 0, 2, 1, 1, 2, 0, 1, 1, 0, 3, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 2, 2, 3, 3, 0, 2, 0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 4, 1, 1, 0, 3, 3, 1, 2, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 2, 1, 2, 1, 0, 0, 0, 3, 0, 0, 0, 0, 1, 0, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 2, 0, 1, 0, 1, 0, 1, 1, 0, 2, 0, 0, 1, 0, 2, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 2, 1, 0, 1, 2, 3, 0, 1, 1, 0, 4, 1, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 2, 3, 0, 0, 0, 2, 0, 0, 1, 0, 1, 0, 0, 0, 2, 1, 0, 1, 0, 3, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 2, 2, 0, 0, 1, 2, 2, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 3, 0, 0, 1, 2, 1, 0, 1, 1, 0, 1, 2, 0, 0, 0, 2, 1, 1, 2, 2, 0, 0, 0, 4, 1, 0, 2, 0, 0, 2, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 2, 0, 0, 2, 1, 1, 0, 1, 1, 1, 1, 1, 1, 3, 0, 1, 0, 0, 1, 1, 0, 0, 0, 2, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 3, 0, 1, 1, 0, 0, 2, 1, 0, 0, 2, 2, 0, 3, 1, 2, 0, 0, 0, 2, 1, 0, 1, 2, 0, 0, 0, 1, 0, 0, 2, 0, 0, 3, 1, 0, 2, 1, 0, 0, 0, 1, 0, 2, 1, 0, 1, 2, 0, 1, 1, 0, 1, 0, 0, 1, 2, 1, 2, 1, 1, 0, 2, 1, 0, 2, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 2, 1, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2, 4, 2, 0, 0, 0, 2, 2, 1, 0, 1, 2, 1, 0, 0, 2, 0, 1, 0, 0, 0, 0, 1, 0, 2, 1, 0, 1, 0, 2, 0, 1, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 2, 0, 0, 1, 2, 1, 0, 1, 1, 2, 0, 0, 1, 0, 1, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 2, 2, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 2, 1, 0, 4, 0, 1, 1, 2, 2, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 4, 0, 2, 0, 0, 1, 1, 0, 0, 2, 0, 0, 1, 2, 0, 1, 1, 0, 2, 2, 0, 0, 0, 0, 1, 0, 0, 3, 1, 0, 0, 0, 1, 0, 0, 2, 0, 0, 2, 3, 1, 0, 1, 1, 0, 1, 0, 2, 1, 4, 0, 0, 0, 0, 1, 1, 0, 0, 3, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 2, 0, 1, 2, 3, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 2, 0, 3, 2, 0, 0, 1, 0, 1, 2, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 3, 0, 2, 4, 0, 4, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0]", Arrays.toString(Utilities.FrequencyArray("ATCAGTTGACATAACCCACCAATGTTGCAGTCTCATCCCCCAAACTGGACTTTACGGAATAACCGACCTCGTGCAGTCGTGTTCAAACTTTGAGAGGCTCGACGTGTGTCTGCGTTGAGTAATATTGACTTGCGTTATTCTTAGAATTAGATTATTTGCAATACAGGACAGGTGCAGTGTGGGCGGAGTCTTACGTCGACAATGTGTGCTTCGGGATCGCGCCACCCCCCAAGGGCACTCCATCCTCGATTGGAATCGACGTTCCGCGTAGGCATCCCAGGCTACACGCAAGTATTTGAGAAGACCTTCCAGGCAACTGGCGCAGGCGTACTGGTTCACCCCTCTCATGTGTTTATATTGCAGCGAGGTCGACTTACAGGGATCCCCTGACTTGTCCAACGTCGCTGCGAGTGCTGCAACGTCCAAAAGACGCAGAAGTTTGCACCTTCTTCTACCTGACATAAGGGGAATACCTTCGTCATATTAGAAGACGGTTTAGCTAAATACACATAGGACGATACTTGAGAGCTCCAACGAAGATAGCGTTCTTAGCTCCAATGCCTGCGTCCCAATCCGGATGATAAGATTGGTTATGATGGGAAAACACAATCGATCATCTATGGCTGAGCCCCAAGTCAGGGACGGCACGCCGTACTAACGTGAACCTATCTATAGCCCCGTGTGGGGCCGCGAGCCCGCGTCGGGCTACGTGTCTAAGGCCAAGCGGCGGAAAG", 5)));
    }

    @Test
    public void fasterFrequentWords() {
        //should be 2 sized Arraylist
        List<String> frequentWords = Utilities.FasterFrequentWords("ACGTTGCATGTCGCATGATGCATGAGAGCT", 4);
        System.out.println(frequentWords);
        assertTrue(frequentWords.contains("CATG"));
        assertTrue(frequentWords.contains("GCAT"));
        assertEquals(2, frequentWords.size());

        //should be 6 sized Arraylist
        frequentWords = Utilities.FasterFrequentWords("GGAATTGGTAGCCGCTCGGCAAACGACGGCAAACGACGGCAAACGACAGCCGCTCGGCAAACGACAACAGGTCATAGCCGCTCGGCAAACGACGTCACGCGGGTCACGCGGGGCAAACGACGTCACGCGGGGAATTGGTGGCAAACGACGTCACGCGGGTCACGCGGAGCCGCTCGTCACGCGGAACAGGTCATGTCACGCGGGGCAAACGACGGAATTGGTGGCAAACGACGTCACGCGGGGCAAACGACAACAGGTCATAGCCGCTCAGCCGCTCGTCACGCGGGGCAAACGACAACAGGTCATGGCAAACGACGGCAAACGACGGAATTGGTGGAATTGGTGTCACGCGGGGAATTGGTGGAATTGGTGGCAAACGACGTCACGCGGGTCACGCGGAGCCGCTCGTCACGCGGAGCCGCTCAACAGGTCATAACAGGTCATGTCACGCGGAGCCGCTCAACAGGTCATAGCCGCTCGGAATTGGTGGCAAACGACGGCAAACGACAGCCGCTCGGCAAACGACGGAATTGGTAACAGGTCATAACAGGTCATGTCACGCGGGGAATTGGTGGAATTGGTGGAATTGGTGGCAAACGACGTCACGCGGGGAATTGGTGTCACGCGGGTCACGCGGAGCCGCTCAGCCGCTCAGCCGCTCAGCCGCTCAGCCGCTCGTCACGCGGAACAGGTCATAACAGGTCATGGAATTGGTGGAATTGGTGTCACGCGGAGCCGCTCGTCACGCGGAGCCGCTCAGCCGCTCAGCCGCTCGGCAAACGACGGAATTGGTAGCCGCTCGGCAAACGACGTCACGCGGGTCACGCGGAGCCGCTCAGCCGCTCAGCCGCTCGGCAAACGACGGAATTGGTAACAGGTCATGGCAAACGACGTCACGCGGAACAGGTCATGGAATTGGT", 12);
        System.out.println(frequentWords);
        //[GGCAAACGACGG, AGCCGCTCAGCC, GCCGCTCAGCCG, CCGCTCAGCCGC, CGCTCAGCCGCT, GCTCAGCCGCTC]
        assertTrue(frequentWords.contains("GGCAAACGACGG"));
        assertTrue(frequentWords.contains("AGCCGCTCAGCC"));
        assertTrue(frequentWords.contains("GCCGCTCAGCCG"));
        assertTrue(frequentWords.contains("CCGCTCAGCCGC"));
        assertTrue(frequentWords.contains("CGCTCAGCCGCT"));
        assertTrue(frequentWords.contains("GCTCAGCCGCTC"));
        assertEquals(6, frequentWords.size());
    }
}
