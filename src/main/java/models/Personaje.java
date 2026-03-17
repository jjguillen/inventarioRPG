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
        this.equipo = new TreeMap<>(Comparator.comparing(TipoEquipamiento::toString));
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


    /**
     * Agrega un item al equipo del personaje
     * @param tipoEquipamiento
     * @param item
     */
    public void agregarEquipo(TipoEquipamiento tipoEquipamiento, Item item) {
        //No vamos a comprobar que el item esté en el inventario, asumimos que el usuario lo hace bien

        //Verificar que el item no esté ya en el equipo
        if (equipo.containsKey(tipoEquipamiento)) {
            //Mover el item al inventario
            Item antiguo = equipo.get(tipoEquipamiento);
            inventario.put(antiguo.getNombre(), antiguo);
        }
        //Poner el nuevo
        //ToDo - Habría que comprobar TipoItem para ver si puedo ponerlo donde corresponde
        equipo.put(tipoEquipamiento, item);
        //Eliminar el nuevo item del inventario
        inventario.remove(item.getNombre());

    }

    /**
     * Elimina un item del equipo del personaje, lo devolvemos al inventario
     * @param tipoEquipamiento
     */
    public void quitarEquipo(TipoEquipamiento tipoEquipamiento) {
        Item item = equipo.get(tipoEquipamiento);
        equipo.remove(tipoEquipamiento);
        inventario.put(item.getNombre(), item);
    }


    /**
     * Devuelve una lista con todos los items del equipo del personaje
     * @return Map.Entry<TipoEquipamiento, Item>
     */
    public List<Map.Entry<TipoEquipamiento, Item>> getEquipo() {
        return new ArrayList<>(equipo.entrySet());
    }





}
