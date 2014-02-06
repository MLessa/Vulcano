package view;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import model.Pessoa;
import service.PessoaService;

public class PessoaCreateForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JLabel lblNome;
	private JLabel lblIdade;
	private JLabel lblData;
	private JLabel lblGenero;
	private JLabel lblObservacao;
	private final Button btnSalvar = new Button("Salvar");
	private final Button btnLimpar = new Button("Limpar");
	private JCheckBox chkGenero;
	private JTextField txtObservacao;
	private JFormattedTextField txtData;
	private Pessoa pessoa;

	//Injected
	PessoaService pessoaService;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PessoaCreateForm frame = new PessoaCreateForm(null,null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public PessoaCreateForm(PessoaService pessoaService, Pessoa pessoa) {
		this.pessoa = pessoa;
		this.pessoaService=pessoaService;
		
		setTitle("Pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		lblNome = new JLabel("Nome:");
		contentPane.add(lblNome);

		txtNome = new JTextField();
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		lblData = new JLabel("Data:");
		contentPane.add(lblData);

		txtData = new JFormattedTextField();
		contentPane.add(txtData);
		try {  
			txtData.setFormatterFactory(new DefaultFormatterFactory(  
					new MaskFormatter("##-##-####")));  
		} catch (ParseException e) {  
			e.printStackTrace();  
		}  

		lblIdade = new JLabel("Idade:");
		contentPane.add(lblIdade);

		txtIdade = new JTextField();
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);

		lblGenero = new JLabel("Voce é Homem?");
		contentPane.add(lblGenero);

		chkGenero = new JCheckBox("");
		contentPane.add(chkGenero);

		lblObservacao = new JLabel("Observacao");
		contentPane.add(lblObservacao);

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});

		txtObservacao = new JTextField();
		contentPane.add(txtObservacao);
		contentPane.add(btnLimpar);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(txtNome.getText());
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

				Date date = null;
				try {
					date = (Date)formatter.parse(txtData.getText());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				pessoa.setData(date);

				pessoa.setGenero(chkGenero.isSelected());

				pessoa.setIdade(Integer.parseInt(txtIdade.getText()));

				pessoa.setObservacao(Long.parseLong(txtObservacao.getText()));

				salvar(pessoa);
			}
		});
		contentPane.add(btnSalvar);
		
		if(pessoa != null){
			carregarCampos();
		}
	}

	private void salvar(Pessoa pessoa){
		if (this.pessoa==null){
//			pessoaService.executeInsert(pessoa);
		}else{
			pessoa.setId(this.pessoa.getId());
//			pessoaService.executeUpdate(pessoa);
		}
	}

	private void carregarCampos(){
		txtNome.setText(pessoa.getNome());
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		txtData.setText(formatter.format(pessoa.getData()));
		chkGenero.setSelected(pessoa.getGenero());
		txtIdade.setText(String.valueOf(pessoa.getIdade()));
		txtObservacao.setText(String.valueOf(pessoa.getObservacao()));
	}

	private void clear(){
		txtNome.setText("");
		txtData.setText("");
		chkGenero.setSelected(false);
		txtIdade.setText(String.valueOf(""));
		txtObservacao.setText(String.valueOf(""));
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
