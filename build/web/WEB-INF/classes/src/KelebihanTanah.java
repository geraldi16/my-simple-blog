public class KelebihanTanah{

	public int IDRumah;
	public int KelebihanTanah;
	public int HargaM;
	public int HargaKelebihan;
	public int HargaTotal;
	
	// Konstruktor
	public KelebihanTanah(){
		
	}
	
	public KelebihanTanah(int IDRumah){
		this.IDRumah = IDRumah;	
	}
		
	public void setStrKT(String KT){
		this.KelebihanTanah = Integer.parseInt(KT);
	}
	
	public void setStrHargaM(String HM){
		this.HargaM = Integer.parseInt(HM);
	}
	
	public String getStrKT(){
		String KT = "" + this.KelebihanTanah;
		return KT;
	}
	
	public String getStrHargaM(){
		String HargaM = "" + this.HargaM;
		return HargaM;
	}

	public String getStrHK(){
		String HK = "" + this.HargaKelebihan;
		return HK;
	}
		
	public String getStrHT(){
		String HT = "" + this.HargaTotal;
		return HT;
	}

}