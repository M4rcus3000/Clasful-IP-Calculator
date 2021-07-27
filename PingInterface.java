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
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class PingInterface {
	private static JTextField Get_ip;
	/**
	 * Interfas para probar la conexión
	 */
	public static void shInterface() {
		
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100,100,483,322);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb_ip_tiitle = new JLabel("IP:");
		lb_ip_tiitle.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 20));
		lb_ip_tiitle.setBounds(100, 32, 53, 19);
		frame.getContentPane().add(lb_ip_tiitle);
		
		Get_ip = new JTextField();
		Get_ip.setText("");
		Get_ip.setBounds(201, 32, 128, 22);
		frame.getContentPane().add(Get_ip);
		Get_ip.setColumns(10);
	
		
		JButton Calc = new JButton("ENTER");
		Calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Get_ip.getText().isEmpty() || Get_ip.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Ingresa los datos");
				}else {
					String ip = Get_ip.getText();
					
					try {
						PingToInternet h = new PingToInternet(ip);
						h.ping();
						
					} catch (IllegalArgumentException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		Calc.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		Calc.setBounds(179, 139, 97, 25);
		frame.getContentPane().add(Calc);
		
		
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
