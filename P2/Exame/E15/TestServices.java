/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;


import static java.lang.System.*;

public class TestServices
{
   public static void main(String[] args) {

      String [] names = { "A", "B", "C" };

      ServiceManager sm = new ServiceManager(names,10);

        // descomentar para testar
          // acrescentar novos testes se necess�rio
      sm.queueFor("pedro","A");
      sm.queueFor("pedro","B");
      sm.queueFor("joao","B");
      sm.queueFor("maria","C");
      sm.queueFor("ana","A");
      sm.serveNext("A");
      sm.serveNext("B");
      sm.serveNext("C");
      sm.endService("A",17);
      sm.endService("B",10);
      sm.endService("C",8);

      if (sm.clientPending("A")) 
         out.println("Cliente pendente no servi�o A");
      if (sm.clientPending("B")) 
         out.println("Cliente pendente no servi�o B");
      if (sm.clientPending("C")) 
         out.println("Cliente pendente no servi�o C");
      
      out.println("Tempo m�ximo de servi�o: "+sm.maxServiceTime());

      if (sm.validServiceNameRec("D")) out.println("Nome de servi�o v�lido: D");
      else out.println("Nome de servi�o inv�lido: D");

      sm.queueFor("luis","A");
      sm.queueFor("tomas","A");
      sm.queueFor("marta","A");
      sm.queueFor("antonia","A");
      String [] a = sm.alphabeticalClientList("A");
      out.print("Lista alfabetica dos clientes na fila do servi�o A: ");
      for(int i=0; i<a.length; i++) out. print(a[i]+" ");
      out.println();

   }
 
}
