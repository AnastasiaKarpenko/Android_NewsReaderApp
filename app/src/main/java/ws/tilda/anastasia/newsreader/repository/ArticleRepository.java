package ws.tilda.anastasia.newsreader.repository;

import java.util.List;

import ws.tilda.anastasia.newsreader.model.Article;

public interface ArticleRepository {
    List<Article> getArticles();
}
