package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Item;

/**
 * ビデオ用DAO
 * @author Isobe daishi*/

public class ItemDAO {

	/**
	 * ビデオテーブルのデータをすべて取得するメソッド
	 * @return ビデオデータ
	 */
	public List<Item> get() {
		List<Item> Itemlist = new ArrayList<>();

		DBManager manager = DBManager.getInstance();
		try (Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM merchandise";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			

			// データをリストに格納
			while (rs.next()) {
				Item video = rs2model(rs);
				Itemlist.add(video);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Itemlist;
	}

	/**
	 * ビデオテーブル内から、主キーがidのレコードを返すメソッド
	 * @param id 主キーの値
	 * @return 発見したビデオデータ、見つからなければnull
	 */

	public Item find(int id) {
		Item video = null;
		DBManager manager = DBManager.getInstance();
		try (Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM merchandise WHERE id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			// データをリストに格納
			if (rs.next()) {
				video = rs2model(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return video;
	}
	
	public boolean deleteItem(int id) {
	    DBManager manager = DBManager.getInstance();
	    try (Connection cn = manager.getConnection()) {
	        // プレースホルダで変数部分を定義
	        PreparedStatement stmt = cn.prepareStatement("DELETE FROM merchandise WHERE ID = ?");
	        stmt.setInt(1, id);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        // 例外が発生した場合の処理
	        e.printStackTrace(); // 通常はログに出力する
	        throw new RuntimeException("商品の削除中にエラーが発生しました。", e); // エラーを呼び出し元に通知
	    }
		return false;
	}


	/**
	 * ResultSetの行データをモデルの形に変換するメソッド
	 * @param rs 変換前のデータ
	 * @return 変換後のデータ
	 */
	private Item rs2model(ResultSet rs) throws SQLException {
		int ItemID = rs.getInt("id");
		String ItemName = rs.getString("PRODUCT_NAME");
		int ItemPrice = rs.getInt("Price");
		int ItemStock = rs.getInt("STOCK");
		String ItemDESCRIPTION = rs.getString("DESCRIPTION_OF_ITEM");
		String Itemimage_url = rs.getString("image_url");
		int PRODUCT_TYPE = rs.getInt("PRODUCT_TYPE");
		int new_item = rs.getInt("new_item");
		int FEATURED_PRODUCTS = rs.getInt("FEATURED_PRODUCTS");
		LocalDateTime cdate = rs.getTimestamp("ADDED_DATE").toLocalDateTime();
		LocalDateTime udate = rs.getTimestamp("UPDATE_DATE").toLocalDateTime();
		

		return new Item(ItemID, ItemName, ItemPrice,ItemStock,ItemDESCRIPTION,Itemimage_url,PRODUCT_TYPE,new_item,FEATURED_PRODUCTS, cdate, udate);
	}
	
	public boolean insertItem(String productName, int price,int stock,int FEATURED_PRODUCTS,String description, String image_url,int PRODUCT_TYPE,int new_item) {
//		int pr = price;
//		int st = Integer.parseInt(stock);
//		int ptype = Integer.parseInt(PRODUCT_TYPE);
//		int ni = Integer.parseInt(new_item);
//		int fp = Integer.parseInt(FEATURED_PRODUCTS);
		int ret = -1;
	       DBManager manager = DBManager.getInstance();
	    try (Connection cn = manager.getConnection()) {
	        String sql = "INSERT INTO merchandise (image_url, product_name, description_of_item, price, product_type, stock, new_item, featured_products) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement stmt = cn.prepareStatement(sql);
	        stmt.setString(1, image_url);
	        stmt.setString(2, productName);
	        stmt.setString(3, description);
	        stmt.setInt(4, price);
	        stmt.setInt(5, PRODUCT_TYPE);
	        stmt.setInt(6, stock);
	        stmt.setInt(7, new_item);
	        stmt.setInt(8, FEATURED_PRODUCTS);
//		stmt.setInt(9, new Timestamp(System.currentTimeMillis()));
//		stmt.setInt(10,new Timestamp(System.currentTimeMillis()));
		ret = stmt.executeUpdate();
		if(ret != -1) {
			return true;
		}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}


	
	/**
     * 商品情報を更新するメソッド
     * @param itemId 更新する商品のID
     * @param newItemName 新しい商品名
     * @param newItemPrice 新しい商品価格
     * @return 更新が成功した場合は true、失敗した場合は false
     */
    public void updateItem(String id, String productName, String productCode, String price, String stock,String FEATURED_PRODUCTS, String description, String size, String color, String image_url,String PRODUCT_TYPE, String new_item) {
    	int Id = Integer.parseInt(id);
    	int pr = Integer.parseInt(price);
	    int st = Integer.parseInt(stock);
	    int ptype = Integer.parseInt(PRODUCT_TYPE);
	    int ni = Integer.parseInt(new_item);
	    int fp = Integer.parseInt(FEATURED_PRODUCTS);
    	
    	DBManager manager = DBManager.getInstance();
        try (Connection cn = manager.getConnection()) {
            String sql = "UPDATE merchandise SET PRODUCT_NAME=?, PRICE=?, STOCK=?, FEATURED_PRODUCTS=?, DESCRIPTION_OF_ITEM=?, SIZE=?, COLOR=?, IMAGE_URL=?, PRODUCT_TYPE=?, NEW_ITEM=? WHERE ID=?;";
            try (PreparedStatement stmt = cn.prepareStatement(sql)) {
            	
                stmt.setString(1, productName);
                stmt.setInt(2, pr);
                stmt.setInt(3, st);
                stmt.setInt(4, fp);
                stmt.setString(5, description);
                stmt.setString(6, size);
                stmt.setString(7, color);
                stmt.setString(8, image_url);
                stmt.setInt(9, ptype);
                stmt.setInt(10, ni);
                stmt.setInt(11, Id);
                stmt.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
            }
        }

	public String insertItem(Item item) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

//	public boolean insertItem(String image_url, String productName, String description, int price, int productType,
//			int stock, int new_item, int featuredProducts) {
//		int ret = -1;
//	       DBManager manager = DBManager.getInstance();
//	    try (Connection cn = manager.getConnection()) {
//	        String sql = "INSERT INTO merchandise (image_url, product_name, description_of_item, price, product_type, stock, new_item, featured_products) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//	        PreparedStatement stmt = cn.prepareStatement(sql);
//	        stmt.setString(1, image_url);
//	        stmt.setString(2, productName);
//	        stmt.setString(3, description);
//	        stmt.setInt(4, price);
//	        stmt.setInt(6, stock);
//	        stmt.setInt(7, new_item);
////		stmt.setInt(9, new Timestamp(System.currentTimeMillis()));
////		stmt.setInt(10,new Timestamp(System.currentTimeMillis()));
//		ret = stmt.executeUpdate();
//		if(ret != -1) {
//			return true;
//		}
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//		return false;
//		
//	}
    }

//   
//    public void addNewItem(String productName, String productCode, String price, String stock, String featured, String description, String size, String color, String imageUrl, String productType, String newItem) {
//        // データベースに新しいアイテムを追加する実装
//    	int pr = Integer.parseInt(price);
//		int st = Integer.parseInt(stock);
//		int ptype = Integer.parseInt(productType);
//		int ni = Integer.parseInt(newItem);
//		int fp = Integer.parseInt(featured);
//		
//		DBManager manager = DBManager.getInstance();
//		try(Connection cn = manager.getConnection()) {
//			String sql = "INSERT INTO merchandise (PRODUCT_NAME,PRICE,STOCK,DESCRIPTION_OF_ITEM,image_url,PRODUCT_TYPE,new_item,FEATURED_PRODUCTS) VALUES(?,?,?,?,?,?,?,?)";
//			PreparedStatement stmt = cn.prepareStatement(sql);
//			
//			stmt.setString(1,productName);
////			stmt.setInt(2, pc);
//			stmt.setInt(2, pr);
//			stmt.setInt(3, st);
//			stmt.setString(4, description);
//			//stmt.setString(5, image_url);
//			stmt.setString(5, imageUrl);
//			stmt.setInt(6,ptype);
//			stmt.setInt(7,ni);
//			stmt.setInt(8, fp);
//			System.out.println("succses");
////			int Size = Integer.parseInt(size);
////			int Color = Integer.parseInt(color);
////			int Stock = Integer.parseInt(stock);
////			setsize(Size);
////			setcolor(Color);
//			
//			stmt.executeUpdate();
//			
//			// データをリストに格納
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//    }
//    
//    /**
//     * 商品の在庫数を更新するメソッド
//     * @param id 更新する商品のID
//     * @param newStock 新しい在庫数
//     * @return 更新が成功した場合はtrue、そうでない場合はfalse
//     */
//    public boolean updateStock(int id, int newStock) {
//        DBManager manager = DBManager.getInstance();
//        try (Connection cn = manager.getConnection()) {
//            String sql = "UPDATE merchandise SET STOCK = ?, UPDATE_DATE = ? WHERE ID = ?";
//            try (PreparedStatement stmt = cn.prepareStatement(sql)) {
//                stmt.setInt(1, newStock);
//                stmt.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
//                stmt.setInt(3, id);
//
//                int rowsAffected = stmt.executeUpdate();
//                return rowsAffected > 0;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
////
//
//	public boolean insertItem(Item item) {
//		// TODO 自動生成されたメソッド・スタブ
//		return false;
//	}
//}


//
//public void set(String productName, String productCode, String price,String stock,String FEATURED_PRODUCTS,
//		String description, String size, String color, String image_url,String PRODUCT_TYPE,String new_item) {
//	System.out.println("do");
//	//int pc = Integer.parseInt(productCode);
//	int pr = Integer.parseInt(price);
//	int st = Integer.parseInt(stock);
//	int ptype = Integer.parseInt(PRODUCT_TYPE);
//	int ni = Integer.parseInt(new_item);
//	int fp = Integer.parseInt(FEATURED_PRODUCTS);
//	
//	DBManager manager = DBManager.getInstance();
//	try(Connection cn = manager.getConnection()) {
//		String sql = "INSERT INTO merchandise (PRODUCT_NAME,PRICE,STOCK,DESCRIPTION_OF_ITEM,image_url,PRODUCT_TYPE,new_item,FEATURED_PRODUCTS) VALUES(?,?,?,?,?,?,?,?)";
//		PreparedStatement stmt = cn.prepareStatement(sql);
//		
//		stmt.setString(1,productName);
////		stmt.setInt(2, pc);
//		stmt.setInt(2, pr);
//		stmt.setInt(3, st);
//		stmt.setString(4, description);
//		//stmt.setString(5, image_url);
//		stmt.setString(5, image_url);
//		stmt.setInt(6,ptype);
//		stmt.setInt(7,ni);
//		stmt.setInt(8, fp);
//		System.out.println("succses");
////		int Size = Integer.parseInt(size);
////		int Color = Integer.parseInt(color);
////		int Stock = Integer.parseInt(stock);
////		setsize(Size);
////		setcolor(Color);
//		
//		stmt.executeUpdate();
//		
//		// データをリストに格納
//	} catch(SQLException e) {
//		e.printStackTrace();
//	}
//
//}

//public void update(int id, String productName, String productCode, String price, String stock,
//        String FEATURED_PRODUCTS, String description, String size, String color, String image_url,
//        String PRODUCT_TYPE, String new_item) {
//    int pr = Integer.parseInt(price);
//    int st = Integer.parseInt(stock);
//    int ptype = Integer.parseInt(PRODUCT_TYPE);
//    int ni = Integer.parseInt(new_item);
//    int fp = Integer.parseInt(FEATURED_PRODUCTS);
//
//    DBManager manager = DBManager.getInstance();
//    try (Connection cn = manager.getConnection()) {
//        String sql = "UPDATE merchandise SET PRODUCT_NAME=?, PRICE=?, STOCK=?, DESCRIPTION_OF_ITEM=?, image_url=?, "
//                + "PRODUCT_TYPE=?, new_item=?, FEATURED_PRODUCTS=? WHERE ID=?";
//        PreparedStatement stmt = cn.prepareStatement(sql);
//
//        stmt.setString(1, productName);
//        stmt.setInt(2, pr);
//        stmt.setInt(3, st);
//        stmt.setString(4, description);
//        stmt.setString(5, image_url);
//        stmt.setInt(6, ptype);
//        stmt.setInt(7, ni);
//        stmt.setInt(8, fp);
//        stmt.setInt(9, id); // WHERE句での条件指定
//
//        stmt.executeUpdate();
//        System.out.println("success");
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}