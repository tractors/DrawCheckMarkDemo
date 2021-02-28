package com.will.drawcheckmarkdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    MagicButton mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewpager);
        mButton = findViewById(R.id.button);

        initListener();
    }

    private void initListener() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (mViewPager.getCurrentItem() == mCount - 1) {
//                    // 导航完成
//                    Toast.makeText(MainActivity.this, "导航完毕", Toast.LENGTH_LONG).show();
//                } else if (mViewPager.getCurrentItem() == mCount - 2) {
//                    //SCROLL_STATE = SCROLL_RIGHT;
//                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
//                } else {
//                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
//                }
            }
        });

//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                switch (SCROLL_STATE) {
//                    case SCROLL_RIGHT:
//                        //向右滑动说明是从倒数第一页滑动倒数第二页，调用mButton.setProgress(true, positionOffset)，true为由对勾绘制箭头，将偏移量传回来绘制
//                        if (position == mCount - 2) {
//                            mButton.setProgress(true, positionOffset);
//                        }
//                        break;
//                    case SCROLL_LEFT:
//                        //向左滑动说明是从倒数第二页滑动倒数第一页，调用mButton.setProgress(false, positionOffset)，false为由箭头绘制对勾，将偏移量传回来绘制
//                        if (position == mCount - 2) {
//                            mButton.setProgress(false, positionOffset);
//                        }
//                        break;
//                    case SCROLL_NONE:
//
//                        break;
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }
}