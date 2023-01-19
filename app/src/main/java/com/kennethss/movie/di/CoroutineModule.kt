package com.kennethss.movie.di

import com.kennethss.movie.domain.movie.di.DefaultDispatcher
import com.kennethss.movie.domain.movie.di.IoDispatcher
import com.kennethss.movie.domain.movie.di.MainDispatcher
import com.kennethss.movie.domain.movie.di.MainImmediateDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module //코루틴은 외부라이브러리 이기 때문에 constructor-inject를 해줄 수 없기 때문에 @Module 어노테이션을 이용한다.
internal object CoroutinesModule {

    /* 모듈 내의 각 메서드에서 똑같은 리턴 타입을 요청할때 사용함
    왜냐하면 Dispatchers.Default, IO, Main, Main.immediate와 같이 상황에 따라 달라야 하는데
    코루틴에서 같은 타입 CoroutineDispatcher를 리턴해버리기 때문에 어떤 필요한 상황에 어떤것을 리턴을 하는것인가를 알 수 없는 것이다.
    즉, 각 메서드에서 같은 CoroutineDispatcher를 객체를 호출하고 있다는 것이다.
    (아래에서는 각 메서드들이 같은 CoroutineDispatcher를
    어떻게 사용하냐면 @Qualifier라는 어노테이션을 이용을 하여 어노테이션 클래스를 만들고 사용할 모듈에서 만든 어노테이션 클래스를 지정하면 된다.
    */

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @MainImmediateDispatcher
    @Provides
    fun providesMainImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate
}
