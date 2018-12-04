package View;

import java.util.List;

import javax.swing.JOptionPane;

import Casa.TerrenoComercializavel.TerrenoComercializavel;
import Jogador.Jogador;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;
import recursos.cenarios.Cenario1;

public class DesenhaComponenteGrafico {
	private Window window;
	private Scene scene;
	private Keyboard teclado;
	private Cenario1 cenario;
	public DesenhaComponenteGrafico() {
		
	}
	
	public void lobby() {
		this.window = new Window(704, 704);
		scene = new Scene();
		GameImage back = new GameImage("src//recursos//sprites//back.png");
		teclado = window.getKeyboard();
		boolean sair = false;
		while(!sair) {
			back.draw();
			window.update();
			if(teclado.keyDown(Keyboard.ENTER_KEY)) {
				sair = true;
				break;
			}
		}
	}
	
	public void desenhaTabuleiro(List<Jogador> jogadores) {
		cenario = new Cenario1(window, jogadores, scene, teclado);
	}
	
	public int telaInserirQtdJogador() {
		Object[] opcoes = {2, 3, 4, 5, 6};
		Object res = JOptionPane.showInputDialog(null, "Escolha a quantidade de jogadores" , "Selecao de itens" ,
						JOptionPane.PLAIN_MESSAGE , null ,opcoes,"");
		return (Integer) res;
	}
	
	public void desenhaPecasNoTabuleiroInicio() {
		cenario.run();
	}
	
	public void mensagemInicial(List<Jogador> jogadores) {
		String mensagemInicial = "";
		for(Jogador j: jogadores) {
			mensagemInicial = mensagemInicial + "Jogador"+j.getId()+" é a peca de cor "+j.getPecaJogador().getCor()+"\n";
		}
		JOptionPane.showMessageDialog(null, mensagemInicial, null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	public Keyboard getTeclado() {
		return this.teclado;
	}
	
	public Cenario1 getCenario() {
		return this.cenario;
	}
	
	public int mensagemConfirmacaoCompra() {
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja comprar este Imóvel?", null, JOptionPane.YES_NO_OPTION);
		return resposta;
	}
	
	public void mensagemPagarTaxa(double valor) {
		JOptionPane.showMessageDialog(null, "Você terá que pagar "+valor+" de taxa", null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemSorteReves(String tipo, double valor) {
		if(tipo.equals("Sorte")) {
			JOptionPane.showMessageDialog(null, "Sorte Ou Reves\nSORTE ganhou " + valor, null, JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Sorte Ou Reves\nREVES pedeu " + valor, null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void mensagemSorteRecebe50DeTodos() {
		JOptionPane.showMessageDialog(null, "Sorte Ou Reves\nSORTE ganhou 50.0 de Todos", null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemSorteSaidaLivre() {
		JOptionPane.showMessageDialog(null, "Sorte Ou Reves\nSORTE ganhou passe livre", null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemRevesVaParaCadeia() {
		JOptionPane.showMessageDialog(null, "Sorte Ou Reves\nREVES va para cadeia", null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemPreso() {
		JOptionPane.showMessageDialog(null, "Que pena! Você está preso!", null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemLucrosDividendos() {
		JOptionPane.showMessageDialog(null, "Lucros e Dividendos\nParabéns! Você ganhou 200.0", null, JOptionPane.INFORMATION_MESSAGE);
	}

	public void mensagemCadeiaVisitante() {
		JOptionPane.showMessageDialog(null, "Relaxa! Você está só de visita na cadeia", null, JOptionPane.INFORMATION_MESSAGE);
	}

	public void mensagemParadaLivre() {
		JOptionPane.showMessageDialog(null, "Nada acontece =)", null, JOptionPane.INFORMATION_MESSAGE);
	}

	public void mensagemImposto() {
		JOptionPane.showMessageDialog(null, "Imposto de Renda\nPague 200.0", null, JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void mensagemPassouInicio() {
		JOptionPane.showMessageDialog(null, "Você deu uma volta completa no tabuleiro\nGanhou 200.0", null, JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarSaldoJogador(double saldo) {
		JOptionPane.showMessageDialog(null, "Saldo\nVoce possui "+saldo+" em sua conta", null, JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarTerrenos(List<TerrenoComercializavel> terrenos) {
		String meusTerrenos = "";
		if(terrenos.size() == 0) {
			meusTerrenos = "Você não possui nenhum terreno!";
		} else {
			meusTerrenos = "Minhas Propriedades:\n";
			for(TerrenoComercializavel terreno: terrenos) {
				meusTerrenos = meusTerrenos + "* " +terreno.getNome()+"\n";
			}
		}
		JOptionPane.showMessageDialog(null, meusTerrenos, null, JOptionPane.INFORMATION_MESSAGE);
	}

	public void mensagemSaldoInsuficiente() {
		JOptionPane.showMessageDialog(null, "Saldo Insuficiente", null, JOptionPane.INFORMATION_MESSAGE);
	}
}
