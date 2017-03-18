package com.beta.android.aakashresearchlabs.test.customClasses;

public class indexclass {

    private String mLessonName;
    private int mLessonNum;
    private Class<?> mCls;

    public indexclass(String lessonName,int lessonNum){
        mLessonName = lessonName;
        mLessonNum = lessonNum;
    }

    public indexclass(String lessonName, Class<?> cls){
        mLessonName = lessonName;
        mCls = cls;
    }

    public Class<?> getmCls(){
        return mCls;
    }

    public String getmLessonName(){
        return mLessonName;
    }

    public  int getmLessonNum(){
        return mLessonNum;
    }


}
