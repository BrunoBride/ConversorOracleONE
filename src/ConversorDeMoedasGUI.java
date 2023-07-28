import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class ConversorDeMoedasGUI {

	private JFrame frmConversorMoeda;
	private JTextField txtFldValorInformado;
	private JComboBox<String> cbbMoedaDe;
	private JComboBox<String> cbbMoedaPara;
	private JLabel lblResultado;

	// Taxas de conversão das moedas em relação ao Real (BRL)
	private final double[] matrizMoedas = { 1.0, 4.73, 5.27, 6.14, 0.01737, 0.005747 };
	             //Sequencia das taxas -     BRL,  USD,  EUR,  GBP,   ARS  ,    CLP
		         //Real, Dólar, Euro, Libras Esterlinas, Peso Argentino, Peso Chileno
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorDeMoedasGUI window = new ConversorDeMoedasGUI();
					window.frmConversorMoeda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConversorDeMoedasGUI() {
		initialize();
	}

	private void initialize() {
		frmConversorMoeda = new JFrame();
		frmConversorMoeda.setFont(new Font("Dialog", Font.PLAIN, 11));
		frmConversorMoeda.setTitle(":: Conversor de Moedas ::");
		frmConversorMoeda.setBounds(100, 100, 330, 300);
		frmConversorMoeda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversorMoeda.getContentPane().setLayout(null);

		JPanel painelConversorMoeda = new JPanel();
		painelConversorMoeda.setBounds(0, 0, 314, 261);
		frmConversorMoeda.getContentPane().add(painelConversorMoeda);
		painelConversorMoeda.setLayout(null);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(30, 30, 70, 20);
		painelConversorMoeda.add(lblValor);

		txtFldValorInformado = new JTextField();
		txtFldValorInformado.setText("1");
		txtFldValorInformado.setBounds(100, 30, 120, 20);
		painelConversorMoeda.add(txtFldValorInformado);
		txtFldValorInformado.setColumns(10);

		JLabel lblDe = new JLabel("De:");
		lblDe.setBounds(30, 70, 70, 20);
		painelConversorMoeda.add(lblDe);

		cbbMoedaDe = new JComboBox<>();
		cbbMoedaDe.setBounds(100, 70, 120, 20);
		cbbMoedaDe.addItem("Reais");
		cbbMoedaDe.addItem("Dólar");
		cbbMoedaDe.addItem("Euro");
		cbbMoedaDe.addItem("Libras Esterlinas");
		cbbMoedaDe.addItem("Peso Argentino");
		cbbMoedaDe.addItem("Peso Chileno");
		painelConversorMoeda.add(cbbMoedaDe);

		JLabel lblPara = new JLabel("Para:");
		lblPara.setBounds(30, 110, 70, 20);
		painelConversorMoeda.add(lblPara);

		cbbMoedaPara = new JComboBox<>();
		cbbMoedaPara.setBounds(100, 110, 120, 20);
		cbbMoedaPara.addItem("Reais");
		cbbMoedaPara.addItem("Dólar");
		cbbMoedaPara.addItem("Euro");
		cbbMoedaPara.addItem("Libras Esterlinas");
		cbbMoedaPara.addItem("Peso Argentino");
		cbbMoedaPara.addItem("Peso Chileno");
		painelConversorMoeda.add(cbbMoedaPara);

		JButton btnConverter = new JButton("Converter");
		btnConverter.setBounds(30, 150, 190, 30);
		painelConversorMoeda.add(btnConverter);

		lblResultado = new JLabel("");
		lblResultado.setBounds(10, 192, 300, 20);
		painelConversorMoeda.add(lblResultado);
		
		JLabel lblMsgDeusFiel = new JLabel("Deus \u00E9 Fiel !");
		lblMsgDeusFiel.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblMsgDeusFiel.setLabelFor(frmConversorMoeda);
		lblMsgDeusFiel.setBounds(243, 236, 61, 14);
		painelConversorMoeda.add(lblMsgDeusFiel);

		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				converterMoeda();
			}
		});
	}

	private void converterMoeda() {
		String moedaDe = cbbMoedaDe.getSelectedItem().toString();
		String moedaPara = cbbMoedaPara.getSelectedItem().toString();

		double resultado = 0.0;
		try {
			resultado = Double.parseDouble(txtFldValorInformado.getText());
		} catch (NumberFormatException ex) {
			lblResultado.setText("Valor inválido.");
			return;
		}

		int opcaoMoedaDe = getCurrencyIndex(moedaDe);
		int opcaoMoedaPara = getCurrencyIndex(moedaPara);

		double converterValor = resultado * matrizMoedas[opcaoMoedaPara] / matrizMoedas[opcaoMoedaDe];
		lblResultado.setText(
				String.format("%.2f %s equivalem\n a %.2f %s", resultado, moedaDe, converterValor, moedaPara));
	}

	private int getCurrencyIndex(String currency) {
		switch (currency) {
		case "Reais":
			return 0;
		case "Dólar":
			return 1;
		case "Euro":
			return 2;
		case "Libras Esterlinas":
			return 3;
		case "Peso Argentino":
			return 4;
		case "Peso Chileno":
			return 5;
		default:
			return -1;
		}
	}
}