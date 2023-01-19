package com.kennethss.movie.di

import com.kennethss.movie.data.MovieRepositoryImpl
import com.kennethss.movie.domain.movie.movie.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

/* 인터페이스는 constructor-inject 할 수 없다. 왜냐하면  인터페이스의 어느 구현체가 객체로 사용될 지 모르기 때문이다.
 그렇기 때문에 @Binds를 통하여 리턴타입은 어떤 타입의 인스턴스를 제공하는지 파라미터는 어떤 타입의 객체를 주입받을지 알려준다.(함수 이름 시작은 binds로 시작함)
 아래에서는 MovieRepository 인터페이스를 위하여 MovieRepositoryImpl의 객체를 주입받고 MovieRepository을 인스턴스 제공한다.
 */

    @Binds
    fun bindsMovieRepository(
        repository: MovieRepositoryImpl
    ): MovieRepository
}
