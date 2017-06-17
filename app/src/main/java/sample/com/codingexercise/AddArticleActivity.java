package sample.com.codingexercise;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import sample.com.codingexercise.Constants.Constant;
import sample.com.codingexercise.Model.ArticleModel;
import sample.com.codingexercise.databinding.ActivityAddArticleBinding;

/**
 * Created by ayush on 17/6/17
 */
public class AddArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddArticleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_article);
        binding.setAddArticle(this);
        binding.setArticle(new ArticleModel());
        setUpActionBar();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }

    private void setUpActionBar() {
        setTitle(getString(R.string.add_article_title));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClickPostButton(View view, String content) {
        Intent data = new Intent();
        data.putExtra(Constant.ARTICLE_CONTENT, content);
        setResult(RESULT_OK, data);
        finish();
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
}
