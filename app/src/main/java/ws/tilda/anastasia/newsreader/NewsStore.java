package ws.tilda.anastasia.newsreader;

import java.util.ArrayList;
import java.util.List;

import ws.tilda.anastasia.newsreader.model.Article;

public class NewsStore {
    private static List<Article> newsArticles = new ArrayList<>();

    public static List<Article> getArticles() {
        return newsArticles;
    }

    public static void setArticles(List<Article> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}
