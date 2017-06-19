package com.dltao.bxd.app.wedgit;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.dltao.bxd.R;

/**
 * Created by ui on 2016/8/15.
 */
public class TitleBar extends Toolbar {

    private TextView mTitleTextView;

    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        String title = a.getString(R.styleable.TitleBar_tb_title);
        boolean defaultNavigation = a.getBoolean(R.styleable.TitleBar_tb_default_navigation, false);
        a.recycle();

        mTitleTextView = new TextView(context);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        mTitleTextView.setSingleLine(true);
        mTitleTextView.setTextColor(Color.WHITE);
        mTitleTextView.setGravity(Gravity.CENTER);
        mTitleTextView.setTextSize(18);
        mTitleTextView.setText(title);

        addView(mTitleTextView, params);
        setTitle("");
        if (defaultNavigation) {
            setNavigationIcon(R.drawable.ic_arrow_l);
            setNavigationOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                }
            });
        }
    }

    public void setTitleCenter(String title) {
        mTitleTextView.setText(title);
    }
}
