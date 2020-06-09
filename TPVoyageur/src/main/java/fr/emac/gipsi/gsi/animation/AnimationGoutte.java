package fr.emac.gipsi.gsi.animation;

public class AnimationGoutte extends AbstractAnimation {
	
	public AnimationGoutte() 
	{
		
	}

	@Override
	public void runAnimation()
	{
		showScreen(ecranDeb);
		ecranInt = copyScreen(ecranDeb);
		
		int n = ecranInt.getColMax() + 1;

		if (n%2 == 0)
		{
			ecranInt.updateColorByXY(n/2 - 1, n/2 - 1, ecranFin.getColorByXY(n/2 - 1, n/2 - 1));
			ecranInt.updateColorByXY(n/2 - 1, n/2, ecranFin.getColorByXY(n/2 - 1, n/2));
			ecranInt.updateColorByXY(n/2, n/2, ecranFin.getColorByXY(n/2, n/2));
			ecranInt.updateColorByXY(n/2, n/2 - 1, ecranFin.getColorByXY(n/2, n/2 - 1));
			
			for (int i = 1; i < n/2 -1 ; i++) 
			{
				System.out.println("startSend");
				this.showScreen(ecranInt);
				
				for (int j = n/2 - 1 - i; j < n/2 + i; i++)
				{
					ecranInt.updateColorByXY(n/2 - 1 - i, j, ecranFin.getColorByXY(n/2 - 1 - i, j));
				}
				
				for (int k = n/2 - i; k< n/2 + i; k++)
				{
					ecranInt.updateColorByXY(k, n/2 + i, ecranFin.getColorByXY(n/2 + i,  k));
				}
				
				for (int g = n/2 + i - 1; g> n/2 - 1 - i; g--)
				{
					ecranInt.updateColorByXY(n/2 + i, g, ecranFin.getColorByXY(n/2 + i,  g));
				}
				
				for (int h = n/2 + i - 1; h> n/2 - i; h--)
				{
					ecranInt.updateColorByXY(h, n/2 - 1 - i, ecranFin.getColorByXY(h, n/2 - 1 - i));
				}
				
				this.showScreen(ecranInt);
				this.wait(500);
			
			}
			
		}
		
		else 
		{
			ecranInt.updateColorByXY(n/2, n/2, ecranFin.getColorByXY(n/2, n/2));
			
			for (int i = 1; i <= n/2 ; i++) 
			{
				System.out.println("startSend");
				this.showScreen(ecranInt);
				
				for (int j = n/2 - i; j <= n/2 + i; j++)
				{
					ecranInt.updateColorByXY(n/2 - i, j, ecranFin.getColorByXY(n/2 - i, j));
				}
				
				for (int k = n/2 - i + 1; k <= n/2 + i; k++)
				{
					ecranInt.updateColorByXY(k, n/2 + i, ecranFin.getColorByXY(k,  n/2 + i));
				}
				
				for (int g = n/2 + i - 1; g >= n/2 - i; g--)
				{
					ecranInt.updateColorByXY(n/2 + i, g, ecranFin.getColorByXY(n/2 + i,  g));
				}
				
				for (int h = n/2 + i - 1; h >= n/2 + 1 - i; h--)
				{
					ecranInt.updateColorByXY(h, n/2 - i, ecranFin.getColorByXY(h, n/2 - i));
				}
				
				this.showScreen(ecranInt);
				this.wait(500);
			}
			
		}
		
		this.showScreen(ecranInt);
		this.wait(500);
		
	}
	
}
