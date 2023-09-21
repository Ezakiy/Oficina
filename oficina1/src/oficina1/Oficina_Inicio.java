package oficina1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Oficina_Inicio extends JFrame {

	private JPanel contentPane;
	private JTable table;
	protected Window Oficina_Inicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oficina_Inicio frame = new Oficina_Inicio();
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
	public Oficina_Inicio() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gerir Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes cl=new Clientes();
				cl.setVisible (true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(79, 99, 147, 43);
		contentPane.add(btnNewButton);
		
		JButton btnGerirFunc = new JButton("Gerir Funcion\u00E1rios");
		btnGerirFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario cl=new Funcionario();
				cl.setVisible (true);
			}
		});
		btnGerirFunc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGerirFunc.setBounds(79, 153, 147, 43);
		contentPane.add(btnGerirFunc);
		
		JButton btnGerirReparaes = new JButton("Gerir Repara\u00E7\u00F5es");
		btnGerirReparaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reparacao cl=new Reparacao();
				cl.setVisible (true);
			}
		});
		btnGerirReparaes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGerirReparaes.setBounds(236, 153, 148, 43);
		contentPane.add(btnGerirReparaes);
		
		JButton btnGerirAutomveis = new JButton("Gerir Automoveis");
		btnGerirAutomveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Automovel cl=new Automovel();
				cl.setVisible (true);
			}
		});
		btnGerirAutomveis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGerirAutomveis.setBounds(236, 99, 148, 43);
		contentPane.add(btnGerirAutomveis);
		
		table = new JTable();
		table.setBounds(150, 57, 87, -23);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Geração da Oficina");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(137, 11, 201, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("<---");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Oficina oficina = new Oficina();
				oficina.setVisible(true);
				setVisible(false);
				   
			    
			}

			
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 11, 72, 23);
		contentPane.add(btnNewButton_1);
	}
}
