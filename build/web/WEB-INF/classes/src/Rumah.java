import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Rumah{
	private int IDRumah;
	private String Tipe;
	private String NoRumah;
	private int LT;
	public int LTAwal;
	private int LB;
	private int HargaAwal;
	private int HargaNett;
	private boolean isBought; // Kalau sudah di beli, jadi harganya di lock tergantung isBought ini
	private boolean isEdited; // Kalau sudah di edit sebelumnya, dia pengen ditandain kaya warna font berubah
	private boolean isLocked; // Kalau dikunci sama owner, cuma owner yang bisa buka lagi
	public int kodepembayaran;
		

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	   static final String USER = "root";
	   static final String PASS = "";
	   public static Connection conn = null;
	   public static Statement statement = null;
	
	// Konstruktor
	public Rumah(int IDRumah){
		this.IDRumah = IDRumah;	
	}
		
	public Rumah(String Tipe, String NoRumah){
		this.Tipe = Tipe;
		this.NoRumah = NoRumah;
	}
	
	public Rumah(String noRumah){
		this.NoRumah = noRumah;
	}
	
//	public Rumah(String id){
//		try{
//			Class.forName(JDBC_DRIVER);
//			conn = DriverManager.getConnection(DB_URL,USER, PASS);
//			statement = conn.createStatement();
//		}catch(SQLException se){
//			se.printStackTrace();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	//tambahan
	public static String convertHarga(int harga){ // jadi tar kalo 50000 jadi 50.000 dst...
		//	harga = 444;
			int ribuan[] = new int[10];
			int counter=0;
			String temphasil="";
			
			while(harga/1000!=0){
				ribuan[counter] = harga%1000;
				counter++;
				//temphasil = temphasil + ribuan+".";
				
				harga = harga /1000; // dicari lagi sisanya
			}
			//dimasukin ke string
			temphasil = harga + ".";
			
			for (int i=counter-1;i>=0;i--){
				//udah sisa ratusan
				if(i!=0){
					if (ribuan[i]==0){//sisa harga 0
						temphasil = temphasil + "000"+".";
					}else if (ribuan[i]<10){ // sisa harga satuan
						temphasil = temphasil + "00"+ribuan[i]+".";
					}else if (ribuan[i]<100){ //sisa harga puluhan
						temphasil = temphasil +"0"+ ribuan[i]+".";
					}else{//sisa harga ratusan
						temphasil = temphasil + ribuan[i]+".";
					}
				}else{
					if (ribuan[i]==0){//sisa harga 0
						temphasil = temphasil + "000";
					}else if (ribuan[i]<10){ // sisa harga satuan
						temphasil = temphasil + "00"+ribuan[i];
					}else if (ribuan[i]<100){ //sisa harga puluhan
						temphasil = temphasil +"0"+ ribuan[i];
					}else{//sisa harga ratusan
						temphasil = temphasil + ribuan[i];
					}
				}
				
			}
			
			
			
			
			return temphasil;
		}
	//---end tambahan
	
	
	// Setter
	
	public void setIDRumah(int IDRumah){
		this.IDRumah = IDRumah;
	}
	
	public void setTipe(String rumahTipe){
		this.Tipe = rumahTipe;
	}
	
	public void setNoRumah(String rumahNoRumah){
		this.NoRumah = rumahNoRumah;
	}
	
	public void setLT(int rumahLT){
		this.LT = rumahLT;
	}
	
	public void setLB(int rumahLB){
		this.LB = rumahLB;
	}

	public void setHargaAwal(int hrgAwal){
		this.HargaAwal = hrgAwal;
	}

	public void setHargaNett(int hrgNett){
		this.HargaNett = hrgNett;
	}
	
	public void setIsBought(boolean bought){
		this.isBought = bought;
	}
	
	public void setIsEdited(boolean edited){
		this.isEdited = edited;
	}
	
	public void setIsLocked(boolean locked){
		this.isLocked = locked;
	}
	
	// Getter

	public int getIDRumah(){
		return this.IDRumah;
	}

	
	public String getTipe(){
		return this.Tipe;
	}
	
	public String getNoRumah(){
		return this.NoRumah;
	}
	
	public int getLT(){
		return this.LT;
	}
	
	public String getStrLT(){
		String strLT = "" + getLT();
		return strLT;
	}

	
	public int getLB(){
		return this.LB;
	}
	
	public String getStrLB(){
		String strLB = "" + getLB();
		return strLB;
	}


	public int getHargaAwal(){
		return this.HargaAwal;
	}

	public String getStrHA(){
		String strHA = "Rp " + convertHarga(HargaAwal);;
		return strHA;
	}

	
	public int getHargaNett(){
		return this.HargaNett;
	}
	
	public String getStrHN(){
		String strHN = "Rp " + convertHarga(HargaNett);
		return strHN;
	}

	public String getStrID(){
		String strID = Integer.toString(IDRumah);
		return strID;
	}
	
	public boolean getIsBought(){
		return this.isBought;
	}
	
	public String getStrIsBought(boolean isBought){
		String strBought;
		if (isBought == false){
			strBought = "Belum Terbeli";
		}
		else{
			strBought = "Terbeli";
		}
		return strBought;

	}
	
	public boolean getIsEdited(){
		return this.isEdited;
	}
	
	public boolean getIsLocked(){
		return this.isLocked;
	}
		
}