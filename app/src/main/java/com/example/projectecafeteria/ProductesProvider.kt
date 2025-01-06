package com.example.projectecafeteria

class ProductesProvider {

    companion object {

        val menjars = listOf(
            Procucte("Ensalada Cèsar", 8f),
            Procucte("Pizza Margarita", 10f),
            Procucte("Bocata de Pernil", 5f),
            Procucte("Paella de Marisc", 15f),
            Procucte("Fideuà", 12f),
            Procucte("Croquetes Casolanes", 7f),
            Procucte("Sopa de Ceba", 6f),
            Procucte("Carpaccio de Vedella", 11f),
            Procucte("Arrossada de Montanya", 14f),
            Procucte("Salmó a la Planxa", 13f)
        )

        val begudes = listOf(
            Procucte("Coca-Cola", 2.5f),
            Procucte("Aigua Mineral", 1.5f),
            Procucte("Cervesa", 3f),
            Procucte("Suc de Taronja", 3.5f),
            Procucte("Tè Gelat", 2.8f),
            Procucte("Cava", 4f),
            Procucte("Vi Blanc", 3.5f),
            Procucte("Vi Negre", 3.8f),
            Procucte("Tè Verd", 2f),
            Procucte("Suc de Poma", 3f)
        )

        val postres = listOf(
            Procucte("Tiramisú", 4.5f),
            Procucte("Gelat de Xocolata", 3f),
            Procucte("Tarta de Formatge", 5f),
            Procucte("Fruit Fresc", 3f),
            Procucte("Brownie de Xocolata", 4f),
            Procucte("Mousse de Llimona", 3.5f),
            Procucte("Crema Catalana", 5f),
            Procucte("Pastís de Poma", 4f),
            Procucte("Flam de Vainilla", 3f),
            Procucte("Pastís de Xocolata", 4.5f)
        )

    }
}