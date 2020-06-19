/**
 * 
 */
package fr.emac.gipsi.gsi.launch;

import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationByColumn;
import fr.emac.gipsi.gsi.animation.AnimationCross;
import fr.emac.gipsi.gsi.animation.AnimationFlash;
import fr.emac.gipsi.gsi.animation.AnimationGoutte;
import fr.emac.gipsi.gsi.animation.AnimationLigne;
import fr.emac.gipsi.gsi.animation.AnimationNyanCat;
import fr.emac.gipsi.gsi.animation.AnimationRandomPop;
import fr.emac.gipsi.gsi.animation.AnimationSpirale;
import fr.emac.gipsi.gsi.ecran.ListScreen;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class LaunchAnimation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AbstractAnimation aa = new AnimationGoutte();
		aa.setEcranDeb(ListScreen.first());
		aa.setEcranFin(ListScreen.Couleurs());
		
		aa.runAnimation();

		aa.wait(1000);
		
		AbstractAnimation ab = new AnimationRandomPop();
		ab.setEcranDeb(ListScreen.Couleurs());
		ab.setEcranFin(ListScreen.Plage());

		ab.runAnimation();
		
		ab.wait(1000);
		
		AbstractAnimation ac = new AnimationCross();
		ac.setEcranDeb(ListScreen.Plage());
		ac.setEcranFin(ListScreen.Pokeball());

		ac.runAnimation();
		
		ac.wait(1000);
		
		AbstractAnimation ad = new AnimationSpirale();
		ad.setEcranDeb(ListScreen.Pokeball());
		ad.setEcranFin(ListScreen.second());
		
		ad.runAnimation();
		
		ad.wait(1000);
		
		AbstractAnimation ae = new AnimationLigne();
		ae.setEcranDeb(ListScreen.second());
		ae.setEcranFin(ListScreen.ArcCiel());

		ae.runAnimation();
		
		ae.wait(1000);
		
		AbstractAnimation af = new AnimationNyanCat();
		af.setEcranFin(ListScreen.NyanCat());
		af.runAnimation();
		

	}

}
