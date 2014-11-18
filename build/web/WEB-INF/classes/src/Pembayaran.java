public class Pembayaran{

	public String Pembayaran;
	public int Jumlah;
	public String Tanggal;
	public String Bank;
	public String AtasNama;
	public String NoRekening;
	public int cek;
	
	// Konstruktor
	public Pembayaran(){
	}
	
	public Pembayaran(String Pembayaran, int Jumlah, String Tanggal, String Bank, String AtasNama, String NoRekening, int _cek){
		this.Pembayaran = Pembayaran;
		this.Jumlah = Jumlah;
		this.Tanggal = Tanggal;
		this.Bank = Bank;
		this.AtasNama = AtasNama;
		this.NoRekening = NoRekening;
		this.cek = _cek;
	}
		
	public String convertHarga(int harga){ // jadi tar kalo 50000 jadi 50.000 dst...
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

	
	public void setStrJumlah(String Jumlah){
		this.Jumlah = Integer.parseInt(Jumlah);
	}
	
	public String getStrJumlah(){
		String Jumlah = "Rp. " +convertHarga(this.Jumlah);
		return Jumlah;
	}
	
	public void print() {
		System.out.println("Nama Pembayaran:  " +this.Pembayaran);
		System.out.println("Jumlah yang dibayarkan : " +this.Jumlah);
		System.out.println("Tanggal pembayaran :  " +this.Tanggal);
		System.out.println("Bank :  " + this.Bank);
		System.out.println("Pembayaran Atasnama :  " + this.AtasNama);
		System.out.println("No Rekening :  " + this.NoRekening);
	}
}