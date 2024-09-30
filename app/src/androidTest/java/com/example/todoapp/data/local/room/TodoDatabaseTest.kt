package com.example.todoapp.data.local.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.todoapp.domain.model.TodoModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TodoDatabaseTest {

    private lateinit var db: TodoDatabase
    private lateinit var dao: TodoDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            TodoDatabase::class.java
        ).build()
        dao = db.todoDao
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun create() = runBlocking {
        val todo = TodoModel(
            id = 1,
            title = "Test Todo",
            desc = "Test Description"
        )
        dao.create(todo)
        val todoList = dao.read()
        assertNotNull(todoList)
        assertEquals(1, todoList.size)
        assertEquals(todo, todoList[0])
    }

    @Test
    fun read() = runBlocking {
        val todo = TodoModel(
            id = 1,
            title = "Test Todo",
            desc = "Test Description"
        )
        dao.create(todo)
        val retrievedTodo = dao.read(1)
        assertNotNull(retrievedTodo)
        assertEquals(todo, retrievedTodo)
    }

    @Test
    fun update() = runBlocking {
        val todo = TodoModel(
            id = 1,
            title = "Test Todo",
            desc = "Test Description"
        )
        dao.create(todo)
        val updatedTodo = todo.copy(title = "Updated Title")
        dao.update(updatedTodo)
        val retrievedTodo = dao.read(1)
        assertNotNull(retrievedTodo)
        assertEquals(updatedTodo, retrievedTodo)
    }

    @Test
    fun delete() = runBlocking {
        val todo = TodoModel(
            id = 1,
            title = "Test Todo",
            desc = "Test Description"
        )
        dao.create(todo)
        dao.delete(todo)
        val todos = dao.read()
        assertEquals(0, todos.size)
    }
}