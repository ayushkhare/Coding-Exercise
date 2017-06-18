package sample.com.codingexercise.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import sample.com.codingexercise.ArticleClickHandler;
import sample.com.codingexercise.ArticleDetailsActivity;
import sample.com.codingexercise.Constants.Constant;
import sample.com.codingexercise.Event.PassArticleDataEvent;
import sample.com.codingexercise.Model.ArticleModel;
import sample.com.codingexercise.databinding.ItemTopicLayoutBinding;

/**
 * Created by ayush on 17/6/17
 */
public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.ViewHolder> {

    private Context context;
    private List<ArticleModel> topicList;

    public TopicListAdapter(Context context, List<ArticleModel> topicList) {
        this.context = context;
        this.topicList = topicList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemTopicLayoutBinding binding = ItemTopicLayoutBinding.inflate(inflater);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ArticleModel article = topicList.get(position);
        holder.bind(article);
        holder.binding.setActionListener(new ArticleClickHandler() {
            @Override
            public void onItemClick(View view, ArticleModel article) {
                Intent intent = new Intent(context, ArticleDetailsActivity.class);
                EventBus.getDefault().postSticky(new PassArticleDataEvent(article));
                ((Activity) context).startActivityForResult(intent, Constant.UPDATE_ARTICLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public void setData(List<ArticleModel> topicList) {
        this.topicList = topicList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemTopicLayoutBinding binding;

        ViewHolder(ItemTopicLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ArticleModel article) {
            binding.setArticle(article);
            binding.executePendingBindings();
        }
    }
}
