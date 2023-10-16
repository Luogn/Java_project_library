package CommandLine;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandLine {
    public static void showAllWord() {
         String no = "No", eng = "English", viet = "Vietnamese";
         System.out.printf("%-4s | %-15s | %-15s\n", no , eng , viet);

        for(int i=0;i<Dictionary.getSize();i++){
            System.out.printf("%-4d | %-15s | %-15s\n", i+1, Dictionary.getWordList().get(i).getWordTarget(), Dictionary.getWordList().get(i).getWordExplain());
        }
    }

    public static void dictionaryBasic(){
        DictionaryManagement.insertFromCommandline();
        showAllWord();
    }

    public static void dictionarySearcher(String target) {
        List<String> searchList = new ArrayList<>();

        for(int i=0;i<Dictionary.getSize();i++) {
            if(target.equals(Dictionary.getWordList().get(i).getWordTarget().substring(0, target.length()))) {
                String rand = Dictionary.getWordList().get(i).getWordTarget();
                searchList.add(rand);
            }
        }

        for(int i=0;i<searchList.size();i++) {
            System.out.println(searchList.get(i));
        }
    }

    public static void dictionaryAdvanced() throws Exception {
        System.out.println("Welcome to My Application!");
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

        Scanner sc = new Scanner(System.in);
        int noAction = sc.nextInt();
        sc.close();

        if(noAction == 0) {
            return;
        }

        if(noAction == 1) {

        }

        if(noAction == 4) {
            showAllWord();
        }

        if(noAction == 8) {
            DictionaryManagement.insertFromFile();
        }

        if(noAction == 9) {
            DictionaryManagement.dictionaryExportToFile();
        }
    }
};