package homeWorks.url.forsite;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Class for get site content
 *
 * @author Jesus Raichuk
 */
public class SiteWorker {
    /**
     * URL
     */
    private String url;

    public SiteWorker(String url) {
        this.url = url;
    }
    /**
     * URLs in the site
     * @param body - site body
     * @return - String[] - urls
     */
    public static String[] getUrls(String body) {
        Pattern urlPattern = Pattern.compile("(https?:\\/\\/)?([\\w\\.]+)\\.([a-z]{2,6}\\.?)(\\/[\\w\\-\\.]*)*\\/?");
        Matcher matcher = urlPattern.matcher(body);

        StringBuilder builder = new StringBuilder();
        while (matcher.find())
            builder.append(matcher.group() + " ");

        return builder.toString().split("\\s");
    }
    /**
     * Get the text (words) of th site
     * @return text - String
     * @throws IOException - wrong URL
     */
    public String getText() throws IOException {
        try {
            Connection connection = Jsoup.connect(url);
            Document doc = connection.get();
            return doc.body().text();
        } catch (IllegalArgumentException e) {
            throw new IOException("URL Error!!!");
        }
    }
}
