package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
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
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class PessoaView extends JFrame {

	private JPanel contentPane;

	private JLabel nomeLabel;
	private JLabel cpfLabel;
	private JLabel dataLabel;
	private JLabel sexoLabel;


	private JTextField nomeField;
	private JTextField cpfField;
	private JFormattedTextField dataField;
	private JCheckBox sexoField;


	private final Button salvar = new Button("Salvar");
	private final Button limpar = new Button("Limpar");


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PessoaView frame = new PessoaView();
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
	public PessoaView() {
		//
		setTitle("Cadastro PessoaView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));


		nomeLabel = new JLabel("nome");
		contentPane.add(nomeLabel);

		nomeField = new JTextField();
		contentPane.add(nomeField);
		nomeField.setColumns(10);

		cpfLabel = new JLabel("cpf");
		contentPane.add(cpfLabel);

		cpfField = new JTextField();
		contentPane.add(cpfField);
		cpfField.setColumns(10);

		dataLabel = new JLabel("data");
		contentPane.add(dataLabel);

		dataField = new JFormattedTextField();
		contentPane.add(dataField);
		try {  
			dataField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##-##-####")));  
		} catch (ParseException e) { 
			e.printStackTrace(); 

		}
		sexoLabel = new JLabel("sexo");
		contentPane.add(sexoLabel);

		sexoField = new JCheckBox("");
		contentPane.add(sexoField);




		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});

		contentPane.add(limpar);

		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		contentPane.add(salvar);
	}

	private void clear(){

		nomeField.setText("");
		cpfField.setText("");
		dataField.setText("");
		sexoField.setSelected(false);


	}
}