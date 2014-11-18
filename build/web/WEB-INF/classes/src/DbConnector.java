import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.prefs.PreferenceChangeEvent;

import javax.swing.JOptionPane;


public class DbConnector {

	private String sql;
	private ResultSet rs;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;


	public DbConnector(){
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void changeType(String tipeRumah, int noRumah) throws SQLException{
		Integer hrgKamboja1 = null;
		Integer hrgKamboja2 = null;
		Integer isSuccess = 0;
		sql = "SELECT * FROM `tabel_hargakavling` WHERE kavling = 'Kamboja 1';";
		rs = statement.executeQuery(sql);
		while(rs.next()){
			hrgKamboja1 = rs.getInt("harga_lama");
		}
		sql = "SELECT * FROM `tabel_hargakavling` WHERE kavling = 'Kamboja 2';";
		rs = statement.executeQuery(sql);
		while(rs.next()){
			hrgKamboja2 = rs.getInt("harga_lama");
		}
		if (tipeRumah.equals("Kamboja 1")){
			sql = "UPDATE `tabel_rumah` SET `TipeRumah` = 'Kamboja 2',`LT`= "+Constant.KAMBOJA1_LT_AWAL+",`LTAwal`= "+Constant.KAMBOJA2_LT_AWAL+","
					+ "`LB`= "+Constant.KAMBOJA2_LB+",`HargaAwal`= "+hrgKamboja2+",`HargaNett`= "+hrgKamboja2+" WHERE `idRumah`= "+noRumah+"";
			isSuccess = statement.executeUpdate(sql);
			MainRumah.rumahSimpan.setLT(Constant.KAMBOJA1_LT_AWAL);
			MainRumah.rumahSimpan.setLB(Constant.KAMBOJA2_LB);
			MainRumah.rumahSimpan.setHargaNett(hrgKamboja2);
			
		}
		else if (tipeRumah.equals("Kamboja 2")){
			sql = "UPDATE `tabel_rumah` SET `TipeRumah` = 'Kamboja 1',`LT`= "+Constant.KAMBOJA1_LT_AWAL+",`LTAwal`= "+Constant.KAMBOJA1_LT_AWAL+","
					+ "`LB`= "+Constant.KAMBOJA1_LB+",`HargaAwal`= "+hrgKamboja1+",`HargaNett`= "+hrgKamboja1+" WHERE `idRumah`= "+noRumah+"";
			isSuccess = statement.executeUpdate(sql);
			MainRumah.rumahSimpan.setLT(Constant.KAMBOJA1_LT_AWAL);
			MainRumah.rumahSimpan.setLB(Constant.KAMBOJA1_LB);
			MainRumah.rumahSimpan.setHargaNett(hrgKamboja1);
		}
		showMessageSuccess(isSuccess);
	}
	public void showMessageSuccess(Integer isSuccess){
		if (isSuccess == 1){
			JOptionPane.showMessageDialog(null, "Tipe rumah berhasil diubah!");
		}
		else{
			JOptionPane.showMessageDialog(null, "Gagal mengubah tipe rumah!");
		}
	}
}
