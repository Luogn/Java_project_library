package CommandLine;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class DictionaryCommandLine {
    public static Scanner sc = new Scanner(System.in);
    public static void showAllWord() {
         String no = "No", eng = "English", viet = "Vietnamese";
         System.out.printf("%-4s | %-15s | %-15s\n", no , eng , viet);

        for(int i=0;i<Dictionary.getSize();i++){
            System.out.printf("%-4d | %-15s | %-15s\n", i+1, Dictionary.getWordList().get(i).getWordTarget(), Dictionary.getWordList().get(i).getWordExplain());
        }
    }

    public static List<String> dictionarySearcher(String target) {
        List<String> searchList = Dictionary.getTrie().getAllWordsWithPrefix(target);


//        for(int i=0;i<Dictionary.getSize();i++) {
//            if(target.equals(Dictionary.getWordList().get(i).getWordTarget())) {
//                Word rand = Dictionary.getWordList().get(i);
//                searchList.add(rand);
//            }
//        }

        return searchList;
    }

    public static void dictionaryAdvanced() throws Exception {
        System.out.println("[0] Exit");
        System.out.println("[1] Add");
        System.out.println("[2] Remove");
        System.out.println("[3] Update");
        System.out.println("[4] Display");
        System.out.println("[5] Lookup");
        System.out.println("[6] Search");
        System.out.println("[7] Game");
        System.out.println("[8] Import from file");
        System.out.println("[9] Export to file");
        System.out.println("Your Action: ");


        int noAction = Integer.parseInt(sc.nextLine());

        if(noAction == 0) {
            return;
        }

        if(noAction == 1) {
            DictionaryManagement.insertFromCommandline();
            System.out.println("Your action has been done!");
            dictionaryAdvanced();
        }

        if(noAction == 2) {
            System.out.println("Put in word you want to remove from dictionary: ");
            String word = sc.nextLine();
            DictionaryManagement.removeWord(word);
            System.out.println("Your action has been done!");
            dictionaryAdvanced();

        }

        if(noAction == 3) {
            // Cần thêm hàm update được gọi từ dictionaryManagement
            System.out.println("Choose what you want to do:\nType ADD to add more meaning\nType CHANGE to change meaning");
            String inputAct = sc.nextLine();
            System.out.println("Choose the word you want to update:");
            String engWord = sc.nextLine();
            System.out.println("Put in the meaning you want to update:");
            String vietMeaning = sc.nextLine();
            DictionaryManagement.update(engWord, vietMeaning, inputAct);
            System.out.println("Your action has been done!");
            dictionaryAdvanced();
        }

        if(noAction == 4) {
            showAllWord();
            System.out.println("Your action has been done!");
            dictionaryAdvanced();
        }

        if(noAction == 5) {
            System.out.println("Type in the word you want to look up:");
            String word = sc.nextLine();
            String res = DictionaryManagement.dictionaryLookup(word);
            System.out.println(res + "\n");
            System.out.println("Your action has been done!");
            dictionaryAdvanced();
        }

        if(noAction == 6) {
            System.out.println("Word you want to search is:");
            String word = sc.nextLine();
            List<String> searchList = dictionarySearcher(word);
            for (String w : searchList) {
                System.out.println(w);
            }
            System.out.println("Your action has been done!");
            dictionaryAdvanced();
        }

        if(noAction == 8) {
            DictionaryManagement.insertFromFile();
            System.out.println("Your action has been done!");
            dictionaryAdvanced();
        }

        if(noAction == 9) {
            DictionaryManagement.dictionaryExportToFile();
            System.out.println("Your action has been done!");
            dictionaryAdvanced();

        }

        sc.close();
    }
};