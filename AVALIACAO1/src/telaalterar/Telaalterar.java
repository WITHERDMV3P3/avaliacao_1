package telaalterar;

import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import teladois.Teladois;
import telaum.Telaum;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JButton;

public class Telaalterar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JLabel lblCdigoDeBarras;
	private JLabel lblDescrio;
	private JTextField textField_2;
	private JLabel lblQuantidade;
	private JTextField textField_3;
	private JLabel lblPreo;
	private JTextField textField_4;
	private JLabel lblMarca;
	private JTextField textField_5;
	private JLabel lblCategoria;
	private JTextField textField_6;
	private JButton btnNewButton;
	private JTextField textField;
	private JLabel codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Telaalterar chamaralterar = new Telaalterar();
		chamaralterar.chamartela();
	}

	/**
	 * Create the frame.
	 */
	public void chamartela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telaalterar frame = new Telaalterar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Telaalterar() {
		setResizable(false);
		setTitle("TELA ALTERAR");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 429);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 82, 291, 20);
		contentPane.add(textField_1);
		
		lblCdigoDeBarras = new JLabel("Código de Barras");
		lblCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));
		lblCdigoDeBarras.setBounds(180, 62, 122, 18);
		contentPane.add(lblCdigoDeBarras);
		
		lblDescrio = new JLabel("Descrição*");
		lblDescrio.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescrio.setBounds(34, 122, 86, 18);
		contentPane.add(lblDescrio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(34, 142, 482, 20);
		contentPane.add(textField_2);
		
		lblQuantidade = new JLabel("Quantidade*");
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 14));
		lblQuantidade.setBounds(34, 187, 86, 18);
		contentPane.add(lblQuantidade);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(34, 207, 99, 20);
		contentPane.add(textField_3);
		
		lblPreo = new JLabel("Preço*");
		lblPreo.setFont(new Font("Arial", Font.BOLD, 14));
		lblPreo.setBounds(166, 187, 52, 18);
		contentPane.add(lblPreo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(166, 207, 99, 20);
		contentPane.add(textField_4);
		
		lblMarca = new JLabel("Marca*");
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));
		lblMarca.setBounds(291, 187, 86, 18);
		contentPane.add(lblMarca);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(291, 207, 99, 20);
		contentPane.add(textField_5);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategoria.setBounds(417, 187, 86, 18);
		contentPane.add(lblCategoria);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(417, 207, 99, 20);
		contentPane.add(textField_6);
		
		btnNewButton = new JButton("ALTERAR");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(212, 265, 122, 42);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(34, 82, 99, 20);
		contentPane.add(textField);
		
		codigo = new JLabel("Código");
		codigo.setFont(new Font("Arial", Font.BOLD, 14));
		codigo.setBounds(34, 62, 86, 18);
		contentPane.add(codigo);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			alterardados();					
			}
		});
			
	}
	
	public void alterardados(){
		Telaum telaum = new Telaum();
		telaum.connect();
			String sql = "UPDATE avaliacao SET codigodebarra = ?, descricao = ?, quantidade = ? , preco= ?, marca = ?, categoria = ? WHERE id = ? ";
			try(Connection bancoavaliacao = telaum.connect();
					PreparedStatement registro = bancoavaliacao.prepareStatement(sql)){
				registro.setString(1, textField_1.getText().toString());
				registro.setString(2, textField_2.getText().toString());
				registro.setString(3, textField_3.getText().toString());
				registro.setString(4, textField_4.getText().toString());
				registro.setString(5, textField_5.getText().toString());
				registro.setString(6, textField_6.getText().toString());
				registro.setString(7, textField.getText().toString());
				registro.executeUpdate();
				bancoavaliacao.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
		}
	}
	public void preenchercampos(int codigo, int codigodebarra, String descricao, int quantidade, float preco, String marca, String categoria ) {
		textField.setText(String.valueOf(codigo));
		textField_1.setText(String.valueOf(codigodebarra));
		textField_2.setText(descricao);
		textField_3.setText(String.valueOf(quantidade));
		textField_4.setText(String.valueOf(preco));
		textField_5.setText(marca);
		textField_6.setText(categoria);
	}
}

