package org.wuhenzhizao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.wuhenzhizao.titlebar.utils.AppUtils;
import com.wuhenzhizao.titlebar.utils.KeyboardConflictCompat;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

/**
 * Created by liufei on 2017/8/29.
 */

public class QuickPreviewActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_preview);
        ((CommonTitleBar) findViewById(R.id.titlebar)).setListener(new CommonTitleBar.OnTitleBarListener() {
            @Override
            public void onClicked(View v, int action, String extra) {
                if (action == CommonTitleBar.ACTION_LEFT_TEXT) {
                    onBackPressed();
                }
            }
        });
        ((CommonTitleBar) findViewById(R.id.titlebar_3)).showCenterProgress();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AppUtils.StatusBarLightMode(getWindow());
        AppUtils.transparencyBar(getWindow());
        KeyboardConflictCompat.assistWindow(getWindow());
    }
}
