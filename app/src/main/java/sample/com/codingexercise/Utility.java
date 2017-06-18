package sample.com.codingexercise;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by ayush on 18/6/17
 */
public class Utility {

    public static float getPixel(Context context, float dp) {

        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return dp * displayMetrics.density;
        }
        return 0;
    }

}
