import java.util.LinkedList;

public class Main {
    public static int motovaliMotovali(Arbol_N<Integer> alboliko, int queBusco){
        return motovaliMotovali(alboliko,queBusco,1);
    }
    private static int motovaliMotovali(Arbol_N<Integer> alboliko, int queBusco,int nivel){
        if (queBusco == alboliko.getRaiz()) return  nivel;
        int i = 1;
        boolean marisco = false;
        while (i <= alboliko.getNumHijos() && !marisco){
            marisco = alboliko.getHijoN(i).getRaiz() == queBusco;
            ++i;
        }
        if (marisco){
            return ++nivel;
        }
        else {
            i = 1;
            int lvl2 = 0;
            while (i <= alboliko.getNumHijos() && lvl2 == 0){
                lvl2 = motovaliMotovali(alboliko.getHijoN(i),queBusco,(nivel + 1));
                ++i;
            }
            return lvl2;
        }
    }
    public static void main(String[] args) {
        //Nivel 4
        LinkedList<Arbol_N<Integer>> cuatro = new LinkedList<>();
        cuatro.add(new Arbol_N<>(9,new LinkedList<>()));
        //Nivel 3
        Arbol_N<Integer> tres_a = new Arbol_N<>(5,new LinkedList<>());
        Arbol_N<Integer> tres_b = new Arbol_N<>(6,cuatro);
        Arbol_N<Integer> tres_c = new Arbol_N<>(7,new LinkedList<>());
        Arbol_N<Integer> tres_d = new Arbol_N<>(8,new LinkedList<>());
        //Nivel 2
        LinkedList<Arbol_N<Integer>> dosa = new LinkedList<>();
        dosa.add(tres_a);
        dosa.add(tres_b);
        Arbol_N<Integer> dos_a = new Arbol_N<>(2,dosa);
        LinkedList<Arbol_N<Integer>> dosbe = new LinkedList<>();
        dosbe.add(tres_c);
        Arbol_N<Integer> dos_b = new Arbol_N<>(3,dosbe);
        LinkedList<Arbol_N<Integer>> dosce = new LinkedList<>();
        dosce.add(tres_d);
        Arbol_N<Integer> dos_c = new Arbol_N<>(4,dosce);
        //Nivel 1
        LinkedList<Arbol_N<Integer>> ichiban = new LinkedList<>();
        ichiban.add(dos_a);
        ichiban.add(dos_b);
        ichiban.add(dos_c);
        Arbol_N<Integer> arbol = new Arbol_N<>(1,ichiban);

        System.out.println(motovaliMotovali(arbol,7));
    }
}
