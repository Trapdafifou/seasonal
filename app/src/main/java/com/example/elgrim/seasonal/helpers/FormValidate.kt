package com.example.elgrim.seasonal.helpers

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import java.util.regex.Pattern

class FormValidate {

    fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    fun errorHandler(context: Context, title: String, message: String?) {
        val alertDialog = AlertDialog.Builder(context)
                .setTitle(title)
                .setTitle(message)
                .setPositiveButton(android.R.string.ok, { dialogInterface: DialogInterface, i: Int ->

                }).create()

        alertDialog.show()
    }
}