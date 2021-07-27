package source;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Menu {

	public static void main(String[] args) {
		shMenu();
	}
	
	/*
	 *Función que arranca la interfas gráfica del programa, mostrando el menú de opciones.
	 *En esta sección se inician las determinadas clases, según la opción elegida.
	 */
	public static void shMenu() {
		
		//Frame principal de la ventana
		JFrame frame = new JFrame();	
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100,100,502,594);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Label
		JLabel lb_tittle = new JLabel("Networking tool-kit");
		lb_tittle.setFont(new Font("RomanD", Font.BOLD, 20));
		lb_tittle.setBounds(112, 13, 262, 110);
		frame.getContentPane().add(lb_tittle);
		
		//Botón para iniciar la calculadora
		JButton btn_ini_calc = new JButton("Calculadora de redes (classful) ");
		btn_ini_calc.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btn_ini_calc.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		btn_ini_calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CalcInterface n = new CalcInterface();
				n.shWindow();
				
			}
		});
		btn_ini_calc.setBounds(102, 157, 272, 25);
		frame.getContentPane().add(btn_ini_calc);
	
		//Botón para iniciar la prueba de conexión
		JButton btn_ini_ping = new JButton("Prueba de conexión");
		btn_ini_ping.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		btn_ini_ping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PingInterface f = new PingInterface();
				f.shInterface();
			}
		});
		btn_ini_ping.setBounds(100, 235, 274, 25);
		frame.getContentPane().add(btn_ini_ping);
		
		//Botón para inciar la verificación de hosts en la red
		JButton btn_ini_hosts = new JButton("Ver host en la red");
		btn_ini_hosts.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		btn_ini_hosts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ScanNetInterface g = new ScanNetInterface();
				g.showInterface();
			}
		});
		btn_ini_hosts.setBounds(102, 316, 272, 25);
		frame.getContentPane().add(btn_ini_hosts);
		
		//Botón para generar tráfico en la red
		JButton btn_ini_Dos = new JButton("Generar tráfico");
		btn_ini_Dos.setFont(new Font("Source Serif Pro Black", Font.BOLD | Font.ITALIC, 13));
		btn_ini_Dos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DoSInterface dd = new DoSInterface();
				dd.interfaceShow();
				
			}
		});
		btn_ini_Dos.setBounds(100, 401, 274, 25);
		frame.getContentPane().add(btn_ini_Dos);
		
	}
}
