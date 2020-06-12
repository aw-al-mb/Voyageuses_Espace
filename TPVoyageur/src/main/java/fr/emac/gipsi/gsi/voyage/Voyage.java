/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.animation.AnimationGoutte;
import fr.emac.gipsi.gsi.animation.AnimationNyanCat;
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
 
//    /* Prend les photos et échantillons lors de l'arrivée sur une nouvelle planète */
//    public void arriveeSurPlanete(AbstractVoyageur voyageur, Planete arrivee, AnimationGoutte animPhoto, AnimationSpirale animSol, AnimationNyanCat animRoche) {
//    	/* On vérifie que c'est la première fois qu'on passe par cette planète */
//    	if (!voyageur.getAlreadyVisit().contains(arrivee)){
//    		/* Prendre la photo de la planète */
//    		voyageur.takePicture(arrivee);
//    		
//    		animPhoto.setEcranFin(arrivee.getImage());
//    		animPhoto.runAnimation();
//    		wait(1000);
//    		animSol.setEcranDeb(arrivee.getImage());
//    		animRoche.setEcranDeb(arrivee.getImage());
//    		
//    		if (arrivee.getEchantillonSol() != null) {
//    			/* Prendre un echantillon de sol si il y en a */
//    			voyageur.takeEchantillonSol(arrivee);
//    			animSol.setEcranFin(arrivee.getEchantillonSol());
//    			animSol.runAnimation();
//    			wait(1000);
//    			animRoche.setEcranDeb(arrivee.getEchantillonSol());
//    			animPhoto.setEcranDeb(arrivee.getEchantillonSol());
//    		}
//    		
//    		if (arrivee.getEchantillonRoche() != null) {
//    			/* prendre un echantillon de roche si il y en a */
//    			voyageur.takeEchantillonRoche(arrivee);    			
//    			animRoche.setEcranFin(arrivee.getEchantillonRoche());
//    			animRoche.runAnimation();
//    			wait(1000);
//    			animPhoto.setEcranDeb(arrivee.getEchantillonRoche());
//    		}
//    		voyageur.getAlreadyVisit().add(arrivee);
//    	}
//    }
    
  /* AVEC UN SEUL TYPE D'ANIMATION */  
    
    /* Prend les photos et échantillons lors de l'arrivée sur une nouvelle planète */
    public void arriveeSurPlanete(AbstractVoyageur voyageur, Planete arrivee, AnimationSpirale anim) {
    	/* On vérifie que c'est la première fois qu'on passe par cette planète */
    	if (!voyageur.getAlreadyVisit().contains(arrivee)){
    		/* Prendre la photo de la planète */
    		voyageur.takePicture(arrivee);
    		
    		anim.setEcranFin(arrivee.getImage());
    		anim.runAnimation();
    		anim.setEcranDeb(arrivee.getImage());
    		wait(1000);
    		
    		if (arrivee.getEchantillonSol() != null) {
    			/* Prendre un echantillon de sol si il y en a */
    			voyageur.takeEchantillonSol(arrivee);
    			anim.setEcranFin(arrivee.getEchantillonSol());
    			anim.runAnimation();
    			wait(1000);
    			anim.setEcranDeb(arrivee.getEchantillonSol());
    		}
    		
    		if (arrivee.getEchantillonRoche() != null) {
    			/* prendre un echantillon de roche si il y en a */
    			voyageur.takeEchantillonRoche(arrivee);    			
    			anim.setEcranFin(arrivee.getEchantillonRoche());
    			anim.runAnimation();
    			wait(1000);
    			anim.setEcranDeb(arrivee.getEchantillonRoche());
    		}
    		voyageur.getAlreadyVisit().add(arrivee);
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
 
    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotageSimuler()
     */
    @Override
    public void lancementSimuler() {
        // TODO Auto-generated method stub 
		AnimationGoutte anim1 = new AnimationGoutte();
		anim1.setEcranDeb(ListScreen.SpaceInvBleu());
		AnimationSpirale anim2 = new AnimationSpirale();
		AnimationNyanCat anim3 = new AnimationNyanCat();
		anim2.setEcranDeb(ListScreen.SpaceInvVert());
    	afficheEcran();
    	wait(1000);
    	for( int i=0; i<listPlanete.size()-1; i++) {
    		deplacement(listPlanete.get(i), getSimulatedvoyageur(),listPlanete.get(i+1));
    		/* arriveeSurPlanete(getSimulatedvoyageur(), listPlanete.get(i+1), anim1, anim2, anim3); */
    		arriveeSurPlanete(getSimulatedvoyageur(), listPlanete.get(i+1), anim2);
    	}
    }
}
