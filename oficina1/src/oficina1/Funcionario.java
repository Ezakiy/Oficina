package oficina1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Funcionario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	String id = "";
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionario frame = new Funcionario();
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
	public Funcionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(76, 78, 221, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numero:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 78, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome.setBounds(10, 103, 56, 14);
		contentPane.add(lblNome);
		
		JLabel lblMorada = new JLabel("Morada:");
		lblMorada.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMorada.setBounds(10, 128, 69, 14);
		contentPane.add(lblMorada);
		
		JLabel lblNDe = new JLabel("NIF:");
		lblNDe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNDe.setBounds(10, 153, 44, 14);
		contentPane.add(lblNDe);
		
		JLabel lblNib = new JLabel("N\u00BA Seguran\u00E7a Social:");
		lblNib.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNib.setBounds(10, 178, 155, 14);
		contentPane.add(lblNib);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(76, 103, 221, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(76, 128, 221, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(76, 153, 221, 20);
		contentPane.add(textField_3);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(158, 178, 139, 20);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				    String sql="Insert into Funcionario (Numero,Nome,Morada,Numero_Seguranca_social,NIF) Values ('"+textField.getText()+"', '"+textField_1.getText()+"','"+textField_2.getText()+"' , '"+textField_3.getText()+"' , '"+textField_4.getText()+"')";
				    Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
					Statement stmt=con.createStatement();	

					int ok=stmt.executeUpdate(sql);

						System.out.println("inseridas " + ok +  " linhas na BD");
						
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");

					}catch (Exception ex1) {

						System.out.println(ex1);

					}
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from Funcionario";
                    
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
		btnNewButton.setBounds(76, 223, 111, 34);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Gerir Funcion\u00E1rios");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(187, 11, 176, 14);
		contentPane.add(lblNewLabel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(336, 50, 306, 364);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int index=table.getSelectedRow();

			    TableModel row=table.getModel();

			  

			    id=row.getValueAt(index, 0).toString();
			    textField.setText(row.getValueAt(index, 0).toString());
			    textField_1.setText(row.getValueAt(index, 1).toString());
			    textField_2.setText(row.getValueAt(index, 2).toString());
			    textField_3.setText(row.getValueAt(index, 3).toString());
			    textField_4.setText(row.getValueAt(index, 4).toString());
			}
			
		});
		scrollPane.setViewportView(table);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql="DELETE from Funcionario where numero='"+ id + "'";
				    Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
					Statement stmt=con.createStatement();	

					int ok=stmt.executeUpdate(sql);
					

						System.out.println("Foi Apagada " + ok +  " linha na BD");
					
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						

					}catch (Exception ex1) {
				
						System.out.println(ex1);

					}
				try { 

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
                    Statement stmt=con.createStatement();
                    String sql="Select * from Funcionario";
                    
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
		btnEliminar.setBounds(204, 221, 104, 36);
		contentPane.add(btnEliminar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Pretende Editar este registo?", "Aten��o!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					try {
						
					    String sql="UPDATE Funcionario SET Numero='"+textField.getText()+"', Nome='"+textField_1.getText()+"', Morada='"+textField_2.getText()+"' , Numero_Seguranca_social='"+textField_3.getText()+"' , NIF='"+textField_4.getText()+"' WHERE numero='"+ id +"'";;
					    Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
						Statement stmt=con.createStatement();	

						int ok=stmt.executeUpdate(sql);

							System.out.println("Foi Editado " + ok +  " linha na BD");
							
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");

						}catch (Exception ex1) {

							System.out.println(ex1);

						}
					try { 

	                    Class.forName("com.mysql.jdbc.Driver");
	                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
	                    Statement stmt=con.createStatement();
	                    String sql="Select * from Funcionario";
	                    
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
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAtualizar.setBounds(204, 268, 104, 36);
		contentPane.add(btnAtualizar);
		
		JButton btnCarregarDados = new JButton("Carregar Dados");
		btnCarregarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Pretende Editar este registo?", "Aten��o!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					try { 

	                    Class.forName("com.mysql.jdbc.Driver");
	                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinarui","root","");
	                    Statement stmt=con.createStatement();
	                    String sql="Select * from Funcionario";
	                    
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
			}
		});
		btnCarregarDados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCarregarDados.setBounds(209, 367, 117, 36);
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
		btnNewButton_1.setBounds(10, 10, 72, 23);
		contentPane.add(btnNewButton_1);
	}
}
