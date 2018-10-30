package com.innowave.assessment.views.aleart;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public abstract class AleartDialogs {

    public static void userNotFound(Context context, String userName) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Not Found!");
        alertDialog.setMessage(splitUserName(userName)+ " not found!");
        alertDialog.setPositiveButton("OK", (arg0, arg1) -> arg0.dismiss());
        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }

    private static String splitUserName(String userName){
        return userName.split("/")[2];
    }
}
