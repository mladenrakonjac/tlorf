package me.factliverpool.tlrof.networking

import android.content.Context
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import me.factliverpool.tlrof.BuildConfig
import me.factliverpool.tlrof.androidmanagers.PreferencesManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by mladenrakonjac on 02/10/17.
 */
@Module
class NetModule{

    @Provides
    @Singleton
    fun providesSharedPreferences(context: Context): PreferencesManager {
        return PreferencesManager(context, context.packageName)
    }

    @Provides
    @Singleton
    fun providesFirebaseDatabaseReferance(context: Context): DatabaseReference {
        val firebaseDatabase = FirebaseDatabase.getInstance()
        return firebaseDatabase.getReference(BuildConfig.FIREBASE_BASE)
    }

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Named("languageInterceptor")
    @Provides
    @Singleton
    fun providesLanguageInterceptor(preferencesManager: PreferencesManager): Interceptor {
        return Interceptor{ chain ->
            val newBuilder = chain.request().newBuilder()
            newBuilder.addHeader("Accept-Language", "en")
            val request = newBuilder.build()
            return@Interceptor chain.proceed(request)
        }
    }

    @Named("authInterceptor")
    @Provides
    @Singleton
    fun providesAuthInterceptor(preferencesManager: PreferencesManager): Interceptor {
        return Interceptor { chain ->
            val newBuilder = chain.request().newBuilder()
            newBuilder.addHeader("fl-access-token", preferencesManager.getAccessToken())
            val request = newBuilder.build()
            return@Interceptor chain.proceed(request)
        }
    }

    @Named("authErrorInterceptor")
    @Provides
    @Singleton
    fun providesAuthErrorInterceptor(preferencesManager: PreferencesManager): Interceptor {
        return Interceptor { chain ->
            val newBuilder = chain.request().newBuilder()
            val request = newBuilder.build()
            val proceed = chain.proceed(request)
            if (proceed.code() == 400) {
                preferencesManager.saveAccessToken("")
                preferencesManager.saveUsername("")
            }
            return@Interceptor proceed
        }
    }


    @Singleton
    @Provides
    fun providesClient(@Named("languageInterceptor") languageInterceptor: Interceptor,
                       @Named("authInterceptor") authInterceptor: Interceptor,
                       @Named("authErrorInterceptor") authErrorInterceptor: Interceptor,
                       httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {

        return OkHttpClient().newBuilder()
                .addNetworkInterceptor(languageInterceptor)
                .addNetworkInterceptor(authInterceptor)
                .addNetworkInterceptor(authErrorInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.SERVERURL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun providesErrorConverter(retrofit: Retrofit) : ErrorConverter{
        return ErrorConverter(retrofit)
    }

    @Singleton
    @Provides
    fun providesEndpointService(retrofit: Retrofit) : BaseNetService{

        return retrofit.create(BaseNetService::class.java)
    }
}