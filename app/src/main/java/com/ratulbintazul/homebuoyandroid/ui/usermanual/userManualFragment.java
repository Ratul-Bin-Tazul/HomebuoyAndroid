package com.ratulbintazul.homebuoyandroid.ui.usermanual;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ratulbintazul.homebuoyandroid.R;

public class userManualFragment extends Fragment {

    private UserManualViewModel mViewModel;

    public static userManualFragment newInstance() {
        return new userManualFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_manual_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UserManualViewModel.class);
        // TODO: Use the ViewModel
    }

}
