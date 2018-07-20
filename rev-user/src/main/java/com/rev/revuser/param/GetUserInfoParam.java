package com.rev.revuser.param;

import java.io.Serializable;

public class GetUserInfoParam implements Serializable {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
