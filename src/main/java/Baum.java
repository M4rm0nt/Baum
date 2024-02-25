public class Baum {
    private Knoten wurzel;

    public Baum() {
        wurzel = null;
    }

    public void einfuegen(int wert) {
        wurzel = einfuegenRekursiv(wurzel, wert);
    }

    private Knoten einfuegenRekursiv(Knoten aktuellerKnoten, int wert) {
        if (aktuellerKnoten == null) {
            return new Knoten(wert);
        }

        if (wert < aktuellerKnoten.wert) {
            aktuellerKnoten.links = einfuegenRekursiv(aktuellerKnoten.links, wert);
        } else if (wert > aktuellerKnoten.wert) {
            aktuellerKnoten.rechts = einfuegenRekursiv(aktuellerKnoten.rechts, wert);
        }

        return aktuellerKnoten;
    }

    public boolean suche(int wert) {
        return sucheRekursiv(wurzel, wert);
    }

    private boolean sucheRekursiv(Knoten aktuellerKnoten, int wert) {
        if (aktuellerKnoten == null) {
            return false;
        }
        if (wert == aktuellerKnoten.wert) {
            return true;
        }
        return wert < aktuellerKnoten.wert ? sucheRekursiv(aktuellerKnoten.links, wert) : sucheRekursiv(aktuellerKnoten.rechts, wert);
    }

    public void durchlaufen() {
        durchlaufenInOrder(wurzel);
    }

    private void durchlaufenInOrder(Knoten knoten) {
        if (knoten != null) {
            durchlaufenInOrder(knoten.links);
            System.out.println(knoten.wert);
            durchlaufenInOrder(knoten.rechts);
        }
    }

    public int findeMin() {
        if (wurzel == null) {
            throw new IllegalStateException("Baum ist leer");
        }
        Knoten aktuell = wurzel;
        while (aktuell.links != null) {
            aktuell = aktuell.links;
        }
        return aktuell.wert;
    }

    public int findeMax() {
        if (wurzel == null) {
            throw new IllegalStateException("Baum ist leer");
        }
        Knoten aktuell = wurzel;
        while (aktuell.rechts != null) {
            aktuell = aktuell.rechts;
        }
        return aktuell.wert;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRekursiv(wurzel, sb, 0);
        return sb.toString();
    }

    private void toStringRekursiv(Knoten knoten, StringBuilder sb, int level) {
        if (knoten != null) {
            toStringRekursiv(knoten.rechts, sb, level + 1);
            sb.append(" ".repeat(level * 4)).append(knoten.wert).append("\n");
            toStringRekursiv(knoten.links, sb, level + 1);
        }
    }

    static class Knoten {
        int wert;
        Knoten links, rechts;

        public Knoten(int wert) {
            this.wert = wert;
            this.links = this.rechts = null;
        }
    }
}
