/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

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
    public void deplacement(Planete depart, AbstractVoyageur voyageur, Planete arrivee) { 
    	int DiffX=arrivee.getPos().getX()-depart.getPos().getX(); /*distance départ-arrivée selon l’axe x*/
    	int DiffY=arrivee.getPos().getY()-depart.getPos().getY();/*distance départ-arrivée selon l’axe y*/
    	if (voyageur.getDirection()=="E") { // le voyageur regarder vers la droite 
    		if (DiffY<0) { /*l’arrivée est à gauche de la position du voyageur : il est dos à l’arrivée */
    /* on gère d’abord les déplacements qui sont sur la même ligne que la direction du robot (soit vertical pour N et S, et horizontal pour O et E) afin d’éviter un quart de tour inutile */
    			for (int i=0; i<-DiffY; i++) {
    				voyageur.goBackward(); /*le voyageur recule autant de fois que de cases séparant départ et arrivée, soit DiffY*/
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		else if (DiffY>0) { /*l’arrivée est à droite de la position du voyageur : il est face à l’arrivée*/
    			for (int i=0; i<DiffY; i++) {
    				voyageur.goForward();/*le voyageur avance autant de fois que de cases séparant départ et arrivée*/
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		if (DiffX<0) { /*l’arrivée est en haut de la position du voyageur : l’arrivée est sur sa gauche */
    			voyageur.turnLeft (); /*le voyageur tourne à gauche*/
    			afficheEcran();
    			wait(1000);
    			for (int i=0; i<-DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		else if (DiffX>0) { /*l’arrivée est en bas de la position du voyageur : l’arrivée est sur sa droite */
    			voyageur.turnRight();
    			afficheEcran();
    			wait(1000);
    			for (int i=0; i<DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    	}
    	else if (voyageur.getDirection()=="O") { /* levoyage regarde vers la gauche*/
    		if (DiffY<0) { /* il doit aller vers la gauche : il est face à l’arrivée*/
    			for (int i=0; i<-DiffY; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		else if (DiffY>0) { /*il doit aller à droite, il est dos à l’arrivée donc il recule*/
    			for (int i=0; i<DiffY; i++) {
    				voyageur.goBackward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		if (DiffX<0) { /*le voyageur doit aller vers le haut : l’arrivée est donc sur sa droite*/
    			voyageur.turnRight();
    			afficheEcran() ;
    			wait(1000) ;
    			for (int i=0; i<-DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		else if (DiffX>0) { /*il doit aller vers le bas : l’arrivée est donc sur sa gauche*/
    			voyageur.turnLeft();
    			afficheEcran() ;
    			wait(1000) ;
    			for (int i=0; i<DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    	}
    	else if (voyageur.getDirection()=="N") { /* le voyageur est face au nord*/
    		if (DiffX<0) { /* il doit aller vers le haut : il doit juste avancer*/
    			for (int i=0; i<-DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(1000) ; 
    			}
    		}
    		else if (DiffX>0) { /* il doit aller vers le bas : il doit juste reculer*/
    			for (int i=0; i<DiffX; i++) {
    				voyageur.goBackward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		if (DiffY<0) { /* l’arrivée est sur la gauche : donc il doit tourner à gauche puis avancer*/
    			voyageur.turnLeft();
    			afficheEcran() ;
    			wait(1000) ;	
    			for (int i=0; i<-DiffY; i++) {
    				voyageur.goBackward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		else if (DiffY>0) { /* l’arrivée est sur la droite : il doit tourner à droite puis avancer */
    			voyageur.turnRight();
    			afficheEcran() ;
    			wait(1000) ;
    			for (int i=0; i<DiffY; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		
    	}
    	else if (voyageur.getDirection()=="S") { /* le voyageur regarde vers le bas */
    		if (DiffX<0) { /* il doit aller vers le haut, donc reculer */
    			for (int i=0; i<-DiffX; i++) {
    				voyageur.goBackward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		else if (DiffX>0) { /* il doit aller vers le bas, donc avancer */
    			for (int i=0; i<DiffX; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		if (DiffY<0) { /*il doit aller vers la gauche, soit tourner à droite puis avancer */
    			voyageur.turnRight();
    			afficheEcran() ;
    			wait(1000) ;
    			for (int i=0; i<-DiffY; i++) {
    				voyageur.goBackward();
    				afficheEcran() ;
    				wait(1000) ;
    			}
    		}
    		else if (DiffY>0) { /*il doit aller à droite, donc tourner sur sa gauche puis avancer */
    			voyageur.turnLeft();
    			afficheEcran() ;
    			wait(1000) ;
    			for (int i=0; i<DiffY; i++) {
    				voyageur.goForward();
    				afficheEcran() ;
    				wait(1000) ;
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
    	afficheEcran();
    	wait(1000);
    	deplacement(listPlanete.get(0), getSimulatedvoyageur(),listPlanete.get(3));
        
    }
}
