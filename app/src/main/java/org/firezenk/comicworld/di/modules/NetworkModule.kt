package org.firezenk.comicworld.di.modules

import com.karumi.marvelapiclient.CharacterApiClient
import com.karumi.marvelapiclient.ComicApiClient
import com.karumi.marvelapiclient.MarvelApiConfig
import com.karumi.marvelapiclient.SeriesApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module open class NetworkModule {

    @Provides @Singleton fun provideApiConfig(): MarvelApiConfig
            = MarvelApiConfig.Builder(
            "8caeb32966c4741d0936b6ebc4b55cfe",
            "27f36853448e42691e1bd6a9fbcdcd0bcd1e0631")
            .debug().build();

    @Provides fun provideCharacterApi(config: MarvelApiConfig): CharacterApiClient = CharacterApiClient(config)

    @Provides fun provideComicApi(config: MarvelApiConfig): ComicApiClient = ComicApiClient(config)

    @Provides fun provideSeriesApi(config: MarvelApiConfig): SeriesApiClient = SeriesApiClient(config)
}