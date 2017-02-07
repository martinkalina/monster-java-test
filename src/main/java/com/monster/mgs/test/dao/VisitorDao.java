package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.Visitor;

public interface VisitorDao {

    Visitor findByEmail(String emailAddress);

}
