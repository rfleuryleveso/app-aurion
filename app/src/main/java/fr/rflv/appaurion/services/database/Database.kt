package fr.rflv.appaurion.services.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.koin.core.annotation.Single

@Single
class Database(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // below is a sqlite query, where column names
        // along with their data types is given
        val query = """create table courses
(
    id            TEXT,
    startDateTime TEXT,
    endDateTime   TEXT,
    teachers      TEXT,
    students      TEXT,
    courseType    TEXT,
    rooms         TEXT,
    groups        TEXT,
    name          TEXT
);
"""


        // we are calling sqlite
        // method for executing our query
        db.execSQL(query)

        val createIndexQuery = """create unique index courses_id_uindex
    on courses (id);"""

        db.execSQL(createIndexQuery);

        val queryCreateMarks = """create table marks
(
    identifier  TEXT not null,
    name        TEXT,
    date        TEXT,
    mark        REAL,
    coefficient REAL
);"""
        db.execSQL(queryCreateMarks)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS courses; DROP TABLE IF EXISTS marks;")
        onCreate(db)
    }


    companion object {
        // here we have defined variables for our database

        // below is variable for database name
        private val DATABASE_NAME = "app-aurion"

        // below is the variable for database version
        private val DATABASE_VERSION = 1

    }
}