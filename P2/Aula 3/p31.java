package p2;

import static java.lang.System.*;

public class p31
{
   public static void main(String[] args)
   {
      Data2[] datas = new Data2[args.length / 3]; // argumentos em grupos de três
      for(int i = 0; i < datas.length; i++)
      {
         int dia = Integer.parseInt(args[i*3]);
         int mes = Integer.parseInt(args[i*3+1]);
         int ano = Integer.parseInt(args[i*3+2]);
         datas[i] = new Data2(dia, mes, ano);
      }

      boolean ordenado = true;
      for(int i = 1; ordenado && i < datas.length; i++)
         ordenado = datas[i].igualA(datas[i-1]) || datas[i].maiorDoQue(datas[i-1]);
      if (!ordenado)
         sort(datas);

      for(int i = 0; i < datas.length; i++)
         out.printf("%02d - %02d-%02d-%04d\n", (i+1), datas[i].getday(), datas[i].getmonth(), datas[i].getyear());
   }

   static void sort(Data2[] datas)
   {
      for(int i = 0; i < datas.length; i++)
         for(int j = i+1; j < datas.length; j++)
           if (datas[j].menorDoQue(datas[i]))
           {
              Data2 tmp = datas[j];
              datas[j] = datas[i];
              datas[i] = tmp;
           }
   }
}