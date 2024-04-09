package teladois;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import telaum.telaum;

public class teladois extends telaum implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnVoltar;
	private JButton btnDetalhes;
	private JButton btnDeletar;
	private JButton btnAlterar;
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
		public void actionPerformed(ActionEvent evento) {
			voltar();
			
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.setBounds(36, 26, 122, 42);
		contentPane.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
		btnDetalhes = new JButton("DETALHES");
		btnDetalhes.setFont(new Font("Arial", Font.BOLD, 14));
		btnDetalhes.setBounds(325, 26, 122, 42);
		contentPane.add(btnDetalhes);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		btnDeletar = new JButton("DELETAR");
		btnDeletar.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletar.setBounds(467, 26, 122, 42);
		contentPane.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				excluirdados();
				
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAlterar.setBounds(607, 26, 122, 42);
		contentPane.add(btnAlterar);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAtualizar.setBounds(182, 26, 122, 42);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 729, 343);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CÓDIGO", "DESCRIÇÃO", "QUANTIDADE", "PREÇO"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(266);
		table.getColumnModel().getColumn(2).setPreferredWidth(108);
		table.getColumnModel().getColumn(3).setPreferredWidth(106);
		

	}
	
	public void voltar() {
		JFrame telaum = new telaum();
		telaum.setVisible(true);
		this.dispose();
	}
	
	public void atualizar() {
		JFrame telaum = new telaum();
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();	
		model1.setRowCount(0);
		
	String sql = "SELECT id,descricao,quantidade,preco from avaliacao";
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
				resultset.getFloat("preco")
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
	}
