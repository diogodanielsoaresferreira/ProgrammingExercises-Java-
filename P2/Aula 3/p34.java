package p2;

import static java.lang.System.*;

public class p34
{
   public static void main(String[] args)
   {
      Agenda agenda = new Agenda();
  

      agenda.novaNota(new Data2(14,6,2012), new Data2(27,6,2012), "Prog2: APF");
      agenda.novaNota(new Data2(2,7,2012), new Data2(13,7,2012), "Prog2: Recurso");
      agenda.novaNota(new Data2(6,6,2012), new Data2(6,6,2012), "Prog2: ACITP2");
      agenda.novaNota(new Data2(9,5,2012), new Data2(9,5,2012), "Prog2: AIP");
      agenda.novaNota(new Data2(22,3,2012), new Data2(27,3,2012), "Prog2: ACITP1");
      agenda.escreve();
      
      out.println();
      
      Data2 d1 = new Data2(27,3,2012);
      Data2 d2 = new Data2(15,6,2012);
      
      Nota[] todo = agenda.compromissos(d1, d2);
      
      out.print("Compromissos de ");
      out.print(d1.escreve());
      
      out.print(" a ");
      out.print(d2.escreve());
      
      out.println(":");
      
      for(int i = 0; i < todo.length; i++)
         out.println(todo[i].escreve());
   }
}

