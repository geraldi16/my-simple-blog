public class Harga{

	public int IDRumah;
	public int TipePembayaran;
	public int Diskon1;
	public int Diskon2;
	public String KeteranganDiskon2;
	public String TanggalBooking;
	public int	TotalDiskon; // HargaNett disambungin sama HargaNett di rumah
	public String NamaMarketing; // Kalau sudah di edit sebelumnya, dia pengen ditandain kaya warna font berubah
	
	// Konstruktor
	
	public Harga(){
		
	}
	
	public Harga(int IDRumah){
		this.IDRumah = IDRumah;	
	}
			
	public void setStrDiskon1(String Diskon1){
		this.Diskon1 = Integer.parseInt(Diskon1);
	}
	
	public void setStrDiskon2(String Diskon2){
		this.Diskon2 = Integer.parseInt(Diskon2);
	}
	
	public String getStrDiskon1(){
		String Diskon1 = "" + this.Diskon1;
		return Diskon1;
	}
	
	public String getStrDiskon2(){
		String Diskon2 = "" + this.Diskon2;
		return Diskon2;
	}

	public String getStrTotal(){
		String strHN = "" + this.TotalDiskon;
		return strHN;
	}
		
}