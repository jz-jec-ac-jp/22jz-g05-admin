package model;
public class UserAdmin {
	String username;
     String furigana;
     String adress;
     int phonnumber;
     String password;
     
     
public String getUsername() {
		return username;
	}

	public String getFurigana() {
		return furigana;
	}

	public String getPassword() {
		return password;
	}
	public String getAdress() {
		return adress;
	}

	public int getPhonnumber() {
		return phonnumber;
	}


    // コンストラクタ、ゲッター、セッターなどを追加

    // 例:
    public UserAdmin(String username, String furigana, String adress, int phonnumber, String password) {
        this.username = username;
        this.furigana = furigana;
        this.adress = adress;
        this.phonnumber = phonnumber;
        this.password = password;

    }

    // ゲッター、セッターなどを追加
}
