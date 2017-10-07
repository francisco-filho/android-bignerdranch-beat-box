package com.bignerdranch.android.beatbox;

/**
 * Created by francisco on 07/10/17.
 */

public class Sound {
    private String mAssetPath;
    private String mName;
    private Integer mSoundId;

    public Sound(String assetPath){
        this.mAssetPath = assetPath;
        String[] fileNameParts = assetPath.split("/");
        mName = fileNameParts[fileNameParts.length - 1].replace(".wav", "");
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }
}
