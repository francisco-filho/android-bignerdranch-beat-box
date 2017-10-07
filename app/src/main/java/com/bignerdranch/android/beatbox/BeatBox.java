package com.bignerdranch.android.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by francisco on 06/10/17.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;

    public BeatBox(Context context) {
        this.mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER);
            for (String name : soundNames) {
                Sound sound = new Sound(SOUNDS_FOLDER + "/" + name);
                load(sound);
                mSounds.add(sound);
            }

        } catch (IOException e) {
            Log.e(TAG, "Could not list sounds");
            return;
        }
    }

    public void load(Sound sound){
        try {
            AssetFileDescriptor fd = mAssets.openFd(sound.getAssetPath());
            int id = mSoundPool.load(fd, 1);
            sound.setSoundId(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play(Sound sound){
        Integer soundId = sound.getSoundId();
        if (soundId == null){
            return;
        }
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void release(){
        mSoundPool.release();
    }

    public List<Sound> getSounds(){
        return mSounds;
    }
}
