package com.microsoft.team;

public class Team {
	private int TEAM_ID;
	
	private TeamType TEAMTYPE_ID;
	
	private String TEAM_NAME;
	
    private String TEAM_DESC;
    
    private int TEAM_CODE;
    
    private String TEAM_IMAGE = "C:\\Users\\Haier\\Desktop";

	public int getTEAM_ID() {
		return TEAM_ID;
	}

	public TeamType getTEAMTYPE_ID() {
		return TEAMTYPE_ID;
	}

	public String getTEAM_NAME() {
		return TEAM_NAME;
	}

	public String getTEAM_DESC() {
		return TEAM_DESC;
	}

	public int getTEAM_CODE() {
		return TEAM_CODE;
	}

	public String getTEAM_IMAGE() {
		return TEAM_IMAGE;
	}
    
	
}
