package io.github.ovso.mutest.api

import io.github.ovso.mutest.api.model.SearchResult
import io.reactivex.Single
import timber.log.Timber

class SearchRequest : BaseRequest<SearchService>() {

  override val apiClass: Class<SearchService>
    get() = SearchService::class.java
  override val isInterceptor: Boolean
    get() = false

  fun search(query: String, page: Int, perPage: Int = 10): Single<SearchResult> {
    Timber.d("search($query,$page,$perPage)")
    return api.search(query, page, perPage)
  }

}