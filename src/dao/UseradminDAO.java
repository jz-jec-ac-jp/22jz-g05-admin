package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserAdmin;

public class UseradminDAO {
    // データベースへの接続やクエリの実行はこのクラスで行う

    public List<UserAdmin> getAllUsers() {
        List<UserAdmin> userList = new ArrayList<>();
        DBManager manager = DBManager.getInstance();
        try (Connection cn = manager.getConnection()){
        		String sql = "SELECT * FROM users";
        		PreparedStatement stmt = cn.prepareStatement(sql);
        		System.out.println("getAllUsers");
        		ResultSet rs = stmt.executeQuery();
        		System.out.println("execute");
        		
        		int l = 1;
            while (rs.next()) {
            	UserAdmin ua = rs2model(rs);
                userList.add(ua);
                System.out.println("loop"+ l);
                l++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }

        return userList;
    }
    
    
    
    public UserAdmin rs2model(ResultSet rs) throws SQLException{
    	String username = rs.getString("name");
        String furigana = rs.getString("name_furigana");
        String adress = rs.getString("address");
        int phonnumber = rs.getInt("id");
        String password = rs.getString("password");
        
		
		return new UserAdmin(username, furigana,adress , phonnumber, password);
    }
}
