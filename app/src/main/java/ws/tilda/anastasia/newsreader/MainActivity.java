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

        newsRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        Call<GetArtilcesResponse> call = NewsAPI.getApi().getArticles("reuters", "top");
        call.enqueue(new Callback<GetArtilcesResponse>() {
            @Override
            public void onResponse(Call<GetArtilcesResponse> call, Response<GetArtilcesResponse> response) {
                GetArtilcesResponse getArtilcesResponse = response.body();
                NewsStore.setArticles(getArtilcesResponse.getArticles());
                Toast.makeText(MainActivity.this, "Response received", Toast.LENGTH_SHORT).show();
                HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(getArtilcesResponse.getArticles());
                newsRecyclerView.setAdapter(homeNewsAdapter);

            }

            @Override
            public void onFailure(Call<GetArtilcesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error received", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
