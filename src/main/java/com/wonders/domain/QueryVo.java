package com.wonders.domain;

import java.util.List;

/**
 * 多个实体对象封装成查询条件
 */
public class QueryVo {

    /**
     * 一个实体对象
     */
    private User user;
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
