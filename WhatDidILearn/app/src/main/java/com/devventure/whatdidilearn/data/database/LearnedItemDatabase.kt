package com.devventure.whatdidilearn.data.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.devventure.whatdidilearn.entities.LearnedItem
import com.devventure.whatdidilearn.view.adapters.UnderstandingLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [LearnedItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class LearnedItemDatabase : RoomDatabase() {
    abstract fun learnedItemDao(): LearnedItemDao

    companion object {
        @Volatile // Torna esse campo imediatamente visivel apra outras threads
        private var INSTANCE: LearnedItemDatabase? = null

        // Usamos o synchronized para garantir que a criação só seja disparada uma vez por solicitação
        fun getDatabase(context: Context, scope: CoroutineScope): LearnedItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val database = Room.databaseBuilder(
                    context.applicationContext,
                    LearnedItemDatabase::class.java,
                    "learned_item_database"
                )
                    .addCallback(LearnedItemDatabaseCallback(scope))
                    .build()

                INSTANCE = database
                database
            }
        }

    }

    private class LearnedItemDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                scope.launch {
//                    populateDatabase(it.learnedItemDao())
                }
            }
        }

        private fun populateDatabase(learnedItemDao: LearnedItemDao) {
            val items = getAll()
//            learnedItemDao.insert(items)
        }

        fun getAll(): List<LearnedItem> {
            return listOf(
                LearnedItem(
                    name = "RecyclerView",
                    description = "Lista de views",
                    understandingLevel = UnderstandingLevel.LOW
                ),
                LearnedItem(
                    name = "Kotlin",
                    description = "Linguagem de programação",
                    understandingLevel = UnderstandingLevel.MEDIUM
                ),
                LearnedItem(
                    name = "Dataclass",
                    description = "Uma dataclass",
                    understandingLevel = UnderstandingLevel.HIGH
                ),
                LearnedItem(
                    name = "Life cycle",
                    description = "Ciclo de vida da activity e fragment",
                    understandingLevel = UnderstandingLevel.LOW
                ),
                LearnedItem(
                    name = "Intent",
                    description = "Apresentar intenções",
                    understandingLevel = UnderstandingLevel.MEDIUM
                ),
                LearnedItem(
                    name = "Services",
                    description = "Service em android",
                    understandingLevel = UnderstandingLevel.HIGH
                ),
                LearnedItem(
                    name = "Content provider",
                    description = "Dados com content provider",
                    understandingLevel = UnderstandingLevel.LOW
                ),
                LearnedItem(
                    name = "RecyclerView",
                    description = "Mostrar uma lista de qualquer coisa na tela",
                    understandingLevel = UnderstandingLevel.MEDIUM
                )
            )
        }
    }
}
