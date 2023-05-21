public class IntSuchbaum {

    Knoten wurzel = null;

    class Knoten{
        int wert;
        Knoten links, rechts = null;

        Knoten(int wert){
            this.wert = wert;
        }
    }

    IntSuchbaum(){

    }

    public boolean isEmpty(){
        return wurzel == null;
    }

    public void insert(Integer i){
        if(wurzel == null){
            wurzel = new Knoten(i);
            return;
        }else if(i < wurzel.wert){
            insertLinks(i, wurzel);
        }else if(i > wurzel.wert){
            insertRechts(i, wurzel);
        }
    }
    void insert(Integer i, Knoten k){
        if(k.wert == i){
            return;
        } else if (i < k.wert) {
            insertLinks(i, k);
        }else {
            insertRechts(i, k);
        }
    }

    void insertLinks(Integer i, Knoten k){
        if(k.links == null){
            k.links = new Knoten(i);
        } else{
            insert(i, k.links);
        }
    }

    void insertRechts(Integer i, Knoten k){
        if(k.rechts == null){
            k.rechts = new Knoten(i);
        } else{
            insert(i, k.rechts);
        }
    }

    public boolean contains(Integer i){
            return contains(i, wurzel);
    }

    boolean contains(Integer i, Knoten k){
        if(k == null){
            return false;
        } else if(k.wert == i){
            return true;
        } else if (i < k.wert) {
            return contains(i, k.links);
        } else {
            return contains(i, k.rechts);
        }
    }

    public String toString(){
        return toString(wurzel);
    }

    String toString(Knoten k){
            String out = "";
        if(k != null){
            out = "(";
            out += toString(k.links);
            out = out + k.wert;
            out += toString(k.rechts);
            out += ")";
        }

        return out;
    }

    public int hoehe(){
        if(wurzel.links == null & wurzel.rechts == null){
            return 1;
        }else {
            return hoehe(wurzel) - 1;
        }
    }

    int hoehe(Knoten k){
        if(k.links == null & k.rechts == null){
            return 1;
        } else if (k.links == null) {
            return 1 + Math.max(0, hoehe(k.rechts));
        } else if (k.rechts == null) {
            return 1 + Math.max(hoehe(k.links), 0);
        } else{
            return 1 + Math.max(hoehe(k.links), hoehe(k.rechts));
        }
    }

    public int size(){
        return size(wurzel);
    }

    int size(Knoten k){
        if(k.links == null & k.rechts == null){
            return 1;
        }else if(k.links == null){
            return 1 + size(k.rechts);
        } else if (k.rechts == null) {
            return 1 + size(k.links);
        } else{
            return 1 + size(k.links) + size(k.rechts);
        }
    }
}
