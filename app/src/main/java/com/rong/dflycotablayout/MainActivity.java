package com.rong.dflycotablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.rong.flycotablayout.CommonTabLayout;
import com.rong.flycotablayout.listener.CustomTabEntity;
import com.rong.flycotablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CommonTabLayout tab;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private String[] mTitles = {"首页", "工具箱", "我"};
    private int[] mIconUnselectIds = {R.mipmap.ic_home_nor, R.mipmap.ic_tool_nor, R.mipmap.ic_mine_nor};
    private int[] mIconSelectIds = {R.drawable.anima_home, R.drawable.anima_util, R.drawable.anima_mine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tab = (CommonTabLayout) findViewById(R.id.tab);
        init();
    }
    private void init() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mFragments.clear();
        for (String title : mTitles) {
            switch (title) {
                case "首页":
                    mFragments.add(new HomePageFragment());
                    break;
                case "工具箱":
                    mFragments.add(new ToolFragment());
                    break;
                case "我的":
                    mFragments.add(new MineFragment());
                    break;
            }
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(2);

        tab.setTabData(mTabEntities);
        tab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                AnimationDrawable animationDrawableTwo = (AnimationDrawable)getResources().getDrawable(mTabEntities.get(position).getTabSelectedIcon());
//                animationDrawableTwo.start();
                tab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
