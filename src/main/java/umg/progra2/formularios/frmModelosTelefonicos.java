package umg.progra2.formularios;

import umg.progra2.baseDatos.Model.ModeloTelefonico;
import umg.progra2.baseDatos.Service.ModeloTelefonicoService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class frmModelosTelefonicos {
    private JLabel frmCarne;
    private JPanel JframeModelos;
    private JLabel lblTitulo;
    private JLabel lblId;
    private JLabel lblMarca;
    private JLabel lblCamaraPrincipal;
    private JLabel lblCamaraFrontal;
    private JLabel lblPaisOrigen;
    private JTextField textFieldId;
    private JTextField textFieldMarca;
    private JTextField textFieldCamaraPrincipal;
    private JTextField textFieldCamaraFrontal;
    private JButton buttonIngresar;
    private JButton buttonActualizar;
    private JComboBox comboBoxPaisOrigen;
    private JButton buttonBuscarPorId;
    private JButton buttonEliminar;

    public static void main(String[] args) {
        JFrame frame = new JFrame("frmModelosTelefonicos");
        frame.setContentPane(new frmModelosTelefonicos().JframeModelos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public frmModelosTelefonicos() {

        comboBoxPaisOrigen.addItem("Guatemala");
        comboBoxPaisOrigen.addItem("México");
        comboBoxPaisOrigen.addItem("Estados Unidos");
        comboBoxPaisOrigen.addItem("Alemania");
        comboBoxPaisOrigen.addItem("Japón");
        comboBoxPaisOrigen.addItem("Corea del Sur");
        comboBoxPaisOrigen.addItem("China");
        comboBoxPaisOrigen.addItem("Brasil");
        comboBoxPaisOrigen.addItem("Argentina");
        comboBoxPaisOrigen.addItem("España");

        buttonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloTelefonico modelo = new ModeloTelefonico();
                modelo.setId(Integer.parseInt(textFieldId.getText()));
                modelo.setMarca(textFieldMarca.getText());
                modelo.setCamaraFrontal(Integer.parseInt(textFieldCamaraFrontal.getText()));
                modelo.setCamaraPrincipal(Integer.parseInt(textFieldCamaraPrincipal.getText()));
                modelo.setPaisOrigen(comboBoxPaisOrigen.getSelectedItem().toString());

                try{
                    new ModeloTelefonicoService().agregarModelo(modelo);
                    JOptionPane.showMessageDialog(null, "Modelo Telefonico creado exitosamente");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Ups hay clavo con la db:" +ex.getMessage());
                }
            }
        });
        buttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloTelefonico modelo = new ModeloTelefonico();

                modelo.setId(Integer.parseInt(textFieldId.getText()));
                modelo.setMarca(textFieldMarca.getText());
                modelo.setCamaraPrincipal(Integer.parseInt(textFieldCamaraPrincipal.getText()));
                modelo.setCamaraFrontal(Integer.parseInt(textFieldCamaraFrontal.getText()));
                modelo.setPaisOrigen(comboBoxPaisOrigen.getSelectedItem().toString());

                try{
                    new ModeloTelefonicoService().actualizarModelo(modelo);
                    JOptionPane.showMessageDialog(null, "Equipo Actualizado exitosamente");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Ups hay clavo con la db:" +ex.getMessage());
                }
            }
        });
        buttonBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Buscar por id
                ModeloTelefonico modelo = new ModeloTelefonico();
                int id = textFieldId.getText().isEmpty() ? 0 : Integer.parseInt(textFieldId.getText());

                try{
                    ModeloTelefonico modeloEncontrado = new ModeloTelefonicoService().obtenerModeloPorId(id);
                    if(modeloEncontrado != null){
                        textFieldId.setText(String.valueOf(modeloEncontrado.getId()));
                        textFieldMarca.setText(modeloEncontrado.getMarca());
                        textFieldCamaraFrontal.setText(String.valueOf(modeloEncontrado.getCamaraFrontal()));
                        textFieldCamaraPrincipal.setText(String.valueOf(modeloEncontrado.getCamaraPrincipal()));
                        comboBoxPaisOrigen.setSelectedItem(modeloEncontrado.getPaisOrigen());

                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el Modelo");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Hay erro en db:" +ex.getMessage());
                }
            }
        });
        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = textFieldId.getText().isEmpty() ? 0 : Integer.parseInt(textFieldId.getText());
                try {
                    // Llamar al servicio para eliminar los datos
                    boolean eliminado = new ModeloTelefonicoService().eliminarModelo(id);

                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Modelo eliminado exitosamente");

                        textFieldId.setText("");
                        textFieldMarca.setText("");
                        textFieldCamaraFrontal.setText("");
                        textFieldCamaraPrincipal.setText("");
                        comboBoxPaisOrigen.removeAllItems();

                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el modelo para eliminar");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el equipo: " + ex.getMessage());
                }

            }
        });
    }
}
