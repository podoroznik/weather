package data.source.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import data.entitiy.WeatherItemDB

@Database(entities = [WeatherItemDB::class], version = 2, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {

    abstract val dao: WeatherDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: WeatherDatabase? = null

        fun getInstance(context: Context): WeatherDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WeatherDatabase::class.java, "weather_table"
                    ).fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }
    }
}