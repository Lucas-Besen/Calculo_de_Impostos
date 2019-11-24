import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int escolhaSair = 0;
		double valor = 0, icms = 0, ipi = 0, pis = 0, cofins = 0;
		String nome = "", valorS = "", icmsS = "", ipiS = "", pisS = "", cofinsS = "";

		Verificacao Verifica_Valores = new Verificacao();

		Verificacao.Aviso_inicio();

		do {

			do {

				try {
					nome = JOptionPane.showInputDialog(null, "Digite o nome do produto ?", "Informação",
							JOptionPane.QUESTION_MESSAGE);
					Verifica_Valores.setVerifica_Vazio(nome);
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}

			} while (Verifica_Valores.getResultado() == true);

			do {

				try {
					valorS = JOptionPane.showInputDialog(null, "Produto: " + nome + " \nValor pago pelo produto R$: ",
							"Informação", JOptionPane.QUESTION_MESSAGE);
					Verifica_Valores.setVerificaNumero(valorS);

				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}

				if (Verifica_Valores.getResultado() == false) {
					try {
						Verifica_Valores.setVerifica_Menor(Double.parseDouble(valorS));
					} catch (IllegalArgumentException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}

			} while (Verifica_Valores.getResultado() == true);

			valor = Double.parseDouble(valorS);

			Verificacao.Aviso_ali();

			do {
				try {
					icmsS = JOptionPane.showInputDialog(null,
							"Digite a alíquota do ICMS % \nobs: Digitar 0 se nao tiver esse imposto", "Informação",
							JOptionPane.QUESTION_MESSAGE);
					if (icmsS == null)
						System.exit(0);
					Verifica_Valores.setVerificaNumero(icmsS);
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				if (Verifica_Valores.getResultado() == false) {
					try {
						Verifica_Valores.setVerifica_Menor2(Double.parseDouble(icmsS));
					} catch (IllegalArgumentException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
			} while (Verifica_Valores.getResultado() == true);

			do {
				try {
					ipiS = JOptionPane.showInputDialog(null,
							"Digite a alíquota do IPI % \nobs: Digitar 0 se nao tiver esse imposto", "Informação",
							JOptionPane.QUESTION_MESSAGE);
					if (ipiS == null)
						System.exit(0);
					Verifica_Valores.setVerificaNumero(ipiS);
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				if (Verifica_Valores.getResultado() == false) {
					try {
						Verifica_Valores.setVerifica_Menor2(Double.parseDouble(ipiS));
					} catch (IllegalArgumentException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
			} while (Verifica_Valores.getResultado() == true);

			do {
				try {
					pisS = JOptionPane.showInputDialog(null,
							"Digite a alíquota do PIS % \nobs: Digitar 0 se nao tiver esse imposto", "Informação",
							JOptionPane.QUESTION_MESSAGE);
					if (pisS == null)
						System.exit(0);
					Verifica_Valores.setVerificaNumero(pisS);
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				if (Verifica_Valores.getResultado() == false) {
					try {
						Verifica_Valores.setVerifica_Menor2(Double.parseDouble(pisS));
					} catch (IllegalArgumentException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
			} while (Verifica_Valores.getResultado() == true);

			do {
				try {
					cofinsS = JOptionPane.showInputDialog(null,
							"Digite a alíquota do COFINS % \nobs: Digitar 0 se nao tiver esse imposto", "Informação",
							JOptionPane.QUESTION_MESSAGE);
					if (cofinsS == null)
						System.exit(0);
					Verifica_Valores.setVerificaNumero(cofinsS);
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				if (Verifica_Valores.getResultado() == false) {
					try {
						Verifica_Valores.setVerifica_Menor2(Double.parseDouble(cofinsS));
					} catch (IllegalArgumentException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
			} while (Verifica_Valores.getResultado() == true);

			// calculos
			icms = Double.parseDouble(icmsS);
			icms /= 100;
			icms *= valor;

			ipi = Double.parseDouble(ipiS);
			ipi /= 100;
			ipi *= valor;

			pis = Double.parseDouble(pisS);
			pis /= 100;
			pis *= valor;

			cofins = Double.parseDouble(cofinsS);
			cofins /= 100;
			cofins *= valor;

			valor -= (ipi + pis + icms + cofins);

			JOptionPane.showMessageDialog(null,
					"valor do produto sem impostos R$: " + valor + "\n o valor do COFINS R$: " + cofins
							+ "\n o valor do ICMS R$: " + icms + "\n o valor do PIS R$: " + pis
							+ "\n o valor do IPI R$: " + ipi);

			String[] opt = { "sim", "nao" };
			escolhaSair = JOptionPane.showOptionDialog(null, "voce quer fazer outro calculo ?", "Sair",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);

		} while (escolhaSair != 1);

		Verificacao.Aviso_Final();

	}

}
