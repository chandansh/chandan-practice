package com.test.chandan.client;

public class StateInfo {
	private String stateName;
	private String[] cities;

	public StateInfo(String stateName, String[] cities) {
		this.stateName = stateName;
		this.cities = cities;
	}

	public String getStateName() {
		return (stateName);
	}

	public String[] getCities() {
		return (cities);
	}

	private static String[] mdCities = { "Patna", "Munger",
			"Bhagalpur", "Darbhanga" };
	private static String[] vaCities = { "Lucknow", "Kanpur",
			"Noida", "Allahabad" };
	private static String[] paCities = { "Kolkata", "Durgapur",
			"khardagpur", "Malda" };
	private static String[] njCities = { "Mumbai", "Nagpur", "Pune",
			"Naisk" };
	private static String[] nyCities = { "Jaipur", "Ajmer", "Udaipur",
			"Jodhpur" };
	
	
	private static StateInfo[] nearbyStates = {
			new StateInfo("Bihar", mdCities),
			new StateInfo("U.P", vaCities),
			new StateInfo("West bangal", paCities),
			new StateInfo("Maharastra", njCities),
			new StateInfo("Rajasthan", nyCities) 
			};

	public static StateInfo[] getNearbyStates() {
		return (nearbyStates);
	}

	public static String[] findCities(StateInfo[] states, String stateName) {
		for (StateInfo state : states) {
			if (state.getStateName().equals(stateName)) {
				return (state.getCities());
			}
		}
		String[] unknown = { "Unknown state" };
		return (unknown);
	}
}
