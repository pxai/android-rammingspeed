package io.pello.android.rammingspeed;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private MediaPlayer mPlayer;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(R.raw.ramming);
            }
        });

        Button buttonFaith = (Button) view.findViewById(R.id.button_faith);
        buttonFaith.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                playSound(R.raw.lack_of_faith);
            }
        });

        return view;
    }

    /**
     * plays a sound
     * @param id
     */
    private void playSound (Integer id) {
        if (null != mPlayer && mPlayer.isPlaying()) {
            mPlayer.stop();
        } else {
            mPlayer = MediaPlayer.create(getActivity(), id);
            mPlayer.start();
        }
    }
}
