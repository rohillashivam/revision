package com.arcesium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {

	public static void main(String[] args) {
		List<String> playerData = new ArrayList<>();
		playerData.add("Boetang");
		playerData.add("6.1");
		playerData.add("22");
		playerData.add("24");
		playerData.add("45");
		List<String> playerData1 = new ArrayList<>();
		playerData1.add("Kaka");
		playerData1.add("6");
		playerData1.add("22");
		playerData1.add("1");
		playerData1.add("1");
		List<String> playerData2 = new ArrayList<>();
		playerData2.add("Ramos");
		playerData2.add("6.3");
		playerData2.add("22");
		playerData2.add("67");
		playerData2.add("70");
		List<String> playerData3 = new ArrayList<>();
		playerData3.add("Ronaldo");
		playerData3.add("5.8");
		playerData3.add("21");
		playerData3.add("120");
		playerData3.add("0");
		List<String> playerData4 = new ArrayList<>();
		playerData4.add("Suarez");
		playerData4.add("5.9");
		playerData4.add("20");
		playerData4.add("100");
		playerData4.add("1");
		List<List<String>> applicationList = new ArrayList<>();
		applicationList.add(playerData);
		applicationList.add(playerData1);
		applicationList.add(playerData2);
		applicationList.add(playerData3);
		applicationList.add(playerData4);
		
		List<List<String>> result = getSelectionStatus(applicationList);
		for(List<String> resultObj : result) {
			for(String data : resultObj) {
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}

	public static List<List<String>> getSelectionStatus(List<List<String>> applications) {
		if (applications == null || applications.isEmpty())
			return applications;

		Map<Integer, List<String>> resultList = new HashMap<>(applications.size());
		List<Integer> exceptionIndex = new LinkedList<Integer>();
		Map<Integer, PlayerResult> rejectedMap = new HashMap<>();
		Queue<PlayerResult> strikerMinHeap = new PriorityQueue<>((_playerResult, _playerResultNew) ->  {
			return _playerResult.getPlayer().getScores().compareTo(_playerResultNew.getPlayer().getScores());
			});
		Queue<PlayerResult> defenderMinHeap = new PriorityQueue<>((_playerResult, _playerResultNew) ->  {
			return _playerResult.getPlayer().getDefends().compareTo(_playerResultNew.getPlayer().getDefends());
			});
		
		for (int i=0; i< applications.size(); i++) {
			List<String> application = applications.get(i);
			if(application.size() < 5)
				continue;
			Player player = null;
			try {
				player = new Player.PlayerBuilder().setName(application.get(0))
						.setHeight(application.get(1) != null && !application.get(1).isEmpty() ? Float.parseFloat(application.get(1)) : null)
						.setBmi(application.get(2) != null && !application.get(2).isEmpty() ? Float.parseFloat(application.get(2)) : null)
						.setScores(application.get(3) != null && !application.get(3).isEmpty() ? Integer.parseInt(application.get(3)) : null)
						.setDefends(application.get(4) != null && !application.get(4).isEmpty() ? Integer.parseInt(application.get(4)) : null)
						.build();
			} catch (Exception e) {
				System.out.println(e.getMessage()+" for application index "+i);
				exceptionIndex.add(i);
				continue;
			}
			PlayerResult playerResult = null;
			if(player != null && !player.isFit()) {
				playerResult = rejectPlayer(rejectedMap, i, player);
				continue;
			}
			if(player.isStriker()) {
				playerResult = new PlayerResult(player, i, PlayerStatus.SELECT_STRIKER);
				strikerMinHeap.add(playerResult);
				continue;
			}
			if(player.isDefender()) {
				playerResult = new PlayerResult(player, i, PlayerStatus.SELECT_DEFENDER);
				defenderMinHeap.add(playerResult);
				continue;
			}
			playerResult = rejectPlayer(rejectedMap, i, player);
		}
		
		if(defenderMinHeap.size() == strikerMinHeap.size()) {
			return buildResponse(defenderMinHeap, strikerMinHeap, rejectedMap, resultList);
		}
		
		rebalanceTeam(rejectedMap, strikerMinHeap, defenderMinHeap);
		
		return buildResponse(defenderMinHeap, strikerMinHeap, rejectedMap, resultList);

	}

	private static void rebalanceTeam(Map<Integer, PlayerResult> rejectedMap, Queue<PlayerResult> strikerMinHeap,
			Queue<PlayerResult> defenderMinHeap) {
		while(defenderMinHeap.size() != strikerMinHeap.size()) {
			if(defenderMinHeap.size() > strikerMinHeap.size()) {
				PlayerResult plResult = defenderMinHeap.poll();
				if(plResult.getPlayer().isStriker()) {
					plResult.setStatus(PlayerStatus.SELECT_STRIKER);
					strikerMinHeap.add(plResult);
				} else {
					plResult.setStatus(PlayerStatus.REJECT_NA);
					rejectedMap.put(plResult.getIndex(), plResult);
				}
			} else {
				PlayerResult plResult = strikerMinHeap.poll();
				if(plResult.getPlayer().isDefender()) {
					plResult.setStatus(PlayerStatus.SELECT_DEFENDER);
					defenderMinHeap.add(plResult);
				} else {
					plResult.setStatus(PlayerStatus.REJECT_NA);
					rejectedMap.put(plResult.getIndex(), plResult);
				}
			}
		}
	}

	private static PlayerResult rejectPlayer(Map<Integer, PlayerResult> rejectedMap, int i, Player player) {
		PlayerResult playerResult;
		playerResult = new PlayerResult(player, i, PlayerStatus.REJECT_NA);
		rejectedMap.put(i, playerResult);
		return playerResult;
	}

	private static List<List<String>> buildResponse(Queue<PlayerResult> defenderMinHeap,
			Queue<PlayerResult> strikerMinHeap, Map<Integer, PlayerResult> rejectedMap, Map<Integer, List<String>> resultMap) {
		Iterator rejectedMapIterator = rejectedMap.entrySet().iterator();
		// adding the rejected players in list
		while(rejectedMapIterator.hasNext()) {
			Map.Entry<Integer, PlayerResult> entryData = (Entry<Integer, PlayerResult>)rejectedMapIterator.next();
			List<String> dataList = new ArrayList<>();
			dataList.add(entryData.getValue().getPlayer().getName());
			addResultData(entryData.getValue(), dataList);
			resultMap.put(entryData.getKey(), dataList);
		}
		
		// adding the strikers
		while(!strikerMinHeap.isEmpty()) {
			PlayerResult result = strikerMinHeap.poll();
			if(resultMap.containsKey(result.getIndex()))
				continue;
			List<String> dataList = new ArrayList<>();
			dataList.add(result.getPlayer().getName());
			addResultData(result, dataList);
			resultMap.put(result.getIndex(), dataList);
		}
		
		// adding the defenders
		while(!defenderMinHeap.isEmpty()) {
			PlayerResult result = defenderMinHeap.poll();
			if(resultMap.containsKey(result.getIndex()))
				continue;
			List<String> dataList = new ArrayList<>();
			dataList.add(result.getPlayer().getName());
			addResultData(result, dataList);
			resultMap.put(result.getIndex(), dataList);
		}
		
		List<List<String>> resultList = new ArrayList<>();
		for(int i=0; i<resultMap.size(); i++) {
			resultList.add(resultMap.get(i));
		}
		return resultList;
	}

	private static void addResultData(PlayerResult result, List<String> dataList) {
		String[] resultStr =  result.getStatus().toString().split("_");
		if(resultStr[0] != null)
			dataList.add(resultStr[0]);
		if(resultStr.length == 1)
			return;
		if(resultStr[1] != null)
			dataList.add(resultStr[1]);
	}

}

enum PlayerStatus {
	REJECT_NA, SELECT_DEFENDER, SELECT_STRIKER 
}

class PlayerResult {
	private Player player;
	private Integer index;
	private PlayerStatus status;
	
	public PlayerResult(Player player, Integer index, PlayerStatus status) {
		this.player = player;
		this.index = index;
		this.status = status;
	}

	public Player getPlayer() {
		return player;
	}

	public Integer getIndex() {
		return index;
	}

	public PlayerStatus getStatus() {
		return status;
	}
	
	public void setStatus(PlayerStatus status) {
		this.status = status;
	}
	
}

class Player {
	private String name;
	private Float height;
	private Float bmi;
	private Integer scores;
	private Integer defends;

	private static final float minHeight = 5.8f;
	private static final float maxBMI = 23f;
	private static final Integer minScoreStriker = 50;
	private static final Integer minDefendDefender = 30;

	private Player(String name, Float height, Float bmi, Integer scores, Integer defends) {
		super();
		this.name = name;
		this.height = height;
		this.bmi = bmi;
		this.scores = scores;
		this.defends = defends;
	}
	
	public String getName() {
		return name;
	}

	public Float getHeight() {
		return height;
	}

	public Float getBmi() {
		return bmi;
	}

	public Integer getScores() {
		return scores;
	}

	public Integer getDefends() {
		return defends;
	}

	public boolean isFit() {
		return this.height >= minHeight && this.bmi <= maxBMI;
	}

	public boolean isStriker() {
		return this.scores >= minScoreStriker;
	}

	public boolean isDefender() {
		return this.defends >= minDefendDefender;
	}

	public static class PlayerBuilder {
		private String name;
		private Float height;
		private Float bmi;
		private Integer scores;
		private Integer defends;

		public PlayerBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public PlayerBuilder setHeight(Float height) {
			this.height = height;
			return this;
		}

		public PlayerBuilder setBmi(Float bmi) {
			this.bmi = bmi;
			return this;
		}

		public PlayerBuilder setScores(Integer scores) {
			this.scores = scores;
			return this;
		}

		public PlayerBuilder setDefends(Integer defends) {
			this.defends = defends;
			return this;
		}

		public Player build() {
			return new Player(name, height, bmi, scores, defends);
		}

	}
}
