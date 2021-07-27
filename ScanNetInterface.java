package source;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ScanNetInterface {
	private static JTextField address;
	
	/**
	 * Interfas para inciar el escaneo en la red
	 */
	public static void showInterface() {
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100,100,483,322);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Host IP");
		lblNewLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(34, 30, 83, 33);
		frame.getContentPane().add(lblNewLabel);
		
		address = new JTextField();
		address.setBounds(143, 37, 116, 22);
		frame.getContentPane().add(address);
		address.setColumns(10);
		
		JButton EnterButton = new JButton("ENTER");
		EnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(address.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Ingresa los datos");
				}else {
					String ip = address.getText();
					try {
						ScanNet net = new ScanNet(ip);
						net.scanMyNet(ip);
					} catch (IllegalArgumentException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}
		});
		EnterButton.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 13));
		EnterButton.setBounds(192, 141, 97, 25);
		frame.getContentPane().add(EnterButton);
		
		JButton btn_back = new JButton("Volver");
		btn_back.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Menu m = new Menu();
				m.shMenu();
			}
		});
		btn_back.setBounds(345, 237, 97, 25);
		frame.getContentPane().add(btn_back);	
	}
	
}
