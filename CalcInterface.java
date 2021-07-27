package source;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalcInterface {
	private static JTextField Get_ip;
	private static JTextField txt_mask;
	private static JTextField txtI_n_mask;

	public void shWindow() {
		JFrame frame = new JFrame();
		frame.getContentPane().setFont(new Font("Source Sans Pro Black", Font.PLAIN, 13));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100,100,483,529);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb_IP = new JLabel("IP:");
		lb_IP.setFont(new Font("Source Code Pro Black", Font.BOLD | Font.ITALIC, 13));
		lb_IP.setBounds(47, 49, 56, 16);
		frame.getContentPane().add(lb_IP);
		
		Get_ip = new JTextField();
		Get_ip.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		Get_ip.setHorizontalAlignment(SwingConstants.CENTER);
		Get_ip.setBounds(186, 46, 172, 22);
		frame.getContentPane().add(Get_ip);
		Get_ip.setColumns(10);
		
		JLabel lb_mask_tittle = new JLabel("Máscara:");
		lb_mask_tittle.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		lb_mask_tittle.setBounds(28, 91, 75, 16);
		frame.getContentPane().add(lb_mask_tittle);
		
		txt_mask = new JTextField();
		txt_mask.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		txt_mask.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mask.setBounds(186, 88, 172, 22);
		frame.getContentPane().add(txt_mask);
		txt_mask.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nueva Máscara:");
		lblNewLabel_1.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(22, 136, 123, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtI_n_mask = new JTextField();
		txtI_n_mask.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		txtI_n_mask.setHorizontalAlignment(SwingConstants.CENTER);
		txtI_n_mask.setBounds(186, 133, 172, 22);
		frame.getContentPane().add(txtI_n_mask);
		txtI_n_mask.setColumns(10);
		
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(Get_ip.getText().isEmpty() || txtI_n_mask.getText().isEmpty() || txt_mask.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Ingresa los datos");
				}else {
					int type = Ip.selectType(Integer.parseInt(txt_mask.getText()));
					String [] subnets, hosts, bd;
					int mask = Integer.parseInt(txt_mask.getText());
					int n_mask = Integer.parseInt(txtI_n_mask.getText());
			
					if(type == 1) {
						try {
							IpA net = new IpA(Get_ip.getText(), mask, n_mask);
							subnets = net.makeSubnets();
							hosts = net.makeHost();
							bd = net.makeBd();
							CSVWriter f = new CSVWriter(subnets, hosts, bd, bd.length);
								
							JOptionPane.showMessageDialog(frame, "El archivo .csv ha sido creado");
								
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else if(type == 2) {
						try {
							IpB net = new IpB(Get_ip.getText(), mask, n_mask);
							subnets = net.makeSubnets();
							hosts = net.makeHost();
							bd = net.makeBd();
							CSVWriter f = new CSVWriter(subnets, hosts, bd, bd.length);
							
							JOptionPane.showMessageDialog(frame, "El archivo .csv ha sido creado");
							
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else if(type == 3) {
						try {
							IpC net = new IpC(Get_ip.getText(), mask, n_mask);
							subnets = net.makeSubnets();
							hosts = net.makeHost();
							bd = net.makeBd();
							CSVWriter f = new CSVWriter(subnets, hosts, bd, bd.length);
							
							JOptionPane.showMessageDialog(frame, "El archivo .csv ha sido creado");
								
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Argumentos inválidos", "FATAL ERROR!!!!", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
			
				
			}
		});
		btnNewButton.setFont(new Font("Source Serif Pro", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBounds(186, 229, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btn_back = new JButton("Volver");
		btn_back.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Menu m = new Menu();
				m.shMenu();
			}
		});
		btn_back.setBounds(340, 444, 97, 25);
		frame.getContentPane().add(btn_back);
		
		
	}
}
