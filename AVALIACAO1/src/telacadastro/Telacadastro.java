package telacadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;

import telatabela.Telatabela;

import javax.swing.border.CompoundBorder;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JTextArea;
import java.awt.Point;
import java.awt.Color;

public class Telacadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_1;
	private JLabel lblCdigoDeBarras;
	private JLabel lblDescrio;
	public JTextField textField_2;
	private JLabel lblQuantidade;
	public JTextField textField_3;
	private JLabel lblPreo;
	public JTextField textField_4;
	private JLabel lblMarca;
	public JTextField textField_5;
	private JLabel lblCategoria;
	public JTextField textField_6;
	private JButton btnNewButton;
	private JButton btnLista;
	private JButton btnLista_1;
	private JTextField txtInserirCdigoDe;

	///////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		Telacadastro chamar = new Telacadastro();
		chamar.metodoum();
	}
	//////////////////////////////////////////////////////////////////////////////////////
	public void metodoum() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telacadastro frame = new Telacadastro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Telacadastro() {
		setResizable(false);
		setTitle("TELA CADASTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblCdigoDeBarras = new JLabel("Código de Barras");
		lblCdigoDeBarras.setForeground(new Color(255, 255, 255));
		lblCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));
		lblCdigoDeBarras.setBounds(36, 25, 122, 18);
		contentPane.add(lblCdigoDeBarras);
		
		lblDescrio = new JLabel("Descrição*");
		lblDescrio.setForeground(new Color(255, 255, 255));
		lblDescrio.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescrio.setBounds(36, 92, 86, 18);
		contentPane.add(lblDescrio);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("INSERIR DESCRIÇÃO DO PRODUTO");
		textField_2.setColumns(10);
		textField_2.setBounds(36, 112, 482, 20);
		contentPane.add(textField_2);
		
		lblQuantidade = new JLabel("Quantidade*");
		lblQuantidade.setForeground(new Color(255, 255, 255));
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 14));
		lblQuantidade.setBounds(36, 157, 86, 18);
		contentPane.add(lblQuantidade);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("INSERIR QUANTIDADE DO PRODUTO");
		textField_3.setColumns(10);
		textField_3.setBounds(36, 177, 99, 20);
		contentPane.add(textField_3);
		
		lblPreo = new JLabel("Preço*");
		lblPreo.setForeground(new Color(255, 255, 255));
		lblPreo.setFont(new Font("Arial", Font.BOLD, 14));
		lblPreo.setBounds(168, 157, 52, 18);
		contentPane.add(lblPreo);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("INSERIR PREÇO DO PRODUTO");
		textField_4.setColumns(10);
		textField_4.setBounds(168, 177, 99, 20);
		contentPane.add(textField_4);
		
		lblMarca = new JLabel("Marca*");
		lblMarca.setForeground(new Color(255, 255, 255));
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));
		lblMarca.setBounds(293, 157, 86, 18);
		contentPane.add(lblMarca);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("INSERIR MARCA DO PRODUTO");
		textField_5.setColumns(10);
		textField_5.setBounds(293, 177, 99, 20);
		contentPane.add(textField_5);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(new Color(255, 255, 255));
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategoria.setBounds(419, 157, 86, 18);
		contentPane.add(lblCategoria);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("INSERIR CATEGORIA DO PRODUTO");
		textField_6.setColumns(10);
		textField_6.setBounds(419, 177, 99, 20);
		contentPane.add(textField_6);
