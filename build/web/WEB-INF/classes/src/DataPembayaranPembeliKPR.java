import java.awt.AWTException;
import java.awt.Color;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DataPembayaranPembeliKPR extends JFrame {

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

	private JTextField No6;
	private JTextField Pembayaran6;
	private JTextField Jumlah6;
	private JTextField Bank6;
	private JTextField AN6;
	private JTextField NoRek6;
	private JTextField Tanggal6;

	private JTextField No7;
	private JTextField Pembayaran7;
	private JTextField Jumlah7;
	private JTextField Bank7;
	private JTextField AN7;
	private JTextField NoRek7;
	private JTextField Tanggal7;

	private JTextField No8;
	private JTextField Pembayaran8;
	private JTextField Jumlah8;
	private JTextField Bank8;
	private JTextField AN8;
	private JTextField NoRek8;
	private JTextField Tanggal8;

	private JTextField No9;
	private JTextField Pembayaran9;
	private JTextField Jumlah9;
	private JTextField Bank9;
	private JTextField AN9;
	private JTextField NoRek9;
	private JTextField Tanggal9;

	private JTextField Tanggal1;
	private JTextField Tanggal2;
	private JTextField Tanggal3;
	private JTextField Tanggal4;
	private JTextField Tanggal5;
	private JButton btnKembaliKeMenu;
	private JButton btnSave;
	private JButton btnDelete;
	private JTextField textField_6;
	private JTextField textField_7;
	private String sql;
	private ResultSet rs;
	private boolean isKosong;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;

	// tambahan variabel
	public Pembayaran[] bayar;
	int nomor[] = new int[9];
	int jmlacc;
	String bankacc;
	private final JCheckBox checkBox1 = new JCheckBox("");
	private final JCheckBox checkBox2;
	private final JCheckBox checkBox3;
	private final JCheckBox checkBox4;
	private final JCheckBox checkBox5;
	private final JCheckBox checkBox6;
	private final JCheckBox checkBox7;
	private final JCheckBox checkBox8;
	private final JCheckBox checkBox9;

	private final JLabel lblCheck;
	private JTextField textField_Total;
	private JTextField textField_StatusTotal;
	private int TotalJumlah;
	private boolean StatusTotal;

	private Date dNow = new Date();
	private SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataPembayaranPembeliKPR frame = new DataPembayaranPembeliKPR();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setEditable() {
		if (MainRumah.rumahSimpan.getIsLocked()) {
			btnSave.setVisible(false);
			btnSave.setEnabled(false);
			btnDelete.setVisible(false);
			btnDelete.setEnabled(false);
		}
	}

	// tambahan
	public String convertHarga(int harga) { // jadi tar kalo 50000 jadi 50.000
											// dst...
		// harga = 444;
		int ribuan[] = new int[10];
		int counter = 0;
		String temphasil = "";

		while (harga / 1000 != 0) {
			ribuan[counter] = harga % 1000;
			counter++;
			// temphasil = temphasil + ribuan+".";

			harga = harga / 1000; // dicari lagi sisanya
		}
		// dimasukin ke string
		temphasil = harga + ".";

		for (int i = counter - 1; i >= 0; i--) {
			// udah sisa ratusan
			if (i != 0) {
				if (ribuan[i] == 0) {// sisa harga 0
					temphasil = temphasil + "000" + ".";
				} else if (ribuan[i] < 10) { // sisa harga satuan
					temphasil = temphasil + "00" + ribuan[i] + ".";
				} else if (ribuan[i] < 100) { // sisa harga puluhan
					temphasil = temphasil + "0" + ribuan[i] + ".";
				} else {// sisa harga ratusan
					temphasil = temphasil + ribuan[i] + ".";
				}
			} else {
				if (ribuan[i] == 0) {// sisa harga 0
					temphasil = temphasil + "000";
				} else if (ribuan[i] < 10) { // sisa harga satuan
					temphasil = temphasil + "00" + ribuan[i];
				} else if (ribuan[i] < 100) { // sisa harga puluhan
					temphasil = temphasil + "0" + ribuan[i];
				} else {// sisa harga ratusan
					temphasil = temphasil + ribuan[i];
				}
			}

		}
		return temphasil;
	}

	public void CbVisibility() {
		if (App.status == 0) {
			checkBox1.setVisible(false);
			checkBox2.setVisible(false);
			checkBox3.setVisible(false);
			checkBox4.setVisible(false);
			checkBox5.setVisible(false);
			checkBox6.setVisible(false);
			checkBox7.setVisible(false);
			checkBox8.setVisible(false);
			checkBox9.setVisible(false);

			lblCheck.setVisible(false);

		}
	}

	/**
	 * Create the frame.
	 */
	public DataPembayaranPembeliKPR() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = conn.createStatement();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setTitle("Pembayaran KPR");
		// System.out.println(App.tes);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1224, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(476, 11, 179, 158);
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
		panel.add(textField_2);
		textField_2.setEditable(false);

		textField_3 = new JTextField(MainRumah.rumahSimpan.getStrLT());
		textField_3.setColumns(10);
		textField_3.setBounds(71, 55, 98, 20);
		panel.add(textField_3);
		textField_3.setEditable(false);

		textField_4 = new JTextField(MainRumah.rumahSimpan.getStrHN());
		textField_4.setColumns(10);
		textField_4.setBounds(71, 105, 98, 20);
		panel.add(textField_4);
		textField_4.setEditable(false);

		textField_5 = new JTextField();
		if (MainRumah.rumahSimpan.getIsBought() == false) {
			textField_5.setText("Belum Terbeli");
		} else {
			textField_5.setText("Terbeli");
		}
		textField_5.setColumns(10);
		textField_5.setBounds(71, 127, 98, 20);
		panel.add(textField_5);
		textField_5.setEditable(false);

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
		Pembayaran1.setText("Booking");
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
		Pembayaran2.setText("DP 1");
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
		Pembayaran3.setText("DP 2");
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
		Pembayaran4.setText("DP 3");
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
		Pembayaran5.setText("DP 4");
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

		No6 = new JTextField();
		No6.setText("6");
		No6.setColumns(10);
		No6.setBounds(20, 375, 23, 20);
		contentPane.add(No6);

		Pembayaran6 = new JTextField();
		Pembayaran6.setText("DP 5");
		Pembayaran6.setColumns(10);
		Pembayaran6.setBounds(53, 375, 173, 20);
		contentPane.add(Pembayaran6);

		Jumlah6 = new JTextField();
		Jumlah6.setColumns(10);
		Jumlah6.setBounds(236, 375, 139, 20);
		contentPane.add(Jumlah6);

		Bank6 = new JTextField();
		Bank6.setColumns(10);
		Bank6.setBounds(496, 375, 137, 20);
		contentPane.add(Bank6);

		AN6 = new JTextField();
		AN6.setColumns(10);
		AN6.setBounds(643, 375, 274, 20);
		contentPane.add(AN6);

		NoRek6 = new JTextField();
		NoRek6.setColumns(10);
		NoRek6.setBounds(927, 375, 217, 20);
		contentPane.add(NoRek6);

		Tanggal6 = new JTextField();
		Tanggal6.setColumns(10);
		Tanggal6.setBounds(385, 375, 101, 20);
		contentPane.add(Tanggal6);

		checkBox6 = new JCheckBox("");
		checkBox6.setBounds(1150, 368, 23, 31);
		contentPane.add(checkBox6);

		No7 = new JTextField();
		No7.setText("7");
		No7.setColumns(10);
		No7.setBounds(20, 406, 23, 20);
		contentPane.add(No7);

		Pembayaran7 = new JTextField();
		Pembayaran7.setText("DP 6");
		Pembayaran7.setColumns(10);
		Pembayaran7.setBounds(53, 406, 173, 20);
		contentPane.add(Pembayaran7);

		Jumlah7 = new JTextField();
		Jumlah7.setColumns(10);
		Jumlah7.setBounds(237, 406, 139, 20);
		contentPane.add(Jumlah7);

		Bank7 = new JTextField();
		Bank7.setColumns(10);
		Bank7.setBounds(497, 406, 137, 20);
		contentPane.add(Bank7);

		AN7 = new JTextField();
		AN7.setColumns(10);
		AN7.setBounds(643, 406, 274, 20);
		contentPane.add(AN7);

		NoRek7 = new JTextField();
		NoRek7.setColumns(10);
		NoRek7.setBounds(927, 406, 217, 20);
		contentPane.add(NoRek7);

		Tanggal7 = new JTextField();
		Tanggal7.setColumns(10);
		Tanggal7.setBounds(385, 406, 101, 20);
		contentPane.add(Tanggal7);

		checkBox7 = new JCheckBox("");
		checkBox7.setBounds(1150, 400, 23, 31);
		contentPane.add(checkBox7);

		No8 = new JTextField();
		No8.setText("8");
		No8.setColumns(10);
		No8.setBounds(20, 437, 23, 20);
		contentPane.add(No8);

		Pembayaran8 = new JTextField();
		Pembayaran8.setText("Akad Kredit");
		Pembayaran8.setColumns(10);
		Pembayaran8.setBounds(53, 437, 173, 20);
		contentPane.add(Pembayaran8);

		Jumlah8 = new JTextField();
		Jumlah8.setColumns(10);
		Jumlah8.setBounds(237, 437, 139, 20);
		contentPane.add(Jumlah8);

		Bank8 = new JTextField();
		Bank8.setColumns(10);
		Bank8.setBounds(497, 437, 137, 20);
		contentPane.add(Bank8);

		AN8 = new JTextField();
		AN8.setColumns(10);
		AN8.setBounds(643, 437, 274, 20);
		contentPane.add(AN8);

		NoRek8 = new JTextField();
		NoRek8.setColumns(10);
		NoRek8.setBounds(927, 437, 217, 20);
		contentPane.add(NoRek8);

		Tanggal8 = new JTextField();
		Tanggal8.setColumns(10);
		Tanggal8.setBounds(385, 437, 101, 20);
		contentPane.add(Tanggal8);

		checkBox8 = new JCheckBox("");
		checkBox8.setBounds(1150, 431, 23, 31);
		contentPane.add(checkBox8);

		No9 = new JTextField();
		No9.setText("9");
		No9.setColumns(10);
		No9.setBounds(20, 468, 23, 20);
		contentPane.add(No9);

		Pembayaran9 = new JTextField();
		Pembayaran9.setText("Retensi");
		Pembayaran9.setColumns(10);
		Pembayaran9.setBounds(53, 468, 173, 20);
		contentPane.add(Pembayaran9);

		Jumlah9 = new JTextField();
		Jumlah9.setColumns(10);
		Jumlah9.setBounds(237, 468, 139, 20);
		contentPane.add(Jumlah9);

		Bank9 = new JTextField();
		Bank9.setColumns(10);
		Bank9.setBounds(497, 468, 137, 20);
		contentPane.add(Bank9);

		AN9 = new JTextField();
		AN9.setColumns(10);
		AN9.setBounds(643, 468, 274, 20);
		contentPane.add(AN9);

		NoRek9 = new JTextField();
		NoRek9.setColumns(10);
		NoRek9.setBounds(927, 468, 217, 20);
		contentPane.add(NoRek9);

		Tanggal9 = new JTextField();
		Tanggal9.setColumns(10);
		Tanggal9.setBounds(385, 468, 101, 20);
		contentPane.add(Tanggal9);

		checkBox9 = new JCheckBox("");
		checkBox9.setBounds(1150, 460, 23, 31);
		contentPane.add(checkBox9);

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
		btnKembaliKeMenu.setBounds(475, 568, 174, 23);
		contentPane.add(btnKembaliKeMenu);

		JLabel lblBank_1 = new JLabel("Bank");
		lblBank_1.setBounds(19, 515, 46, 14);
		contentPane.add(lblBank_1);

		textField_6 = new JTextField();
		textField_6.setBounds(143, 512, 150, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblJumlahAcc = new JLabel("Jumlah Acc");
		lblJumlahAcc.setBounds(19, 538, 84, 14);
		contentPane.add(lblJumlahAcc);

		textField_7 = new JTextField();
		textField_7.setBounds(143, 535, 150, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveValue(); // pindahin nilai textfield ke array lagi
				String sql;
				boolean ok = true;

				if (isKosong) {// insert baru
					for (int i = 0; i < 9; i++) {
						try {
							sql = "INSERT INTO `tabel_kpr`(`idRumah`, `no`, `pembayaran`, `Jumlah`, `tanggal`, `bank`, `atas_nama`, `no_rek`, `isChecked`,`bank_acc`,`jumlah_acc`) VALUES ("
									+ MainRumah.rumahSimpan.getIDRumah()
									+ ","
									+ (i + 1)
									+ ",'"
									+ bayar[i].Pembayaran
									+ "',"
									+ bayar[i].Jumlah
									+ ",'"
									+ bayar[i].Tanggal
									+ "','"
									+ bayar[i].Bank
									+ "','"
									+ bayar[i].AtasNama
									+ "','"
									+ bayar[i].NoRekening
									+ "', "
									+ bayar[i].cek
									+ ",'"
									+ bankacc
									+ "',"
									+ jmlacc + ")";
							statement.executeUpdate(sql);

						} catch (SQLException se) {
							se.printStackTrace();
							ok = false;
							break;
						}
					}
					try {
						// update ke history edit
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"
								+ MainRumah.pembeli.Nama
								+ "','"
								+ ft.format(dNow)
								+ "','"
								+ Jumlah1.getText().toString()
								+ "','"
								+ MainRumah.rumahSimpan.getTipe()
								+ "','"
								+ MainRumah.rumahSimpan.getNoRumah()
								+ "','"
								+ MainRumah.marketing
								+ "','data pembayaran KPR baru')";
						statement.executeUpdate(sql);
						// JOptionPane.showMessageDialog(null,
						// "update tabel berhasi1!!");

					} catch (SQLException se) {
						se.printStackTrace();
						ok = false;

					}

				} else {
					for (int i = 0; i < 9; i++) {
						try {
							sql = "UPDATE `tabel_kpr` SET `jumlah` = "
									+ bayar[i].Jumlah + ",`tanggal`='"
									+ bayar[i].Tanggal + "',`bank`= '"
									+ bayar[i].Bank + "',`atas_nama`= '"
									+ bayar[i].AtasNama + "',`no_rek`= '"
									+ bayar[i].NoRekening + "',`isChecked`= "
									+ bayar[i].cek + ", `bank_acc`='" + bankacc
									+ "', `jumlah_acc`= " + jmlacc
									+ " WHERE `pembayaran`= '"
									+ bayar[i].Pembayaran + "'";
							statement.executeUpdate(sql);

							// JOptionPane.showMessageDialog(null,
							// "update tabel berhasi1!!");

						} catch (SQLException se) {
							se.printStackTrace();
							ok = false;
							break;
						}
					}
					try {
						// update ke history edit
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"
								+ MainRumah.pembeli.Nama
								+ "','"
								+ ft.format(dNow)
								+ "','"
								+ Jumlah1.getText().toString()
								+ "','"
								+ MainRumah.rumahSimpan.getTipe()
								+ "','"
								+ MainRumah.rumahSimpan.getNoRumah()
								+ "','"
								+ MainRumah.marketing
								+ "','update data pembayaran KPR')";
						statement.executeUpdate(sql);
						// JOptionPane.showMessageDialog(null,
						// "update tabel berhasi1!!");

					} catch (SQLException se) {
						se.printStackTrace();
						ok = false;

					}
				}

				if (ok) {
					JOptionPane.showMessageDialog(null, "Update berhasil!");
					setVisible(false);
					MainRumah frameMain = new MainRumah();
					frameMain.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Update gagal!");
				}

			}
		});
		btnSave.setBounds(659, 568, 139, 23);
		contentPane.add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Object[] option = { "Hapus", "Tunda" };
					int op = JOptionPane.showOptionDialog(null,
							"Data akan dihapus. Teruskan? ",
							"Konfirmasi Jawaban", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, option,
							option[0]);

					if (op == 0) {
						String sql1;
						sql1 = "DELETE FROM `tabel_kpr` WHERE `idRumah`="
								+ MainRumah.rumahSimpan.getIDRumah();
						statement.executeUpdate(sql1);

						// update ke history edit
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"
								+ MainRumah.pembeli.Nama
								+ "','"
								+ ft.format(dNow)
								+ "','"
								+ Jumlah1.getText().toString()
								+ "','"
								+ MainRumah.rumahSimpan.getTipe()
								+ "','"
								+ MainRumah.rumahSimpan.getNoRumah()
								+ "','"
								+ MainRumah.marketing
								+ "','data pembayaran KPR dihapus')";
						statement.executeUpdate(sql);

						JOptionPane.showMessageDialog(null,
								"Data berhasil dihapus");
						setVisible(false);
						MainRumah frameMain = new MainRumah();
						frameMain.setVisible(true);
					}

				} catch (SQLException se) {
					se.printStackTrace();
					JOptionPane.showMessageDialog(null, "Data gagal dihapus");

				}
			}
		});
		btnDelete.setBounds(329, 568, 139, 23);
		// btnEdit.setVisible(false);
		contentPane.add(btnDelete);

		JButton btnNewButton = new JButton("Save Picture");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Robot robot;
				try {
					robot = new Robot();
					BufferedImage image = robot
							.createScreenCapture(new Rectangle(1350, 750));
					ImageIO.write(image, "PNG", new FileOutputStream(
							"D:/KotaBali/Pembayaran Pembeli/"
									+ MainRumah.rumahSimpan.getTipe() + "-"
									+ MainRumah.rumahSimpan.getStrID() + "_"
									+ ft.format(dNow) + ".png"));
					JOptionPane.showMessageDialog(null,
							"Gambar berhasil disimpan!!");
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(1031, 568, 139, 23);
		contentPane.add(btnNewButton);

		lblCheck = new JLabel("check");
		lblCheck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheck.setBounds(1154, 183, 40, 26);
		contentPane.add(lblCheck);
		checkBox1.setBounds(1150, 209, 21, 31);
		contentPane.add(checkBox1);

		checkBox2 = new JCheckBox("");
		checkBox2.setBounds(1150, 240, 23, 31);
		contentPane.add(checkBox2);

		checkBox3 = new JCheckBox("");
		checkBox3.setBounds(1150, 274, 23, 31);
		contentPane.add(checkBox3);

		checkBox4 = new JCheckBox("");
		checkBox4.setBounds(1150, 302, 23, 31);
		contentPane.add(checkBox4);

		checkBox5 = new JCheckBox("");
		checkBox5.setBounds(1150, 336, 23, 31);
		contentPane.add(checkBox5);

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

		CbVisibility();

		bayar = new Pembayaran[9];
		try {

			sql = "SELECT * FROM `tabel_kpr` WHERE `idRumah`="
					+ MainRumah.rumahSimpan.getIDRumah();
			rs = statement.executeQuery(sql);
			if (!rs.isBeforeFirst()) {
				System.out.println("Tabel Kosong");
				isKosong = true;

				TotalJumlah = 0;
				textField_Total.setText("Rp " + this.convertHarga(TotalJumlah));
				setStatusTotal();

				bayar[0] = new Pembayaran("Booking", -999, "aaa", "aaa", "aaa",	"aaa", 0);
				bayar[1] = new Pembayaran("DP 1", -999, "aaa", "aaa", "aaa","aaa", 0);
				bayar[2] = new Pembayaran("DP 2", -999, "aaa", "aaa", "aaa","aaa", 0);
				bayar[3] = new Pembayaran("DP 3", -999, "aaa", "aaa", "aaa","aaa", 0);
				bayar[4] = new Pembayaran("DP 4", -999, "aaa", "aaa", "aaa","aaa", 0);
				bayar[5] = new Pembayaran("DP 5", -999, "aaa", "aaa", "aaa","aaa", 0);
				bayar[6] = new Pembayaran("DP 6", -999, "aaa", "aaa", "aaa","aaa", 0);
				bayar[7] = new Pembayaran("Akad Kredit", -999, "aaa", "aaa","aaa", "aaa", 0);
				bayar[8] = new Pembayaran("Retensi", -999, "aaa", "aaa", "aaa",	"aaa", 0);

				bankacc = "aaa";
				jmlacc = -999;
			}

			else {
				isKosong = false;
				int i = 0;
				TotalJumlah = 0;
				String jpem;
				int jml;
				String bank;
				String tgl;
				String atasnama;
				String norek;
				int cek;
				while (rs.next()) {
					nomor[i] = rs.getInt("no");
					jpem = rs.getString("pembayaran");
					jml = rs.getInt("Jumlah");
					tgl = rs.getString("tanggal");
					bank = rs.getString("bank");
					atasnama = rs.getString("atas_nama");
					norek = rs.getString("no_rek");
					cek = rs.getInt("isChecked");
					bankacc = rs.getString("bank_acc");
					jmlacc = rs.getInt("jumlah_acc");

					// taruh di kelas
					bayar[i] = new Pembayaran(jpem, jml, tgl, bank, atasnama,norek, cek);
					i++;
				}
			}
			int j = 1;
			while (j <= 1) {
				switch (j) {
				case 1:
					if (bayar[0].Jumlah != -999) {
						TotalJumlah = TotalJumlah + bayar[0].Jumlah;
						Jumlah1.setText("Rp "
								+ this.convertHarga(bayar[0].Jumlah));
					} else {
						Jumlah1.setText("Rp ");
					}
					if (!bayar[0].Tanggal.equals("aaa")) {
						Tanggal1.setText(bayar[0].Tanggal);
					}
					if (!bayar[0].Bank.equals("aaa")) {
						Bank1.setText(bayar[0].Bank);
					}
					if (!bayar[0].AtasNama.equals("aaa")) {
						AN1.setText(bayar[0].AtasNama);
					}
					if (!bayar[0].NoRekening.equals("aaa")) {
						NoRek1.setText(bayar[0].NoRekening);
					}
					if (bayar[0].cek == 1) {
						checkBox1.setSelected(true);
					}
					Pembayaran1.setText(bayar[0].Pembayaran);

					// break;
				case 2:
					Pembayaran2.setText(bayar[1].Pembayaran);
					if (bayar[1].Jumlah != -999) {
						TotalJumlah = TotalJumlah + bayar[1].Jumlah;
						Jumlah2.setText("Rp "
								+ this.convertHarga(bayar[1].Jumlah));
					} else {
						Jumlah2.setText("Rp ");
					}
					if (!bayar[1].Tanggal.equals("aaa")) {
						Tanggal2.setText(bayar[1].Tanggal);
					}
					if (!bayar[1].Bank.equals("aaa")) {
						Bank2.setText(bayar[1].Bank);
					}
					if (!bayar[1].AtasNama.equals("aaa")) {
						AN2.setText(bayar[1].AtasNama);
					}
					if (!bayar[1].NoRekening.equals("aaa")) {
						NoRek2.setText(bayar[1].NoRekening);
					}
					if (bayar[1].cek == 1) {
						checkBox2.setSelected(true);
					}
					// break;
				case 3:
					Pembayaran3.setText(bayar[2].Pembayaran);
					if (bayar[2].Jumlah != -999) {
						TotalJumlah = TotalJumlah + bayar[2].Jumlah;
						Jumlah3.setText("Rp "
								+ this.convertHarga(bayar[2].Jumlah));
					} else {
						Jumlah3.setText("Rp ");
					}
					if (!bayar[2].Tanggal.equals("aaa")) {
						Tanggal3.setText(bayar[2].Tanggal);
					}
					if (!bayar[2].Bank.equals("aaa")) {
						Bank3.setText(bayar[2].Bank);
					}
					if (!bayar[2].AtasNama.equals("aaa")) {
						AN3.setText(bayar[2].AtasNama);
					}
					if (!bayar[2].NoRekening.equals("aaa")) {
						NoRek3.setText(bayar[2].NoRekening);
					}
					if (bayar[2].cek == 1) {
						checkBox3.setSelected(true);
					}
					// break;
				case 4:
					Pembayaran4.setText(bayar[3].Pembayaran);
					if (bayar[3].Jumlah != -999) {
						TotalJumlah = TotalJumlah + bayar[3].Jumlah;
						Jumlah4.setText("Rp "
								+ this.convertHarga(bayar[3].Jumlah));
					} else {
						Jumlah4.setText("Rp ");
					}
					if (!bayar[3].Tanggal.equals("aaa")) {
						Tanggal4.setText(bayar[3].Tanggal);
					}
					if (!bayar[3].Bank.equals("aaa")) {
						Bank4.setText(bayar[3].Bank);
					}
					if (!bayar[3].AtasNama.equals("aaa")) {
						AN4.setText(bayar[3].AtasNama);
					}
					if (!bayar[3].NoRekening.equals("aaa")) {
						NoRek4.setText(bayar[3].NoRekening);
					}
					if (bayar[3].cek == 1) {
						checkBox4.setSelected(true);
					}
					if (jmlacc != -999) {
						textField_7.setText("Rp " + convertHarga(jmlacc));
					}
					if (!bankacc.equals("aaa")) {
						textField_6.setText(bankacc);
					}
					// break;
				case 5:
					Pembayaran5.setText(bayar[4].Pembayaran);
					if (bayar[4].Jumlah != -999) {
						TotalJumlah = TotalJumlah + bayar[4].Jumlah;
						Jumlah5.setText("Rp "
								+ this.convertHarga(bayar[4].Jumlah));
					} else {
						Jumlah5.setText("Rp ");
					}
					if (!bayar[4].Tanggal.equals("aaa")) {
						Tanggal5.setText(bayar[4].Tanggal);
					}
					if (!bayar[4].Bank.equals("aaa")) {
						Bank5.setText(bayar[4].Bank);
					}
					if (!bayar[4].AtasNama.equals("aaa")) {
						AN5.setText(bayar[4].AtasNama);
					}
					if (!bayar[4].NoRekening.equals("aaa")) {
						NoRek5.setText(bayar[4].NoRekening);
					}
					if (bayar[4].cek == 1) {
						checkBox5.setSelected(true);
					}

				case 6:
					Pembayaran6.setText(bayar[5].Pembayaran);
					if (bayar[5].Jumlah != -999) {
						TotalJumlah = TotalJumlah + bayar[5].Jumlah;
						Jumlah6.setText("Rp "
								+ this.convertHarga(bayar[5].Jumlah));
					} else {
						Jumlah6.setText("Rp ");
					}
					if (!bayar[5].Tanggal.equals("aaa")) {
						Tanggal6.setText(bayar[5].Tanggal);
					}
					if (!bayar[5].Bank.equals("aaa")) {
						Bank6.setText(bayar[5].Bank);
					}
					if (!bayar[5].AtasNama.equals("aaa")) {
						AN6.setText(bayar[5].AtasNama);
					}
					if (!bayar[5].NoRekening.equals("aaa")) {
						NoRek6.setText(bayar[5].NoRekening);
					}
					if (bayar[5].cek == 1) {
						checkBox6.setSelected(true);
					}

				case 7:
					Pembayaran7.setText(bayar[6].Pembayaran);
					if (bayar[6].Jumlah != -999) {
						TotalJumlah = TotalJumlah + bayar[6].Jumlah;
						Jumlah7.setText("Rp "
								+ this.convertHarga(bayar[6].Jumlah));
					} else {
						Jumlah7.setText("Rp ");
					}
					if (!bayar[6].Tanggal.equals("aaa")) {
						Tanggal7.setText(bayar[6].Tanggal);
					}
					if (!bayar[6].Bank.equals("aaa")) {
						Bank7.setText(bayar[6].Bank);
					}
					if (!bayar[6].AtasNama.equals("aaa")) {
						AN7.setText(bayar[6].AtasNama);
					}
					if (!bayar[6].NoRekening.equals("aaa")) {
						NoRek7.setText(bayar[6].NoRekening);
					}
					if (bayar[6].cek == 1) {
						checkBox7.setSelected(true);
					}

				case 8:
					Pembayaran8.setText(bayar[7].Pembayaran);
					if (bayar[7].Jumlah != -999) {
						TotalJumlah = TotalJumlah + bayar[7].Jumlah;
						Jumlah8.setText("Rp "
								+ this.convertHarga(bayar[7].Jumlah));
					} else {
						Jumlah8.setText("Rp ");
					}
					if (!bayar[7].Tanggal.equals("aaa")) {
						Tanggal8.setText(bayar[7].Tanggal);
					}
					if (!bayar[7].Bank.equals("aaa")) {
						Bank8.setText(bayar[7].Bank);
					}
					if (!bayar[7].AtasNama.equals("aaa")) {
						AN8.setText(bayar[7].AtasNama);
					}
					if (!bayar[7].NoRekening.equals("aaa")) {
						NoRek8.setText(bayar[7].NoRekening);
					}
					if (bayar[7].cek == 1) {
						checkBox8.setSelected(true);
					}

				case 9:
					Pembayaran9.setText(bayar[8].Pembayaran);
					if (bayar[8].Jumlah != -999) {
						TotalJumlah = TotalJumlah + bayar[8].Jumlah;
						Jumlah9.setText("Rp "
								+ this.convertHarga(bayar[8].Jumlah));
					} else {
						Jumlah9.setText("Rp ");
					}
					if (!bayar[8].Tanggal.equals("aaa")) {
						Tanggal9.setText(bayar[8].Tanggal);
					}
					if (!bayar[8].Bank.equals("aaa")) {
						Bank9.setText(bayar[8].Bank);
					}
					if (!bayar[8].AtasNama.equals("aaa")) {
						AN9.setText(bayar[8].AtasNama);
					}
					if (!bayar[8].NoRekening.equals("aaa")) {
						NoRek9.setText(bayar[8].NoRekening);
					}
					if (bayar[8].cek == 1) {
						checkBox9.setSelected(true);
					}

					// break;
				default: {
				}
				}
				j++;

			}
			textField_Total.setText("Rp " + this.convertHarga(TotalJumlah));
			setStatusTotal();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setEditable();

	}

	// *******TAMBAHAN PROSEDUR ***********\\

	public void checkStatusTotal() {
		if (TotalJumlah != MainRumah.rumahSimpan.getHargaNett()) {
			this.StatusTotal = false;
		} else if (TotalJumlah == MainRumah.rumahSimpan.getHargaNett()) {
			this.StatusTotal = true;
		}
	}

	public void setStatusTotal() {
		this.checkStatusTotal();
		if (StatusTotal) {
			textField_StatusTotal.setText("Total harga sudah sesuai");
		} else {
			textField_StatusTotal.setText("Total harga belum sesuai");
		}

	}

	public void moveValue() {
		if (!Jumlah1.getText().equals("") && !Jumlah1.getText().equals("Rp ")) {
			String str = Jumlah1.getText().toString();
			String tmp = "";
			for (String tmp2 : str.split("[.]")) {
				// System.out.println(tmp2);
				tmp += tmp2;
			}

			if (tmp.substring(0, 3).equals("Rp ")) {
				str = tmp.substring(3, tmp.length());
				bayar[0].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			} else {
				str = tmp;
				bayar[0].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		} else {
			bayar[0].Jumlah = -999;
		}
		if (!Tanggal1.getText().equals("")) {
			bayar[0].Tanggal = Tanggal1.getText().toString();
		} else {
			bayar[0].Tanggal = "aaa";
		}
		if (!Bank1.getText().equals("")) {
			bayar[0].Bank = Bank1.getText().toString();
		} else {
			bayar[0].Bank = "aaa";
		}
		if (!AN1.getText().equals("")) {
			bayar[0].AtasNama = AN1.getText().toString();
		} else {
			bayar[0].AtasNama = "aaa";
		}
		if (!NoRek1.getText().equals("")) {
			bayar[0].NoRekening = NoRek1.getText().toString();
		} else {
			bayar[0].NoRekening = "aaa";
		}
		if (checkBox1.isSelected()) {
			bayar[0].cek = 1;
		} else {
			bayar[0].cek = 0;
		}

		if (!Jumlah2.getText().equals("") && !Jumlah2.getText().equals("Rp ")) {
			String str = Jumlah2.getText().toString();
			String tmp = "";
			for (String tmp2 : str.split("[.]")) {
				// System.out.println(tmp2);
				tmp += tmp2;
			}

			if (tmp.substring(0, 3).equals("Rp ")) {
				str = tmp.substring(3, tmp.length());
				bayar[1].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			} else {
				str = tmp;
				bayar[1].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		} else {
			bayar[1].Jumlah = -999;
		}
		if (!Tanggal2.getText().equals("")) {
			bayar[1].Tanggal = Tanggal2.getText().toString();
		} else {
			bayar[1].Tanggal = "aaa";
		}
		if (!Bank1.getText().equals("")) {
			bayar[1].Bank = Bank2.getText().toString();
		} else {
			bayar[1].Bank = "aaa";
		}
		if (!AN2.getText().equals("")) {
			bayar[1].AtasNama = AN2.getText().toString();
		} else {
			bayar[1].AtasNama = "aaa";
		}
		if (!NoRek2.getText().equals("")) {
			bayar[1].NoRekening = NoRek2.getText().toString();
		} else {
			bayar[1].NoRekening = "aaa";
		}
		if (checkBox2.isSelected()) {
			bayar[1].cek = 1;
		} else {
			bayar[1].cek = 0;
		}

		if (!Jumlah3.getText().equals("") && !Jumlah3.getText().equals("Rp ")) {
			String str = Jumlah3.getText().toString();
			String tmp = "";
			for (String tmp2 : str.split("[.]")) {
				// System.out.println(tmp2);
				tmp += tmp2;
			}

			if (tmp.substring(0, 3).equals("Rp ")) {
				str = tmp.substring(3, tmp.length());
				bayar[2].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			} else {
				str = tmp;
				bayar[2].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		} else {
			bayar[2].Jumlah = -999;
		}
		if (!Tanggal3.getText().equals("")) {
			bayar[2].Tanggal = Tanggal3.getText().toString();
		} else {
			bayar[2].Tanggal = "aaa";
		}
		if (!Bank3.getText().equals("")) {
			bayar[2].Bank = Bank3.getText().toString();
		} else {
			bayar[2].Bank = "aaa";
		}
		if (!AN3.getText().equals("")) {
			bayar[2].AtasNama = AN3.getText().toString();
		} else {
			bayar[2].AtasNama = "aaa";
		}
		if (!NoRek3.getText().equals("")) {
			bayar[2].NoRekening = NoRek3.getText().toString();
		} else {
			bayar[2].NoRekening = "aaa";
		}
		if (checkBox3.isSelected()) {
			bayar[2].cek = 1;
		} else {
			bayar[2].cek = 0;
		}

		if (!Jumlah4.getText().equals("") && !Jumlah4.getText().equals("Rp ")) {
			String str = Jumlah4.getText().toString();
			String tmp = "";
			for (String tmp2 : str.split("[.]")) {
				// System.out.println(tmp2);
				tmp += tmp2;
			}

			if (tmp.substring(0, 3).equals("Rp ")) {
				str = tmp.substring(3, tmp.length());
				bayar[3].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			} else {
				str = tmp;
				bayar[3].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		} else {
			bayar[3].Jumlah = -999;
		}
		if (!Tanggal4.getText().equals("")) {
			bayar[3].Tanggal = Tanggal4.getText().toString();
		} else {
			bayar[3].Tanggal = "aaa";
		}
		if (!Bank4.getText().equals("")) {
			bayar[3].Bank = Bank4.getText().toString();
		} else {
			bayar[3].Bank = "aaa";
		}
		if (!AN4.getText().equals("")) {
			bayar[3].AtasNama = AN4.getText().toString();
		} else {
			bayar[3].AtasNama = "aaa";
		}
		if (!NoRek4.getText().equals("")) {
			bayar[3].NoRekening = NoRek4.getText().toString();
		} else {
			bayar[3].NoRekening = "aaa";
		}
		if (checkBox4.isSelected()) {
			bayar[3].cek = 1;
		} else {
			bayar[3].cek = 0;
		}

		if (textField_6.getText().toString().equals("")) {
			bankacc = "aaa";
		} else {
			bankacc = textField_6.getText().toString();
		}
		if (!textField_7.getText().equals("")
				&& !textField_7.getText().equals("Rp ")) {
			String str = textField_7.getText().toString();
			String tmp = "";
			for (String tmp2 : str.split("[.]")) {
				// System.out.println(tmp2);
				tmp += tmp2;
			}

			if (tmp.substring(0, 3).equals("Rp ")) {
				str = tmp.substring(3, tmp.length());
				jmlacc = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			} else {
				str = tmp;
				jmlacc = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		} else {
			jmlacc = -999;
		}

		if (!Jumlah5.getText().equals("") && !Jumlah5.getText().equals("Rp ")) {
			String str = Jumlah5.getText().toString();
			String tmp = "";
			for (String tmp2 : str.split("[.]")) {
				// System.out.println(tmp2);
				tmp += tmp2;
			}

			if (tmp.substring(0, 3).equals("Rp ")) {
				str = tmp.substring(3, tmp.length());
				bayar[4].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			} else {
				str = tmp;
				bayar[4].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		} else {
			bayar[4].Jumlah = -999;
		}
		if (!Tanggal5.getText().equals("")) {
			bayar[4].Tanggal = Tanggal5.getText().toString();
		} else {
			bayar[4].Tanggal = "aaa";
		}
		if (!Bank5.getText().equals("")) {
			bayar[4].Bank = Bank5.getText().toString();
		} else {
			bayar[4].Bank = "aaa";
		}
		if (!AN5.getText().equals("")) {
			bayar[4].AtasNama = AN5.getText().toString();
		} else {
			bayar[4].AtasNama = "aaa";
		}
		if (!NoRek5.getText().equals("")) {
			bayar[4].NoRekening = NoRek5.getText().toString();
		} else {
			bayar[4].NoRekening = "aaa";
		}
		if (checkBox5.isSelected()) {
			bayar[4].cek = 1;
		} else {
			bayar[4].cek = 0;
		}

		if (!Jumlah6.getText().equals("") && !Jumlah6.getText().equals("Rp ")) {
			String str = Jumlah6.getText().toString();
			String tmp = "";
			for (String tmp2 : str.split("[.]")) {
				// System.out.println(tmp2);
				tmp += tmp2;
			}

			if (tmp.substring(0, 3).equals("Rp ")) {
				str = tmp.substring(3, tmp.length());
				bayar[5].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			} else {
				str = tmp;
				bayar[5].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		} else {
			bayar[5].Jumlah = -999;
		}
		if (!Tanggal6.getText().equals("")) {
			bayar[5].Tanggal = Tanggal6.getText().toString();
		} else {
			bayar[5].Tanggal = "aaa";
		}
		if (!Bank6.getText().equals("")) {
			bayar[5].Bank = Bank6.getText().toString();
		} else {
			bayar[5].Bank = "aaa";
		}
		if (!AN6.getText().equals("")) {
			bayar[5].AtasNama = AN6.getText().toString();
		} else {
			bayar[5].AtasNama = "aaa";
		}
		if (!NoRek6.getText().equals("")) {
			bayar[5].NoRekening = NoRek6.getText().toString();
		} else {
			bayar[5].NoRekening = "aaa";
		}
		if (checkBox6.isSelected()) {
			bayar[5].cek = 1;
		} else {
			bayar[5].cek = 0;
		}

		if (!Jumlah7.getText().equals("") && !Jumlah7.getText().equals("Rp ")) {
			String str = Jumlah7.getText().toString();
			String tmp = "";
			for (String tmp2 : str.split("[.]")) {
				// System.out.println(tmp2);
				tmp += tmp2;
			}

			if (tmp.substring(0, 3).equals("Rp ")) {
				str = tmp.substring(3, tmp.length());
				bayar[6].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			} else {
				str = tmp;
				bayar[6].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		} else {
			bayar[6].Jumlah = -999;
		}
		if (!Tanggal7.getText().equals("")) {
			bayar[6].Tanggal = Tanggal7.getText().toString();
		} else {
			bayar[6].Tanggal = "aaa";
		}
		if (!Bank7.getText().equals("")) {
			bayar[6].Bank = Bank7.getText().toString();
		} else {
			bayar[6].Bank = "aaa";
		}
		if (!AN7.getText().equals("")) {
			bayar[6].AtasNama = AN7.getText().toString();
		} else {
			bayar[6].AtasNama = "aaa";
		}
		if (!NoRek7.getText().equals("")) {
			bayar[6].NoRekening = NoRek7.getText().toString();
		} else {
			bayar[6].NoRekening = "aaa";
		}
		if (checkBox7.isSelected()) {
			bayar[6].cek = 1;
		} else {
			bayar[6].cek = 0;
		}

		if (!Jumlah8.getText().equals("") && !Jumlah8.getText().equals("Rp ")) {
			String str = Jumlah8.getText().toString();
			String tmp = "";
			for (String tmp2 : str.split("[.]")) {
				// System.out.println(tmp2);
				tmp += tmp2;
			}

			if (tmp.substring(0, 3).equals("Rp ")) {
				str = tmp.substring(3, tmp.length());
				bayar[7].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			} else {
				str = tmp;
				bayar[7].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		} else {
			bayar[7].Jumlah = -999;
		}
		if (!Tanggal8.getText().equals("")) {
			bayar[7].Tanggal = Tanggal8.getText().toString();
		} else {
			bayar[7].Tanggal = "aaa";
		}
		if (!Bank8.getText().equals("")) {
			bayar[7].Bank = Bank8.getText().toString();
		} else {
			bayar[7].Bank = "aaa";
		}
		if (!AN8.getText().equals("")) {
			bayar[7].AtasNama = AN8.getText().toString();
		} else {
			bayar[7].AtasNama = "aaa";
		}
		if (!NoRek8.getText().equals("")) {
			bayar[7].NoRekening = NoRek8.getText().toString();
		} else {
			bayar[7].NoRekening = "aaa";
		}
		if (checkBox8.isSelected()) {
			bayar[7].cek = 1;
		} else {
			bayar[7].cek = 0;
		}

		if (!Jumlah9.getText().equals("") && !Jumlah9.getText().equals("Rp ")) {
			String str = Jumlah9.getText().toString();
			String tmp = "";
			for (String tmp2 : str.split("[.]")) {
				// System.out.println(tmp2);
				tmp += tmp2;
			}

			if (tmp.substring(0, 3).equals("Rp ")) {
				str = tmp.substring(3, tmp.length());
				bayar[8].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			} else {
				str = tmp;
				bayar[8].Jumlah = Integer.parseInt(str);
				// System.out.println("nilai baru : "+Integer.parseInt(str));
			}
		} else {
			bayar[8].Jumlah = -999;
		}
		if (!Tanggal9.getText().equals("")) {
			bayar[8].Tanggal = Tanggal9.getText().toString();
		} else {
			bayar[8].Tanggal = "aaa";
		}
		if (!Bank9.getText().equals("")) {
			bayar[8].Bank = Bank9.getText().toString();
		} else {
			bayar[8].Bank = "aaa";
		}
		if (!AN9.getText().equals("")) {
			bayar[8].AtasNama = AN9.getText().toString();
		} else {
			bayar[8].AtasNama = "aaa";
		}
		if (!NoRek9.getText().equals("")) {
			bayar[8].NoRekening = NoRek9.getText().toString();
		} else {
			bayar[8].NoRekening = "aaa";
		}
		if (checkBox9.isSelected()) {
			bayar[8].cek = 1;
		} else {
			bayar[8].cek = 0;
		}

	}
}
