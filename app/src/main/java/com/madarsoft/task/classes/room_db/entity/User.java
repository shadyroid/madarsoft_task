package com.madarsoft.task.classes.room_db.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userName;
    private String age;
    private String jobTitle;
    private int gender;


    public User(int id,String userName, String age, String jobTitle, int gender) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.jobTitle = jobTitle;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private int id;
        private String userName;
        private String age;
        private String jobTitle;
        private int gender;

        UserBuilder() {
        }

        public UserBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder age(String age) {
            this.age = age;
            return this;
        }

        public UserBuilder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public UserBuilder gender(int gender) {
            this.gender = gender;
            return this;
        }

        public User build() {
            return new User(id, userName, age, jobTitle, gender);
        }

        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", userName=" + this.userName + ", age=" + this.age + ", jobTitle=" + this.jobTitle + ", gender=" + this.gender + ")";
        }
    }
}
