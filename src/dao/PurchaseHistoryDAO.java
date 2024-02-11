package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Itemcolor;
import model.Itemsize;
import model.Ph;
import model.User;

public class PurchaseHistoryDAO {
	public List<Ph> get() {
		List<Ph> list = new ArrayList<>();

		DBManager manager = DBManager.getInstance();
		try (Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM purchase_history";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Ph purchaseHistory = rs2model(rs);
				list.add(purchaseHistory);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Ph find(int id) {
		Ph purchaseHistory = null;
		DBManager manager = DBManager.getInstance();
		try (Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM purchase_history WHERE id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			// データをリストに格納
			if (rs.next()) {
				purchaseHistory = rs2model(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseHistory;
	}

	public List<Ph> findByPh(int user_id) {
		List<Ph> purchaseHistory = new ArrayList<>();
		DBManager manager = DBManager.getInstance();
		try (Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM purchase_history WHERE user_id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Ph ph = rs2model(rs);
				purchaseHistory.add(ph);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseHistory;
	}

	private Ph rs2model(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		//License license = (License)rs.getInt("License_id");
		int userId = rs.getInt("User_id");
		UserDAO dao = new UserDAO();
		User user = dao.find(userId);
		System.out.println(user);
		
		
		LocalDateTime purchase_date = rs.getTimestamp("purchase_date").toLocalDateTime();
		
		
		int itemId = rs.getInt("Item_id");
		ItemDAO daodao = new ItemDAO();
		Item itemlist = daodao.find(itemId);
		System.out.println(itemlist);
		String itemName = itemlist.getProductName(); // Itemオブジェクトから商品名を取得
		System.out.println(itemName);
		
		
		int sizeId = rs.getInt("Size_id");
		ItemSizeDAO daodaodao = new ItemSizeDAO();
		Itemsize size = daodaodao.find(sizeId);
		System.out.println(size);
		
		
		int colorId = rs.getInt("Color_id");
		ItemColorDAO daodaodaodao = new ItemColorDAO();
		Itemcolor color = daodaodaodao.find(colorId);
		System.out.println(color);
		
		
		return new Ph(id, purchase_date, user, itemlist, size, color);

	}

	public boolean create(int itemlist, int user, int size, int color) {
		int ret = -1;

		// ①データの存在確認

		UserDAO userDAO = new UserDAO();
		if (userDAO.find(user) == null) {
			System.out.println("購入履歴追加失敗。ユーザが見つかりませんでした");
			return false;
		}

		ItemDAO itemDao = new ItemDAO();
		if (itemDao.find(itemlist) == null) {
			System.out.println("購入履歴追加失敗。商品が見つかりませんでした");
			return false;
		}

		ItemSizeDAO sizeDAO = new ItemSizeDAO();
		if (sizeDAO.find(size) == null) {
			System.out.println("購入履歴追加失敗。sizeが見つかりませんでした");
			return false;
		}

		ItemColorDAO colorDAO = new ItemColorDAO();
		if (colorDAO.find(color) == null) {
			System.out.println("購入履歴追加失敗。colorが見つかりませんでした");
			return false;
		}
		// ②DBにデータを追加
		DBManager manager = DBManager.getInstance();
		try (Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "INSERT INTO purchase_history (USER_ID, ITEM_ID,　SIZE_ID, COLOR_ID) VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, user);
			stmt.setInt(2, itemlist);
			stmt.setInt(3, size);
			stmt.setInt(4, color);

			ret = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret >= 0;
	}

}
