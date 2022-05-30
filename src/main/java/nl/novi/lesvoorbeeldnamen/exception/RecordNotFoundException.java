package nl.novi.lesvoorbeeldnamen.exception;


public class RecordNotFoundException extends RuntimeException{

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    // om een tekst terug te geven moet er hier een constructor gemaakt worden die een message in zich heeft. En om deze
    // consructor te kunnen maken in Spring boot, moet de lege constructor ook worden toegevoegd.

    public RecordNotFoundException(){
        super();
    }

    public RecordNotFoundException(String message){
        super(message);
    }

}
