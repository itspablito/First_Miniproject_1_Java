    package Soldados;
    import Rango.Rango;
    import Interfaz.OperacionesMilitares;

    public class Teniente extends Rango implements OperacionesMilitares { 
        private String unidad;

        public Teniente(int rango) {
            super(3); 
            System.out.println("Teniente");
        }
        public void mostrarUnidad(String unidad){
            this.unidad = unidad;
        }
        public void mostrarRango() {
            System.out.println("Rango: Teniente");
        }

        public void mostrarUnidad() {
            System.out.println("Unidad: " + unidad);
        }

        @Override
        public void realizarAccion() {
            System.out.println("Realizando Accion");
        }

        @Override
        public void asignarMision(String mision) {
            System.out.println("Mision: " + mision);
        }

        @Override
        public void reportarEstado() {
            System.out.println("Reportando Estado");
        }
        
        
    }
