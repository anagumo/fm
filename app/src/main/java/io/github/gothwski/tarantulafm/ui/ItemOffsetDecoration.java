package io.github.gothwski.tarantulafm.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by ariana gothwski on 8/07/15.
 */
public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

    //La medida en px del espaciado
    private int mItemOffset;

    public ItemOffsetDecoration(Context context, @IntegerRes int integerResId) {
        int itemOffset = context.getResources().getInteger(integerResId);
        mItemOffset = convertToPixels(itemOffset, context.getResources().getDisplayMetrics());
    }

    public int convertToPixels(int offsetDp, DisplayMetrics metrics) {
        return offsetDp * (metrics.densityDpi / 160);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }
}
