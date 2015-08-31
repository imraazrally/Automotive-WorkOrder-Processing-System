package com.imraazrally.autoshop.model.vehicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImportVehiclesFromDbUsingCustomerId {
	private final Connection dbConnection;
	private final int customerId;
	private final VehicleStorage vehicleStorage;
	
	public ImportVehiclesFromDbUsingCustomerId(Connection dbConnection, int customerId){
		this.dbConnection=dbConnection;
		this.customerId=customerId;
		vehicleStorage=new VehicleStorage();
		importVehiclesFromDb();
	}
	
	public void importVehiclesFromDb(){
		String query=String.format(VehicleConsts.IMPORT_VEHICLE_QUERY,Integer.toString(customerId));
		try{
			ResultSet results=dbConnection.createStatement().executeQuery(query);
			while (results.next()) addVehicle(results);
		}catch(Exception e){e.printStackTrace();}
	}
	
	public void addVehicle(ResultSet results) throws SQLException{
		Year year=new Year(results.getString("year"));
		Make make=new Make(results.getString("make"));
		Model model=new Model(results.getString("model"));
		EngineSize engine=new EngineSize(results.getString("cylinders"), results.getString("cc"));
		//Creating Vehicle 
		Vehicle vehicle=new Vehicle(new VehicleInfo(year,make,model,engine));
		vehicleStorage.add(vehicle);
	}
	
	public VehicleStorage getVehicleStorage(){
		return vehicleStorage;
	}
	
}
