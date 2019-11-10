package views;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ActionMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class MenuPanel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

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
		setBounds(100, 100, 1000, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnLivros = new JMenu("Livros");
		menuBar.add(mnLivros);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnLivros.add(mntmListar);
		
		JMenu mnAutores = new JMenu("Autores");
		menuBar.add(mnAutores);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mnAutores.add(mntmListar_1);
		
		JMenu mnEditora = new JMenu("Editora");
		menuBar.add(mnEditora);
		
		JMenuItem mntmListar_2 = new JMenuItem("Listar");
		mnEditora.add(mntmListar_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTable table = new JTable();
		//table.setModel(table.getDtm());
		contentPane.add(table, BorderLayout.CENTER);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		mntmListar.addActionListener(new ActionMenu("livros", table));
		
		JScrollPane scroolPane = new JScrollPane(table);
		getContentPane().add(scroolPane, BorderLayout.CENTER);
		
		
		
		
	}

}
