package chatGPT;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChatGPT {
	
	private static final String API_KEY = "sk-VVweUI6uS1L0rn7VNxVDKGkkzXJy4XB1I6Gz_6T_T5T3BlbkFJsDJE_B_ubMBPjJcmXyj-IMAlpwbJFZdP7NWSOSHb0A";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

	public static void main(String[] args) {

		try {
			chatting("Hello Chat");
		} catch (IOException | InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void chatting(String message) throws IOException, InterruptedException 
	{
		var body = """
                {
                "model": "tts-1-hd-1106",
                "messages": [
                    {
                        "role": "user",
                        "content": \"""" + message + "\" "
                  + "} ] }";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
	}
	
}
