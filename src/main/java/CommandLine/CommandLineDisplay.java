package CommandLine;

public class CommandLineDisplay {
    /**
     * Khi chọn 1 trong phần menu và hoàn thành add từ, bị lỗi không nhảy vào đệ quy và hiển thị lại menu
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to My Application!");
        try {
            DictionaryCommandLine.dictionaryAdvanced();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}