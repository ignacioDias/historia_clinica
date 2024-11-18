import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class MedicalRecordGUI extends JFrame {
    private static MedicalRecord medicalRecord = new MedicalRecord();
    private JTextField docField;

    public MedicalRecordGUI() {
        setTitle("Sistema de Gestión de Historias Clínicas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel docLabel = new JLabel("Documento:");
        docField = new JTextField();
        mainPanel.add(docLabel);
        mainPanel.add(docField);

        JButton searchButton = new JButton("Buscar Historia Clínica");
        searchButton.addActionListener(e -> searchPatient());
        mainPanel.add(searchButton);

        JButton createButton = new JButton("Crear Historia Clínica");
        createButton.addActionListener(e -> createPatient());
        mainPanel.add(createButton);

        add(mainPanel);
        setVisible(true);
    }

    private void searchPatient() {
        String doc = docField.getText();
        try {
            Patient patient = medicalRecord.getPatient(doc);
            JOptionPane.showMessageDialog(this, "Historia clínica encontrada:\n" + patient);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "No se encontró la historia clínica para el documento proporcionado.");
        }
    }

    private void createPatient() {
        Patient patient = new Patient();
        patient.documento = docField.getText(); // Establecemos el documento directamente.

        JDialog dialog = new JDialog(this, "Ingresar Datos del Paciente", true);
        dialog.setSize(1080, 720);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new GridLayout(0, 2, 10, 10));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 10, 10));

        // Añadir campos del paciente como componentes del formulario.
        mainPanel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        mainPanel.add(nombreField);

        mainPanel.add(new JLabel("Peso:"));
        JTextField pesoField = new JTextField();
        mainPanel.add(pesoField);

        mainPanel.add(new JLabel("Altura:"));
        JTextField alturaField = new JTextField();
        mainPanel.add(alturaField);

        mainPanel.add(new JLabel("Motivo de Consulta:"));
        JTextField motivoField = new JTextField();
        mainPanel.add(motivoField);

        mainPanel.add(new JLabel("Fumador:"));
        JCheckBox fumadorCheckbox = new JCheckBox();
        mainPanel.add(fumadorCheckbox);

        // Botón de confirmación
        JButton confirmButton = new JButton("Aceptar");
        confirmButton.addActionListener(e -> {
            // Asignamos los valores ingresados directamente al objeto paciente.
            patient.nombre = nombreField.getText();
            patient.peso = pesoField.getText();
            patient.altura = alturaField.getText();
            patient.motivoConsulta = motivoField.getText();
            patient.fumador = fumadorCheckbox.isSelected();

            // Guardamos los datos del paciente.
            savePatientDataToFile(patient);
            dialog.dispose();
            JOptionPane.showMessageDialog(this, "Historia clínica creada y guardada exitosamente.");
        });

        mainPanel.add(confirmButton);
        dialog.add(mainPanel);
        dialog.setVisible(true);
    }

    private void savePatientDataToFile(Patient patient) {
        medicalRecord.saveFile(patient);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MedicalRecordGUI());
    }
}
