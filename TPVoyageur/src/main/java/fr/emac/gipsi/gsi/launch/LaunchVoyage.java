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
		p1.getPos().setX(2);
		p1.getPos().setY(2);
		
		/* On l'ajoute à la liste des planetes */
		listPlanete.add(p1);
		
		
		/* On crée une planete p2 */
		Planete p2 = new Planete();
		p2.setColorName("DeepPink");
		p2.setImage(ListScreen.second());
		p2.setEchantillonRoche(ListScreen.ArcCiel());
		p2.setEchantillonSol(ListScreen.second());
		p2.getPos().setX(6);
		p2.getPos().setY(2);
		p2.getListAccessibilite().add(p1);
		p2.getListVisibilite().add(p1);
		
		p1.getListAccessibilite().add(p2);
		p1.getListVisibilite().add(p2);
		
		/* On l'ajoute à la liste des planetes */
		listPlanete.add(p2);
		
		
		Planete plage = new Planete();
		plage.setColorName("Red");
		plage.setImage(ListScreen.Plage());
		plage.setEchantillonSol(ListScreen.Champi());
		plage.getPos().setX(3);
		plage.getPos().setY(3);
		plage.getListAccessibilite().add(p2);
		plage.getListVisibilite().add(p2);
		
		p2.getListAccessibilite().add(plage);
		p2.getListVisibilite().add(plage);

		listPlanete.add(plage);
		
		
		Planete pokemon = new Planete();
		pokemon.setColorName("White");
		pokemon.setImage(ListScreen.Pokeball());
		pokemon.setEchantillonRoche(ListScreen.Plage());
		pokemon.setEchantillonSol(ListScreen.Pokeball());
		pokemon.getPos().setX(8);
		pokemon.getPos().setY(7);
		pokemon.getListAccessibilite().add(plage);
		pokemon.getListVisibilite().add(plage);
		
		pokemon.getListVisibilite().add(p2);
		
		plage.getListAccessibilite().add(pokemon);
		plage.getListVisibilite().add(pokemon);
		
		p2.getListVisibilite().add(pokemon);

		
		listPlanete.add(pokemon);
		
		
		Planete colore = new Planete();
		colore.setColorName("AliceBlue");
		colore.setImage(ListScreen.Couleurs());
		colore.setEchantillonRoche(ListScreen.Tetris());
		colore.setEchantillonSol(ListScreen.Couleurs());
		colore.getPos().setX(3);
		colore.getPos().setY(6);
		colore.getListAccessibilite().add(pokemon);
		colore.getListVisibilite().add(pokemon);
		colore.getListAccessibilite().add(plage);
		colore.getListVisibilite().add(plage);
		
		colore.getListVisibilite().add(p2);

		pokemon.getListAccessibilite().add(colore);
		pokemon.getListVisibilite().add(colore);
		plage.getListAccessibilite().add(colore);
		plage.getListVisibilite().add(colore);
		
		p2.getListVisibilite().add(colore);
		
		listPlanete.add(colore);
		
		
		Planete rainbow = new Planete();
		rainbow.setColorName("Linen");
		rainbow.setImage(ListScreen.ArcCiel());
		rainbow.setEchantillonRoche(ListScreen.NyanCat());
		rainbow.setEchantillonSol(ListScreen.Smiley());
		rainbow.getPos().setX(7);
		rainbow.getPos().setY(5);
		rainbow.getListAccessibilite().add(pokemon);
		rainbow.getListVisibilite().add(pokemon);
		rainbow.getListAccessibilite().add(colore);
		rainbow.getListVisibilite().add(colore);
		
		rainbow.getListVisibilite().add(plage);
		
		pokemon.getListAccessibilite().add(rainbow);
		pokemon.getListVisibilite().add(rainbow);
		colore.getListAccessibilite().add(rainbow);
		colore.getListVisibilite().add(rainbow);

		plage.getListVisibilite().add(rainbow);
		
		listPlanete.add(rainbow);
		
		
		for(Planete p : listPlanete){
			p.setRayon(0);
		}
		
		 
		/*On crée un nouveau voyageur */
		AbstractVoyageur simulatedVoyageur = new VoyageurSimuler();
		
		simulatedVoyageur.getPosTete().setX(listPlanete.get(0).getPos().getX());
		simulatedVoyageur.getPosTete().setY(listPlanete.get(0).getPos().getY()+1);
		simulatedVoyageur.getPosBody().setX(listPlanete.get(0).getPos().getX());
		simulatedVoyageur.getPosBody().setY(listPlanete.get(0).getPos().getY()); // la tete regarde vers la droite
		simulatedVoyageur.setDirection("E");
		
		
		/*On crée un nouveau voyage avec la liste des planetes et le voyageur*/
		Voyage voyage = new Voyage(listPlanete, simulatedVoyageur);
		
		/* On simule le voyage */
		voyage.lancementSimuler();
	}
}