package umg.progra2.baseDatos.Service;

import umg.progra2.baseDatos.Dao.ModeloTelefonicoDAO;
import umg.progra2.baseDatos.Model.ModeloTelefonico;

public class ModeloTelefonicoService {

    private final ModeloTelefonicoDAO modeloTelefonicoDAO = new ModeloTelefonicoDAO();

    public void agregarModelo(ModeloTelefonico modelo) {
        modeloTelefonicoDAO.agregarModelo(modelo);
    }

    public ModeloTelefonico obtenerModeloPorId(int id) {
        return modeloTelefonicoDAO.obtenerModeloPorId(id);
    }

    public void actualizarModelo(ModeloTelefonico modelo) {
        modeloTelefonicoDAO.actualizarModelo(modelo);
    }

    public boolean eliminarModelo(int id) {
        return modeloTelefonicoDAO.eliminarModelo(id);
    }
}
