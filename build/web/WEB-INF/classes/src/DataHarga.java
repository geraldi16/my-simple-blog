import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;







import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class DataHarga extends JFrame {

	private JRadioButton radioCash;
	private JRadioButton radioSoftcash;
	private JRadioButton radioKPR;
	private JPanel contentPane;
	private JTextField textField_Kavling;
	private JTextField textField_noRumah;
	private JTextField textField_LB;
	private JTextField textField_LT;
	private JTextField textField_HN;
	private JTextField textField_Status;
	private JTextField textField_Diskon1;
	private JTextField textField_Diskon2;
	private JTextField textField_Tgl;
	private JTextField textField_Total;
	private JTextField textField_NamaMarketing;
	private JTextArea textArea_Keterangan;
	private JButton btnSave;
	private JButton btnDelete;
	private String sql;
	private ResultSet rs;
	private Rumah rumah;
	private Harga harga;
	private boolean isKosong;
	private int hargaKelebihan;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;
	public static Harga hargaSimpan = new Harga();
	public static String marketing;
	Date dNow = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
	


	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataHarga frame = new DataHarga();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setEditable(){
		if (MainRumah.rumahSimpan.getIsLocked()){
			btnSave.setVisible(false);
			btnSave.setEnabled(false);
			btnDelete.setVisible(false);
			btnDelete.setEnabled(false);
		}
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

	/**
	 * Create the frame.
	 */
	public DataHarga() {
		
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		rumah = MainRumah.rumahSimpan;
		harga = new Harga(rumah.getIDRumah());

		setTitle("Data Harga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 179, 158);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Kavling");
		label.setBounds(10, 11, 46, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("No Rumah");
		label_1.setBounds(10, 33, 55, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("LB");
		label_2.setBounds(10, 80, 55, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("LT");
		label_3.setBounds(10, 58, 46, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Harga");
		label_4.setBounds(10, 105, 55, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Status");
		label_5.setBounds(10, 130, 55, 14);
		panel.add(label_5);
		
		textField_Kavling = new JTextField();
		textField_Kavling.setColumns(10);
		textField_Kavling.setBounds(71, 8, 98, 20);
		panel.add(textField_Kavling);textField_Kavling.setEditable(false);
		
		textField_noRumah = new JTextField();
		textField_noRumah.setColumns(10);
		textField_noRumah.setBounds(71, 30, 98, 20);
		panel.add(textField_noRumah);textField_noRumah.setEditable(false);
		
		textField_LB = new JTextField();
		textField_LB.setColumns(10);
		textField_LB.setBounds(71, 77, 98, 20);
		panel.add(textField_LB);textField_LB.setEditable(false);
		
		textField_LT = new JTextField();
		textField_LT.setColumns(10);
		textField_LT.setBounds(71, 55, 98, 20);
		panel.add(textField_LT);textField_LT.setEditable(false);
		
		textField_HN = new JTextField();
		textField_HN.setColumns(10);
		textField_HN.setBounds(71, 105, 98, 20);
		panel.add(textField_HN);textField_HN.setEditable(false);
		
		textField_Status = new JTextField();
		textField_Status.setColumns(10);
		textField_Status.setBounds(71, 127, 98, 20);
		panel.add(textField_Status);textField_Status.setEditable(false);
		
		textField_Kavling.setText(rumah.getTipe());
		textField_noRumah.setText(rumah.getNoRumah());
		textField_LT.setText(rumah.getStrLT());
		textField_LB.setText(rumah.getStrLB());
		textField_HN.setText(rumah.getStrHN());
		if (rumah.getIsBought() == false){
			textField_Status.setText("Belum Terbeli");
		}
		else{
			textField_Status.setText("Terbeli");
		}
		
		JLabel lblJenisPembayaran = new JLabel("Jenis Pembayaran");
		lblJenisPembayaran.setBounds(221, 14, 139, 14);
		contentPane.add(lblJenisPembayaran);
		
		JLabel lblDisc = new JLabel("Disc 1");
		lblDisc.setBounds(221, 42, 127, 14);
		contentPane.add(lblDisc);
		
		textField_Diskon1 = new JTextField();
		textField_Diskon1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if ((textField_Diskon1.getText() != "0" ) && (textField_Diskon2.getText() != "0")){
					String str = textField_Diskon1.getText().toString();
					String tmp = "";
					for(String tmp2: str.split("[.]")){
					// System.out.println(tmp2);
						tmp += tmp2;
					}
					//System.out.println(tmp);
					str = textField_Diskon2.getText().toString();
					String tmp3 = "";
					for(String tmp2: str.split("[.]")){
						// System.out.println(tmp2);
							tmp3 += tmp2;
						}
					//System.out.println(tmp3);
					
					harga.setStrDiskon1(tmp);
					harga.setStrDiskon2(tmp3);
					harga.TotalDiskon = harga.Diskon1 + harga.Diskon2;
					textField_Total.setText("Rp "+convertHarga(Integer.parseInt(harga.getStrTotal())));
				}
			}
		});
		textField_Diskon1.setText("0");
		textField_Diskon1.setColumns(10);
		textField_Diskon1.setBounds(370, 42, 244, 20);
		contentPane.add(textField_Diskon1);
		
		JLabel lblDisc_1 = new JLabel("Disc 2");
		lblDisc_1.setBounds(221, 70, 127, 14);
		contentPane.add(lblDisc_1);
		
		textField_Diskon2 = new JTextField();
		textField_Diskon2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if ((textField_Diskon1.getText() != "0" ) && (textField_Diskon2.getText() != "0")){
					String str = textField_Diskon1.getText().toString();
					String tmp = "";
					for(String tmp2: str.split("[.]")){
					// System.out.println(tmp2);
						tmp += tmp2;
					}
					//System.out.println(tmp);
					str = textField_Diskon2.getText().toString();
					String tmp3 = "";
					for(String tmp2: str.split("[.]")){
						// System.out.println(tmp2);
							tmp3 += tmp2;
						}
					//System.out.println(tmp3);
					
					harga.setStrDiskon1(tmp);
					harga.setStrDiskon2(tmp3);
					harga.TotalDiskon = harga.Diskon1 + harga.Diskon2;
					textField_Total.setText("Rp "+convertHarga(Integer.parseInt(harga.getStrTotal())));
				}
			}
		});
		textField_Diskon2.setText("0");
		textField_Diskon2.setColumns(10);
		textField_Diskon2.setBounds(370, 70, 244, 20);
		contentPane.add(textField_Diskon2);
		
		JLabel lblKeteranganDisc = new JLabel("Keterangan Disc 2");
		lblKeteranganDisc.setBounds(221, 98, 127, 14);
		contentPane.add(lblKeteranganDisc);
		
		JButton btnKembali = new JButton("Kembali ke menu rumah");
		btnKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MainRumah frameMain = new MainRumah();
				frameMain.setVisible(true);
			}
		});
		btnKembali.setBounds(199, 297, 187, 23);
		contentPane.add(btnKembali);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//delete pembeli, terus update rumah jadi belum terbeli lagi
				String sql1= "DELETE FROM `tabel_harga` WHERE `idRumah`="+MainRumah.rumahSimpan.getIDRumah();
				
				try{
					Object[] option = {"Hapus","Tunda"};
					int op = JOptionPane.showOptionDialog(null, "Data akan dihapus. Teruskan? ","Konfirmasi Jawaban",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,option,option[0]);
					
					if(op==0){
						statement.executeUpdate(sql1);
						String sql2 = "UPDATE `tabel_rumah` SET `idx_pembayaran`=0 WHERE `idRumah`= "+MainRumah.rumahSimpan.getIDRumah()+";";
						statement.executeUpdate(sql2);
						JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
						
						if(MainRumah.rumahSimpan.kodepembayaran==1){
							sql1= "DELETE FROM `tabel_cash` WHERE `idRumah`="+MainRumah.rumahSimpan.getIDRumah();
							statement.executeUpdate(sql1);
						}else if(MainRumah.rumahSimpan.kodepembayaran==2){
							sql1= "DELETE FROM `tabel_softcash` WHERE `idRumah`="+MainRumah.rumahSimpan.getIDRumah();
							statement.executeUpdate(sql1);
						}else if(MainRumah.rumahSimpan.kodepembayaran==3){
							sql1= "DELETE FROM `tabel_kpr` WHERE `idRumah`="+MainRumah.rumahSimpan.getIDRumah();
							statement.executeUpdate(sql1);
						}
						//update ke history edit
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"+MainRumah.pembeli.Nama+"','"+ft.format(dNow)+"','Rp xxx.','"+MainRumah.rumahSimpan.getTipe()+"','"+MainRumah.rumahSimpan.getNoRumah()+"','"+MainRumah.marketing+"','data harga dihapus')";
						statement.executeUpdate(sql);
						
						setVisible(false);
						MainRumah frameMain = new MainRumah();
						frameMain.setVisible(true);
					}
					
				}catch(SQLException se){
					se.printStackTrace();
					JOptionPane.showMessageDialog(null, "Data gagal dihapus");
					
				}
			}
		});
		btnDelete.setBounds(47, 297, 144, 23);
		contentPane.add(btnDelete);
		
		JLabel lblTanggalBooking = new JLabel("Tanggal Booking");
		lblTanggalBooking.setBounds(221, 196, 127, 14);
		contentPane.add(lblTanggalBooking);
		
		JLabel lblHargaNett = new JLabel("Total Diskon");
		lblHargaNett.setBounds(221, 224, 127, 14);
		contentPane.add(lblHargaNett);
		
		textField_Tgl = new JTextField();
		textField_Tgl.setColumns(10);
		textField_Tgl.setBounds(370, 196, 244, 20);
		contentPane.add(textField_Tgl);
		
		textField_Total = new JTextField();
		textField_Total.setEditable(false);
		textField_Total.setColumns(10);
		textField_Total.setBounds(370, 224, 244, 20);
		contentPane.add(textField_Total);
		
		radioCash = new JRadioButton("Cash");
		radioCash.setBounds(370, 12, 56, 23);
		contentPane.add(radioCash);
		
		radioSoftcash = new JRadioButton("Soft-cash");
		radioSoftcash.setBounds(451, 11, 96, 23);
		contentPane.add(radioSoftcash);
		
		radioKPR = new JRadioButton("KPR");
		radioKPR.setBounds(558, 11, 56, 23);
		contentPane.add(radioKPR);
				
		//harus di grup!!
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioCash);
		bg.add(radioSoftcash);
		bg.add(radioKPR);
		
		JLabel lblNamaMarketing = new JLabel("Nama Marketing");
		lblNamaMarketing.setBounds(221, 252, 127, 14);
		contentPane.add(lblNamaMarketing);
		
		textField_NamaMarketing = new JTextField();
		textField_NamaMarketing.setColumns(10);
		textField_NamaMarketing.setBounds(370, 252, 244, 20);
		contentPane.add(textField_NamaMarketing);
		
		textArea_Keterangan = new JTextArea();
		textArea_Keterangan.setLineWrap(true);
		textArea_Keterangan.setBounds(370, 96, 244, 89);
		contentPane.add(textArea_Keterangan);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField_Diskon1.getText().toString();
				String tmp = "";
				for(String tmp2: str.split("[.]")){
				// System.out.println(tmp2);
					tmp += tmp2;
				}
				//System.out.println(tmp);
				str = textField_Diskon2.getText().toString();
				String tmp3 = "";
				for(String tmp2: str.split("[.]")){
					// System.out.println(tmp2);
						tmp3 += tmp2;
					}
				//System.out.println(tmp3);
				
				harga.setStrDiskon1(tmp);
				harga.setStrDiskon2(tmp3);
				harga.TotalDiskon = harga.Diskon1 + harga.Diskon2;
				//textField_Total.setText("Rp "+convertHarga(Integer.parseInt(harga.getStrTotal())));
	
				harga.KeteranganDiskon2 = textArea_Keterangan.getText();
				harga.TanggalBooking = textField_Tgl.getText();
				harga.NamaMarketing = textField_NamaMarketing.getText();
					
				if (isKosong){
					sql = "INSERT INTO `tabel_harga`(`idRumah`, `tipe_pembayaran`, `diskon1`, `diskon2`, `keterangan`, `tgl_book`, `total_diskon`, `nama_marketing`) " +
							"VALUES ("+rumah.getIDRumah()+","+getTipePembayaran()+","+harga.Diskon1+","+harga.Diskon2+",'"+harga.KeteranganDiskon2+"','"+harga.TanggalBooking+"',"+harga.TotalDiskon+",'"+harga.NamaMarketing+"')";
					try {
						statement.executeUpdate(sql);
						marketing = harga.NamaMarketing;
						JOptionPane.showMessageDialog(null, "Pengisian data harga berhasil!!");
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
				}
				
				else {
				sql = "UPDATE `tabel_harga` " +
						"SET `tipe_pembayaran`="+getTipePembayaran()+",`diskon1`="+harga.Diskon1+",`diskon2`="+harga.Diskon2+"," +
						"`keterangan`='"+harga.KeteranganDiskon2+"',`tgl_book`='"+harga.TanggalBooking+"',`total_diskon`="+harga.TotalDiskon+",`nama_marketing`='"+harga.NamaMarketing+"' " +
						"WHERE `idRumah` = "+harga.IDRumah+"";
				try {
					statement.executeUpdate(sql);
					marketing = harga.NamaMarketing;
					JOptionPane.showMessageDialog(null, "Update data harga berhasil!!");
					//MainRumah.rumahSimpan.kodepembayaran = getTipePembayaran();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				sql = "SELECT `HargaKelebihan` FROM `tabel_kelebihantanah` WHERE `idRumah` = "+rumah.getIDRumah()+";";
				try {
					rs = statement.executeQuery(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (!rs.isBeforeFirst()){
						int hargaNett = rumah.getHargaAwal() - harga.TotalDiskon;
						rumah.setHargaNett(hargaNett);
						
						sql = "UPDATE tabel_rumah " +
								"SET HargaNett = "+rumah.getHargaNett()+" " +
								"WHERE idRumah = "+harga.IDRumah+";";
						try {
							int hasilUpdate = statement.executeUpdate(sql);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					else {
						while(rs.next()){
							hargaKelebihan = rs.getInt("HargaKelebihan");
						}
						int hargaNett = rumah.getHargaAwal() - harga.TotalDiskon + hargaKelebihan;
						rumah.setHargaNett(hargaNett);
						
						sql = "UPDATE tabel_rumah " +
								"SET HargaNett = "+rumah.getHargaNett()+" " +
								"WHERE idRumah = "+harga.IDRumah+";";
						try {
							int hasilUpdate = statement.executeUpdate(sql);
							System.out.println("Update harga : " +hasilUpdate);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				sql = "UPDATE `tabel_rumah` SET `idx_pembayaran`= "+getTipePembayaran()+" WHERE `idRumah`= "+MainRumah.rumahSimpan.getIDRumah();
				try {
					statement.executeUpdate(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				hargaSimpan = harga;
				setVisible(false);
				MainRumah frameMain = new MainRumah();
				frameMain.setVisible(true);


			}
		});
		btnSave.setBounds(390, 297, 139, 23);
		contentPane.add(btnSave);
	
		
		sql = "SELECT * FROM `tabel_harga` WHERE idRumah="+harga.IDRumah+";";
		try {
			rs = statement.executeQuery(sql);
			if (!rs.isBeforeFirst()){
				System.out.println("Tabel Kosong");
				isKosong = true;
			}
			else{
				isKosong = false;
				while(rs.next()){
					harga.TipePembayaran = rs.getInt("tipe_pembayaran");
					harga.Diskon1 = rs.getInt("diskon1");
					harga.Diskon2 = rs.getInt("diskon2");
					harga.KeteranganDiskon2 = rs.getString("keterangan");
					harga.TanggalBooking = rs.getString("tgl_book");
					harga.TotalDiskon = rs.getInt("total_diskon");
					harga.NamaMarketing = rs.getString("nama_marketing");
					
					this.setTipePembayaran(harga.TipePembayaran);
					textField_Diskon1.setText(Rumah.convertHarga(Integer.parseInt(harga.getStrDiskon1())));
					textField_Diskon2.setText(Rumah.convertHarga(Integer.parseInt(harga.getStrDiskon2())));
					textArea_Keterangan.setText(harga.KeteranganDiskon2);
					textField_Tgl.setText(harga.TanggalBooking);
					textField_Total.setText("Rp "+convertHarga(Integer.parseInt(harga.getStrTotal())));
					textField_NamaMarketing.setText(harga.NamaMarketing);
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setEditable();

	}
	
	public int getTipePembayaran(){
		int tipePembayaran;
		if (radioCash.isSelected()){
			tipePembayaran = 1;
		}
		else if (radioSoftcash.isSelected()){
			tipePembayaran = 2;
		}
		else if (radioKPR.isSelected()){
			tipePembayaran = 3;
		}
		else{
			tipePembayaran = 0;
		}
		return tipePembayaran;
	}
	
	public void setTipePembayaran(int tipe){
		if (tipe == 1){
			radioCash.setSelected(true);
		}
		else if (tipe == 2){
			radioSoftcash.setSelected(true);
		}
		else if (tipe == 3){
			radioKPR.setSelected(true);
		}
	}

}
