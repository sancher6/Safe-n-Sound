package com.example.peruv.osmosis;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by peruv on 11/30/2017.
 */

//-----------------------------------------------------------------------------------------
//
//  Function: Message class
//
//    Parameters:
//    Context context, String message
//
//    Pre-condition: toaster messaged is needed
//    Post-condition: toaster message is displayed
//-----------------------------------------------------------------------------------------
public class Message {
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
