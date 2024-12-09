import java.util.List;

public enum Tarea {
    RECONOCIMIENTO, GUARDIA, RESCATE, 
    LIDERAZGO, ESTRATEGIA, ADMINISTRACION,
    ENTRENAMIENTO, INTELIGENCIA, SUPERVISION;


    public static List<Tarea> getTareasPorRango(int rango) {
        switch (rango) {
            case 1: 
                return List.of(RECONOCIMIENTO, GUARDIA, RESCATE);
            case 2: 
                return List.of(LIDERAZGO, ESTRATEGIA, ADMINISTRACION);
            case 3: 
                return List.of(ENTRENAMIENTO, INTELIGENCIA, SUPERVISION);
            case 4: 
                return List.of(LIDERAZGO, ENTRENAMIENTO, GUARDIA);
            default:
                return List.of();
        }
    }
}
