package ws.tilda.anastasia.newsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ws.tilda.anastasia.newsreader.model.NewsArticle;

public class MainActivity extends AppCompatActivity {

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
    }
}
