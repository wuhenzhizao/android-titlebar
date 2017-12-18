package org.wuhenzhizao;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jude.swipbackhelper.SwipeBackHelper;

/**
 * Created by liufei on 2017/12/18.
 */

public abstract class SwipeBackActivity extends AppCompatActivity {

    protected boolean isSwipeBackEnable() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SwipeBackHelper.onCreate(this);
        if (isSwipeBackEnable() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SwipeBackHelper.getCurrentPage(this)
                    .setSwipeBackEnable(true)
                    .setSwipeSensitivity(0.5f)
                    .setSwipeRelateEnable(true)
                    .setSwipeSensitivity(1);
        } else {
            SwipeBackHelper.getCurrentPage(this)
                    .setSwipeBackEnable(false);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }

}
