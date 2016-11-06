package com.webapp.knowlin.persistence.handlers;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.EnumTypeHandler;

import com.webapp.knowlin.model.StatusCd;

public class StatusCdTypeHandler extends EnumTypeHandler {

	public StatusCdTypeHandler(Class type) {
		super(type);
	}

	@Override
	public StatusCd getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return StatusCd.convertFrom(rs.getString(columnName)) ;
	}

	@Override
	public StatusCd getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return StatusCd.convertFrom(rs.getString(columnIndex));
	}

	@Override
	public StatusCd getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return StatusCd.convertFrom(cs.getString(columnIndex));
	}
}
