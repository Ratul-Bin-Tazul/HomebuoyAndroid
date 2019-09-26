package com.ratulbintazul.homebuoyandroid.ui.usermanual;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.ratulbintazul.homebuoyandroid.R;

public class userManualFragment extends Fragment {

    private UserManualViewModel mViewModel;

    public static userManualFragment newInstance() {
        return new userManualFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_manual_fragment, container, false);

        WebView mWebView = (WebView) view.findViewById(R.id.user_manual_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("http://beta.html5test.com/");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UserManualViewModel.class);
        // TODO: Use the ViewModel
    }

}
