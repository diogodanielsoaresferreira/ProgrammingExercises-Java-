/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

/**
Este programa demonstra a utilização de de uma estrutura de dados para
gerir a carga e descarga de vagões num comboio de mercadorias.
Crie o módulo Train de forma que o programa compile e funcione devidamente.
**/

import static java.lang.System.*;

public class MainTrain {
  public static void main(String[] args) {
    if (args.length < 2 || !isNumber(args[0]) || !isNumber(args[1])) {
      err.printf("Usage: java -ea MainTrain WagonCapacity TrainCapacity [...]\n");
      exit(1);
    }
    double wagonCapacity = Double.parseDouble(args[0]);  // capacidade de cada vagão
    double trainCapacity = Double.parseDouble(args[1]);  // capacidade total do comboio
    if (wagonCapacity <= 0) {
      err.printf("ERRO: A capacidade tem de ser positiva!\n");
      exit(1);
    }
    if (trainCapacity < wagonCapacity) {
      err.printf("ERRO: A capacidade do comboio deve superar a de um vagão!\n");
      exit(1);
    }
    
    // Cria comboio com as capacidades indicadas:
    Train train = new Train(wagonCapacity, trainCapacity);
    out.printf("(Capacidade dos vagões: %.1f ton.)\n", wagonCapacity);
    out.printf("(Capacidade do comboio: %.1f ton.)\n", trainCapacity);
    double c;
    int n;
    
    for (int i = 2; i < args.length; i++) {
      out.printf("args[%d]=\"%s\": ", i, args[i]);
      
      if (args[i].equalsIgnoreCase("R")) {  // "R" => retirar um vagão
        if (train.isEmpty()) {  // se comboio não tem vagões, não posso retirar nada!
          err.println("ERRO: Comboio vazio!\n");
          exit(1);
        }
        c = train.removeWagon();   // retira 1 vagão e devolve a carga que transportava
        out.printf("Retira vagão com %.1f ton\n", c);
      } else if (isNumber(args[i])) {
        c = Double.parseDouble(args[i]);
        if (c >= 0) {  // valor positivo => acrescentar um vagão com essa carga
          if (c > wagonCapacity) {  // se carga supera capacidade de um vagão,
            err.printf("ERRO: Sobrecarga de vagão!\n");
            exit(1);
          }
          if (!train.acceptsCargo(c)) {  // se carga tornaria o comboio pesado demais,
            err.printf("ERRO: Sobrecarga do comboio!\n");
            exit(1);
          }
          train.addWagon(c);  // acrescenta ao comboio um novo vagão com carga c
          out.printf("Junta vagão com %.1f ton\n", c);
        } else {  // valor negativo => descarregar essa carga
          c = -c;
          if (c > train.totalCargo()) {  // não podemos descarregar mais do que temos!
            err.printf("ERRO: Comboio não tem carga suficiente!\n");
            exit(1);
          }
          n = train.unload(c);  // descarregar carga c, retirando n vagões vazios
          out.printf("Descarrega %.1f ton e retira %d vagões vazios.\n", c, n);
        }
      } else {
        err.printf("ERRO: Argumento inválido!\n");
        exit(1);
      }
      
      // Mostra o estado do comboio: tamanho, carga total e lista dos vagões
      out.printf("  (%d vagões, %.1f ton):\tLocO",
                 train.size(), train.totalCargo());
      double[] wagons = train.list();  // obtém array com as cargas dos vagões
      for (int k = 0; k < wagons.length; k++) {
        out.printf("_[%.1f]", wagons[k]);
      }
      out.println();
    }
  }
  
  /** Verifica se string s contém um número real. **/
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
