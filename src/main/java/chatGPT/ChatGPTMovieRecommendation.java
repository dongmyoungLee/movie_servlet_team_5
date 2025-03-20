package chatGPT;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

public class ChatGPTMovieRecommendation {
    private static final String API_KEY = "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"; // 본인의 API 키로 대체
    private static final String MODEL_NAME = "text-davinci-003"; // 채팅 모델 이름

    public String sendChatGptRequest(String userInput) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("https://api.openai.com/v1/completions");
        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + API_KEY);
        request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());

        StringEntity requestEntity = new StringEntity(
                "{\"model\":\"" + MODEL_NAME + "\",\"prompt\":\"" + userInput + "\",\"max_tokens\":200}",
                ContentType.APPLICATION_JSON
        );
        request.setEntity(requestEntity);

        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] extractChatGptReply(String chatGptResponse) {
        Gson gson = new Gson();
        ChatGptResponse response = gson.fromJson(chatGptResponse, ChatGptResponse.class);

        if (response.choices != null && response.choices.length > 0) {
            String text = response.choices[0].text;
            return text.split("\\n");
        } else {
            return new String[0];
        }
    }


    private static class ChatGptResponse {
        ChatGptChoice[] choices;

        @Override
        public String toString() {
            return "ChatGptResponse{" +
                    "choices=" + Arrays.toString(choices) +
                    '}';
        }
    }

    private static class ChatGptChoice {
        public String text;
        public int index;
        public Object logprobs;
        public String finish_reason;

        @Override
        public String toString() {
            return "ChatGptChoice{" +
                    "text='" + text + '\'' +
                    ", index=" + index +
                    ", logprobs=" + logprobs +
                    ", finish_reason='" + finish_reason + '\'' +
                    '}';
        }
    }

    private static class ChatGptMessage {
        String role;
        String content;
    }
}
