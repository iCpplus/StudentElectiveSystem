package entity;

public class Sc {
    private String SId;
    private String CName;
    private String SName;

    public Sc() {
    }

    public Sc(String sId, String cName, String sName) {
        SId = sId;
        CName = cName;
        SName = sName;
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String sId) {
        SId = sId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String cName) {
        CName = cName;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String sName) {
        SName = sName;
    }
    

}