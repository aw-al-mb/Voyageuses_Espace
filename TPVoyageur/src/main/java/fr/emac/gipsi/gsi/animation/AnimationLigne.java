package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.screen.Screen;

public class AnimationLigne extends AbstractAnimation {

	public AnimationLigne()
	{
		
	}
	
	@Override
	public void runAnimation() {
		showScreen(ecranDeb);
		ecranInt = copyScreen(ecranDeb);
		
		// on va parcourir l'ecran ligne par ligne
		for (int lig = 0; lig < ecranInt.getLigMax() + 1; lig++)
		{
			System.out.println("startSend");
			this.showScreen(ecranInt);
			
			//on parcourt tous les pixels de chaque la ligne en question
			for (int col = 0; col < ecranInt.getColMax() + 1; col++)
			{
				ecranInt.updateColorByXY(lig,  col,  ecranFin.getColorByXY(lig, col));
			}
			this.wait(400);
		}
		this.showScreen(ecranInt);
		
	}

}
