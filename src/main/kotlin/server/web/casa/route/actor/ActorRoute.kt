package server.web.casa.route.actor

import server.web.casa.route.GlobalRoute

object ActorRoute {
    const val BAILLEUR = "${GlobalRoute.ROOT}/${ActorFeatures.BAILLEUR_PATH}"
    const val COMMISSIONNAIRE = "${GlobalRoute.ROOT}/${ActorFeatures.COMMISSIONNAIRE_PATH}"
    const val LOCATAIRE = "${GlobalRoute.ROOT}/${ActorFeatures.LOCATAIRE_PATH}"
}

object ActorFeatures{
    const val BAILLEUR_PATH = "bailleurs"
    const val COMMISSIONNAIRE_PATH = "commissionnaires"
    const val LOCATAIRE_PATH = "locataires"
}