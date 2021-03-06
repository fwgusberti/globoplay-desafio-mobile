package br.com.nerdrapido.themoviedbapp.ui.login

import br.com.nerdrapido.themoviedbapp.data.model.login.RequestTokenResponse
import br.com.nerdrapido.themoviedbapp.ui.abstracts.View

/**
 * Created By FELIPE GUSBERTI @ 08/03/2020
 */
interface LoginView : View {

    fun showMdbDialog(requestTokenResponse: RequestTokenResponse)

    fun showLoginDenied()

}