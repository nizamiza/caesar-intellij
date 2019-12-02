package caesar.game.turn;

import caesar.game.Game;
import caesar.game.map.Direction;
import caesar.game.map.Location;
import caesar.game.map.Relief;
import caesar.game.weather.WeatherType;
import caesar.military.troop.Troop;
import caesar.ui.Message;
import caesar.ui.Printer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum Action {
	
	NEW_GAME("New game", 0, game -> {
		
		game.start(10, 6, 4, 6, 100);
		
		return new Response(
			Message.NEW_GAME,
			ResponseType.SUCCESS
		);
	}),
	
	CONTINUE_GAME("Continue game", 0, game -> {
		
		Response response = new Response();
		
		if (game.getPlayer() != null) {
			
			response.setMessage(Message.CONTINUE);
			response.setType(ResponseType.SUCCESS);
			
			game.nextTurn(TurnType.TRAVEL);
			return response;
		}
		
		else {
			response.setMessage(Message.NO_CURRENT_GAME);
			response.setType(ResponseType.FAILURE);
			return response;
		}
	}),
	
	EXIT("Exit", 0, game -> {
		game.exit();
		return new Response(ResponseType.SUCCESS);
	}),
	
	TO_MAIN_MENU("<< Main menu", 0, game -> {
		
		game.nextTurn(TurnType.MAIN_MENU);
		return new Response(ResponseType.SUCCESS);
	}),
	
	TO_NEXT_DAY("Next day >>", 0, game -> {
		
		game.getEnemy().makeMove(game.getPlayer(), game.getMap());
		game.incrementTurnsCount();
		
		game.replenishEntitiesAP();
		game.nextDay();
		game.changeWeather();
		
		if (game.getEnemyLocation().equals(game.getPlayerLocation()))
			game.nextTurn(TurnType.ENCOUNTER);
		
		else game.nextTurn(TurnType.TRAVEL);
		
		return new Response(
			Message.NEXT_TURN,
			ResponseType.SUCCESS
		);
	}),
	
	TO_TRAVEL("<< Previous", 0, game -> {
		
		game.nextTurn(TurnType.TRAVEL);
		return new Response(ResponseType.SUCCESS);
	}),
	
	TO_ENCOUNTER("<< Previous", 0, game -> {
		
		game.nextTurn(TurnType.ENCOUNTER);
		return new Response(ResponseType.SUCCESS);
	}),
	
	ADVANCE("Advance", 0, game -> {
		
		game.nextTurn(TurnType.ADVANCE);
		return new Response(ResponseType.SUCCESS);
	}),
	
	LOOK_AROUND("Look around", 3, game -> {
		
		Location playerLocation = game.getPlayerLocation();
		Location enemyLocation = game.getEnemyLocation();
		
		int deltaX = enemyLocation.getX() - playerLocation.getX();
		int deltaY = enemyLocation.getY() - playerLocation.getY();
		
		Printer.printRelief(
			game.getMap(),
			playerLocation
		);
		
		if (WeatherType.isClear(game.getCurrentWeather()) &&
			(Math.abs(deltaX) == 1 || Math.abs(deltaY) == 1)) {
			
			Direction direction = Direction.valueOf(deltaX, deltaY);
			
			Printer.print(Message.ENEMY_NEARBY);
			Printer.print("Enemy is " + direction + " of you...");
		}
		
		return new Response(ResponseType.SUCCESS);
	}),
	
	ANALYZE_ARMY("Analyze your army", 0, game -> {
		
		game.nextTurn(TurnType.ANALYZE_ARMY);
		return new Response(ResponseType.SUCCESS);
	}),
	
	OPEN_JOURNAL("Open journal", 0, game -> {
		
		return new Response(
			game.getLog(),
			ResponseType.SUCCESS
		);
	}),
	
	GENERAL_ANALYSIS("General analysis", 1, game -> {
		
		return new Response(
			Troop.getSummary(game.getPlayerArmy()),
			ResponseType.SUCCESS
		);
	}),
	
	THOROUGH_ANALYSIS("Thorough analysis", 3, game -> {
		
		return new Response(
			Troop.getFullSummary(game.getPlayerArmy()),
			ResponseType.SUCCESS
		);
	}),
	
	BUILD_CAMP("Build camp", 10, game -> {
		
		Response response = new Response();
		
		if (Relief.isSolid(game.getPlayerRelief())) {
		
		
		}
		
		return new Response(ResponseType.SUCCESS);
	}),
	
	PREPARE_FOR_BATTLE("Prepare for battle", 0, game -> {
		
		game.nextTurn(TurnType.PREPARE_FOR_BATTLE);
		return new Response(ResponseType.SUCCESS);
	}),
	
	SEND_MESSAGE("Send message", 0, game -> {
		
		game.nextTurn(TurnType.SEND_MESSAGE);
		return new Response(ResponseType.SUCCESS);
	}),
	
	RETREAT("Retreat", 0, game -> {
		
		game.nextTurn(TurnType.RETREAT);
		return new Response(ResponseType.SUCCESS);
	}),
	
	ATTACK("Attack", 0, game -> {
		
		game.getPlayerArmy().engage(game.getEnemyArmy(), false);
		return new Response(ResponseType.SUCCESS);
	}),
	
	CHANGE_FORMATION("Change formation", 0, game -> {
		return new Response(ResponseType.SUCCESS);
	}),
	
	PROPOSE_ALLIANCE("Propose alliance", 2, game -> {
		return new Response(ResponseType.SUCCESS);
	}),
	
	DEMAND_SURRENDER("Demand surrender", 2, game -> {
		return new Response(ResponseType.SUCCESS);
	}),
	
	ASK_FOR_SUPPLIES("Ask for supplies", 2, game -> {
		return new Response(ResponseType.SUCCESS);
	}),
	
	NORTH("North", 1, Action::advance),
	NORTHWEST("Northwest", 1, Action::advance),
	NORTHEAST("Northeast", 1, Action::advance),
	WEST("West", 1, Action::advance),
	EAST("East", 1, Action::advance),
	SOUTH("South", 1, Action::advance),
	SOUTHWEST("Southwest", 1, Action::advance),
	SOUTHEAST("Southeast", 1, Action::advance);
	
	private final int value;
	private final String name;
	private final ActionHandler handler;
	
	@Contract(pure = true)
	Action(String name, int value, ActionHandler handler) {
		
		this.name = name;
		this.value = value;
		this.handler = handler;
	}
	
	@Contract(pure = true)
	public int getValue() {
		return this.value;
	}
	
	public Response handle(Game game) {
		return this.handler.handle(game);
	}
	
	@Contract(pure = true)
	@Override
	public String toString() {
		return this.name;
	}
	
	@NotNull
	@Contract(pure = true)
	public String toString(boolean addValue) {
		return this.name + (
			addValue && this.value != 0 ? " [" + this.value + "]" : ""
		);
	}
	
	@NotNull
	@Contract("_ -> new")
	static Response advance(@NotNull Game game) {
		
		Direction direction = Direction.valueOf(
			game.getLogLastItem().toUpperCase()
		);
		
		Relief relief = game.getMap().getRelief(
			direction.getX() + game.getPlayerLocation().getX(),
			direction.getY() + game.getPlayerLocation().getY()
		);
		
		Response response = new Response();
		
		if (relief == Relief.UNKNOWN) {
			
			response.setMessage(Message.UNKNOWN_DIRECTION);
			response.setType(ResponseType.FAILURE);
			
			return response;
		}
		
		response.setMessage(Message.PLAYER_MOVED);
		response.setType(ResponseType.SUCCESS);
		
		game.getPlayer().move(direction, relief);
		return response;
	}
}
