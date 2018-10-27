package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetna;
    private double krajnja;
    private boolean prvaPripada;
    private boolean drugaPripada;

    public Interval(double pocetna, double krajnja, boolean prvaPripada, boolean drugaPripada) {
        if (pocetna > krajnja)
            throw new IllegalArgumentException("Pocetna tacka veca od krajnje!");
            this.pocetna = pocetna;
            this.krajnja = krajnja;
            this.prvaPripada = prvaPripada;
            this.drugaPripada = drugaPripada;
    }
    public Interval() {
        pocetna = 0;
        krajnja = 0;
        prvaPripada = false;
        drugaPripada = false;
    }

    public boolean isNull() {
        if (pocetna == 0 && krajnja == 0 && prvaPripada == false && drugaPripada == false)
            return true;
        return false;
    }
    public boolean isIn(double tacka) {
        if (tacka < pocetna || tacka > krajnja) return false;
        else if (tacka == pocetna && prvaPripada == false) return false;
        else if (tacka == krajnja && drugaPripada == false) return false;
        return true;
    }
    public Interval intersect(Interval i) {
        double vecaPocetna = pocetna;
        if (i.pocetna > vecaPocetna) vecaPocetna = i.pocetna;
        double manjaKrajnja = krajnja;
        if (i.krajnja < manjaKrajnja) manjaKrajnja = i.krajnja;
        boolean prvaNovogPripada = false;
        if (isIn(vecaPocetna) && i.isIn(vecaPocetna)) prvaNovogPripada = true;
        boolean drugaNovogPripada = false;
        if (isIn(manjaKrajnja) && i.isIn(manjaKrajnja)) drugaNovogPripada = true;
        return new Interval(vecaPocetna, manjaKrajnja, prvaNovogPripada, drugaNovogPripada);
    }
    public static Interval intersect(Interval i1, Interval i2) {
        double vecaPocetna = i1.pocetna;
        if (i2.pocetna > vecaPocetna) vecaPocetna = i2.pocetna;
        double manjaKrajnja = i1.krajnja;
        if (i2.krajnja < manjaKrajnja) manjaKrajnja = i2.krajnja;
        boolean prvaNovogPripada = false;
        if (i1.isIn(vecaPocetna) && i2.isIn(vecaPocetna)) prvaNovogPripada = true;
        boolean drugaNovogPripada = false;
        if (i1.isIn(manjaKrajnja) && i2.isIn(manjaKrajnja)) drugaNovogPripada = true;
        return new Interval(vecaPocetna, manjaKrajnja, prvaNovogPripada, drugaNovogPripada);
    }

    @Override
    public String toString() {
        if (isNull()) return "()";
        String novi = "";
        if (prvaPripada) novi += "[";
        else novi += "(";
        novi += pocetna;
        novi += ",";
        novi += krajnja;
        if (drugaPripada) novi += "]";
        else novi += ")";
        return novi;
    }

    @Override
    public boolean equals(Object obj) {
        Interval castovani = (Interval) obj;
        return pocetna == castovani.pocetna && krajnja == castovani.krajnja
                && prvaPripada == castovani.prvaPripada && drugaPripada == castovani.drugaPripada;
    }
}
