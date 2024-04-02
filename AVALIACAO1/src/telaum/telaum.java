package telaum;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class telaum extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
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
	private JLabel lblUnidadeDeMedida;
	private JComboBox comboBox;
	private JLabel lblObservap;
	private JTextField textField_6;
	private JLabel lblCategoria;
	private JTextField textField_7;
	private JButton btnNewButton;
	private JButton btnLista;
	private JButton btnLista_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	public telaum() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1301, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Código");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(400, 90, 50, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(400, 110, 99, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(532, 110, 291, 20);
		contentPane.add(textField_1);
		
		lblCdigoDeBarras = new JLabel("Código de Barras");
		lblCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));
		lblCdigoDeBarras.setBounds(532, 90, 122, 18);
		contentPane.add(lblCdigoDeBarras);
		
		lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescrio.setBounds(400, 163, 70, 18);
		contentPane.add(lblDescrio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(400, 183, 482, 20);
		contentPane.add(textField_2);
		
		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 14));
		lblQuantidade.setBounds(400, 228, 86, 18);
		contentPane.add(lblQuantidade);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(400, 248, 99, 20);
		contentPane.add(textField_3);
		
		lblPreo = new JLabel("Preço");
		lblPreo.setFont(new Font("Arial", Font.BOLD, 14));
		lblPreo.setBounds(532, 228, 41, 18);
		contentPane.add(lblPreo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(532, 248, 99, 20);
		contentPane.add(textField_4);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));
		lblMarca.setBounds(657, 228, 86, 18);
		contentPane.add(lblMarca);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(657, 248, 99, 20);
		contentPane.add(textField_5);
		
		lblUnidadeDeMedida = new JLabel("Unidade de Medida");
		lblUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));
		lblUnidadeDeMedida.setBounds(400, 293, 141, 18);
		contentPane.add(lblUnidadeDeMedida);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"UN", "KG"}));
		comboBox.setName("");
		comboBox.setToolTipText("");
		comboBox.setBounds(400, 315, 141, 22);
		contentPane.add(comboBox);
		
		lblObservap = new JLabel("Observação");
		lblObservap.setFont(new Font("Arial", Font.BOLD, 14));
		lblObservap.setBounds(400, 348, 86, 18);
		contentPane.add(lblObservap);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(400, 368, 423, 98);
		contentPane.add(textField_6);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategoria.setBounds(783, 228, 86, 18);
		contentPane.add(lblCategoria);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(783, 248, 99, 20);
		contentPane.add(textField_7);
		
		btnNewButton = new JButton("INSERIR");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(400, 509, 122, 42);
		contentPane.add(btnNewButton);
		
		btnLista = new JButton("LIMPAR");
		btnLista.setFont(new Font("Arial", Font.BOLD, 14));
		btnLista.setBounds(581, 509, 122, 42);
		contentPane.add(btnLista);
		
		btnLista_1 = new JButton("LISTA");
		btnLista_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnLista_1.setBounds(760, 509, 122, 42);
		contentPane.add(btnLista_1);
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c= DriverManager.getConnection("jdbc:sqlite:D:\\anderson\\avaliacao"); 
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select codigo, codigodebarra, descricao,preco,marca,quantidade,categoria,unimed,obs from NewTable");
			
			while(rs.next()) {
				Object o = new Object[]{rs.getObject("codigo"),rs.getObject("codigodebarra"),rs.getObject("descricao"),rs.getObject("preco"),rs.getObject("marca"),rs.getObject("quantidade"),rs.getObject("categoria"),rs.getObject("unimed"),rs.getObject("obs")};
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
}
