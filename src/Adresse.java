public abstract class Adresse {
  // Anfang Attribute
  private String Name;
  private String NName;
  private String Strase;
  private int hnummer;
  private String ort;
  private String land;
  private String plz;
  protected String house;
  protected String State;
  // Ende Attribute

  // Anfang Methoden

  public Adresse(String Name, String NName, String Strase, int hnummer, String ort, String land, String plz) {
    this.Name = Name;
    this.NName = NName;
    this.Strase = Strase;
    this.hnummer = hnummer;
    this.ort = ort;
    this.land = land;
    this.plz = plz;
  }

  public abstract void print();

  @Override
  public String toString() {
    return this.Name + ";" + this.NName + ";" + this.Strase + ";" + this.hnummer + ";" + this.ort + ";" + this.plz + ";"
        + this.land + ";" + this.house + ";" + this.State + ";";
  }

  public boolean equals(Adresse a) {
    if (this.Name.equals(a.getName()) && this.Name.equals(a.getName())) {
      return true;
    } else {
      return false;
    }
  }

  public void setName(String NameNeu) {
    Name = NameNeu;
  }

  public void setNName(String NNameNeu) {
    NName = NNameNeu;
  }

  public void setStrase(String StraseNeu) {
    Strase = StraseNeu;
  }

  public void setHnummer(int hnummerNeu) {
    hnummer = hnummerNeu;
  }

  public void setOrt(String ortNeu) {
    ort = ortNeu;
  }

  public void setLand(String landNeu) {
    land = landNeu;
  }

  public String getPlz() {
    return plz;
  }

  public void setPlz(String plzNeu) {
    plz = plzNeu;
  }

  public String getName() {
    return Name;
  }

  public String getLand() {
    return land;
  }

  public String getOrt() {
    return ort;
  }

  public int getHnummer() {
    return hnummer;
  }

  public String getNName() {
    return NName;
  }

  public String getStrase() {
    return Strase;
  }

  public String toFormatedString() {
    return null;
  }

  // Ende Methoden

}