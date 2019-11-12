package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAlterLivro extends JFrame {

	private JPanel contentPane;
	private JTextField jCampoPreco;
	private JTextField jCampoISBN;
	private JTextField jCampoTitulo;
	private JLabel labelEditora;
	private JButton buttonEditAutor;
	private JComboBox comboBoxEditora;
	private JPanel panel;
	private JButton buttonSaveEditLivro;
	private JButton buttonCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAlterLivro frame = new ViewAlterLivro();
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
	public ViewAlterLivro() {
		setTitle("Editar Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel labelTitulo = new JLabel("Titulo:");
		GridBagConstraints gbc_labelTitulo = new GridBagConstraints();
		gbc_labelTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitulo.gridx = 0;
		gbc_labelTitulo.gridy = 0;
		contentPane.add(labelTitulo, gbc_labelTitulo);
		
		jCampoTitulo = new JTextField();
		GridBagConstraints gbc_jCampoTitulo = new GridBagConstraints();
		gbc_jCampoTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoTitulo.gridx = 1;
		gbc_jCampoTitulo.gridy = 0;
		contentPane.add(jCampoTitulo, gbc_jCampoTitulo);
		jCampoTitulo.setColumns(10);
		
		JLabel labelISBN = new JLabel("ISBN:");
		GridBagConstraints gbc_labelISBN = new GridBagConstraints();
		gbc_labelISBN.insets = new Insets(0, 0, 5, 5);
		gbc_labelISBN.gridx = 0;
		gbc_labelISBN.gridy = 1;
		contentPane.add(labelISBN, gbc_labelISBN);
		
		jCampoISBN = new JTextField();
		GridBagConstraints gbc_jCampoISBN = new GridBagConstraints();
		gbc_jCampoISBN.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoISBN.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoISBN.gridx = 1;
		gbc_jCampoISBN.gridy = 1;
		contentPane.add(jCampoISBN, gbc_jCampoISBN);
		jCampoISBN.setColumns(10);
		
		JLabel labelPreco = new JLabel("Preço:");
		GridBagConstraints gbc_labelPreco = new GridBagConstraints();
		gbc_labelPreco.insets = new Insets(0, 0, 5, 5);
		gbc_labelPreco.gridx = 0;
		gbc_labelPreco.gridy = 2;
		contentPane.add(labelPreco, gbc_labelPreco);
		
		jCampoPreco = new JTextField();
		GridBagConstraints gbc_jCampoPreco = new GridBagConstraints();
		gbc_jCampoPreco.insets = new Insets(0, 0, 5, 0);
		gbc_jCampoPreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCampoPreco.gridx = 1;
		gbc_jCampoPreco.gridy = 2;
		contentPane.add(jCampoPreco, gbc_jCampoPreco);
		jCampoPreco.setColumns(10);
		
		JLabel labelAutores = new JLabel("Autores:");
		GridBagConstraints gbc_labelAutores = new GridBagConstraints();
		gbc_labelAutores.insets = new Insets(0, 0, 5, 5);
		gbc_labelAutores.gridx = 0;
		gbc_labelAutores.gridy = 3;
		contentPane.add(labelAutores, gbc_labelAutores);
		
		buttonEditAutor = new JButton("Editar Autores");
		buttonEditAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewSelectAutor viewSelectAutor= new ViewSelectAutor();
				viewSelectAutor.setVisible(true);
				viewSelectAutor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		GridBagConstraints gbc_buttonEditAutor = new GridBagConstraints();
		gbc_buttonEditAutor.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonEditAutor.insets = new Insets(0, 0, 5, 0);
		gbc_buttonEditAutor.gridx = 1;
		gbc_buttonEditAutor.gridy = 3;
		contentPane.add(buttonEditAutor, gbc_buttonEditAutor);
		
		labelEditora = new JLabel("Editora:");
		GridBagConstraints gbc_labelEditora = new GridBagConstraints();
		gbc_labelEditora.anchor = GridBagConstraints.EAST;
		gbc_labelEditora.insets = new Insets(0, 0, 5, 5);
		gbc_labelEditora.gridx = 0;
		gbc_labelEditora.gridy = 4;
		contentPane.add(labelEditora, gbc_labelEditora);
		
		comboBoxEditora = new JComboBox();
		GridBagConstraints gbc_comboBoxEditora = new GridBagConstraints();
		gbc_comboBoxEditora.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxEditora.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEditora.gridx = 1;
		gbc_comboBoxEditora.gridy = 4;
		contentPane.add(comboBoxEditora, gbc_comboBoxEditora);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		buttonSaveEditLivro = new JButton("Salvar");
		buttonSaveEditLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//panel.add(buttonSaveEditLivro, BorderLayout.WEST);
		
		
		buttonCancel = new JButton("Cancelar");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		//panel.add(buttonCancel, BorderLayout.EAST);
		
		
	}

	public JTextField getjCampoPreco() {
		return jCampoPreco;
	}

	public void setjCampoPreco(String text) {
		this.jCampoPreco.setText(text);
	}

	public JTextField getjCampoISBN() {
		return jCampoISBN;
	}

	public void setjCampoISBN(String text) {
		this.jCampoISBN.setText(text);
	}

	public JTextField getjCampoTitulo() {
		return jCampoTitulo;
	}

	public void setjCampoTitulo(String text) {
		this.jCampoTitulo.setText(text);
	}

}
