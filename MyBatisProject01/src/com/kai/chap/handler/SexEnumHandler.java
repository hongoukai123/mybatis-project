package com.kai.chap.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.kai.chap.enumeration.SexEnum;

/**
 * 性别枚举处理器
 * @author hok
 * @since 2019-3-13 14:59:04
 */
public class SexEnumHandler extends BaseTypeHandler<SexEnum> {

	/**
	 *  用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
	 */
	@Override
	public SexEnum getNullableResult(ResultSet rs, String columName) throws SQLException {
		//根据数据库存储类型决定获取类型，本例中数据库存放的是int类型
		int id = rs.getInt(columName);
		if(rs.wasNull()) {
			return null;
		}
		return SexEnum.getSexEnum(id);
	}

	/**
	 * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
	 */
	@Override
	public SexEnum getNullableResult(ResultSet rs, int columIndex) throws SQLException {
		//根据数据库存储类型决定获取类型，本例中数据库存放的是int类型
		int id = rs.getInt(columIndex);
		if(rs.wasNull()) {
			return null;
		}
		return SexEnum.getSexEnum(id);
	}

	/**
	 * 用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
	 */
	@Override
	public SexEnum getNullableResult(CallableStatement cs, int columIndex) throws SQLException {
		//根据数据库存储类型决定获取类型，本例中数据库存放的是int类型
		int id = cs.getInt(columIndex);
		if(cs.wasNull()) {
			return null;
		}
		return SexEnum.getSexEnum(id);
	}

	/**
	 * 用于定义设置参数时，该如何把java的参数转换为对应的数据类型
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
		//BaseTypeHandler已经帮我们做了sexEnum的null判断
		//第二个参数存入到数据库中的值
		ps.setInt(i, sexEnum.getId());
	}

}
