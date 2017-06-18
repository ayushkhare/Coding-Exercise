package sample.com.codingexercise;

import android.view.View;

import sample.com.codingexercise.Model.ArticleModel;

/**
 * Created by ayush on 18/6/17
 */
public interface ArticleClickHandler {
    void onItemClick(View view, ArticleModel article);
}
