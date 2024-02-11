package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import model.User;

public class UserDAO {
	/**
	 * Usersテーブルのデータをすべて取得するメソッド
	 * @return ユーザデータ
	 */
	public List<User> get() {
		List<User> list = new ArrayList<>();
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM users";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			// データをリストに格納
			while(rs.next()) {
				User user = rs2model(rs);
				list.add(user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * テーブルの中から、主キーが id であるレコードを返すメソッド
	 * @param id 主キーの値
	 * @return 発見したデータ。なければnull
	 */
	public User find(int id) {
		User user = null;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			// データをリストに格納
			while(rs.next()) {
				 user = rs2model(rs);
			
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	

	/**
	 * テーブルの中から、指定されたメールアドレスを持つレコードを返すメソッド
	 * @param email メールアドレス
	 * @return 発見したデータ。なければnull
	 */
	public User findByEmail(String email) {
		User user = null;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			if (rs.next()) {
				user = rs2model(rs);
				System.out.println(user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  user;
	}
	
	/**
	 * DBにデータを追加する
	 * @return 成功時は追加したデータ、失敗時はnull
	 */
	public User create(String email, String password) {
		int ret = -1;
		
		// 重複確認
		if (findByEmail(email) != null) {
			System.out.println("該当ユーザは既に存在しています");
			return null;
		}
		
		// DBにデータを追加
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// パスワードをハッシュ化↓
			String hashed = BCrypt.hashpw(password, BCrypt.gensalt());//一つ目の引数は変更前のパスワード、二つ目はBCrypt.gensalt()左固定。
			
			// プレースホルダで変数部分を定義↓
			String sql = "INSERT INTO users (email, password) VALUES (?, ?)";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, hashed);
			
			ret = stmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if (ret >= 0) {
			return findByEmail(email);
		}
		return null;
	}
	
	/**
	 * ResultSetの行データをモデルの形に変換するメソッド
	 * @param rs 変換前のデータ
	 * @return 変換後のデータ
	 */
	private User rs2model(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		String password = rs.getString("password");
		LocalDateTime createdAt = rs.getTimestamp("ADDED_DATE").toLocalDateTime();
		LocalDateTime updatedAt = rs.getTimestamp("UPDATE_DATE").toLocalDateTime();

		return new User(id,name, email, password, createdAt, updatedAt);
	}
}
