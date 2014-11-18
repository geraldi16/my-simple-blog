import java.awt.AWTException;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class DataPembayaranPembeliSoftCash extends JFrame {

	private JPanel contentPane;
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
	private JTextField No6;
	private JTextField Pembayaran6;
	private JTextField Jumlah6;
	private JTextField Tanggal6;
	private JTextField Bank6;
	private JTextField AN6;
	private JTextField NoRek6;
	private JTextField No7;
	private JTextField Pembayaran7;
	private JTextField Jumlah7;
	private JTextField Tanggal7;
	private JTextField Bank7;
	private JTextField AN7;
	private JTextField NoRek7;
	private JTextField No8;
	private JTextField Pembayaran8;
	private JTextField Jumlah8;
	private JTextField Tanggal8;
	private JTextField Bank8;
	private JTextField AN8;
	private JTextField NoRek8;
	private JTextField No9;
	private JTextField Pembayaran9;
	private JTextField Jumlah9;
	private JTextField Bank9;
	private JTextField AN9;
	private JTextField NoRek9;
	private JTextField NoRek10;
	private JTextField AN10;
	private JTextField Bank10;
	private JTextField Jumlah10;
	private JTextField Pembayaran10;
	private JTextField No10;
	private JTextField No11;
	private JTextField Pembayaran11;
	private JTextField Jumlah11;
	private JTextField Bank11;
	private JTextField AN11;
	private JTextField NoRek11;
	private JTextField No12;
	private JTextField Pembayaran12;
	private JTextField Jumlah12;
	private JTextField Bank12;
	private JTextField AN12;
	private JTextField NoRek12;
	private JTextField No13;
	private JTextField Pembayaran13;
	private JTextField Jumlah13;
	private JTextField Bank13;
	private JTextField AN13;
	private JTextField NoRek13;
	private JTextField Tanggal9;
	private JTextField Tanggal10;
	private JTextField Tanggal11;
	private JTextField Tanggal12;
	private JTextField Tanggal13;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField Pembayaran14;
	private JTextField Pembayaran15;
	private JTextField Pembayaran16;
	private JTextField Pembayaran17;
	private JTextField Jumlah14;
	private JTextField Jumlah15;
	private JTextField Jumlah16;
	private JTextField Jumlah17;
	private JTextField Tanggal14;
	private JTextField Tanggal15;
	private JTextField Tanggal16;
	private JTextField Tanggal17;
	private JTextField Bank14;
	private JTextField Bank15;
	private JTextField Bank16;
	private JTextField Bank17;
	private JTextField AN14;
	private JTextField AN15;
	private JTextField AN16;
	private JTextField AN17;
	private JTextField NoRek14;
	private JTextField NoRek15;
	private JTextField NoRek16;
	private JTextField NoRek17;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField Pembayaran18;
	private JTextField Pembayaran19;
	private JTextField Pembayaran20;
	private JTextField Pembayaran21;
	private JTextField Jumlah18;
	private JTextField Jumlah19;
	private JTextField Jumlah20;
	private JTextField Jumlah21;
	private JTextField Tanggal18;
	private JTextField Tanggal19;
	private JTextField Tanggal20;
	private JTextField Tanggal21;
	private JTextField Bank18;
	private JTextField Bank19;
	private JTextField Bank20;
	private JTextField Bank21;
	private JTextField AN18;
	private JTextField AN19;
	private JTextField AN20;
	private JTextField AN21;
	private JTextField NoRek18;
	private JTextField NoRek19;
	private JTextField NoRek20;
	private JTextField NoRek21;
	private JTextField textField_28;
	private JTextField Pembayaran22;
	private JTextField Jumlah22;
	private JTextField Tanggal22;
	private JTextField Bank22;
	private JTextField AN22;
	private JTextField NoRek22;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;
	
	//tambahan variabel
	public Pembayaran[] bayar;
	int nomor[] = new int[22];
	public boolean isKosong;
	ResultSet rs;
	String sql;
	Date dNow = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
	
	JCheckBox checkBox;
	JCheckBox checkBox_1;
	JCheckBox checkBox_2;
	JCheckBox checkBox_3;
	JCheckBox checkBox_4;
	JCheckBox checkBox_5;
	JCheckBox checkBox_6;
	JCheckBox checkBox_7;
	JCheckBox checkBox_8;
	JCheckBox checkBox_9;
	JCheckBox checkBox_10;
	JCheckBox checkBox_11;
	JCheckBox checkBox_12;
	JCheckBox checkBox_13;
	JCheckBox checkBox_14;
	JCheckBox checkBox_15;
	JCheckBox checkBox_16;
	JCheckBox checkBox_17;
	JCheckBox checkBox_18;
	JCheckBox checkBox_19;
	JCheckBox checkBox_20;
	JLabel lblCheck;
	
	private final JCheckBox NewCheckBox = new JCheckBox("");
	private JTextField textField_StatusTotal;
	private JTextField textField_Total;
	private int TotalJumlah;
	private boolean StatusTotal;
	
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
	
	public void setEditable(){
		if (MainRumah.rumahSimpan.getIsLocked()){
			btnSave.setVisible(false);
			btnSave.setEnabled(false);
			btnDelete.setVisible(false);
			btnDelete.setEnabled(false);

		}
	}

	
	public void CbVisibility(){
		if(App.status==0){
			NewCheckBox.setVisible(false);
			checkBox.setVisible(false);
			checkBox_1.setVisible(false);
			checkBox_2.setVisible(false);
			checkBox_3.setVisible(false);
			checkBox_4.setVisible(false);
			checkBox_5.setVisible(false);
			checkBox_6.setVisible(false);
			checkBox_7.setVisible(false);
			checkBox_8.setVisible(false);
			checkBox_9.setVisible(false);
			checkBox_10.setVisible(false);
			checkBox_11.setVisible(false);
			checkBox_12.setVisible(false);
			checkBox_13.setVisible(false);
			checkBox_14.setVisible(false);
			checkBox_15.setVisible(false);
			checkBox_16.setVisible(false);
			checkBox_17.setVisible(false);
			checkBox_18.setVisible(false);
			checkBox_19.setVisible(false);
			checkBox_20.setVisible(false);
			lblCheck.setVisible(false);
		}
	}
	//end tambahan

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataPembayaranPembeliSoftCash frame = new DataPembayaranPembeliSoftCash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public DataPembayaranPembeliSoftCash() {
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setTitle("Pembayaran SoftCash");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 0, 1212, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPembayaran = new JLabel("Pembayaran");
		lblPembayaran.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPembayaran.setBounds(53, 14, 84, 26);
		contentPane.add(lblPembayaran);
		
		JLabel lblNo = new JLabel("No");
		lblNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNo.setBounds(20, 14, 23, 26);
		contentPane.add(lblNo);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJumlah.setBounds(236, 14, 58, 26);
		contentPane.add(lblJumlah);
		
		JLabel lblBank = new JLabel("Bank");
		lblBank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBank.setBounds(496, 14, 40, 26);
		contentPane.add(lblBank);
		
		JLabel lblAtasNama = new JLabel("Atas Nama");
		lblAtasNama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtasNama.setBounds(643, 14, 84, 26);
		contentPane.add(lblAtasNama);
		
		JLabel lblNoRekening = new JLabel("No Rekening");
		lblNoRekening.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNoRekening.setBounds(927, 14, 92, 26);
		contentPane.add(lblNoRekening);
		
		No1 = new JTextField();
		No1.setText("1");
		No1.setBounds(20, 51, 23, 20);
		contentPane.add(No1);
		No1.setColumns(10);
		
		Pembayaran1 = new JTextField();
		Pembayaran1.setText("Booking");
		Pembayaran1.setBounds(53, 51, 173, 20);
		contentPane.add(Pembayaran1);
		Pembayaran1.setColumns(10);
		
		Jumlah1 = new JTextField();
		Jumlah1.setBounds(236, 51, 139, 20);
		contentPane.add(Jumlah1);
		Jumlah1.setColumns(10);
		
		Bank1 = new JTextField();
		Bank1.setBounds(496, 51, 137, 20);
		contentPane.add(Bank1);
		Bank1.setColumns(10);
		
		AN1 = new JTextField();
		AN1.setBounds(643, 51, 274, 20);
		contentPane.add(AN1);
		AN1.setColumns(10);
		
		NoRek1 = new JTextField();
		NoRek1.setBounds(927, 51, 217, 20);
		contentPane.add(NoRek1);
		NoRek1.setColumns(10);
		
		NoRek2 = new JTextField();
		NoRek2.setColumns(10);
		NoRek2.setBounds(927, 75, 217, 20);
		contentPane.add(NoRek2);
		
		AN2 = new JTextField();
		AN2.setColumns(10);
		AN2.setBounds(643, 75, 274, 20);
		contentPane.add(AN2);
		
		Bank2 = new JTextField();
		Bank2.setColumns(10);
		Bank2.setBounds(496, 75, 137, 20);
		contentPane.add(Bank2);
		
		Jumlah2 = new JTextField();
		Jumlah2.setColumns(10);
		Jumlah2.setBounds(236, 75, 139, 20);
		contentPane.add(Jumlah2);
		
		Pembayaran2 = new JTextField();
		Pembayaran2.setText("DP");
		Pembayaran2.setColumns(10);
		Pembayaran2.setBounds(53, 75, 173, 20);
		contentPane.add(Pembayaran2);
		
		No2 = new JTextField();
		No2.setText("2");
		No2.setColumns(10);
		No2.setBounds(20, 75, 23, 20);
		contentPane.add(No2);
		
		No3 = new JTextField();
		No3.setText("3");
		No3.setColumns(10);
		No3.setBounds(20, 99, 23, 20);
		contentPane.add(No3);
		
		Pembayaran3 = new JTextField();
		Pembayaran3.setText("Transfer 1");
		Pembayaran3.setColumns(10);
		Pembayaran3.setBounds(53, 99, 173, 20);
		contentPane.add(Pembayaran3);
		
		Jumlah3 = new JTextField();
		Jumlah3.setColumns(10);
		Jumlah3.setBounds(236, 99, 139, 20);
		contentPane.add(Jumlah3);
		
		Bank3 = new JTextField();
		Bank3.setColumns(10);
		Bank3.setBounds(496, 99, 137, 20);
		contentPane.add(Bank3);
		
		AN3 = new JTextField();
		AN3.setColumns(10);
		AN3.setBounds(643, 99, 274, 20);
		contentPane.add(AN3);
		
		NoRek3 = new JTextField();
		NoRek3.setColumns(10);
		NoRek3.setBounds(927, 99, 217, 20);
		contentPane.add(NoRek3);
		
		No4 = new JTextField();
		No4.setText("4");
		No4.setColumns(10);
		No4.setBounds(20, 123, 23, 20);
		contentPane.add(No4);
		
		Pembayaran4 = new JTextField();
		Pembayaran4.setText("Transfer 2");
		Pembayaran4.setColumns(10);
		Pembayaran4.setBounds(53, 123, 173, 20);
		contentPane.add(Pembayaran4);
		
		Jumlah4 = new JTextField();
		Jumlah4.setColumns(10);
		Jumlah4.setBounds(236, 123, 139, 20);
		contentPane.add(Jumlah4);
		
		Bank4 = new JTextField();
		Bank4.setColumns(10);
		Bank4.setBounds(496, 123, 137, 20);
		contentPane.add(Bank4);
		
		AN4 = new JTextField();
		AN4.setColumns(10);
		AN4.setBounds(643, 123, 274, 20);
		contentPane.add(AN4);
		
		NoRek4 = new JTextField();
		NoRek4.setColumns(10);
		NoRek4.setBounds(927, 123, 217, 20);
		contentPane.add(NoRek4);
		
		No5 = new JTextField();
		No5.setText("5");
		No5.setColumns(10);
		No5.setBounds(20, 147, 23, 20);
		contentPane.add(No5);
		
		Pembayaran5 = new JTextField();
		Pembayaran5.setText("Transfer 3");
		Pembayaran5.setColumns(10);
		Pembayaran5.setBounds(53, 147, 173, 20);
		contentPane.add(Pembayaran5);
		
		Jumlah5 = new JTextField();
		Jumlah5.setColumns(10);
		Jumlah5.setBounds(236, 147, 139, 20);
		contentPane.add(Jumlah5);
		
		Bank5 = new JTextField();
		Bank5.setColumns(10);
		Bank5.setBounds(496, 147, 137, 20);
		contentPane.add(Bank5);
		
		AN5 = new JTextField();
		AN5.setColumns(10);
		AN5.setBounds(643, 147, 274, 20);
		contentPane.add(AN5);
		
		NoRek5 = new JTextField();
		NoRek5.setColumns(10);
		NoRek5.setBounds(927, 147, 217, 20);
		contentPane.add(NoRek5);
		
		JLabel Tanggal = new JLabel("Tanggal");
		Tanggal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Tanggal.setBounds(385, 11, 58, 26);
		contentPane.add(Tanggal);
		
		Tanggal1 = new JTextField();
		Tanggal1.setColumns(10);
		Tanggal1.setBounds(385, 51, 101, 20);
		contentPane.add(Tanggal1);
		
		Tanggal2 = new JTextField();
		Tanggal2.setColumns(10);
		Tanggal2.setBounds(385, 75, 101, 20);
		contentPane.add(Tanggal2);
		
		Tanggal3 = new JTextField();
		Tanggal3.setColumns(10);
		Tanggal3.setBounds(385, 99, 101, 20);
		contentPane.add(Tanggal3);
		
		Tanggal4 = new JTextField();
		Tanggal4.setColumns(10);
		Tanggal4.setBounds(385, 123, 101, 20);
		contentPane.add(Tanggal4);
		
		Tanggal5 = new JTextField();
		Tanggal5.setColumns(10);
		Tanggal5.setBounds(385, 147, 101, 20);
		contentPane.add(Tanggal5);
		
		btnKembaliKeMenu = new JButton("Kembali ke Menu Rumah");
		btnKembaliKeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MainRumah frameMain = new MainRumah();
				frameMain.setVisible(true);
			}
		});
		btnKembaliKeMenu.setBounds(578, 626, 190, 23);
		contentPane.add(btnKembaliKeMenu);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveValue(); //pindahin nilai textfield ke array lagi
				String sql;
				boolean ok=true;
				
				if(isKosong){//insert baru
					for(int i=0;i<22;i++){
						try{
							sql = "INSERT INTO `tabel_softcash`(`idRumah`, `nomor`, `pembayaran`, `Jumlah`, `tanggal`, `bank`, `atas_nama`, `no_rek`, `isChecked`) VALUES ("+MainRumah.rumahSimpan.getIDRumah()+","+(i+1)+",'"+bayar[i].Pembayaran+"',"+bayar[i].Jumlah+",'"+bayar[i].Tanggal+"','"+bayar[i].Bank+"','"+bayar[i].AtasNama+"','"+bayar[i].NoRekening+"',"+bayar[i].cek+")";
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
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"+MainRumah.pembeli.Nama+"','"+ft.format(dNow)+"','"+Jumlah1.getText().toString()+"','"+MainRumah.rumahSimpan.getTipe()+"','"+MainRumah.rumahSimpan.getNoRumah()+"','"+MainRumah.marketing+"','data pembayaran SoftCash baru')";
						statement.executeUpdate(sql);
//						JOptionPane.showMessageDialog(null, "update tabel berhasi1!!");
						
					}catch(SQLException se){
						se.printStackTrace();
						ok = false;
						
					}
				}else{
					for(int i=0;i<22;i++){
						try{
							sql = "UPDATE `tabel_softcash` SET `Jumlah` = "+bayar[i].Jumlah+",`tanggal`='"+bayar[i].Tanggal+"',`bank`= '"+bayar[i].Bank+"',`atas_nama`= '"+bayar[i].AtasNama+"',`no_rek`= '"+bayar[i].NoRekening+"',`isChecked`= "+bayar[i].cek+" WHERE `pembayaran`= '"+bayar[i].Pembayaran+"'";
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
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"+MainRumah.pembeli.Nama+"','"+ft.format(dNow)+"','"+Jumlah1.getText().toString()+"','"+MainRumah.rumahSimpan.getTipe()+"','"+MainRumah.rumahSimpan.getNoRumah()+"','"+MainRumah.marketing+"','update data pembayaran Soft Cash')";
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
		btnSave.setBounds(778, 626, 139, 23);
		contentPane.add(btnSave);
		
		JButton btnNewButton = new JButton("Save Picture");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Robot robot;
				try {
					robot = new Robot();
					BufferedImage image = robot.createScreenCapture(new Rectangle(1300,700));
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
		btnNewButton.setBounds(1055, 626, 139, 23);
		contentPane.add(btnNewButton);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Object[] option = {"Hapus","Tunda"};
					int op = JOptionPane.showOptionDialog(null, "Data akan dihapus. Teruskan? ","Konfirmasi Jawaban",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,option,option[0]);
					
					if(op==0){
						String sql1;
						sql1= "DELETE FROM `tabel_softcash` WHERE `idRumah`="+MainRumah.rumahSimpan.getIDRumah();
						statement.executeUpdate(sql1);
					
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"+MainRumah.pembeli.Nama+"','"+ft.format(dNow)+"','"+Jumlah1.getText().toString()+"','"+MainRumah.rumahSimpan.getTipe()+"','"+MainRumah.rumahSimpan.getNoRumah()+"','"+MainRumah.marketing+"','hapus data pembayaran Soft Cash')";
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
		btnDelete.setBounds(429, 626, 139, 23);
		contentPane.add(btnDelete);
		
		No6 = new JTextField();
		No6.setText("6");
		No6.setColumns(10);
		No6.setBounds(20, 170, 23, 20);
		contentPane.add(No6);
		
		Pembayaran6 = new JTextField();
		Pembayaran6.setText("Transfer 4");
		Pembayaran6.setColumns(10);
		Pembayaran6.setBounds(53, 170, 173, 20);
		contentPane.add(Pembayaran6);
		
		Jumlah6 = new JTextField();
		Jumlah6.setColumns(10);
		Jumlah6.setBounds(236, 170, 139, 20);
		contentPane.add(Jumlah6);
		
		Tanggal6 = new JTextField();
		Tanggal6.setColumns(10);
		Tanggal6.setBounds(385, 170, 101, 20);
		contentPane.add(Tanggal6);
		
		Bank6 = new JTextField();
		Bank6.setColumns(10);
		Bank6.setBounds(496, 170, 137, 20);
		contentPane.add(Bank6);
		
		AN6 = new JTextField();
		AN6.setColumns(10);
		AN6.setBounds(643, 170, 274, 20);
		contentPane.add(AN6);
		
		NoRek6 = new JTextField();
		NoRek6.setColumns(10);
		NoRek6.setBounds(927, 170, 217, 20);
		contentPane.add(NoRek6);
		
		No7 = new JTextField();
		No7.setText("7");
		No7.setColumns(10);
		No7.setBounds(20, 194, 23, 20);
		contentPane.add(No7);
		
		Pembayaran7 = new JTextField();
		Pembayaran7.setText("Transfer 5");
		Pembayaran7.setColumns(10);
		Pembayaran7.setBounds(53, 194, 173, 20);
		contentPane.add(Pembayaran7);
		
		Jumlah7 = new JTextField();
		Jumlah7.setColumns(10);
		Jumlah7.setBounds(236, 194, 139, 20);
		contentPane.add(Jumlah7);
		
		Tanggal7 = new JTextField();
		Tanggal7.setColumns(10);
		Tanggal7.setBounds(385, 194, 101, 20);
		contentPane.add(Tanggal7);
		
		Bank7 = new JTextField();
		Bank7.setColumns(10);
		Bank7.setBounds(496, 194, 137, 20);
		contentPane.add(Bank7);
		
		AN7 = new JTextField();
		AN7.setColumns(10);
		AN7.setBounds(643, 194, 274, 20);
		contentPane.add(AN7);
		
		NoRek7 = new JTextField();
		NoRek7.setColumns(10);
		NoRek7.setBounds(927, 194, 217, 20);
		contentPane.add(NoRek7);
		
		No8 = new JTextField();
		No8.setText("8");
		No8.setColumns(10);
		No8.setBounds(20, 218, 23, 20);
		contentPane.add(No8);
		
		Pembayaran8 = new JTextField();
		Pembayaran8.setText("Transfer 6");
		Pembayaran8.setColumns(10);
		Pembayaran8.setBounds(53, 218, 173, 20);
		contentPane.add(Pembayaran8);
		
		Jumlah8 = new JTextField();
		Jumlah8.setColumns(10);
		Jumlah8.setBounds(236, 218, 139, 20);
		contentPane.add(Jumlah8);
		
		Tanggal8 = new JTextField();
		Tanggal8.setColumns(10);
		Tanggal8.setBounds(385, 218, 101, 20);
		contentPane.add(Tanggal8);
		
		Bank8 = new JTextField();
		Bank8.setColumns(10);
		Bank8.setBounds(496, 218, 137, 20);
		contentPane.add(Bank8);
		
		AN8 = new JTextField();
		AN8.setColumns(10);
		AN8.setBounds(643, 218, 274, 20);
		contentPane.add(AN8);
		
		NoRek8 = new JTextField();
		NoRek8.setColumns(10);
		NoRek8.setBounds(927, 218, 217, 20);
		contentPane.add(NoRek8);
		
		No9 = new JTextField();
		No9.setText("9");
		No9.setColumns(10);
		No9.setBounds(20, 242, 23, 20);
		contentPane.add(No9);
		
		Pembayaran9 = new JTextField();
		Pembayaran9.setText("Transfer 7");
		Pembayaran9.setColumns(10);
		Pembayaran9.setBounds(53, 242, 173, 20);
		contentPane.add(Pembayaran9);
		
		lblCheck = new JLabel("check");
		lblCheck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheck.setBounds(1156, 14, 40, 26);
		contentPane.add(lblCheck);
		NewCheckBox.setBounds(1150, 51, 21, 20);
		contentPane.add(NewCheckBox);
		
		Jumlah9 = new JTextField();
		Jumlah9.setColumns(10);
		Jumlah9.setBounds(236, 242, 139, 20);
		contentPane.add(Jumlah9);
		
		Bank9 = new JTextField();
		Bank9.setColumns(10);
		Bank9.setBounds(496, 242, 137, 20);
		contentPane.add(Bank9);
		
		AN9 = new JTextField();
		AN9.setColumns(10);
		AN9.setBounds(643, 242, 274, 20);
		contentPane.add(AN9);
		
		NoRek9 = new JTextField();
		NoRek9.setColumns(10);
		NoRek9.setBounds(927, 242, 217, 20);
		contentPane.add(NoRek9);
		
		NoRek10 = new JTextField();
		NoRek10.setColumns(10);
		NoRek10.setBounds(927, 266, 217, 20);
		contentPane.add(NoRek10);
		
		AN10 = new JTextField();
		AN10.setColumns(10);
		AN10.setBounds(643, 266, 274, 20);
		contentPane.add(AN10);
		
		Bank10 = new JTextField();
		Bank10.setColumns(10);
		Bank10.setBounds(496, 266, 137, 20);
		contentPane.add(Bank10);
		
		Jumlah10 = new JTextField();
		Jumlah10.setColumns(10);
		Jumlah10.setBounds(236, 266, 139, 20);
		contentPane.add(Jumlah10);
		
		Pembayaran10 = new JTextField();
		Pembayaran10.setText("Transfer 8");
		Pembayaran10.setColumns(10);
		Pembayaran10.setBounds(53, 266, 173, 20);
		contentPane.add(Pembayaran10);
		
		No10 = new JTextField();
		No10.setText("10");
		No10.setColumns(10);
		No10.setBounds(20, 266, 23, 20);
		contentPane.add(No10);
		
		No11 = new JTextField();
		No11.setText("11");
		No11.setColumns(10);
		No11.setBounds(20, 290, 23, 20);
		contentPane.add(No11);
		
		Pembayaran11 = new JTextField();
		Pembayaran11.setHorizontalAlignment(SwingConstants.LEFT);
		Pembayaran11.setText("Transfer 9");
		Pembayaran11.setColumns(10);
		Pembayaran11.setBounds(53, 290, 173, 20);
		contentPane.add(Pembayaran11);
		
		Jumlah11 = new JTextField();
		Jumlah11.setColumns(10);
		Jumlah11.setBounds(236, 290, 139, 20);
		contentPane.add(Jumlah11);
		
		Bank11 = new JTextField();
		Bank11.setColumns(10);
		Bank11.setBounds(496, 290, 137, 20);
		contentPane.add(Bank11);
		
		AN11 = new JTextField();
		AN11.setColumns(10);
		AN11.setBounds(643, 290, 274, 20);
		contentPane.add(AN11);
		
		NoRek11 = new JTextField();
		NoRek11.setColumns(10);
		NoRek11.setBounds(927, 290, 217, 20);
		contentPane.add(NoRek11);
		
		No12 = new JTextField();
		No12.setText("12");
		No12.setColumns(10);
		No12.setBounds(20, 315, 23, 20);
		contentPane.add(No12);
		
		Pembayaran12 = new JTextField();
		Pembayaran12.setText("Transfer 10");
		Pembayaran12.setColumns(10);
		Pembayaran12.setBounds(53, 315, 173, 20);
		contentPane.add(Pembayaran12);
		
		Jumlah12 = new JTextField();
		Jumlah12.setColumns(10);
		Jumlah12.setBounds(236, 315, 139, 20);
		contentPane.add(Jumlah12);
		
		Bank12 = new JTextField();
		Bank12.setColumns(10);
		Bank12.setBounds(496, 315, 137, 20);
		contentPane.add(Bank12);
		
		AN12 = new JTextField();
		AN12.setColumns(10);
		AN12.setBounds(643, 315, 274, 20);
		contentPane.add(AN12);
		
		NoRek12 = new JTextField();
		NoRek12.setColumns(10);
		NoRek12.setBounds(927, 315, 217, 20);
		contentPane.add(NoRek12);
		
		No13 = new JTextField();
		No13.setText("13");
		No13.setColumns(10);
		No13.setBounds(20, 339, 23, 20);
		contentPane.add(No13);
		
		Pembayaran13 = new JTextField();
		Pembayaran13.setText("Transfer 11");
		Pembayaran13.setColumns(10);
		Pembayaran13.setBounds(53, 339, 173, 20);
		contentPane.add(Pembayaran13);
		
		Jumlah13 = new JTextField();
		Jumlah13.setColumns(10);
		Jumlah13.setBounds(236, 339, 139, 20);
		contentPane.add(Jumlah13);
		
		Bank13 = new JTextField();
		Bank13.setColumns(10);
		Bank13.setBounds(496, 339, 137, 20);
		contentPane.add(Bank13);
		
		AN13 = new JTextField();
		AN13.setColumns(10);
		AN13.setBounds(643, 339, 274, 20);
		contentPane.add(AN13);
		
		NoRek13 = new JTextField();
		NoRek13.setColumns(10);
		NoRek13.setBounds(927, 339, 217, 20);
		contentPane.add(NoRek13);
		
		Tanggal9 = new JTextField();
		Tanggal9.setColumns(10);
		Tanggal9.setBounds(385, 242, 101, 20);
		contentPane.add(Tanggal9);
		
		Tanggal10 = new JTextField();
		Tanggal10.setColumns(10);
		Tanggal10.setBounds(385, 266, 101, 20);
		contentPane.add(Tanggal10);
		
		Tanggal11 = new JTextField();
		Tanggal11.setColumns(10);
		Tanggal11.setBounds(385, 290, 101, 20);
		contentPane.add(Tanggal11);
		
		Tanggal12 = new JTextField();
		Tanggal12.setColumns(10);
		Tanggal12.setBounds(385, 315, 101, 20);
		contentPane.add(Tanggal12);
		
		Tanggal13 = new JTextField();
		Tanggal13.setColumns(10);
		Tanggal13.setBounds(385, 339, 101, 20);
		contentPane.add(Tanggal13);
		
		textField = new JTextField();
		textField.setText("14");
		textField.setColumns(10);
		textField.setBounds(20, 363, 23, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("15");
		textField_1.setColumns(10);
		textField_1.setBounds(20, 387, 23, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("16");
		textField_2.setColumns(10);
		textField_2.setBounds(20, 412, 23, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("17");
		textField_3.setColumns(10);
		textField_3.setBounds(20, 436, 23, 20);
		contentPane.add(textField_3);
		
		Pembayaran14 = new JTextField();
		Pembayaran14.setText("Transfer 12");
		Pembayaran14.setColumns(10);
		Pembayaran14.setBounds(53, 363, 173, 20);
		contentPane.add(Pembayaran14);
		
		Pembayaran15 = new JTextField();
		Pembayaran15.setText("Transfer 13");
		Pembayaran15.setHorizontalAlignment(SwingConstants.LEFT);
		Pembayaran15.setColumns(10);
		Pembayaran15.setBounds(53, 387, 173, 20);
		contentPane.add(Pembayaran15);
		
		Pembayaran16 = new JTextField();
		Pembayaran16.setText("Transfer 14");
		Pembayaran16.setColumns(10);
		Pembayaran16.setBounds(53, 412, 173, 20);
		contentPane.add(Pembayaran16);
		
		Pembayaran17 = new JTextField();
		Pembayaran17.setText("Transfer 15");
		Pembayaran17.setColumns(10);
		Pembayaran17.setBounds(53, 436, 173, 20);
		contentPane.add(Pembayaran17);
		
		Jumlah14 = new JTextField();
		Jumlah14.setColumns(10);
		Jumlah14.setBounds(236, 363, 139, 20);
		contentPane.add(Jumlah14);
		
		Jumlah15 = new JTextField();
		Jumlah15.setColumns(10);
		Jumlah15.setBounds(236, 387, 139, 20);
		contentPane.add(Jumlah15);
		
		Jumlah16 = new JTextField();
		Jumlah16.setColumns(10);
		Jumlah16.setBounds(236, 412, 139, 20);
		contentPane.add(Jumlah16);
		
		Jumlah17 = new JTextField();
		Jumlah17.setColumns(10);
		Jumlah17.setBounds(236, 436, 139, 20);
		contentPane.add(Jumlah17);
		
		Tanggal14 = new JTextField();
		Tanggal14.setColumns(10);
		Tanggal14.setBounds(385, 363, 101, 20);
		contentPane.add(Tanggal14);
		
		Tanggal15 = new JTextField();
		Tanggal15.setColumns(10);
		Tanggal15.setBounds(385, 387, 101, 20);
		contentPane.add(Tanggal15);
		
		Tanggal16 = new JTextField();
		Tanggal16.setColumns(10);
		Tanggal16.setBounds(385, 412, 101, 20);
		contentPane.add(Tanggal16);
		
		Tanggal17 = new JTextField();
		Tanggal17.setColumns(10);
		Tanggal17.setBounds(385, 436, 101, 20);
		contentPane.add(Tanggal17);
		
		Bank14 = new JTextField();
		Bank14.setColumns(10);
		Bank14.setBounds(496, 363, 137, 20);
		contentPane.add(Bank14);
		
		Bank15 = new JTextField();
		Bank15.setColumns(10);
		Bank15.setBounds(496, 387, 137, 20);
		contentPane.add(Bank15);
		
		Bank16 = new JTextField();
		Bank16.setColumns(10);
		Bank16.setBounds(496, 412, 137, 20);
		contentPane.add(Bank16);
		
		Bank17 = new JTextField();
		Bank17.setColumns(10);
		Bank17.setBounds(496, 436, 137, 20);
		contentPane.add(Bank17);
		
		AN14 = new JTextField();
		AN14.setColumns(10);
		AN14.setBounds(643, 363, 274, 20);
		contentPane.add(AN14);
		
		AN15 = new JTextField();
		AN15.setColumns(10);
		AN15.setBounds(643, 387, 274, 20);
		contentPane.add(AN15);
		
		AN16 = new JTextField();
		AN16.setColumns(10);
		AN16.setBounds(643, 412, 274, 20);
		contentPane.add(AN16);
		
		AN17 = new JTextField();
		AN17.setColumns(10);
		AN17.setBounds(643, 436, 274, 20);
		contentPane.add(AN17);
		
		NoRek14 = new JTextField();
		NoRek14.setColumns(10);
		NoRek14.setBounds(927, 363, 217, 20);
		contentPane.add(NoRek14);
		
		NoRek15 = new JTextField();
		NoRek15.setColumns(10);
		NoRek15.setBounds(927, 387, 217, 20);
		contentPane.add(NoRek15);
		
		NoRek16 = new JTextField();
		NoRek16.setColumns(10);
		NoRek16.setBounds(927, 412, 217, 20);
		contentPane.add(NoRek16);
		
		NoRek17 = new JTextField();
		NoRek17.setColumns(10);
		NoRek17.setBounds(927, 436, 217, 20);
		contentPane.add(NoRek17);
		
		textField_4 = new JTextField();
		textField_4.setText("18");
		textField_4.setColumns(10);
		textField_4.setBounds(20, 460, 23, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("19");
		textField_5.setColumns(10);
		textField_5.setBounds(20, 484, 23, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("20");
		textField_6.setColumns(10);
		textField_6.setBounds(20, 509, 23, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("21");
		textField_7.setColumns(10);
		textField_7.setBounds(20, 533, 23, 20);
		contentPane.add(textField_7);
		
		Pembayaran18 = new JTextField();
		Pembayaran18.setText("Transfer 16");
		Pembayaran18.setColumns(10);
		Pembayaran18.setBounds(53, 460, 173, 20);
		contentPane.add(Pembayaran18);
		
		Pembayaran19 = new JTextField();
		Pembayaran19.setText("Transfer 17");
		Pembayaran19.setHorizontalAlignment(SwingConstants.LEFT);
		Pembayaran19.setColumns(10);
		Pembayaran19.setBounds(53, 484, 173, 20);
		contentPane.add(Pembayaran19);
		
		Pembayaran20 = new JTextField();
		Pembayaran20.setText("Transfer 18");
		Pembayaran20.setColumns(10);
		Pembayaran20.setBounds(53, 509, 173, 20);
		contentPane.add(Pembayaran20);
		
		Pembayaran21 = new JTextField();
		Pembayaran21.setText("Transfer 19");
		Pembayaran21.setColumns(10);
		Pembayaran21.setBounds(53, 533, 173, 20);
		contentPane.add(Pembayaran21);
		
		Jumlah18 = new JTextField();
		Jumlah18.setColumns(10);
		Jumlah18.setBounds(236, 460, 139, 20);
		contentPane.add(Jumlah18);
		
		Jumlah19 = new JTextField();
		Jumlah19.setColumns(10);
		Jumlah19.setBounds(236, 484, 139, 20);
		contentPane.add(Jumlah19);
		
		Jumlah20 = new JTextField();
		Jumlah20.setColumns(10);
		Jumlah20.setBounds(236, 509, 139, 20);
		contentPane.add(Jumlah20);
		
		Jumlah21 = new JTextField();
		Jumlah21.setColumns(10);
		Jumlah21.setBounds(236, 533, 139, 20);
		contentPane.add(Jumlah21);
		
		Tanggal18 = new JTextField();
		Tanggal18.setColumns(10);
		Tanggal18.setBounds(385, 460, 101, 20);
		contentPane.add(Tanggal18);
		
		Tanggal19 = new JTextField();
		Tanggal19.setColumns(10);
		Tanggal19.setBounds(385, 484, 101, 20);
		contentPane.add(Tanggal19);
		
		Tanggal20 = new JTextField();
		Tanggal20.setColumns(10);
		Tanggal20.setBounds(385, 509, 101, 20);
		contentPane.add(Tanggal20);
		
		Tanggal21 = new JTextField();
		Tanggal21.setColumns(10);
		Tanggal21.setBounds(385, 533, 101, 20);
		contentPane.add(Tanggal21);
		
		Bank18 = new JTextField();
		Bank18.setColumns(10);
		Bank18.setBounds(496, 460, 137, 20);
		contentPane.add(Bank18);
		
		Bank19 = new JTextField();
		Bank19.setColumns(10);
		Bank19.setBounds(496, 484, 137, 20);
		contentPane.add(Bank19);
		
		Bank20 = new JTextField();
		Bank20.setColumns(10);
		Bank20.setBounds(496, 509, 137, 20);
		contentPane.add(Bank20);
		
		Bank21 = new JTextField();
		Bank21.setColumns(10);
		Bank21.setBounds(496, 533, 137, 20);
		contentPane.add(Bank21);
		
		AN18 = new JTextField();
		AN18.setColumns(10);
		AN18.setBounds(643, 460, 274, 20);
		contentPane.add(AN18);
		
		AN19 = new JTextField();
		AN19.setColumns(10);
		AN19.setBounds(643, 484, 274, 20);
		contentPane.add(AN19);
		
		AN20 = new JTextField();
		AN20.setColumns(10);
		AN20.setBounds(643, 509, 274, 20);
		contentPane.add(AN20);
		
		AN21 = new JTextField();
		AN21.setColumns(10);
		AN21.setBounds(643, 533, 274, 20);
		contentPane.add(AN21);
		
		NoRek18 = new JTextField();
		NoRek18.setColumns(10);
		NoRek18.setBounds(927, 460, 217, 20);
		contentPane.add(NoRek18);
		
		NoRek19 = new JTextField();
		NoRek19.setColumns(10);
		NoRek19.setBounds(927, 484, 217, 20);
		contentPane.add(NoRek19);
		
		NoRek20 = new JTextField();
		NoRek20.setColumns(10);
		NoRek20.setBounds(927, 509, 217, 20);
		contentPane.add(NoRek20);
		
		NoRek21 = new JTextField();
		NoRek21.setColumns(10);
		NoRek21.setBounds(927, 533, 217, 20);
		contentPane.add(NoRek21);
		
		textField_28 = new JTextField();
		textField_28.setText("22");
		textField_28.setColumns(10);
		textField_28.setBounds(20, 557, 23, 20);
		contentPane.add(textField_28);
		
		Pembayaran22 = new JTextField();
		Pembayaran22.setText("Transfer 20");
		Pembayaran22.setColumns(10);
		Pembayaran22.setBounds(53, 557, 173, 20);
		contentPane.add(Pembayaran22);
		
		Jumlah22 = new JTextField();
		Jumlah22.setColumns(10);
		Jumlah22.setBounds(236, 557, 139, 20);
		contentPane.add(Jumlah22);
		
		Tanggal22 = new JTextField();
		Tanggal22.setColumns(10);
		Tanggal22.setBounds(385, 557, 101, 20);
		contentPane.add(Tanggal22);
		
		Bank22 = new JTextField();
		Bank22.setColumns(10);
		Bank22.setBounds(496, 557, 137, 20);
		contentPane.add(Bank22);
		
		AN22 = new JTextField();
		AN22.setColumns(10);
		AN22.setBounds(643, 557, 274, 20);
		contentPane.add(AN22);
		
		NoRek22 = new JTextField();
		NoRek22.setColumns(10);
		NoRek22.setBounds(927, 557, 217, 20);
		contentPane.add(NoRek22);
		
		 checkBox = new JCheckBox("");
		checkBox.setBounds(1150, 74, 21, 20);
		contentPane.add(checkBox);
		
		 checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(1150, 98, 21, 20);
		contentPane.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(1150, 122, 21, 20);
		contentPane.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(1150, 147, 21, 20);
		contentPane.add(checkBox_3);
		
		 checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(1150, 169, 21, 20);
		contentPane.add(checkBox_4);
		
		 checkBox_5 = new JCheckBox("");
		checkBox_5.setBounds(1150, 193, 21, 20);
		contentPane.add(checkBox_5);
		
		 checkBox_6 = new JCheckBox("");
		checkBox_6.setBounds(1150, 217, 21, 20);
		contentPane.add(checkBox_6);
		
		 checkBox_7 = new JCheckBox("");
		checkBox_7.setBounds(1150, 241, 21, 20);
		contentPane.add(checkBox_7);
		
		 checkBox_8 = new JCheckBox("");
		checkBox_8.setBounds(1150, 265, 21, 20);
		contentPane.add(checkBox_8);
		
		 checkBox_9 = new JCheckBox("");
		checkBox_9.setBounds(1150, 289, 21, 20);
		contentPane.add(checkBox_9);
		
		 checkBox_10 = new JCheckBox("");
		checkBox_10.setBounds(1150, 314, 21, 20);
		contentPane.add(checkBox_10);
		
		 checkBox_11 = new JCheckBox("");
		checkBox_11.setBounds(1150, 338, 21, 20);
		contentPane.add(checkBox_11);
		
		 checkBox_12 = new JCheckBox("");
		checkBox_12.setBounds(1150, 362, 21, 20);
		contentPane.add(checkBox_12);
		
		 checkBox_13 = new JCheckBox("");
		checkBox_13.setBounds(1150, 386, 21, 20);
		contentPane.add(checkBox_13);
		
		 checkBox_14 = new JCheckBox("");
		checkBox_14.setBounds(1150, 411, 21, 20);
		contentPane.add(checkBox_14);
		
		 checkBox_15 = new JCheckBox("");
		checkBox_15.setBounds(1150, 435, 21, 20);
		contentPane.add(checkBox_15);
		
		 checkBox_16 = new JCheckBox("");
		checkBox_16.setBounds(1150, 459, 21, 20);
		contentPane.add(checkBox_16);
		
		 checkBox_17 = new JCheckBox("");
		checkBox_17.setBounds(1150, 483, 21, 20);
		contentPane.add(checkBox_17);
		
		 checkBox_18 = new JCheckBox("");
		checkBox_18.setBounds(1150, 508, 21, 20);
		contentPane.add(checkBox_18);
		
		 checkBox_19 = new JCheckBox("");
		checkBox_19.setBounds(1150, 532, 21, 20);
		contentPane.add(checkBox_19);
		
		 checkBox_20 = new JCheckBox("");
		checkBox_20.setBounds(1150, 556, 21, 20);
		contentPane.add(checkBox_20);
		
		
		JLabel lblTotalJumlah = new JLabel("Total Jumlah Pembayaran :");
		lblTotalJumlah.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalJumlah.setBounds(19, 586, 173, 26);
		contentPane.add(lblTotalJumlah);
		
		textField_Total = new JTextField();
		textField_Total.setBounds(202, 590, 195, 20);
		contentPane.add(textField_Total);
		textField_Total.setColumns(10);
		
		JLabel lblStatusTotalPembayaran = new JLabel("Status Total Pembayaran :");
		lblStatusTotalPembayaran.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStatusTotalPembayaran.setBounds(19, 623, 173, 26);
		contentPane.add(lblStatusTotalPembayaran);
		
		textField_StatusTotal = new JTextField();
		textField_StatusTotal.setColumns(10);
		textField_StatusTotal.setBounds(202, 627, 195, 20);
		contentPane.add(textField_StatusTotal);

		
		CbVisibility();

		bayar = new Pembayaran[22];
		try{
			
			sql = "SELECT * FROM `tabel_softcash` WHERE `idRumah`="+MainRumah.rumahSimpan.getIDRumah();
			rs = statement.executeQuery(sql);
			if (!rs.isBeforeFirst()){
				System.out.println("Tabel Kosong");
				isKosong = true;
				
				TotalJumlah = 0;
				textField_Total.setText("Rp "+this.convertHarga(TotalJumlah));
				setStatusTotal();

				bayar[0] = new Pembayaran("Booking",-999,"aaa","aaa","aaa","aaa",0);
				bayar[1] = new Pembayaran("DP",-999,"aaa","aaa","aaa","aaa",0);
				
				for(int i=1;i<=20;i++){
					bayar[i+1] = new Pembayaran("Transfer "+i,-999,"aaa","aaa","aaa","aaa",0);
				}
				
				
				
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
						case 6 :
							if(bayar[5].Jumlah!=-999){
								TotalJumlah = TotalJumlah + bayar[5].Jumlah;

								Jumlah6.setText("Rp "+this.convertHarga(bayar[5].Jumlah));
							}else{
								Jumlah6.setText("Rp ");
							}
							if(!bayar[5].Tanggal.equals("aaa")){
								Tanggal6.setText(bayar[5].Tanggal);
							}
							if(!bayar[5].Bank.equals("aaa")){
								Bank6.setText(bayar[5].Bank);
							}
							if(!bayar[5].AtasNama.equals("aaa")){
								AN6.setText(bayar[5].AtasNama);
							}
							if(!bayar[5].NoRekening.equals("aaa")){
								NoRek6.setText(bayar[5].NoRekening);
							}
							if(bayar[5].cek==1){
								checkBox_4.setSelected(true);
							}
							Pembayaran6.setText(bayar[5].Pembayaran);
							
							//break;
						case 7 :
							Pembayaran7.setText(bayar[6].Pembayaran);
							if(bayar[6].Jumlah!=-999){
								TotalJumlah = TotalJumlah + bayar[6].Jumlah;

								Jumlah7.setText("Rp "+this.convertHarga(bayar[6].Jumlah));
							}else{
								Jumlah7.setText("Rp ");
							}
							if(!bayar[6].Tanggal.equals("aaa")){
								Tanggal7.setText(bayar[6].Tanggal);
							}
							if(!bayar[6].Bank.equals("aaa")){
								Bank7.setText(bayar[6].Bank);
							}
							if(!bayar[6].AtasNama.equals("aaa")){
								AN7.setText(bayar[6].AtasNama);
							}
							if(!bayar[6].NoRekening.equals("aaa")){
								NoRek7.setText(bayar[6].NoRekening);
							}if(bayar[6].cek==1){
								checkBox_5.setSelected(true);
							}
						//	break;
						case 8 :
							Pembayaran8.setText(bayar[7].Pembayaran);
							if(bayar[7].Jumlah!=-999){
								TotalJumlah = TotalJumlah + bayar[7].Jumlah;

								Jumlah8.setText("Rp "+this.convertHarga(bayar[7].Jumlah));
							}else{
								Jumlah8.setText("Rp ");
							}
							if(!bayar[7].Tanggal.equals("aaa")){
								Tanggal8.setText(bayar[7].Tanggal);
							}
							if(!bayar[7].Bank.equals("aaa")){
								Bank8.setText(bayar[7].Bank);
							}
							if(!bayar[7].AtasNama.equals("aaa")){
								AN8.setText(bayar[7].AtasNama);
							}
							if(!bayar[7].NoRekening.equals("aaa")){
								NoRek8.setText(bayar[7].NoRekening);
							}
							if(bayar[7].cek==1){
								checkBox_6.setSelected(true);
							}
						//	break;
						case 9 :
							Pembayaran9.setText(bayar[8].Pembayaran);
							if(bayar[8].Jumlah!=-999){
								TotalJumlah = TotalJumlah + bayar[8].Jumlah;

								Jumlah9.setText("Rp "+this.convertHarga(bayar[8].Jumlah));
							}else{
								Jumlah9.setText("Rp ");
							}
							if(!bayar[8].Tanggal.equals("aaa")){
								Tanggal9.setText(bayar[8].Tanggal);
							}
							if(!bayar[8].Bank.equals("aaa")){
								Bank9.setText(bayar[8].Bank);
							}
							if(!bayar[8].AtasNama.equals("aaa")){
								AN9.setText(bayar[8].AtasNama);
							}
							if(!bayar[8].NoRekening.equals("aaa")){
								NoRek9.setText(bayar[8].NoRekening);
							}if(bayar[8].cek==1){
								checkBox_7.setSelected(true);
							}
						//	break;
						case 10 :
							Pembayaran10.setText(bayar[9].Pembayaran);
							if(bayar[9].Jumlah!=-999){
								TotalJumlah = TotalJumlah + bayar[9].Jumlah;

								Jumlah10.setText("Rp "+this.convertHarga(bayar[9].Jumlah));
							}else{
								Jumlah10.setText("Rp ");
							}
							if(!bayar[9].Tanggal.equals("aaa")){
								Tanggal10.setText(bayar[9].Tanggal);
							}
							if(!bayar[9].Bank.equals("aaa")){
								Bank10.setText(bayar[9].Bank);
							}
							if(!bayar[9].AtasNama.equals("aaa")){
								AN10.setText(bayar[9].AtasNama);
							}
							if(!bayar[9].NoRekening.equals("aaa")){
								NoRek10.setText(bayar[9].NoRekening);
							}
							if(bayar[9].cek==1){
								checkBox_8.setSelected(true);
							}
						//	break;
							case 11 :
								if(bayar[10].Jumlah!=-999){
									TotalJumlah = TotalJumlah + bayar[10].Jumlah;

									Jumlah11.setText("Rp "+this.convertHarga(bayar[10].Jumlah));
								}else{
									Jumlah11.setText("Rp ");
								}
								if(!bayar[10].Tanggal.equals("aaa")){
									Tanggal11.setText(bayar[10].Tanggal);
								}
								if(!bayar[10].Bank.equals("aaa")){
									Bank11.setText(bayar[10].Bank);
								}
								if(!bayar[10].AtasNama.equals("aaa")){
									AN11.setText(bayar[10].AtasNama);
								}
								if(!bayar[10].NoRekening.equals("aaa")){
									NoRek11.setText(bayar[10].NoRekening);
								}if(bayar[10].cek==1){
									checkBox_9.setSelected(true);
								}
								Pembayaran11.setText(bayar[10].Pembayaran);
								
								//break;
							case 12 :
								Pembayaran12.setText(bayar[11].Pembayaran);
								if(bayar[11].Jumlah!=-999){
									TotalJumlah = TotalJumlah + bayar[11].Jumlah;

									Jumlah12.setText("Rp "+this.convertHarga(bayar[11].Jumlah));
								}else{
									Jumlah12.setText("Rp ");
								}
								if(!bayar[11].Tanggal.equals("aaa")){
									Tanggal12.setText(bayar[11].Tanggal);
								}
								if(!bayar[11].Bank.equals("aaa")){
									Bank12.setText(bayar[11].Bank);
								}
								if(!bayar[11].AtasNama.equals("aaa")){
									AN12.setText(bayar[11].AtasNama);
								}
								if(bayar[11].cek==1){
									checkBox_10.setSelected(true);
								}
								if(!bayar[11].NoRekening.equals("aaa")){
									NoRek12.setText(bayar[11].NoRekening);
								}
							//	break;
							case 13 :
								Pembayaran13.setText(bayar[12].Pembayaran);
								if(bayar[12].Jumlah!=-999){
									TotalJumlah = TotalJumlah + bayar[12].Jumlah;

									Jumlah13.setText("Rp "+this.convertHarga(bayar[12].Jumlah));
								}else{
									Jumlah13.setText("Rp ");
								}
								if(!bayar[12].Tanggal.equals("aaa")){
									Tanggal13.setText(bayar[12].Tanggal);
								}
								if(!bayar[12].Bank.equals("aaa")){
									Bank13.setText(bayar[12].Bank);
								}
								if(!bayar[12].AtasNama.equals("aaa")){
									AN13.setText(bayar[12].AtasNama);
								}
								if(!bayar[12].NoRekening.equals("aaa")){
									NoRek13.setText(bayar[12].NoRekening);
								}
								if(bayar[12].cek==1){
									checkBox_11.setSelected(true);
								}
							//	break;
							case 14 :
								Pembayaran14.setText(bayar[13].Pembayaran);
								if(bayar[13].Jumlah!=-999){
									TotalJumlah = TotalJumlah + bayar[13].Jumlah;

									Jumlah14.setText("Rp "+this.convertHarga(bayar[13].Jumlah));
								}else{
									Jumlah14.setText("Rp ");
								}
								if(!bayar[13].Tanggal.equals("aaa")){
									Tanggal14.setText(bayar[13].Tanggal);
								}
								if(!bayar[13].Bank.equals("aaa")){
									Bank14.setText(bayar[13].Bank);
								}
								if(!bayar[13].AtasNama.equals("aaa")){
									AN14.setText(bayar[13].AtasNama);
								}
								if(!bayar[13].NoRekening.equals("aaa")){
									NoRek14.setText(bayar[13].NoRekening);
								}
								if(bayar[13].cek==1){
									checkBox_12.setSelected(true);
								}
							//	break;
							case 15 :
								Pembayaran15.setText(bayar[14].Pembayaran);
								if(bayar[14].Jumlah!=-999){
									TotalJumlah = TotalJumlah + bayar[14].Jumlah;

									Jumlah15.setText("Rp "+this.convertHarga(bayar[14].Jumlah));
								}else{
									Jumlah15.setText("Rp ");
								}
								if(!bayar[14].Tanggal.equals("aaa")){
									Tanggal15.setText(bayar[14].Tanggal);
								}
								if(!bayar[14].Bank.equals("aaa")){
									Bank15.setText(bayar[14].Bank);
								}
								if(!bayar[14].AtasNama.equals("aaa")){
									AN15.setText(bayar[14].AtasNama);
								}
								if(!bayar[14].NoRekening.equals("aaa")){
									NoRek15.setText(bayar[14].NoRekening);
								}
								if(bayar[14].cek==1){
									checkBox_13.setSelected(true);
								}
							//	beak;
								case 16 :
									if(bayar[15].Jumlah!=-999){
										TotalJumlah = TotalJumlah + bayar[15].Jumlah;

										Jumlah16.setText("Rp "+this.convertHarga(bayar[15].Jumlah));
									}else{
										Jumlah16.setText("Rp ");
									}
									if(!bayar[15].Tanggal.equals("aaa")){
										Tanggal16.setText(bayar[15].Tanggal);
									}
									if(!bayar[15].Bank.equals("aaa")){
										Bank16.setText(bayar[15].Bank);
									}
									if(!bayar[15].AtasNama.equals("aaa")){
										AN16.setText(bayar[15].AtasNama);
									}
									if(!bayar[15].NoRekening.equals("aaa")){
										NoRek16.setText(bayar[15].NoRekening);
									}
									if(bayar[15].cek==1){
										checkBox_14.setSelected(true);
									}
									Pembayaran16.setText(bayar[15].Pembayaran);
									
									//break;
								case 17 :
									Pembayaran17.setText(bayar[16].Pembayaran);
									if(bayar[16].Jumlah!=-999){
										TotalJumlah = TotalJumlah + bayar[16].Jumlah;

										Jumlah17.setText("Rp "+this.convertHarga(bayar[16].Jumlah));
									}else{
										Jumlah17.setText("Rp ");
									}
									if(!bayar[16].Tanggal.equals("aaa")){
										Tanggal17.setText(bayar[16].Tanggal);
									}
									if(!bayar[16].Bank.equals("aaa")){
										Bank17.setText(bayar[16].Bank);
									}
									if(!bayar[16].AtasNama.equals("aaa")){
										AN17.setText(bayar[16].AtasNama);
									}
									if(!bayar[16].NoRekening.equals("aaa")){
										NoRek17.setText(bayar[16].NoRekening);
									}
									if(bayar[16].cek==1){
										checkBox_15.setSelected(true);
									}
								//	break;
								case 18 :
									Pembayaran18.setText(bayar[17].Pembayaran);
									if(bayar[17].Jumlah!=-999){
										TotalJumlah = TotalJumlah + bayar[17].Jumlah;

										Jumlah18.setText("Rp "+this.convertHarga(bayar[17].Jumlah));
									}else{
										Jumlah18.setText("Rp ");
									}
									if(!bayar[17].Tanggal.equals("aaa")){
										Tanggal18.setText(bayar[17].Tanggal);
									}
									if(!bayar[17].Bank.equals("aaa")){
										Bank18.setText(bayar[17].Bank);
									}
									if(!bayar[17].AtasNama.equals("aaa")){
										AN17.setText(bayar[17].AtasNama);
									}
									if(!bayar[17].NoRekening.equals("aaa")){
										NoRek18.setText(bayar[17].NoRekening);
									}
									if(bayar[17].cek==1){
										checkBox_16.setSelected(true);
									}
								//	break;
								case 19 :
									Pembayaran19.setText(bayar[18].Pembayaran);
									if(bayar[18].Jumlah!=-999){
										TotalJumlah = TotalJumlah + bayar[18].Jumlah;

										Jumlah19.setText("Rp "+this.convertHarga(bayar[18].Jumlah));
									}else{
										Jumlah19.setText("Rp ");
									}
									if(!bayar[18].Tanggal.equals("aaa")){
										Tanggal19.setText(bayar[18].Tanggal);
									}
									if(!bayar[18].Bank.equals("aaa")){
										Bank19.setText(bayar[18].Bank);
									}
									if(!bayar[18].AtasNama.equals("aaa")){
										AN19.setText(bayar[18].AtasNama);
									}
									if(!bayar[18].NoRekening.equals("aaa")){
										NoRek19.setText(bayar[18].NoRekening);
									}
									if(bayar[18].cek==1){
										checkBox_17.setSelected(true);
									}
								//	break;
								case 20 :
									Pembayaran20.setText(bayar[19].Pembayaran);
									if(bayar[19].Jumlah!=-999){
										TotalJumlah = TotalJumlah + bayar[19].Jumlah;

										Jumlah20.setText("Rp "+this.convertHarga(bayar[19].Jumlah));
									}else{
										Jumlah20.setText("Rp ");
									}
									if(!bayar[19].Tanggal.equals("aaa")){
										Tanggal20.setText(bayar[19].Tanggal);
									}
									if(!bayar[19].Bank.equals("aaa")){
										Bank20.setText(bayar[19].Bank);
									}
									if(!bayar[19].AtasNama.equals("aaa")){
										AN20.setText(bayar[19].AtasNama);
									}
									if(!bayar[19].NoRekening.equals("aaa")){
										NoRek20.setText(bayar[19].NoRekening);
									}
									if(bayar[19].cek==1){
										checkBox_18.setSelected(true);
									}
								//	break;
									case 21 :
										if(bayar[20].Jumlah!=-999){
											TotalJumlah = TotalJumlah + bayar[20].Jumlah;

											Jumlah21.setText("Rp "+this.convertHarga(bayar[20].Jumlah));
										}else{
											Jumlah21.setText("Rp ");
										}
										if(!bayar[20].Tanggal.equals("aaa")){
											Tanggal21.setText(bayar[20].Tanggal);
										}
										if(!bayar[20].Bank.equals("aaa")){
											Bank21.setText(bayar[20].Bank);
										}
										if(!bayar[20].AtasNama.equals("aaa")){
											AN21.setText(bayar[20].AtasNama);
										}
										if(!bayar[20].NoRekening.equals("aaa")){
											NoRek21.setText(bayar[20].NoRekening);
										}
										if(bayar[20].cek==1){
											checkBox_19.setSelected(true);
										}
										Pembayaran21.setText(bayar[20].Pembayaran);
										
										//break;
									case 22 :
										Pembayaran22.setText(bayar[21].Pembayaran);
										if(bayar[21].Jumlah!=-999){
											TotalJumlah = TotalJumlah + bayar[21].Jumlah;

											Jumlah22.setText("Rp "+this.convertHarga(bayar[21].Jumlah));
										}else{
											Jumlah22.setText("Rp ");
										}
										if(!bayar[21].Tanggal.equals("aaa")){
											Tanggal22.setText(bayar[21].Tanggal);
										}
										if(!bayar[21].Bank.equals("aaa")){
											Bank22.setText(bayar[21].Bank);
										}
										if(!bayar[21].AtasNama.equals("aaa")){
											AN22.setText(bayar[21].AtasNama);
										}
										if(!bayar[21].NoRekening.equals("aaa")){
											NoRek22.setText(bayar[21].NoRekening);
										}
										if(bayar[21].cek==1){
											checkBox_20.setSelected(true);
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
		
		if(!Jumlah6.getText().equals("")&&!Jumlah6.getText().equals("Rp ")){
			String str = Jumlah6.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[5].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[5].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[5].Jumlah=-999;
		}
		if(!Tanggal6.getText().equals("")){
			bayar[5].Tanggal= Tanggal6.getText().toString();
		}else{
			bayar[5].Tanggal = "aaa";
		}
		if(!Bank6.getText().equals("")){
			bayar[5].Bank= Bank6.getText().toString();
		}else{
			bayar[5].Bank = "aaa";
		}
		if(!AN6.getText().equals("")){
			bayar[5].AtasNama= AN6.getText().toString();
		}else{
			bayar[5].AtasNama = "aaa";
		}
		if(!NoRek6.getText().equals("")){
			bayar[5].NoRekening= NoRek6.getText().toString();
		}else{
			bayar[5].NoRekening = "aaa";
		}
		if(checkBox_4.isSelected()){
			bayar[5].cek = 1;
		}else{
			bayar[5].cek = 0;
		}
		
		if(!Jumlah7.getText().equals("")&&!Jumlah7.getText().equals("Rp ")){
			String str = Jumlah7.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[6].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[6].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[6].Jumlah = -999;
		}
		if(!Tanggal7.getText().equals("")){
			bayar[6].Tanggal= Tanggal7.getText().toString();
		}else{
			bayar[6].Tanggal = "aaa";
		}
		if(!Bank7.getText().equals("")){
			bayar[6].Bank= Bank7.getText().toString();
		}else{
			bayar[6].Bank = "aaa";
		}
		if(!AN7.getText().equals("")){
			bayar[6].AtasNama= AN7.getText().toString();
		}else{
			bayar[6].AtasNama = "aaa";
		}
		if(!NoRek7.getText().equals("")){
			bayar[6].NoRekening= NoRek7.getText().toString();
		}else{
			bayar[6].NoRekening = "aaa";
		}
		if(checkBox_5.isSelected()){
			bayar[6].cek = 1;
		}else{
			bayar[6].cek = 0;
		}
		
		if(!Jumlah8.getText().equals("")&&!Jumlah8.getText().equals("Rp ")){
			String str = Jumlah8.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[7].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[7].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[7].Jumlah = -999;
		}
		if(!Tanggal8.getText().equals("")){
			bayar[7].Tanggal= Tanggal8.getText().toString();
		}else{
			bayar[7].Tanggal = "aaa";
		}
		if(!Bank8.getText().equals("")){
			bayar[7].Bank= Bank8.getText().toString();
		}else{
			bayar[7].Bank = "aaa";
		}
		if(!AN8.getText().equals("")){
			bayar[7].AtasNama= AN8.getText().toString();
		}else{
			bayar[7].AtasNama = "aaa";
		}
		if(!NoRek8.getText().equals("")){
			bayar[7].NoRekening= NoRek8.getText().toString();
		}else{
			bayar[7].NoRekening = "aaa";
		}
		if(checkBox_6.isSelected()){
			bayar[7].cek = 1;
		}else{
			bayar[7].cek = 0;
		}
		
		if(!Jumlah9.getText().equals("")&&!Jumlah9.getText().equals("Rp ")){
			String str = Jumlah9.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[8].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[8].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[8].Jumlah = -999;
		}
		if(!Tanggal9.getText().equals("")){
			bayar[8].Tanggal= Tanggal9.getText().toString();
		}else{
			bayar[8].Tanggal = "aaa";
		}
		if(!Bank9.getText().equals("")){
			bayar[8].Bank= Bank9.getText().toString();
		}else{
			bayar[8].Bank = "aaa";
		}
		if(!AN9.getText().equals("")){
			bayar[8].AtasNama= AN9.getText().toString();
		}else{
			bayar[8].AtasNama = "aaa";
		}
		if(!NoRek9.getText().equals("")){
			bayar[8].NoRekening= NoRek9.getText().toString();
		}else{
			bayar[8].NoRekening = "aaa";
		}
		if(checkBox_7.isSelected()){
			bayar[8].cek = 1;
		}else{
			bayar[8].cek = 0;
		}
		
		if(!Jumlah10.getText().equals("")&&!Jumlah10.getText().equals("Rp ")){
			String str = Jumlah10.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[9].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[9].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[9].Jumlah = -999;
		}
		if(!Tanggal10.getText().equals("")){
			bayar[9].Tanggal= Tanggal10.getText().toString();
		}else{
			bayar[9].Tanggal = "aaa";
		}
		if(!Bank10.getText().equals("")){
			bayar[9].Bank= Bank10.getText().toString();
		}else{
			bayar[9].Bank = "aaa";
		}
		if(!AN10.getText().equals("")){
			bayar[9].AtasNama= AN10.getText().toString();
		}else{
			bayar[9].AtasNama = "aaa";
		}
		if(!NoRek10.getText().equals("")){
			bayar[9].NoRekening= NoRek10.getText().toString();
		}else{
			bayar[9].NoRekening = "aaa";
		}
		if(checkBox_8.isSelected()){
			bayar[9].cek = 1;
		}else{
			bayar[9].cek = 0;
		}
		
		if(!Jumlah11.getText().equals("")&&!Jumlah11.getText().equals("Rp ")){
			String str = Jumlah11.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[10].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[10].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[10].Jumlah=-999;
		}
		if(!Tanggal11.getText().equals("")){
			bayar[10].Tanggal= Tanggal11.getText().toString();
		}else{
			bayar[10].Tanggal = "aaa";
		}
		if(!Bank11.getText().equals("")){
			bayar[10].Bank= Bank11.getText().toString();
		}else{
			bayar[10].Bank = "aaa";
		}
		if(!AN11.getText().equals("")){
			bayar[10].AtasNama= AN11.getText().toString();
		}else{
			bayar[10].AtasNama = "aaa";
		}
		if(!NoRek11.getText().equals("")){
			bayar[10].NoRekening= NoRek11.getText().toString();
		}else{
			bayar[10].NoRekening = "aaa";
		}
		if(checkBox_9.isSelected()){
			bayar[10].cek = 1;
		}else{
			bayar[10].cek = 0;
		}
		
		if(!Jumlah12.getText().equals("")&&!Jumlah12.getText().equals("Rp ")){
			String str = Jumlah12.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[11].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[11].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[11].Jumlah = -999;
		}
		if(!Tanggal12.getText().equals("")){
			bayar[11].Tanggal= Tanggal12.getText().toString();
		}else{
			bayar[11].Tanggal = "aaa";
		}
		if(!Bank11.getText().equals("")){
			bayar[11].Bank= Bank12.getText().toString();
		}else{
			bayar[11].Bank = "aaa";
		}
		if(!AN12.getText().equals("")){
			bayar[11].AtasNama= AN12.getText().toString();
		}else{
			bayar[11].AtasNama = "aaa";
		}
		if(!NoRek12.getText().equals("")){
			bayar[11].NoRekening= NoRek12.getText().toString();
		}else{
			bayar[11].NoRekening = "aaa";
		}
		if(checkBox_10.isSelected()){
			bayar[11].cek = 1;
		}else{
			bayar[11].cek = 0;
		}
		
		if(!Jumlah13.getText().equals("")&&!Jumlah13.getText().equals("Rp ")){
			String str = Jumlah13.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[12].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[12].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[12].Jumlah = -999;
		}
		if(!Tanggal13.getText().equals("")){
			bayar[12].Tanggal= Tanggal13.getText().toString();
		}else{
			bayar[12].Tanggal = "aaa";
		}
		if(!Bank13.getText().equals("")){
			bayar[12].Bank= Bank13.getText().toString();
		}else{
			bayar[12].Bank = "aaa";
		}
		if(!AN13.getText().equals("")){
			bayar[12].AtasNama= AN13.getText().toString();
		}else{
			bayar[12].AtasNama = "aaa";
		}
		if(!NoRek13.getText().equals("")){
			bayar[12].NoRekening= NoRek13.getText().toString();
		}else{
			bayar[12].NoRekening = "aaa";
		}
		if(checkBox_11.isSelected()){
			bayar[12].cek = 1;
		}else{
			bayar[12].cek = 0;
		}
		
		if(!Jumlah14.getText().equals("")&&!Jumlah14.getText().equals("Rp ")){
			String str = Jumlah14.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[13].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[13].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[13].Jumlah = -999;
		}
		if(!Tanggal14.getText().equals("")){
			bayar[13].Tanggal= Tanggal14.getText().toString();
		}else{
			bayar[13].Tanggal = "aaa";
		}
		if(!Bank14.getText().equals("")){
			bayar[13].Bank= Bank14.getText().toString();
		}else{
			bayar[13].Bank = "aaa";
		}
		if(!AN14.getText().equals("")){
			bayar[13].AtasNama= AN14.getText().toString();
		}else{
			bayar[13].AtasNama = "aaa";
		}
		if(!NoRek14.getText().equals("")){
			bayar[13].NoRekening= NoRek14.getText().toString();
		}else{
			bayar[13].NoRekening = "aaa";
		}
		if(checkBox_12.isSelected()){
			bayar[13].cek = 1;
		}else{
			bayar[13].cek = 0;
		}
		
		if(!Jumlah15.getText().equals("")&&!Jumlah15.getText().equals("Rp ")){
			String str = Jumlah15.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[14].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[14].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[14].Jumlah = -999;
		}
		if(!Tanggal15.getText().equals("")){
			bayar[14].Tanggal= Tanggal15.getText().toString();
		}else{
			bayar[14].Tanggal = "aaa";
		}
		if(!Bank15.getText().equals("")){
			bayar[14].Bank= Bank15.getText().toString();
		}else{
			bayar[14].Bank = "aaa";
		}
		if(!AN15.getText().equals("")){
			bayar[14].AtasNama= AN15.getText().toString();
		}else{
			bayar[14].AtasNama = "aaa";
		}
		if(!NoRek15.getText().equals("")){
			bayar[14].NoRekening= NoRek15.getText().toString();
		}else{
			bayar[14].NoRekening = "aaa";
		}
		if(checkBox_13.isSelected()){
			bayar[14].cek = 1;
		}else{
			bayar[14].cek = 0;
		}
		
		if(!Jumlah16.getText().equals("")&&!Jumlah16.getText().equals("Rp ")){
			String str = Jumlah16.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[15].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[15].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[15].Jumlah=-999;
		}
		if(!Tanggal16.getText().equals("")){
			bayar[15].Tanggal= Tanggal16.getText().toString();
		}else{
			bayar[15].Tanggal = "aaa";
		}
		if(!Bank16.getText().equals("")){
			bayar[15].Bank= Bank16.getText().toString();
		}else{
			bayar[15].Bank = "aaa";
		}
		if(!AN16.getText().equals("")){
			bayar[15].AtasNama= AN16.getText().toString();
		}else{
			bayar[15].AtasNama = "aaa";
		}
		if(!NoRek16.getText().equals("")){
			bayar[15].NoRekening= NoRek16.getText().toString();
		}else{
			bayar[15].NoRekening = "aaa";
		}
		if(checkBox_14.isSelected()){
			bayar[15].cek = 1;
		}else{
			bayar[15].cek = 0;
		}
		
		if(!Jumlah17.getText().equals("")&&!Jumlah17.getText().equals("Rp ")){
			String str = Jumlah17.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[16].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[16].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[16].Jumlah = -999;
		}
		if(!Tanggal17.getText().equals("")){
			bayar[16].Tanggal= Tanggal17.getText().toString();
		}else{
			bayar[16].Tanggal = "aaa";
		}
		if(!Bank17.getText().equals("")){
			bayar[16].Bank= Bank17.getText().toString();
		}else{
			bayar[16].Bank = "aaa";
		}
		if(!AN17.getText().equals("")){
			bayar[16].AtasNama= AN17.getText().toString();
		}else{
			bayar[16].AtasNama = "aaa";
		}
		if(!NoRek17.getText().equals("")){
			bayar[16].NoRekening= NoRek17.getText().toString();
		}else{
			bayar[16].NoRekening = "aaa";
		}
		if(checkBox_15.isSelected()){
			bayar[16].cek = 1;
		}else{
			bayar[16].cek = 0;
		}
		
		if(!Jumlah18.getText().equals("")&&!Jumlah18.getText().equals("Rp ")){
			String str = Jumlah18.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[17].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[17].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[17].Jumlah = -999;
		}
		if(!Tanggal18.getText().equals("")){
			bayar[17].Tanggal= Tanggal18.getText().toString();
		}else{
			bayar[17].Tanggal = "aaa";
		}
		if(!Bank18.getText().equals("")){
			bayar[17].Bank= Bank18.getText().toString();
		}else{
			bayar[17].Bank = "aaa";
		}
		if(!AN18.getText().equals("")){
			bayar[17].AtasNama= AN18.getText().toString();
		}else{
			bayar[17].AtasNama = "aaa";
		}
		if(!NoRek18.getText().equals("")){
			bayar[17].NoRekening= NoRek18.getText().toString();
		}else{
			bayar[17].NoRekening = "aaa";
		}
		if(checkBox_16.isSelected()){
			bayar[17].cek = 1;
		}else{
			bayar[17].cek = 0;
		}
		
		if(!Jumlah19.getText().equals("")&&!Jumlah19.getText().equals("Rp ")){
			String str = Jumlah19.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[18].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[18].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[18].Jumlah = -999;
		}
		if(!Tanggal19.getText().equals("")){
			bayar[18].Tanggal= Tanggal19.getText().toString();
		}else{
			bayar[18].Tanggal = "aaa";
		}
		if(!Bank19.getText().equals("")){
			bayar[18].Bank= Bank19.getText().toString();
		}else{
			bayar[18].Bank = "aaa";
		}
		if(!AN19.getText().equals("")){
			bayar[18].AtasNama= AN19.getText().toString();
		}else{
			bayar[18].AtasNama = "aaa";
		}
		if(!NoRek19.getText().equals("")){
			bayar[18].NoRekening= NoRek19.getText().toString();
		}else{
			bayar[18].NoRekening = "aaa";
		}
		if(checkBox_17.isSelected()){
			bayar[18].cek = 1;
		}else{
			bayar[18].cek = 0;
		}
		
		if(!Jumlah20.getText().equals("")&&!Jumlah20.getText().equals("Rp ")){
			String str = Jumlah20.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[19].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[19].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[19].Jumlah = -999;
		}
		if(!Tanggal20.getText().equals("")){
			bayar[19].Tanggal= Tanggal20.getText().toString();
		}else{
			bayar[19].Tanggal = "aaa";
		}
		if(!Bank10.getText().equals("")){
			bayar[19].Bank= Bank20.getText().toString();
		}else{
			bayar[19].Bank = "aaa";
		}
		if(!AN10.getText().equals("")){
			bayar[19].AtasNama= AN20.getText().toString();
		}else{
			bayar[19].AtasNama = "aaa";
		}
		if(!NoRek10.getText().equals("")){
			bayar[19].NoRekening= NoRek20.getText().toString();
		}else{
			bayar[19].NoRekening = "aaa";
		}
		if(checkBox_18.isSelected()){
			bayar[19].cek = 1;
		}else{
			bayar[19].cek = 0;
		}
		
		if(!Jumlah21.getText().equals("")&&!Jumlah21.getText().equals("Rp ")){
			String str = Jumlah21.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[20].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[20].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[20].Jumlah=-999;
		}
		if(!Tanggal21.getText().equals("")){
			bayar[20].Tanggal= Tanggal21.getText().toString();
		}else{
			bayar[20].Tanggal = "aaa";
		}
		if(!Bank21.getText().equals("")){
			bayar[20].Bank= Bank21.getText().toString();
		}else{
			bayar[20].Bank = "aaa";
		}
		if(!AN21.getText().equals("")){
			bayar[20].AtasNama= AN21.getText().toString();
		}else{
			bayar[20].AtasNama = "aaa";
		}
		if(!NoRek21.getText().equals("")){
			bayar[20].NoRekening= NoRek21.getText().toString();
		}else{
			bayar[20].NoRekening = "aaa";
		}
		if(checkBox_19.isSelected()){
			bayar[20].cek = 1;
		}else{
			bayar[20].cek = 0;
		}
		
		if(!Jumlah22.getText().equals("")&&!Jumlah22.getText().equals("Rp ")){
			String str = Jumlah22.getText().toString();
			String tmp = "";
			for(String tmp2: str.split("[.]")){
			// System.out.println(tmp2);
				tmp += tmp2;
			}
			
			if(tmp.substring(0,3).equals("Rp ")){
				str = tmp.substring(3,tmp.length());
				bayar[21].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}else{
				str = tmp;
				bayar[21].Jumlah = Integer.parseInt(str);
				//System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		}else{
			bayar[21].Jumlah = -999;
		}
		if(!Tanggal22.getText().equals("")){
			bayar[21].Tanggal= Tanggal22.getText().toString();
		}else{
			bayar[21].Tanggal = "aaa";
		}
		if(!Bank22.getText().equals("")){
			bayar[21].Bank= Bank22.getText().toString();
		}else{
			bayar[11].Bank = "aaa";
		}
		if(!AN22.getText().equals("")){
			bayar[21].AtasNama= AN22.getText().toString();
		}else{
			bayar[21].AtasNama = "aaa";
		}
		if(!NoRek22.getText().equals("")){
			bayar[21].NoRekening= NoRek22.getText().toString();
		}else{
			bayar[21].NoRekening = "aaa";
		}
		if(checkBox_20.isSelected()){
			bayar[21].cek = 1;
		}else{
			bayar[21].cek = 0;
		}
	}
}
