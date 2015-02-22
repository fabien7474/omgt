package com.hsbcpb.omgt.commons;

import org.apache.commons.collections4.Transformer;;

/**
 * Transformer implementation qui retourne la clé fonctionnelle de l'objet en entrée.
 * 
 */
@SuppressWarnings("rawtypes")
public class FunctionalKeyTransformer implements Transformer {

    /** Singleton predicate instance */
    public static final Transformer INSTANCE = new FunctionalKeyTransformer();

    /**
     * Factory returning the singleton instance.
     * 
     * @return the singleton instance
     */
    public static Transformer getInstance() {
        return INSTANCE;
    }

    /**
     * Constructor
     */
    private FunctionalKeyTransformer() {
        super();
    }

    @Override
    public Object transform(Object input) {
        FunctionalKeyAware fka = (FunctionalKeyAware) input;
        return fka.getFunctionalKey();
    }

}
