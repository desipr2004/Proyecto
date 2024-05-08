package org.example.ApliCanvas;

// Un objeto que sea "Tickable" es un objeto que está interesado
// en saber cómo van pasando unidades de tiempo.
// Por CADA UNA de estas unidades de tiempo, yo tengo la
// obligación de llamar a su método tick().
// El objeto, a su vez, actualizará su estado interno en el método
// (ubicación//movimiento, puntuaciones, etc.).

import org.example.PkDemoBolas.Pala;

public interface Tickable {
    public void tick(Pala pala1, Pala pala2);
}