package Entity;

import java.util.Arrays;

public class UserList {




    private User[] users;
    private int index;

    public UserList() {
        this.users = new User[10];
        this.index = 0;
    }

    public void add(User user) {
        users[index] = user;
        index++;

        if (index >= users.length)
            users = Arrays.copyOf(users, users.length * 2);
    }

    public int getIndex() {
        return index;
    }

    public User getUsers(int index) {
        return users[index];
    }
    }


