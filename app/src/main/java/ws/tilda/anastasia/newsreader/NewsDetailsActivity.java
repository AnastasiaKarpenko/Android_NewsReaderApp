package ws.tilda.anastasia.newsreader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.R.attr.start;

public class NewsDetailsActivity extends AppCompatActivity {
    public static final String KEY_INDEX = "news_index";
    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        webView = (WebView) findViewById(R.id.activity_news_details_webview);
        progressBar = (ProgressBar) findViewById(R.id.activity_news_details_progressbar);
    }

    public void updateNewsDetails(int index) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(NewsDetailsActivity.this, "Error in loading webpage", Toast.LENGTH_SHORT).show();
            }
        });

        webView.loadUrl(NewsStore.getNewsArticles().get(index).getUrlToArticle());
        getSupportActionBar().setTitle(NewsStore.getNewsArticles().get(index).getTitle());
    }

    public static void launch(Context context, int index) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra(KEY_INDEX, index);
        context.startActivity(intent);
    }
}
