package com.kennethss.movie.data

import com.kennethss.movie.domain.movie.movie.Movie
import com.kennethss.movie.domain.movie.movie.MovieThumbnail
import com.kennethss.movie.domain.movie.movie.MovieRepository
import com.kennethss.movie.domain.movie.usecase.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/*
MovieRepositoryImpl 클래스는 MovieDbRemoteDataSource 객체를 의존성 주입 받는다.
이때 MovieDbRemoteDataSource는 인터페이스 이기 때문에 @Module과@InstalIn과@Binds를 이용하여 바인딩 정보를 제공해야한다
이때 @Module과@InstallIn과@Binds를 이용을 하여 메서드를 작성한 코드를 보게 되면
  매개변수로는 MovieDbRemoteDataSourceImpl 클래스에서 MovieDbRemoteDataSource를 구현했기 때문에 구현을 시킨 MovieDbRemoteDataSourceImpl를 넣어주고,
  그리고 리턴으로 자기 자신인 MovieDbRemoteDataSource를 인스턴스화 하는것이다.(이름은 binds로 시작해야함)

즉, MovieDbRemoteDataSource를 의존성 주입을 하려고 보니 인터페이스 여서 안되었고 이것을 @Module과@InstallIn@Binds를 통해 해결하였다.
@Module과@InstallIn@Binds를 이용하여 메서드를 작성할때,
매개변수로 인터페이스를 구현한 클래스(MovieDbRemoteDataSourceImpl)를 넣고,
인터페이스 자기 자신(MovieDbRemoteDataSource)을 리턴 타입으로 받으면 된다.

MovieRepositoryImpl 클래스에 대해 설명해보자면, MovieDbRemoteDataSource를 의존성 주입을 받고 도메인 계층의 MovieRepository를 구현해야한다.

 */


/*  궁금한점은 constructor-@Inject MovieDbRemoteDataSource를 받는데 이것은 아무런것이 들어있지 않은? 인터페이스 인스턴스 인데 넣어봤자 아닌가..? 라는 생각이 든다..
생성자에 인터페이스 인스턴스를 넣는 이유를 모르는것이다..
==> 아 ! 알 것 같다. remote 계층의 MovieDbService 인터페이스를 @Mudule,@InstallIn,@Provides를 통해 레트로핏 객체를 사용해
 데이터를 받는 싱글톤 MovieDbService 인터페이스 인스턴스로 생성을 하였고,
MovieDbRemoteDataSourceImpl 클래스에서 이러한 MovieDBService 인스턴스를 이용하여 MovieDbRemoteDataSource를 구현하기 때문이다.
이때 hilt 기능인 @Module과@InstallIn과@Binds를 통하여 MovieDbRemoteDataSource 인터페이스를 구현하는 MovieDbRemoteDataSourceImpl 객체를 매개변수로 넣고
리턴 타입을 자기 자신인 MovieDbRemoteDataSource로 인스턴스 시켜줬기 때문에 MovieDbRemoteDataSource는 값이 있는 것이다..!
맞을까..?

 */
class MovieRepositoryImpl @Inject constructor(
    private val movieDbRemoteDataSource: MovieDbRemoteDataSource
) : MovieRepository {


    //flow에 처음에는 Seal Class의 Result.Loading 그 후 Result.Success(result) ?? 그냥 로딩을 콜렉트 해주고 싶어서 인가..?
    override fun getMovieDetail(id: Int): Flow<Result<Movie>> = flow{
        emit(Result.Loading)
        val result = movieDbRemoteDataSource.getMovieDetail(id).toDomain()
        emit(Result.Success(result))
    }

    override fun getPopularMovies(page: Int): Flow<Result<List<MovieThumbnail>>> = flow {
        emit(Result.Loading)
        val result = movieDbRemoteDataSource.getPopularMovie(page).map { it.toDomain() }
        emit(Result.Success(result))
    }
}
