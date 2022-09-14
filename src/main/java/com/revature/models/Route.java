package com.revature.models;

import java.util.Objects;

import annotations.GeneratedId;
import annotations.NonId;

public class Route {
	
	@GeneratedId(column=1)
	private int routeId;
	
	@NonId(column=2)
	private String routeName;
	
	@NonId(column=3)
	private int locationId;
	
	@NonId(column=4)
	private int difficulty;
	
	@NonId(column=5)
	private int length;

	public Route(int routeId, String routeName, int locationId, int difficulty, int length) {
		super();
		this.routeId = routeId;
		this.routeName = routeName;
		this.locationId = locationId;
		this.difficulty = difficulty;
		this.length = length;
	}

	public Route(String routeName, int locationId, int difficulty, int length) {
		super();
		this.routeName = routeName;
		this.locationId = locationId;
		this.difficulty = difficulty;
		this.length = length;
	}

	public Route() {
		super();
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		return Objects.hash(difficulty, length, locationId, routeId, routeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		return difficulty == other.difficulty && length == other.length && locationId == other.locationId
				&& routeId == other.routeId && Objects.equals(routeName, other.routeName);
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeName=" + routeName + ", locationId=" + locationId + ", difficulty="
				+ difficulty + ", length=" + length + "]";
	}
	
	
	
	
	
}
