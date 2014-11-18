import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class PetaAwal extends JFrame {

	private JPanel contentPane;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private JRadioButton radio4;
	private JRadioButton radio5;
	private JRadioButton radio6;
	private JRadioButton radio7;
	private JRadioButton radio8;
	private JRadioButton radio9;
	private JRadioButton radio10;
	private JRadioButton radio11;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetaAwal frame = new PetaAwal();
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
	public PetaAwal() {
		setTitle("Siteplan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_10 = new JButton("11");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_10.setBounds(138, 635, 48, 30);
		contentPane.add(button_10);
		
		JButton button_7 = new JButton("8");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_7.setBounds(229, 509, 42, 30);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_8.setBounds(202, 557, 42, 30);
		contentPane.add(button_8);
		
		JButton button_6 = new JButton("7");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_6.setBounds(202, 425, 42, 30);
		contentPane.add(button_6);
		
		JButton button_9 = new JButton("10");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_9.setBounds(179, 601, 48, 30);
		contentPane.add(button_9);
		
		JButton button_4 = new JButton("5");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_4.setBounds(91, 557, 42, 30);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_5.setBounds(99, 384, 42, 30);
		contentPane.add(button_5);
		
		JButton button_3 = new JButton("4");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setBounds(146, 425, 42, 30);
		contentPane.add(button_3);
		
		JButton button_2 = new JButton("3");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setBounds(166, 337, 42, 30);
		contentPane.add(button_2);
		
		JButton button_1 = new JButton("2");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(138, 238, 42, 30);
		contentPane.add(button_1);
		
		JButton button = new JButton("1");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(123, 113, 42, 30);
		contentPane.add(button);
		
				
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PetaAwal.class.getResource("/gambar/Full.png")));
		lblNewLabel.setBounds(-136, 7, 486, 700);
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("1. KutaRaya, 1 - 18");
		radio1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio1.setBounds(447, 146, 400, 23);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("2. Blok A, 1 - 23");
		radio2.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio2.setBounds(447, 176, 400, 23);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("3. KutaRaya, 19 - 31");
		radio3.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio3.setBounds(447, 206, 400, 23);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("4. KutaRaya, 32 - 52");
		radio4.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio4.setBounds(447, 236, 400, 23);
		contentPane.add(radio4);
		
		radio5 = new JRadioButton("5. KutaRaya, 53 - 72");
		radio5.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio5.setBounds(447, 266, 400, 23);
		contentPane.add(radio5);
		
		radio6 = new JRadioButton("6. Blok B, 1-23");
		radio6.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio6.setBounds(447, 296, 400, 23);
		contentPane.add(radio6);
		
		radio7 = new JRadioButton("7. Blok C, 1 ; 11 - 29");
		radio7.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio7.setBounds(447, 326, 400, 23);
		contentPane.add(radio7);
		
		radio8 = new JRadioButton("8. Blok D, 34 - 67");
		radio8.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio8.setBounds(447, 356, 400, 23);
		contentPane.add(radio8);
		
		radio9 = new JRadioButton("9. Blok D, 1 - 33 ; 68 - 73");
		radio9.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio9.setBounds(447, 386, 400, 23);
		contentPane.add(radio9);
		
		radio10 = new JRadioButton("10. Blook D, 74 - 116");
		radio10.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio10.setBounds(447, 416, 400, 23);
		contentPane.add(radio10);
		
		radio11 = new JRadioButton("11. Blok E, 1 - 35");
		radio11.setFont(new Font("Monospaced", Font.PLAIN, 16));
		radio11.setBounds(447, 446, 400, 23);
		contentPane.add(radio11);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radio1);
		bg.add(radio2);
		bg.add(radio3);
		bg.add(radio4);
		bg.add(radio5);
		bg.add(radio6);
		bg.add(radio7);
		bg.add(radio8);
		bg.add(radio9);
		bg.add(radio10);
		bg.add(radio11);
		
		JLabel lblKeterangan = new JLabel("KETERANGAN !");
		lblKeterangan.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeterangan.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblKeterangan.setBounds(447, 84, 303, 48);
		contentPane.add(lblKeterangan);
		
		JButton btnPilih = new JButton("Perbesar Peta");
		btnPilih.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				masukFrame(getPilihanPeta());
			}
		});
		btnPilih.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPilih.setBounds(451, 503, 159, 34);
		contentPane.add(btnPilih);
		
		if(App.status==0){
			JButton btnKembali = new JButton("Log Out");
			btnKembali.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					App frameLogin = new App();
					frameLogin.setVisible(true);
				}
			});
			btnKembali.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnKembali.setBounds(648, 502, 159, 34);
			contentPane.add(btnKembali);
		}else{//owner
			JButton btnKembali = new JButton("Menu Owner");
			btnKembali.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					MenuOwner frameLogin = new MenuOwner();
					frameLogin.setVisible(true);
				}
			});
			btnKembali.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnKembali.setBounds(648, 502, 159, 34);
			contentPane.add(btnKembali);
		}
		
	}
	
	public int getPilihanPeta(){
		int pilihan;
		if (radio1.isSelected()){
			pilihan = 1;
		}
		else if (radio2.isSelected()){
			pilihan = 2;
		}
		else if (radio3.isSelected()){
			pilihan = 3;
		}
		else if (radio3.isSelected()){
			pilihan = 3;
		}
		else if (radio4.isSelected()){
			pilihan = 4;
		}
		else if (radio5.isSelected()){
			pilihan = 5;
		}
		else if (radio6.isSelected()){
			pilihan = 6;
		}
		else if (radio7.isSelected()){
			pilihan = 7;
		}
		else if (radio8.isSelected()){
			pilihan = 8;
		}
		else if (radio9.isSelected()){
			pilihan = 9;
		}
		else if (radio10.isSelected()){
			pilihan = 10;
		}
		else if (radio11.isSelected()){
			pilihan = 11;
		}
		else{
			pilihan = 0;
		}
		return pilihan;
	}
	
	public void masukFrame(int pilihan){
		switch (pilihan){
		case 1 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 1");
			this.setVisible(false);
			Frame1 frame1 = new Frame1();
			frame1.setVisible(true);
			break;
			
		case 2 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 2");
			this.setVisible(false);
			Frame2 frame2 = new Frame2();
			frame2.setVisible(true);
			break;

		case 3 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 3");
			this.setVisible(false);
			Frame3 frame3 = new Frame3();
			frame3.setVisible(true);
			break;

		case 4 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 4");
			this.setVisible(false);
			Frame4 frame4 = new Frame4();
			frame4.setVisible(true);
			break;

		case 5 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 5");
			this.setVisible(false);
			Frame5 frame5 = new Frame5();
			frame5.setVisible(true);
			break;

		case 6 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 6");
			this.setVisible(false);
			Frame6 frame6 = new Frame6();
			frame6.setVisible(true);
			break;
			
		case 7 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 7");
			this.setVisible(false);
			Frame7 frame7 = new Frame7();
			frame7.setVisible(true);
			break;

			
		case 8 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 8");
			this.setVisible(false);
			Frame8 frame8 = new Frame8();
			frame8.setVisible(true);
			break;

			
		case 9 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 9");
			this.setVisible(false);
			Frame9 frame9 = new Frame9();
			frame9.setVisible(true);
			break;

			
		case 10 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 10");
			this.setVisible(false);
			Frame10 frame10 = new Frame10();
			frame10.setVisible(true);
			break;

			
		case 11 :
//			JOptionPane.showMessageDialog(null, "Perbesar lokasi 11");
			this.setVisible(false);
			Frame11 frame11 = new Frame11();
			frame11.setVisible(true);
			break;
			
		default :
			JOptionPane.showMessageDialog(null, "Isi dahulu pilihan tempat yang dituju!");
		}
	}

}
