import java.awt.Color;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class metaData {
	
	/*meta.localNoroeste = 0
	meta.localNordeste = 1
	meta.localSudoeste = 2
	meta.localSudeste = 3
	meta.localNorte = 4
	meta.localOeste = 5
	meta.localCentro = 6
	meta.localLeste = 7
	meta.localSul = 8*/
	
    Random ran = new Random();

    //Escolha de jogador
	int pick = 0;
	//Contador de cada coordenada
    int[] cont = new int[9];
    //Bot�es das coordenadas
    JButton[] btn = new JButton[9];
    //??
	int local[] = new int[9];
	//Visualizador se bot�o j� foi apertado
	boolean[] ativo = {false, false, false, false, false, false, false, false, false};
	//Salvador player
	private String dataNick;
	private int setSave = 0;
	//Construtor do metaData player
	metaData player = new metaData();

	//M�TODOS COMUNS
	public int local(int x) {
	int result;
	if(x == 0) {
		pick = 1;
		result = 0;
	}
	else {
		pick = 0;
		result = 1;
		
	}
	return result;
}
	
	public int whoWin(int local[], boolean[] ativo)
			throws HeadlessException, FileNotFoundException, IOException {
		if(local[0] == 0 && local[6] == 0 && local[3] == 0) {
			JOptionPane.showMessageDialog(null, "Voc� venceu!");
			player.carregar().replaceAll(" = 0 V", " = 1 V ");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[0] == 1 && local[6] == 1 && local[3] == 1) {
			JOptionPane.showMessageDialog(null, "Voc� perdeu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[0] == 0 && local[4] == 0 && local[1] == 0) {
			JOptionPane.showMessageDialog(null, "Voc� venceu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[0] == 1 && local[4] == 1 && local[1] == 1) {
			JOptionPane.showMessageDialog(null, "Voc� perdeu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[0] == 0 && local[5] == 0 && local[2] == 0) {
			JOptionPane.showMessageDialog(null, "Voc� venceu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[0] == 1 && local[5] == 1 && local[2] == 1) {
			JOptionPane.showMessageDialog(null, "Voc� perdeu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[5] == 0 && local[6] == 0 && local[7] == 0) {
			JOptionPane.showMessageDialog(null, "Voc� venceu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[5] == 1 && local[6] == 1 && local[7] == 1) {
			JOptionPane.showMessageDialog(null, "Voc� perdeu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[2] == 0 && local[8] == 0 && local[3] == 0) {
			JOptionPane.showMessageDialog(null, "Voc� venceu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[2] == 1 && local[8] == 1 && local[3] == 1) {
			JOptionPane.showMessageDialog(null, "Voc� perdeu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[1] == 0 && local[6] == 0 && local[2] == 0) {
			JOptionPane.showMessageDialog(null, "Voc� venceu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[1] == 1 && local[6] == 1 && local[2] == 1) {
			JOptionPane.showMessageDialog(null, "Voc� perdeu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[1] == 0 && local[7] == 0 && local[3] == 0) {
			JOptionPane.showMessageDialog(null, "Voc� venceu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[1] == 1 && local[7] == 1 && local[3] == 1) {
			JOptionPane.showMessageDialog(null, "Voc� perdeu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[4] == 0 && local[6] == 0 && local[8] == 0) {
			JOptionPane.showMessageDialog(null, "Voc� venceu!");
			new JMenu().setVisible(true);
			return 1;
		}
		else if(local[4] == 1 && local[6] == 1 && local[8] == 1) {
			JOptionPane.showMessageDialog(null, "Voc� perdeu!");
			new JMenu().setVisible(true);
			return 1;
		}
		if(ativo[0] == true && ativo[1] == true && ativo[2] == true && ativo[3] == true &&
				ativo[4] == true && ativo[5] == true && ativo[6] == true && ativo[7] == true
				&& ativo[8] == true) {
			JOptionPane.showMessageDialog(null, "Ningu�m ganhou!");
			new JMenu().setVisible(true);
			return 1;
		}
		return 0;
	}
	
	public boolean complete(boolean[] ativo) {
		if(ativo[0] == true && ativo[1] == true && ativo[2] == true && ativo[3] == true &&
				ativo[4] == true && ativo[5] == true && ativo[6] == true && ativo[7] == true
				&& ativo[8] == true) {
			JOptionPane.showMessageDialog(null, "Ningu�m ganhou!");
			return true;
		}
		return false;
	}
	
	public void VerifyBackground(JButton btn, int pick) {
		if(pick == 0) {
		btn.setBackground(Color.GREEN);
		}
		else {
			btn.setBackground(Color.RED);
		}
	}

	//M�TODOS MENU
	
	public void salvar(String conteudo, boolean adicionar)
			throws IOException {
				FileWriter fw = 
						new FileWriter("C:\\Users\\J_geb\\eclipse-workspace\\Jogo da Velha\\"
								+ "savedDataNicks.txt", adicionar);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(conteudo);
				pw.flush();
				pw.close();
			}

			public String carregar()
			throws FileNotFoundException, IOException {

				File file = 
						new File("C:\\Users\\User1\\eclipse-workspace\\Jogo da Velha\\"
								+ "savedDataNicks.txt");

				if (! file.exists()) {
					return null;
				}

				BufferedReader br = 
						new BufferedReader(new FileReader("C:\\Users\\J_geb\\eclipse-workspace\\"
								+ "Jogo da Velha\\savedDataNicks.txt"));
				StringBuffer bufSaida = new StringBuffer();

				int c;
				while( (c = br.read()) > 1 ){
					bufSaida.append((char)c);
				}
				br.close();
				return bufSaida.toString();
			}
	
	public void Players() {
		this.dataNick = "";
		//this.dataPoints = 0;
	}
	
		//M�TODOS GAME EASY	
	public int generate () {
        int aux = 0;
        int save = 0;
        
        while(aux != 1) {

		switch (ran.nextInt(9)) {
			case 0:
				if(cont[0] != 1) {
					btn[0].setBackground(new Color(255, 69, 0));
	    			cont[0] = 1;
					aux = 1;
					
					//Desabilitar o bot�o
					btn[0].setEnabled(false);
					
					ativo[0] = true;
					
					save = 0;
					break;
				}
			case 4:
					if(cont[4] != 1) {
						btn[4].setBackground(new Color(255, 69, 0));
						aux = 1;
	    				cont[4] = 1;
					
					//Desabilitar o bot�o
					btn[4].setEnabled(false);
					
					ativo[4] = true;
					
					save = 4;
					break;
				}
			case 1:
				if(cont[1] != 1) {
					btn[1].setBackground(new Color(255, 69, 0));
					aux = 1;
	   				cont[1] = 1;
					
					//Desabilitar o bot�o
					btn[1].setEnabled(false);
					
					ativo[1] = true;
					
					save = 1;
					break;
				}
			case 5:
				if(cont[5] != 1) {
					btn[5].setBackground(new Color(255, 69, 0));
						aux = 1;
	    				cont[5] = 1;
					
					//Desabilitar o bot�o
					btn[5].setEnabled(false);
					
					ativo[5] = true;
					
					save = 5;
					break;
				}
			case 6:
					if(cont[6] != 1) {
					btn[6].setBackground(new Color(255, 69, 0));
					aux = 1;
	    			cont[6] = 1;
					
					//Desabilitar o bot�o
					btn[6].setEnabled(false);
					
					ativo[6] = true;
					
					save = 6;
					break;
				}
			case 7:
				if(cont[7] != 1) {
					btn[7].setBackground(new Color(255, 69, 0));
						aux = 1;
	    				cont[7] = 1;
					
					//Desabilitar o bot�o
					btn[7].setEnabled(false);
					
					ativo[7] = true;
					
					save = 7;
					break;
				}
			case 2:
					if(cont[2] != 1) {
						btn[2].setBackground(new Color(255, 69, 0));
					aux = 1;
	    			cont[2] = 1;
					
					//Desabilitar o bot�o
					btn[2].setEnabled(false);
					
					ativo[2] = true;
					
					save = 2;
					break;
				}
			case 8:
				if(cont[8] != 1) {
					btn[8].setBackground(new Color(255, 69, 0));
						aux = 1;
	    				cont[8] = 1;
					
					//Desabilitar o bot�o
					btn[8].setEnabled(false);
					
					ativo[8] = true;
					
					save = 8;
					break;
				}
			case 3:
				if(cont[3] != 1) {
					btn[3].setBackground(new Color(255, 69, 0));
					aux = 1;
	   				cont[3] = 1;
					
					//Desabilitar o bot�o
					btn[3].setEnabled(false);
					
					ativo[3] = true;
					
					save = 3;
					break;
				}
			}
        }
		return save;
    }
	
		//M�TODOS GAME HARD
	public int generateFirst () {
		int save = 0;

	switch (ran.nextInt(4)) {
		case 0:
			if(cont[0] != 1) {
				btn[0].setBackground(new Color(255, 69, 0));
    			cont[0] = 1;
				
				//Desabilitar o bot�o
				btn[0].setEnabled(false);
				
				ativo[0] = true;
				
				save = 0;
				break;
			}
		case 1:
			if(cont[1] != 1) {
				btn[1].setBackground(new Color(255, 69, 0));
   				cont[1] = 1;
				
				//Desabilitar o bot�o
				btn[1].setEnabled(false);
				
				ativo[1] = true;
				
				save = 1;
   				break;
			}
		case 2:
			if(cont[2] != 1) {
				btn[2].setBackground(new Color(255, 69, 0));
				cont[2] = 1;
				
				//Desabilitar o bot�o
				btn[2].setEnabled(false);
				
				ativo[2] = true;
				
				save = 2;
				break;
			}
		case 3:
			if(cont[3] != 1) {
				btn[3].setBackground(new Color(255, 69, 0));
   				cont[3] = 1;
				
				//Desabilitar o bot�o
				btn[3].setEnabled(false);
				
				ativo[3] = true;
				
				save = 3;
   				break;
			}
	}
	return save;
	}
	
}