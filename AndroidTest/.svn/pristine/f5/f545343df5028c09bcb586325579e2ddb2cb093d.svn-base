package com.xinglefly.util;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * It use to finish all activities</br>
 * To get start you should£º</br>
 * 1£º Invoke the method ActivityController.add(this) in onCreate method in activties<br>
 * 2£º ActivityController.remove(this) in onDestroy method  in activties.</br>
 * </br>
 * when you quit app,you should invoke finishProgram
 */
public class ActivityController {
    private static final String TAG = ActivityController.class.getSimpleName();
    
    private static List<Activity> activityList = new ArrayList<Activity>();

    
    public static void add(Activity activity) {
        activityList.add(activity);
        Log.d(TAG,"add:"+activity.getClass().getSimpleName());
    }

    public static void remove(Activity activity) {
        if (activity != null) {
            activityList.remove(activity);
            Log.d(TAG,"remove:"+activity.getClass().getSimpleName());
        }
    }

    public static void finishProgram() {
        for (Activity activity : activityList) {
            if (null != activity) {
                activity.finish();
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static void finishAllActivitys() {
        for (Activity activity : activityList) {
            if (null != activity) {
                activity.finish();
            }
        }
    }
}
