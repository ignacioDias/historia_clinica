import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MedicalRecord {
    private Map<String, Patient> patients = new HashMap<String, Patient>();
    public MedicalRecord() {
        loadAllPatients();
    }
    private void loadAllPatients() {
        File folder = new File(".");
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                loadPatientFromFile(file);
            }
        }
    }

    private void loadPatientFromFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            Patient patient = new Patient();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                String fieldName = parts[0];
                String fieldValue = parts[1];
                Field field = Patient.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                if (field.getType() == boolean.class) {
                    field.set(patient, Boolean.parseBoolean(fieldValue));
                } else {
                    field.set(patient, fieldValue);
                }
            }
            patients.put(patient.getDocumento(), patient);
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Error al cargar los datos del paciente: " + e.getMessage());
        }
    }

    public Patient getPatient(String doc) {
        if (patients.containsKey(doc))
            return patients.get(doc);
        throw new IllegalArgumentException("Patient not found");
    }
    public void saveFile(Patient patient) {
        try {
            String fileName = patient.getNombre().replaceAll("\\s+", "_") + ".txt";
            FileWriter writer = new FileWriter(fileName);
            Field[] fields = Patient.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                writer.write(field.getName() + ":" + field.get(patient) + "\n");
            }
            writer.close();
            patients.put(patient.getDocumento(),patient);
        } catch (IOException | IllegalAccessException e) {
            System.out.println("Error al guardar los datos del paciente: " + e.getMessage());
        }
    }
}
