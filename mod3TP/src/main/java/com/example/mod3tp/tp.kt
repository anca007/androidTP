package com.example.mod3tp

import java.math.BigInteger

fun sissa() {

    var nbGrainDeRiz: BigInteger = 1.toBigInteger()
    var nbIteration = 64

    //until équivalent de .., 1..64, 1 until 64
    for (i in 1 until nbIteration) {
        nbGrainDeRiz *= 2.toBigInteger()
        //nbGrainDeRiz = nbGrainDeRiz.multiply(2.toBigInteger())
    }

    println("Nombre de grains totaux : $nbGrainDeRiz")
}

fun calculMoyenne() {

    println("Entrez le nombre de notes")
    val nbValues = readLine()?.toFloatOrNull() ?: 0

    var totalValues: Float = 0F

    for (i in 0 until nbValues.toInt()) {
        println("Valeur ?")
        var value = readLine()?.toFloat()
        totalValues += value!!
    }

    println("La moyenne est " + totalValues / nbValues.toInt())

}

fun calculMoyenne2() {

    var note: Float = 0.0F
    var somme = 0.0
    var nbNotes = 0

    do {
        println("Entrez la note (-1 pour terminer)")
        note = readLine()?.toFloatOrNull()!!
        if (note.toInt() != -1) {
            somme += note
            nbNotes++
        }


    } while (note.toInt() != -1)

    println("La moyenne est " + somme / nbNotes)

}

fun main() {
    //sissa()
    // calculMoyenne()
    calculMoyenne2()
}