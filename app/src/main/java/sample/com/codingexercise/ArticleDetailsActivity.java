package sample.com.codingexercise;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

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
        binding.setListener(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding();
        setUpActionBar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    private void setUpActionBar() {
        setTitle(getString(R.string.article_detail_title));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_details);
        binding.setArticle(mArticle);
    }

    public void onClickUpvote(View view, int upVotes) {
        mArticle.setUpVotes(upVotes);
        binding.setArticle(mArticle);
    }

    public void onClickDownvote(View view, int downVotes) {
        mArticle.setDownVotes(downVotes);
        binding.setArticle(mArticle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
