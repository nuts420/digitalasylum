package us.digitalasylum.repository.enums;

public enum FeedType {
    RSS1("RSS1"),
    RSS2("RSS2"),
    ATOM("ATOM");

    private final String name;

    private FeedType(String s) {
        name = s;
    }

/*    public String equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }*/

    public String toString(){
        return name;
    }
}
