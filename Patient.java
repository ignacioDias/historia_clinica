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
        output.append("Nombre: ").append(nombre).append("\n");
        output.append("Documento: ").append(documento).append("\n");
        output.append("Peso: ").append(peso).append("\n");
        output.append("Altura: ").append(altura).append("\n");
        output.append("Motivo de Consulta: ").append(motivoConsulta).append("\n");
        output.append("Historial de Enfermedades: ").append(historialDeEnfermedades).append("\n");
        output.append("Examinación Física: ").append(examinacionFisica).append("\n");
        output.append("Examenes Complementarios: ").append(examenesComplementarios).append("\n");
        output.append("CSV_TA: ").append(CSV_TA).append("\n");
        output.append("FC: ").append(FC).append("\n");
        output.append("Temp: ").append(Temp).append("\n");
        output.append("SaturO2: ").append(SaturO2).append("\n");
        output.append("Glasgow: ").append(Glasgow).append("\n");
        output.append("Tratamiento: ").append(Tratamiento).append("\n");
        output.append("Evolucion: ").append(Evolucion).append("\n");
        output.append("Estudios Solicitados: ").append(estudiosSolicitados).append("\n");
        output.append("Perimetro Cefálico: ").append(perimCefalico).append("\n");
        output.append("Obstetricia Fum: ").append(ObstetriciaFum).append("\n");
        output.append("Colesterol: ").append(colesterol).append("\n");
        output.append("Glucemia: ").append(glucemia).append("\n");
        output.append("Circunferencia de Cintura: ").append(circunsferenciaCintura).append("\n");
        if (fumador)
            output.append("Fumador: Sí").append("\n");
        else
            output.append("Fumador: No").append("\n");
        if (diabetico)
            output.append("Diabetico: Sí").append("\n");
        else
            output.append("Diabetico: No").append("\n");
        if (hipertenso)
            output.append("Hipertenso: Sí").append("\n");
        else
            output.append("Hipertenso: No").append("\n");
        return output.toString();
    }
}
