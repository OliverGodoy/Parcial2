package umg.progra2.baseDatos.Dao;

import umg.progra2.baseDatos.Conexion.Conexion;
import umg.progra2.baseDatos.Model.ModeloTelefonico;

import java.sql.*;

public class ModeloTelefonicoDAO {

    public void agregarModelo(ModeloTelefonico modelo) {
        String query = "INSERT INTO modelos_telefonicos (marca, camara_principal, camara_frontal, pais_origen) VALUES (?, ?, ?, ?)";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, modelo.getMarca());
            statement.setObject(2, modelo.getCamaraPrincipal(), Types.INTEGER);
            statement.setObject(3, modelo.getCamaraFrontal(), Types.INTEGER);
            statement.setString(4, modelo.getPaisOrigen());
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ModeloTelefonico obtenerModeloPorId(int id) {
        String query = "SELECT * FROM modelos_telefonicos WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ModeloTelefonico modelo = new ModeloTelefonico();
                    modelo.setId(rs.getInt("id"));
                    modelo.setMarca(rs.getString("marca"));
                    modelo.setCamaraPrincipal(rs.getInt("camara_principal"));
                    modelo.setCamaraFrontal(rs.getInt("camara_frontal"));
                    modelo.setPaisOrigen(rs.getString("pais_origen"));
                    return modelo;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void actualizarModelo(ModeloTelefonico modelo) {
        String query = "UPDATE modelos_telefonicos SET marca = ?, camara_principal = ?, camara_frontal = ?, pais_origen = ? WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, modelo.getMarca());
            ps.setObject(2, modelo.getCamaraPrincipal(), Types.INTEGER);
            ps.setObject(3, modelo.getCamaraFrontal(), Types.INTEGER);
            ps.setString(4, modelo.getPaisOrigen());
            ps.setInt(5, modelo.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean eliminarModelo(int id) {
        String query = "DELETE FROM modelos_telefonicos WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
