package com.example.darttrainer.repository

import com.example.darttrainer.models.GameModel

const val FOUR_TO_ONE = "four to one"
const val FOUR_TO_THREE = "four to three"
const val TEN_TO_ONE = "ten to one"
const val MATCHES = "match"

private val doublesList = listOf(
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9",
    "10",
    "11",
    "12",
    "13",
    "14",
    "16",
    "17",
    "18",
    "19",
    "20",
    "Bullseye"
)

private val treblesList = listOf(
    "10",
    "11",
    "12",
    "13",
    "14",
    "15",
    "16",
    "17",
    "18",
    "19",
    "20"
)

val gameList = arrayOf(
    GameModel(
        "100 Darts",
        TEN_TO_ONE,
        arrayOf("Scoring", "Daily Routine"),
        (100 downTo 1 step 3).map { it.toString() }.toList(),
        "100 Darts"
    ),
    GameModel(
        "420",
        FOUR_TO_ONE,
        arrayOf("Finishing", "Daily Routine"),
        doublesList,
        "420"
    ),
    GameModel(
        "Catch 40",
        FOUR_TO_ONE,
        arrayOf("Finishing", "Daily Routine"),
        (61..100).map { it.toString() }.toList(),
        "Catch 40"
    ),
    GameModel(
        "Doubles Arround the World",
        FOUR_TO_ONE,
        arrayOf("Finishing", "Daily Routine"),
        doublesList,
        "DATW"
    ),
    GameModel(
        "Doubles Boomerang",
        FOUR_TO_THREE,
        arrayOf("Finishing", "Daily Routine"),
        listOf(
            "1",
            "18",
            "4",
            "13",
            "6",
            "10",
            "15",
            "2",
            "17",
            "3",
            "19",
            "7",
            "16",
            "8",
            "11",
            "14",
            "9",
            "12",
            "5",
            "20",
            "Bullseye",
        ),
        "DB"
    ),
//    GameModel(
//        "Doubles Down",
//        "four to one",
//        arrayOf("Finishing", "Daily Routine")
//    ),
//    GameModel(
//        "JDC",
//        "four to one",
//        arrayOf("Finishing", "Daily Routine")
//    ),
    GameModel(
        "Priestley's Trebles",
        "four to one",
        arrayOf("Scoring", "Daily Routine"),
        treblesList,
        "PT"
    ),
    GameModel(
        "-01",
        MATCHES,
        arrayOf("-01", "Daily Routine"),
        emptyList(),
        MATCHES
    )
)