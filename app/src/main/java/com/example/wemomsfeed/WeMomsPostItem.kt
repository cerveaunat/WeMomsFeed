/*
    Author: Nathan Cerveau
    Filename: Adapter.kt
    Description: Description of a Wemoms Post
 */

package com.example.wemomsfeed


data class WeMomsPostItem(
    val id: Long,
    val mom: String,
    val children: String,
    val weeksOfPregnancy: String,
    val description: String,
    val likes: String,
    val comments: String,
    val profilePictureIndex: Long
)
