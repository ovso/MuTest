package io.github.ovso.mutest.api

class SearchRequest : BaseRequest<SearchService>() {

  override val apiClass: Class<SearchService>
    get() = SearchService::class.java
  override val isInterceptor: Boolean
    get() = false

  fun search(query: String, page: Int) = api.search(query, page)

}