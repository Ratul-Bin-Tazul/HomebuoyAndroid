package com.ratulbintazul.homebuoyandroid.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.github.islamkhsh.CardSliderViewPager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ratulbintazul.homebuoyandroid.R;
import com.ratulbintazul.homebuoyandroid.adapter.ListingAdapter;
import com.ratulbintazul.homebuoyandroid.model.Listing;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Context context;

    Object fromJson(String jsonString, Type type) {
        return new Gson().fromJson(jsonString, type);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<Listing> listing = new ArrayList<>();

        String res = "[{\"LISTING_ID\":\"14\",\"TITLE\":\"demo 6\",\"DESCRIPTION\":\"demo 6\",\"TYPE\":\"Platform B\",\"MEDIA_URL\":\"http:\\/\\/ratulbintazul.com\\/homebouy\\/html\\/media\\/c4.PNG\",\"MEDIA_TYPE\":\"image\",\"TIME\":\"2019-08-23 12:28:15\",\"PRICE_PER_UNIT\":\"56\",\"URL\":\"null\"},{\"LISTING_ID\":\"34\",\"TITLE\":\"Phone\",\"DESCRIPTION\":\"Nice Yes\",\"TYPE\":\"Platform B\",\"MEDIA_URL\":\"http:\\/\\/ratulbintazul.com\\/homebouy\\/html\\/media\\/IMG_20190426_220029.jpg\",\"MEDIA_TYPE\":\"image\",\"TIME\":\"2019-09-16 03:23:24\",\"PRICE_PER_UNIT\":\"1200\",\"URL\":\"null\"},{\"LISTING_ID\":\"35\",\"TITLE\":\"demo 6\",\"DESCRIPTION\":\"demo 6\",\"TYPE\":\"Platform B\",\"MEDIA_URL\":\"http:\\/\\/ratulbintazul.com\\/homebouy\\/html\\/media\\/c4.PNG\",\"MEDIA_TYPE\":\"image\",\"TIME\":\"2019-09-16 03:23:30\",\"PRICE_PER_UNIT\":\"56\",\"URL\":\"null\"},{\"LISTING_ID\":\"36\",\"TITLE\":\"video\",\"DESCRIPTION\":\"video\",\"TYPE\":\"Platform B\",\"MEDIA_URL\":\"http:\\/\\/homebuoy.com.au\\/html\\/media\\/Spash Screen.mp4\",\"MEDIA_TYPE\":\"video\",\"TIME\":\"2019-09-20 09:24:17\",\"PRICE_PER_UNIT\":\"12\",\"URL\":\"null\"}]";

        listing = (ArrayList<Listing>) fromJson(res,
                new TypeToken<ArrayList<Listing>>() {
                }.getType());

        // add items to arraylist

        CardSliderViewPager cardSliderViewPager = root.findViewById(R.id.viewPager);
        cardSliderViewPager.setAdapter(new ListingAdapter(listing,context));

        cardSliderViewPager.setCurrentItem((cardSliderViewPager.getCurrentItem()+1) % cardSliderViewPager.getAdapter().getCount());
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}