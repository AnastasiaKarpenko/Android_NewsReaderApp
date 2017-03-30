package ws.tilda.anastasia.newsreader.presenter;

import java.util.List;

import ws.tilda.anastasia.newsreader.ArticleView;
import ws.tilda.anastasia.newsreader.model.Article;

public interface ArticlePresenter {
        List<Article> getArticles();
        void setView(ArticleView view);


}
