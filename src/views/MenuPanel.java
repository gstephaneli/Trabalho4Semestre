package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ActionMenu;
import controllers.TableBooksController;
import models.TableBooks;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class MenuPanel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField CampoDeBusca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPanel frame = new MenuPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Throwable 
	 */
	public MenuPanel() throws Throwable {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuLivros = new JMenu("Livros");
		menuBar.add(menuLivros);
		
		JMenuItem menuLivrosListar = new JMenuItem("Listar");
		menuLivros.add(menuLivrosListar);
		
		JMenuItem menuLivrosAdicionar = new JMenuItem("Adicionar");
		menuLivros.add(menuLivrosAdicionar);
		
		JMenu menuAutores = new JMenu("Autores");
		menuBar.add(menuAutores);
		
		JMenuItem menuAutoresListar = new JMenuItem("Listar");
		menuAutores.add(menuAutoresListar);
		
		JMenuItem menuAutoresAdicionar = new JMenuItem("Adicionar");
		menuAutores.add(menuAutoresAdicionar);
		
		JMenu menuEditora = new JMenu("Editora");
		menuBar.add(menuEditora);
		
		JMenuItem menuEditoraListar = new JMenuItem("Listar");
		menuEditora.add(menuEditoraListar);
		
		JMenuItem menuEditoraAdicionar = new JMenuItem("Adicionar");
		menuEditora.add(menuEditoraAdicionar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTable table = new JTable();
		//table.setModel(table.getDtm());
		contentPane.add(table, BorderLayout.CENTER);
		
		CampoDeBusca = new JTextField();
		contentPane.add(CampoDeBusca, BorderLayout.NORTH);
		CampoDeBusca.setColumns(10);
		menuLivrosListar.addActionListener(new ActionMenu("livros", table));
		menuAutoresListar.addActionListener(new ActionMenu("autores", table));
		JScrollPane scroolPane = new JScrollPane(table);
		getContentPane().add(scroolPane, BorderLayout.CENTER);
		
		
		
		
	}

}
