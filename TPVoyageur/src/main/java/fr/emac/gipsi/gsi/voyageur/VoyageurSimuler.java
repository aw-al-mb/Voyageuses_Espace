/**
 *
 */
package fr.emac.gipsi.gsi.voyageur;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class VoyageurSimuler extends AbstractVoyageur {

    /**
     *
     */
    public VoyageurSimuler() {
        // TODO Auto-generated constructor stub
    }
    
    /* Le robot se deplace dans la direction où il regarde */
    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#forward()
     */
    @Override
    protected void forward() {

   	setPosBody(getPosTete());
    if(getDirection()=="E") {
		 getPosTete().setY(getPosTete().getY()+1);
     }
     else if(getDirection()=="N") {
         getPosTete().setX(getPosTete().getX()-1);
     }
     else if(getDirection()=="O") {
    	 getPosTete().setY(getPosTete().getY()-1);
     }
     else {
    	 getPosTete().setX(getPosTete().getX()+1);
     }

    }

    
    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#backward()
     */
    @Override
    protected void backward() {

       	setPosTete(getPosBody());
        if(getDirection()=="E") {
    		 getPosBody().setY(getPosBody().getY()-1);
         }
         else if(getDirection()=="N") {
             getPosBody().setX(getPosBody().getX()+1);
         }
         else if(getDirection()=="O") {
        	 getPosBody().setY(getPosBody().getY()+1);
         }
         else {
        	 getPosBody().setX(getPosBody().getX()-1);
         }
    }

    
    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#left()
     */
    @Override
    protected void left() {

    	if(getDirection()=="E") {
    		 getPosTete().setX(getPosTete().getX()-1);
    		 getPosTete().setY(getPosTete().getY()-1);
             setDirection("N");
         }
         else if(getDirection()=="N") {
             getPosTete().setX(getPosTete().getX()+1);
             getPosTete().setY(getPosTete().getY()-1);
             setDirection("O");
         }
         else if(getDirection()=="O") {
        	 getPosTete().setX(getPosTete().getX()+1);
             getPosTete().setY(getPosTete().getY()+1);
             setDirection("S");
         }
         else {
        	 getPosTete().setX(getPosTete().getX()-1);
             getPosTete().setY(getPosTete().getY()+1);
             setDirection("E");
         }
     }
    

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#right()
     */
    @Override
    protected void right() {
    	
   	 if(getDirection()=="E") {
		 getPosTete().setX(getPosTete().getX()+1);
		 getPosTete().setY(getPosTete().getY()-1);
         setDirection("S");
     }
     else if(getDirection()=="N") {
         getPosTete().setX(getPosTete().getX()+1);
         getPosTete().setY(getPosTete().getY()+1);
         setDirection("E");
     }
     else if(getDirection()=="O") {
    	 getPosTete().setX(getPosTete().getX()-1);
         getPosTete().setY(getPosTete().getY()+1);
         setDirection("N");
     }
     else {
    	 getPosTete().setX(getPosTete().getX()-1);
         getPosTete().setY(getPosTete().getY()-1);
         setDirection("O");
    }
}
    
}
