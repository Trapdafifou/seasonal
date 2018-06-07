package com.example.elgrim.seasonal.utils

import java.text.SimpleDateFormat

fun format(dateString: String?): String? {
    val outputFormat = SimpleDateFormat("dd/MM/yyyy")
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

    val date = inputFormat.parse(dateString)
    return outputFormat.format(date)

}

fun month (dateString: String?): String? {
    val outputFormat = SimpleDateFormat("dd/MM")
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

    val date = inputFormat.parse(dateString)
    return outputFormat.format(date)
}