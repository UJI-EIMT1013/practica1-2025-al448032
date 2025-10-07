package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
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
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        //TODO

    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        //TODO
        return null;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        //TODO
        return null;
    }



}
