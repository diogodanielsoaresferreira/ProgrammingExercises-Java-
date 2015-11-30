/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

/**
Este programa demonstra a utiliza��o de de uma estrutura de dados para
gerir a carga e descarga de vag�es num comboio de mercadorias.
Crie o m�dulo Train de forma que o programa compile e funcione devidamente.
**/

import static java.lang.System.*;

public class MainTrain {
  public static void main(String[] args) {
    if (args.length < 2 || !isNumber(args[0]) || !isNumber(args[1])) {
      err.printf("Usage: java -ea MainTrain WagonCapacity TrainCapacity [...]\n");
      exit(1);
    }
    double wagonCapacity = Double.parseDouble(args[0]);  // capacidade de cada vag�o
    double trainCapacity = Double.parseDouble(args[1]);  // capacidade total do comboio
    if (wagonCapacity <= 0) {
      err.printf("ERRO: A capacidade tem de ser positiva!\n");
      exit(1);
    }
    if (trainCapacity < wagonCapacity) {
      err.printf("ERRO: A capacidade do comboio deve superar a de um vag�o!\n");
      exit(1);
    }
    
    // Cria comboio com as capacidades indicadas:
    Train train = new Train(wagonCapacity, trainCapacity);
    out.printf("(Capacidade dos vag�es: %.1f ton.)\n", wagonCapacity);
    out.printf("(Capacidade do comboio: %.1f ton.)\n", trainCapacity);
    double c;
    int n;
    
    for (int i = 2; i < args.length; i++) {
      out.printf("args[%d]=\"%s\": ", i, args[i]);
      
      if (args[i].equalsIgnoreCase("R")) {  // "R" => retirar um vag�o
        if (train.isEmpty()) {  // se comboio n�o tem vag�es, n�o posso retirar nada!
          err.println("ERRO: Comboio vazio!\n");
          exit(1);
        }
        c = train.removeWagon();   // retira 1 vag�o e devolve a carga que transportava
        out.printf("Retira vag�o com %.1f ton\n", c);
      } else if (isNumber(args[i])) {
        c = Double.parseDouble(args[i]);
        if (c >= 0) {  // valor positivo => acrescentar um vag�o com essa carga
          if (c > wagonCapacity) {  // se carga supera capacidade de um vag�o,
            err.printf("ERRO: Sobrecarga de vag�o!\n");
            exit(1);
          }
          if (!train.acceptsCargo(c)) {  // se carga tornaria o comboio pesado demais,
            err.printf("ERRO: Sobrecarga do comboio!\n");
            exit(1);
          }
          train.addWagon(c);  // acrescenta ao comboio um novo vag�o com carga c
          out.printf("Junta vag�o com %.1f ton\n", c);
        } else {  // valor negativo => descarregar essa carga
          c = -c;
          if (c > train.totalCargo()) {  // n�o podemos descarregar mais do que temos!
            err.printf("ERRO: Comboio n�o tem carga suficiente!\n");
            exit(1);
          }
          n = train.unload(c);  // descarregar carga c, retirando n vag�es vazios
          out.printf("Descarrega %.1f ton e retira %d vag�es vazios.\n", c, n);
        }
      } else {
        err.printf("ERRO: Argumento inv�lido!\n");
        exit(1);
      }
      
      // Mostra o estado do comboio: tamanho, carga total e lista dos vag�es
      out.printf("  (%d vag�es, %.1f ton):\tLocO",
                 train.size(), train.totalCargo());
      double[] wagons = train.list();  // obt�m array com as cargas dos vag�es
      for (int k = 0; k < wagons.length; k++) {
        out.printf("_[%.1f]", wagons[k]);
      }
      out.println();
    }
  }
  
  /** Verifica se string s cont�m um n�mero real. **/
  public static boolean isNumber(String s) {
    boolean b = true;
    try {
      Double.parseDouble(s);
    } catch (NumberFormatException e) {
      b = false;
    }
    return b;
  }
}
