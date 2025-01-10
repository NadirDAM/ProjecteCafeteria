package com.example.projectecafeteria

class ProductesProvider {

    companion object {


        val menjars = listOf(
            Producte("Ensalada Cèsar", 8f),
            Producte("Pizza Margarita", 10f),
            Producte("Bocata de Pernil", 5f),
            Producte("Paella de Marisc", 15f),
            Producte("Fideuà", 12f),
            Producte("Croquetes Casolanes", 7f),
            Producte("Sopa de Ceba", 6f),
            Producte("Carpaccio de Vedella", 11f),
            Producte("Arrossada de Montanya", 14f),
            Producte("Salmó a la Planxa", 13f)
        )

        val begudes = listOf(
            Producte("Coca-Cola", 2.5f),
            Producte("Aigua Mineral", 1.5f),
            Producte("Cervesa", 3f),
            Producte("Suc de Taronja", 3.5f),
            Producte("Tè Gelat", 2.8f),
            Producte("Cava", 4f),
            Producte("Vi Blanc", 3.5f),
            Producte("Vi Negre", 3.8f),
            Producte("Tè Verd", 2f),
            Producte("Suc de Poma", 3f)
        )

        val postres = listOf(
            Producte("Tiramisú", 4.5f),
            Producte("Gelat de Xocolata", 3f),
            Producte("Tarta de Formatge", 5f),
            Producte("Fruit Fresc", 3f),
            Producte("Brownie de Xocolata", 4f),
            Producte("Mousse de Llimona", 3.5f),
            Producte("Crema Catalana", 5f),
            Producte("Pastís de Poma", 4f),
            Producte("Flam de Vainilla", 3f),
            Producte("Pastís de Xocolata", 4.5f)
        )

        fun identificarListaMenu(lista: MutableList<MenuModel>): String {
            val menjarsNoms = menjars.map { it.nom }
            val begudesNoms = begudes.map { it.nom }
            val postresNoms = postres.map { it.nom }

            return when {
                lista.all { it.nom in menjarsNoms } -> "menjars"
                lista.all { it.nom in begudesNoms } -> "begudes"
                lista.all { it.nom in postresNoms } -> "postres"
                else -> "desconeguda"
            }
        }

        fun identificarListaProducte(lista: List<Producte>): String {
            val menjarsNoms = menjars.map { it.nom }
            val begudesNoms = begudes.map { it.nom }
            val postresNoms = postres.map { it.nom }

            return when {
                lista.all { it.nom in menjarsNoms } -> "menjars"
                lista.all { it.nom in begudesNoms } -> "begudes"
                lista.all { it.nom in postresNoms } -> "postres"
                else -> "desconeguda"
            }
        }





    }
}