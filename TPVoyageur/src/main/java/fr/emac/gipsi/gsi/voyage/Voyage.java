/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.animation.AnimationCross;
import fr.emac.gipsi.gsi.animation.AnimationGoutte;
import fr.emac.gipsi.gsi.animation.AnimationSpirale;
import fr.emac.gipsi.gsi.ecran.ListScreen;
import fr.emac.gipsi.gsi.screen.Screen;
import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;

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
	
	/* vérifie si il y a une gazeuse dans le voisinage à prendre en photo.*/
	public void gazeuseVoisine(AbstractVoyageur voyageur, Planete planete, ArrayList<Planete> gazeuses, AnimationGoutte animPhoto, AnimationCross animRoche, AnimationSpirale animSol) {
	  	for (Planete g : gazeuses) {
	   		if (planete.getListVisibilite().contains(g)){
	   			faceAPlanete(voyageur, g); // fait face à la gazeuse
	   			
	   			voyageur.takePicture(planete); // la prend en photo
	    		animPhoto.setEcranFin(planete.getImage());
	    		animPhoto.runAnimation();
	    		afficheEcran();
	    		wait(1000);
	    		animRoche.setEcranDeb(planete.getImage());
	    		animSol.setEcranDeb(planete.getImage());
	    		
	    		gazeuses.remove(gazeuses.indexOf(g));// l'enlève de la liste des gazeuses pas encore traitées
	   		}
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


		/* On créer la liste des permutations
		 * Attention, ces permutations ne sont pas forcéments des trajets viables*/
		ArrayList<ArrayList<Planete>> permutation = new ArrayList<>();
		ArrayList<Planete> listInit = new ArrayList<>();
		listInit.add(aVisiter.get(0));
		ArrayList<Planete> listTronquee = (ArrayList<Planete>)aVisiter.clone();
		listTronquee.remove(0);
		permutation.add(listInit);
		generePermutation(permutation, listTronquee);


		/* On créer la liste des planetes sur lesquelles on ne passe pas */
		ArrayList<Planete> pasAVisiter = (ArrayList<Planete>)gazeuse.clone();
		for (Planete g : gazeuse) {
			//enlever g de pasAVisiter si on y passe en suivant le trajet opti
		}

		AnimationGoutte anim1 = new AnimationGoutte();
		anim1.setEcranDeb(ListScreen.SpaceInvBleu());
		AnimationCross anim2 = new AnimationCross();
		AnimationSpirale anim3 = new AnimationSpirale();

    	afficheEcran();
    	wait(1000);
    	arriveeSurPlanete(getSimulatedvoyageur(), listPlanete.get(0), anim1, anim2, anim3);
    	gazeuseVoisine(getSimulatedvoyageur(), listPlanete.get(0), pasAVisiter, anim1, anim2, anim3);
    	for( int i=0; i<listPlanete.size()-1; i++) {
    		deplacement(listPlanete.get(i), getSimulatedvoyageur(),listPlanete.get(i+1));
    		arriveeSurPlanete(getSimulatedvoyageur(), listPlanete.get(i+1), anim1, anim2, anim3);
    		gazeuseVoisine(getSimulatedvoyageur(), listPlanete.get(i+1), pasAVisiter, anim1, anim2, anim3);
    	}

    }
}
