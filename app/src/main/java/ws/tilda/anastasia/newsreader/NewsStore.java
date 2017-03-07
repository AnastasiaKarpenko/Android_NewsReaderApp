package ws.tilda.anastasia.newsreader;

import java.util.ArrayList;
import java.util.List;

import ws.tilda.anastasia.newsreader.model.NewsArticle;

public class NewsStore {
    private static List<NewsArticle> newsArticles = new ArrayList<>();

    public static List<NewsArticle> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<NewsArticle> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}
