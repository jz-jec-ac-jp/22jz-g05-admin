package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Itemsize;

public class ItemSizeDAO {
	public List<Itemsize> get() {
		List<Itemsize> list = new ArrayList<>();
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM item_size";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Itemsize itemsize = rs2model(rs);
				list.add(itemsize);}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	 public Itemsize find(int id) {
		 Itemsize itemsize = null;
	    			DBManager manager = DBManager.getInstance();
			try(Connection cn = manager.getConnection()) {
				// プレースホルダで変数部分を定義
				String sql = "SELECT * FROM item_size WHERE id = ?";
				PreparedStatement stmt = cn.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				// データをリストに格納
				if (rs.next()) {
					itemsize = rs2model(rs);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return  itemsize;
	    }
	 
	 public List<Itemsize> getItemSizeByItemId(int itemId) {
	        List<Itemsize> list = new ArrayList<>();
	        
	        DBManager manager = DBManager.getInstance();
	        try(Connection cn = manager.getConnection()) {
	        String sql = "SELECT * FROM item_size WHERE item_id = ?";
	        PreparedStatement stmt = cn.prepareStatement(sql);
	        stmt.setInt(1, itemId);
	        ResultSet rs = stmt.executeQuery();
	        
	            // データをリストに格納
	            while(rs.next()) {
	            	Itemsize itemsize = rs2model(rs);
	                list.add(itemsize);
	            }
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	      
	        return list;
	    }
	 
	 private Itemsize rs2model(ResultSet rs) throws SQLException {
	        int id = rs.getInt("id");
	        String itemSize = rs.getString("item_size");
	        int itemID = rs.getInt("item_id");
	        LocalDateTime addDate =
	                 rs.getTimestamp("added_date").toLocalDateTime();                       
	        LocalDateTime upDate = 
	                 rs.getTimestamp("update_date").toLocalDateTime();                        

	        return new Itemsize(id, itemSize, addDate, upDate, itemID);
	    }
}
