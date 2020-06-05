/**
 * 
 */
package fr.emac.gipsi.gsi.launch;

import java.util.ArrayList;

import fr.emac.gipsi.gsi.ecran.ListScreen;
import fr.emac.gipsi.gsi.voyage.Planete;
import fr.emac.gipsi.gsi.voyage.Voyage;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;
import fr.emac.gipsi.gsi.voyageur.VoyageurSimuler;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class LaunchVoyage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Planete> listPlanete = new ArrayList<>();
		
		/* On crée une planete p1 */
		Planete p1 = new Planete();
		p1.setColorName("DarkSalmon");
		p1.setImage(ListScreen.first());
		p1.setEchantillonRoche(ListScreen.second());
		p1.setEchantillonSol(ListScreen.first());
		p1.setRayon(1);
		p1.getPos().setX(2);
		p1.getPos().setY(2);
		
		/* On l'ajoute à la liste des planetes */
		listPlanete.add(p1);
		
		/* On crée une planete p1 */
		Planete p2 = new Planete();
		p2.setColorName("DeepPink");
		p2.setImage(ListScreen.first());
		p2.setEchantillonRoche(ListScreen.second());
		p2.setEchantillonSol(ListScreen.first());
		p2.setRayon(1);
		p2.getPos().setX(5);
		p2.getPos().setY(5);
		p2.getListAccessibilite().add(p1);
		
		/* On l'ajoute à la liste des planetes */
		listPlanete.add(p2);
		
		Planete plage = new Planete();
		plage.setColorName("Red");
		plage.setImage(ListScreen.Plage());
		plage.setEchantillonRoche(ListScreen.Plage());
		plage.setEchantillonSol(ListScreen.Plage());
		plage.setRayon(2);
		plage.getPos().setX(5);
		plage.getPos().setY(5);
		plage.getListAccessibilite().add(p1);
		plage.getListAccessibilite().add(p2);
		
		listPlanete.add(plage);
		
		Planete pokemon = new Planete();
		pokemon.setColorName("White");
		pokemon.setImage(ListScreen.poke());
		pokemon.setEchantillonRoche(ListScreen.poke());
		pokemon.setEchantillonSol(ListScreen.poke());
		pokemon.setRayon(1);
		pokemon.getPos().setX(5);
		pokemon.getPos().setY(5);
		pokemon.getListAccessibilite().add(plage);
		pokemon.getListAccessibilite().add(p1);
		
		listPlanete.add(pokemon);
		

		
		/*On crée un nouveau voyageur */
		AbstractVoyageur simulatedVoyageur = new VoyageurSimuler();
		
		simulatedVoyageur.getPosTete().setX(listPlanete.get(0).getPos().getX());
		simulatedVoyageur.getPosTete().setY(listPlanete.get(0).getPos().getY());
		simulatedVoyageur.getPosBody().setX(listPlanete.get(0).getPos().getX());
		simulatedVoyageur.getPosBody().setY(listPlanete.get(0).getPos().getY()-1); // la tete regarde vers la gauche
		simulatedVoyageur.setDirection("E");
		
		/*On crée un nouveau voyage avec la liste des planetes et le voyageur*/
		Voyage voyage = new Voyage(listPlanete, simulatedVoyageur);
		
		/* On simule le voyage */
		voyage.lancementSimuler();
	}

}













