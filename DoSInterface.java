package source;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoSInterface {
	private static JTextField victim;
	private static JTextField Package_num;

	/**
	 * Interfaz para generar tráfico en la red
	 */
	public static void interfaceShow() {
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100,100,484,322);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		victim = new JTextField();
		victim.setBounds(177, 31, 178, 22);
		frame.getContentPane().add(victim);
		victim.setColumns(10);
		
		Package_num = new JTextField();
		Package_num.setBounds(177, 101, 178, 22);
		frame.getContentPane().add(Package_num);
		Package_num.setColumns(10);
		
		
		JLabel Ip_tittle = new JLabel("IP:");
		Ip_tittle.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 20));
		Ip_tittle.setBounds(109, 32, 56, 16);
		frame.getContentPane().add(Ip_tittle);
		
		JButton Ini_attack = new JButton("Inicio");
		Ini_attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(victim.getText().isEmpty() || Package_num.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Ingresa los datos");
				}else {
					String ip = victim.getText();
					int packages = Integer.parseInt(Package_num.getText());
					DoS dd;
					try {
						dd = new DoS(ip, packages);
						try {
							dd.attack(ip, packages);
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (IllegalArgumentException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					 
				}
				
			}
		});
		Ini_attack.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 15));
		Ini_attack.setBounds(188, 156, 97, 25);
		frame.getContentPane().add(Ini_attack);
		
		JLabel lblNewLabel = new JLabel("Número de paquetes");
		lblNewLabel.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(12, 83, 153, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(Por hilo 1-1000000)");
		lblNewLabel_1.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(12, 104, 153, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		
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
