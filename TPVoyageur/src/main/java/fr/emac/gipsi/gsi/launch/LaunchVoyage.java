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
		// Planete gazeuse
		Planete p1 = new Planete();
		p1.setColorName("DarkSalmon");
		p1.setImage(ListScreen.first());
		p1.getPos().setX(5);
		p1.getPos().setY(2);
		
		/* On l'ajoute à la liste des planetes */
		listPlanete.add(p1);
		
		
		/* On crée une planete vacances */
		Planete vacances = new Planete();
		vacances.setColorName("Aqua");
		vacances.setImage(ListScreen.Plage());
		vacances.setEchantillonRoche(ListScreen.water());
		vacances.getPos().setX(6);
		vacances.getPos().setY(2);
		vacances.getListAccessibilite().add(p1);
		vacances.getListVisibilite().add(p1);
		
		p1.getListAccessibilite().add(vacances);
		p1.getListVisibilite().add(vacances);
		
		/* On l'ajoute à la liste des planetes */
		listPlanete.add(vacances);
		
		
		Planete ciel = new Planete();
		ciel.setColorName("SkyBlue");
		ciel.setImage(ListScreen.Sun());
		ciel.setEchantillonSol(ListScreen.ArcCiel());
		ciel.getPos().setX(3);
		ciel.getPos().setY(3);
		ciel.getListAccessibilite().add(p1);
		ciel.getListVisibilite().add(p1);
		
		p1.getListAccessibilite().add(ciel);
		p1.getListVisibilite().add(ciel);

		listPlanete.add(ciel);
		
		
		Planete pokemon = new Planete();
		pokemon.setColorName("Red");
		pokemon.setImage(ListScreen.Pokeball());
		pokemon.setEchantillonSol(ListScreen.pikachu());
		pokemon.getPos().setX(8);
		pokemon.getPos().setY(7);
				
		vacances.getListVisibilite().add(pokemon);
		
		listPlanete.add(pokemon);
		
		
		// Planete gazeuse
		Planete random = new Planete();
		random.setColorName("AliceBlue");
		random.setImage(ListScreen.Couleurs());
		random.getPos().setX(3);
		random.getPos().setY(6);
		random.getListAccessibilite().add(ciel);
		random.getListVisibilite().add(ciel);

		ciel.getListAccessibilite().add(random);
		ciel.getListVisibilite().add(random);
		
		listPlanete.add(random);
		
		
		Planete spaceInv = new Planete();
		spaceInv.setColorName("Chartreuse");
		spaceInv.setImage(ListScreen.SpaceInvVert());
		spaceInv.setEchantillonSol(ListScreen.SpaceInvBleu());
		spaceInv.getPos().setX(7);
		spaceInv.getPos().setY(5);
		spaceInv.getListAccessibilite().add(pokemon);
		spaceInv.getListVisibilite().add(pokemon);
		spaceInv.getListAccessibilite().add(vacances);
		spaceInv.getListVisibilite().add(vacances);
		
		pokemon.getListAccessibilite().add(spaceInv);
		pokemon.getListVisibilite().add(spaceInv);
		vacances.getListAccessibilite().add(spaceInv);
		vacances.getListVisibilite().add(spaceInv);
		
		listPlanete.add(spaceInv);
		
		Planete retro = new Planete();
		retro.setColorName("Gold");
		retro.setImage(ListScreen.Tetris());
		retro.setEchantillonRoche(ListScreen.tetris2());
		retro.getPos().setX(8);
		retro.getPos().setY(2);
		retro.getListAccessibilite().add(pokemon);
		retro.getListVisibilite().add(pokemon);
		retro.getListAccessibilite().add(vacances);
		retro.getListVisibilite().add(vacances);
		retro.getListAccessibilite().add(spaceInv);
		retro.getListVisibilite().add(spaceInv);
		
		pokemon.getListAccessibilite().add(retro);
		pokemon.getListVisibilite().add(retro);
		spaceInv.getListAccessibilite().add(retro);
		spaceInv.getListVisibilite().add(retro);
		vacances.getListAccessibilite().add(retro);
		vacances.getListVisibilite().add(retro);
		
		listPlanete.add(retro);
		
		Planete Mario = new Planete();
		Mario.setColorName("MediumBlue");
		Mario.setImage(ListScreen.boite());
		Mario.setEchantillonRoche(ListScreen.mario());
		Mario.setEchantillonSol(ListScreen.Champi());
		Mario.getPos().setX(5);
		Mario.getPos().setY(11);
		
		Mario.getListVisibilite().add(p1);
		p1.getListVisibilite().add(Mario);
		
		listPlanete.add(Mario);
		
		
		Planete Lol = new Planete();
		Lol.setColorName("OrangeRed");
		Lol.setImage(ListScreen.NyanCat());
		Lol.setEchantillonSol(ListScreen.Smiley());
		Lol.getPos().setX(8);
		Lol.getPos().setY(8);
		
		Lol.getListAccessibilite().add(pokemon);
		Lol.getListVisibilite().add(pokemon);
		Lol.getListAccessibilite().add(Mario);
		Lol.getListVisibilite().add(Mario);
		
		pokemon.getListAccessibilite().add(Lol);
		pokemon.getListVisibilite().add(Lol);
		Mario.getListAccessibilite().add(Lol);
		Mario.getListVisibilite().add(Lol);
		
		listPlanete.add(Lol);
		
		
		Planete banquise = new Planete();
		banquise.setColorName("PaleTurquoise");
		banquise.setImage(ListScreen.pinguoin());
		banquise.setEchantillonRoche(ListScreen.flocon());
		banquise.getPos().setX(3);
		banquise.getPos().setY(12);
		
		banquise.getListAccessibilite().add(random);
		banquise.getListVisibilite().add(random);
		banquise.getListAccessibilite().add(spaceInv);
		banquise.getListVisibilite().add(spaceInv);
		banquise.getListAccessibilite().add(Mario);
		banquise.getListVisibilite().add(Mario);
		
		random.getListAccessibilite().add(banquise);
		random.getListVisibilite().add(banquise);
		spaceInv.getListAccessibilite().add(banquise);
		spaceInv.getListVisibilite().add(banquise);
		Mario.getListAccessibilite().add(banquise);
		Mario.getListVisibilite().add(banquise);
		
		listPlanete.add(banquise);
		
		
		Planete noel = new Planete();
		noel.setColorName("Green");
		noel.setImage(ListScreen.sapin());
		noel.setEchantillonRoche(ListScreen.kdo());
		noel.setEchantillonSol(ListScreen.flocon());
		noel.getPos().setX(1);
		noel.getPos().setY(4);
		
		noel.getListAccessibilite().add(ciel);
		noel.getListVisibilite().add(ciel);
		
		ciel.getListAccessibilite().add(noel);
		ciel.getListVisibilite().add(noel);
		
		listPlanete.add(noel);
		
		
		for(Planete p : listPlanete){
			p.setRayon(0);
		}
		
		
		/*On crée un nouveau voyageur */
		AbstractVoyageur simulatedVoyageur = new VoyageurSimuler();
		
		/*On crée un nouveau voyage avec la liste des planetes et le voyageur*/
		Voyage voyage = new Voyage(listPlanete, simulatedVoyageur);

		/* On simule le voyage */
		voyage.lancementSimuler();

	}
}