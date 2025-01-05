package com.example.projectecafeteria

import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private var _user = User("","")
    val user: User
        get() = _user

    fun checkUser(user: String, password: String): Boolean {
        _user = User(user, password)

        for (u in UsersProvider.users) {
            if (u.user == _user.user && u.password == _user.password) {
                return true
            }
        }
        return false
    }
}
