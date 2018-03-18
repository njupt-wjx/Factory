//:com/factoty/db/JDBCConnection.java mysql数据库操作
package com.factory.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;


	import java.sql.*;

	/**
	 * @author wjx*/
	public class JDBCConnection {
		private static final String dbDriver = "com.mysql.jdbc.Driver";
		private static final String url = "jdbc:mysql://localhost:3306/db_factory";
		private static final String user = "root";
		private static final String pwd = "123456";
		private Connection conn = null;
		
		/**
		 * @return 构造器,加载驱动*/
		public JDBCConnection() {
			// TODO 加载数据库驱动
			try {
				Class.forName(dbDriver).newInstance();
			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		/**
		 * 创建数据库连接
		 * @return conn
		 */
		public void createConnection(){
			try {
				conn = (Connection)DriverManager.getConnection(url,user,pwd);
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.getMessage();
			}
			
		}

		/**
		 * 对数据库进行查询操作
		 * @return rs:数据集
		 * @param sql:sql脚本*/
		public ResultSet executeQuery(String sql){
		    ResultSet rs = null;
		    Statement stmt = null;
		    if (conn==null){
				createConnection();
			}
			try {
				stmt = (Statement) conn.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
			
		}
		
		/**
		 * 对数据库进行插入操作
		 * @param sql:sql脚本*/
		public void insert2Database(String sql){
			
			PreparedStatement pStmt = null;
			if (conn==null) {
				createConnection();
			}
			try {
				pStmt = conn.prepareStatement(sql);
				pStmt.executeUpdate();
				pStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 对数据库进行更新操作*/
		public void updateDatabase(String sql){
			Connection con = null;
			PreparedStatement pStmt = null;
			if (conn==null){
				createConnection();
			}
			try {
				pStmt = con.prepareStatement(sql);
				pStmt.executeUpdate();
				pStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 对数据库进行删除操作*/
		public void deleteDatabase(String sql){
			Connection con = null;
			PreparedStatement pStmt = null;
			if (conn==null){
				createConnection();
			}
			try {
				pStmt = con.prepareStatement(sql);
				pStmt.executeUpdate();
				pStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/**
		 * 关闭数据库，conn关闭*/
		public void closeConnection(){
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					conn = null;
				}
			}
		}
	}