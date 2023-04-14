package com.vishtech.create30daysapp.data

import com.vishtech.create30daysapp.R
import com.vishtech.create30daysapp.model.DayItem

object DataSource {
    fun getDayItems(): List<DayItem> {
        val dayList  = arrayListOf<DayItem>()
        dayList.add(
            DayItem(
                R.string.title_day1,
                R.drawable.image1,
                R.string.description_day1
            )
        )
        dayList.add(
            DayItem(
                R.string.title_day2,
                R.drawable.image2,
                R.string.description_day2
            )
        )
        dayList.add(
            DayItem(
                R.string.title_day3,
                R.drawable.image3,
                R.string.description_day3
            )
        )
        dayList.add(
            DayItem(
                R.string.title_day4,
                R.drawable.image4,
                R.string.description_day4
            )
        )
        dayList.add(
            DayItem(
                R.string.title_day5,
                R.drawable.image5,
                R.string.description_day5
            )
        )
        dayList.add(
            DayItem(
                R.string.title_day6,
                R.drawable.image6,
                R.string.description_day6
            )
        )
        dayList.add(
            DayItem(
                R.string.title_day7,
                R.drawable.image7,
                R.string.description_day7
            )
        )
        return dayList
    }
}