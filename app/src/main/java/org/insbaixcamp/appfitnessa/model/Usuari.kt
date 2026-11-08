package org.insbaixcamp.appfitnessa.model

// Classe amb totes les dades del perfil de l'usuari
data class Usuari(
    val nom: String,
    val email: String,
    val edat: Int,
    val genere: String,
    val alcada: Int,       // en cm
    val pes: Double,       // en kg
    val pesObjectiu: Double,
    val objectiu: String,
    val nivellActivitat: String
)

// Dades inicials (de moment no fem servir Firebase, nomes memoria)
val usuariInicial = Usuari(
    nom = "Laia Soler",
    email = "laia.soler@exemple.com",
    edat = 27,
    genere = "Femení",
    alcada = 168,
    pes = 62.0,
    pesObjectiu = 58.0,
    objectiu = "Perdre pes",
    nivellActivitat = "Moderat"
)

// Opcions dels menus desplegables
val opcionsGenere = listOf("Masculí", "Femení", "Prefereixo no dir-ho")
val opcionsObjectiu = listOf("Perdre pes", "Guanyar massa muscular", "Mantenir el pes")
val opcionsNivell = listOf("Sedentari", "Lleuger", "Moderat", "Actiu", "Molt actiu")
