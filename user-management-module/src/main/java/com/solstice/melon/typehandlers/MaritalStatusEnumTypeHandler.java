package com.solstice.melon.typehandlers;

import com.solstice.melon.enums.MaritalStatus;
import com.solstice.melon.enums.Sex;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
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
 * @Date 2018/5/15
 * @Time 11:30
 * @Description 枚举类型处理器，用于将java枚举映射到数据库中
 */
@MappedJdbcTypes({JdbcType.SMALLINT})
@MappedTypes({MaritalStatus.class})
public class MaritalStatusEnumTypeHandler extends BaseTypeHandler<MaritalStatus> {

    private static final Logger log = LoggerFactory.getLogger(MaritalStatusEnumTypeHandler.class);

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, MaritalStatus maritalStatus, JdbcType jdbcType) throws SQLException {
        log.info("SexEnumTypeHandler.setNonNullParameter()");
        preparedStatement.setInt(i,maritalStatus.getCode());
    }

    @Override
    public MaritalStatus getNullableResult(ResultSet resultSet, String s) throws SQLException {
        log.info("SexEnumTypeHandler.getNullableResult()");
        return MaritalStatus.indexOf(resultSet.getInt(s));
    }

    @Override
    public MaritalStatus getNullableResult(ResultSet resultSet, int i) throws SQLException {
        log.info("SexEnumTypeHandler.getNullableResult()");
        return MaritalStatus.indexOf(resultSet.getInt(i));
    }

    @Override
    public MaritalStatus getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        log.info("SexEnumTypeHandler.getNullableResult()");
        return MaritalStatus.indexOf(callableStatement.getInt(i));
    }
}
