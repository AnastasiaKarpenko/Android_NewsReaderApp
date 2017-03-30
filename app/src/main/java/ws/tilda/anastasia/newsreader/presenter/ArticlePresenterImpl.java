package ws.tilda.anastasia.newsreader.presenter;

import java.util.List;

import ws.tilda.anastasia.newsreader.model.Article;
import ws.tilda.anastasia.newsreader.repository.ArticleRepository;
import ws.tilda.anastasia.newsreader.repository.ArticleRepositoryImpl;
import ws.tilda.anastasia.newsreader.ArticleView;

public class ArticlePresenterImpl implements ArticlePresenter {
    private ArticleRepository mArticleRepository = new ArticleRepositoryImpl();
    private ArticleView view;


    @Override
    public List<Article> getArticles() {
        List<Article> articles = mArticleRepository.getArticles();
        if (articles == null) {
            return null;
        } else {
            return articles;
        }

    }

    @Override
    public void setView(ArticleView view) {
        this.view = view;
    }




}
