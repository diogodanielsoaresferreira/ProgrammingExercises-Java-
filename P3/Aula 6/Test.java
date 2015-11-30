/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula6;

public class Test {
	public static void main(String[] args) {
		Ementa ementa = new Ementa("Especial Caloiro");
		
		Prato[] pratos = new Prato[10];
		
		for (int i=0; i < pratos.length; i++){
			//pratos[i] = new PratoVegetariano("Prato N." + i + " (Vegetariano)");
			//pratos[i] = new PratoDieta("Prato N." + i + " (Dieta)", 90.8);
			pratos[i] = randPrato(i);
			int cnt = 0;
		
			while (cnt <2){ // Adicionar 2 Ingredientes a cada Prato
				Alimento aux = randAlimento();
				if (pratos[i].addAl(aux))
					cnt++;
				else
					System.out.println("ERRO: Não é possivel adicionar '" +aux + "' ao -> " + pratos[i]);
			}
		
			ementa.addPrato(pratos[i], randDia()); // Dia Aleatório
		}
		
		System.out.println("\n" + ementa);
	}
	
	// Retorna um Alimento Aleatoriamente
	public static Alimento randAlimento() {
		switch ((int) (Math.random() * 4)) {
			default:
			case 0:
				return new Carne(Carne.VariedadeCarne.frango, 22.3, 345.3, 300);
			case 1:
				return new Peixe(Peixe.TipoPeixe.congelado, 31.3, 25.3, 200);
			case 2:
				return new Legume("Couve Flor", 21.3, 22.4, 150);
			case 3:
				return new Cereal("Milho", 19.3, 32.4, 110);
		}
	}
	// Retorna um Tipo de Prato Aleatoriamente
	public static Prato randPrato(int i) {
		switch ((int) (Math.random() * 3)) {
			default:
			case 0:
				return new Prato("Prato N." + i);
			case 1:
				return new PratoVegetariano("Prato N." + i + " (Vegetariano)");
			case 2:
				return new PratoDieta("Prato N." + i + " (Dieta)", 90.8);
		}
	}
	
	public static Ementa.DiaSemana randDia(){
		switch ((int) (Math.random() * 7)) {
		default:
		case 0:
			return Ementa.DiaSemana.Segunda;
		case 1:
			return Ementa.DiaSemana.Terca;
		case 2:
			return Ementa.DiaSemana.Quarta;
		case 3:
			return Ementa.DiaSemana.Quinta;
		case 4:
			return Ementa.DiaSemana.Sexta;
		case 5:
			return Ementa.DiaSemana.Sabado;
		case 6:
			return Ementa.DiaSemana.Domingo;
		}
	}
}
