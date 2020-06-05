package fr.emac.gipsi.gsi.animation;

public class AnimationSpirale extends AbstractAnimation {

	public AnimationSpirale()
	{
		
	}
	
	@Override
	public void runAnimation() 
	{
		showScreen(ecranDeb);
		ecranInt = copyScreen(ecranDeb);
		
		int n = ecranInt.getColMax();
				
		for (int i = 0; i < n / 2; i++)
		{
			System.out.println("startSend");
			this.showScreen(ecranInt);
			
			for (int j = i; j < n-i+1; j++)
			{
				ecranInt.updateColorByXY(i, j, ecranFin.getColorByXY(i,  j));
				this.showScreen(ecranInt);
				this.wait(50);
			}


			for (int k = i+1; k < n-i+1; k++)
			{
				ecranInt.updateColorByXY(k, n - i, ecranFin.getColorByXY(k, n - i));
				this.showScreen(ecranInt);
				this.wait(50);
			}

			
			for (int g = n-i-1; g > i-1; g--)
			{
				ecranInt.updateColorByXY(n-i, g, ecranFin.getColorByXY(n-i,  g));
				this.showScreen(ecranInt);
				this.wait(50);
			}

			
			for (int h = n-i-1; h > i; h--)
			{
				ecranInt.updateColorByXY(h, i, ecranFin.getColorByXY(h, i));
				this.showScreen(ecranInt);
				this.wait(50);
			}
		}
		
		ecranInt.updateColorByXY(n/2 , n/2, ecranFin.getColorByXY(n/2, n/2));
		this.showScreen(ecranInt);
		this.wait(400);
	}
}
