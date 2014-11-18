import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class MainRumah extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Kavling;
	private JTextField textField_noRumah;
	private JTextField textField_LT;
	private JTextField textField_LB;
	private JTextField textField_HA;
	private JTextField textField_Status;
	private Rumah rumah;
	private String Tipe;
	private String NoRumah;
	private int LT;
	private int LTAwal;
	private int LB;
	private int HargaAwal;
	private int HargaNett;
	private int IDRumah;
	private boolean isBought; // Kalau sudah di beli, jadi harganya di lock tergantung isBought ini
	private boolean isEdited; // Kalau sudah di edit sebelumnya, dia pengen ditandain kaya warna font berubah
	private boolean isLocked; // Kalau dikunci sama owner, cuma owner yang bisa buka lagi
	private int kodepembayaran;
	private JButton btnLock;
	private JButton btnUnlock;
	//tambahan
	//public static int kodepembayaran=1; //ini dummy
	
	public static String noRumahDariPeta;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;
	public static Rumah rumahSimpan; //buat nyimpan data rumah, tar si rumah edit di Peta
	public static Pembeli pembeli;
	public Harga harga;
	public static String marketing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainRumah frame = new MainRumah();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean isBought(){
		return this.rumah.getIsBought();
	}
	
	public boolean isKamboja(){
		return (this.rumah.getTipe().equals("Kamboja 1")||this.rumah.getTipe().equals("Kamboja 2"));
	}
	
	public void SetVisibility(){
		if(App.status==0){
			btnLock.setVisible(false);
			btnUnlock.setVisible(false);
		}
	}
	
	public void SetLocked(){
		if(rumahSimpan.getIsLocked()){
			btnUnlock.setVisible(true);
			btnLock.setVisible(false);
		}
		else if(!rumahSimpan.getIsLocked()){
			btnLock.setVisible(true);
			btnUnlock.setVisible(false);
		}
	}

	
	/**
	 * Create the frame.
	 */
	public MainRumah() {
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		setTitle("Menu Rumah");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 510, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		NoRumah = MainRumah.noRumahDariPeta;
		rumah = new Rumah(NoRumah);
		String sql = "SELECT * FROM `tabel_rumah` WHERE noRumah='"+rumah.getNoRumah()+"';";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				IDRumah = rs.getInt("idRumah");
				Tipe = rs.getString("tipeRumah");
				LT = rs.getInt("LT");
				LTAwal = rs.getInt("LTAwal");
				LB = rs.getInt("LB");
				HargaAwal = rs.getInt("HargaAwal");
				HargaNett = rs.getInt("HargaNett");
				isBought = rs.getBoolean("isBought");
				isEdited = rs.getBoolean("isEdited");
				isLocked = rs.getBoolean("isLocked");
				kodepembayaran = rs.getInt("idx_pembayaran");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rumah.setIDRumah(IDRumah);
		rumah.setTipe(Tipe);
		rumah.setLT(LT);
		rumah.LTAwal = LTAwal;
		rumah.setLB(LB);
		rumah.setHargaAwal(HargaAwal);
		rumah.setHargaNett(HargaNett);
		rumah.setIsBought(isBought);
		rumah.setIsEdited(isEdited);
		rumah.setIsLocked(isLocked);
		rumah.kodepembayaran = kodepembayaran;
		
		rumahSimpan = this.rumah;
		
		if(rumah.getIsBought()){
			pembeli = new Pembeli();
			
			sql = "SELECT `nama_marketing` FROM `tabel_harga` WHERE `idRumah`="+rumah.getIDRumah()+";";
			try {
				
				ResultSet rs = statement.executeQuery(sql);
				if (!rs.isBeforeFirst()){
					System.out.println("Tabel Kosong");
					//isKosong = true;
				}
				else{
					//isKosong = false;
					while(rs.next()){
						marketing = rs.getString("nama_marketing");
						}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 50, 179, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kavling");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNoRumah = new JLabel("No Rumah");
		lblNoRumah.setBounds(10, 33, 55, 14);
		panel.add(lblNoRumah);
		
		JLabel lblLb = new JLabel("LB");
		lblLb.setBounds(10, 80, 55, 14);
		panel.add(lblLb);
		
		JLabel lblLt = new JLabel("LT");
		lblLt.setBounds(10, 58, 46, 14);
		panel.add(lblLt);
		
		JLabel lblHarga = new JLabel("Harga");
		lblHarga.setBounds(10, 105, 55, 14);
		panel.add(lblHarga);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 130, 55, 14);
		panel.add(lblStatus);
		
		
		textField_Kavling = new JTextField();
		textField_Kavling.setBounds(71, 8, 98, 20);
		panel.add(textField_Kavling);
		textField_Kavling.setColumns(10);
		textField_Kavling.setEditable(false);
		
		textField_noRumah = new JTextField();
		textField_noRumah.setColumns(10);
		textField_noRumah.setBounds(71, 30, 98, 20);
		panel.add(textField_noRumah);
		textField_noRumah.setEditable(false);
		
		textField_LT = new JTextField();
		textField_LT.setColumns(10);
		textField_LT.setBounds(71, 55, 98, 20);
		panel.add(textField_LT);
		textField_LT.setEditable(false);
		
		textField_LB = new JTextField();
		textField_LB.setBounds(71, 76, 98, 23);
		panel.add(textField_LB);
		textField_LB.setColumns(10);
		textField_LB.setEditable(false);
		
		textField_HA = new JTextField();
		textField_HA.setColumns(10);
		textField_HA.setBounds(71, 105, 98, 20);
		panel.add(textField_HA);
		textField_HA.setEditable(false);
		
		textField_Status = new JTextField();
		textField_Status.setColumns(10);
		textField_Status.setBounds(71, 127, 98, 20);
		panel.add(textField_Status);
		textField_Status.setEditable(false);

		textField_Kavling.setText(rumah.getTipe());
		textField_noRumah.setText(rumah.getNoRumah());
		textField_LT.setText(rumah.getStrLT());
		textField_LB.setText(rumah.getStrLB());
		textField_HA.setText(rumah.getStrHN());
		if (rumah.getIsBought() == false){
			textField_Status.setText("Belum Terbeli");
		}
		else{
			textField_Status.setText("Terbeli");
		}

		
		JButton btnDataKelebihanTanah = new JButton("Data Kelebihan Tanah");
		btnDataKelebihanTanah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DataKelebihanTanah frameKelebihanTanah = new DataKelebihanTanah();
				frameKelebihanTanah.setVisible(true);
			}
		});
		btnDataKelebihanTanah.setBounds(241, 50, 222, 23);
		contentPane.add(btnDataKelebihanTanah);
		
		JButton btnDataPembeli = new JButton("Data Pembeli");
		btnDataPembeli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DataPembeli framePembeli = new DataPembeli();
				framePembeli.setVisible(true);
			}
		});
		btnDataPembeli.setBounds(241, 85, 222, 23);
		contentPane.add(btnDataPembeli);
		
		JButton btnDataPembayaranPembeli = new JButton("Data Pembayaran Pembeli");
		btnDataPembayaranPembeli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rumahSimpan.getIsBought()){
					if(kodepembayaran==1){
						setVisible(false);
						DataPembayaranPembeliCash framePembayaran = new DataPembayaranPembeliCash();
						framePembayaran.setVisible(true);
					}else if(kodepembayaran==3){
						setVisible(false);
						DataPembayaranPembeliKPR framePembayaran = new DataPembayaranPembeliKPR();
						framePembayaran.setVisible(true);
					}else if(kodepembayaran==2){
						setVisible(false);
						DataPembayaranPembeliSoftCash framePembayaran = new DataPembayaranPembeliSoftCash();
						framePembayaran.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "isi dulu data harga");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Rumah belum terbeli!!");
				}
			}
		});
		btnDataPembayaranPembeli.setBounds(241, 151, 222, 23);
		contentPane.add(btnDataPembayaranPembeli);
		
		JButton btnDataPembayaranPerusahaan = new JButton("Data Pembayaran Perusahaan");
		btnDataPembayaranPerusahaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rumahSimpan.getIsBought()){
					setVisible(false);
					DataPembayaranPerusahaan framePembayaranPerusahaan = new DataPembayaranPerusahaan();
					framePembayaranPerusahaan.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Rumah belum terbeli!!");
				}
			
			}
		});
		btnDataPembayaranPerusahaan.setBounds(241, 185, 222, 23);
		contentPane.add(btnDataPembayaranPerusahaan);
		
		JButton btnDataHarga = new JButton("Data Harga");
		btnDataHarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rumahSimpan.getIsBought()){
					setVisible(false);
					DataHarga frameHarga = new DataHarga();
					frameHarga.setVisible(true);
				}else{
				JOptionPane.showMessageDialog(null, "Rumah belum terbeli!!");
			}

			}
		});
		btnDataHarga.setBounds(241, 119, 222, 23);
		contentPane.add(btnDataHarga);
		
		JLabel lblAndaMasukSebagai = new JLabel("Anda masuk sebagai :" +App.LoginID);
		lblAndaMasukSebagai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAndaMasukSebagai.setBounds(163, 11, 263, 14);
		contentPane.add(lblAndaMasukSebagai);
		
		JButton btnKembaliKePeta = new JButton("Kembali ke peta");
		btnKembaliKePeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKembaliKePeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				PetaAwal framePeta = new PetaAwal();
				framePeta.setVisible(true);
			}
		});
		btnKembaliKePeta.setBounds(313, 266, 140, 35);
		contentPane.add(btnKembaliKePeta);
		
		btnLock = new JButton("Lock");
		btnLock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE `tabel_rumah` SET `isLocked` = 1 WHERE idRumah = "+rumah.getIDRumah()+";";
				try {
					statement.executeUpdate(sql);
					rumahSimpan.setIsLocked(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnLock.setVisible(false);
				btnUnlock.setVisible(true);
			}
		});
		btnLock.setBounds(67, 267, 105, 34);
		contentPane.add(btnLock);
		
		btnUnlock = new JButton("Unlock");
		btnUnlock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE `tabel_rumah` SET `isLocked` = 0 WHERE idRumah = "+rumah.getIDRumah()+";";
				try {
					int test = statement.executeUpdate(sql);
					rumahSimpan.setIsLocked(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnUnlock.setVisible(false);
				btnLock.setVisible(true);
			}
		});

		btnUnlock.setBounds(67, 266, 105, 34);
		contentPane.add(btnUnlock);
		
		JButton btnLayarDataRumah = new JButton("Data Lengkap Rumah");
		btnLayarDataRumah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				HalamanRumah frameBaru = new HalamanRumah();
				frameBaru.setVisible(true);
			}
		});
		btnLayarDataRumah.setBounds(241, 219, 222, 23);
		contentPane.add(btnLayarDataRumah);
		
		JButton btnNewButton = new JButton("Ganti Tipe Rumah");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder sb = new StringBuilder();
				if (!isBought()&&isKamboja()){
					DbConnector dbConnector = new DbConnector();
					try {
						dbConnector.changeType(rumah.getTipe(), rumah.getIDRumah());
						
						//ubah data di textfield
						if(rumah.getTipe().equals("Kamboja 1")){
							textField_Kavling.setText("Kamboja 2");
							rumah.setTipe("Kamboja 2");
						}else{//pasti kamboja 2
							textField_Kavling.setText("Kamboja 1");
							rumah.setTipe("Kamboja 1");
						}
						textField_Kavling.setText(rumah.getTipe());
						textField_noRumah.setText(rumah.getNoRumah());
						textField_LT.setText(rumah.getStrLT());
						textField_LB.setText(rumah.getStrLB());
						textField_HA.setText(rumah.getStrHN());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					if (!isKamboja()){
						sb.append("Tipe rumah bukan Kamboja! Tidak dapat mengganti tipe Rumah!");
					}
					if (isBought()){
						sb.append("Status rumah sudah terbeli! Hapus data pembeli dahulu!");
					}
					JOptionPane.showMessageDialog(null, sb.toString());
				}
			}
		});
		btnNewButton.setBounds(32, 219, 158, 23);
		contentPane.add(btnNewButton);
		
//		JButton btnNewButton = new JButton("Data Lengkap Pembayaran");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				setVisible(false);
//				HalamanPembayaran frameBaru = new HalamanPembayaran();
//				frameBaru.setvisibility(true);
//			}
//		});
//		btnNewButton.setBounds(241, 253, 222, 23);
//		contentPane.add(btnNewButton);
		
		SetLocked();
		SetVisibility();
	}
}