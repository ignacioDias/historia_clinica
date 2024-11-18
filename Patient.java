public class Patient {
    public String nombre;
    public String documento;
    public String peso;
    public String altura;   
    public String motivoConsulta;
    public String historialDeEnfermedades;
    public String examinacionFisica;
    public String examenesComplementarios;
    public String CSV_TA;
    public String FC;
    public String Temp;
    public String SaturO2;
    public String Glasgow;
    public String Tratamiento;
    public String Evolucion;
    public String estudiosSolicitados;
    public String perimCefalico;
    public String ObstetriciaFum;
    public String colesterol;
    public String glucemia;
    public String circunsferenciaCintura;
    public boolean fumador;
    public boolean diabetico;
    public boolean hipertenso;

    public Patient() {
    }

@Override
public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("Nombre: ").append(nombre).append("\n")
          .append("Documento: ").append(documento).append("\n")
          .append("Peso: ").append(peso).append("\n")
          .append("Altura: ").append(altura).append("\n")
          .append("Motivo de Consulta: ").append(motivoConsulta).append("\n")
          .append("Historial de Enfermedades: ").append(historialDeEnfermedades).append("\n")
          .append("Examinación Física: ").append(examinacionFisica).append("\n")
          .append("Exámenes Complementarios: ").append(examenesComplementarios).append("\n")
          .append("CSV_TA: ").append(CSV_TA).append("\n")
          .append("FC: ").append(FC).append("\n")
          .append("Temperatura: ").append(Temp).append("\n")
          .append("Saturación de O2: ").append(SaturO2).append("\n")
          .append("Glasgow: ").append(Glasgow).append("\n")
          .append("Tratamiento: ").append(Tratamiento).append("\n")
          .append("Evolución: ").append(Evolucion).append("\n")
          .append("Estudios Solicitados: ").append(estudiosSolicitados).append("\n")
          .append("Perímetro Cefálico: ").append(perimCefalico).append("\n")
          .append("Obstetricia FUM: ").append(ObstetriciaFum).append("\n")
          .append("Colesterol: ").append(colesterol).append("\n")
          .append("Glucemia: ").append(glucemia).append("\n")
          .append("Circunferencia de Cintura: ").append(circunsferenciaCintura).append("\n");

    String[] booleanAttributes = {
        "Fumador: " + (fumador ? "Sí" : "No"),
        "Diabético: " + (diabetico ? "Sí" : "No"),
        "Hipertenso: " + (hipertenso ? "Sí" : "No")
    };

    for (String attr : booleanAttributes) {
        output.append(attr).append("\n");
    }

    return output.toString();
}

}
