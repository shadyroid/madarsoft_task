package com.madarsoft.task.classes.room_db.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.madarsoft.task.classes.room_db.entity.User;

import java.util.List;

@Dao
public interface UsersDao {

    @Query("SELECT * FROM users")
    List<User> queryAllUsers();

    @Insert
    long insertUser(User user);

}
