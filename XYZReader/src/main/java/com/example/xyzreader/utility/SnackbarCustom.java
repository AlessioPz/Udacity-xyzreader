package com.example.xyzreader.utility;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.example.xyzreader.R;

/**
 * Created by alessio on 24/06/16.
 */
public class SnackbarCustom {

    private static Snackbar snackbar;

    public static SnackbarCustom make(@NonNull View view, @StringRes int resId) {
        SnackbarCustom snackbarCustom = new SnackbarCustom();
        snackbar = Snackbar.make(view, resId, Snackbar.LENGTH_INDEFINITE);
        setLayout();
        return snackbarCustom;
    }

    public static SnackbarCustom make(@NonNull View view, @NonNull CharSequence text,
                                      @Snackbar.Duration int duration) {
        SnackbarCustom snackbarCustom = new SnackbarCustom();
        snackbar = Snackbar.make(view, text, duration);
        setLayout();
        return snackbarCustom;
    }

    private static void setLayout() {
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(snackBarView.getResources().getColor(R.color.primary_dark));
        TextView tv = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
    }

    public static void show() {
        snackbar.show();
    }


    public SnackbarCustom addOkAction() {
        snackbar.setActionTextColor(Color.GREEN);
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        return this;
    }
}
