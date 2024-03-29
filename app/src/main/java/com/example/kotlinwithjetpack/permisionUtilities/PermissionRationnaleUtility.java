package com.example.kotlinwithjetpack.permisionUtilities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;

import com.example.kotlinwithjetpack.R;
import com.karumi.dexter.PermissionToken;

import androidx.appcompat.app.AlertDialog;

public class PermissionRationnaleUtility {

    private Activity activity;

    public PermissionRationnaleUtility(Activity activity){
        this.activity = activity;
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void showPermissionRationale(final PermissionToken token) {
        new AlertDialog.Builder(activity).setTitle(R.string.permission_rationale_title)
                .setMessage(R.string.permission_rationale_message)
                .setNegativeButton(android.R.string.cancel, (dialog, which) -> {
                    dialog.dismiss();
                    token.cancelPermissionRequest();
                })
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    dialog.dismiss();
                    token.continuePermissionRequest();
                })
                .setOnDismissListener(dialog -> token.cancelPermissionRequest())
                .show();
    }

}
