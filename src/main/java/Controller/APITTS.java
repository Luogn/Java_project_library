package Controller;

import com.google.gson.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import javax.sound.sampled.*;
import java.net.http.*;
public class APITTS {
    public static void audioPhat(String word) {
        try {
            String API = String.format("https://api.dictionaryapi.dev/api/v2/entries/en/%s", URLEncoder.encode(word, "UTF-8"));

            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API)).build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());
                // Xử lý dữ liệu JSON
                String jsonResponse = (String) response.body();
                // Gọi hàm để phân tích và lấy URL phát âm từ JSON
                String audioUrl = getAudioUrlFromJson(jsonResponse);
                // Gọi hàm để phát âm từ
                try {
                    playAudio(audioUrl);
                }catch (MalformedURLException m) {
                    assert audioUrl != null;
//                    System.out.printf("%s%",audioUrl);
                    System.out.println("không có audioUrl");
                }
        } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        }
    public static String getAudioUrlFromJson(String jsonResponse) throws IOException {
        JsonElement jsonElement = JsonParser.parseString(jsonResponse);
        if(jsonElement.isJsonArray()) {
            JsonArray jsonArray = JsonParser.parseString(jsonResponse).getAsJsonArray();
            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

            // Lấy URL audio từ JSON
            JsonArray phoneticsArray = jsonObject.getAsJsonArray("phonetics");
            for (int i = 0; i < phoneticsArray.size(); i++) {
                JsonObject phoneticsObject = phoneticsArray.get(i).getAsJsonObject();
                String audioUrl = phoneticsObject.get("audio").getAsString();
                if (!audioUrl.isEmpty()) {
                    return audioUrl;
                }
            }
        }else {
            System.out.println("Định dạng JSON không hợp lệ trong phản hồi từ API.");
        }
            return null;
        }

        // Trả về null nếu không tìm thấy URL phát âm hợp lệ
    public static void playAudio(String audioUrl) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        if (audioUrl != null) {
            try {
                URL url = new URL(audioUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                try (InputStream in = new BufferedInputStream(httpURLConnection.getInputStream())) {
                    // Kiểm tra xem định dạng của tệp âm thanh có được hỗ trợ không
                    AdvancedPlayer player = new AdvancedPlayer(in);
                    player.play();

                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (MalformedURLException | JavaLayerException e) {
                throw new MalformedURLException();
            }
        } else {
            System.out.println("khong co urlaudio");
        }
    }
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        APITTS.audioPhat("dog");
    }
}
