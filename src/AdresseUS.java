public class AdresseUS extends Adresse {
  public AdresseUS(String Name, String NName, String Strase, int hnummer, String ort, String land, String plz,
      String state) {
    super(Name, NName, Strase, hnummer, ort, land, plz);
    this.State = state;
  }

  @Override
  public void print() {
    System.out.println(getName() + " " + getNName() + " \n" + getHnummer() + " " + getStrase() + " \n" + getOrt() + ", "
        + getState() + " " + getPlz() + " \n" + getLand());
  }

  public String toFormatedString() {
    return (getName() + " " + getNName() + " \n" + getHnummer() + " " + getStrase() + " \n" + getOrt() + ", "
        + getState() + " " + getPlz() + " \n" + getLand());
  }

  public String getState() {
    return State;
  }

}
