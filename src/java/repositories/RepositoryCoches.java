package repositories;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Coche;

public class RepositoryCoches {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        String cadena
                = "jdbc:sqlserver://sqlserverjavapgs.database.windows.net:1433;databaseName=SQLAZURE";
        Connection cn
                = DriverManager.getConnection(cadena, "adminsql", "Admin123");
        return cn;
    }

    public List<Coche> getCoches() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from coches";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Coche> coches = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("IDCOCHE");
            String marca = rs.getString("MARCA");
            String modelo = rs.getString("MODELO");
            String conductor = rs.getString("CONDUCTOR");
            String imagen = rs.getString("IMAGEN");
            Coche car = new Coche(id, marca, modelo, conductor, imagen);
            coches.add(car);
        }
        rs.close();
        cn.close();
        return coches;
    }

    public Coche findCoche(int id) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from coches where idcoche=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int idcoche = rs.getInt("IDCOCHE");
            String marca = rs.getString("MARCA");
            String modelo = rs.getString("MODELO");
            String conductor = rs.getString("CONDUCTOR");
            String imagen = rs.getString("IMAGEN");
            rs.close();
            cn.close();
            Coche car = new Coche(idcoche, marca, modelo, conductor, imagen);
            return car;
        } else {
            rs.close();
            cn.close();
            return null;
        }
    }
}
