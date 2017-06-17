package sample.com.codingexercise.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sample.com.codingexercise.Model.ArticleModel;

/**
 * Created by ayush on 17/6/17
 */
public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.ViewHolder> {

    private final Context context;
    private final List<ArticleModel> topicList;

    public TopicListAdapter(Context context, List<ArticleModel> topicList) {
        this.context = context;
        this.topicList = topicList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //TODO
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //TODO
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
