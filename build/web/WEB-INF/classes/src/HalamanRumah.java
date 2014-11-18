import java.awt.AWTException;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HalamanRumah extends JFrame {

	private JRadioButton rad1;
	private JRadioButton rad2;
	private JRadioButton rad3;
	private JPanel contentPane;
	private JTextField textKavling;
	private JTextField textNoRumah;
	private JTextField textLT;
	private JTextField textLB;
	private JTextField textHargaNett;
	private JTextField textStatus;
	private JTextField textKT;
	private JTextField textHargaM;
	private JTextField textHK;
	private JTextField textNama;
	private JTextField textAlamat;
	private JTextField textNoTelepon;
	private JTextField textTTL;
	private JTextField textPekerjaan;
	private JTextField textKTP;
	private JTextField textDisc1;
	private JTextField textDisc2;
	private JTextField textTanggal;
	private JTextField textTotalDisc;
	private JTextField textMarketing;
	private Rumah rumah;
	private Harga harga;
	private KelebihanTanah kelebihanTanah;
	private Pembeli pembeli;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HalamanRumah frame = new HalamanRumah();
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
	public HalamanRumah() {
		setTitle("Halaman Lengkap Data Rumah");
		
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
			
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 822, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(129, 21, 179, 158);
		contentPane.add(panel);

		rumah = MainRumah.rumahSimpan;
		pembeli = DataPembeli.pembeliSimpan;
		harga = DataHarga.hargaSimpan;
		kelebihanTanah = DataKelebihanTanah.kelebihanTanahSimpan;

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

		textKavling = new JTextField();
		textKavling.setText((String) null);
		textKavling.setEditable(false);
		textKavling.setColumns(10);
		textKavling.setBounds(71, 8, 98, 20);
		panel.add(textKavling);textKavling.setEditable(false);

		textNoRumah = new JTextField();
		textNoRumah.setText((String) null);
		textNoRumah.setEditable(false);
		textNoRumah.setColumns(10);
		textNoRumah.setBounds(71, 30, 98, 20);
		panel.add(textNoRumah);textNoRumah.setEditable(false);

		textLT = new JTextField();
		textLT.setText("0");
		textLT.setEditable(false);
		textLT.setColumns(10);
		textLT.setBounds(71, 55, 98, 20);
		panel.add(textLT);textLT.setEditable(false);

		textLB = new JTextField();
		textLB.setText("0");
		textLB.setEditable(false);
		textLB.setColumns(10);
		textLB.setBounds(71, 76, 98, 23);
		panel.add(textLB);
		textLB.setEditable(false);

		textHargaNett = new JTextField();
		textHargaNett.setText("Rp 0.");
		textHargaNett.setEditable(false);
		textHargaNett.setColumns(10);
		textHargaNett.setBounds(71, 105, 98, 20);
		panel.add(textHargaNett);textHargaNett.setEditable(false);

		textStatus = new JTextField();
		textStatus.setEditable(false);
		textStatus.setColumns(10);
		textStatus.setBounds(71, 127, 98, 20);
		panel.add(textStatus);textStatus.setEditable(false);

		if (!rumah.getTipe().equals(null)) {
			textKavling.setText(rumah.getTipe());
			textNoRumah.setText(rumah.getNoRumah());
			textLT.setText(rumah.getStrLT());
			textLB.setText(rumah.getStrLB());
			textHargaNett.setText(rumah.getStrHN());
			textStatus.setText(rumah.getStrIsBought(rumah.getIsBought()));
		}

		JLabel label_6 = new JLabel("Kelebihan Tanah");
		label_6.setBounds(456, 72, 79, 14);
		contentPane.add(label_6);

		textKT = new JTextField();
		textKT.setText("0");
		textKT.setColumns(10);
		textKT.setBounds(556, 69, 150, 20);
		contentPane.add(textKT);textKT.setEditable(false);

		textHargaM = new JTextField();
		textHargaM.setText("0");
		textHargaM.setColumns(10);
		textHargaM.setBounds(556, 97, 150, 20);
		contentPane.add(textHargaM); textHargaM.setEditable(false);

		JLabel label_7 = new JLabel("Harga / m");
		label_7.setBounds(456, 100, 79, 14);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("Harga kelebihan");
		label_8.setBounds(456, 128, 79, 14);
		contentPane.add(label_8);

		textHK = new JTextField();
		textHK.setEditable(false);
		textHK.setColumns(10);
		textHK.setBounds(556, 125, 150, 20);
		contentPane.add(textHK);
		textHK.setEditable(false);
		
		
		String sql = "SELECT * FROM `tabel_kelebihantanah` WHERE idRumah="+MainRumah.rumahSimpan.getIDRumah()+";";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.isBeforeFirst()){
				textHK.setText(kelebihanTanah.getStrHK());
				textHargaM.setText(kelebihanTanah.getStrHargaM());
				textKT.setText(kelebihanTanah.getStrKT());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel label_9 = new JLabel("Nama");
		label_9.setBounds(19, 237, 79, 14);
		contentPane.add(label_9);

		textNama = new JTextField();
		textNama.setColumns(10);
		textNama.setBounds(119, 234, 240, 20);
		contentPane.add(textNama);
		textNama.setEditable(false);

		textAlamat = new JTextField();
		textAlamat.setColumns(10);
		textAlamat.setBounds(119, 262, 240, 20);
		contentPane.add(textAlamat);
		textAlamat.setEditable(false);

		JLabel label_10 = new JLabel("No Telepon");
		label_10.setBounds(19, 293, 79, 14);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("Alamat");
		label_11.setBounds(19, 265, 79, 14);
		contentPane.add(label_11);

		textNoTelepon = new JTextField();
		textNoTelepon.setColumns(10);
		textNoTelepon.setBounds(119, 290, 240, 20);
		contentPane.add(textNoTelepon);
		textNoTelepon.setEditable(false);

		textTTL = new JTextField();
		textTTL.setColumns(10);
		textTTL.setBounds(119, 318, 240, 20);
		contentPane.add(textTTL);
		textTTL.setEditable(false);

		JLabel label_12 = new JLabel("TTL");
		label_12.setBounds(19, 321, 79, 14);
		contentPane.add(label_12);

		JLabel label_13 = new JLabel("Pekerjaan");
		label_13.setBounds(19, 347, 79, 14);
		contentPane.add(label_13);

		textPekerjaan = new JTextField();
		textPekerjaan.setColumns(10);
		textPekerjaan.setBounds(119, 344, 240, 20);
		contentPane.add(textPekerjaan);
		textPekerjaan.setEditable(false);

		JLabel label_14 = new JLabel("No KTP");
		label_14.setBounds(19, 375, 79, 14);
		contentPane.add(label_14);

		textKTP = new JTextField();
		textKTP.setColumns(10);
		textKTP.setBounds(119, 372, 240, 20);
		contentPane.add(textKTP);
		textKTP.setEditable(false);

		sql = "SELECT * FROM `tabel_pembeli` WHERE idRumah="+MainRumah.rumahSimpan.getIDRumah()+";";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.isBeforeFirst()){
				textNama.setText(pembeli.getNama());
				textAlamat.setText(pembeli.Alamat);
				textNoTelepon.setText(pembeli.NoTelepon);
				textTTL.setText(pembeli.TTL);
				textPekerjaan.setText(pembeli.Pekerjaan);
				textKTP.setText(pembeli.KTP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		JLabel lblDataKelebihanTanah = new JLabel("Data Kelebihan Tanah");
		lblDataKelebihanTanah.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataKelebihanTanah.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataKelebihanTanah.setBounds(456, 21, 250, 32);
		contentPane.add(lblDataKelebihanTanah);

		JLabel lblDataPembeli = new JLabel("Data Pembeli");
		lblDataPembeli.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataPembeli.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataPembeli.setBounds(19, 188, 340, 32);
		contentPane.add(lblDataPembeli);

		JLabel lblJenisPembayaran = new JLabel("Jenis Pembayaran");
		lblJenisPembayaran.setBounds(380, 223, 133, 14);
		contentPane.add(lblJenisPembayaran);

		rad1 = new JRadioButton("Cash");
		rad1.setBounds(529, 221, 56, 23);
		contentPane.add(rad1);

		rad2 = new JRadioButton("Soft-cash");
		rad2.setBounds(610, 220, 96, 23);
		contentPane.add(rad2);

		rad3 = new JRadioButton("KPR");
		rad3.setBounds(717, 220, 56, 23);
		contentPane.add(rad3);

		JLabel label_16 = new JLabel("Disc 1");
		label_16.setBounds(380, 251, 127, 14);
		contentPane.add(label_16);

		textDisc1 = new JTextField();
		textDisc1.setText("0");
		textDisc1.setColumns(10);
		textDisc1.setBounds(529, 251, 244, 20);
		contentPane.add(textDisc1); textDisc1.setEditable(false);

		JLabel label_17 = new JLabel("Disc 2");
		label_17.setBounds(380, 279, 127, 14);
		contentPane.add(label_17);

		textDisc2 = new JTextField();
		textDisc2.setText("0");
		textDisc2.setColumns(10);
		textDisc2.setBounds(529, 279, 244, 20);
		contentPane.add(textDisc2);
		textDisc2.setEditable(false);

		JLabel label_18 = new JLabel("Keterangan Disc 2");
		label_18.setBounds(380, 307, 127, 14);
		contentPane.add(label_18);

		JTextArea textAreaKeterangan = new JTextArea();
		textAreaKeterangan.setLineWrap(true);
		textAreaKeterangan.setBounds(529, 305, 244, 89);
		contentPane.add(textAreaKeterangan);
		textAreaKeterangan.setEditable(false);

		JLabel label_19 = new JLabel("Tanggal Booking");
		label_19.setBounds(380, 405, 127, 14);
		contentPane.add(label_19);

		textTanggal = new JTextField();
		textTanggal.setColumns(10);
		textTanggal.setBounds(529, 405, 244, 20);
		contentPane.add(textTanggal);
		textTanggal.setEditable(false);

		textTotalDisc = new JTextField();
		textTotalDisc.setEditable(false);
		textTotalDisc.setColumns(10);
		textTotalDisc.setBounds(529, 433, 244, 20);
		contentPane.add(textTotalDisc);
		textTotalDisc.setEditable(false);

		JLabel label_20 = new JLabel("Total Diskon");
		label_20.setBounds(380, 433, 127, 14);
		contentPane.add(label_20);

		JLabel label_21 = new JLabel("Nama Marketing");
		label_21.setBounds(380, 461, 127, 14);
		contentPane.add(label_21);

		textMarketing = new JTextField();
		textMarketing.setColumns(10);
		textMarketing.setBounds(529, 461, 244, 20);
		contentPane.add(textMarketing);
		textMarketing.setEditable(false);

		JLabel lblDataHarga = new JLabel("Data Harga");
		lblDataHarga.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataHarga.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataHarga.setBounds(380, 176, 393, 32);
		contentPane.add(lblDataHarga);
		
		JButton btnKembali = new JButton("Kembali ke Menu Rumah");
		btnKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MainRumah frameMain = new MainRumah();
				frameMain.setVisible(true);
			}
		});
		btnKembali.setBounds(456, 508, 194, 23);
		contentPane.add(btnKembali);
		
		JButton btnSavePicture = new JButton("Save Picture");
		btnSavePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Robot robot;
				try {
					Date dNow = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
					robot = new Robot();
					BufferedImage image = robot.createScreenCapture(new Rectangle(825, 580));
					ImageIO.write(image, "PNG", new FileOutputStream("D:/KotaBali/DataRumah/"+MainRumah.rumahSimpan.getTipe()+"-"+MainRumah.rumahSimpan.getStrID()+"_"+ft.format(dNow)+".png"));
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
		btnSavePicture.setBounds(270, 508, 115, 23);
		contentPane.add(btnSavePicture);
		
		sql = "SELECT * FROM `tabel_harga` WHERE idRumah="+MainRumah.rumahSimpan.getIDRumah()+";";
		try {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.isBeforeFirst()){
				textMarketing.setText(harga.NamaMarketing);
				textTotalDisc.setText(harga.getStrTotal());
				textDisc1.setText(harga.getStrDiskon1());
				textDisc2.setText(harga.getStrDiskon2());
				textAreaKeterangan.setText(harga.KeteranganDiskon2);
				setTipePembayaran(harga.TipePembayaran);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void setTipePembayaran(int tipe){
		if (tipe == 1){
			rad1.setSelected(true);
		}
		else if (tipe == 2){
			rad2.setSelected(true);
		}
		else if (tipe == 3){
			rad3.setSelected(true);
		}
	}
}