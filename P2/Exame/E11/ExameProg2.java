/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

/**
 * Este programa serve para verificar se uma express�o aritm�tica (formada
 * por d�gitos, opera��es elementares e par�ntesis) � sintacticamente v�lida.
 * Crie o m�dulo StackX de forma que este programa funcione devidamente
 * respeitando o comportamento esperado de uma Pilha.
 */

import static java.lang.System.*;
import java.util.Scanner;

public class ExameProg2 {
   public static void main(String[] args) {
      Stack2 p = new Stack2();
      String[] e = {"(e)","e+e","e-e","e*e","e/e","D"}; // formas alternativas para
      // definir uma express�o
      if (args.length != 1) {
         exit(1); // ERRO na chamada!
      }

      String expr = args[0];
      for(int i = 0;i < expr.length();i++) {
         char c = expr.charAt(i);
         if (Character.isDigit(c))
            p.push('D'); // coloca o car�cter 'D' no stack, indicando presen�a de um d�gito
         else
            p.push(c); // coloca o car�cter armazenado em c no stack

         out.print("  PUSH: ");
         out.println(p.toStrings()); // escreve numa �nica linha o conte�do da pilha (sem a alterar)

         boolean change;
         do
         {
            // tenta reduzir a express�o no topo do stack para outra mais simples
            change = false;
            for(int j = 0;!change && j < e.length;j++) {
               String pattern = e[j];
               int n = pattern.length();
               if (p.topMatches(pattern)) { // verifica se os n caracteres no topo da pilha s�o iguais a pattern
            	  p.popN(n); // retira n elementos do topo
                  p.push('e'); // coloca 'e' no stack
                  change = true;
                  out.print("REDUCE: ");
                  out.println(p.toStrings()); // escreve numa �nica linha o conte�do da pilha (sem a alterar)
               }
            }
         }
         while(change);
      }

      if (p.size() == 1 && p.top() == 'e')
         out.println("Correct expression!");
      else
         out.println("Bad expression!");
   }
}

/* Exemplos de utiliza��o e resultados esperados:

> java -ea ProgX "2+2"
  PUSH: D
REDUCE: e
  PUSH: e+
  PUSH: e+D
REDUCE: e+e
REDUCE: e
Correct expression!

> java -ea ProgX "2+(2-3)"
  PUSH: D
REDUCE: e
  PUSH: e+
  PUSH: e+(
  PUSH: e+(D
REDUCE: e+(e
  PUSH: e+(e-
  PUSH: e+(e-D
REDUCE: e+(e-e
REDUCE: e+(e
  PUSH: e+(e)
REDUCE: e+e
REDUCE: e
Correct expression!

> java -ea ProgX "3*(4/(3))"
  PUSH: D
REDUCE: e
  PUSH: e*
  PUSH: e*(
  PUSH: e*(D
REDUCE: e*(e
  PUSH: e*(e/
  PUSH: e*(e/(
  PUSH: e*(e/(D
REDUCE: e*(e/(e
  PUSH: e*(e/(e)
REDUCE: e*(e/e
REDUCE: e*(e
  PUSH: e*(e)
REDUCE: e*e
REDUCE: e
Correct expression!

> java -ea ProgX "2+"
  PUSH: D
REDUCE: e
  PUSH: e+
Bad expression!

> java -ea ProgX "(3*(2+4)+5))"
  PUSH: (
  PUSH: (D
REDUCE: (e
  PUSH: (e*
  PUSH: (e*(
  PUSH: (e*(D
REDUCE: (e*(e
  PUSH: (e*(e+
  PUSH: (e*(e+D
REDUCE: (e*(e+e
REDUCE: (e*(e
  PUSH: (e*(e)
REDUCE: (e*e
REDUCE: (e
  PUSH: (e+
  PUSH: (e+D
REDUCE: (e+e
REDUCE: (e
  PUSH: (e)
REDUCE: e
  PUSH: e)
Bad expression!

> java -ea ProgX "2+4*(4++5)"
  PUSH: D
REDUCE: e
  PUSH: e+
  PUSH: e+D
REDUCE: e+e
REDUCE: e
  PUSH: e*
  PUSH: e*(
  PUSH: e*(D
REDUCE: e*(e
  PUSH: e*(e+
  PUSH: e*(e++
  PUSH: e*(e++D
REDUCE: e*(e++e
  PUSH: e*(e++e)
Bad expression!

*/
