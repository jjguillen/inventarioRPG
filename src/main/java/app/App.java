package app;

import models.Item;
import models.Personaje;
import models.TipoEquipamiento;
import models.TipoItem;

import java.util.Map;

public class App {
    static void main() {

        Personaje personaje = new Personaje("Gandalf");
        personaje.agregarItemInventario(
                new Item("Vara troncho", "Una vara mágica poderosa",
                        10, TipoItem.ARMA));
        personaje.agregarItemInventario(
                new Item("Capa blanca", "Capa de mago blanco",
                        7, TipoItem.ARMADURA));
        personaje.agregarItemInventario(
                new Item("Vino de la comarca", "Ejem",
                        1, TipoItem.CONSUMIBLE));
        personaje.agregarItemInventario(
                new Item("Botas de Tom Bombadil", "Pedazo de botas no veas como corres",
                        3, TipoItem.ARMADURA));

        personaje.agregarEquipo(TipoEquipamiento.MANO_PRINCIPAL, personaje.buscarItem("Vara troncho"));
        personaje.agregarEquipo(TipoEquipamiento.PECHO, personaje.buscarItem("Capa blanca"));
        personaje.agregarEquipo(TipoEquipamiento.PIERNAS, personaje.buscarItem("Botas de Tom Bombadil"));

        IO.println("--- EQUIPO ---");
        for(Map.Entry<TipoEquipamiento, Item> entry : personaje.getEquipo()) {
            IO.println(entry.getKey() + ": " + entry.getValue());
        }

        IO.println("--- INVENTARIO ---");
        for(Item item : personaje.getInventario()) {
            IO.println(item);
        }



    }
}
