/**
 * 
 */
package fr.emac.gipsi.gsi.launch;

import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationByColumn;
import fr.emac.gipsi.gsi.animation.AnimationFlash;
import fr.emac.gipsi.gsi.animation.AnimationLigne;
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
		
		AbstractAnimation aa = new AnimationByColumn();
		aa.setEcranDeb(ListScreen.first());
		aa.setEcranFin(ListScreen.second());
		
		aa.runAnimation();

		aa.wait(1000);
		
		AbstractAnimation ab = new AnimationLigne();
		ab.setEcranDeb(ListScreen.second());
		ab.setEcranFin(ListScreen.Plage());

		ab.runAnimation();
		
		ab.wait(1000);
		
		AbstractAnimation ac = new AnimationByColumn();
		ac.setEcranDeb(ListScreen.Plage());
		ac.setEcranFin(ListScreen.Pokeball());

		ac.runAnimation();
		
		ac.wait(1000);
		
		AbstractAnimation ad = new AnimationLigne();
		ad.setEcranDeb(ListScreen.Pokeball());
		ad.setEcranFin(ListScreen.Plage());

		ad.runAnimation();

	}

}
