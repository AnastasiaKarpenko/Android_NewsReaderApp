package ws.tilda.anastasia.newsreader;

import android.support.v7.widget.RecyclerView;

public interface ArticleView {
    void showErrorReceivedMessage();
    void showResponseReceivedMessage();
    void setAdapter();

}
