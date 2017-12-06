package com.derekudacityclassprojects.jokeappproject;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.derekudacityclassprojects.displayjoke.DisplayJokeActivity;
import com.derekudacityclassprojects.jokelib.JavaJoke;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Derek on 12/5/2017.
 */

public class MainActivityFragment extends Fragment {
    private final int REQUEST_CODE_DISPLAY_JOKE_ACITVITY = 7;
    private Button getJokeButton;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        getJokeButton = root.findViewById(R.id.get_a_joke_button);
        getJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DisplayJokeActivity.class);
                String[] joke = JavaJoke.getJoke();
                intent.putExtra(DisplayJokeActivity.EXTRA_JOKE, joke[0]);
                intent.putExtra(DisplayJokeActivity.EXTRA_JOKE_ANSWER, joke[1]);
                startActivityForResult(intent, REQUEST_CODE_DISPLAY_JOKE_ACITVITY);
            }
        });
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        // Do a check to see which version it is using reflection
        if(BuildConfig.APP_FREE_MODE){
            AdView mAdView = (AdView) root.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder()
                    //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .addTestDevice("ca-app-pub-4496136774846958~4367784416")
                    .build();
            mAdView.loadAd(adRequest);
        }
        return root;
    }
}
