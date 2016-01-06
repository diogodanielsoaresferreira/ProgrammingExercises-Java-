/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package reflection.plugins;

import reflection.IPlugin;

public class ExemploPlugin2 implements IPlugin {

	@Override
	public void fazQualQuerCoisa() {
		System.out.println("Teste 2");
	}

}
