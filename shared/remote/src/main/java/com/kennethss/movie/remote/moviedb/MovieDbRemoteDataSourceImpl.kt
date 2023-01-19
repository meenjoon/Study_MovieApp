package com.kennethss.movie.remote.moviedb

import com.kennethss.movie.data.MovieData
import com.kennethss.movie.data.MovieThumbnailData
import com.kennethss.movie.data.MovieDbRemoteDataSource
import com.kennethss.movie.remote.response.detail.toData
import com.kennethss.movie.remote.response.popular.toData
import com.kennethss.movie.remote.service.MovieDbService
import javax.inject.Inject

/*
MovieDbRemoteDataSourceImpl 클래스는 MovieDbService 객체를 의존성 주입 받는다.
이때 MovieDbService 인터페이스인데 retrofit객체로 생성되기 때문에 때문에 @Module과@InstalIn과@Provides를 이용하여 바인딩 정보를 제공해야한다
이때 @Module과@InstallIn과@Provides를 이용을 하여 메서드를 작성한 코드를 보게 되면
  매개변수로 사용하려는 클래스의 객체인 retrofit 객체를 받게 되고
  그리고 리턴으로 자기 자신인 MovieDbService를 인스턴스화 하는것이다.(이름은 provides 시작해야함)

즉, MovieDbService 의존성 주입을 하려고 보니 인터페이스 여서 안되었고 이것을 @Module과@InstallIn@Provides를 통해 해결하였다.
@Module과@InstallIn@Provides를 이용하여 메서드를 작성할때 레트로핏(사용할 객체)를 매개변수에 넣고, 인터페이스 자기 자신을 리턴 타입으로 받으면 된다.
==> 여기서 궁금한점이 인터페이스 이지만 hilt로 인해서 레트로핏 객체를 통해 값을 가진(구현) 인스턴스가 되는것이간 ?

MovieDbRemoteDataSourceImpl 클래스에 대해 설명해보자면, MovieDbService 의존성 주입을 받고 도메인 계층의 MovieDbRemoteDataSource를 구현해야한다.
==> 여기서 MovieDbRemoteDataSourceImpl이 MovieDbService 인터페이스 인스턴스를 통해 값을 받아왔기 때문에
MovieRemoteDataSource 인터페이스도 @Module과@InstallIn@Binds를 통해 매개변수에 MovieDbRemoteDataSourceImpl(사용할 객체)를 넣고
 리턴 값에 자기 자신인(인터페이스) MovieRemoteDataSource를 인스턴스 화 해주는 것인가..?

 */


class MovieDbRemoteDataSourceImpl @Inject constructor(
    private val movieDbService: MovieDbService
) : MovieDbRemoteDataSource {

    override suspend fun getMovieDetail(id: Int): MovieData {
        return movieDbService.getMovieDetail(id).toData()
    }

    override suspend fun getPopularMovie(page: Int): List<MovieThumbnailData> {
        return movieDbService.getPopularMovie(page).results.map { it.toData() }
    }
}
