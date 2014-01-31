package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.TextField;

public class form extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField form;
	private JTextField idade;
	private JLabel campoNome;
	private JLabel campoIdade;
	private JLabel campoform;
	private JLabel campoGenero;
	private JLabel campoObservacao;
	private final Button salvar = new Button("Salvar");
	private final Button limpar = new Button("Limpar");
	private JCheckBox checkbox;
	private TextField observacao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
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
	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		campoNome = new JLabel("Nome:");
		contentPane.add(campoNome);
		
		nome = new JTextField();
		contentPane.add(nome);
		nome.setColumns(10);
		
		campoform = new JLabel("form:");
		contentPane.add(campoform);
		
		form = new JTextField();
		contentPane.add(form);
		form.setColumns(10);
		
		campoIdade = new JLabel("Idade:");
		contentPane.add(campoIdade);
		
		idade = new JTextField();
		contentPane.add(idade);
		idade.setColumns(10);
		
		campoGenero = new JLabel("Voce é Homem?");
		contentPane.add(campoGenero);
		
		checkbox = new JCheckBox("");
		contentPane.add(checkbox);
		
		campoObservacao = new JLabel("Observacao");
		contentPane.add(campoObservacao);
		
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		observacao = new TextField();
		contentPane.add(observacao);
		contentPane.add(limpar);
		
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(salvar);
	}
		
		private void clear(){
		nome.setText("");
		form.setText("");
		idade.setText("");
		observacao.setText("");
		checkbox.setSelected(false);
		
		}
}