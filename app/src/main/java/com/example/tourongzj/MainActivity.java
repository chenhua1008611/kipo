package com.example.tourongzj;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tourongzj.college.fragment.CollegeFragment;
import com.example.tourongzj.market.fragment.MarketFragment;
import com.example.tourongzj.message.fragment.MessageFragment;
import com.example.tourongzj.mine.fragment.MineFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MarketFragment marketFragment;//投融市场
    private CollegeFragment collegeFragment;//投融学院
    private MessageFragment messageFragment;//私信
    private MineFragment mineFragment;//我

    private RadioGroup rgs;
    private RadioButton mrbMeetMarket, mrbCollege, mrbMessage, mrbMine;

    private FragmentManager fragmentManager;
    private  int currentIndex;//当前显示的fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getSupportFragmentManager();
        currentIndex = 0;
        setTabSelection(currentIndex);//首次进入默认加载会吧
    }

    private void initView() {

        rgs = (RadioGroup) findViewById(R.id.tabs_rg);
        mrbMeetMarket = (RadioButton) findViewById(R.id.tab_radiobutton_market);
        mrbCollege = (RadioButton) findViewById(R.id.tab_radiobutton_college);
        mrbMessage = (RadioButton) findViewById(R.id.tab_radiobutton_messege);
        mrbMine = (RadioButton) findViewById(R.id.tab_radiobutton_mine);
        rgs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tab_radiobutton_market:
                        setTabSelection(0);
                        break;
                    case R.id.tab_radiobutton_college:
                        setTabSelection(1);
                        break;
                    case R.id.tab_radiobutton_messege:
                        setTabSelection(2);
                        break;
                    case R.id.tab_radiobutton_mine:
                        setTabSelection(3);
                        break;
                }
            }
        });

    }


    @Override
    public void onClick(View v) {

    }

    private void setTabSelection(int index) {
        clearSelection();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        currentIndex = index;
        switch (index) {
            case 0:
                mrbMeetMarket.setChecked(true);
                mrbMeetMarket.getPaint().setFakeBoldText(true);
                mrbMeetMarket.setTextColor(Color.parseColor("#d7000f"));
                if (marketFragment == null) {
                    marketFragment = new MarketFragment();
                    transaction.add(R.id.fragment_content, marketFragment);
                } else {
                    transaction.show(marketFragment);
                }
                break;
            case 1:
                mrbCollege.setChecked(true);
                mrbCollege.getPaint().setFakeBoldText(true);
                mrbCollege.setTextColor(Color.parseColor("#d7000f"));
                if (collegeFragment == null) {
                    collegeFragment = new CollegeFragment();
                    transaction.add(R.id.fragment_content, collegeFragment);
                } else {
                    transaction.show(collegeFragment);
                }
                break;
            case 2:
                mrbMessage.setChecked(true);
                mrbMessage.getPaint().setFakeBoldText(true);
                mrbMessage.setTextColor(Color.parseColor("#d7000f"));
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.fragment_content, messageFragment);
                } else {
                    transaction.show(messageFragment);
                }
                break;
            case 3:
                mrbMine.setChecked(true);
                mrbMine.getPaint().setFakeBoldText(true);
                mrbMine.setTextColor(Color.parseColor("#d7000f"));
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.fragment_content, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (marketFragment != null) {
            transaction.hide(marketFragment);
        }
        if (collegeFragment != null) {
            transaction.hide(collegeFragment);
        }
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    private void clearSelection() {
        mrbMeetMarket.setChecked(false);
        mrbCollege.setChecked(false);
        mrbMessage.setChecked(false);
        mrbMine.setChecked(false);
        mrbMeetMarket.getPaint().setFakeBoldText(false);
        mrbCollege.getPaint().setFakeBoldText(false);
        mrbMessage.getPaint().setFakeBoldText(false);
        mrbMine.getPaint().setFakeBoldText(false);
        mrbMeetMarket.setTextColor(Color.parseColor("#000000"));
        mrbCollege.setTextColor(Color.parseColor("#000000"));
        mrbMessage.setTextColor(Color.parseColor("#000000"));
        mrbMine.setTextColor(Color.parseColor("#000000"));
    }

    /**
     * 按回车键
     */

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), getString(R.string.tip_press_back),
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                moveTaskToBack(false);
                finish();

            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
