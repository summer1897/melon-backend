package com.solstice.melon.typehandlers;

import com.solstice.melon.enums.AcademicDegree;
import com.solstice.melon.enums.DegreeOfEducation;
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
@MappedTypes({DegreeOfEducation.class})
public class DegreeOfEducationEnumTypeHandler extends BaseTypeHandler<DegreeOfEducation> {

    private static final Logger log = LoggerFactory.getLogger(DegreeOfEducationEnumTypeHandler.class);

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, DegreeOfEducation degreeOfEducation, JdbcType jdbcType) throws SQLException {
        log.info("SexEnumTypeHandler.setNonNullParameter()");
        preparedStatement.setInt(i,degreeOfEducation.getValue());
    }

    @Override
    public DegreeOfEducation getNullableResult(ResultSet resultSet, String s) throws SQLException {
        log.info("SexEnumTypeHandler.getNullableResult()");
        return DegreeOfEducation.indexOf(resultSet.getInt(s));
    }

    @Override
    public DegreeOfEducation getNullableResult(ResultSet resultSet, int i) throws SQLException {
        log.info("SexEnumTypeHandler.getNullableResult()");
        return DegreeOfEducation.indexOf(resultSet.getInt(i));
    }

    @Override
    public DegreeOfEducation getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        log.info("SexEnumTypeHandler.getNullableResult()");
        return DegreeOfEducation.indexOf(callableStatement.getInt(i));
    }
}
