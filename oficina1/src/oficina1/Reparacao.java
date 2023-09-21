package oficina1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Reparacao extends JFrame {

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
					Reparacao frame = new Reparacao();
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
	public Reparacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerir Reparações");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(227, 11, 190, 28);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(329, 82, 276, 291);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 87, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kms:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 112, 79, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(10, 137, 79, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Valor:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(10, 162, 79, 14);
		contentPane.add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(121, 87, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 112, 185, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(121, 137, 185, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(121, 162, 185, 20);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				    String sql="Insert into reparacao (Data,Kms,Descricao,Valor) Values ('"+textField.getText()+"', '"+textField_1.getText()+"','"+textField_2.getText()+"' , '"+textField_3.getText() +"')";
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
                    String sql="Select * from reparacao";
                    
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(101, 193, 99, 34);
		contentPane.add(btnNewButton);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql="DELETE from reparacao where id='"+ id + "'";
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
                    String sql="Select * from reparacao";
                    
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
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEliminar.setBounds(207, 193, 99, 34);
		contentPane.add(btnEliminar);
		
		JButton btnCarregarDados = new JButton("Carregar Dados");
		btnCarregarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from reparacao";
                    
                    ResultSet rs=stmt.executeQuery(sql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    System.out.println("Carregar dados para a tabela");

                    con.close();
                    }
				catch(Exception ee){

                    	System.out.println(ee);

                    	}
				
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from reparacao";
                    
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
		btnCarregarDados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCarregarDados.setBounds(185, 336, 134, 37);
		contentPane.add(btnCarregarDados);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				    String sql="UPDATE reparacao SET nome='"+textField.getText()+"', email='"+textField_1.getText()+"', telefone='"+textField_2.getText()+"' WHERE id='"+ id +"'";;
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
                    String sql="Select * from reparacao";
                    
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
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtualizar.setBounds(207, 238, 99, 34);
		contentPane.add(btnAtualizar);
		
		JButton btnNewButton_1 = new JButton("<---");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Oficina_Inicio oficina_Inicio = new Oficina_Inicio();
				oficina_Inicio.setVisible(true);
			    setVisible(false);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 11, 72, 23);
		contentPane.add(btnNewButton_1);
	}

}
