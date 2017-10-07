package com.bignerdranch.android.beatbox;


import android.databinding.BaseObservable;

/**
 * Created by francisco on 07/10/17.
 */

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        mSound = sound;
        this.notifyChange();
    }

    public String getTitle(){
        return mSound.getName();
    }

    public void onButtonClicked() {
        mBeatBox.play(mSound);
    }
}
