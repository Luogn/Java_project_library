package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

public class TranslationController {
    @FXML
    TextArea targetArea;
    @FXML
    TextArea meaningArea;
    String textenvi;

    public String translate(String langFirst, String langSecond, String text) throws IOException {
        try {
            String API = String.format("https://translate.googleapis.com/translate_a/single?client=gtx&sl=%s&tl=%s&dt=t&q=%s",
                    langFirst, langSecond, URLEncoder.encode(text, "UTF-8"));

            HttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(API);

            HttpResponse response = httpClient.execute(request);
            String result = EntityUtils.toString(response.getEntity());

            Gson gson = new Gson();
            List<List<List<String>>> jsonData = gson.fromJson(result, List.class);

                List<List<String>> translationItems = jsonData.get(0);

            StringBuilder translation = new StringBuilder();

            for (List<String> item : translationItems) {
                Iterator<String> translationLineString = item.iterator();
                translation.append(" ").append(translationLineString.next());
            }

            if (translation.length() > 1) {
                translation.deleteCharAt(0);
            }

            return translation.toString();
        } catch (NullPointerException ne ) {
            throw ne;
        }
    }

    public  void  English_transto_VietNam() {
        try {
            textenvi = targetArea.getText();
            String a= translate("en", "vi", textenvi);
            meaningArea.setText(a);

        } catch (IOException e) {
            String exception = e.toString();
            targetArea.setText("Lỗi đọc hiểu" + exception);
            System.out.println(targetArea);
        }catch (NullPointerException ne) {
            meaningArea.setText("Vui lòng nhập từ muốn dịch!");
        }
    }

    public void  VietName_transto_English() {
        try {
            textenvi = meaningArea.getText();
            String a= translate("vi", "en", textenvi);
            targetArea.setText(a);
        } catch (IOException e) {
            String exception = e.toString();
            targetArea.setText("Lỗi đọc hiểu" + exception);
            System.out.println(targetArea);
        } catch (NullPointerException ne) {
            targetArea.setText("Please enter the word you want to translate!");
        }
    }
}
