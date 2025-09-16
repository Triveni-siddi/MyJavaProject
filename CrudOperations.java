package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudOperations {

	public static boolean insert() {
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into books(title,author) values(?,?)");
			ps.setString(1, "Mathamatics Solving");// in the place of 1st question mark set string to Don Quixote
			ps.setString(2, "Triveni");// in the place of second question mark set string to Miguel de
												// Cervantes
			int n = ps.executeUpdate();
			if (n > 0) {
				b = true;
				System.out.println(n + " row(s) Inserted");
			} else {
				System.out.println("Something went wrong !! ");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;

	}

	public static void select() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from books");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getBoolean(4));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean update() {
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library", "root", "root");
			PreparedStatement ps = con.prepareStatement("update books set title=? where bookId = ?");
			ps.setString(1, "Artificial Intelligence");// in the place of 1st question mark set title to python
			ps.setInt(2, 4);//// in the place of 2nd question mark i.e where id is 1
			int n = ps.executeUpdate();
			if (n > 0) {
				b = true;
				System.out.println(n + " row(s) updated");
			} else {
				System.out.println("Oops !! something went wrong ... ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;

	}

	public static boolean delete() {
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete from books where bookId = ? ");
			ps.setInt(1, 4);
			int n = ps.executeUpdate();
			if (n > 0) {
				b = true;
				System.out.println(n + " row(s) deleted");
			} else {
				System.out.println("Oops!! something went wrong ....");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	public static void main(String[] args) {
		//insert();
		// update();
		// delete();
		select();

	}

}
