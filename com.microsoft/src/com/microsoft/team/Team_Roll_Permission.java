package com.microsoft.team;

public class Team_Roll_Permission {
	
	private Team TEAM_ID;
	
	private Role ROLL_ID;
	
	private Permission PERMISSION_ID;

	public Team getTEAM_ID() {
		return TEAM_ID;
	}

	public void setTEAM_ID(Team tEAM_ID) {
		TEAM_ID = tEAM_ID;
	}

	public Role getROLL_ID() {
		return ROLL_ID;
	}

	public void setROLL_ID(Role rOLL_ID) {
		ROLL_ID = rOLL_ID;
	}

	public Permission getPERMISSION_ID() {
		return PERMISSION_ID;
	}

	public void setPERMISSION_ID(Permission pERMISSION_ID) {
		PERMISSION_ID = pERMISSION_ID;
	}
	

}
