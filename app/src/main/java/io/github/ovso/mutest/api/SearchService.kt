package io.github.ovso.mutest.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
  @GET("/search/users?per_page=15")
  fun search(
    @Query("q") query: String,
    @Query("page") page: Int,
    @Query("per_page") perPage: Int = 15
  ): Single<SearchRequest>
}