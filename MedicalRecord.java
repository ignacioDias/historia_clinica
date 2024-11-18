import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MedicalRecord {
    private Map<String, Patient> patients = new HashMap<>();

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
                String[] parts = line.split(":", 2); // Limita el split para evitar errores si el valor tiene ":"
                if (parts.length < 2) continue; // Salta líneas mal formateadas
                String fieldName = parts[0].trim();
                String fieldValue = parts[1].trim();

                switch (fieldName) {
                    case "nombre":
                        patient.nombre = fieldValue;
                        break;
                    case "documento":
                        patient.documento = fieldValue;
                        break;
                    case "peso":
                        patient.peso = fieldValue;
                        break;
                    case "altura":
                        patient.altura = fieldValue;
                        break;
                    case "motivoConsulta":
                        patient.motivoConsulta = fieldValue;
                        break;
                    case "historialDeEnfermedades":
                        patient.historialDeEnfermedades = fieldValue;
                        break;
                    case "examinacionFisica":
                        patient.examinacionFisica = fieldValue;
                        break;
                    case "examenesComplementarios":
                        patient.examenesComplementarios = fieldValue;
                        break;
                    case "CSV_TA":
                        patient.CSV_TA = fieldValue;
                        break;
                    case "FC":
                        patient.FC = fieldValue;
                        break;
                    case "Temp":
                        patient.Temp = fieldValue;
                        break;
                    case "SaturO2":
                        patient.SaturO2 = fieldValue;
                        break;
                    case "Glasgow":
                        patient.Glasgow = fieldValue;
                        break;
                    case "Tratamiento":
                        patient.Tratamiento = fieldValue;
                        break;
                    case "Evolucion":
                        patient.Evolucion = fieldValue;
                        break;
                    case "estudiosSolicitados":
                        patient.estudiosSolicitados = fieldValue;
                        break;
                    case "perimCefalico":
                        patient.perimCefalico = fieldValue;
                        break;
                    case "ObstetriciaFum":
                        patient.ObstetriciaFum = fieldValue;
                        break;
                    case "colesterol":
                        patient.colesterol = fieldValue;
                        break;
                    case "glucemia":
                        patient.glucemia = fieldValue;
                        break;
                    case "circunsferenciaCintura":
                        patient.circunsferenciaCintura = fieldValue;
                        break;
                    case "fumador":
                        patient.fumador = Boolean.parseBoolean(fieldValue);
                        break;
                    case "diabetico":
                        patient.diabetico = Boolean.parseBoolean(fieldValue);
                        break;
                    case "hipertenso":
                        patient.hipertenso = Boolean.parseBoolean(fieldValue);
                        break;
                }
            }
            patients.put(patient.documento, patient);
        } catch (IOException e) {
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
            String fileName = patient.nombre.replaceAll("\\s+", "_") + ".txt";
            FileWriter writer = new FileWriter(fileName);

            writer.write("nombre:" + patient.nombre + "\n");
            writer.write("documento:" + patient.documento + "\n");
            writer.write("peso:" + patient.peso + "\n");
            writer.write("altura:" + patient.altura + "\n");
            writer.write("motivoConsulta:" + patient.motivoConsulta + "\n");
            writer.write("historialDeEnfermedades:" + patient.historialDeEnfermedades + "\n");
            writer.write("examinacionFisica:" + patient.examinacionFisica + "\n");
            writer.write("examenesComplementarios:" + patient.examenesComplementarios + "\n");
            writer.write("CSV_TA:" + patient.CSV_TA + "\n");
            writer.write("FC:" + patient.FC + "\n");
            writer.write("Temp:" + patient.Temp + "\n");
            writer.write("SaturO2:" + patient.SaturO2 + "\n");
            writer.write("Glasgow:" + patient.Glasgow + "\n");
            writer.write("Tratamiento:" + patient.Tratamiento + "\n");
            writer.write("Evolucion:" + patient.Evolucion + "\n");
            writer.write("estudiosSolicitados:" + patient.estudiosSolicitados + "\n");
            writer.write("perimCefalico:" + patient.perimCefalico + "\n");
            writer.write("ObstetriciaFum:" + patient.ObstetriciaFum + "\n");
            writer.write("colesterol:" + patient.colesterol + "\n");
            writer.write("glucemia:" + patient.glucemia + "\n");
            writer.write("circunsferenciaCintura:" + patient.circunsferenciaCintura + "\n");
            writer.write("fumador:" + patient.fumador + "\n");
            writer.write("diabetico:" + patient.diabetico + "\n");
            writer.write("hipertenso:" + patient.hipertenso + "\n");

            writer.close();
            patients.put(patient.documento, patient);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos del paciente: " + e.getMessage());
        }
    }
}