/////////////////////////////////////////////////////////////////////////////////////////////
		btnNewButton = new JButton("INSERIR");
		btnNewButton.setToolTipText("INSERIR DADOS NA TABELA PRODUTOS");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.green);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(36, 268, 122, 42);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean checar =
						naoativo(textField_2)||
						naoativo(textField_3)||
						naoativo(textField_4)||
						naoativo(textField_5)||
						naoativo(textField_6);
				if(checar) {
					avisoinserir();
				}else {
					inserirdados();
					limpar();
				}
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////
		
		btnLista = new JButton("LIMPAR CAMPOS");
		btnLista.setToolTipText("LIMPAR CAMPOS DA TELA CADASTRO ");
		btnLista.setForeground(new Color(255, 255, 255));
		btnLista.setFont(new Font("Arial", Font.BOLD, 14));
		btnLista.setContentAreaFilled(false);
		btnLista.setOpaque(true);
		btnLista.setBackground(Color.red);
		btnLista.setBounds(202, 268, 160, 42);
		contentPane.add(btnLista);
		btnLista.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					boolean checar =
							naoativo(txtInserirCdigoDe)&&
							naoativo(textField_2)&&
							naoativo(textField_3)&&
							naoativo(textField_4)&&
							naoativo(textField_5);
					if(checar) {
						JOptionPane.showMessageDialog(null, "Nenhuma informação exluida, pois, não possui informação","ATENÇÃO",2);
					}else {
						limpar();
						JOptionPane.showMessageDialog(null, "Campos Limpos com sucesso!!!","ATENÇÃO",1);
					}
				}
		});
		
/////////////////////////////////////////////////////////////////////////////////////////////////
		btnLista_1 = new JButton("LISTA");
		btnLista_1.setToolTipText("LISTA COM OS PRODUTOS INSERIDOS");
		btnLista_1.setForeground(new Color(255, 255, 255));
		btnLista_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janela();	
			}
		});
		btnLista_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnLista_1.setContentAreaFilled(false);
		btnLista_1.setOpaque(true);
		btnLista_1.setBackground(Color.gray);
		btnLista_1.setBounds(396, 268, 122, 42);
		contentPane.add(btnLista_1);
		
		txtInserirCdigoDe = new JTextField();
		txtInserirCdigoDe.setToolTipText("INSERIR CÓDIGO DE BARRAS DO PRODUTO");
		txtInserirCdigoDe.setColumns(10);
		txtInserirCdigoDe.setBounds(36, 48, 482, 20);
		contentPane.add(txtInserirCdigoDe);}
//////////////////////////////////////////////////////////////////////////////////////////////		
	
	public void janela() {
		Telatabela janeladois = new Telatabela();
		janeladois.setVisible(true);
		janeladois.setLocationRelativeTo(null);
		janeladois.atualizar();
		this.setVisible(false);
	}
	public void limpar() { // limpar os JTextFields para ficar vazio
		txtInserirCdigoDe.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
	}
	
	public Connection connect(){ // conexao com o banco de dados
		Connection bancoavaliacao = null;
	try {
		Class.forName("org.sqlite.JDBC");
		bancoavaliacao = DriverManager.getConnection("jdbc:sqlite:D:\\anderson\\avaliacao");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return bancoavaliacao;
	}
		
			public void inserirdados() {
		String sql = "INSERT INTO avaliacao(codigodebarra,descricao,quantidade,preco,marca,categoria) VALUES(?,?,?,?,?,?)"; //click do botão vai inserir dados essas sao os metodos para conexão e inserção de dados
		try(Connection bancoavaliacao = this.connect();
				PreparedStatement registro = bancoavaliacao.prepareStatement(sql)){
			registro.setString(1, txtInserirCdigoDe.getText().toString());
			registro.setString(2, textField_2.getText().toString());
			registro.setString(3, textField_3.getText().toString());
			registro.setString(4, textField_4.getText().toString().replaceAll(",", "."));
			registro.setString(5, textField_5.getText().toString());
			registro.setString(6, textField_6.getText().toString());
			registro.execute();
			bancoavaliacao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
		JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!","ATENÇÃO",1);
}
	
	private boolean naoativo(JTextField teste){ // teste para verificar se todos os campos foram inseridos dados para não ficar vazio
		return teste.getText().toString().trim().isEmpty();		
	}
	
	private void avisoinserir(){ // aviso para o usuário inserir os dados
		JOptionPane.showMessageDialog(null, "Por favor, preencha todas as informações obrigatórias com *(asterisco)","ATENÇÃO",2);
	}
	private void limpador() { // aviso para o usuário que os dados foram deletados
		JOptionPane.showMessageDialog(null, "Campos limpos com sucesso ✔","ATENÇÃO",1);

	}
}