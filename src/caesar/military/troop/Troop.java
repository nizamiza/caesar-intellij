package caesar.military.troop;

import caesar.game.engagement.EngagementController;
import caesar.military.MilitaryUnit;
import caesar.military.officer.Officer;
import caesar.military.rome.RomanArmy;
import caesar.military.soldier.Soldier;
import caesar.ui.Message;
import caesar.ui.Printer;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.IntStream;

public abstract class Troop implements MilitaryUnit {
	
	private final int unitCapacity;
	private final String symbol;
	private Troop parentUnit;
	
	protected List<MilitaryUnit> units;
	protected Officer officer;
	
	protected Troop(Troop parentUnit, int unitCapacity, String symbol) {
		
		this.unitCapacity = unitCapacity;
		this.units = this.initUnits();
		this.parentUnit = parentUnit;
		this.symbol = symbol;
	}
	
	@Contract(pure = true)
	protected Troop(
		Troop parentUnit,
		int unitCapacity,
		List<MilitaryUnit> units,
		String symbol
	) {
		
		this.unitCapacity = unitCapacity;
		this.units = units;
		this.parentUnit = parentUnit;
		this.symbol = symbol;
	}
	
	protected Troop(int unitCapacity, String symbol) {
		
		this.unitCapacity = unitCapacity;
		this.units = this.initUnits();
		this.symbol = symbol;
	}

	protected abstract int getChildUnitCapacity();
	
	protected abstract List<MilitaryUnit> initUnits();
	
	protected abstract Troop getChildUnitInstance(
		List<MilitaryUnit> units,
		Officer officer
	);
	
	public List<MilitaryUnit> getUnits() {
		return this.units;
	}
	
	public Officer getOfficer() {
		return this.officer;
	}
	
	@Override
	public void perish() {
		
		if (this.parentUnit != null) {
			this.parentUnit.units.remove(this);
			this.parentUnit = null;
		}
		
		else Printer.print(Message.CANT_REMOVE_TROOP);
	}
	
	@Override
	public void setParentUnit(MilitaryUnit parentUnit) {
		this.parentUnit = (Troop) parentUnit;
	}
	
	public void removeSoldier(@NotNull Soldier soldier) {
		
		this.units.remove(soldier);
		
		if (this.units.size() == 0 && this.officer == null)
			this.perish();
	}
	
	public void removeOfficer() {
		
		this.officer.setParentUnit(null);
		
		if (this.units.size() == 0)
			this.perish();
	}
	
	@Contract("null -> null")
	private Officer getUnitOfficer(MilitaryUnit unit) {
		
		if (unit instanceof Troop)
			return ((Troop) unit).getOfficer();
		
		return null;
	}
	
	@Nullable
	private Officer findReplacementOfficer(
		@NotNull List<MilitaryUnit> units
	) {
		
		if (units.isEmpty())
			return null;
		
		if (units.get(0) instanceof Soldier) {
			
			Officer officer = (Officer) units.get(0);
			units.remove(0);
			
			return officer;
		}
		
		Optional<MilitaryUnit> optional =
			units.parallelStream()
			     .filter(u -> ((Troop) u).getOfficer() != null)
			     .findFirst();
		
		if (optional.isPresent()) {
			
			Troop unit = (Troop) optional.get();
			Officer officer = this.getUnitOfficer(unit);
			
			unit.removeOfficer();
			this.findReplacementOfficer(unit.getUnits());
			
			return officer;
		}
		
		for (MilitaryUnit unit: units) {
			return this.findReplacementOfficer(
				((Troop) unit).getUnits()
			);
		}
		
		return null;
	}
	
	private Troop initChildUnit(
		@NotNull List<Officer> officersPool,
		@NotNull List<MilitaryUnit> unitsPool
	) {
		
		Officer officer;
		
		if (officersPool.isEmpty()) {
			officer = this.findReplacementOfficer(unitsPool);
		} else {
			officer = officersPool.get(0);
			officersPool.remove(0);
		}
		
		return this.getChildUnitInstance(
			new LinkedList<>(),
			officer
		);
	}
	
	private void populateChildTroop(
		Troop unit,
		List<MilitaryUnit> unitsPool
	) {
		
		MilitaryUnit unitToAdd;
		
		for (int j = 0; j < this.getChildUnitCapacity(); j++) {
			
			if (unitsPool.isEmpty())
				return;
			
			unitToAdd = unitsPool.get(0);
			unitToAdd.setParentUnit(unit);
	
			unit.getUnits().add(unitToAdd);
			unitsPool.remove(0);
		}
	}
	
	private void regroupUnits() {
		
		List<MilitaryUnit> unitsPool = new LinkedList<>();
		List<Officer> officersPool = new LinkedList<>();
		
		IntStream.range(0, this.unitCapacity).forEach(i -> {
			
			Troop troop = (Troop) this.units.get(i);
			unitsPool.addAll(troop.getUnits());
			
			if (troop.getOfficer() != null)
				officersPool.add(troop.getOfficer());
		});
		
		this.units.clear();
		
		for (int i = 0; i < this.unitCapacity; i++) {
			
			if (unitsPool.isEmpty() && officersPool.isEmpty())
				break;
			
			Troop unit = this.initChildUnit(
				officersPool,
				unitsPool
			);
			
			this.populateChildTroop(unit, unitsPool);
			this.units.add(unit);
		}
	}
	
	@Override
	public MilitaryUnit engage(MilitaryUnit target, boolean verbose) {
		
		if (target == null)
			return this;
		
		Troop targetTroop = (Troop) target;
		
		new EngagementController(this.officer, targetTroop.officer)
			.start(verbose);
		
		new EngagementController(this.units, targetTroop.units)
			.start(verbose);
		
		this.regroupUnits();
		return this;
	}
	
	@Override
	public String toString() {
		return super.toString() +
			"[" +
			this.symbol +
			"] (" +
			(this.units.size()) +
			")";
	}
	
	@Contract(pure = true)
	public static int countSoldiers(MilitaryUnit unit) {
		
		if (unit == null)
			return 0;
		
		if (unit instanceof Soldier)
			return 1;
		
		int total = 0;
		Troop troop = (Troop) unit;
		
		for (MilitaryUnit u:  troop.units)
			total += countSoldiers(u);
		
		return total + (troop.officer == null ? 0 : 1);
	}
	
	@NotNull
	public static String getSummary(@NotNull Troop troop) {
		
		return troop.getClass().getSimpleName() +
			":\n" +
			"-> Officer: " +
			troop.officer +
			"\n" +
			"-> Units count: " +
			troop.units.size() +
			"\n";
	}
	
	@NotNull
	public static String getFullSummary(Troop troop) {
		
		StringBuilder fullSummary = new StringBuilder(getSummary(troop));
		
		IntStream.range(0, troop.units.size())
		         .forEach(i -> {
			         Troop current = (Troop) troop.units.get(i);
			         fullSummary.append(getSummary(current));
		         });
		
		return fullSummary.toString();
	}
	
	public static void main(String[] args) {
		
		Troop troop = new RomanArmy(10);
		Printer.print(Troop.getFullSummary(troop));
	}
}