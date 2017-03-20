package ws.tilda.anastasia.newsreader.networking;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ws.tilda.anastasia.newsreader.model.GetArtilcesResponse;

public class NewsAPI {
    public static final String APIKEY = "d7c0c429f9ee423b9f3ae45d61daca9f";
    public static final String APIPATH = "https://newsapi.org/v1/";

    private static NewsService newsService = null;

    public static NewsService getApi() {
        if (newsService == null) {
            // initialize NewsService
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIPATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            newsService = retrofit.create(NewsService.class);
        }
        return newsService;
    }

    public interface NewsService {
        @GET("articles?apiKey=" + APIKEY)
        Call<GetArtilcesResponse> getArticles(@Query("source") String source, @Query("sortBy") String sortBy);
    }
}
