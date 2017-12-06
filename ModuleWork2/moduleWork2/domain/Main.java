package moduleWork2.domain;

import moduleWork2.entitys.MapSentence;
import moduleWork2.entitys.Sentence;
import moduleWork2.entitys.Text;
import moduleWork2.entitys.Word;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Создать программу обработки текста учебника по программированию с использованием классов:
 * Символ, Слово, Предложение, Знак препинания и др.
 * Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом.
 * 10.	Существует текст и список слов.
 * Для каждого слова из заданного списка найти, сколько раз оно встречается в каждом предложении,
 * и рассортировать слова по убыванию общего количества вхождений.
 */

public class Main {
    /**
     * Way to file will process and name one
     */
    static final String FILE_NAME = "D:\\ForCreate(ua.jrc)\\Java\\Java9.1\\EPAM17\\M-Module-2\\src\\main\\resources\\text.txt";
    /**
     * List of words will look for in text
     */
    static String[] list = {"the", "to", "in", "java", "by"};
    /**
     * Mam with list of searched words and number of occurrences each
     */
    static Map<String, Integer> mList = new HashMap<String, Integer>();

    public static void main(String[] args) {
        /**
         * Create buffer for text
         */
        StringBuffer text = new StringBuffer(6000);
        /**
         * Get text from file to buffer
         */
        getFile(text, FILE_NAME);
        /**
         * Put buffered text into class type Text
         */
        Text t1 = new Text(text.toString());
        /**
         * Print the text
         */
        t1.print();

        /**
         * Count number of occurrences each words in each sentences in the text
         * And add it to Map
         */
        List<Sentence> sents = t1.getSentences();
        for (int i = 0; i < list.length; i++) {
            //Count
            int count = 0;
            for (int j = 0; j < sents.size(); j++) {
                MapSentence tM = new MapSentence(sents.get(j));
                if(tM.findWordCount(list[i]) > 0)
                    System.out.println("'" + list[i] + "'" + " in sentence " + (j+1) + " was found " + tM.findWordCount(list[i]) + " times");
                count += tM.findWordCount(list[i]);
            }
            //Add
            mList.put(list[i], count);
        }
        /**
         * Print map of words
         */
        System.out.println("\nSearched words in text:\n" + mList);
        /**
         * Sort the list of words
         */
        sort(mList, list);
        /**
         * Print sorted list of words
         */
        System.out.println("Sorted list");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

    }

    /**
     * Take buffer and fill it text from some file
     * @param text - buffer will fill
     * @param F_NAME - file name
     */
    private static void getFile(StringBuffer text, String F_NAME) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(F_NAME), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            // log error
            System.out.println("File not found!");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // log warning
                    System.out.println("File wasn't open!");
                }
            }
        }
    }

    /**
     * Sort the list of words
     * @param map - map of words and number of occurrences each
     * @param list - list will sorted
     */
    private static void sort(Map<String, Integer> map, String[] list) {
        boolean swapped = true;
        int z = 0;
        while (swapped){
            swapped = false;
            for (int i = 0; i < list.length - 1 - z; i++) {
                if (map.get(list[i]) < map.get(list[i + 1])) {
                    String a = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = a;
                    swapped = true;
                }
            }
            z++;
        }
    }

}
