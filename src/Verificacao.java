import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Verificacao {

	private boolean resultado = true;;

	public void setVerifica_Vazio(String x) {
		if (x == null)
			System.exit(0);
		resultado = true;
		Pattern padrao = Pattern.compile("[a-z]+|.*[a-z]+|[A-Z]+|.*[A-Z]+|[A-z]+|.*[A-z]+");
		Matcher pesquisa = padrao.matcher(x);
		if (!pesquisa.matches())
			throw new IllegalArgumentException("Por Favor digite o Nome para continuar");

		else
			resultado = false;

	}

	public void setVerificaNumero(String x) {
		if (x == null)
			System.exit(0);
		resultado = true;
		Pattern padrao = Pattern.compile("[\\d]*.+");
		Matcher pesquisa = padrao.matcher(x);
		if (!pesquisa.matches())
			throw new IllegalArgumentException("Por Favor digite algum numero para continuar");

		else
			resultado = false;

	}

	public void setVerifica_Menor(double x) {

		resultado = true;
		if (x <= 0)
			throw new IllegalArgumentException("Digite um valor Maior que 0");

		else
			resultado = false;

	}

	public void setVerifica_Menor2(double x) {

		resultado = true;
		if (x <= -1)
			throw new IllegalArgumentException("Digite um numero positivo");

		else
			resultado = false;

	}

	public boolean getResultado() {

		return resultado;
	}

	public static void Aviso_inicio() {
		JOptionPane.showMessageDialog(null,
				"Este programa calcula o valor dos produtos sem impostos e o valor dos impostos", "AVISO",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void Aviso_ali() {
		JOptionPane.showMessageDialog(null, "Digite os valores da alíquota usando apenas valor e pontuaçao ", "AVISO",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
