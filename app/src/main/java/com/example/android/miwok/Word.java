package com.example.android.miwok;

import android.media.MediaPlayer;

public class Word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mPronunciationResId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation, int pronunciationResId){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mPronunciationResId = pronunciationResId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int pronunciationResId) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mPronunciationResId = pronunciationResId;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getPronunciationResId(){return mPronunciationResId;}
}
