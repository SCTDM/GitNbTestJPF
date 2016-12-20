package be.vdab.util;

/**
 *
 * @author simon.chaffart
 */
public enum Geslacht {
    M("man"), V("vrouw");
    
    private final String geslacht;

    private Geslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getGeslacht() {
        return geslacht;
    }
}
