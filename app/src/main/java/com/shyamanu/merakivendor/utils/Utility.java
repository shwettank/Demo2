package com.shyamanu.merakivendor.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by shwettank.ramteke on 3/30/2018.
 */

public class Utility {

    /**
     * <p>When this activity is called we have some EditTexts whose behavior is to get input from
     * device keyboard and pops up the keyboard on screens. This method will help us to hide
     * the soft input of keyboard when this activity comes forward.</p>
     * @param activity  Activity: an activity is required as parameter to perform application-specific
     *                 tasks.
     */
    public static void hideSoftKeyboard(Activity activity) {
        View v = activity.getCurrentFocus();
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }
    }
}
