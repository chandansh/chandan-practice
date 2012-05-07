package com.springinaction.test;

public class KnightOfTheRoundTable implements Knight {
	private String name;
	private Quest quest;
	private KnightLogger logger;

	public KnightLogger getLogger() {
		return logger;
	}

	public void setLogger(KnightLogger logger) {
		this.logger = logger;
	}

	public Quest getQuest() {
		return quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

	public KnightOfTheRoundTable(String name) {
		this.name = name;
	}

	@Override
	public void embarkOnQuest() {
		//logger.singBefore(this);
		System.out.println(quest.embark());
		//logger.singAfter(this);

	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
