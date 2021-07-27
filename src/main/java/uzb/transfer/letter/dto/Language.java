package uzb.transfer.letter.dto;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class Language {
    private String id;
    private String fromCapitalLetter;
    private String fromLetter;
    private String toCapitalLetter;
    private String toLetter;

    public Language(String id, String fromCapitalLetter, String fromLetter, String toCapitalLetter,
        String toLetter) {
        this.id = id;
        this.fromCapitalLetter = fromCapitalLetter;
        this.fromLetter = fromLetter;
        this.toCapitalLetter = toCapitalLetter;
        this.toLetter = toLetter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromCapitalLetter() {
        return fromCapitalLetter;
    }

    public void setFromCapitalLetter(String fromCapitalLetter) {
        this.fromCapitalLetter = fromCapitalLetter;
    }

    public String getFromLetter() {
        return fromLetter;
    }

    public void setFromLetter(String fromLetter) {
        this.fromLetter = fromLetter;
    }

    public String getToCapitalLetter() {
        return toCapitalLetter;
    }

    public void setToCapitalLetter(String toCapitalLetter) {
        this.toCapitalLetter = toCapitalLetter;
    }

    public String getToLetter() {
        return toLetter;
    }

    public void setToLetter(String toLetter) {
        this.toLetter = toLetter;
    }
}
