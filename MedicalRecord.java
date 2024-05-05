package historia_clinica;

import historia_clinica.patient.Patient;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;

public class MedicalRecord {
    private Map<String, Patient> patients = new HashMap<String, Patient>();
    public MedicalRecord() {
    }
    public void addPatient(Patient patient) {
        patients.put(patient.getDoc(), patient);
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
                writer.write(field.getName() + ":" + field+ "\n");
            }
            writer.close();
            patients.put(patient.getDoc(),patient);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos del paciente: " + e.getMessage());
        }
    }
}
