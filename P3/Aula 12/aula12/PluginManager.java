/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula12;


abstract class PluginManager {
	public static LoadSaveFile load(String name) throws Exception {
		Class<?> c = Class.forName(name);
		return (LoadSaveFile) c.newInstance();
	}
}
