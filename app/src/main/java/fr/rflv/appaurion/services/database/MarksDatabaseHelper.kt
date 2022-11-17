package fr.rflv.appaurion.services.database

import android.content.ContentValues
import android.content.Context
import fr.rflv.appaurion.services.aurion.data.Mark
import kotlinx.datetime.LocalDate
import org.koin.core.annotation.Single

@Single
class MarksDatabaseHelper(private val context: Context) {

    private val database = Database(context)

    // This method is for adding data in our database
    fun addMark(mark: Mark) {
        val values = ContentValues()
        values.put("id", mark.id)
        values.put("date", mark.date.toString())
        values.put("name", mark.name)
        values.put("mark", mark.mark)
        values.put("coefficient", mark.mark)
        val db = this.database.writableDatabase
        db.insert("mark", null, values)
        db.close()
    }

    fun getMarks(): Array<Mark> {
        val db = this.database.writableDatabase
        val marksCursor = db.query("marks", null, null, null, null, null, null)
        val marks = arrayOf<Mark>();
        marksCursor!!.moveToFirst();
        if (marksCursor.count > 0) {
            do {
                marks.plus(
                    Mark(
                        id = marksCursor.getString(marksCursor.getColumnIndexOrThrow("id")),
                        date = LocalDate.parse(
                            marksCursor.getString(
                                marksCursor.getColumnIndexOrThrow(
                                    "date"
                                )
                            )
                        ),
                        name = marksCursor.getString(marksCursor.getColumnIndexOrThrow("name")),
                        mark = marksCursor.getFloat(
                            marksCursor.getColumnIndexOrThrow(
                                "mark"
                            )
                        ),
                        coefficient = marksCursor.getInt(
                            marksCursor.getColumnIndexOrThrow(
                                "mark"
                            )
                        )

                    )
                )
                marksCursor.moveToNext()
            } while (!marksCursor.isAfterLast)
        }
        marksCursor.close();
        return marks;
    }
}