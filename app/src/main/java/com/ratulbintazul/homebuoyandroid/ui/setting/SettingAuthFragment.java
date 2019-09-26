package com.ratulbintazul.homebuoyandroid.ui.setting;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ratulbintazul.homebuoyandroid.R;
import com.ratulbintazul.homebuoyandroid.SettingOptionActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingAuthFragment extends Fragment {

    private SettingAuthViewModel mViewModel;

    public static SettingAuthFragment newInstance() {
        return new SettingAuthFragment();
    }

    @BindView(R.id.setting_auth_button)
    Button button;

    @BindView(R.id.setting_auth_edittext)
    EditText settingAuthEdittext;

    Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_auth_fragment, container, false);
        ButterKnife.bind(this,view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (settingAuthEdittext.getText().toString().equals("admin")) {
                    context.startActivity(new Intent(context, SettingOptionActivity.class));
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SettingAuthViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
