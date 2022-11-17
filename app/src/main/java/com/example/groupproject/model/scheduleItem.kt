package com.example.groupproject.model

data class scheduleItem(
    val className: String,
    val isOnline: Boolean,
    val days: List<validDays>,
    val time_block: String,
    val location: String
)
{
    enum class validDays {
        Empty,
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Online
    }
    enum class validTimes {
        Block1,
        Block2,
        Block3,
        Block4,
        Block5,
        Block6,
        Block7,
        Block8,
        Block9

    }
}
