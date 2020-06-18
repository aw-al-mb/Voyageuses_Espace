/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.animation.AnimationCross;
import fr.emac.gipsi.gsi.animation.AnimationGoutte;
import fr.emac.gipsi.gsi.animation.AnimationSpirale;
import fr.emac.gipsi.gsi.ecran.ListScreen;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;
import fr.emac.gipsi.gsi.voyageur.VoyageurSimuler;

import java.util.ArrayList;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class Voyage extends AbstractVoyage {

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur) {
        super(listPlanete, simulatedVoyageur);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     * @param realVoyager
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur, AbstractVoyageur realVoyager) {
        super(listPlanete, simulatedVoyageur, realVoyager);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showFromPlanete(fr.emac.gipsi.gsi.voyage.Planete)
     */
    @Override
    public int showFromPlanete(Planete p) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showAll()
     */
    @Override
    public int showAll() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotage()
     */
    @Override
    public void lancement() {
        // TODO Auto-generated method stub

    }

    /* Prend les photos et échantillons lors de l'arrivée sur une nouvelle planète */
    public void arriveeSurPlanete(AbstractVoyageur voyageur, Planete arrivee, AnimationGoutte animPhoto, AnimationCross animRoche, AnimationSpirale animSol) {
    	/* On vérifie que c'est la première fois qu'on passe par cette planète */
    	if (!voyageur.getAlreadyVisit().contains(arrivee)){
    		/* Prendre la photo de la planète */
    		voyageur.takePicture(arrivee);
    		
    		animPhoto.setEcranFin(arrivee.getImage());
    		animPhoto.runAnimation();
    		afficheEcran();
    		wait(1000);
    		animRoche.setEcranDeb(arrivee.getImage());
    		animSol.setEcranDeb(arrivee.getImage());
    		
    		if (arrivee.getEchantillonRoche() != null) {
    			/* Prendre un echantillon de sol si il y en a */
    			voyageur.takeEchantillonRoche(arrivee);
    			animRoche.setEcranFin(arrivee.getEchantillonRoche());
    			animRoche.runAnimation();
    			afficheEcran();
    			wait(1000);
    			animSol.setEcranDeb(arrivee.getEchantillonRoche());
    			animPhoto.setEcranDeb(arrivee.getEchantillonRoche());
    		}
    		
    		if (arrivee.getEchantillonSol() != null) {
    			/* prendre un echantillon de roche si il y en a */
    			voyageur.takeEchantillonSol(arrivee);    			
    			animSol.setEcranFin(arrivee.getEchantillonSol());
    			animSol.runAnimation();
    			afficheEcran();
    			wait(1000);
    			animPhoto.setEcranDeb(arrivee.getEchantillonSol());
    		}
    		voyageur.getAlreadyVisit().add(arrivee);
    	}
    }    

    /* tourne le robot pour qu'il fasse face à une planete visible
     * Les gazeuses visibles sont forcément sur la même ligne ou la même colone que le robot.*/
    public void faceAPlanete(AbstractVoyageur voyageur, Planete gazeuse) {
    	int diffX = gazeuse.getPos().getX() - voyageur.getPosBody().getX();
    	int diffY = gazeuse.getPos().getY() - voyageur.getPosBody().getY();
    	if (voyageur.getDirection()=="E") {
    		if (diffX == 0) {
    			if (diffY < 0) {
    				voyageur.turnRight();
    				afficheEcran();
    				wait(500);
        			voyageur.turnRight();
        			afficheEcran();
        			wait(500);
    			}
    		}
    		else if(diffX <0) {
    			voyageur.turnLeft();
				afficheEcran();
				wait(500);
    		}
    		else {
    			voyageur.turnRight();
				afficheEcran();
				wait(500);
    		}
    	}
    	else if (voyageur.getDirection()=="N") {
    		if (diffY == 0) {
    			if (diffX > 0) {
    				voyageur.turnRight();
    				afficheEcran();
    				wait(500);
        			voyageur.turnRight();
        			afficheEcran();
        			wait(500);
    			}
    		}
    		else if(diffY <0) {
    			voyageur.turnLeft();
				afficheEcran();
				wait(500);
    		}
    		else {
    			voyageur.turnRight();
				afficheEcran();
				wait(500);
    		}
    	}
    	else if (voyageur.getDirection()=="O") {
    		if (diffX == 0) {
    			if (diffY > 0) {
    				voyageur.turnRight();
    				afficheEcran();
    				wait(500);
        			voyageur.turnRight();
        			afficheEcran();
        			wait(500);
    			}
    		}
    		else if(diffX <0) {
    			voyageur.turnRight();
				afficheEcran();
				wait(500);
    		}
    		else {
    			voyageur.turnLeft();
				afficheEcran();
				wait(500);
    		}
    	}
    	else {
    		if (diffY == 0) {
    			if (diffX < 0) {
    				voyageur.turnRight();
    				afficheEcran();
    				wait(500);
        			voyageur.turnRight();
        			afficheEcran();
        			wait(500);
    			}
    		}
    		else if(diffY > 0) {
    			voyageur.turnLeft();
				afficheEcran();
				wait(500);
    		}
    		else {
    			voyageur.turnRight();
				afficheEcran();
				wait(500);
    		}
    	}
    }
    
    /* déplace le robot d'une planète de depart à une planete d'arrivee */
    public void deplacement(Planete depart, AbstractVoyageur voyageur, Planete arrivee) { 
    	int DiffX=arrivee.getPos().getX()-depart.getPos().getX(); /*distance départ-arrivée selon l’axe x*/
    	int DiffY=arrivee.getPos().getY()-depart.getPos().getY();/*distance départ-arrivée selon l’axe y*/
    	
    	if (voyageur.getDirection()=="E") { // le voyageur regarder vers la droite 
    		if (DiffY<0) { /*l’arrivée est à gauche de la position du voyageur : il est dos à l’arrivée */
    /* on gère d’abord les déplacements qui sont sur la même ligne que la direction du robot (soit vertical pour N et S, et horizontal pour O et E) afin d’éviter un quart de tour inutile */
    			for (int i=0; i<-DiffY; i++) {
    				voyageur.goBackward(); /*le voyageur recule autant de fois que de cases séparant départ et arrivée, soit DiffY*/
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		else if (DiffY>0) { /*l’arrivée est à droite de la position du voyageur : il est face à l’arrivée*/
    			for (int i=0; i<DiffY; i++) {
    				voyageur.goForward();/*le voyageur avance autant de fois que de cases séparant départ et arrivée*/
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		if (DiffX<0) { /*l’arrivée est en haut de la position du voyageur : l’arrivée est sur sa gauche */
    			voyageur.turnLeft (); /*le voyageur tourne à gauche*/
    			afficheEcran();
    			wait(700);
    			for (int i=0; i<-DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		else if (DiffX>0) { /*l’arrivée est en bas de la position du voyageur : l’arrivée est sur sa droite */
    			voyageur.turnRight();
    			afficheEcran();
    			wait(700);
    			for (int i=0; i<DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    	}
    	
    	else if (voyageur.getDirection()=="O") { /* levoyage regarde vers la gauche*/
    		if (DiffY<0) { /* il doit aller vers la gauche : il est face à l’arrivée*/
    			for (int i=0; i<-DiffY; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		else if (DiffY>0) { /*il doit aller à droite, il est dos à l’arrivée donc il recule*/
    			for (int i=0; i<DiffY; i++) {
    				voyageur.goBackward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		if (DiffX<0) { /*le voyageur doit aller vers le haut : l’arrivée est donc sur sa droite*/
    			voyageur.turnRight();
    			afficheEcran() ;
    			wait(700) ;
    			for (int i=0; i<-DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		else if (DiffX>0) { /*il doit aller vers le bas : l’arrivée est donc sur sa gauche*/
    			voyageur.turnLeft();
    			afficheEcran() ;
    			wait(700) ;
    			for (int i=0; i<DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    	}
    	
    	else if (voyageur.getDirection()=="N") { /* le voyageur est face au nord*/
    		if (DiffX<0) { /* il doit aller vers le haut : il doit juste avancer*/
    			for (int i=0; i<-DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ; 
    			}
    		}
    		else if (DiffX>0) { /* il doit aller vers le bas : il doit juste reculer*/
    			for (int i=0; i<DiffX; i++) {
    				voyageur.goBackward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		if (DiffY<0) { /* l’arrivée est sur la gauche : donc il doit tourner à gauche puis avancer*/
    			voyageur.turnLeft();
    			afficheEcran() ;
    			wait(700) ;	
    			for (int i=0; i<-DiffY; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		else if (DiffY>0) { /* l’arrivée est sur la droite : il doit tourner à droite puis avancer */
    			voyageur.turnRight();
    			afficheEcran() ;
    			wait(700) ;
    			for (int i=0; i<DiffY; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		
    	}
    	
    	else if (voyageur.getDirection()=="S") { /* le voyageur regarde vers le bas */
    		if (DiffX<0) { /* il doit aller vers le haut, donc reculer */
    			for (int i=0; i<-DiffX; i++) {
    				voyageur.goBackward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		else if (DiffX>0) { /* il doit aller vers le bas, donc avancer */
    			for (int i=0; i<DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		if (DiffY<0) { /*il doit aller vers la gauche, soit tourner à droite puis avancer */
    			voyageur.turnRight();
    			afficheEcran() ;
    			wait(700) ;
    			for (int i=0; i<-DiffY; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    		else if (DiffY>0) { /*il doit aller à droite, donc tourner sur sa gauche puis avancer */
    			voyageur.turnLeft();
    			afficheEcran() ;
    			wait(700) ;
    			for (int i=0; i<DiffY; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(500) ;
    			}
    		}
    	}
    }
    
    // La même que déplacement mais sans l'aspect graphique
    public void deplacementSansImages(Planete depart, Planete arrivee) { 
    	int DiffX=arrivee.getPos().getX()-depart.getPos().getX(); /*distance départ-arrivée selon l’axe x*/
    	int DiffY=arrivee.getPos().getY()-depart.getPos().getY();/*distance départ-arrivée selon l’axe y*/
    	
    	if (getSimulatedvoyageur().getDirection()=="E") { // le voyageur regarder vers la droite 
    		if (DiffY<0) { /*l’arrivée est à gauche de la position du voyageur : il est dos à l’arrivée */
    /* on gère d’abord les déplacements qui sont sur la même ligne que la direction du robot (soit vertical pour N et S, et horizontal pour O et E) afin d’éviter un quart de tour inutile */
    			for (int i=0; i<-DiffY; i++) {
    				getSimulatedvoyageur().goBackward(); /*le voyageur recule autant de fois que de cases séparant départ et arrivée, soit DiffY*/
    			}
    		}
    		else if (DiffY>0) { /*l’arrivée est à droite de la position du voyageur : il est face à l’arrivée*/
    			for (int i=0; i<DiffY; i++) {
    				getSimulatedvoyageur().goForward();/*le voyageur avance autant de fois que de cases séparant départ et arrivée*/
    			}
    		}
    		if (DiffX<0) { /*l’arrivée est en haut de la position du voyageur : l’arrivée est sur sa gauche */
    			getSimulatedvoyageur().turnLeft (); /*le voyageur tourne à gauche*/
    			for (int i=0; i<-DiffX; i++) {
    				getSimulatedvoyageur().goForward();
    			}
    		}
    		else if (DiffX>0) { /*l’arrivée est en bas de la position du voyageur : l’arrivée est sur sa droite */
    			getSimulatedvoyageur().turnRight();
    			for (int i=0; i<DiffX; i++) {
    				getSimulatedvoyageur().goForward();
       			}
    		}
    	}
    	
    	else if (getSimulatedvoyageur().getDirection()=="O") { /* levoyage regarde vers la gauche*/
    		if (DiffY<0) { /* il doit aller vers la gauche : il est face à l’arrivée*/
    			for (int i=0; i<-DiffY; i++) {
    				getSimulatedvoyageur().goForward();    				
    			}
    		}
    		else if (DiffY>0) { /*il doit aller à droite, il est dos à l’arrivée donc il recule*/
    			for (int i=0; i<DiffY; i++) {
    				getSimulatedvoyageur().goBackward();
    			}
    		}
    		if (DiffX<0) { /*le voyageur doit aller vers le haut : l’arrivée est donc sur sa droite*/
    			getSimulatedvoyageur().turnRight();
    			for (int i=0; i<-DiffX; i++) {
    				getSimulatedvoyageur().goForward();
    			}
    		}
    		else if (DiffX>0) { /*il doit aller vers le bas : l’arrivée est donc sur sa gauche*/
    			getSimulatedvoyageur().turnLeft();
    			for (int i=0; i<DiffX; i++) {
    				getSimulatedvoyageur().goForward();
    			}
    		}
    	}
    	
    	else if (getSimulatedvoyageur().getDirection()=="N") { /* le voyageur est face au nord*/
    		if (DiffX<0) { /* il doit aller vers le haut : il doit juste avancer*/
    			for (int i=0; i<-DiffX; i++) {
    				getSimulatedvoyageur().goForward();
    			}
    		}
    		else if (DiffX>0) { /* il doit aller vers le bas : il doit juste reculer*/
    			for (int i=0; i<DiffX; i++) {
    				getSimulatedvoyageur().goBackward();
    			}
    		}
    		if (DiffY<0) { /* l’arrivée est sur la gauche : donc il doit tourner à gauche puis avancer*/
    			getSimulatedvoyageur().turnLeft();
    			for (int i=0; i<-DiffY; i++) {
    				getSimulatedvoyageur().goForward();
    			}
    		}
    		else if (DiffY>0) { /* l’arrivée est sur la droite : il doit tourner à droite puis avancer */
    			getSimulatedvoyageur().turnRight();
    			for (int i=0; i<DiffY; i++) {
    				getSimulatedvoyageur().goForward();
    			}
    		}
    		
    	}
    	
    	else if (getSimulatedvoyageur().getDirection()=="S") { /* le voyageur regarde vers le bas */
    		if (DiffX<0) { /* il doit aller vers le haut, donc reculer */
    			for (int i=0; i<-DiffX; i++) {
    				getSimulatedvoyageur().goBackward();
    			}
    		}
    		else if (DiffX>0) { /* il doit aller vers le bas, donc avancer */
    			for (int i=0; i<DiffX; i++) {
    				getSimulatedvoyageur().goForward();
    			}
    		}
    		if (DiffY<0) { /*il doit aller vers la gauche, soit tourner à droite puis avancer */
    			getSimulatedvoyageur().turnRight();
    			for (int i=0; i<-DiffY; i++) {
    				getSimulatedvoyageur().goForward();
    			}
    		}
    		else if (DiffY>0) { /*il doit aller à droite, donc tourner sur sa gauche puis avancer */
    			getSimulatedvoyageur().turnLeft();
    			for (int i=0; i<DiffY; i++) {
    				getSimulatedvoyageur().goForward();
    			}
    		}
    	}
    }
    
    /* Applique un trajet d'étapes donné à un voyageur 
     * (ne prend pas les photos et ne sert finalement que pour obtenir l'energie necessaire au trajet)*/
    public void effectuerTrajet(ArrayList<Planete> etapes) {
    	getSimulatedvoyageur().getPosTete().setX(etapes.get(0).getPos().getX());
    	getSimulatedvoyageur().getPosTete().setY(etapes.get(0).getPos().getY()+1);
    	getSimulatedvoyageur().getPosBody().setX(etapes.get(0).getPos().getX());
    	getSimulatedvoyageur().getPosBody().setY(etapes.get(0).getPos().getY()); // la tete regarde vers la droite
    	getSimulatedvoyageur().setDirection("E");
    	for( int i=0; i<etapes.size()-1; i++) {
    		deplacementSansImages(etapes.get(i),etapes.get(i+1));
    	}
    }
    
    /* Fonction qui prend un trajet et renvoie l'energie qu'il coûte*/
    public int testVoyageur(ArrayList<Planete> li) {
    	AbstractVoyageur voyageurTest = new VoyageurSimuler();
    	setSimulatedvoyageur(voyageurTest);
    	effectuerTrajet(li);
    	return voyageurTest.getEnergy();
    }
    
    /* Fonction qui prend pour argument l'ArrayList d'ArrayList de planete perm à modifier,
     * la planete p qui doit être insérée successivent à toutes les positions de l'ArrayList en position j.
	 * en interalant élément aux différentes positions possibles dans liste */
	public void interposition(ArrayList<ArrayList<Planete>> perm, Planete p, int j) {
		ArrayList<Planete> li = (ArrayList<Planete>)perm.get(j).clone();
		perm.get(j).add(p);
		for(int i=0; i<li.size(); i++) {
			perm.add(j, (ArrayList<Planete>)li.clone());
			perm.get(j).add(i, p);
		}
	}
	
	public void generePermutation(ArrayList<ArrayList<Planete>> perm, ArrayList<Planete> planetes) {
		for (Planete p : planetes) {
			int nbPerm = perm.size();
			for (int j=nbPerm - 1; j>=0; j--) {
				interposition(perm, p, j);
			}
		}
	}	
// PROBLEME DE COPIE D'OBJET ??? (a verifier apres)	
	/* Intercalle entre les planètes j-1 et j d'une permutation les planetes necessaires
	 * pour aller de l'une à l'autre. Renvoi le nombre de planetes intercallées. */
	public int ajoutePlanetes(ArrayList<Planete>[][]matrice, ArrayList<Planete> unePerm, int j) {
		Planete depart = unePerm.get(j-1);
		Planete arrivee = unePerm.get(j);
		ArrayList<Planete> liEtapes =(ArrayList<Planete>)matrice[listPlanete.indexOf(depart)][listPlanete.indexOf(arrivee)].clone();
		liEtapes.remove(liEtapes.size()-1);
		unePerm.addAll(j, liEtapes);
		return liEtapes.size();
	}
	
	/* vérifie si il y a une gazeuse dans le voisinage à prendre en photo.*/
	public void gazeuseVoisine(AbstractVoyageur voyageur, Planete planete, ArrayList<Planete> gazeuses, AnimationGoutte animPhoto, AnimationCross animRoche, AnimationSpirale animSol) {
	  	ArrayList<Integer> indiceAEnlever = new ArrayList<>();	  	
		for (Planete g : gazeuses) {
	   		if (planete.getListVisibilite().contains(g)){
	   			faceAPlanete(voyageur, g); // fait face à la gazeuse
	   			
	   			voyageur.takePicture(planete); // la prend en photo
	    		animPhoto.setEcranFin(g.getImage());
	    		animPhoto.runAnimation();
	    		afficheEcran();
	    		wait(1000);
	    		animPhoto.setEcranDeb(g.getImage());
	    		animRoche.setEcranDeb(g.getImage());
	    		animSol.setEcranDeb(g.getImage());
	    		
	    		indiceAEnlever.add(gazeuses.indexOf(g));
	   		}
	   	}
		// l'enlève les gazeuses qui ont été traitées de la liste
	  	while(indiceAEnlever.size()>0) {
	  		gazeuses.remove(gazeuses.get(indiceAEnlever.get(indiceAEnlever.size()-1)));
	  		indiceAEnlever.remove(indiceAEnlever.size()-1);
	  	}
	}
	
    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotageSimuler()
     */
    @Override
    public void lancementSimuler() {
        // TODO Auto-generated method stub 
    	
		int nbPlanete = listPlanete.size();
		/* On fait la liste des planètes à visiter*/
		ArrayList<Planete> aVisiter = new ArrayList<>();
		for (Planete p : listPlanete) {
			if (p.getEchantillonRoche() != null || p.getEchantillonSol() != null) {
				aVisiter.add(p);
			}
		}
		/* On fait la liste des planètes gazeuses */
		ArrayList<Planete> gazeuse = new ArrayList<>();
		for (Planete p : listPlanete) {
			if (!aVisiter.contains(p)){
				gazeuse.add(p);
			}
		}

		/* On créer la liste des permutations des planetes a visiter
		 * Attention, ces permutations ne sont pas forcéments des trajets viables*/
		ArrayList<ArrayList<Planete>> permutation = new ArrayList<>();
		ArrayList<Planete> listInit = new ArrayList<>();
		listInit.add(aVisiter.get(0));
		ArrayList<Planete> listTronquee = (ArrayList<Planete>)aVisiter.clone();
		listTronquee.remove(0);
		permutation.add(listInit);
		generePermutation(permutation, listTronquee);
		
		/* On crée une matrice Mij qui en (i,j) donne les planetes qui doivent être traversées pour aller de i à j
		 * i exclus de cette liste, j inclus.
		 */
		ArrayList<Planete>[][] chemin = new ArrayList[nbPlanete][nbPlanete];
		for (int i= 0; i<nbPlanete; i++) {
			for (int j = 0; j<nbPlanete; j++) {
				chemin[i][j] = new ArrayList<>();
			}
		}		
		
		// on ajoute les voisins immédiats
		for (int i=0 ;i<nbPlanete ;i++) {
			for (int j=i+1 ;j<nbPlanete ;j++) {
				if (listPlanete.get(i).getListAccessibilite().contains(listPlanete.get(j))) {
					chemin[i][j].add(listPlanete.get(j));
					chemin[j][i].add(listPlanete.get(i)) ;
				}
			}
		}
		
		int numVoisMin = 0;
		int enerMin = 0;
		int enerTest = 0;
		ArrayList<Integer> potentiel = new ArrayList<>();
		ArrayList<Planete> listVoyage = new ArrayList<>();
		// initialise la listVoyage avec 2 éléments
		listVoyage.add(listPlanete.get(0)) ;
		listVoyage.add(listPlanete.get(0)) ;
		int a = 0 ; // un indice qui nous servira plus tard
		
		// on boucle sur k et à chaque boucle on ajoute les trajets vers les voisins de rang k
		for (int k = 1 ; k<nbPlanete-1 ; k++) {
			listVoyage.add(listPlanete.get(0));
			// planete de départ d’indice i
			for (int i=0 ; i<nbPlanete ;i++) {
				// planete d’arrivée d’indice j
				for (int j=i+1 ;j<nbPlanete ;j++) {					
					if (chemin[i][j].size() == 0) {
						// Pour trouver des candidats
						for (int n=0; n<nbPlanete; n++)	{
							if (listPlanete.get(i).getListAccessibilite().contains(listPlanete.get(n))) {
								if (chemin[n][j].size() == k) {
									potentiel.add(n);
								}
							}
						}
						// Si on a plusieurs trajets candidats on prend le moins énergivore
						if (potentiel.size() > 0) {
							listVoyage.set(0, listPlanete.get(i));
							numVoisMin = potentiel.get(0);
							listVoyage.set(1, listPlanete.get(potentiel.get(0)));
							a = 2;
							for (Planete p : chemin[potentiel.get(0)][j]) {
								listVoyage.set(a, p);
								a++;
							}		
							enerTest = testVoyageur(listVoyage);
							enerMin = enerTest;
							potentiel.remove(0);
							for(int n : potentiel) {
								listVoyage.set(1, listPlanete.get(n));
								a = 2;
								for (Planete p : chemin[n][j]) {
									listVoyage.set(a, p);
									a++;
								}
								enerTest = testVoyageur(listVoyage);
								if(enerTest<enerMin) {
									enerMin = enerTest;
									numVoisMin = n;
								}							
							}
							while(potentiel.size() > 0) {
								potentiel.remove(0);							
							}
							// Remplis la case (i,j) de la matrice chemin par le trajet opti 
							chemin[i][j].add(listPlanete.get(numVoisMin));
							chemin[j][i].add(listPlanete.get(i)) ;
							chemin[j][i].add(0, listPlanete.get(numVoisMin));
							if(chemin[numVoisMin][j].size()>1) {
								for (int n=0; n<chemin[numVoisMin][j].size()-1; n++) {
								chemin[i][j].add(chemin[numVoisMin][j].get(n));
								chemin[j][i].add(0, chemin[numVoisMin][j].get(n));
								}
							}											
							chemin[i][j].add(listPlanete.get(j)) ;							
						}
					}		
				}		
			}			
		}
		// Cet algorithme n'est pas parfait parce qu'il ne tient pas totalement compte de la direction du robot.
		//Pour chaque trajet, on considère arbitrarement que le robot regarde à l'est.
		
				
		/* Modifier les permutations pour en faire des trajets viables
		 * qui respectent les contraintes d'accessibilite*/
		for (int n=0; n<permutation.size(); n++) {
			int listSize = permutation.get(n).size();
			int b = 0 ;			// b le nombre de planètes rajoutées par rapport à la permutation
			for(int i = 1; i<listSize; i++) {
				// Si la planète ième planete traitée de la permutation n'est pas voisine
				// de la planète juste avant elle dans la permutation : on ajoute les étapes
				if (!permutation.get(n).get(i+b-1).getListAccessibilite().contains(permutation.get(n).get(i+b))) {					
					b = b + ajoutePlanetes(chemin, permutation.get(n), i+b);					
				}
			}
		}
		
		/* On filtre les trajets viables et on enlève ceux dont la longueur est 
		 * supérieur à [arbitrairement] 3 fois le nombre de planètes du système*/
		for(ArrayList<Planete> li : permutation) {
			if (li.size()>3*nbPlanete) {
				permutation.remove(permutation.indexOf(li));
			}
		}
		
		/* On test toutes les permutations pour savoir laquelle est la plus efficace. */
		numVoisMin = 0;
		enerMin = testVoyageur(permutation.get(0));
		for (int i=1; i<permutation.size(); i++) {
			enerTest = testVoyageur(permutation.get(i));
			if (enerTest<enerMin) {
				enerMin = enerTest;
				numVoisMin = i;
			}			
		}
		ArrayList<Planete> listOpti = permutation.get(numVoisMin);
		
		/* On créer la liste des planetes sur lesquelles on ne passe pas et qu'on prend uniquement en photo*/
		ArrayList<Planete> pasAVisiter = new ArrayList<Planete>();
		for (Planete g : gazeuse) {
			if (!listOpti.contains(g)) {
				pasAVisiter.add(g);
			}
		}
		// On réinitiale notre voyageur pour qu'il commence bien avec une énergie à 0.
		AbstractVoyageur voyageurFinal = new VoyageurSimuler();
    	setSimulatedvoyageur(voyageurFinal);
    	// On le place sur sa première étape.
		getSimulatedvoyageur().getPosTete().setX(listOpti.get(0).getPos().getX());
		getSimulatedvoyageur().getPosTete().setY(listOpti.get(0).getPos().getY()+1);
		getSimulatedvoyageur().getPosBody().setX(listOpti.get(0).getPos().getX());
		getSimulatedvoyageur().getPosBody().setY(listOpti.get(0).getPos().getY());
		// la tete regarde vers la droite
		getSimulatedvoyageur().setDirection("E");

		AnimationGoutte anim1 = new AnimationGoutte();
		anim1.setEcranDeb(ListScreen.SpaceInvBleu());
		AnimationCross anim2 = new AnimationCross();
		AnimationSpirale anim3 = new AnimationSpirale();

    	afficheEcran();
    	wait(1000);
    	arriveeSurPlanete(getSimulatedvoyageur(), listOpti.get(0), anim1, anim2, anim3);
    	gazeuseVoisine(getSimulatedvoyageur(), listOpti.get(0), pasAVisiter, anim1, anim2, anim3);
    	for( int i=0; i<listOpti.size()-1; i++) {
    		deplacement(listOpti.get(i), getSimulatedvoyageur(),listOpti.get(i+1));
    		arriveeSurPlanete(getSimulatedvoyageur(), listOpti.get(i+1), anim1, anim2, anim3);
    		gazeuseVoisine(getSimulatedvoyageur(), listOpti.get(i+1), pasAVisiter, anim1, anim2, anim3);
    	}

    }
}

