/*
    Author: Nathan Cerveau
    Filename: WeMomsPos.kt
    Description: Generates a Wemoms post : every parameter is generated randomly.
 */

package com.example.wemomsfeed

import kotlin.random.Random

class WeMomsPostGenerator {

    private val WINDOW_SIZE = 6

    private var currentId = 1L

    private val momList = listOf("Julie","Sandrine","Emma","Laura","Elodie","Nora","Zoé","Ophelia","Pauline","Anna")


    private val descriptionList = listOf("J'ai une question...",
        "Mon bébé ne dort pas",
        "Je peux faire du sport en étant enceinte ?",
        "Est-ce que je peux me faire vacciner en étant enceinte ?",
        "Votre bébé faisait quel poids à la naissance ?",
        "Celles qui ont accouché à Lyon, quelle clinique me conseillez-vous ?",
        "Je n'arrive pas à avoir un deuxième enfant",
        "Comment résister à l'envie de fumer ?",
        "Quels médicaments sont déconseillés en étant enceinte ?",
        "Commment vous contrôlez votre poids ?"
    )

    private val profilePictureList = listOf(R.drawable.picture1, R.drawable.picture2, R.drawable.picture3)

    fun newModels(): List<WeMomsPostItem> {
        val endId = currentId + WINDOW_SIZE
        val result = (currentId until endId).map {
            WeMomsPostItem(
                id = it,
                mom = momList.random(),
                children = "Children : ${Random.nextLong(4)}",
                weeksOfPregnancy = "WoP : ${Random.nextLong(40)}",
                description = descriptionList.random(),
                likes = "\u2665 ${Random.nextInt(20)}",
                comments = "\u2709 ${Random.nextInt(10)}",
                profilePictureIndex = 1L + Random.nextLong(3)
            )
        }
        currentId = endId
        return result
    }

}
