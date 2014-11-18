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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;


public class App extends JFrame {

	private JPanel contentPane;
//	private final JTextField textField;
	//private final JPasswordField password;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	   static final String USER = "root";
	   static final String PASS = "";
	   public static Connection conn = null;
	   public static Statement statement = null;
	   public static String LoginID; // buat user name 
	   public static int status; // keterangan : 0 = pegawai ; 1= owner

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		initialize();
		
	}
	
	public void initialize(){
		setTitle("Menu Utama");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		setBounds(450, 220, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(119, 128, 46, 14);
		contentPane.add(lblId);
		
		JLabel header1 = new JLabel("Selamat datang di Menu utama");
		header1.setHorizontalAlignment(SwingConstants.CENTER);
		header1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 14));
		header1.setBounds(83,21,286,30);
		contentPane.add(header1);
		
		JLabel header2 = new JLabel("Kota Bali");
		header2.setHorizontalAlignment(SwingConstants.CENTER);
		header2.setFont(new Font("Segoe Print", Font.BOLD, 40));
		header2.setBounds(69,49,300,50);
		contentPane.add(header2);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(119, 153, 70, 14);
		contentPane.add(lblPassword);
		
		final JTextField login = new JTextField();
		login.setBounds(231, 125, 120, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		final JPasswordField password = new JPasswordField();
		password.setBounds(231, 150, 120, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		final JLabel notif = new JLabel("Ada kesalahan pada inputan!!");
		notif.setBounds(141, 207, 159, 50);
		contentPane.add(notif);
		notif.setVisible(false);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(170, 187, 89, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					int isOwner = 999; // buat ngecek aja, 0 = bukan, 1= owner, 999 = ada kesalahan
					String pass = String.valueOf(password.getPassword());
					//System.out.println(textField.getText());
					String sql = "SELECT `isOwner` FROM `tabel_user` WHERE userID='"+login.getText()+"' and password = '"+pass+"'";
					//System.out.println(sql);
					ResultSet rs = statement.executeQuery(sql);
					
					while(rs.next()){
						isOwner= rs.getInt("isOwner");
					}
					LoginID = login.getText();
					
					if(isOwner==999){ // ada kesalahan
						notif.setVisible(true);
					}else{ //bener, masuk ke ider menu owner ato bukan
						if (isOwner==0){
							// tampilin menu buat pegawai
							status = 0;
							JOptionPane.showMessageDialog(null, "Selamat datang di program KotaBali");
							setVisible(false);
							PetaAwal framePeta = new PetaAwal();
							framePeta.setVisible(true);
						}else{//isOwner==1
							//tampilin menu owner 
							status =1;
							JOptionPane.showMessageDialog(null, "menu owner");
							setVisible(false);
							MenuOwner frameMenuOwner = new MenuOwner();
							frameMenuOwner.setVisible(true);
						}
					}
					
					
				}catch(SQLException se){
					JOptionPane.showMessageDialog(null, "ada kesalahan pada input login!!");
					se.printStackTrace();
				}
			}
		});
		contentPane.add(btnLogin);
	}
}
