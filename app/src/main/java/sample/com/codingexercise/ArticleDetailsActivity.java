package sample.com.codingexercise;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import sample.com.codingexercise.Event.PassArticleDataEvent;
import sample.com.codingexercise.Model.ArticleModel;
import sample.com.codingexercise.databinding.ActivityArticleDetailsBinding;

/**
 * Created by ayush on 18/6/17
 */
public class ArticleDetailsActivity extends AppCompatActivity {

    private ArticleModel mArticle;
    private ActivityArticleDetailsBinding binding;

    @Subscribe(sticky = true)
    public void onEventMainThread(PassArticleDataEvent event) {
        mArticle = event.getArticle();
        binding.setArticle(mArticle);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    private void setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_details);
        binding.setArticle(mArticle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
