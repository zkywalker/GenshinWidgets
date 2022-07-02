package org.zky.genshinwidgets.database

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.zky.genshinwidgets.Database
import org.zky.genshinwidgets.MainQueries
import org.zky.genshinwidgets.utils.application

object DatabaseStore {

    private var database: Database? = null

    val queries: MainQueries
        get() = (database ?: init(application)).mainQueries

    private fun init(context: Context): Database {
        val driver: SqlDriver = AndroidSqliteDriver(Database.Schema, context, "genshin_widgets.db")
        return Database(driver)
    }

}