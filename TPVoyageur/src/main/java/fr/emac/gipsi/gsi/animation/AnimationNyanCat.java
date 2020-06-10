package fr.emac.gipsi.gsi.animation;

import fr.emac.gipsi.gsi.ecran.ListScreen;

public class AnimationNyanCat extends AbstractAnimation {
	
	public AnimationNyanCat()
	{
		
	}
	
	@Override
	public void runAnimation()
	{
		ecranDeb = ListScreen.NyanCat();
		
		showScreen(ecranDeb);
		ecranInt = copyScreen(ecranDeb);
		
		int n = ecranDeb.getColMax() + 1;
		int N = ecranDeb.getLigMax() + 1;
		
		float t = 0 ;
		
		for (t = 0 ; t < 15 ; t++)
		{
			for (int i = 0; i < N-1 ; i++)
			{
				System.out.println("startSend");
				this.showScreen(ecranInt);
				
				ecranInt.updateColorByXY(i+1, 0, ecranFin.getColorByXY(i, 0));
			}
			
			for (int j = 2 ; j < n ; j++)
			{
				ecranInt.updateColorByXY(n-2, j, ecranFin.getColorByXY(n-2, j-1));
			}
			
			this.showScreen(ecranInt);
			this.wait(400);
			
			this.showScreen(ecranDeb);
			this.wait(400);
		}	
	}
}
