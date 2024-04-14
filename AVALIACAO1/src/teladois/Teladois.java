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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import telaalterar.Telaalterar;
import telaum.Telaum;

public class Teladois extends Telaum implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnDetalhes;
	private JButton btnDeletar;
	private JScrollPane scrollPane;
	private JButton btnAtualizar;
	private JButton btnDetalhes_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Teladois chamar2 = new Teladois();
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
					Teladois frame = new Teladois();
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
	public Teladois() {
		setTitle("TELA LISTA");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		btnDeletar = new JButton("DELETAR");
		btnDeletar.setFont(new Font("Arial", Font.BOLD, 14));
		btnDeletar.setBounds(342, 22, 122, 42);
		contentPane.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deletado();
			}

			private void deletado() {
				Object[] opcoes = {"SIM" , "NÃO"}; 
				int valor = JOptionPane.showOptionDialog(null, "DESEJA REALMENTE EXCLUIR?","EXCLUIR",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcoes,opcoes[1]);				
			if(valor == 0) {
				excluirdados();
			    atualizar();
			}
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAtualizar.setBounds(190, 22, 122, 42);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizar();
				atualizado();
			}

			private void atualizado() {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO","ATENÇÃO",1);
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 803, 343);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "C\u00D3DIGO DE BARRAS", "DESCRI\u00C7\u00C3O", "QUANTIDADE", "PRE\u00C7O", "MARCA", "CATEGORIA"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, String.class, Object.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		btnDetalhes_1 = new JButton("DETALHES");
		btnDetalhes_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnDetalhes_1.setBounds(488, 22, 122, 42);
		contentPane.add(btnDetalhes_1);
		btnDetalhes_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int tabela = table.getSelectedColumnCount();
				if(tabela==0) {
				JOptionPane.showMessageDialog(null, "SELECIONE A LISTA DA TABELA PARA CONTINUAR", "ATENÇÃO", 0);
				}else {
					mudardados();
				}			
			}
		});
		
		table.getColumnModel().getColumn(1).setPreferredWidth(142);
		table.getColumnModel().getColumn(2).setPreferredWidth(266);
		table.getColumnModel().getColumn(3).setPreferredWidth(108);
		table.getColumnModel().getColumn(4).setPreferredWidth(106);
		

	}
	
	public void atualizar() {
		Telaum telaum = new Telaum();
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();	
		model1.setRowCount(0);
		
	String sql = "SELECT * from avaliacao";
	Statement statement = null;
	ResultSet resultset = null;
	try(Connection bancoavaliacao = this.connect();
					PreparedStatement registro = bancoavaliacao.prepareStatement(sql)){
		statement = connect().createStatement();
		resultset = statement.executeQuery(sql);
		while(resultset.next()) {
		Object[] rowData = {
				resultset.getInt("id"),
				resultset.getInt("codigodebarra"),
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
    } catch (SQLException e) {
        System.out.println("Erro ao fechar os recursos: " + e.getMessage());
    }
		}
			
	public void excluirdados() {
		JFrame telaum = new Telaum();
		String sql = "DELETE from avaliacao where id=?";
			try(Connection bancoavaliacao = this.connect();
					PreparedStatement registro = bancoavaliacao.prepareStatement(sql)){
				for (int linha :table.getSelectedRows()) {
	              registro.setInt(1,Integer.parseInt(table.getValueAt( linha , 0).toString()));
	          registro.execute();
	          }
			} catch (SQLException e) {
				System.out.println(e.getMessage());
		}
	}
	public void mudardados() {
			try {
			DefaultTableModel model1 = (DefaultTableModel) table.getModel();
			model1.getValueAt(table.getSelectedRow(),0).toString();
			int codigo = (int) table.getValueAt(table.getSelectedRow(), 0);
			int codigodebarra = (int) table.getValueAt(table.getSelectedRow(), 1);
			String descricao = (String) table.getValueAt(table.getSelectedRow(), 2);
			int quantidade = (int) table.getValueAt(table.getSelectedRow(), 3);
			float preco = (float) table.getValueAt(table.getSelectedRow(), 4);
			String marca = (String) table.getValueAt(table.getSelectedRow(), 5);
			String categoria = (String) table.getValueAt(table.getSelectedRow(), 6);
			Telaalterar telaAlterar = new Telaalterar();
			telaAlterar.preenchercampos(codigo, codigodebarra, descricao, quantidade, preco, marca, categoria);
			telaAlterar.setVisible(true);
			telaAlterar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			telaAlterar.setLocationRelativeTo(null);
			
			}
			 catch (Exception e1){
				e1.printStackTrace();
			}
		}
}
	
