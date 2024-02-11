package logic;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import dao.UserDAO;
import model.User;

/**
 * ログイン・ログアウト処理を行うクラス
 * @author d.sugawara
 *
 */
public class AuthLogic {
    public User login(String email, String password) {
        UserDAO dao = new UserDAO();
        User user = dao.findByEmail(email);
        System.out.println(user);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }

        return null;
    }
	
	/**
	 * ログアウト処理を行う
	 * @return なし
	 */
	public void logout(HttpSession session) {
		if (isLoggedIn(session)) {
			session.removeAttribute("loginUser");
		}
	}
	
	/**
	 * ログイン状態を確認する
	 * @param session
	 * @return ログインしていれば true、していなければ false
	 */
	public boolean isLoggedIn(HttpSession session) {
		return session.getAttribute("loginUser") != null;
	}
}
