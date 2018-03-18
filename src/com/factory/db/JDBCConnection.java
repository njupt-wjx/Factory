//:com/factoty/db/JDBCConnection.java mysql���ݿ����
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
		 * @return ������,��������*/
		public JDBCConnection() {
			// TODO �������ݿ�����
			try {
				Class.forName(dbDriver).newInstance();
			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		/**
		 * �������ݿ�����
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
		 * �����ݿ���в�ѯ����
		 * @return rs:���ݼ�
		 * @param sql:sql�ű�*/
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
		 * �����ݿ���в������
		 * @param sql:sql�ű�*/
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
		 * �����ݿ���и��²���*/
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
		 * �����ݿ����ɾ������*/
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
		 * �ر����ݿ⣬conn�ر�*/
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