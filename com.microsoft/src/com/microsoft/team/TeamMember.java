package com.microsoft.team;

public class TeamMember {
	
	private int TEAMMEMBERROLL_ID;
	
	private String TEAMMEMBERREQUEST_ACCEPTED;
	
	private Team TEAM_ID;
	
	private Users USERS_ID;

	public int getTEAMMEMBERROLL_ID() {
		return TEAMMEMBERROLL_ID;
	}

	public void setTEAMMEMBERROLL_ID(int tEAMMEMBERROLL_ID) {
		TEAMMEMBERROLL_ID = tEAMMEMBERROLL_ID;
	}

	public String getTEAMMEMBERREQUEST_ACCEPTED() {
		return TEAMMEMBERREQUEST_ACCEPTED;
	}

	public void setTEAMMEMBERREQUEST_ACCEPTED(String tEAMMEMBERREQUEST_ACCEPTED) {
		TEAMMEMBERREQUEST_ACCEPTED = tEAMMEMBERREQUEST_ACCEPTED;
	}

	public Team getTEAM_ID() {
		return TEAM_ID;
	}

	public void setTEAM_ID(Team tEAM_ID) {
		TEAM_ID = tEAM_ID;
	}

	public Users getUSERS_ID() {
		return USERS_ID;
	}

	public void setUSERS_ID(Users uSERS_ID) {
		USERS_ID = uSERS_ID;
	}
	
	

}
