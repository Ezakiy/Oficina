package oficina1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Automovel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String id = "";
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Automovel frame = new Automovel();
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
	public Automovel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerir Autom\u00F3veis");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(240, 12, 191, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matricula:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 76, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Marca:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 109, 97, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Modelo:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(10, 142, 97, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ano:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1.setBounds(10, 173, 97, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(91, 76, 163, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 109, 163, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 142, 163, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(91, 173, 163, 22);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				    String sql="Insert into automovel (Matricula,Marca,Modelo,Ano) Values ('"+textField.getText()+"', '"+textField_1.getText()+"','"+textField_2.getText()+"' , '"+textField_3.getText()+ "')";
				    Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
					Statement stmt=con.createStatement();	

					int ok=stmt.executeUpdate(sql);

						System.out.println("inseridas " + ok +  " linhas na BD");
						
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						

					}catch (Exception ex1) {
			

						System.out.println(ex1);

					}
				
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from Automovel";
                    
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 217, 114, 37);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 69, 327, 308);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btneliminar = new JButton("Eliminar");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql="DELETE from automovel where matricula='"+ id + "'";
				    Class.forName("com.mysql.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
					Statement stmt=con.createStatement();	

					int ok=stmt.executeUpdate(sql);

						System.out.println("Foi Apagada " + ok +  " linha na BD");
						
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						

					}catch (Exception ex1) {
				
						System.out.println(ex1);

					}
				
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from Automovel";
                    
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
		btneliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btneliminar.setBounds(140, 217, 114, 37);
		contentPane.add(btneliminar
				);
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				    String sql="UPDATE automovel SET Marca='"+textField_1.getText()+"', Modelo='"+textField_2.getText()+"' , Ano='"+textField_3.getText()+"' WHERE matricula='"+ id +"'";
				    Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
					Statement stmt=con.createStatement();	

					int ok=stmt.executeUpdate(sql);

						System.out.println("Foi Editado " + ok +  " linha na BD");
						
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						

					}catch (Exception ex1) {

						System.out.println(ex1);

					}
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from Automovel";
                    
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(140, 265, 114, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnCarregarDados = new JButton("Carregar Dados");
		btnCarregarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from Automovel";
                    
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
		btnCarregarDados.setBounds(119, 335, 135, 30);
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
		btnNewButton_1.setBounds(10, 14, 72, 23);
		contentPane.add(btnNewButton_1);
	}

}
