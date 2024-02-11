package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Itemcolor;

public class ItemColorDAO {
	public List<Itemcolor> get() {
		List<Itemcolor> list = new ArrayList<>();
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM item_color";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Itemcolor itemcolor = rs2model(rs);
				list.add(itemcolor);}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	 public Itemcolor find(int id) {
		 Itemcolor itemcolor = null;
	    			DBManager manager = DBManager.getInstance();
			try(Connection cn = manager.getConnection()) {
				// プレースホルダで変数部分を定義
				String sql = "SELECT * FROM item_color WHERE id = ?";
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				// データをリストに格納
				if (rs.next()) {
					itemcolor = rs2model(rs);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return  itemcolor;
	    }
	 
	 public List<Itemcolor> getItemColorByItemId(int itemId) {
	        List<Itemcolor> list = new ArrayList<>();
	        
	        DBManager manager = DBManager.getInstance();
	        try(Connection cn = manager.getConnection()) {
	        String sql = "SELECT * FROM item_color WHERE item_id = ?";
	        PreparedStatement stmt = cn.prepareStatement(sql);
	        stmt.setInt(1, itemId);
	        ResultSet rs = stmt.executeQuery();
	        
	            // データをリストに格納
	            while(rs.next()) {
	            	Itemcolor itemcolor = rs2model(rs);
	                list.add(itemcolor);
	            }
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	      
	        return list;
	    }
	 
	 private Itemcolor rs2model(ResultSet rs) throws SQLException {
	        int id = rs.getInt("id");
	        String itemColor = rs.getString("item_color");
	        int itemID = rs.getInt("item_id");
	        LocalDateTime addDate =
	                 rs.getTimestamp("added_date").toLocalDateTime();                       
	        LocalDateTime upDate = 
	                 rs.getTimestamp("update_date").toLocalDateTime();                        

	        return new Itemcolor(id, itemColor, upDate, addDate, itemID);
	    }
}	
