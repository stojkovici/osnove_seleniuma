package Helper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Helper {
    public int getHTTPResponseStatusCode(String urlString) throws IOException, IOException {
        URL url = new URL(urlString);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }

}
