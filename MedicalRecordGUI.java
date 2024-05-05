import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
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
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPatient();
            }
        });
        mainPanel.add(searchButton);

        JButton createButton = new JButton("Crear Historia Clínica");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPatient();
            }
        });
        mainPanel.add(createButton);

        add(mainPanel);
        setVisible(true);
    }

    private void searchPatient() {
        String doc = docField.getText();
        try {
            Patient patient = medicalRecord.getPatient(doc);
            JOptionPane.showMessageDialog(this, "Historia clínica encontrada:\n" + patient.toString());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "No se encontró la historia clínica para el documento proporcionado.");
        }
    }
    private void createPatient() {
        Patient patient = new Patient();
        JDialog dialog = new JDialog(this, "Ingresar Datos del Paciente", true);
        dialog.setSize(1080, 720);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new GridLayout(0, 2, 10, 10));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 10, 10));

        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMaximumFractionDigits(2);

        Field[] fields = Patient.class.getDeclaredFields();
        for (Field field : fields) {
            if(field.getName().equals("documento")) {
                patient.setDocumento(docField.getText());
                continue;
            }
            JLabel label = new JLabel(field.getName() + ":");
            field.setAccessible(true);
            if (field.getType() == boolean.class) {
                JCheckBox checkBox = new JCheckBox();
                mainPanel.add(label);
                mainPanel.add(checkBox);
                checkBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            field.set(patient, checkBox.isSelected());
                        } catch (IllegalAccessException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            } else {
                JTextField textField = new JTextField();
                mainPanel.add(label);
                mainPanel.add(textField);
                textField.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateField();
                    }
                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateField();
                    }
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateField();
                    }
                    private void updateField() {
                        try {
                            field.set(patient, textField.getText());
                        } catch (IllegalAccessException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
        }
        JButton confirmButton = new JButton("Aceptar");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    savePatientDataToFile(patient);
                    dialog.dispose();
                    JOptionPane.showMessageDialog(MedicalRecordGUI.this, "Historia clínica creada y guardada exitosamente.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        mainPanel.add(confirmButton);
        dialog.add(mainPanel);
        dialog.setVisible(true);
    }


    private void savePatientDataToFile(Patient patient) {
        medicalRecord.saveFile(patient);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MedicalRecordGUI();
            }
        });
    }
}
