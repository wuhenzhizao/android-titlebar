package org.wuhenzhizao;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.wuhenzhizao.utils.AppUtils;
import com.wuhenzhizao.utils.KeyBoardConflictCompat;
import com.wuhenzhizao.utils.ScreenUtils;
import com.wuhenzhizao.widget.CommonTitleBar;

public class MainActivity extends AppCompatActivity {
    private double maxAlphaEffectHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(true)
                .setSwipeSensitivity(0.5f)
                .setSwipeRelateEnable(true)
                .setSwipeSensitivity(1);

        final int position = getIntent().getIntExtra("position", 0);
        switch (position) {
            case 0:
                setContentView(R.layout.content_left_text_);
                break;
            case 1:
                setContentView(R.layout.content_left_button);
                break;
            case 2:
                setContentView(R.layout.content_left_custom_layout);
                break;
            case 3:
                setContentView(R.layout.content_right_text);
                break;
            case 4:
                setContentView(R.layout.content_right_button);
                break;
            case 5:
                setContentView(R.layout.content_right_custom_layout);
                break;
            case 6:
                setContentView(R.layout.content_center_text_marquee);
                break;
            case 7:
                setContentView(R.layout.content_center_subtext);
                break;
            case 8:
                setContentView(R.layout.content_center_custom_layout);
                break;
            case 9:
                setContentView(R.layout.content_center_search_view);
                break;
        }


        final CommonTitleBar titleBar = (CommonTitleBar) findViewById(R.id.titlebar);

        if (position == 1) {
            titleBar.showCenterProgress();
        }

        maxAlphaEffectHeight = ScreenUtils.getScreenPixelSize(this)[1] / 3;

        GScrollView sv = (GScrollView) findViewById(R.id.sv);
        sv.setOnScrollChangeListener(new GScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldX, int oldY) {
                if (y <= maxAlphaEffectHeight) {
                    int alpha = 255 - (int) (y / maxAlphaEffectHeight * 255);
                    if (alpha > 255 || alpha < 175) return;
                    String alphaHex = Integer.toString(alpha, 16).toUpperCase();
                    if (alphaHex.length() == 1) {
                        alphaHex = "0" + alphaHex;
                    }
                    String color = "#" + alphaHex + "f9f9f9";
                    titleBar.setBackgroundColor(Color.parseColor(color));
                }
            }
        });
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

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        KeyBoardConflictCompat.assistActivity(this);
        AppUtils.StatusBarLightMode(getWindow());
        AppUtils.transparencyBar(getWindow());
    }
}
