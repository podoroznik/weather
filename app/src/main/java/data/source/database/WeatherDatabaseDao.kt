package data.source.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import data.entitiy.WeatherItemDB
import io.reactivex.Flowable

@Dao
interface WeatherDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item : WeatherItemDB)

    @Query("SELECT * FROM weather_table ORDER BY id")
    fun getAllData(): Flowable<List<WeatherItemDB>>
}