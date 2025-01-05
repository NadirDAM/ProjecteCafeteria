package com.example.projectecafeteria

import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    fun createUser(user: String, password: String): String {
        if (user.isEmpty() || password.isEmpty()) {
            return "Els camps no poden estar buits"
        }

        for (u in UsersProvider.users) {
            if (u.user == user) {
                return "Usuari ja existent"
            }
        }
        if (password.length < 8) {
            return "La contrasenya ha de tenir almenys 8 caràcters"
        }
        else if (!password.any { it.isUpperCase() }) {
            return "La contrasenya ha de tenir almenys una lletra majúscula"
        }
        else if (!password.any { it.isDigit() }) {
            return "La contrasenya ha de tenir almenys un número"
        }

        UsersProvider.users.add(User(user, password))
        return ""
    }
}
