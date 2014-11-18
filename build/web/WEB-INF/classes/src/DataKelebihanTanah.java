import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;


public class DataKelebihanTanah extends JFrame {

	private KelebihanTanah kelebihanTanah;
	private Rumah rumah;
	private JPanel contentPane;
	private int awalLT;
	private boolean isKosong;
	private JTextField textField_Kavling;
	private JTextField textField_noRumah;
	private JTextField textField_LB;
	private JTextField textField_LT;
	private JTextField textField_HN;
	private JTextField textField_Status;
	private JTextField textField_KT;
	private JTextField textField_HargaM;
	private JTextField textField_HK;
	private JButton btnKembaliKeMenu;
	private JButton btnSave;
	private String sql;
	private ResultSet rs;
	private int totalDiskon;

	public static KelebihanTanah kelebihanTanahSimpan = new KelebihanTanah();
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
					DataKelebihanTanah frame = new DataKelebihanTanah();
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
		}
	}

	
	/**
	 * Create the frame.
	 */
	public DataKelebihanTanah() {
		
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
		awalLT = rumah.LTAwal;
		kelebihanTanah = new KelebihanTanah(rumah.getIDRumah());
		setTitle("Kelebihan Tanah");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(26, 46, 179, 158);
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
		panel.add(textField_Kavling);
		
		textField_noRumah = new JTextField();
		textField_noRumah.setColumns(10);
		textField_noRumah.setBounds(71, 30, 98, 20);
		panel.add(textField_noRumah);
		
		textField_LB = new JTextField();
		textField_LB.setColumns(10);
		textField_LB.setBounds(71, 77, 98, 20);
		panel.add(textField_LB);
		
		textField_LT = new JTextField();
		textField_LT.setColumns(10);
		textField_LT.setBounds(71, 55, 98, 20);
		panel.add(textField_LT);
		
		textField_HN = new JTextField();
		textField_HN.setColumns(10);
		textField_HN.setBounds(71, 105, 98, 20);
		panel.add(textField_HN);
		
		textField_Status = new JTextField();
		textField_Status.setColumns(10);
		textField_Status.setBounds(71, 127, 98, 20);
		panel.add(textField_Status);
		
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

		JLabel lblKelebihanTanah = new JLabel("Kelebihan Tanah");
		lblKelebihanTanah.setBounds(237, 75, 79, 14);
		contentPane.add(lblKelebihanTanah);
		
		textField_KT = new JTextField();
		textField_KT.setText("0");
		textField_KT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if ((textField_KT.getText() != "0" ) && (textField_HargaM.getText() != "0")){
					String str = textField_HargaM.getText().toString();
					String tmp = "";
					for(String tmp2: str.split("[.]")){
					// System.out.println(tmp2);
						tmp += tmp2;
					}
					str = textField_KT.getText().toString();
					String tmp3 = "";
					for(String tmp2: str.split("[.]")){
						// System.out.println(tmp2);
							tmp3 += tmp2;
						}
					
					kelebihanTanah.setStrHargaM(tmp);
					kelebihanTanah.setStrKT(tmp3);
					kelebihanTanah.HargaKelebihan = kelebihanTanah.KelebihanTanah * kelebihanTanah.HargaM;
					textField_HK.setText("Rp "+Rumah.convertHarga(kelebihanTanah.HargaKelebihan));
				}
			}
		});
		textField_KT.setBounds(337, 72, 150, 20);
		contentPane.add(textField_KT);
		textField_KT.setColumns(10);
		
		JLabel lblHargaM = new JLabel("Harga / m");
		lblHargaM.setBounds(237, 103, 79, 14);
		contentPane.add(lblHargaM);
		
		textField_HargaM = new JTextField();
		textField_HargaM.setText("0");
		textField_HargaM.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if ((textField_KT.getText() != "0" ) && (textField_HargaM.getText() != "0")){
					String str = textField_HargaM.getText().toString();
					String tmp = "";
					for(String tmp2: str.split("[.]")){
					// System.out.println(tmp2);
						tmp += tmp2;
					}
					//System.out.println(tmp);
					str = textField_KT.getText().toString();
					String tmp3 = "";
					for(String tmp2: str.split("[.]")){
						// System.out.println(tmp2);
							tmp3 += tmp2;
						}
					//System.out.println(tmp3);
					
					kelebihanTanah.setStrHargaM(tmp);
					kelebihanTanah.setStrKT(tmp3);
					kelebihanTanah.HargaKelebihan = kelebihanTanah.KelebihanTanah * kelebihanTanah.HargaM;
					textField_HK.setText("Rp "+Rumah.convertHarga(kelebihanTanah.HargaKelebihan));
				}
			}
		});
		textField_HargaM.setColumns(10);
		textField_HargaM.setBounds(337, 100, 150, 20);
		contentPane.add(textField_HargaM);
		
		JLabel lblHargaKelebihan = new JLabel("Harga kelebihan");
		lblHargaKelebihan.setBounds(237, 131, 79, 14);
		contentPane.add(lblHargaKelebihan);
		
		textField_HK = new JTextField();
		textField_HK.setEditable(false);
		textField_HK.setColumns(10);
		textField_HK.setBounds(337, 128, 150, 20);
		contentPane.add(textField_HK);
				
		btnKembaliKeMenu = new JButton("Kembali ke menu rumah");
		btnKembaliKeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MainRumah frameMain = new MainRumah();
				frameMain.setVisible(true);
			}
		});
		btnKembaliKeMenu.setBounds(26, 236, 179, 23);
		contentPane.add(btnKembaliKeMenu);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String str = textField_KT.getText().toString();
				String tmp = "";
				for(String tmp2: str.split("[.]")){
				// System.out.println(tmp2);
					tmp += tmp2;
				}
				//System.out.println(tmp);
				str = textField_HargaM.getText().toString();
				String tmp3 = "";
				for(String tmp2: str.split("[.]")){
					// System.out.println(tmp2);
						tmp3 += tmp2;
					}
				//System.out.println(tmp3);
				
				kelebihanTanah.setStrKT(tmp);
				kelebihanTanah.setStrHargaM(tmp3);
				kelebihanTanah.HargaKelebihan = kelebihanTanah.KelebihanTanah * kelebihanTanah.HargaM;
				kelebihanTanahSimpan = kelebihanTanah;
				rumah.setLT(awalLT+kelebihanTanah.KelebihanTanah);
	
				if (isKosong){
					sql = "INSERT INTO `tabel_kelebihantanah`(`idRumah`, `KelebihanTanah`, `HargaM`, `HargaKelebihan`, `HargaTotal`) " +
							"VALUES ("+rumah.getIDRumah()+","+kelebihanTanah.KelebihanTanah+","+kelebihanTanah.HargaM+","+kelebihanTanah.HargaKelebihan+","+kelebihanTanah.HargaTotal+")";
					try {
						int hasilUpdate = statement.executeUpdate(sql);
						System.out.println(hasilUpdate);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Pengisian kelebihan tanah berhasil!");

		
				}
				
				if (!isKosong){
				sql = "UPDATE tabel_kelebihantanah " +
						"SET KelebihanTanah ="+kelebihanTanah.KelebihanTanah+", HargaM ="+kelebihanTanah.HargaM+", HargaKelebihan = "+kelebihanTanah.HargaKelebihan+", HargaTotal = "+kelebihanTanah.HargaTotal+" " +
						"WHERE idRumah = "+kelebihanTanah.IDRumah+";";
				try {
					int hasilUpdate = statement.executeUpdate(sql);
					System.out.println(hasilUpdate);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Upate data Kelebihan Tanah berhasil!");
				}
				sql = "SELECT `total_diskon` FROM `tabel_harga` WHERE `idRumah` = "+rumah.getIDRumah()+";";
				try {
					rs = statement.executeQuery(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (!rs.isBeforeFirst()){
						System.out.println("Harga kelebihan di tabel_harga kosong");
						int hargaNett = rumah.getHargaAwal() + kelebihanTanah.HargaKelebihan;
						rumah.setHargaNett(hargaNett);
						
						sql = "UPDATE tabel_rumah " +
								"SET LT = "+rumah.getLT()+", HargaNett = "+rumah.getHargaNett()+" " +
								"WHERE idRumah = "+kelebihanTanah.IDRumah+";";
						try {
							int hasilUpdate = statement.executeUpdate(sql);
							System.out.println("Update harga : " +hasilUpdate);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						
					}
					else {
						while(rs.next()){
							totalDiskon = rs.getInt("total_diskon");
						}
						int hargaNett = rumah.getHargaAwal() - totalDiskon + kelebihanTanah.HargaKelebihan;
						rumah.setHargaNett(hargaNett);
						
						sql = "UPDATE tabel_rumah " +
								"SET LT = "+rumah.getLT()+", HargaNett = "+rumah.getHargaNett()+" " +
								"WHERE idRumah = "+kelebihanTanah.IDRumah+";";
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
				
				setVisible(false);
				MainRumah frameMain = new MainRumah();
				frameMain.setVisible(true);

		}
		});
		btnSave.setBounds(364, 237, 139, 23);
		contentPane.add(btnSave);
						
		sql = "SELECT * FROM `tabel_kelebihantanah` WHERE idRumah="+kelebihanTanah.IDRumah+";";
		try {
			rs = statement.executeQuery(sql);
			if (!rs.isBeforeFirst()){
				System.out.println("Tabel Kosong");
				isKosong = true;
			}
			else{
				isKosong = false;
				while(rs.next()){
					kelebihanTanah.KelebihanTanah = rs.getInt("KelebihanTanah");
					kelebihanTanah.HargaM = rs.getInt("HargaM");
					kelebihanTanah.HargaKelebihan = rs.getInt("HargaKelebihan");
					kelebihanTanah.HargaTotal = rs.getInt("HargaTotal");
					textField_KT.setText(kelebihanTanah.getStrKT());
					textField_HargaM.setText(kelebihanTanah.getStrHargaM());
					textField_HK.setText("Rp "+Rumah.convertHarga(kelebihanTanah.HargaKelebihan));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	setEditable();
	}
}