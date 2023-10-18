package CommandLine;

public class CommandLineDisplay {
    public static void main(String[] args) {
        System.out.println("Welcome to My Application!");
        try {
            DictionaryCommandLine.dictionaryAdvanced();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}