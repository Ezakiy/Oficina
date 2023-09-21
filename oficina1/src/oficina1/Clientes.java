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
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtEscrevaAqui;
	private JTextField txtEscrevaAqui_2;
	private JTextField txtEscrevaAqui_3;
	private JTextField txtNif;
	private JLabel lblNewLabel_1;
	String id = "";
	private JButton btnEliminar;
	private JButton btnAtualizar;
	private JButton btnCarregarDados;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 75, 133, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNTelefone = new JLabel("N\u00BA telefone:");
		lblNTelefone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNTelefone.setBounds(10, 103, 133, 17);
		contentPane.add(lblNTelefone);
		
		JLabel lblMorada = new JLabel("Morada:");
		lblMorada.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMorada.setBounds(10, 131, 133, 17);
		contentPane.add(lblMorada);
		
		JLabel lblNif = new JLabel("NIF:");
		lblNif.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNif.setBounds(10, 159, 48, 17);
		contentPane.add(lblNif);
		
		txtEscrevaAqui = new JTextField();
		txtEscrevaAqui.setToolTipText("Escreva aqui...");
		txtEscrevaAqui.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEscrevaAqui.setBounds(119, 73, 198, 23);
		contentPane.add(txtEscrevaAqui);
		txtEscrevaAqui.setColumns(10);
		
		txtEscrevaAqui_2 = new JTextField();
		txtEscrevaAqui_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEscrevaAqui_2.setColumns(10);
		txtEscrevaAqui_2.setBounds(119, 103, 198, 23);
		contentPane.add(txtEscrevaAqui_2);
		
		txtEscrevaAqui_3 = new JTextField();
		txtEscrevaAqui_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEscrevaAqui_3.setColumns(10);
		txtEscrevaAqui_3.setBounds(119, 131, 198, 23);
		contentPane.add(txtEscrevaAqui_3);
		
		txtNif = new JTextField();
		txtNif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNif.setColumns(10);
		txtNif.setBounds(119, 159, 198, 23);
		contentPane.add(txtNif);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				    String sql="Insert into clientes (Nome,Telefone,Morada,NIF,Senha) Values ('"+txtEscrevaAqui.getText()+"','"+txtEscrevaAqui_2.getText()+"', '"+txtEscrevaAqui_3.getText()+"', '"+txtNif.getText()+"', '"+textField.getText()+"')";
				    Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
					Statement stmt=con.createStatement();	

					int ok=stmt.executeUpdate(sql);

						System.out.println("inseridas " + ok +  " linhas na BD");
						
						txtEscrevaAqui.setText("");						
						txtEscrevaAqui_2.setText("");
						txtEscrevaAqui_3.setText("");
						txtNif.setText("");
						textField.setText("");

					}catch (Exception ex1) {
				

						System.out.println(ex1);

					}
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from clientes";
                    
                    ResultSet rs=stmt.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    System.out.println("Carregar dados para a tabela");

                    con.close();
                    }
				catch(Exception ee){

                    	System.out.println(ee);

                    	}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(90, 232, 101, 34);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Gerir Clientes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(220, 11, 137, 49);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(340, 78, 289, 345);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql="DELETE from Clientes  where id='"+ id + "'";
				    Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");

					Statement stmt=con.createStatement();	

					int ok=stmt.executeUpdate(sql);

						System.out.println("Foi Apagada " + ok +  " linha na BD");
						
						txtEscrevaAqui.setText("");
						
						txtEscrevaAqui_2.setText("");
						txtEscrevaAqui_3.setText("");
						txtNif.setText("");
						

					}catch (Exception ex1) {
				
						System.out.println(ex1);

					}
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from clientes";
                    
                    ResultSet rs=stmt.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    System.out.println("Carregar dados para a tabela");

                    con.close();
                    }
				catch(Exception ee){

                    	System.out.println(ee);

                    	}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminar.setBounds(205, 232, 112, 34);
		contentPane.add(btnEliminar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				    String sql="UPDATE Clientes SET nome='"+txtEscrevaAqui.getText()+"', telefone='"+txtEscrevaAqui_2.getText()+"', '"+txtEscrevaAqui_3.getText()+"', '"+txtNif.getText()+"' WHERE id='"+ id +"'";;
				    Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
					Statement stmt=con.createStatement();	

					int ok=stmt.executeUpdate(sql);

						System.out.println("Foi Editado " + ok +  " linha na BD");
						
						txtEscrevaAqui.setText("");
						
						txtEscrevaAqui_2.setText("");
						txtEscrevaAqui_3.setText("");
						txtNif.setText("");

					}catch (Exception ex1) {

						System.out.println(ex1);

					}
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from clientes";
                    
                    ResultSet rs=stmt.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    System.out.println("Carregar dados para a tabela");

                    con.close();
                    }
				catch(Exception ee){

                    	System.out.println(ee);

                    	}
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAtualizar.setBounds(205, 280, 112, 34);
		contentPane.add(btnAtualizar);
		
		btnCarregarDados = new JButton("Carregar Dados");
		btnCarregarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from clientes";
                    
                    ResultSet rs=stmt.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    System.out.println("Carregar dados para a tabela");

                    con.close();
                    }
				catch(Exception ee){

                    	System.out.println(ee);

                    	}
			}
		});
		btnCarregarDados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCarregarDados.setBounds(193, 390, 137, 33);
		contentPane.add(btnCarregarDados);
		
		JButton btnNewButton_1 = new JButton("<---");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Oficina_Inicio oficina_Inicio = new Oficina_Inicio();
				oficina_Inicio.setVisible(true);
			    setVisible(false);
			}

			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 11, 72, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSenha.setBounds(10, 187, 88, 17);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(119, 193, 198, 23);
		contentPane.add(textField);
	}
}
