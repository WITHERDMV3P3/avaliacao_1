package telaum;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;

import teladois.teladois;

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

public class telaum extends JFrame {

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
	private JLabel lblObservap;
	private JTextField textField_7;
	private JLabel lblCategoria;
	private JTextField textField_6;
	private JButton btnNewButton;
	private JButton btnLista;
	private JButton btnLista_1;

	///////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		telaum chamar = new telaum();
		chamar.metodoum();
	}
	//////////////////////////////////////////////////////////////////////////////////////
	public void metodoum() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaum frame = new telaum();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public telaum() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1301, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(400, 116, 291, 20);
		contentPane.add(textField_1);
		
		lblCdigoDeBarras = new JLabel("Código de Barras");
		lblCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));
		lblCdigoDeBarras.setBounds(400, 96, 122, 18);
		contentPane.add(lblCdigoDeBarras);
		
		lblDescrio = new JLabel("Descrição*");
		lblDescrio.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescrio.setBounds(400, 163, 86, 18);
		contentPane.add(lblDescrio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(400, 183, 482, 20);
		contentPane.add(textField_2);
		
		lblQuantidade = new JLabel("Quantidade*");
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 14));
		lblQuantidade.setBounds(400, 228, 86, 18);
		contentPane.add(lblQuantidade);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(400, 248, 99, 20);
		contentPane.add(textField_3);
		
		lblPreo = new JLabel("Preço*");
		lblPreo.setFont(new Font("Arial", Font.BOLD, 14));
		lblPreo.setBounds(532, 228, 52, 18);
		contentPane.add(lblPreo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(532, 248, 99, 20);
		contentPane.add(textField_4);
		
		lblMarca = new JLabel("Marca*");
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));
		lblMarca.setBounds(657, 228, 86, 18);
		contentPane.add(lblMarca);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(657, 248, 99, 20);
		contentPane.add(textField_5);
		
		lblObservap = new JLabel("Observação");
		lblObservap.setFont(new Font("Arial", Font.BOLD, 14));
		lblObservap.setBounds(400, 292, 86, 18);
		contentPane.add(lblObservap);
		
		textField_7 = new JTextField();
		textField_7.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField_7.setHorizontalAlignment(SwingConstants.LEFT);
		textField_7.setColumns(10);
		textField_7.setBounds(400, 312, 423, 42);
		contentPane.add(textField_7);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategoria.setBounds(783, 228, 86, 18);
		contentPane.add(lblCategoria);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(783, 248, 99, 20);
		contentPane.add(textField_6);
/////////////////////////////////////////////////////////////////////////////////////////////
		btnNewButton = new JButton("INSERIR");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(400, 393, 122, 42);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean checar =
						naoativo(textField_2)||
						naoativo(textField_3)||
						naoativo(textField_4)||
						naoativo(textField_5);
				if(checar) {
					aviso();
				}else {
					inserirdados();
				}
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////
		
		btnLista = new JButton("LIMPAR CAMPOS");
		btnLista.setFont(new Font("Arial", Font.BOLD, 14));
		btnLista.setBounds(566, 393, 160, 42);
		contentPane.add(btnLista);
		btnLista.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				limpar();
			}});
		
/////////////////////////////////////////////////////////////////////////////////////////////////
		btnLista_1 = new JButton("LISTA");
		btnLista_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janela();	
			}
		});
		btnLista_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnLista_1.setBounds(760, 393, 122, 42);
		contentPane.add(btnLista_1);}
//////////////////////////////////////////////////////////////////////////////////////////////		
	
	public void janela() {
		JFrame janeladois = new teladois();
		janeladois.setVisible(true);
		this.dispose();
	}
	public void limpar() {
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_7.setText("");
		textField_6.setText("");
	}
	
	public Connection connect(){
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
		String sql = "INSERT INTO avaliacao(codigodebarra,descricao,preco,marca,quantidade,categoria,obs) VALUES(?,?,?,?,?,?,?)";
		try(Connection bancoavaliacao = this.connect();
				PreparedStatement registro = bancoavaliacao.prepareStatement(sql)){
			registro.setString(1, textField_1.getText().toString());
			registro.setString(2, textField_2.getText().toString());
			registro.setString(3, textField_3.getText().toString());
			registro.setString(4, textField_4.getText().toString());
			registro.setString(5, textField_5.getText().toString());
			registro.setString(6, textField_6.getText().toString());
			registro.setString(7, textField_7.getText().toString());
			registro.execute();
			bancoavaliacao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	}
}
	
	private boolean naoativo(JTextField teste){
		return teste.getText().toString().trim().isEmpty();		
	}
	
	private void aviso(){
		JOptionPane avisoa = new JOptionPane("POR FAVOR, PREENCHA TODAS AS INFORMAÇÕES OBRIGATÓRIAS COM *(asterisco)");
		javax.swing.JDialog dialogo = avisoa.createDialog(this,"ATENÇÃO");
		java.awt.Toolkit.getDefaultToolkit().beep();
		dialogo.setAlwaysOnTop(true);		
		dialogo.setVisible(true);
	}
	
}