package tech.luigui.katas;

public class DryingPotatoes {

	public int calculateFinalWeight(int initialWeight, int initialWaterPercentage, int finalWaterPercentage) {
		int dryPercentage = 100 - initialWaterPercentage;
		float dryWeight = initialWeight * dryPercentage / 100f;
		int finalDryPercentage =  100 - finalWaterPercentage;
		float finalWeight = dryWeight * 100 / finalDryPercentage;
		System.out.println(finalWeight);
		return (int) finalWeight;
	}
	
}
