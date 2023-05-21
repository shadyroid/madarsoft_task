package com.madarsoft.task.classes.room_db.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.madarsoft.task.classes.room_db.dao.UsersDao;
import com.madarsoft.task.classes.room_db.entity.User;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    // The associated DAOs for the database
    public abstract UsersDao usersDao();

}
