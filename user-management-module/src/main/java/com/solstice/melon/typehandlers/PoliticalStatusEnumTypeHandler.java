package com.solstice.melon.typehandlers;

import com.solstice.melon.enums.PoliticalStatus;
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
@MappedTypes({PoliticalStatus.class})
public class PoliticalStatusEnumTypeHandler extends BaseTypeHandler<PoliticalStatus> {

    private static final Logger log = LoggerFactory.getLogger(PoliticalStatusEnumTypeHandler.class);

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, PoliticalStatus politicalStatus, JdbcType jdbcType) throws SQLException {
        log.info("SexEnumTypeHandler.setNonNullParameter()");
        preparedStatement.setInt(i,politicalStatus.getValue());
    }

    @Override
    public PoliticalStatus getNullableResult(ResultSet resultSet, String s) throws SQLException {
        log.info("SexEnumTypeHandler.getNullableResult()");
        return PoliticalStatus.indexOf(resultSet.getInt(s));
    }

    @Override
    public PoliticalStatus getNullableResult(ResultSet resultSet, int i) throws SQLException {
        log.info("SexEnumTypeHandler.getNullableResult()");
        return PoliticalStatus.indexOf(resultSet.getInt(i));
    }

    @Override
    public PoliticalStatus getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        log.info("SexEnumTypeHandler.getNullableResult()");
        return PoliticalStatus.indexOf(callableStatement.getInt(i));
    }
}
