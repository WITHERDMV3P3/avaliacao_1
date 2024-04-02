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

public class teladois extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollBar scrollBar;

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
		scrollBar.setBounds(1311, 73, 17, 594);
		contentPane.add(scrollBar);
		
		table = new JTable();
		table.setBounds(46, 73, 1282, 594);
		contentPane.add(table);
	}
}
