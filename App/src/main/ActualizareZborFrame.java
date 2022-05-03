package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ActualizareZborFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNrZbor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizareZborFrame frame = new ActualizareZborFrame();
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
	public ActualizareZborFrame() {
		setTitle("Actualizare zbor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(168, 208, 224)); // the color of the MainFrame #a8d0e6
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNrZbor = new JLabel("Numar zbor:");
		lblNrZbor.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblNrZbor.setBounds(116, 28, 130, 24);
		contentPane.add(lblNrZbor);
		
		txtNrZbor = new JTextField();
		txtNrZbor.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtNrZbor.setBounds(249, 28, 199, 22);
		contentPane.add(txtNrZbor);
		txtNrZbor.setColumns(10);
		
		JList listaZboruri = new JList();
		listaZboruri.setFont(new Font("Consolas", Font.PLAIN, 16));
		listaZboruri.setBounds(10, 131, 566, 222);
		contentPane.add(listaZboruri);
		
		JButton btnCautare = new JButton("Cautare");
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNrZbor.getText().trim().equals(""))
					JOptionPane.showMessageDialog(null, "Introduceti numarul zborului!", "Cautare invalida",JOptionPane.WARNING_MESSAGE);
				else {
					//verificare daca numarul zborului din caseta coincide cu vreunul din lista de zboruri
					//in caz afirmativ, butonul "Actualizare" devine Enabled iar in JList apare zborul respectiv cu toate detaliile
					//daca nu s-a gasit zborul, se afiseaza un mesaj corespunzator
				}
			}
		});
		btnCautare.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCautare.setBounds(10, 76, 148, 45);
		btnCautare.setForeground(Color.WHITE);
		btnCautare.setBackground(new Color(55, 71, 133));
		btnCautare.setOpaque(true);
		contentPane.add(btnCautare);
		
		JButton btnActualizare = new JButton("Actualizare");
		btnActualizare.setEnabled(false);
		btnActualizare.setForeground(Color.WHITE);
		btnActualizare.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnActualizare.setBounds(428, 76, 148, 45);
		btnActualizare.setBackground(new Color(55, 71, 133));
		btnActualizare.setOpaque(true);
		contentPane.add(btnActualizare);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Doriti sa va intoarceti inapoi?", "Inchidere fereastra", 
			            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
						== JOptionPane.YES_OPTION) {
					OptiuniStaffFrame optiuni_staff = new OptiuniStaffFrame();
					optiuni_staff.setVisible(true);
					setVisible(false);
				}
			}
		});
	}
}
