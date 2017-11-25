package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;

import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Janela extends JFrame {

	private JPanel contentPane;
	private JTextField nome1;
	private JTextField nome2;
	private JTextField nome3;
	private JTextField nome4;
	private JTextField nome5;
	private String pathFinal = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel caminho = new JLabel("Clique no bot\u00E3o a esquerda para escolher o arquivo PDF a ser pesquisado");
		caminho.setHorizontalAlignment(SwingConstants.CENTER);
		caminho.setBackground(Color.WHITE);
		GridBagConstraints gbc_caminho = new GridBagConstraints();
		gbc_caminho.anchor = GridBagConstraints.WEST;
		gbc_caminho.insets = new Insets(0, 0, 5, 5);
		gbc_caminho.gridx = 2;
		gbc_caminho.gridy = 1;
		contentPane.add(caminho, gbc_caminho);
		
		JButton arquivo = new JButton("PDF");
		arquivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(getParent());
				if (result == JFileChooser.APPROVE_OPTION) 
				{				
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					path = path.replace(File.separator, "//");
					System.out.println(path);
					pathFinal = path;
					caminho.setText(path);
					
				}
			}
		});
		arquivo.setIcon(new ImageIcon(Janela.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		GridBagConstraints gbc_arquivo = new GridBagConstraints();
		gbc_arquivo.anchor = GridBagConstraints.EAST;
		gbc_arquivo.insets = new Insets(0, 0, 5, 5);
		gbc_arquivo.gridx = 1;
		gbc_arquivo.gridy = 1;
		contentPane.add(arquivo, gbc_arquivo);	
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 2;
		contentPane.add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblMarqueACaixa = new JLabel("Marque a caixa a esquerda para ativar os campos abaixo");
		GridBagConstraints gbc_lblMarqueACaixa = new GridBagConstraints();
		gbc_lblMarqueACaixa.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarqueACaixa.gridx = 2;
		gbc_lblMarqueACaixa.gridy = 3;
		contentPane.add(lblMarqueACaixa, gbc_lblMarqueACaixa);		
		
		nome1 = new JTextField();
		nome1.setEnabled(false);
		nome1.setHorizontalAlignment(SwingConstants.CENTER);
		nome1.setText("Nome completo do advogado 1");
		GridBagConstraints gbc_nome1 = new GridBagConstraints();
		gbc_nome1.fill = GridBagConstraints.BOTH;
		gbc_nome1.insets = new Insets(0, 0, 5, 5);
		gbc_nome1.gridx = 2;
		gbc_nome1.gridy = 5;
		contentPane.add(nome1, gbc_nome1);
		nome1.setColumns(10);
		
		nome2 = new JTextField();
		nome2.setEnabled(false);
		nome2.setHorizontalAlignment(SwingConstants.CENTER);
		nome2.setText("Nome completo do advogado 2");
		GridBagConstraints gbc_nome2 = new GridBagConstraints();
		gbc_nome2.fill = GridBagConstraints.BOTH;
		gbc_nome2.insets = new Insets(0, 0, 5, 5);
		gbc_nome2.gridx = 2;
		gbc_nome2.gridy = 6;
		contentPane.add(nome2, gbc_nome2);
		nome2.setColumns(10);
		
		
		
		nome3 = new JTextField();
		nome3.setEnabled(false);
		nome3.setText("Nome completo do advogado 3");
		nome3.setHorizontalAlignment(SwingConstants.CENTER);
		nome3.setColumns(10);
		GridBagConstraints gbc_nome3 = new GridBagConstraints();
		gbc_nome3.insets = new Insets(0, 0, 5, 5);
		gbc_nome3.fill = GridBagConstraints.BOTH;
		gbc_nome3.gridx = 2;
		gbc_nome3.gridy = 7;
		contentPane.add(nome3, gbc_nome3);
		
		
		
		nome4 = new JTextField();
		nome4.setEnabled(false);
		nome4.setText("Nome completo do advogado 4");
		nome4.setHorizontalAlignment(SwingConstants.CENTER);
		nome4.setColumns(10);
		GridBagConstraints gbc_nome4 = new GridBagConstraints();
		gbc_nome4.insets = new Insets(0, 0, 5, 5);
		gbc_nome4.fill = GridBagConstraints.BOTH;
		gbc_nome4.gridx = 2;
		gbc_nome4.gridy = 8;
		contentPane.add(nome4, gbc_nome4);
		
		
		
		nome5 = new JTextField();
		nome5.setEnabled(false);
		nome5.setText("Nome completo do advogado 5");
		nome5.setHorizontalAlignment(SwingConstants.CENTER);
		nome5.setColumns(10);
		GridBagConstraints gbc_nome5 = new GridBagConstraints();
		gbc_nome5.insets = new Insets(0, 0, 5, 5);
		gbc_nome5.fill = GridBagConstraints.BOTH;
		gbc_nome5.gridx = 2;
		gbc_nome5.gridy = 9;
		contentPane.add(nome5, gbc_nome5);
				
		JCheckBox ck1 = new JCheckBox("");
		ck1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				nome1.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		GridBagConstraints gbc_ck1 = new GridBagConstraints();
		gbc_ck1.insets = new Insets(0, 0, 5, 5);
		gbc_ck1.gridx = 1;
		gbc_ck1.gridy = 5;
		contentPane.add(ck1, gbc_ck1);
		
		
		
		JCheckBox ck2 = new JCheckBox("");
		ck2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				nome2.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		GridBagConstraints gbc_ck2 = new GridBagConstraints();
		gbc_ck2.insets = new Insets(0, 0, 5, 5);
		gbc_ck2.gridx = 1;
		gbc_ck2.gridy = 6;
		contentPane.add(ck2, gbc_ck2);
		
		JCheckBox ck3 = new JCheckBox("");
		ck3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				nome3.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		GridBagConstraints gbc_ck3 = new GridBagConstraints();
		gbc_ck3.insets = new Insets(0, 0, 5, 5);
		gbc_ck3.gridx = 1;
		gbc_ck3.gridy = 7;
		contentPane.add(ck3, gbc_ck3);
		
		JCheckBox ck4 = new JCheckBox("");
		ck4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				nome4.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		GridBagConstraints gbc_ck4 = new GridBagConstraints();
		gbc_ck4.insets = new Insets(0, 0, 5, 5);
		gbc_ck4.gridx = 1;
		gbc_ck4.gridy = 8;
		contentPane.add(ck4, gbc_ck4);
		
		JCheckBox ck5 = new JCheckBox("");
		ck5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				nome5.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		GridBagConstraints gbc_ck5 = new GridBagConstraints();
		gbc_ck5.insets = new Insets(0, 0, 5, 5);
		gbc_ck5.gridx = 1;
		gbc_ck5.gridy = 9;
		contentPane.add(ck5, gbc_ck5);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 10;
		contentPane.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel btnErro = new JLabel("");	
		
		GridBagConstraints gbc_btnErro = new GridBagConstraints();
		gbc_btnErro.insets = new Insets(0, 0, 5, 5);
		gbc_btnErro.gridx = 2;
		gbc_btnErro.gridy = 12;
		contentPane.add(btnErro, gbc_btnErro);
		
		JButton btnIniciarConverso = new JButton("Iniciar convers\u00E3o");
		btnIniciarConverso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				btnErro.setIcon(new ImageIcon(Janela.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
				btnErro.setText("Iniciando raspagem de dados, aguarde até o processo finalizar");
				if(pathFinal!=null)
				{		
					String ext = FilenameUtils.getExtension(pathFinal);
					System.out.println(ext);
					if(ext.equals("pdf"))
					{
						if(ck1.isSelected() || ck2.isSelected() || ck3.isSelected() || ck4.isSelected() || ck5.isSelected())
						{
							ArrayList<String> nomes = new ArrayList<String>();
							if(ck1.isSelected())
							{
								nomes.add(nome1.getText());
							}
							if(ck2.isSelected())
							{
								nomes.add(nome2.getText());
							}						
							if(ck3.isSelected())
							{
								nomes.add(nome3.getText());
							}						
							if(ck4.isSelected())
							{
								nomes.add(nome4.getText());
							}						
							if(ck5.isSelected())
							{
								nomes.add(nome5.getText());
							}						
							ColetaPDF coleta = new ColetaPDF();
							System.out.println("Iniciando Raspagem");						
							try {
								ArrayList<String> advogados = new ArrayList<String>();
								
								advogados.add(nome1.getText());
								coleta.raspagem(pathFinal, advogados);
								btnErro.setIcon(new ImageIcon(Janela.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-information.png")));
								btnErro.setText("Processo finalizado com sucesso!");							
							} catch (IOException e) {							
								e.printStackTrace();
							}
						}
						
					}
					else
					{
						btnErro.setIcon(new ImageIcon(Janela.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
						btnErro.setText("Erro, o arquivo não é de extensão .PDF");
					}
				}
			}
		});
		btnIniciarConverso.setIcon(new ImageIcon(Janela.class.getResource("/sun/print/resources/oneside.png")));
		GridBagConstraints gbc_btnIniciarConverso = new GridBagConstraints();
		gbc_btnIniciarConverso.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciarConverso.gridx = 2;
		gbc_btnIniciarConverso.gridy = 11;
		contentPane.add(btnIniciarConverso, gbc_btnIniciarConverso);
		
		
		
		
		
		JLabel lblalpha = new JLabel("0.1-alpha");
		GridBagConstraints gbc_lblalpha = new GridBagConstraints();
		gbc_lblalpha.anchor = GridBagConstraints.SOUTH;
		gbc_lblalpha.gridx = 5;
		gbc_lblalpha.gridy = 19;
		contentPane.add(lblalpha, gbc_lblalpha);
	}

}
