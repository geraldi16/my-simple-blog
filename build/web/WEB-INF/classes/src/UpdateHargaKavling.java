import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class UpdateHargaKavling extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ResultSet rs;
	
	private int hargaKelebihan;
	private int totalDiskon;
	private int hargaNett;
	private boolean isBought;

	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;
	
	//variabel
	public int[] harga;
	public String[] tanggal;
	Date dNow = new Date();
	 SimpleDateFormat ft =  new SimpleDateFormat ("dd-MM-yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateHargaKavling frame = new UpdateHargaKavling();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		//---end tambahan
		
	/**
	 * Create the frame.
	 */
	public UpdateHargaKavling() {
		harga = new int[7];
		tanggal = new String[7];
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
			
			String sql = "SELECT * FROM `tabel_hargakavling`";
			ResultSet rs = statement.executeQuery(sql);
			
			int i=0;
			while (rs.next()){
				harga[i] = rs.getInt("harga_lama");
				tanggal[i] = rs.getString("Tgl_update");
				i++;
			}
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setTitle("Update Harga Kavling");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblHargaLama = new JLabel("Harga Lama");
		lblHargaLama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHargaLama.setBounds(78, 73, 74, 27);
		contentPane.add(lblHargaLama);
		
		JLabel lblTerakhirUpdate = new JLabel("Terakhir Update");
		lblTerakhirUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTerakhirUpdate.setBounds(78, 98, 107, 27);
		contentPane.add(lblTerakhirUpdate);
		
		JLabel lblNewLabel = new JLabel("Harga Baru");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(78, 123, 74, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kavling");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(78, 45, 61, 27);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField("Rp "+convertHarga(harga[0]));
		textField.setBounds(234, 78, 123, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField(tanggal[0]);
		textField_1.setBounds(234, 103, 123, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		final JTextField textField_2 = new JTextField();
		textField_2.setBounds(234, 128, 123, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		final JComboBox <String>comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.addItemListener(new ItemListener() {
			@Override
	        public void itemStateChanged(ItemEvent arg0) {
	           textField.setText("Rp "+convertHarga(harga[comboBox.getSelectedIndex()]));
	           textField_1.setText(tanggal[comboBox.getSelectedIndex()]);
	        }
	    });
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ruko", "Anggrek 1", "Anggrek 2", "Teratai 1", "Teratai 2", "Kamboja 1", "Kamboja 2"}));
		comboBox.setBounds(234, 48, 123, 20);
		contentPane.add(comboBox);
		
		JButton btnKembaliKeMenu = new JButton("Kembali ke Menu Owner");
		btnKembaliKeMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnKembaliKeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MenuOwner frameMenuOwner = new MenuOwner();
				frameMenuOwner.setVisible(true);
			}
		});
		btnKembaliKeMenu.setBounds(190, 176, 167, 27);
		contentPane.add(btnKembaliKeMenu);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Masukkan input harga baru!!");
				}else{
					try{
						int newharga =  Integer.parseInt(textField_2.getText());
						String sql = "UPDATE `tabel_hargakavling` SET `harga_lama`= "+newharga+",`Tgl_update`= '"+ft.format(dNow)+"' WHERE `kavling` = '"+comboBox.getItemAt(comboBox.getSelectedIndex())+"'";
						statement.executeUpdate(sql);
						
						int i = 1;
						while (i <=284){
							sql = "SELECT `isBought` FROM `tabel_rumah` WHERE `idRumah` = "+i+";";
							rs = statement.executeQuery(sql);
							if (!rs.isBeforeFirst()){
							}							
							else{
								while (rs.next()){
									isBought = rs.getBoolean("isBought");
								}
								if (!isBought){
									String sql1 = "SELECT `total_diskon` FROM `tabel_harga` WHERE `idRumah` = "+i+";";
									try {
										rs = statement.executeQuery(sql1);
										if (!rs.isBeforeFirst()){
											totalDiskon = 0;
										}
										else {
											while (rs.next()){
												totalDiskon = rs.getInt("total_diskon");
											}
										}
									//	System.out.print(totalDiskon);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									String sql2 = "SELECT `HargaKelebihan` FROM `tabel_kelebihantanah` WHERE `idRumah` = "+i+";";
									try {
										rs = statement.executeQuery(sql2);
										if (!rs.isBeforeFirst()){
											hargaKelebihan = 0;
										}
										else {
											while (rs.next()){
												hargaKelebihan = rs.getInt("HargaKelebihan");
											}
										}
									//	System.out.print(hargaKelebihan);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									hargaNett = newharga + hargaKelebihan - totalDiskon;
									String sql3 = "UPDATE `tabel_rumah` SET `HargaAwal`= "+newharga+", `HargaNett`= "+hargaNett+" WHERE `idRumah` = "+i+" AND tipeRumah = '"+comboBox.getItemAt(comboBox.getSelectedIndex())+"' AND isBought = 0";
									int x = statement.executeUpdate(sql3);
								}
								else{
								}

							}
							i++;
						}
						
						JOptionPane.showMessageDialog(null, "Update harga kavling berhasil");
						
						setVisible(false);
						MenuOwner frameMenuOwner = new MenuOwner();
						frameMenuOwner.setVisible(true);
					}catch(SQLException se){
						se.printStackTrace();
					}
				}
				
			}
		});
		btnSimpan.setBounds(78, 176, 89, 27);
		contentPane.add(btnSimpan);
	}
}
