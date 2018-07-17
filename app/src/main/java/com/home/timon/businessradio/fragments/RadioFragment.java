package com.home.timon.businessradio.fragments;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.home.timon.businessradio.MainActivity;
import com.home.timon.businessradio.R;

import java.io.IOException;

import static android.support.constraint.Constraints.TAG;
import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * Created by timon9551 on 7/9/2018.
 */

public class RadioFragment extends Fragment {

    //region Vars

    private static final String TAG = RadioFragment.class.getName();

    private boolean paused;
    private Button bt_play_pause;
    private View viewFragment;

    //endregion

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        paused = true;
        viewFragment = inflater.inflate(R.layout.fragment_radio, container, false);
        bt_play_pause = viewFragment.findViewById(R.id.radio_button_play_pause);
        bt_play_pause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24px);
        bt_play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.radio_button_play_pause:
                        if (paused) {
                            bt_play_pause.setBackgroundResource(R.drawable.ic_baseline_pause_24px);
                            ((MainActivity)getActivity()).startPlayer();
                            paused = false;
                        } else {
                            bt_play_pause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24px);
                            paused = true;
                            ((MainActivity)getActivity()).pausePlayer();
                        }
                }
            }
        });
        return viewFragment;
    }
}