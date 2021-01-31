package data.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weather.utils.ProjectConstants.EMPTY_STRING

@Entity(tableName = "weather_table")
data class WeatherItemDB (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "temp")
    var temp: Double = 0.0,
    @ColumnInfo(name = "temp_max")
    var tempMax: Double = 0.0,
    @ColumnInfo(name = "temp_min")
    var tempMin : Double = 0.0,
    @ColumnInfo(name = "city_name")
    var name : String = EMPTY_STRING
)