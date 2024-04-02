package teladois;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Font;

public class teladois extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollBar scrollBar;
	private JButton btnVoltar;
	private JButton btnDetalhes;
	private JButton btnDeletar;
	private JButton btnAlterar;

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
		setBounds(100, 100, 1308, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(1275, 73, 17, 594);
		contentPane.add(scrollBar);
		
		table = new JTable();
		table.setBounds(10, 73, 1282, 594);
		contentPane.add(table);
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.setBounds(10, 20, 122, 42);
		contentPane.add(btnVoltar);
		
		btnDetalhes = new JButton("DETALHES");
		btnDetalhes.setFont(new Font("Arial", Font.BOLD, 14));
		btnDetalhes.setBounds(856, 20, 122, 42);
		contentPane.add(btnDetalhes);
		
		btnDeletar = new JButton("DELETAR");
		btnDeletar.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletar.setBounds(998, 20, 122, 42);
		contentPane.add(btnDeletar);
		
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAlterar.setBounds(1138, 20, 122, 42);
		contentPane.add(btnAlterar);
	}
}
