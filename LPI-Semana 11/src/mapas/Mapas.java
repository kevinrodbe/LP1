package mapas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Mapas {

    public static void main(String[] args) {
        {
            //Tiene una llave que identifica al objeto
            //Si se realiza un update es con elmismo codigo
            Map<Integer, String> mapa = new HashMap<Integer, String>();
            mapa.put(12, "Elba");
            mapa.put(13, "Elba");
            mapa.put(711, "Maria");
            mapa.put(9, "Sonia");
            mapa.put(9, "Grettna");

            Set<Integer> keys = mapa.keySet();
            Collection<String> values = mapa.values();
            Set data = mapa.entrySet();

            System.out.println("HashMap " + keys);
            System.out.println("HashMap " + values);
            System.out.println("HashMap " + data);


        }

        {
            //Tiene una llave que identifica al objeto
            //Si se realiza un update es con elmismo codigo
            Map<Integer, String> mapa = new TreeMap<Integer, String>();
            mapa.put(12, "Elba");
            mapa.put(13, "Elba");
            mapa.put(711, "Maria");
            mapa.put(9, "Sonia");
            mapa.put(9, "Grettna");

            Set<Integer> keys = mapa.keySet();
            Collection<String> values = mapa.values();
            Set data = mapa.entrySet();

            System.out.println("TreeMap " + keys);
            System.out.println("TreeMap " + values);
            System.out.println("TreeMap " + data);


        }
         {
            //Tiene una llave que identifica al objeto
            //Si se realiza un update es con elmismo codigo
            Map<Integer, String> mapa = new LinkedHashMap<Integer, String>();
            mapa.put(12, "Elba");
            mapa.put(13, "Elba");
            mapa.put(711, "Maria");
            mapa.put(9, "Sonia");
            mapa.put(9, "Grettna");

            Set<Integer> keys = mapa.keySet();
            Collection<String> values = mapa.values();
            Set data = mapa.entrySet();

            System.out.println("LinkedHashMap " + keys);
            System.out.println("LinkedHashMap " + values);
            System.out.println("LinkedHashMap " + data);


        }

                 {
            //Tiene una llave que identifica al objeto
            //Si se realiza un update es con elmismo codigo
            Map<Integer, String> mapa = new Hashtable<Integer, String>();
            mapa.put(12, "Elba");
            mapa.put(13, "Elba");
            mapa.put(711, "Maria");
            mapa.put(9, "Sonia");
            mapa.put(9, "Grettna");

            Set<Integer> keys = mapa.keySet();
            Collection<String> values = mapa.values();
            Set data = mapa.entrySet();

            System.out.println("Hashtable " + keys);
            System.out.println("Hashtable " + values);
            System.out.println("Hashtable " + data);


        }
    }
}
