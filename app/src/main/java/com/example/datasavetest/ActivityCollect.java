package com.example.datasavetest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifb on 2015/5/3.
 */
public class ActivityCollect {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
}
