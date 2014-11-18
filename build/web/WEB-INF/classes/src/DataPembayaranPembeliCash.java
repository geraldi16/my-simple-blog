import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Robot;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JCheckBox;


public class DataPembayaranPembeliCash extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField No1;
	private JTextField Pembayaran1;
	private JTextField Jumlah1;
	private JTextField Bank1;
	private JTextField AN1;
	private JTextField NoRek1;
	private JTextField NoRek2;
	private JTextField AN2;
	private JTextField Bank2;
	private JTextField Jumlah2;
	private JTextField Pembayaran2;
	private JTextField No2;
	private JTextField No3;
	private JTextField Pembayaran3;
	private JTextField Jumlah3;
	private JTextField Bank3;
	private JTextField AN3;
	private JTextField NoRek3;
	private JTextField No4;
	private JTextField Pembayaran4;
	private JTextField Jumlah4;
	private JTextField Bank4;
	private JTextField AN4;
	private JTextField NoRek4;
	private JTextField No5;
	private JTextField Pembayaran5;
	private JTextField Jumlah5;
	private JTextField Bank5;
	private JTextField AN5;
	private JTextField NoRek5;
	private JTextField Tanggal1;
	private JTextField Tanggal2;
	private JTextField Tanggal3;
	private JTextField Tanggal4;
	private JTextField Tanggal5;
	private JButton btnKembaliKeMenu;
	private JButton btnSave;
	private JButton btnDelete;
	private String sql;
	private ResultSet rs;
	private boolean isKosong;
	
	private int TotalJumlah;
	private boolean StatusTotal;

	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;
	
	//tambahan variabel
	public Pembayaran[] bayar;
	
	int nomor[] = new int[5];
	private final JCheckBox NewCheckBox = new JCheckBox("");
	private final JCheckBox checkBox ;
	private final JCheckBox checkBox_1 ;
	private final JCheckBox checkBox_2 ;
	private final JCheckBox checkBox_3 ;
	private final JLabel lblCheck;
	private JTextField textField_Total;
	private JTextField textField_StatusTotal;

	Date dNow = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataPembayaranPembeliCash frame = new DataPembayaranPembeliCash();
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
	
	
	//tambahan
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
		
		public void CbVisibility(){
			if(App.status==0){
				NewCheckBox.setVisible(false);
				checkBox.setVisible(false);
				checkBox_1.setVisible(false);
				checkBox_2.setVisible(false);
				checkBox_3.setVisible(false);
				lblCheck.setVisible(false);				
			}
		}

		
	/**
	 * Create the frame.
	 */
	public DataPembayaranPembeliCash() {
		
		
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}

		setTitle("Pembayaran Cash");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1220, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(516, 11, 179, 158);
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
		
		textField = new JTextField(MainRumah.rumahSimpan.getTipe());
		textField.setColumns(10);
		textField.setBounds(71, 8, 98, 20);
		panel.add(textField);
		textField.setEditable(false);
		
		textField_1 = new JTextField(MainRumah.rumahSimpan.getNoRumah());
		textField_1.setColumns(10);
		textField_1.setBounds(71, 30, 98, 20);
		panel.add(textField_1);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField(MainRumah.rumahSimpan.getStrLB());
		textField_2.setColumns(10);
		textField_2.setBounds(71, 77, 98, 20);
		panel.add(textField_2);textField_2.setEditable(false);
		
		textField_3 = new JTextField(MainRumah.rumahSimpan.getStrLT());
		textField_3.setColumns(10);
		textField_3.setBounds(71, 55, 98, 20);
		panel.add(textField_3);textField_3.setEditable(false);
		
		textField_4 = new JTextField(MainRumah.rumahSimpan.getStrHN());
		textField_4.setColumns(10);
		textField_4.setBounds(71, 105, 98, 20);
		panel.add(textField_4);textField_4.setEditable(false);
		
		textField_5 = new JTextField();
		if (MainRumah.rumahSimpan.getIsBought() == false){
			textField_5.setText("Belum Terbeli");
		}
		else{
			textField_5.setText("Terbeli");
		}
		textField_5.setColumns(10);
		textField_5.setBounds(71, 127, 98, 20);
		panel.add(textField_5);textField_5.setEditable(false);
		
		JLabel lblPembayaran = new JLabel("Pembayaran");
		lblPembayaran.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPembayaran.setBounds(53, 183, 84, 26);
		contentPane.add(lblPembayaran);
		
		JLabel lblNo = new JLabel("No");
		lblNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNo.setBounds(20, 183, 23, 26);
		contentPane.add(lblNo);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJumlah.setBounds(236, 183, 58, 26);
		contentPane.add(lblJumlah);
		
		JLabel lblBank = new JLabel("Bank");
		lblBank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBank.setBounds(496, 183, 40, 26);
		contentPane.add(lblBank);
		
		JLabel lblAtasNama = new JLabel("Atas Nama");
		lblAtasNama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtasNama.setBounds(643, 183, 84, 26);
		contentPane.add(lblAtasNama);
		
		JLabel lblNoRekening = new JLabel("No Rekening");
		lblNoRekening.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNoRekening.setBounds(927, 183, 92, 26);
		contentPane.add(lblNoRekening);
		
		No1 = new JTextField();
		No1.setText("1");
		No1.setBounds(20, 220, 23, 20);
		contentPane.add(No1);
		No1.setColumns(10);
		
		Pembayaran1 = new JTextField();
		Pembayaran1.setBounds(53, 220, 173, 20);
		contentPane.add(Pembayaran1);
		Pembayaran1.setColumns(10);
		
		Jumlah1 = new JTextField();
		Jumlah1.setBounds(236, 220, 139, 20);
		contentPane.add(Jumlah1);
		Jumlah1.setColumns(10);
		
		Bank1 = new JTextField();
		Bank1.setBounds(496, 220, 137, 20);
		contentPane.add(Bank1);
		Bank1.setColumns(10);
		
		AN1 = new JTextField();
		AN1.setBounds(643, 220, 274, 20);
		contentPane.add(AN1);
		AN1.setColumns(10);
		
		NoRek1 = new JTextField();
		NoRek1.setBounds(927, 220, 217, 20);
		contentPane.add(NoRek1);
		NoRek1.setColumns(10);
		
		NoRek2 = new JTextField();
		NoRek2.setColumns(10);
		NoRek2.setBounds(927, 251, 217, 20);
		contentPane.add(NoRek2);
		
		AN2 = new JTextField();
		AN2.setColumns(10);
		AN2.setBounds(643, 251, 274, 20);
		contentPane.add(AN2);
		
		Bank2 = new JTextField();
		Bank2.setColumns(10);
		Bank2.setBounds(496, 251, 137, 20);
		contentPane.add(Bank2);
		
		Jumlah2 = new JTextField();
		Jumlah2.setColumns(10);
		Jumlah2.setBounds(236, 251, 139, 20);
		contentPane.add(Jumlah2);
		
		Pembayaran2 = new JTextField();
		Pembayaran2.setColumns(10);
		Pembayaran2.setBounds(53, 251, 173, 20);
		contentPane.add(Pembayaran2);
		
		No2 = new JTextField();
		No2.setText("2");
		No2.setColumns(10);
		No2.setBounds(20, 251, 23, 20);
		contentPane.add(No2);
		
		No3 = new JTextField();
		No3.setText("3");
		No3.setColumns(10);
		No3.setBounds(20, 282, 23, 20);
		contentPane.add(No3);
		
		Pembayaran3 = new JTextField();
		Pembayaran3.setColumns(10);
		Pembayaran3.setBounds(53, 282, 173, 20);
		contentPane.add(Pembayaran3);
		
		Jumlah3 = new JTextField();
		Jumlah3.setColumns(10);
		Jumlah3.setBounds(236, 282, 139, 20);
		contentPane.add(Jumlah3);
		
		Bank3 = new JTextField();
		Bank3.setColumns(10);
		Bank3.setBounds(496, 282, 137, 20);
		contentPane.add(Bank3);
		
		AN3 = new JTextField();
		AN3.setColumns(10);
		AN3.setBounds(643, 282, 274, 20);
		contentPane.add(AN3);
		
		NoRek3 = new JTextField();
		NoRek3.setColumns(10);
		NoRek3.setBounds(927, 282, 217, 20);
		contentPane.add(NoRek3);
		
		No4 = new JTextField();
		No4.setText("4");
		No4.setColumns(10);
		No4.setBounds(20, 313, 23, 20);
		contentPane.add(No4);
		
		Pembayaran4 = new JTextField();
		Pembayaran4.setColumns(10);
		Pembayaran4.setBounds(53, 313, 173, 20);
		contentPane.add(Pembayaran4);
		
		Jumlah4 = new JTextField();
		Jumlah4.setColumns(10);
		Jumlah4.setBounds(236, 313, 139, 20);
		contentPane.add(Jumlah4);
		
		Bank4 = new JTextField();
		Bank4.setColumns(10);
		Bank4.setBounds(496, 313, 137, 20);
		contentPane.add(Bank4);
		
		AN4 = new JTextField();
		AN4.setColumns(10);
		AN4.setBounds(643, 313, 274, 20);
		contentPane.add(AN4);
		
		NoRek4 = new JTextField();
		NoRek4.setColumns(10);
		NoRek4.setBounds(927, 313, 217, 20);
		contentPane.add(NoRek4);
		
		No5 = new JTextField();
		No5.setText("5");
		No5.setColumns(10);
		No5.setBounds(20, 344, 23, 20);
		contentPane.add(No5);
		
		Pembayaran5 = new JTextField();
		Pembayaran5.setColumns(10);
		Pembayaran5.setBounds(53, 344, 173, 20);
		contentPane.add(Pembayaran5);
		
		Jumlah5 = new JTextField();
		Jumlah5.setColumns(10);
		Jumlah5.setBounds(236, 344, 139, 20);
		contentPane.add(Jumlah5);
		
		Bank5 = new JTextField();
		Bank5.setColumns(10);
		Bank5.setBounds(496, 344, 137, 20);
		contentPane.add(Bank5);
		
		AN5 = new JTextField();
		AN5.setColumns(10);
		AN5.setBounds(643, 344, 274, 20);
		contentPane.add(AN5);
		
		NoRek5 = new JTextField();
		NoRek5.setColumns(10);
		NoRek5.setBounds(927, 344, 217, 20);
		contentPane.add(NoRek5);
		
		JLabel Tanggal = new JLabel("Tanggal");
		Tanggal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Tanggal.setBounds(385, 180, 58, 26);
		contentPane.add(Tanggal);
		
		Tanggal1 = new JTextField();
		Tanggal1.setColumns(10);
		Tanggal1.setBounds(385, 220, 101, 20);
		contentPane.add(Tanggal1);
		
		Tanggal2 = new JTextField();
		Tanggal2.setColumns(10);
		Tanggal2.setBounds(385, 251, 101, 20);
		contentPane.add(Tanggal2);
		
		Tanggal3 = new JTextField();
		Tanggal3.setColumns(10);
		Tanggal3.setBounds(385, 282, 101, 20);
		contentPane.add(Tanggal3);
		
		Tanggal4 = new JTextField();
		Tanggal4.setColumns(10);
		Tanggal4.setBounds(385, 313, 101, 20);
		contentPane.add(Tanggal4);
		
		Tanggal5 = new JTextField();
		Tanggal5.setColumns(10);
		Tanggal5.setBounds(385, 344, 101, 20);
		contentPane.add(Tanggal5);
		
		btnKembaliKeMenu = new JButton("Kembali ke Menu Rumah");
		btnKembaliKeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MainRumah frameMain = new MainRumah();
				frameMain.setVisible(true);
			}
		});
		btnKembaliKeMenu.setBounds(476, 388, 214, 23);
		contentPane.add(btnKembaliKeMenu);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveValue(); //pindahin nilai textfield ke array lagi
				String sql;
				boolean ok=true;
				
				if(isKosong){//insert baru
					for(int i=0;i<5;i++){
						try{
							sql = "INSERT INTO `tabel_cash`(`idRumah`, `nomor`, `pembayaran`, `Jumlah`, `tanggal`, `bank`, `atas_nama`, `no_rek`, `isChecked`) VALUES ("+MainRumah.rumahSimpan.getIDRumah()+","+(i+1)+",'"+bayar[i].Pembayaran+"',"+bayar[i].Jumlah+",'"+bayar[i].Tanggal+"','"+bayar[i].Bank+"','"+bayar[i].AtasNama+"','"+bayar[i].NoRekening+"', "+bayar[i].cek+")";
							statement.executeUpdate(sql);
							
//							JOptionPane.showMessageDialog(null, "update tabel berhasi1!!");
							
						}catch(SQLException se){
							se.printStackTrace();
							ok = false;
							break;
						}
					}
					try{
						//update ke history edit
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"+MainRumah.pembeli.Nama+"','"+ft.format(dNow)+"','"+Jumlah1.getText().toString()+"','"+MainRumah.rumahSimpan.getTipe()+"','"+MainRumah.rumahSimpan.getNoRumah()+"','"+MainRumah.marketing+"','data pembayaran Cash baru')";
						statement.executeUpdate(sql);
//						JOptionPane.showMessageDialog(null, "update tabel berhasi1!!");
						
					}catch(SQLException se){
						se.printStackTrace();
						ok = false;
						
					}
				}else{
					for(int i=0;i<5;i++){
						try{
							sql = "UPDATE `tabel_cash` SET `Jumlah` = "+bayar[i].Jumlah+",`tanggal`='"+bayar[i].Tanggal+"',`bank`= '"+bayar[i].Bank+"',`atas_nama`= '"+bayar[i].AtasNama+"',`no_rek`= '"+bayar[i].NoRekening+"',`isChecked`= "+bayar[i].cek+" WHERE `pembayaran`= '"+bayar[i].Pembayaran+"'";
							statement.executeUpdate(sql);
							
//							JOptionPane.showMessageDialog(null, "update tabel berhasi1!!");
							
						}catch(SQLException se){
							se.printStackTrace();
							ok = false;
							break;
						}
					}
					try{
						//update ke history edit
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"+MainRumah.pembeli.Nama+"','"+ft.format(dNow)+"','"+Jumlah1.getText().toString()+"','"+MainRumah.rumahSimpan.getTipe()+"','"+MainRumah.rumahSimpan.getNoRumah()+"','"+MainRumah.marketing+"','update data pembayaran Cash')";
						statement.executeUpdate(sql);
//						JOptionPane.showMessageDialog(null, "update tabel berhasi1!!");
						
					}catch(SQLException se){
						se.printStackTrace();
						ok = false;
						
					}
				}
				
				
				
				if(ok){
					JOptionPane.showMessageDialog(null, "Update berhasil!");
					setVisible(false);
					MainRumah frameMain = new MainRumah();
					frameMain.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Update gagal!");
				}
				
			}
		});
		btnSave.setBounds(700, 388, 139, 23);
		contentPane.add(btnSave);
		
		lblCheck = new JLabel("check");
		lblCheck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheck.setBounds(1154, 183, 40, 26);
		contentPane.add(lblCheck);
		NewCheckBox.setBounds(1150, 209, 21, 31);
		contentPane.add(NewCheckBox);
		
		 checkBox = new JCheckBox("");
		checkBox.setBounds(1150, 240, 23, 31);
		contentPane.add(checkBox);
		
		 checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(1150, 274, 23, 31);
		contentPane.add(checkBox_1);
		
		 checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(1150, 302, 23, 31);
		contentPane.add(checkBox_2);
		
		 checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(1150, 336, 23, 31);
		contentPane.add(checkBox_3);
		
		btnDelete = new JButton("Delete");
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Object[] option = {"Hapus","Tunda"};
					int op = JOptionPane.showOptionDialog(null, "Data akan dihapus. Teruskan? ","Konfirmasi Jawaban",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,option,option[0]);
					
					if(op==0){
						String sql1;
						sql1= "DELETE FROM `tabel_cash` WHERE `idRumah`="+MainRumah.rumahSimpan.getIDRumah();
						statement.executeUpdate(sql1);
						
						//update ke history edit
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"+MainRumah.pembeli.Nama+"','"+ft.format(dNow)+"','"+Jumlah1.getText().toString()+"','"+MainRumah.rumahSimpan.getTipe()+"','"+MainRumah.rumahSimpan.getNoRumah()+"','"+MainRumah.marketing+"','data Cash dihapus')";
						statement.executeUpdate(sql);
					
					JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
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
		
		btnDelete.setBounds(328, 388, 139, 23);
		contentPane.add(btnDelete);
		
		JLabel lblTotalJumlah = new JLabel("Total Jumlah Pembayaran :");
		lblTotalJumlah.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalJumlah.setBounds(53, 70, 173, 26);
		contentPane.add(lblTotalJumlah);
		
		textField_Total = new JTextField();
		textField_Total.setBounds(236, 74, 195, 20);
		contentPane.add(textField_Total);
		textField_Total.setColumns(10);
		
		JLabel lblStatusTotalPembayaran = new JLabel("Status Total Pembayaran :");
		lblStatusTotalPembayaran.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStatusTotalPembayaran.setBounds(53, 107, 173, 26);
		contentPane.add(lblStatusTotalPembayaran);
		
		textField_StatusTotal = new JTextField();
		textField_StatusTotal.setColumns(10);
		textField_StatusTotal.setBounds(236, 111, 195, 20);
		contentPane.add(textField_StatusTotal);
		
		JButton btnNewButton = new JButton("Save Picture");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Robot robot;
				try {
					robot = new Robot();
					BufferedImage image = robot.createScreenCapture(new Rectangle(1350, 580));
					ImageIO.write(image, "PNG", new FileOutputStream("D:/KotaBali/Pembayaran Pembeli/"+MainRumah.rumahSimpan.getTipe()+"-"+MainRumah.rumahSimpan.getStrID()+"_"+ft.format(dNow)+".png"));
					JOptionPane.showMessageDialog(null, "Gambar berhasil disimpan!!");
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(1055, 388, 139, 23);
		contentPane.add(btnNewButton);

		CbVisibility();
		
		bayar = new Pembayaran[5];
		//check = new int[5];
		try{
			
			sql = "SELECT * FROM `tabel_cash` WHERE `idRumah`="+MainRumah.rumahSimpan.getIDRumah();
			rs = statement.executeQuery(sql);
			if (!rs.isBeforeFirst()){
				System.out.println("Tabel Kosong");
				isKosong = true;
				
				TotalJumlah = 0;
				textField_Total.setText("Rp "+this.convertHarga(TotalJumlah));
				setStatusTotal();
				bayar[0] = new Pembayaran("Booking",-999,"aaa","aaa","aaa","aaa",0);
				bayar[1] = new Pembayaran("DP",-999,"aaa","aaa","aaa","aaa",0);
				bayar[2] = new Pembayaran("Transfer 1",-999,"aaa","aaa","aaa","aaa",0);
				bayar[3] = new Pembayaran("Transfer 2",-999,"aaa","aaa","aaa","aaa",0);
				bayar[4] = new Pembayaran("Transfer 3",-999,"aaa","aaa","aaa","aaa",0);
				
				
			}else {
				isKosong = false;
				int i=0;
				
				TotalJumlah = 0;
				String jpem;
				int jml;
				String bank;
				String tgl;
				String atasnama;
				String norek;
				int cek;
				while(rs.next()){
					nomor[i] = rs.getInt("nomor");
					jpem = rs.getString("pembayaran");
					jml = rs.getInt("Jumlah");
					tgl = rs.getString("tanggal");
					bank = rs.getString("bank");
					atasnama = rs.getString("atas_nama");
					norek = rs.getString("no_rek");
					cek = rs.getInt("isChecked");
					
					//taruh di kelas
					bayar[i] = new Pembayaran(jpem,jml,tgl,bank,atasnama,norek,cek);
					i++;	
				}
			}
				int j = 1;
				while (j<=1){
					switch (j){
					case 1 :
						if(bayar[0].Jumlah!=-999){
							TotalJumlah = TotalJumlah + bayar[0].Jumlah;
							Jumlah1.setText("Rp "+this.convertHarga(bayar[0].Jumlah));
						}else{
							Jumlah1.setText("Rp ");
						}
						if(!bayar[0].Tanggal.equals("aaa")){
							Tanggal1.setText(bayar[0].Tanggal);
						}
						if(!bayar[0].Bank.equals("aaa")){
							Bank1.setText(bayar[0].Bank);
						}
						if(!bayar[0].AtasNama.equals("aaa")){
							AN1.setText(bayar[0].AtasNama);
						}
						if(!bayar[0].NoRekening.equals("aaa")){
							NoRek1.setText(bayar[0].NoRekening);
						}
						if(bayar[0].cek==1){
							NewCheckBox.setSelected(true);
						}
						Pembayaran1.setText(bayar[0].Pembayaran);
						
						//break;
					case 2 :
						Pembayaran2.setText(bayar[1].Pembayaran);
						if(bayar[1].Jumlah!=-999){
							TotalJumlah = TotalJumlah + bayar[1].Jumlah;
							Jumlah2.setText("Rp "+this.convertHarga(bayar[1].Jumlah));
						}else{
							Jumlah2.setText("Rp ");
						}
						if(!bayar[1].Tanggal.equals("aaa")){
							Tanggal2.setText(bayar[1].Tanggal);
						}
						if(!bayar[1].Bank.equals("aaa")){
							Bank2.setText(bayar[1].Bank);
						}
						if(!bayar[1].AtasNama.equals("aaa")){
							AN2.setText(bayar[1].AtasNama);
						}
						if(!bayar[1].NoRekening.equals("aaa")){
							NoRek2.setText(bayar[1].NoRekening);
						}
						if(bayar[1].cek==1){
							checkBox.setSelected(true);
						}
					//	break;
					case 3 :
						Pembayaran3.setText(bayar[2].Pembayaran);
						if(bayar[2].Jumlah!=-999){
							TotalJumlah = TotalJumlah + bayar[2].Jumlah;
							Jumlah3.setText("Rp "+this.convertHarga(bayar[2].Jumlah));
						}else{
							Jumlah3.setText("Rp ");
						}
						if(!bayar[2].Tanggal.equals("aaa")){
							Tanggal3.setText(bayar[2].Tanggal);
						}
						if(!bayar[2].Bank.equals("aaa")){
							Bank3.setText(bayar[2].Bank);
						}
						if(!bayar[2].AtasNama.equals("aaa")){
							AN3.setText(bayar[2].AtasNama);
						}
						if(!bayar[2].NoRekening.equals("aaa")){
							NoRek3.setText(bayar[2].NoRekening);
						}
						if(bayar[2].cek==1){
							checkBox_1.setSelected(true);
						}
					//	break;
					case 4 :
						Pembayaran4.setText(bayar[3].Pembayaran);
						if(bayar[3].Jumlah!=-999){
							TotalJumlah = TotalJumlah + bayar[3].Jumlah;
							Jumlah4.setText("Rp "+this.convertHarga(bayar[3].Jumlah));
						}else{
							Jumlah4.setText("Rp ");
						}
						if(!bayar[3].Tanggal.equals("aaa")){
							Tanggal4.setText(bayar[3].Tanggal);
						}
						if(!bayar[3].Bank.equals("aaa")){
							Bank4.setText(bayar[3].Bank);
						}
						if(!bayar[3].AtasNama.equals("aaa")){
							AN4.setText(bayar[3].AtasNama);
						}
						if(!bayar[3].NoRekening.equals("aaa")){
							NoRek4.setText(bayar[3].NoRekening);
						}
						if(bayar[3].cek==1){
							checkBox_2.setSelected(true);
						}
					//	break;
					case 5 :
						Pembayaran5.setText(bayar[4].Pembayaran);
						if(bayar[4].Jumlah!=-999){
							TotalJumlah = TotalJumlah + bayar[4].Jumlah;
							Jumlah5.setText("Rp "+this.convertHarga(bayar[4].Jumlah));
						}else{
							Jumlah5.setText("Rp ");
						}
						if(!bayar[4].Tanggal.equals("aaa")){
							Tanggal5.setText(bayar[4].Tanggal);
						}
						if(!bayar[4].Bank.equals("aaa")){
							Bank5.setText(bayar[4].Bank);
						}
						if(!bayar[4].AtasNama.equals("aaa")){
							AN5.setText(bayar[4].AtasNama);
						}
						if(!bayar[4].NoRekening.equals("aaa")){
							NoRek5.setText(bayar[4].NoRekening);
						}
						if(bayar[4].cek==1){
							checkBox_3.setSelected(true);
						}
					//	break;
					default:{}
					}
					j++;
				}
				
				textField_Total.setText("Rp "+this.convertHarga(TotalJumlah));
				setStatusTotal();
				
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		setEditable();
	}
	
	//*******TAMBAHAN PROSEDUR ***********\\
	public void checkStatusTotal(){
		if(TotalJumlah != MainRumah.rumahSimpan.getHargaNett()){
			this.StatusTotal = false;
		}
		else if(TotalJumlah == MainRumah.rumahSimpan.getHargaNett()){
			this.StatusTotal = true;
		}
	}
	
	public void setStatusTotal(){
		this.checkStatusTotal();
		if(StatusTotal){
			textField_StatusTotal.setText("Total harga sudah sesuai");
		}else{
			textField_StatusTotal.setText("Total harga belum sesuai");
		}

	}
	
	public void moveValue(){
		if(!Jumlah1.getText().equals("")&&!Jumlah1.getText().equals("Rp ")){
			String str = Jumlah1.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[0].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[0].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[0].Jumlah=-999;
		}
		if(!Tanggal1.getText().equals("")){
			bayar[0].Tanggal= Tanggal1.getText().toString();
		}else{
			bayar[0].Tanggal = "aaa";
		}
		if(!Bank1.getText().equals("")){
			bayar[0].Bank= Bank1.getText().toString();
		}else{
			bayar[0].Bank = "aaa";
		}
		if(!AN1.getText().equals("")){
			bayar[0].AtasNama= AN1.getText().toString();
		}else{
			bayar[0].AtasNama = "aaa";
		}
		if(!NoRek1.getText().equals("")){
			bayar[0].NoRekening= NoRek1.getText().toString();
		}else{
			bayar[0].NoRekening = "aaa";
		}
		if(NewCheckBox.isSelected()){
			bayar[0].cek = 1;
		}else{
			bayar[0].cek = 0;
		}
		
		if(!Jumlah2.getText().equals("")&&!Jumlah2.getText().equals("Rp ")){
			String str = Jumlah2.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[1].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[1].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[1].Jumlah = -999;
		}
		if(!Tanggal2.getText().equals("")){
			bayar[1].Tanggal= Tanggal2.getText().toString();
		}else{
			bayar[1].Tanggal = "aaa";
		}
		if(!Bank1.getText().equals("")){
			bayar[1].Bank= Bank2.getText().toString();
		}else{
			bayar[1].Bank = "aaa";
		}
		if(!AN2.getText().equals("")){
			bayar[1].AtasNama= AN2.getText().toString();
		}else{
			bayar[1].AtasNama = "aaa";
		}
		if(!NoRek2.getText().equals("")){
			bayar[1].NoRekening= NoRek2.getText().toString();
		}else{
			bayar[1].NoRekening = "aaa";
		}
		if(checkBox.isSelected()){
			bayar[1].cek = 1;
		}else{
			bayar[1].cek = 0;
		}
		
		if(!Jumlah3.getText().equals("")&&!Jumlah3.getText().equals("Rp ")){
			String str = Jumlah3.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[2].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[2].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[2].Jumlah = -999;
		}
		if(!Tanggal3.getText().equals("")){
			bayar[2].Tanggal= Tanggal3.getText().toString();
		}else{
			bayar[2].Tanggal = "aaa";
		}
		if(!Bank3.getText().equals("")){
			bayar[2].Bank= Bank3.getText().toString();
		}else{
			bayar[2].Bank = "aaa";
		}
		if(!AN3.getText().equals("")){
			bayar[2].AtasNama= AN3.getText().toString();
		}else{
			bayar[2].AtasNama = "aaa";
		}
		if(!NoRek3.getText().equals("")){
			bayar[2].NoRekening= NoRek3.getText().toString();
		}else{
			bayar[2].NoRekening = "aaa";
		}
		if(checkBox_1.isSelected()){
			bayar[2].cek = 1;
		}else{
			bayar[2].cek = 0;
		}
		
		if(!Jumlah4.getText().equals("")&&!Jumlah4.getText().equals("Rp ")){
			String str = Jumlah4.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[3].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[3].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[3].Jumlah = -999;
		}
		if(!Tanggal4.getText().equals("")){
			bayar[3].Tanggal= Tanggal4.getText().toString();
		}else{
			bayar[3].Tanggal = "aaa";
		}
		if(!Bank4.getText().equals("")){
			bayar[3].Bank= Bank4.getText().toString();
		}else{
			bayar[3].Bank = "aaa";
		}
		if(!AN4.getText().equals("")){
			bayar[3].AtasNama= AN4.getText().toString();
		}else{
			bayar[3].AtasNama = "aaa";
		}
		if(!NoRek4.getText().equals("")){
			bayar[3].NoRekening= NoRek4.getText().toString();
		}else{
			bayar[3].NoRekening = "aaa";
		}
		if(checkBox_2.isSelected()){
			bayar[3].cek = 1;
		}else{
			bayar[3].cek = 0;
		}
		
		if(!Jumlah5.getText().equals("")&&!Jumlah5.getText().equals("Rp ")){
			String str = Jumlah5.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[4].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[4].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[4].Jumlah = -999;
		}
		if(!Tanggal5.getText().equals("")){
			bayar[4].Tanggal= Tanggal5.getText().toString();
		}else{
			bayar[4].Tanggal = "aaa";
		}
		if(!Bank5.getText().equals("")){
			bayar[4].Bank= Bank5.getText().toString();
		}else{
			bayar[4].Bank = "aaa";
		}
		if(!AN5.getText().equals("")){
			bayar[4].AtasNama= AN5.getText().toString();
		}else{
			bayar[4].AtasNama = "aaa";
		}
		if(!NoRek5.getText().equals("")){
			bayar[4].NoRekening= NoRek5.getText().toString();
		}else{
			bayar[4].NoRekening = "aaa";
		}
		if(checkBox_3.isSelected()){
			bayar[4].cek = 1;
		}else{
			bayar[4].cek = 0;
		}
		
	}
}
