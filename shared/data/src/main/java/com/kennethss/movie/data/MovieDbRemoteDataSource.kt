package com.kennethss.movie.data

/* Movie DB에 대한 interface이다.
구현해야할 메서드에 각 메서드에 필요한 매개변수를 넣으면 고유하지 않은 데이터 계층의 MovieData, MovieThumbnailData을 반환하도록 짜야한다.
이 인터페이스를 이용할 곳은 MovieRepositoryImpl이다.
*/
interface MovieDbRemoteDataSource {

    suspend fun getMovieDetail(id: Int): MovieData
    suspend fun getPopularMovie(page: Int): List<MovieThumbnailData>
}
