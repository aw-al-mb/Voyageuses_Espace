package fr.emac.gipsi.gsi.animation;

public class AnimationCross extends AbstractAnimation{

	public AnimationCross()
	{
		
	}
	
	@Override
	public void runAnimation() {

		showScreen(ecranDeb);
		ecranInt = copyScreen(ecranDeb);
		
		//parcourt de la planete
		for (int col = 0; col < ecranInt.getColMax() + 1; col++)
		{
			System.out.println("startSend");
			this.showScreen(ecranInt);
			
			for (int lig = 0; lig < ecranInt.getLigMax() + 1; lig++)
			{
				if (lig % 2 == 0)
				{
					ecranInt.updateColorByXY(lig, col, ecranFin.getColorByXY(lig, col));
				}
				else
				{
					int n = ecranInt.getLigMax() - lig;
					int m = ecranInt.getColMax() - col;
					ecranInt.updateColorByXY(n, m, ecranFin.getColorByXY(n,m));
				}
			}
			this.wait(400);
		}
		this.showScreen(ecranInt);
	}
}
