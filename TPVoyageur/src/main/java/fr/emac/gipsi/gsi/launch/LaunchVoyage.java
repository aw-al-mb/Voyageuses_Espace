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
		/*p1.setEchantillonSol(ListScreen.second());*/
		p1.getPos().setX(2);
		p1.getPos().setY(2);
		
		/* On l'ajoute à la liste des planetes */
		listPlanete.add(p1);
		
		
		/* On crée une planete vacances */
		Planete vacances = new Planete();
		vacances.setColorName("Aqua");
		vacances.setImage(ListScreen.Plage());
		vacances.setEchantillonRoche(ListScreen.water());
		vacances.setEchantillonSol(ListScreen.Plage());
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
		ciel.getListAccessibilite().add(vacances);
		ciel.getListVisibilite().add(vacances);
		
		vacances.getListAccessibilite().add(ciel);
		vacances.getListVisibilite().add(ciel);

		listPlanete.add(ciel);
		
		
		Planete pokemon = new Planete();
		pokemon.setColorName("Red");
		pokemon.setImage(ListScreen.Pokeball());
		pokemon.setEchantillonRoche(ListScreen.Pokeball());
		pokemon.setEchantillonSol(ListScreen.pikachu());
		pokemon.getPos().setX(8);
		pokemon.getPos().setY(7);
		pokemon.getListAccessibilite().add(ciel);
		pokemon.getListVisibilite().add(ciel);
		
		pokemon.getListVisibilite().add(vacances);
		
		ciel.getListAccessibilite().add(pokemon);
		ciel.getListVisibilite().add(pokemon);
		
		vacances.getListVisibilite().add(pokemon);

		
		listPlanete.add(pokemon);
		
		
		Planete random = new Planete();
		random.setColorName("AliceBlue");
		random.setImage(ListScreen.Couleurs());
		/*random.setEchantillonRoche(ListScreen.Couleurs());
		random.setEchantillonSol(ListScreen.Smiley());*/
		random.getPos().setX(3);
		random.getPos().setY(6);
		random.getListAccessibilite().add(pokemon);
		random.getListVisibilite().add(pokemon);
		random.getListAccessibilite().add(ciel);
		random.getListVisibilite().add(ciel);
		
		random.getListVisibilite().add(vacances);

		pokemon.getListAccessibilite().add(random);
		pokemon.getListVisibilite().add(random);
		ciel.getListAccessibilite().add(random);
		ciel.getListVisibilite().add(random);
		
		vacances.getListVisibilite().add(random);
		
		listPlanete.add(random);
		
		
		Planete spaceInv = new Planete();
		spaceInv.setColorName("Chartreuse");
		spaceInv.setImage(ListScreen.SpaceInvVert());
		spaceInv.setEchantillonRoche(ListScreen.SpaceInvVert());
		spaceInv.setEchantillonSol(ListScreen.SpaceInvBleu());
		spaceInv.getPos().setX(7);
		spaceInv.getPos().setY(5);
		spaceInv.getListAccessibilite().add(pokemon);
		spaceInv.getListVisibilite().add(pokemon);
		spaceInv.getListAccessibilite().add(random);
		spaceInv.getListVisibilite().add(random);
		
		spaceInv.getListVisibilite().add(ciel);
		pokemon.getListAccessibilite().add(spaceInv);
		pokemon.getListVisibilite().add(spaceInv);
		random.getListAccessibilite().add(spaceInv);
		random.getListVisibilite().add(spaceInv);

		ciel.getListVisibilite().add(spaceInv);
		
		listPlanete.add(spaceInv);
		
		Planete retro = new Planete();
		retro.setColorName("Gold");
		retro.setImage(ListScreen.Tetris());
		retro.setEchantillonRoche(ListScreen.Tetris());
		retro.setEchantillonSol(ListScreen.tetris2());
		retro.getPos().setX(8);
		retro.getPos().setY(2);
		retro.getListAccessibilite().add(pokemon);
		retro.getListVisibilite().add(pokemon);
		retro.getListAccessibilite().add(random);
		retro.getListVisibilite().add(random);
		retro.getListAccessibilite().add(vacances);
		retro.getListVisibilite().add(vacances);
		retro.getListVisibilite().add(spaceInv);
		
		pokemon.getListAccessibilite().add(retro);
		pokemon.getListVisibilite().add(retro);
		random.getListAccessibilite().add(retro);
		random.getListVisibilite().add(retro);
		vacances.getListAccessibilite().add(retro);
		vacances.getListVisibilite().add(retro);
		spaceInv.getListVisibilite().add(retro);
		
		listPlanete.add(retro);
		
		Planete Mario = new Planete();
		Mario.setColorName("MediumBlue");
		Mario.setImage(ListScreen.boite());
		Mario.setEchantillonRoche(ListScreen.boite());
		Mario.setEchantillonSol(ListScreen.Champi());
		Mario.getPos().setX(5);
		Mario.getPos().setY(11);
		
		Mario.getListAccessibilite().add(pokemon);
		Mario.getListVisibilite().add(pokemon);
		Mario.getListAccessibilite().add(retro);
		Mario.getListVisibilite().add(retro);
		Mario.getListAccessibilite().add(ciel);
		Mario.getListVisibilite().add(ciel);
		Mario.getListVisibilite().add(p1);
		
		pokemon.getListAccessibilite().add(Mario);
		pokemon.getListVisibilite().add(Mario);
		retro.getListAccessibilite().add(Mario);
		retro.getListVisibilite().add(Mario);
		ciel.getListAccessibilite().add(Mario);
		ciel.getListVisibilite().add(Mario);

		p1.getListVisibilite().add(Mario);
		listPlanete.add(Mario);
		
		
		Planete Lol = new Planete();
		Lol.setColorName("OrangeRed");
		Lol.setImage(ListScreen.NyanCat());
		Lol.setEchantillonRoche(ListScreen.NyanCat());
		Lol.setEchantillonSol(ListScreen.Smiley());
		Lol.getPos().setX(8);
		Lol.getPos().setY(8);
		
		Lol.getListAccessibilite().add(vacances);
		Lol.getListVisibilite().add(vacances);
		Lol.getListAccessibilite().add(ciel);
		Lol.getListVisibilite().add(ciel);
		Lol.getListVisibilite().add(pokemon);
		
		vacances.getListAccessibilite().add(Lol);
		vacances.getListVisibilite().add(Lol);
		ciel.getListAccessibilite().add(Lol);
		ciel.getListVisibilite().add(Lol);

		pokemon.getListVisibilite().add(Lol);
		listPlanete.add(Lol);
		
		
		Planete banquise = new Planete();
		banquise.setColorName("PaleTurquoise");
		banquise.setImage(ListScreen.pinguoin());
		banquise.setEchantillonRoche(ListScreen.flocon());
		banquise.setEchantillonSol(ListScreen.pinguoin());
		banquise.getPos().setX(4);
		banquise.getPos().setY(12);
		
		banquise.getListAccessibilite().add(retro);
		banquise.getListVisibilite().add(retro);
		banquise.getListAccessibilite().add(pokemon);
		banquise.getListVisibilite().add(pokemon);
		banquise.getListAccessibilite().add(Lol);
		banquise.getListVisibilite().add(Lol);
		
		banquise.getListVisibilite().add(random);
		
		retro.getListAccessibilite().add(banquise);
		retro.getListVisibilite().add(banquise);
		pokemon.getListAccessibilite().add(banquise);
		pokemon.getListVisibilite().add(banquise);
		Lol.getListAccessibilite().add(banquise);
		Lol.getListVisibilite().add(banquise);
		
		random.getListVisibilite().add(banquise);
		
		listPlanete.add(banquise);
		
		
		Planete noel = new Planete();
		noel.setColorName("Green");
		noel.setImage(ListScreen.sapin());
		noel.setEchantillonRoche(ListScreen.kdo());
		noel.setEchantillonSol(ListScreen.sapin());
		noel.getPos().setX(1);
		noel.getPos().setY(4);
		
		noel.getListAccessibilite().add(vacances);
		noel.getListVisibilite().add(vacances);
		noel.getListAccessibilite().add(pokemon);
		noel.getListVisibilite().add(pokemon);
		noel.getListAccessibilite().add(p1);
		noel.getListVisibilite().add(p1);
		
		noel.getListVisibilite().add(ciel);
		
		vacances.getListAccessibilite().add(noel);
		vacances.getListVisibilite().add(noel);
		pokemon.getListAccessibilite().add(noel);
		pokemon.getListVisibilite().add(noel);
		p1.getListAccessibilite().add(noel);
		p1.getListVisibilite().add(noel);
		
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