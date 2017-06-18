package sample.com.codingexercise;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import sample.com.codingexercise.Adapter.TopicListAdapter;
import sample.com.codingexercise.Constants.Constant;
import sample.com.codingexercise.Model.ArticleModel;
import sample.com.codingexercise.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private List<ArticleModel> mTopicList;
    private TopicListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setListener(this);
        initVariables();
        initRecyclerView();
    }

    private void initVariables() {
        if (mTopicList == null) {
            mTopicList = new ArrayList<>();
        }
    }

    private void initRecyclerView() {
        mAdapter = new TopicListAdapter(this, mTopicList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.article_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        CardItemDecoration itemDecoration = new CardItemDecoration((int) Utility.getPixel(this, 8f));
        recyclerView.addItemDecoration(itemDecoration);
    }

    public void onClickAddButton(View view) {
        Intent intent = new Intent(MainActivity.this, AddArticleActivity.class);
        startActivityForResult(intent, Constant.POST_ARTICLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constant.POST_ARTICLE) {
            if (resultCode == RESULT_OK) {
                String content = data.getStringExtra(Constant.ARTICLE_CONTENT);
                ArticleModel articleModel = new ArticleModel();
                articleModel.setContent(content);
                articleModel.setUpVotes(0);
                articleModel.setDownVotes(0);
                mTopicList.add(articleModel);
                mAdapter.setData(mTopicList);
            }
        }
    }
}
