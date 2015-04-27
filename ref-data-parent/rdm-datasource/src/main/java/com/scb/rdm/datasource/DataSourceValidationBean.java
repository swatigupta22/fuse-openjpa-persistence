package com.scb.rdm.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DataSourceValidationBean {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void validate() {
		System.out.println("DataSourceValidationBean.validate()");
		Connection connection = null;
		try {
			connection = getDataSource().getConnection();
		} catch (SQLException e) {
			System.err.println("Connection to the DataSource is failed.");
		}
		if (connection != null) {
			System.out.println("Connection to the DataSource is successful.");
		}

	}
}
