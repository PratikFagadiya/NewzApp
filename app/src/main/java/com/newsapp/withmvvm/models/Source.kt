package com.newsapp.withmvvm.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Parcelize helps the data class to be easily passed to NavArgs, and it automatically handles everything
 * This is the new way of passing arguments to NavArgs
 */
@Parcelize
data class Source(
    val id: String,
    val name: String
): Parcelable