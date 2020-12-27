package com.example.nide_shop;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import com.example.nide_shop.fragment.ClassifyFragment;
import com.example.nide_shop.fragment.HomeFragment;
import com.example.nide_shop.fragment.ShopFragment;
import com.example.nide_shop.fragment.TopicFragment;
import com.example.nide_shop.fragment.UserFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgMain;
    private ViewPager vp;
    private RadioButton rbHome;
    private RadioButton rbTopic;
    private RadioButton rbClassify;
    private RadioButton rbShop;
    private RadioButton rbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rgMain = (RadioGroup) findViewById(R.id.rg_main);
        vp = findViewById(R.id.vp);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TopicFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new ShopFragment());
        fragments.add(new UserFragment());


        vp.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case R.id.rb_home:
                        rbHome.setChecked(true);
                        break;
                    case R.id.rb_topic:
                        rbTopic.setChecked(true);
                        break;
                    case R.id.rb_classify:
                        rbClassify.setChecked(true);
                        break;
                    case R.id.rb_shop:
                        rbShop.setChecked(true);
                        break;
                    case R.id.rb_user:
                        rbUser.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb_topic:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb_classify:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rb_shop:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.rb_user:
                        vp.setCurrentItem(4);
                        break;
                }
            }
        });


        rbHome = (RadioButton) findViewById(R.id.rb_home);
        rbTopic = (RadioButton) findViewById(R.id.rb_topic);
        rbClassify = (RadioButton) findViewById(R.id.rb_classify);
        rbShop = (RadioButton) findViewById(R.id.rb_shop);
        rbUser = (RadioButton) findViewById(R.id.rb_user);
    }
}