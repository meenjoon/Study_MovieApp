package com.kennethss.movie.di

import com.kennethss.movie.data.MovieDbRemoteDataSource
import com.kennethss.movie.remote.moviedb.MovieDbRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteModule {
/* 인터페이스는 constructor-inject 할 수 없다. 왜냐하면  인터페이스의 어느 구현체가 객체로 사용될 지 모르기 때문이다.
 그렇기 때문에 @Binds를 통하여 리턴타입은 어떤 타입의 인스턴스를 제공하는지 파라미터는 어떤 타입의 객체를 주입받을지 알려준다.(함수 이름 시작은 binds로 시작함)
 아래에서는 bindsMovieDbRemoteDataSource를 위하여 MovieDbRemoteDataSourceImpl 객체를 주입(이 객체를 보게되면 bindsMovieDbRemoteDataSource를 구현하게 되어 있음)
  MovieDbRemoteDataSource 라는 인스턴스를 획득한다.
 */

    @Singleton
    @Binds
    abstract fun bindsMovieDbRemoteDataSource(source: MovieDbRemoteDataSourceImpl): MovieDbRemoteDataSource
}
