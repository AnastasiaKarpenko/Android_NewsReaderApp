package ws.tilda.anastasia.newsreader;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ws.tilda.anastasia.newsreader.model.GetArtilcesResponse;
import ws.tilda.anastasia.newsreader.networking.NewsAPI;

public class MainActivity extends AppCompatActivity {
    private RecyclerView newsRecyclerView;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_main);

        Call<GetArtilcesResponse> call = NewsAPI.getApi().getArticles("reuters", "top");
        call.enqueue(new Callback<GetArtilcesResponse>() {
            @Override
            public void onResponse(Call<GetArtilcesResponse> call, Response<GetArtilcesResponse> response) {
                showNewsApiSnack();
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

    private void showNewsApiSnack() {
        Snackbar.make(coordinatorLayout, R.string.powered_by_NewsApi, Snackbar.LENGTH_LONG)
                .setAction(R.string.visit, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loadNewsApiWebsite();
                    }
                }).show();
    }

    private void loadNewsApiWebsite() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.newsApi_uri))));
    }
}

