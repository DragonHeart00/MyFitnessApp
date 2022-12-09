package com.example.myfitnessapp.di

import android.content.Context
import com.example.myfitnessapp.MyFitnessApp
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * AppModule class will provide dependencies
 * for a part of the application.
 * It is normal to have multiple Dagger modules in a project,
 * and it is typical for one of them to provide app-wide dependencies.
 */

/**
 * @InstallIn specifies which class the module will be installed in.
 * We use ApplicationComponent to install the module throughout
 * the lifecycle of the application.
 */

/**
 * We can see that this method will be used to
 * provide instances of the application class
 * that we instantiated in the application class.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): MyFitnessApp {
        return app as MyFitnessApp
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}

/**
 * provideFirebaseAuth
 * will create reference to the repository
 *
 */

/**
 * @Provides
 * it is annotation tells Dagger that the method provides
 * a certain type of dependency, in this case, a Context object.
 * When a part of the app requests that Dagger inject a Context,
 * the @Provides annotation tells Dagger where to find it.
 */

/**
 * @Singleton
 * It tells Dagger that there should only be a single instance of that dependency.
 * So when generating the code Dagger will handle all the logic for you,
 * and you won’t write all the boilerplate code to check if another instance of the object is already available.
 */

