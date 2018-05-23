package com.solstice.melon.typehandlers;

import com.solstice.melon.enums.*;
import com.summer.base.utils.ObjectUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Intellij IDEA
 *
 * @Projcet melon
 * @Author solstice
 * @Date 2018/5/21
 * @Time 10:45
 * @Description
 */
//@MappedJdbcTypes({JdbcType.SMALLINT})
//@MappedTypes({AcademicDegree.class, DegreeOfEducation.class,
//        MaritalStatus.class,Nation.class,
//        PoliticalStatus.class,Sex.class})
public class ValueEnumTypeHandler<E extends Enum<?> & BaseEnum> extends BaseTypeHandler<BaseEnum> {

    private static final Logger log = LoggerFactory.getLogger(ValueEnumTypeHandler.class);

    private Class<E> type;

    public ValueEnumTypeHandler(Class<E> type) {
        if (ObjectUtils.isNull(type)) {
            throw new IllegalArgumentException("type can not be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BaseEnum baseEnum, JdbcType jdbcType) throws SQLException {
        /*log.info("ValueEnumTypeHandler.setNonNullParameter()");
        ps.setInt(i,baseEnum.getValue());*/
    }

    @Override
    public BaseEnum getNullableResult(ResultSet rs, String s) throws SQLException {
        log.info("ValueEnumTypeHandler.getNullableResult()");
        /*if (!rs.wasNull()) {
            int i = rs.getInt(s);
            try {
                return EnumUtils.valueOf(type,i);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", e);
            }
        }*/
        return null;
    }

    @Override
    public BaseEnum getNullableResult(ResultSet rs, int index) throws SQLException {
        log.info("ValueEnumTypeHandler.getNullableResult()");
        /*if (!rs.wasNull()) {
            int i = rs.getInt(index);
            try {
                return EnumUtils.valueOf(type,i);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", e);
            }
        }*/
        return null;
    }

    @Override
    public BaseEnum getNullableResult(CallableStatement cs, int index) throws SQLException {
        log.info("ValueEnumTypeHandler.getNullableResult()");
        /*if (!cs.wasNull()) {
            int i = cs.getInt(index);
            try {
                return EnumUtils.valueOf(type,i);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", e);
            }
        }*/
        return null;
    }
}
