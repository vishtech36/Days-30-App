package com.vishtech.create30daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DayItem(
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)
