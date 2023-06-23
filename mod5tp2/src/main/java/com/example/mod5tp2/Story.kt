package com.example.mod5tp2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Story(val firstname : String, val place : String) : Parcelable
