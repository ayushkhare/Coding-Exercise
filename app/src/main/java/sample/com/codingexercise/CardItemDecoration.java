package sample.com.codingexercise;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ayush on 18/6/17
 */
public class CardItemDecoration extends RecyclerView.ItemDecoration{
    private final int space;

    public CardItemDecoration(int space) {
        this.space= space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.top = space;
    }
}

