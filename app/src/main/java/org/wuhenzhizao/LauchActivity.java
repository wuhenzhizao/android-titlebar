package org.wuhenzhizao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.wuhenzhizao.titlebar.utils.AppUtils;

public class LauchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauch);

        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this).setSwipeBackEnable(false);

        final ListView lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, new String[]{
                "快速预览",
                "1、左边TextView + 中间文字",
                "2、左边ImageButton + 中间文字(带进度条)",
                "3、左边自定义Layout + 中间文字",
                "4、中间文字 + 右边TextView",
                "5、中间文字 + 右边ImageButton",
                "6、中间文字 + 右边自定义Layout",
                "7、中间跑马灯效果 + 右边TextView",
                "8、中间添加副标题",
                "9、中间自定义Layout + 右边自定义Layout",
                "10、中间搜索框",
                "11、中间搜索框 + 两侧自定义Layout"
        }));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(new Intent(LauchActivity.this, QuickPreviewActivity.class));
                } else {
                    Intent intent = new Intent(LauchActivity.this, MainActivity.class);
                    intent.putExtra("position", position - 1);
                    startActivity(intent);
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
        AppUtils.StatusBarLightMode(getWindow());
        AppUtils.transparencyBar(getWindow());
    }
}
