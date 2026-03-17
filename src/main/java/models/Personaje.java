package models;

import lombok.Getter;

import java.util.*;

@Getter
public class Personaje {

    private String nombre;
    private Map<String, Item> inventario;
    private Map<TipoEquipamiento, Item> equipo;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.inventario = new HashMap<>();
        this.equipo = new TreeMap<>();
    }

    /**
     * Agrega un item al inventario del personaje
     * Usamos como clave el nombre del item
     * @param item
     */
    public void agregarItemInventario(Item item) {
        this.inventario.put(item.getNombre(), item);
    }

    /**
     * Elimina un item del inventario del personaje
     * @param nombreItem
     */
    public void eliminarItemInventario(String nombreItem) {
        this.inventario.remove(nombreItem);
    }

    /**
     * Devuelve una lista con todos los items del inventario del personaje
     * @return
     */
    public List<Item> getInventario() {
        return new ArrayList<>(inventario.values());
    }

    /**
     * Busca un item en el inventario del personaje por su nombre
     * @param nombreItem
     * @return Item o null si no se encuentra
     */
    public Item buscarItem(String nombreItem) {
        return inventario.get(nombreItem);
    }
}
