package ws.tilda.anastasia.newsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ws.tilda.anastasia.newsreader.model.GetArtilcesResponse;
import ws.tilda.anastasia.newsreader.model.NewsArticle;
import ws.tilda.anastasia.newsreader.networking.NewsAPI;

public class MainActivity extends AppCompatActivity {
    private RecyclerView newsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<NewsArticle> newsArticles = new ArrayList<>();
        newsArticles.add(new NewsArticle("After pushing back, " +
                "Amazon hands over Echo data in Arkansas murder case",
                "Amazon’s First Amendment fight was short lived. ",
                "https://tctechcrunch2011.files.wordpress.com/2015/12/25-amazon-echo.png?w=1200",
                "4 hours ago", "https://techcrunch.com/2017/03/07/amazon-echo-murder/"));

        newsArticles.add(new NewsArticle("Salesforce Einstein AI can generate models automatically",
                "When Salesforce announced its spring release this week, it revealed that " +
                        "its artificial intelligence platform, " +
                        "dubbed Einstein, can build data models automatically, " +
                        "even when customers have customized their products " +
                        "to meet the company’s unique requirements",
                "https://tctechcrunch2011.files.wordpress.com/2016/09/marc-benioff51.jpg?w=1318",
                "5 hours ago", "https://techcrunch.com/2017/03/07/salesforce-einstein-ai-can-generate" +
                "-models-automatically/"));

        NewsStore.setNewsArticles(newsArticles);

        newsRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(NewsStore.getNewsArticles());
        newsRecyclerView.setAdapter(homeNewsAdapter);

        Call<GetArtilcesResponse> call = NewsAPI.getApi().getArticles("reuters", "top");
        call.enqueue(new Callback<GetArtilcesResponse>() {
            @Override
            public void onResponse(Call<GetArtilcesResponse> call, Response<GetArtilcesResponse> response) {
                GetArtilcesResponse getArtilcesResponse = response.body();
                Toast.makeText(MainActivity.this, "Response received", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<GetArtilcesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error received", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
