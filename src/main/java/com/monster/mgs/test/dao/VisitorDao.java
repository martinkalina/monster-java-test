package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.Visitor;

public interface VisitorDao {

    void create(Visitor visitor);

    Visitor findByEmail(String emailAddress);

}
