import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class Frame7 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox<String> comboBox;
	private Rumah rumah;
	private boolean isSelected = false;
	
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
					Frame7 frame = new Frame7();
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
	public Frame7() {
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	
	
		setTitle("Blok C, 1 ; 11 - 29");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frame7.class.getResource("/gambar/Frame 7.jpg")));
		lblNewLabel.setBounds(10,33,350, 618);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().equals("")){
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					isSelected = false;
				}
				else{
					isSelected = true;
					String noRumah = (String) comboBox.getSelectedItem();
					rumah = new Rumah(noRumah);

					String sql = "SELECT * FROM `tabel_rumah` WHERE noRumah='"+rumah.getNoRumah()+"';";
					try {
						ResultSet rs = statement.executeQuery(sql);
						if (!rs.isBeforeFirst()){
							System.out.println("Tabel Kosong");
						}

						while(rs.next()){
							rumah.setIDRumah(rs.getInt("idRumah"));
							rumah.setTipe(rs.getString("tipeRumah"));
							rumah.setLT(rs.getInt("LT"));
							rumah.LTAwal = rs.getInt("LTAwal");
							rumah.setLB(rs.getInt("LB"));
							rumah.setHargaAwal(rs.getInt("HargaAwal"));
							rumah.setHargaNett(rs.getInt("HargaNett"));
							rumah.setIsBought(rs.getBoolean("isBought"));
							rumah.setIsEdited(rs.getBoolean("isEdited"));
							rumah.setIsLocked(rs.getBoolean("isLocked"));						
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					textField.setText(rumah.getTipe());
					textField_1.setText(rumah.getNoRumah());
					textField_3.setText(rumah.getStrLT());
					textField_2.setText(rumah.getStrLB());
					textField_4.setText(rumah.getStrHN());
					textField_5.setText(rumah.getStrIsBought(rumah.getIsBought()));
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "C-1", "C-11", "C-12", "C-13", "C-14", "C-15", "C-16", "C-17", "C-18", "C-19", "C-20", "C-21", "C-22", "C-23", "C-24", "C-25", "C-26", "C-27", "C-28", "C-29"}));
		comboBox.setBounds(524, 87, 63, 20);
		contentPane.add(comboBox);
		
		JLabel labelKeterangan = new JLabel("Blok C, 1 ; 11 - 29");
		labelKeterangan.setHorizontalAlignment(SwingConstants.CENTER);
		labelKeterangan.setFont(new Font("Monospaced", Font.BOLD, 20));
		labelKeterangan.setBounds(10, 0, 350, 41);
		contentPane.add(labelKeterangan);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(407, 139, 179, 158);
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
		
		textField = new JTextField();
		textField.setText((String) null);
		textField.setColumns(10);
		textField.setBounds(71, 8, 98, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setColumns(10);
		textField_1.setBounds(71, 30, 98, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setColumns(10);
		textField_2.setBounds(71, 77, 98, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText((String) null);
		textField_3.setColumns(10);
		textField_3.setBounds(71, 55, 98, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText((String) null);
		textField_4.setColumns(10);
		textField_4.setBounds(71, 105, 98, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(71, 127, 98, 20);
		panel.add(textField_5);
		
		JLabel lblPilihanRumah = new JLabel("Pilihan Rumah :");
		lblPilihanRumah.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPilihanRumah.setBounds(406, 91, 90, 14);
		contentPane.add(lblPilihanRumah);
		
		JButton btnNewButton = new JButton("Kembali ke Peta Awal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				PetaAwal frame = new PetaAwal();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(412, 359, 176, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Masuk ke Menu Rumah");
				btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isSelected){
					MainRumah.noRumahDariPeta = rumah.getNoRumah();
					setVisible(false);
					MainRumah frameMain = new MainRumah();
					frameMain.setVisible(true);
				}
				else if (!isSelected){
					JOptionPane.showMessageDialog(null, "Rumah belum dipilih, silahkan pilih terlebih dahulu");
				}
			}
		});

		btnNewButton_1.setBounds(413, 320, 173, 30);
		contentPane.add(btnNewButton_1);

	}
}
