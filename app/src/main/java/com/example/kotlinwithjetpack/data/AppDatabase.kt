package com.example.kotlinwithjetpack.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.kotlinwithjetpack.gaadi.data.Gaadi
import com.example.kotlinwithjetpack.gaadi.data.GaadiDao
import com.example.kotlinwithjetpack.legoset.data.LegoSet
import com.example.kotlinwithjetpack.legoset.data.LegoSetDao
import com.example.kotlinwithjetpack.legotheme.data.LegoTheme
import com.example.kotlinwithjetpack.legotheme.data.LegoThemeDao
import com.example.kotlinwithjetpack.worker.SeedDatabaseWorker

/**
 * The Room database for this app
 */
@Database(entities = [LegoTheme::class, LegoSet::class, Gaadi::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun legoSetDao(): LegoSetDao

    abstract fun legoThemeDao(): LegoThemeDao

    abstract fun gaadiDao(): GaadiDao


    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "legocatalog-db")
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    })
                    .build()
        }
    }
}
