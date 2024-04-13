package teladois;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javax.swing.table.TableModel;

import telaalterar.Telaalterar;
import telaum.telaum;

public class teladois extends telaum implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnDetalhes;
	private JButton btnDeletar;
	private JScrollPane scrollPane;
	private JButton btnAtualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		teladois chamar2 = new teladois();
		chamar2.metododois();
		
	}
	///////////////////////////////////////////////////////////////////////////////////////
	
	//TODO metodo responsavel pela acão;
	public void actionPerformed(ActionEvent e) {
	}
	///////////////////////////////////////////////////////////////////////////////////////
	public void metododois() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teladois frame = new teladois();
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
	public teladois() {
		setTitle("TELA LISTA");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
		btnDetalhes = new JButton("ALTERAR");
		btnDetalhes.setFont(new Font("Arial", Font.BOLD, 14));
		btnDetalhes.setBounds(446, 27, 122, 42);
		contentPane.add(btnDetalhes);
		btnDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		btnDeletar = new JButton("DELETAR");
		btnDeletar.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletar.setBounds(295, 27, 122, 42);
		contentPane.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				excluirdados();
				
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAtualizar.setBounds(143, 27, 122, 42);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 705, 343);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
				mudardados();
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "DESCRI\u00C7\u00C3O", "QUANTIDADE", "PRE\u00C7O", "MARCA", "CATEGORIA"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Object.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(266);
		table.getColumnModel().getColumn(2).setPreferredWidth(108);
		table.getColumnModel().getColumn(3).setPreferredWidth(106);
		

	}
	
	public void alterar() {
		JFrame telaum = new telaum();
		String sql = "UPDATE avaliacao SET codigodebarra = ?, descricao= ?,quantidade= ?,preco= ?,marca= ?,categoria= ?  WHERE id=?";
			try(Connection bancoavaliacao = this.connect();
					PreparedStatement registro = bancoavaliacao.prepareStatement(sql)){
					int i = 1;
	           
	          registro.execute();
	          
	      atualizar();}
			 catch (SQLException e) {
				System.out.println(e.getMessage());
		}
			}
	
	public void atualizar() {
		JFrame telaum = new telaum();
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();	
		model1.setRowCount(0);
		
	String sql = "SELECT * from avaliacao";
	Statement statement = null;
	ResultSet resultset = null;
	Connection conexao = null;
	try {
		conexao = connect();
		statement = conexao.createStatement();
		resultset = statement.executeQuery(sql);
		
		while(resultset.next()) {
		Object[] rowData = {
				resultset.getInt("id"),
				resultset.getString("descricao"),
				resultset.getInt("quantidade"),
				resultset.getFloat("preco"),
				resultset.getString("marca"),
				resultset.getString("categoria"),
		};
		model1.addRow(rowData);
		}
	} catch (SQLException e) {
		System.out.println("ERRO AO ATUALIZAR A TABELA: "+ e.getMessage());
	} try {
        if (resultset != null) {
            resultset.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (conexao != null) {
            conexao.close();
        }
    } catch (SQLException e) {
        System.out.println("Erro ao fechar os recursos: " + e.getMessage());
    }
		}
			
	public void excluirdados() {
		JFrame telaum = new telaum();
		String sql = "DELETE from avaliacao where id=?";
			try(Connection bancoavaliacao = this.connect();
					PreparedStatement registro = bancoavaliacao.prepareStatement(sql)){
				for (int linha :table.getSelectedRows()) {
	              registro.setInt(1,Integer.parseInt(table.getValueAt( linha , 0).toString()));
	          registro.execute();
	          }
	      atualizar();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
		}
	}
	public void mudardados() {
			try {
			DefaultTableModel model1 = (DefaultTableModel) table.getModel();
			model1.getValueAt(table.getSelectedRow(),0).toString();
			JFrame Telaalterar = new Telaalterar();
			Telaalterar.setVisible(true);
			telaum janeladois = new teladois();
			janeladois.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			janeladois.setLocationRelativeTo(null);
			this.dispose();
			}
			 catch (Exception e1){
				e1.printStackTrace();
			}
		}
	
	}
