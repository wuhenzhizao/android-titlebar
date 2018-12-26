package org.wuhenzhizao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

public class LaunchActivity extends SwipeBackActivity {

    private int light = 1;

    @Override
    protected boolean isSwipeBackEnable() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauch);

        final CommonTitleBar titleBar = (CommonTitleBar) findViewById(R.id.titlebar);
        titleBar.setBackgroundResource(R.drawable.shape_gradient);
        titleBar.setListener(new CommonTitleBar.OnTitleBarListener() {
            @Override
            public void onClicked(View v, int action, String extra) {
                if (action == CommonTitleBar.ACTION_RIGHT_TEXT) {
                    titleBar.toggleStatusBarMode();
                }
            }
        });

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
                    startActivity(new Intent(LaunchActivity.this, QuickPreviewActivity.class));
                } else {
                    Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                    intent.putExtra("position", position - 1);
                    startActivity(intent);
                }
            }
        });
    }
}
