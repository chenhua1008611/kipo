package com.example.tourongzj.mine.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tourongzj.R;
import com.example.tourongzj.common.base.BaseFragment;

/**
 * Created by admin on 2017/3/9.
 */
public class MineFragment extends BaseFragment {

    private Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,container, false);
        return view;
    }
}
