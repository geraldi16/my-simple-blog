import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;


public class MenuOwner extends JFrame {

	private JPanel contentPane;
	
	PetaAwal peta;
	HistoryEdit he;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOwner frame = new MenuOwner();
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
	public MenuOwner() {
		setTitle("Menu Owner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 220, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpdateHargaMana = new JButton("Log Out");
		btnUpdateHargaMana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				App frameLogin = new App();
				frameLogin.setVisible(true);
			}
		});
		btnUpdateHargaMana.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateHargaMana.setBounds(125, 61, 182, 30);
		contentPane.add(btnUpdateHargaMana);
		
		JButton btnUpdateHarga = new JButton("Update Harga Kavling");
		btnUpdateHarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				UpdateHargaKavling frameUpdateHarga = new UpdateHargaKavling();
				frameUpdateHarga.setVisible(true);

			}
		});
		btnUpdateHarga.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateHarga.setBounds(125, 102, 182, 32);
		contentPane.add(btnUpdateHarga);
		
		JButton btnLihatHistoryEdit = new JButton("Lihat History Edit");
		btnLihatHistoryEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLihatHistoryEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				he = new HistoryEdit();
				he.setVisible(true);
				setVisible(false);
			}
		});
		btnLihatHistoryEdit.setBounds(125, 145, 182, 30);
		contentPane.add(btnLihatHistoryEdit);
		
		JButton btnLihatSitemap = new JButton("Lihat Sitemap");
		btnLihatSitemap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLihatSitemap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				peta = new PetaAwal();
				peta.setVisible(true);
				
			}
		});
		btnLihatSitemap.setBounds(125, 186, 182, 30);
		contentPane.add(btnLihatSitemap);
		
		JLabel lblAnda = new JLabel("Anda masuk sebagai Owner");
		lblAnda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAnda.setBounds(104, 11, 229, 30);
		contentPane.add(lblAnda);
	}
}
