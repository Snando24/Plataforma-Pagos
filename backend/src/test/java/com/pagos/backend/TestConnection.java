package com.pagos.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) {
		try {
			// Registrar el controlador PostgreSQL
			Class.forName("org.postgresql.Driver");

			// Establecer la conexión
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/plataformapagos",
					"pagos",
					"pagos");

			System.out.println("Conexión exitosa");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
