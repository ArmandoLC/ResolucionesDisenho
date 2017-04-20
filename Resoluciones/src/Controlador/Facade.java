package Controlador;

public abstract class Facade implements ISolicitud {

    protected final ControladorPrincipal ctrl;

    public Facade() {
        this.ctrl = new ControladorPrincipal();
    }
}
