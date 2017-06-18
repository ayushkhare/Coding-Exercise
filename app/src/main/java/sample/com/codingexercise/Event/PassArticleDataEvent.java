package sample.com.codingexercise.Event;

import sample.com.codingexercise.Model.ArticleModel;

/**
 * Created by ayush on 18/6/17
 */
public class PassArticleDataEvent {

    private ArticleModel article;

    public PassArticleDataEvent(ArticleModel article) {
        this.article = article;
    }

    public ArticleModel getArticle() {
        return article;
    }
}
