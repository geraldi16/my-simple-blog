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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


public class HistoryEdit extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JButton button;
	JButton button_1;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/proyek_perumahan";
	static final String USER = "root";
	static final String PASS = "";
	public static Connection conn = null;
	public static Statement statement = null;
	
	//variable
	public int jumlahdata;
	public boolean isKosong;
	public Object[][] object;
	public String[] colName={"pembeli","Tanggal","Booking","Tipe Rumah","No Rumah","Marketing","Keterangan"};
	public int page=1; // buat ngitung kalo data lebih dari tabel, dibuat page , default 1
	public int totalpage; // nyimpan halaman total page
	public Object[][] perpage; // nampung data perhalaman yang bakal ditampilin

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryEdit frame = new HistoryEdit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public HistoryEdit() {
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			statement = conn.createStatement();
			
			String sql = "SELECT COUNT(`pembeli`) AS `jumlah` FROM `tabel_history`";
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()){
				jumlahdata = rs.getInt("jumlah");
			}
			
			object = new Object[jumlahdata][colName.length];
			
			sql = "SELECT * FROM `tabel_history`";
			rs = statement.executeQuery(sql);
			
			int i=0;
			if (!rs.isBeforeFirst()){
				
			}else{
				while(rs.next()){
					object[i][0] = rs.getString("pembeli");
					object[i][1] = rs.getString("tanggal");
					object[i][2] = rs.getString("booking");
					object[i][3] = rs.getString("tipe_rumah");
					object[i][4] = rs.getString("no_rumah");
					object[i][5] = rs.getString("marketing");
					object[i][6] = rs.getString("keterangan");
					i++;
				}
			}
			
			totalpage = countPage();
			showTable();
			//System.out.println(object[0][0]);
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//inisiasi frame
		initialize();
	}
	public void initialize(){
		showTable();
		
		setTitle("History Edit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1144, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable(perpage,colName);
		table.setBounds(50, 77, 1030, 480);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(400);
		contentPane.add(table);
		
		button = new JButton("<<<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				page--;
				jumlahdata+= 30;
				initialize();
				setVisible(false);
				setVisible(true);
			}
		});
		button.setBounds(426, 620, 89, 23);
		contentPane.add(button);
		
		button_1 = new JButton(">>>");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page++;
				jumlahdata -= 30;
				initialize();
				setVisible(false);
				setVisible(true);
			}
		});
		button_1.setBounds(540, 620, 89, 23);
		contentPane.add(button_1);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				initialize();
				setVisible(false);
				setVisible(true);
				
			}
		});
		btnRefresh.setBounds(972, 20, 103, 32);
		contentPane.add(btnRefresh);
		
		JButton btnMenuUtama = new JButton("Menu Utama");
		btnMenuUtama.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				MenuOwner mo = new MenuOwner();
				setVisible(false);
				mo.setVisible(true);
				
			}
		});
		btnMenuUtama.setBounds(942, 620, 163, 32);
		contentPane.add(btnMenuUtama);
		
		JLabel lbl1 = new JLabel(colName[0]);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl1.setBounds(50,50,80,20);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel(colName[1]);
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl2.setBounds(140,50,80,20);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel(colName[2]);
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl3.setBounds(240,50,80,20);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel(colName[3]);
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl4.setBounds(420,50,80,20);
		contentPane.add(lbl4);
		
		JLabel lbl5 = new JLabel(colName[4]);
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl5.setBounds(520,50,80,20);
		contentPane.add(lbl5);
		
		JLabel lbl6 = new JLabel(colName[5]);
		lbl6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl6.setBounds(610,50,80,20);
		contentPane.add(lbl6);
		
		JLabel lbl7 = new JLabel(colName[6]);
		lbl7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl7.setBounds(700,50,80,20);
		contentPane.add(lbl7);
		
		JLabel lblHistoryEditProses = new JLabel("History Edit Proses Transaksi Penjualan Rumah");
		lblHistoryEditProses.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblHistoryEditProses.setBounds(116, 11, 543, 38);
		contentPane.add(lblHistoryEditProses);
		
		visibilityButton();
	}
	
	//---------PROSEDUR DAN FUNGSI------------
	
	public int countPage(){
		int temp,temphasil=0;
		temp = jumlahdata;
		while(temp/30!=0){
			temp-=30;
			temphasil++;
		}
			temphasil++;
			
		return temphasil;
	}
	
	public void showTable(){
		int idx = (page -1)*30;
		
		if(jumlahdata>=30){
			perpage = new Object[30][colName.length];
			for(int i=0;i<30;i++){
				perpage[i][0] = object[i+idx][0];
				perpage[i][1] = object[i+idx][1];
				perpage[i][2] = object[i+idx][2];
				perpage[i][3] = object[i+idx][3];
				perpage[i][4] = object[i+idx][4];
				perpage[i][5] = object[i+idx][5];
				perpage[i][6] = object[i+idx][6];
			}
		}else{
			perpage = new Object[jumlahdata][colName.length];
			for(int i=0;i<jumlahdata;i++){
				perpage[i][0] = object[i+idx][0];
				perpage[i][1] = object[i+idx][1];
				perpage[i][2] = object[i+idx][2];
				perpage[i][3] = object[i+idx][3];
				perpage[i][4] = object[i+idx][4];
				perpage[i][5] = object[i+idx][5];
				perpage[i][6] = object[i+idx][6];
			}
		}
		
	}
	public void visibilityButton(){
		if(page!=totalpage){
			if(page==1){
				button.setVisible(false);
				button_1.setVisible(true);
			}else{//bukan halaman 1, bukan halaman akhir
				button.setVisible(true);
				button_1.setVisible(true);
			}
		}else{//halaman akhir
			if(page==1){// cuma sehalaman berarti
				button.setVisible(false);
				button_1.setVisible(false);
			}else{//halaman akhir bukan 1
				button.setVisible(true);
				button_1.setVisible(false);
			}
		}
	}
}
