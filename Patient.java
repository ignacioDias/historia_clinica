public class Patient {
    private String nombre;
    private String documento;
    private String peso;
    private String altura;   private String motivoConsulta;
    private String historialDeEnfermedades;
    private String examinacionFisica;
    private String examenesComplementarios;
    private String CSV_TA;
    private String FC;
    private String Temp;
    private String SaturO2;
    private String Glasgow;
    private String Tratamiento;
    private String Evolucion;
    private String estudiosSolicitados;
    private String perimCefalico;
    private String ObstetriciaFum;
    private String colesterol;
    private String glucemia;
    private String circunsferenciaCintura;
    private boolean fumador;
    private boolean diabetico;
    private boolean hipertenso;


    public Patient() {
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getDocumento() {
        return documento;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getAltura() {
        return altura;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }
    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }
    public String getHistorialDeEnfermedades() {
        return historialDeEnfermedades;
    }
    public void setHistorialDeEnfermedades(String historialDeEnfermedades) {
        this.historialDeEnfermedades = historialDeEnfermedades;
    }
    public String getExaminacionFisica() {
        return examinacionFisica;
    }
    public void setExaminacionFisica(String examinacionFisica) {
        this.examinacionFisica = examinacionFisica;
    }
    public String getExamenesComplementarios() {
        return examenesComplementarios;
    }
    public void setExamenesComplementarios(String examenesComplementarios) {
        this.examenesComplementarios = examenesComplementarios;
    }
    public String getCSV_TA() {
        return CSV_TA;
    }
    public void setCSV_TA(String CSV_TA) {
        this.CSV_TA = CSV_TA;
    }
    public String getFC() {
        return FC;
    }
    public void setFC(String FC) {
        this.FC = FC;
    }
    public String getTemp() {
        return Temp;
    }
    public void setTemp(String temp) {
        this.Temp = temp;
    }
    public String getSaturO2() {
        return SaturO2;
    }
    public void setSaturO2(String saturO2) {
        this.SaturO2 = saturO2;
    }
    public String getGlasgow() {
        return Glasgow;
    }
    public void setGlasgow(String glasgow) {
        this.Glasgow = glasgow;
    }
    public String getTratamiento() {
        return Tratamiento;
    }
    public void setTratamiento(String tratamiento) {
        this.Tratamiento = tratamiento;
    }
    public String getEvolucion() {
        return Evolucion;
    }
    public void setEvolucion(String evolucion) {
        this.Evolucion = evolucion;
    }
    public String getEstudiosSolicitados() {
        return estudiosSolicitados;
    }
    public void setEstudiosSolicitados(String estudiosSolicitados) {
        this.estudiosSolicitados = estudiosSolicitados;
    }
    public String getPerimCefalico() {
        return perimCefalico;
    }
    public void setPerimCefalico(String perimCefalico) {
        this.perimCefalico = perimCefalico;
    }
    public String getObstetriciaFum() {
        return ObstetriciaFum;
    }
    public void setObstetriciaFum(String obstetriciaFum) {
        this.ObstetriciaFum = obstetriciaFum;
    }
    public String getColesterol() {
        return colesterol;
    }
    public void setColesterol(String colesterol) {
        this.colesterol = colesterol;
    }
    public String getGlucemia() {
        return glucemia;
    }
    public void setGlucemia(String glucemia) {
        this.glucemia = glucemia;
    }
    public String getCircunsferenciaCintura() {
        return circunsferenciaCintura;
    }
    public void setCircunsferenciaCintura(String circunsferenciaCintura) {
        this.circunsferenciaCintura = circunsferenciaCintura;
    }
    public boolean isFumador() {
        return fumador;
    }
    public void setFumador(boolean isSmoker) {
        this.fumador = isSmoker;
    }
    public boolean isDiabetico() {
        return diabetico;
    }
    public void setDiabetico(boolean isDiabetic) {
        this.diabetico = isDiabetic;
    }
    public boolean isHipertenso() {
        return hipertenso;
    }
    public void setHipertenso(boolean isHypertensive) {
        this.hipertenso = isHypertensive;
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
        if(fumador)
            output.append("Fumador: Sí").append("\n");
        else
            output.append("Fumador: No").append("\n");
        if(diabetico)
            output.append("Diabetico: Sí").append("\n");
        else
            output.append("Diabetico: No").append("\n");
        if(hipertenso)
            output.append("Hipertenso: Sí").append("\n");
        else
            output.append("Hipertenso: No").append("\n");
        return output.toString();
    }
}