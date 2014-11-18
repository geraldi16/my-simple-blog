import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Pembeli{
	public String Nama;
	public String NoTelepon;
	public String KTP;
	public String Pekerjaan;
	public String Alamat;
	public String TTL;
	public int IDRumah;
	

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;
	
	// Konstruktor
	
	public Pembeli(int idRumah){
		this.IDRumah = idRumah;
	}

	public Pembeli(){
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
			
			String sql ="SELECT * FROM `tabel_pembeli` WHERE `IDRumah`= '"+MainRumah.rumahSimpan.getIDRumah()+"'";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				IDRumah = rs.getInt("idRumah");
				Nama = rs.getString("nama");
				Alamat = rs.getString("alamat");
				TTL = rs.getString("ttl");
				NoTelepon = rs.getString("noTelepon");
				Pekerjaan = rs.getString("Pekerjaan");
				KTP = rs.getString("ktp");
			}
			
		}catch(SQLException se){
			Nama ="";
			
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// Setter
	
	
	public void setNama(String _Nama){
		this.Nama = _Nama;
	}
	
	public String getTTL() {
		return TTL;
	}

	public void setTTL(String tTL) {
		TTL = tTL;
	}

	public void setNoTelepon1(String _NoTelepon1){
		this.NoTelepon = _NoTelepon1;
	}
	
	
	
//	public void setNoTelepon2(String _NoTelepon2){
//		this.NoTelepon2 = _NoTelepon2;
//	}
//
//	
//	public void setKTP(String _KTP){
//		this.KTP = _KTP;
//	}
	
	public String getKTP() {
		return KTP;
	}

	public void setKTP(String kTP) {
		KTP = kTP;
	}

	public void setPekerjaan(String _Pekerjaan){
		this.Pekerjaan = _Pekerjaan;
	}
	
	public void setAlamat(String _Alamat){
		this.Alamat = _Alamat;
	}
	
	// Getter
	
	public String getNama(){
		return this.Nama;
	}
	
	public String getNoTelepon(){
		return this.NoTelepon;
	}

	
	public String getPekerjaan(){
		return this.Pekerjaan;
	}
	
	public String getAlamat(){
		return this.Alamat;
	}
	
}