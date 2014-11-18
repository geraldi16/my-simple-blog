import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class DataPembeli extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JButton btnSave;
	private JButton btnDelete;
	private String sql;
	private ResultSet rs;
	
	private boolean isKosong;
	private Pembeli pembeli;
	private Rumah rumah;
	Date dNow = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;
	public static Pembeli pembeliSimpan = new Pembeli();
	
	//variabel pembeli

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataPembeli frame = new DataPembeli();
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
	
	
	/**
	 * Create the frame.
	 */
	
	public DataPembeli() {
		
		
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
		
		setTitle("Data Pembeli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 286);
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
		if (MainRumah.rumahSimpan.getIsBought() == false){
			textField_5.setText("Belum Terbeli");
		}
		else{
			textField_5.setText("Terbeli");
		}
		textField_5.setColumns(10);
		textField_5.setBounds(71, 127, 98, 20);
		panel.add(textField_5);
		textField_5.setEditable(false);
		
		JLabel label_6 = new JLabel("Nama");
		label_6.setBounds(221, 14, 79, 14);
		contentPane.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(321, 11, 240, 20);
		contentPane.add(textField_6);
		
		JLabel label_7 = new JLabel("Alamat");
		label_7.setBounds(221, 42, 79, 14);
		contentPane.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(321, 39, 240, 20);
		contentPane.add(textField_7);
		
		JLabel label_8 = new JLabel("No Telepon");
		label_8.setBounds(221, 70, 79, 14);
		contentPane.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(321, 67, 240, 20);
		contentPane.add(textField_8);
		
		JLabel label_9 = new JLabel("TTL");
		label_9.setBounds(221, 98, 79, 14);
		contentPane.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(321, 95, 240, 20);
		contentPane.add(textField_9);
		
		JButton button = new JButton("Kembali ke menu rumah");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MainRumah frameMain = new MainRumah();
				frameMain.setVisible(true);
			}
		});
		button.setBounds(187, 214, 200, 23);
		contentPane.add(button);
		
		JLabel label_10 = new JLabel("Pekerjaan");
		label_10.setBounds(221, 124, 79, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("No KTP");
		label_11.setBounds(221, 152, 79, 14);
		contentPane.add(label_11);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(321, 121, 240, 20);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(321, 149, 240, 20);
		contentPane.add(textField_11);
				
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//delete pembeli, terus update rumah jadi belum terbeli lagi
				String sql1= "DELETE FROM `tabel_pembeli` WHERE `idRumah`="+pembeli.IDRumah+";";
				
				try{
					Object[] option = {"Hapus","Tunda"};
					int op = JOptionPane.showOptionDialog(null, "Data akan dihapus. Teruskan? ","Konfirmasi Jawaban",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,option,option[0]);
					
					if(op==0){
						statement.executeUpdate(sql1);
					String sql2 = "UPDATE `tabel_rumah` SET `isBought`=0 WHERE `idRumah`= "+pembeli.IDRumah+";";
						statement.executeUpdate(sql2);
						sql1= "DELETE FROM `tabel_harga` WHERE `idRumah`="+MainRumah.rumahSimpan.getIDRumah();
						statement.executeUpdate(sql1);
						
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
						sql = "INSERT INTO `tabel_history`(`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES ('"+MainRumah.pembeli.Nama+"','"+ft.format(dNow)+"','Rp xxx.','"+MainRumah.rumahSimpan.getTipe()+"','"+MainRumah.rumahSimpan.getNoRumah()+"','"+MainRumah.marketing+"','data Pembeli dihapus')";
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
		btnDelete.setBounds(15, 214, 139, 23);
		contentPane.add(btnDelete);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//update
				int hasil = 0;
				if(!isKosong){
					String sql = "UPDATE `tabel_pembeli` SET `nama`='"+textField_6.getText()+"',`alamat`='"+textField_7.getText()+"',`noTelepon`='"+textField_8.getText()+"',`ttl`='"+textField_9.getText()+"',`pekerjaan`='"+textField_10.getText()+"',`ktp`='"+textField_11.getText()+"' WHERE `idRumah` = "+pembeli.IDRumah+";";
					try{
						hasil = statement.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Update data berhasil!");
						setVisible(false);
						MainRumah frameMain = new MainRumah();
						frameMain.setVisible(true);
					}catch(SQLException se){
						se.printStackTrace();
					}
				}else{//data masih kosong
					if(textField_6.getText()!=null&&textField_7.getText()!=null&&textField_8.getText()!=null&&textField_9.getText()!=null&&textField_10.getText()!=null&&textField_11.getText()!=null){
						String sql = "INSERT INTO `tabel_pembeli`(`idRumah`, `nama`, `alamat`, `noTelepon`, `ttl`, `pekerjaan`, `ktp`) VALUES ("+rumah.getIDRumah()+",'"+textField_6.getText()+"','"+textField_7.getText()+"','"+textField_8.getText()+"','"+textField_9.getText()+"','"+textField_10.getText()+"','"+textField_11.getText()+"')"; //insert pembeli
						String sql2 ="UPDATE `tabel_rumah` SET `isBought`= 1 WHERE `idRumah` = "+rumah.getIDRumah()+""; //update rumah
						try{
							hasil = statement.executeUpdate(sql);
							statement.executeUpdate(sql2);
							
							JOptionPane.showMessageDialog(null, "Isi data pembeli berhasil!");
							setVisible(false);
							MainRumah frameMain = new MainRumah();
							frameMain.setVisible(true);
							
						}catch(SQLException se){
							se.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(null, "isi seluruh datanya!!");
					}
				}
				if(hasil==1){
					pembeliSimpan.setNama(textField_6.getText());
					pembeliSimpan.setAlamat(textField_7.getText());
					pembeliSimpan.setNoTelepon1(textField_8.getText());
					pembeliSimpan.setTTL(textField_9.getText());
					pembeliSimpan.setPekerjaan(textField_10.getText());
					pembeliSimpan.setKTP(textField_11.getText());
				}
			}
		});
		btnSave.setBounds(424, 213, 139, 23);
		contentPane.add(btnSave);
		
		sql = "SELECT * FROM `tabel_pembeli` WHERE idRumah="+MainRumah.rumahSimpan.getIDRumah()+";";
		try {
			rs = statement.executeQuery(sql);
			if (!rs.isBeforeFirst()){
				System.out.println("Tabel Kosong");
				isKosong = true;
			}
			else{
				isKosong = false;
				pembeli = new Pembeli();
				textField_6.setText(pembeli.getNama());
				textField_7.setText(pembeli.getAlamat());
				textField_8.setText(pembeli.getNoTelepon());
				textField_9.setText(pembeli.TTL);
				textField_10.setText(pembeli.getPekerjaan());
				textField_11.setText(pembeli.KTP);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setEditable();
	}

	private Pembeli Pembeli(int idRumah) {
		// TODO Auto-generated method stub
		return null;
	}
}
