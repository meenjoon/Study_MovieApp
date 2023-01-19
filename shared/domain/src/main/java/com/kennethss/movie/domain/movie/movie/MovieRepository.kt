package com.kennethss.movie.domain.movie.movie

import com.kennethss.movie.domain.movie.usecase.Result
import kotlinx.coroutines.flow.Flow


/* MovieRepository에 대한 interface이다 킴드에 필요한 매개변수를 넣으면 고유한 Movie, MovieThumbnail 을 반환하도록 짜야한다.
이 인터페이스를 구현하는 곳은 MovieRepositoryImpl이다.
*/
interface MovieRepository {
    fun getMovieDetail(id: Int): Flow<Result<Movie>>
    fun getPopularMovies(page: Int): Flow<Result<List<MovieThumbnail>>>
}
