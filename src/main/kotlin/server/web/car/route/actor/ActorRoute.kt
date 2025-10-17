package server.web.car.route.actor

import server.web.car.route.GlobalRoute

object ActorRoute {
    const val VENDEUR = "${GlobalRoute.ROOT}/${ActorFeatures.VENDEUR_PATH}"
    const val COMMISSIONNAIRE = "${GlobalRoute.ROOT}/${ActorFeatures.COMMISSIONNAIRE_PATH}"
    const val ACHETEUR = "${GlobalRoute.ROOT}/${ActorFeatures.ACHETEUR_PATH}"
}

object ActorFeatures{
    const val VENDEUR_PATH = "vendeurs"
    const val COMMISSIONNAIRE_PATH = "commissionnaires"
    const val ACHETEUR_PATH = "acheteurs"
}