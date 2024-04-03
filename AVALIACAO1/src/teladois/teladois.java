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
import javax.swing.JScrollPane;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import android.view.View;
import telaum.telaum;

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
		setBounds(100, 100, 1800, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(1326, 79, 17, 609);
		contentPane.add(scrollBar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		
		
		table.setBounds(10, 114, 1333, 574);
		contentPane.add(table);
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.setBounds(36, 26, 122, 42);
		contentPane.add(btnVoltar);
		
		btnDetalhes = new JButton("DETALHES");
		btnDetalhes.setFont(new Font("Arial", Font.BOLD, 14));
		btnDetalhes.setBounds(882, 26, 122, 42);
		contentPane.add(btnDetalhes);
		
		btnDeletar = new JButton("DELETAR");
		btnDeletar.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletar.setBounds(1024, 26, 122, 42);
		contentPane.add(btnDeletar);
		
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAlterar.setBounds(1164, 26, 122, 42);
		contentPane.add(btnAlterar);
		
		new telaum().show();
		
		
		
	}
}
