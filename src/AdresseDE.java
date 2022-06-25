public class AdresseDE extends Adresse {

  public AdresseDE(String Name, String NName, String Strase, int hnummer, String ort, String land, String plz) {
    super(Name, NName, Strase, hnummer, ort, land, plz);
  }

  @Override
  public void print() {
    System.out.println(getName() + " " + getNName() + " \n" + getStrase() + " " + getHnummer() + " \n" + getPlz() + " "
        + getOrt() + " \n" + getLand());
  }

  public String toFormatedString() {
    return (getName() + " " + getNName() + " \n" + getStrase() + " " + getHnummer() + " \n" + getPlz() + " "
        + getOrt() + " \n" + getLand());
  }

}
