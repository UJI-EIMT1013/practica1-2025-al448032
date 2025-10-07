package practica1;

import java.sql.Array;
import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos(Iterator<Integer> it) {
        //Me hago una lista para poder recorrerla con el iterador las veces que haga falta
        Set<Integer> resultado = new HashSet<>();
        List<Integer> numeros = new ArrayList<>();

        while (it.hasNext()) {
            numeros.add(it.next());
        }
        //Cojo cada numero y los comparo entre ellos para ver si uno es multiplo del otro
        for (int i = 0; i < numeros.size(); i++) {
            int primero = numeros.get(i);

            for (int j = 0; j < numeros.size(); j++) {
                int segundo = numeros.get(j);

                //Me aseguro de que no tengo en cuenta los 0 y además que no esté comparando el mismo numero entre sí

                if (primero != 0 && segundo != 0 && i != j) {
                    if (primero % segundo == 0) {
                        resultado.add(primero);
                    }

                }
            }
        }
        return resultado;
    }

    //EJERCICIO2
    public static void separate(Set<Integer> cuadrados, Set<Integer> noCuadrados) {
        List<Integer> nuevo = new ArrayList<>();
        nuevo.addAll(cuadrados);
        nuevo.addAll(noCuadrados);

        //Me hago unos conjuntos nuevos para meter provisionalmente los resultados
        Set<Integer> provisionalCuadrados = new HashSet<>();
        Set<Integer> provisionalNoCuadrados = new HashSet<>();
        for (int i = 0; i < nuevo.size(); i++) {
            int numero1 = nuevo.get(i);
            boolean esCuadrado = false;

            for (int j = 0; j < nuevo.size(); j++) {
                int numero2 = nuevo.get(j);

                if (i != j) {
                    if (numero2 * numero2 == numero1) {
                        esCuadrado = true;
                        break;
                    }
                }
            }
            if (esCuadrado) {
                provisionalCuadrados.add(numero1);
            } else {
                provisionalNoCuadrados.add(numero1);

            }
        }
        cuadrados.clear();
        cuadrados.addAll(provisionalCuadrados);
        noCuadrados.clear();
        noCuadrados.addAll(provisionalNoCuadrados);
    }

    //EJERCICIO 3
    public static <T> Collection<Set<T>> divideInSets(Iterator<T> it) {
        Collection<Set<T>> resultado = new ArrayList<>();
        while (it.hasNext()) {
            T elemento = it.next();
            boolean colocado = false;

            //Miro si el elemento ya esta puesto en el conjunto y lo meto

            for (Set<T> conjunto : resultado) {
                if (!conjunto.contains(elemento)) {
                    conjunto.add(elemento);
                    colocado = true;
                    break;
                }
            }
            //Si no está puesto, creo uno nuevo y lo meto
            if (!colocado) {
                Set<T> nuevo = new HashSet<>();
                nuevo.add(elemento);
                resultado.add(nuevo);
            }
        }
        return resultado;

    }

    //EJERCICIO 4
    public static <T> Collection<Set<T>> coverageSet2(Set<T> u, ArrayList<Set<T>> col) {
        Collection<Set<T>> resultado = new HashSet<>();
        //Recorro todos los conjuntos de la lista y los comparo de dos en dos
        for (int i = 0; i < col.size(); i++) {
            Set<T> conjunto1 = col.get(i);

            if (!u.equals(conjunto1)) {
                for (int j = i + 1; j < col.size(); j++) {
                    Set<T> conjunto2 = col.get(j);

                    //Hago la union de los dos conjuntos y los devuelvo
                    if (!u.equals(conjunto2)) {
                        Set<T> union = new HashSet<>(conjunto1);
                        union.addAll(conjunto2);

                        if (union.equals(u)) {
                            resultado.add(conjunto1);
                            resultado.add(conjunto2);
                            return resultado;
                        }
                    }
                }
            }
        }

        return resultado;
    }
}
