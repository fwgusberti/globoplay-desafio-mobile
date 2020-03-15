package br.com.nerdrapido.themoviedbapp.data.repository.account

import br.com.nerdrapido.themoviedbapp.data.model.account.AccountRequest
import br.com.nerdrapido.themoviedbapp.data.model.account.AccountResponse
import br.com.nerdrapido.themoviedbapp.data.model.favoritemovies.FavoriteMoviesRequest
import br.com.nerdrapido.themoviedbapp.data.model.favoritemovies.FavoriteMoviesResponse
import br.com.nerdrapido.themoviedbapp.data.repository.abstracts.AbstractMovieDbApiRepos
import retrofit2.Retrofit

/**
 * Created By FELIPE GUSBERTI @ 15/03/2020
 */
class AccountRepositoryImpl(retrofit: Retrofit) : AbstractMovieDbApiRepos(retrofit),
    AccountRepository {

    private val authService: AccountService = retrofit.create(AccountService::class.java)

    override suspend fun getAccount(accountRequest: AccountRequest): AccountResponse {
        return authService.getAccount(accountRequest.sessionId)
    }

    override suspend fun getFavoriteMovies(favoriteMoviesRequest: FavoriteMoviesRequest): FavoriteMoviesResponse {
        return authService.getFavoriteMovies(
            favoriteMoviesRequest.accountId,
            favoriteMoviesRequest.language,
            favoriteMoviesRequest.sessionId,
            favoriteMoviesRequest.sortBy,
            favoriteMoviesRequest.page
        )

    }
}