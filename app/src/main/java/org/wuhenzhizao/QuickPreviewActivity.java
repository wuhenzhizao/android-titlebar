package org.wuhenzhizao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wuhenzhizao.utils.AppUtils;
import com.wuhenzhizao.utils.KeyBoardConflictCompat;
import com.wuhenzhizao.widget.CommonTitleBar;

/**
 * Created by liufei on 2017/8/29.
 */

public class QuickPreviewActivity extends AppCompatActivity {

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
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AppUtils.StatusBarLightMode(getWindow());
        AppUtils.transparencyBar(getWindow());
        KeyBoardConflictCompat.assistActivity(this);
    }
}
