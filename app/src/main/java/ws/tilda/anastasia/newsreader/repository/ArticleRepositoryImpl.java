package ws.tilda.anastasia.newsreader.repository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ws.tilda.anastasia.newsreader.model.Article;
import ws.tilda.anastasia.newsreader.model.GetArtilcesResponse;
import ws.tilda.anastasia.newsreader.presenter.ArticlePresenterImpl;

public class ArticleRepositoryImpl implements ArticleRepository {
    private List<Article> articles = new ArrayList<>();
    ArticlePresenterImpl presenter = new ArticlePresenterImpl();

    @Override
    public List<Article> getArticles() {
        Call<GetArtilcesResponse> call = NewsAPI.getApi().getArticles("reuters", "top");
        call.enqueue(new Callback<GetArtilcesResponse>() {
            @Override
            public void onResponse(Call<GetArtilcesResponse> call, Response<GetArtilcesResponse> response) {
                GetArtilcesResponse getArtilcesResponse = response.body();
                for (Article article : articles) {
                    articles.add(article);
                }
            }

            @Override
            public void onFailure(Call<GetArtilcesResponse> call, Throwable t) {

            }
        });

        return articles;
    }
}
