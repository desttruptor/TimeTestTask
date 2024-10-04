package com.pnvpnvpnv.timetesttask.util

import androidx.lifecycle.SavedStateHandle

fun <T> SavedStateHandle.getValue(key: String, onSuccess: (T) -> Unit) {
    if (contains(key)) {
        get<T>(key)?.let(onSuccess)
        remove<T>(key)
    }
}