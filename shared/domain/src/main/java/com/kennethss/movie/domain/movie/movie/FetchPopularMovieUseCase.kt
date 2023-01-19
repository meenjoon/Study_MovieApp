package com.kennethss.movie.domain.movie.movie

import com.kennethss.movie.domain.movie.di.IoDispatcher
import com.kennethss.movie.domain.movie.usecase.FlowUseCase
import com.kennethss.movie.domain.movie.usecase.NoParamFlowUseCase
import com.kennethss.movie.domain.movie.usecase.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

/*
FetchPopularMovieUseCase 클래스는 인기있ㅆ는 Movie만 가져오는 것만을 실행하는 UseCase이다.
@Inject를 통하여 MovieRepository를 주입받지만, 인터페이스라서 할 수 없다.
아까와 말한대로 @Module @InstallIn @Binds를 통해서 매개변수에 인터페이스를 쓰려고 하는 객체를 넣고 리턴 타입에 자신을 넣으면 자신의 interface 인스턴스가 생성이 된다.
여기에서는 위에서 말한 것을 생성해서 넣은것이다.
또한 @Inject를 통하여 CoroutineDispatcher를 주입받지만 구체적으로 어떤 CoroutineDispatcher를 주입을 하는지 모른다.
이것을 해결하기 위해 @Qualifier를 사용하여 각각의 객체를 생성할 지 커스텀하고 @Provides 에 정의하여 사용한다.
 */

class FetchPopularMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<FetchPopularMovieUseCaseParam, List<MovieThumbnail>>(dispatcher) {

    override fun execute(parameters: FetchPopularMovieUseCaseParam) =
        movieRepository.getPopularMovies(parameters.page)
            .onStart { emit(Result.Loading) }
}

data class FetchPopularMovieUseCaseParam(val page: Int)
