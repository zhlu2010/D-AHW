package growArray;

import java.lang.reflect.Array;

public class DifTypesofArray<E> {

    private E[] a;

    public DifTypesofArray(Class<E> c, int s) {
        // Use Array native method to create array
        // of a type only known at run time
        @SuppressWarnings("unchecked")
        final E[] a = (E[]) Array.newInstance(c, s);
        this.a = a;
    }

    E get(int i) {
        return a[i];
    }
}