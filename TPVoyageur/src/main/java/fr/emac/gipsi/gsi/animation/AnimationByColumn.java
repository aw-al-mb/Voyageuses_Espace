/**
 * 
 */
package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

/**
 * @author truptil
 *
 */
public class AnimationByColumn extends AbstractAnimation{
 
	/**
	 *  Animation colonne par colonne 
	 */
	public AnimationByColumn() {
		
	}

	@Override
	public void runAnimation() {
		showScreen(ecranDeb); //ecran du début
		ecranInt=copyScreen(ecranDeb); 
		// pour chaque pixel de cette colonne de l'image du début on les remplace par les pixels de l'image de fin
		for(int col=0;col<ecranInt.getColMax()+1;col++){ 
			System.out.println("startSend");
			this.showScreen(ecranInt);
			for(int lig=0;lig<ecranInt.getLigMax()+1;lig++){
				ecranInt.updateColorByXY(lig, col, ecranFin.getColorByXY(lig,col));
			}
			this.wait(400); //on ajoute un petit délais entre chaque changement de colonne
			
		}
		this.showScreen(ecranInt); // on affiche le nouvel ecran
		
	}

	

}
