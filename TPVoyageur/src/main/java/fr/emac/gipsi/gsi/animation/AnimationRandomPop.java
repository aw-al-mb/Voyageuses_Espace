package fr.emac.gipsi.gsi.animation;

import java.util.ArrayList;
import java.util.List;

import fr.emac.gipsi.gsi.voyage.Position;

public class AnimationRandomPop extends AbstractAnimation {

	public AnimationRandomPop() {
		
	}
	
	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt = copyScreen(ecranDeb);

		List<Position> colories = new ArrayList<Position>();
		
		while (colories.size() < (ecranInt.getLigMax()+1)*(ecranInt.getColMax()+1)) {
			int x = (int) (Math.random() * (ecranInt.getLigMax()+1 - 0));
			int y = (int) (Math.random() * (ecranInt.getColMax()+1 - 0));
			
			Position pixel = new Position(x, y);
			
			if (DejaLa(colories, pixel) == false) {
				ecranInt.updateColorByXY(x, y, ecranFin.getColorByXY(x,  y));
				colories.add(pixel);
				
				this.showScreen(ecranInt);
				this.wait(50);
			}
		}
		
		this.wait(1000);
	}

	
	public boolean DejaLa(List<Position> liste, Position test) {
		
		for (Position p : liste)
		{
			if (p.getX() == test.getX() && p.getY() == test.getY()) {
				return true;
			}
		}
		return false;
	}
}
