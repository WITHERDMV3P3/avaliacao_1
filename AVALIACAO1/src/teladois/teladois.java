package teladois;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class teladois extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teladois frame = new teladois();
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
	public teladois() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1301, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Código");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(246, 54, 50, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(246, 74, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(378, 74, 291, 20);
		contentPane.add(textField_1);
		
		lblCdigoDeBarras = new JLabel("Código de Barras");
		lblCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));
		lblCdigoDeBarras.setBounds(378, 54, 122, 18);
		contentPane.add(lblCdigoDeBarras);
		
		lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescrio.setBounds(246, 127, 70, 18);
		contentPane.add(lblDescrio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(246, 147, 423, 20);
		contentPane.add(textField_2);
		
		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial", Font.BOLD, 14));
		lblQuantidade.setBounds(246, 192, 86, 18);
		contentPane.add(lblQuantidade);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(246, 212, 86, 20);
		contentPane.add(textField_3);
	}
}
