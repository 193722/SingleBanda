/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */
 
/*
 * 修订记录:
 * zisi@yiji.com:2017-05-22 10:59创建
 */
package top.yunsun.bicycle.core.ground.usertype;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import top.yunsun.bicycle.core.money.Money;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * spring-data-jpa的api实现使用Hibernate,此类是Hibernate对用户自定义类型的支持
 */
public class MoneyType implements UserType {

    private static final int[] SQL_TYPES = { Types.INTEGER };

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public Class<?> returnedClass() {
        return Money.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if ((x == null) || (y == null)) {
            return false;
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x == null ? 0 : x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
            throws HibernateException,
            SQLException {
        Long value = rs.getLong(names[0]);
        Money m = new Money();
        m.setCent(value);
        return m;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,
                            SessionImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setLong(index, 0L);
            return;
        }

        if (!(value instanceof Money)) {
            throw new HibernateException("value is not type of " + Money.class);
        }

        st.setLong(index, ((Money) value).getCent());
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

}
