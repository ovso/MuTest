package io.github.ovso.mutest.api

import io.github.ovso.mutest.api.model.SearchResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
  @GET("/search/users?")
  fun search(
    @Query("q") query: String,
    @Query("page") page: Int,
    @Query("per_page") perPage: Int
  ): Single<SearchResult>
}