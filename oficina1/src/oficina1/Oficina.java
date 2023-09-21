package oficina1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Oficina extends JFrame {

	private JPanel contentPane;
	private JTextField txtIntroduzaONome;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oficina frame = new Oficina();
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
	public Oficina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome de Utilizador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 117, 156, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblPalavrapasse = new JLabel("Palavra-passe:");
		lblPalavrapasse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPalavrapasse.setBounds(10, 163, 156, 19);
		contentPane.add(lblPalavrapasse);
		
		txtIntroduzaONome = new JTextField();	
		txtIntroduzaONome.setText("Introduza o seu nome de utilizador");
		txtIntroduzaONome.setBounds(176, 119, 227, 20);
		contentPane.add(txtIntroduzaONome);
		txtIntroduzaONome.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Oficina");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(206, 32, 71, 19);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Iniciar sess\u00E3o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from clientes";                  
                    ResultSet rs=stmt.executeQuery(sql);

                    if (!rs.next()) {                           
                    	System.out.println("No records found");
                    	Oficina_Inicio Oficina_Inicio = new Oficina_Inicio();
        				Oficina_Inicio.setVisible(true);
        			    setVisible(false);
                    }
                    else {
                    	do {
                    										
                    		} while (rs.next());
                    	
                    	}
                    }
				catch(Exception ee){

                    	System.out.println(ee);

                    	}
				
				}

		
		});
		btnNewButton.setBounds(193, 230, 122, 42);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(176, 165, 227, 20);
		contentPane.add(passwordField);
	}

	
}
