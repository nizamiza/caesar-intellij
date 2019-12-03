package caesar.game.engagement;

import caesar.military.MilitaryUnit;
import caesar.ui.Printer;
import org.jetbrains.annotations.Contract;

import java.util.concurrent.Callable;

public class Engagement implements Callable<MilitaryUnit> {
	
	private MilitaryUnit unitA;
	private MilitaryUnit unitB;
	private boolean verbose;
	
	@Contract(pure = true)
	Engagement(MilitaryUnit unitA, MilitaryUnit unitB, boolean verbose) {
		
		this.unitA = unitA;
		this.unitB = unitB;
		this.verbose = verbose;
	}
	
	@Override
	public MilitaryUnit call() {
		
		if (this.unitA == null || this.unitB == null)
			return null;
		
		if (this.verbose) {
			Printer.print(this.unitA + " is engaging with " + this.unitB);
			return this.unitA.engage(this.unitB, true);
		}
		
		return this.unitA.engage(this.unitB, false);
	}
}
