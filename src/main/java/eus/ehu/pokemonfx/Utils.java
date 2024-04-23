package eus.ehu.pokemonfx;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Utils {

    public static String readFile(String filename){
        String content = "";
        try{
            // read filename from resources folder
            URL fileURL = Utils.class.getResource(filename);
            content = new String(Files.readAllBytes(Paths.get(fileURL.toURI())));
        } catch (IOException e){
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

   public static String query(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
